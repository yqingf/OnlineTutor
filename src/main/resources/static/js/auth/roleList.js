/**
 * 角色列表
 */
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        var tbody=$("#tbody");
        $.get("/auth/role/list",function(res){
            if(res.data!=null){
                tbody.empty();


                for (var i = 0; i < res.data.length; i++) {
                    var td=$("<tr><td>"+res.data[i].code+"</td>"
                        +"<td>"+res.data[i].roleName+"</td>"
                        +"<td>"+res.data[i].description+"</td>"
                        +"<td>"+res.data[i].createTime+"</td>"
                        +"<td>"
                        +"<button class='layui-btn layui-btn-xs' onclick='updateRole("+res.data[i].id+")'>编辑</button>"
                        +"<button class='layui-btn layui-btn-danger layui-btn-xs' onclick='delRole("+res.data[i].id+")'>删除</button></td></tr>");
                    tbody.append(td);
                }
            }
        });
    });
});

function updateRole(id) {
    //isNaN是数字返回false
    if(id!=null && !isNaN(id)){
        window.location.href="/auth/updateRole/"+id+"?callback="+getCallback();
    }else{
        layer.alert("请求参数有误，请您稍后再试");
    }
}
function delRole(id) {
    if(null!=id){
        layer.confirm('您确定要删除'+name+'角色吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/auth/delRole",{"id":id},function(data){
                if(data=="ok"){
                    //回调弹框
                    layer.alert("删除成功！",function(){
                        layer.closeAll();
                        //加载load方法
                        load();//自定义
                    });
                }else{
                    layer.alert(data);//弹出错误提示
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

