<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:28
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
<body>

<div class="leftMenu">
    <div class="menu">


        <div class="menuParent">
            <div class="ListTitlePanel">
                <div class="ListTitle">
                    <strong>学生主页</strong>
                    <div class="leftbgbt"></div>
                </div>
            </div>

            <div class="menuList">
                <div style="color:#6e75a1"><a target="main_right" href="xuankeServlet?method=liulankecheng">选课</a></div>
                <div><a target="main_right" href="updates.jsp">修改个人信息</a></div>
                <div><a target="main_right" href="xuankeServlet?method=liulankecheng1">浏览课程信息</a></div>

            </div>
        </div>


    </div>
</div>

<script type="text/javascript">



</script>

</body>
</html>