/**
 * 判断是否登录，没登录刷新当前页，促使Shiro拦截后跳转登录页
 * @param result	ajax请求返回的值
 * @returns {如果没登录，刷新当前页}
 */
function isLogin(result){
    if(result && result.code && (result.code == 1100 || result.code==1102)){
        location.replace(location.href);//刷新当前页
    }
    return true;//返回true
}

/**
 * 获取get请求参数
 * @param name
 * @returns
 */
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var search=window.location.search;
    if(search!=null && search!=""){
        var r = search.substr(1).match(reg);
        if(r!=null){
            return  unescape(r[2]);
        }
    }
    return null;
}
/**
 * 获取菜单uri
 * @returns
 */
function getCallback(){
    var pathname = window.location.pathname;
    var param=GetQueryString("callback");
    //console.log("pathname:"+pathname);
    //console.log("param:"+param);
    if(param!=null && param != ""){
        return param;
    }else{
        return pathname;
    }
}
/**
 * 针对不同的错误可结合业务自定义处理方式
 * @param result
 * @returns {Boolean}
 */
function isError(result){
    var flag=true;
    if(result && result.code){
        flag=false;
        if(result.code == '-1' || result.code=='-101' || result.code=='400' || result.code=='404' || result.code=='500'){
            layer.alert(result.msg);
        }else if(result.code=='403'){
            layer.alert(result.msg,function(){
                //跳转到未授权界面
                window.location.href="/403";
            });
        }
    }
    return flag;//返回true
}