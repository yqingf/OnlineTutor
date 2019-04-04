/**
 * 角色列表
 */
$(function () {
    layui.use('table', function () {
        var table = layui.table;
        var tbody = $("#tbody");
        $.get("/auth/role/list", function (res) {
            if (res.data != null) {
                tbody.empty();
                for (var i = 0; i < res.data.length; i++) {
                    var td = $("<tr><td>" + res.data[i].code + "</td>"
                        + "<td>" + res.data[i].roleName + "</td>"
                        + "<td>" + res.data[i].description + "</td>"
                        + "<td>" + res.data[i].createTime + "</td>"
                        + "<td>"
                        + "<button class='layui-btn layui-btn-xs' onclick='updateRole(" + res.data[i].id + ")'>编辑</button>"
                        + "<button class='layui-btn layui-btn-danger layui-btn-xs' onclick='delRole(" + res.data[i].id + ")'>删除</button></td></tr>");
                    tbody.append(td);
                }
            }
        });
    });
});

function updateRole(id) {
    //isNaN是数字返回false
    if (id != null && !isNaN(id)) {
        window.location.href = "/auth/role/update/" + id/*+"?callback="+getCallback()*/;
    } else {
        layer.alert("请求参数有误，请您稍后再试");
    }
}

function delRole(id) {
    if (null != id) {
        layer.confirm('您确定要删除' + name + '角色吗？', {
            btn: ['确认', '返回'] //按钮
        }, function () {
            $.post("/auth/role/delete", {"roleId": id}, function (res) {
                if (res.code == 200) {
                    //回调弹框
                    layer.msg(res.msg, {
                        icon: 6,//成功的表情
                        time: 1000 //1秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        location.reload();
                    });
                } else {
                    layer.msg(res.msg,{icon: 5});//弹出错误提示
                    return;
                }
            });
        }, function () {
            layer.closeAll();
        });
    }
}

function getCallback() {
    var pathname = window.location.pathname;
    var param = GetQueryString("callback");
    //console.log("pathname:"+pathname);
    //console.log("param:"+param);
    if (param != null && param != "") {
        return param;
    } else {
        return pathname;
    }
}

/**
 * 获取get请求参数
 * @param name
 * @returns
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var search = window.location.search;
    if (search != null && search != "") {
        var r = search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
    }
    return null;
}