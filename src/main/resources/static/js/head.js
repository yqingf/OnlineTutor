/**
 * 菜单
 * */
//获取路径uri
var pathUri = window.location.href;
console.log("pathUrl:" + pathUri);
$(function () {
    layui.use('element', function () {
        var element = layui.element;
        // 左侧导航区域（可配合layui已有的垂直导航）
        $.get("/auth/user/perms", function (data) {
            if (isLogin(data)) {
                if (data != null) {
                    getMenus(data);
                    element.render('nav');
                } else {
                    layer.alert("权限不足，请联系管理员", function () {
                        //退出
                        window.location.href = "/user/logout";
                    });
                }
            }
        });
    });
})
var getMenus = function (data) {
    //回显选中
    var ul = $('<ul id="nav"></ul>');
    for (var index = 0; index < data.length; index++) {
        // 父级节点
        var node = data[index];
        if (node.type == 0) {
            if (node.parentId == 0) {
                var li = $("<li></li>");
                var a = $("<a href='javascript:;'></a>");
                var i = $("<i class='iconfont'>" + node.icon + "</i>")
                var i1 = $('<i class="iconfont nav_right">&#xe697;</i>');
                var cate = $("<cite>" + node.name + "</cite>");
                a.append(i);
                a.append(cate);
                a.append(i1);
                li.append(a);
                //获取子节点
                var childArray = getParentArray(node.id, data);
                if (childArray.length > 0) {
                    var childUl = $('<ul class="sub-menu"></ul>');
                    for (var x in childArray) {
                        var cli = $("<li></li>");
                        var _a = $('<a _href="' + childArray[x].page + '"></a>');
                        var ci = $('<i class="iconfont">&#xe6a7;</i>');
                        var ccate = $('<cite>' + childArray[x].name + '</cite>');
                        _a.append(ci);
                        _a.append(ccate);
                        cli.append(_a);
                        childUl.append(cli);
                    }
                    li.append(childUl);
                }
                ul.append(li);
            }
        }
    }
    $("#side-nav").append(ul);
}
//根据菜单主键id获取下级菜单
//id：菜单主键id
//arry：菜单数组信息
function getParentArray(id, array) {
    var newArray = new Array();
    for (var x in array) {
        if (array[x].parentId == id)
            newArray.push(array[x]);
    }
    return newArray;
}

function updateUsePwd() {
    layer.open({
        type: 1,
        title: "修改密码",
        fixed: false,
        resize: false,
        shadeClose: true,
        offset: ['100px'],
        area: ["400px", "280px"],
        content: $('#updatePassword')
    });
}
function isLogin(result){
    if(result && result.code && (result.code == 1100 || result.code==1102)){
        layer.alert(result.msg, function () {
            // 退出
            window.location.href = "/user/logout";
        });
    }
    return true;//返回true
}