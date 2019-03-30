/**start==动态生成验证码**/
//生成随机数
function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

//生成随机颜色RGB分量
function randomColor(min, max) {
    var _r = randomNum(min, max);
    var _g = randomNum(min, max);
    var _b = randomNum(min, max);
    return "rgb(" + _r + "," + _g + "," + _b + ")";
}
//先阻止画布默认点击发生的行为再执行drawPic()方法
document.getElementById("canvas").onclick = function (e) {
    e.preventDefault();
    drawPic();
};
/**绘制验证码图片**/
function drawPic(){
    var canvas=document.getElementById("canvas");
    var width=canvas.width;
    var height=canvas.height;
    var ctx = canvas.getContext('2d');
    ctx.textBaseline = 'bottom';

    /**绘制背景色**/
    ctx.fillStyle = randomColor(180,240); //颜色若太深可能导致看不清
    ctx.fillRect(0,0,width,height);
    /**绘制文字**/

    /*   for(var i=0; i<4; i++){ */
    var txt = $("#yzms").attr("value");
    ctx.fillStyle = randomColor(50,160);  //随机生成字体颜色
    ctx.font = randomNum(20,30)+'px SimHei'; //随机生成字体大小
    var x = 10;
    var y = randomNum(20,30);
    var deg = randomNum(0, 25);
    //修改坐标原点和旋转角度
    ctx.translate(x,y);
    ctx.rotate(deg*Math.PI/180);
    ctx.fillText(txt, 0,0);
    //恢复坐标原点和旋转角度
    ctx.rotate(-deg*Math.PI/180);
    ctx.translate(-x,-y);
    /*    } */
    /* /**绘制干扰线**/
    for(var i=0; i<8; i++){
        ctx.strokeStyle = randomColor(40,180);
        ctx.beginPath();
        ctx.moveTo( randomNum(0,width), randomNum(0,height) );
        ctx.lineTo( randomNum(0,width), randomNum(0,height) );
        ctx.stroke();
    }
}

/**end==动态生成验证码**/