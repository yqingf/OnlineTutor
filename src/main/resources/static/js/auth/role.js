/**
 * 更新角色
 */
//选中的复选框
var nodeIds = [];
$(function () {

    layui.use(['form', 'tree', 'layer'], function () {
        var form = layui.form;
        var layer = layui.layer;

        //监听提交
        getTreeData();

        form.on('submit(roleSubmit)', function (data) {
            //校验 TODO
            var array = new Array();
            //获取选中的权限id
            var checked = $(".layui-form-checked");
            checked.each(function () {
                array.push($(this).parent(".layui-xtree-item").find("input").val())
            });
            //校验是否授权
            var permIds = array.join(",");
            console.log("permIds" + permIds);
            if (permIds == null || permIds == '') {
                layer.alert("请给该角色添加权限菜单！")
                return false;
            }
            $("#permIds").val(permIds);

            $.ajax({
                type: "POST",
                data: $("#roleForm").serialize(),
                url: "/auth/role/add",
                success: function (res) {
                    if (res.code == 200) {
                        // layer.alert(res.msg, function () {
                        //     layer.closeAll();
                        //
                        // });
                        layer.msg(res.msg, {
                            icon: 6,//成功的表情
                            time: 1000 //1秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            load();
                        });
                    } else {
                        layer.alert(res.msg);
                    }
                },
                error: function (res) {
                    layer.alert(res.msg);
                }
            });
            return false;
        });
        form.render();
    });

});

function getTreeData() {
    $.ajax({
        type: "GET",
        url: "/auth/permission/list",
        success: function (data) {
            if (data != null) {
                initTree(data);
            } else {
                layer.alert(data);
            }
        },
        error: function () {
            layer.alert("获取数据错误，请您稍后再试");
        }
    });
}

function initTree(data) {
    layui.use(['form'], function () {
        var form = layui.form;
        var xtree = new layuiXtree({
            elem: 'perm'   //(必填) 放置xtree的容器，样式参照 .xtree_contianer
            , form: form     //(必填) layui 的 from
            , data: listToTreeJson(data)     //(必填) json数据
        });
    });
}

/**
 * 获取所有子节点的id数组
 * @param obj
 * @returns {Array}
 */
function getChildNode(obj) {
    if (obj != null) {
        if (obj.children.length > 0) {
            $.each(obj.children, function (k, v) {
                //console.log( v.id );
                nodeIds.push(v.id);
                getChildNode(v);
            });
        }
    }
    return nodeIds;
}

var demoData = [
    {"id": "aaa", "pid": "account", "spType": 0, "layerId": 0, "seqId": 1, "name": "阿萨德发多少", "deleted": "0"},
    {"id": "account", "pid": "", "spType": 0, "layerId": 0, "seqId": 50, "name": "账户", "deleted": "0"},
    {"id": "bbb", "pid": "account", "spType": 0, "layerId": 0, "seqId": 2, "name": "阿萨德发多少", "deleted": "0"},
    {"id": "ccc", "pid": "account", "spType": 0, "layerId": 0, "seqId": 3, "name": "a啊都是发", "deleted": "0"},
    {"id": "ddd", "pid": "dispatch", "spType": 0, "layerId": 0, "seqId": 1, "name": "大夫", "deleted": "0"},
    {"id": "dispatch", "pid": "", "spType": 0, "layerId": 0, "seqId": 2, "name": "通知公告", "deleted": "0"},
    {"id": "eee", "pid": "dispatch", "spType": 0, "layerId": 0, "seqId": 2, "name": "；卡萨丁", "deleted": "0"},
    {"id": "fff", "pid": "gridding", "spType": 0, "layerId": 0, "seqId": 1, "name": "拉收到了", "deleted": "0"},
    {"id": "gridding", "pid": "", "spType": 0, "layerId": 0, "seqId": 1, "name": "网格化管理", "deleted": "0"},
    {"id": "portals", "pid": "", "spType": 0, "layerId": 0, "seqId": 3, "name": "综合信息门户管理", "deleted": "0"}
];
var json = [
    {
        title: "节点1", value: "jd1", data: [
            {title: "节点1.1", checked: true, disabled: true, value: "jd1.1", data: []}
            , {title: "节点1.2", value: "jd1.2", checked: true, data: []}
            , {title: "节点1.3", value: "jd1.3", disabled: true, data: []}
            , {title: "节点1.4", value: "jd1.4", data: []}
        ]
    }
    , {
        title: "节点2", value: "jd2", data: [
            {title: "节点2.1", value: "jd2.1", data: []}
            , {title: "节点2.2", value: "jd2.2", data: []}
            , {title: "节点2.3", value: "jd2.3", data: []}
            , {title: "节点2.4", value: "jd2.4", data: []}
        ]
    }
    , {title: "节点3", value: "jd3", data: []}
    , {title: "节点4", value: "jd4", data: []}
];

/**
 * list转化为tree结构的json数据
 */
function listToTreeJson(data) {
    //data不能为null，且是数组
    if (data != null && (data instanceof Array)) {
        //递归转化
        var getJsonTree = function (data, parentId) {
            var itemArr = [];
            for (var i = 0; i < data.length; i++) {
                var node = data[i];
                if (node.parentId == parentId && parentId != null) {
                    /*var newNode = {
                        name: node.name,
                        check: 'checkbox',
                        spread: true,
                        id: node.id,
                        pid: node.parentId,
                        children: getJsonTree(data, node.id)
                    };*/
                    var newNode = {
                        title: node.name,
                        value: node.id,
                        data: getJsonTree(data, node.id)
                    };
                    itemArr.push(newNode);
                }
            }
            return itemArr;
        }
        return getJsonTree(data, 0);
    }
}
