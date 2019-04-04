/**
 * 角色授权
 */
$(function () {

    if (flag == "updateRole") {
        // zTree 的参数配置
        var setting = {
            check: {
                enable: true,
                chkboxType: {"Y": "p", "N": "s"}
            },
            data: {
                simpleData: {
                    enable: true,
                    pIdKey: "parentId",
                    idKey: "id",
                    rootPid: 0
                }
            }
        };
        $.fn.zTree.init($("#treeDemo"), setting, permIdList);
    }

    layui.use(['form', 'layer'], function () {
        var form = layui.form;
        var layer = layui.layer;

        //监听提交
        form.on('submit(updateRoleSumbit)', function (data) {
            //获取选中的权限
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getCheckedNodes(true);
            //选中的复选框
            var nodeIds = new Array();
            for (var i = 0; i < nodes.length; i++) {
                nodeIds.push(nodes[i].id);
            }
            //校验是否授权
            var permList = nodeIds.join(",");
            // console.log("permList:"+permList)
            if (permList == null || permList == '') {
                layer.alert("请给该角色添加权限菜单！")
                return false;
            }
            $("#rolePermIds").val(permList);
            $.ajax({
                type: "POST",
                data: $("#updateRoleForm").serialize(),
                url: "/auth/role/update",
                success: function (res) {
                    if (res.code == 200) {
                        layer.msg(res.msg, {
                            icon: 6,//成功的表情
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            load();
                        });
                    } else {
                        layer.msg(res.msg, {
                            icon: 5,//成功的表情
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        });
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



