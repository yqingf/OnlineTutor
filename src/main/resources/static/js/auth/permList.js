/**
 * 权限列表
 */
$(function () {
    //初始化treegrid 页面表格
    layui.config({
        base: '../../treegrid/'
    }).use(['laytpl', 'treegrid'], function () {
        var laytpl = layui.laytpl,
            treegrid = layui.treegrid;
        treegrid.config.render = function (viewid, data) {
            var view = document.getElementById(viewid).innerHTML;
            return laytpl(view).render(data) || '';
        };

        var treeForm = treegrid.createNew({
            elem: 'permTable',
            view: 'view',
            data: {rows: permList},
            parentid: 'parentId',
            singleSelect: false
        });
        treeForm.build();
    });
    //操作
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(permSubmit)', function (data) {
            //校验 TODO
            $.ajax({
                type: "POST",
                data: $("#permForm").serialize(),
                url: "/auth/permission/update",
                success: function (res) {
                    if (res.code == 200) {
                        layer.alert(res.msg, function () {
                            layer.closeAll();
                        });
                    } else {
                        layer.alert(res.msg);
                    }
                },
                error: function (res) {
                    layer.alert("操作请求错误，请您稍后再试");
                }
            });
            return false;
        });
        form.render();
    });

});

function edit(id, type) {
    if (null != id) {
        $("#type").val(type);
        $("#id").val(id);
        $.get("/auth/permission/detail", {"permId": id}, function (data) {
            // console.log(data);
            if (null != data.data) {
                $("input[name='name']").val(data.data.name);
                $("input[name='code']").val(data.data.code);
                $("input[name='page']").val(data.data.page);
                $("input[name='zindex']").val(data.data.zindex);
                $("textarea[name='description']").text(data.data.description);
                $("#parentId").val(data.data.parentId);
                data.data.type == 0 ? $("input[name='type']").val(0).checked : $("input[name='type']").val(1).checked;
                layer.open({
                    type: 1,
                    title: "更新权限",
                    fixed: false,
                    resize: false,
                    shadeClose: true,
                    area: [($(window).width() * 0.7) + 'px', ($(window).height() - 50) + 'px'],
                    content: $('#updatePerm'),
                    end: function () {
                        location.reload();
                    }
                });
            } else {
                layer.alert("获取权限数据出错，请您稍后再试");
            }
        });
    }
}

//开通权限
function addPerm(pid, flag) {
    /*if (null != pid) {
        //flag[0:开通权限；1：新增子节点权限]
        //type[0:编辑；1：新增]
        if (flag == 0) {
            // $("#type").val(1);
            $("#parentId").val(0);
        } else {
            //设置父id
            // $("#type").val(1);
            $("#parentId").val(pid);
        }
        layer.open({
            type: 1,
            title: "添加权限",
            fixed: false,
            resize: false,
            shadeClose: false,
            area: [($(window).width() * 0.7) + 'px', ($(window).height() - 50) + 'px'],
            content: $('#updatePerm'),  //页面自定义的div，样式自定义
            end: function () {
                location.reload();
            }
        });
    }*/
    $("#parentId").val(pid);
    if (flag == 0) {
        $("#parentId").val(0);
    }
    x_admin_show("添加权限", "/auth/permission/add.html/"+$("#parentId").val());
}

function del(id, name) {
    // console.log("===删除id："+id);
    if (null != id) {
        layer.confirm('您确定要删除' + name + '权限吗？', {
            btn: ['确认', '返回'] //按钮
        }, function () {
            $.post("/auth/delete/perm", {"permId": id}, function (res) {
                if (res.code == 200) {
                    //回调弹框
                    layer.alert(res.msg, function () {
                        layer.closeAll();
                        //加载load方法
                        location.reload();//自定义
                    });
                } else {
                    layer.alert(res.msg);//弹出错误提示
                }
            });
        }, function () {
            layer.closeAll();
        });
    }

}
//关闭弹框
function close() {
    layer.closeAll();
}