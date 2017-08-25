<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="images/tx.ico" rel="shortcut icon" type="image/x-icon">
<title>404错误</title>
<style type="text/css">
* {margin:0px;padding:0px;list-style:none;text-decoration:none;}
body {background:url(images/b1.jpg)}
.mian {width:1000px;height:600px;background:url(images/back.jpg);margin:3% auto}
.error_div {width:210px;float:right;margin-right:28%;margin-top:38%;font-family:"微软雅黑"}
.error_div a {float:left;color:#FFFBF0;width:80px;background:#8A532A;text-align:center;line-height:20px;font-size:15px;border-bottom:3px solid #683F20}
.error_div a:hover {background:#7B4A26;}
.info {float:right;line-height:20px;color:#000}
</style>
<script type="text/javascript">
	    var InterValObj; //timer变量，控制时间
	    var count=5;
	    var curCount;
    
	    function SetRemainTime() {
           if (curCount == 0) {
               window.clearInterval(InterValObj);//停止计时器
               window.setTimeout("window.location='#'",0); 
           }
           else {
               curCount--;
               document.getElementById("redirect_info").innerHTML=(curCount+"秒后返回首页");
           }
	    }
    </script>
</head>
<body>
<div class="mian">
	<div class="error_div">
        <a href="#">返回首页</a>
        <p id="redirect_info" class="info">5秒后返回首页</p>
        <script type="text/javascript">
            curCount=count;
            InterValObj = window.setInterval(SetRemainTime, 1000);
        </script>
    </div>
</div>
</body>
</html>