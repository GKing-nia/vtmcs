<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">

        .leftMenu{
            background-color:#7986CB;
            width:250px;
            height:600px;
            position:relative;
            top:0px;
        }

        .menuParent{
            background-color:#BBDEFB;
        }



    </style>
</head>
<body background="images/login.jpg">

<div class="leftMenu">
    <div class="menu">


        <div class="menuParent">
            <div class="ListTitlePanel">
                <div class="ListTitle">
                    <strong>注册页面</strong>
                    <div class="leftbgbt"></div>
                </div>
            </div>

            <div class="menuList">
                <div><a target="main_right" href="addtea.jsp">教师注册</a></div>
                <div><a target="main_right" href="addstu.jsp">学生注册</a></div>
            </div>
        </div>


    </div>
</div>

<script type="text/javascript">



</script>

</body>
</html>