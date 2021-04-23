<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB2312"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="GB2312">
    <title>维生数课程系统-登录</title>
</head>
<body background="images/login.jpg">

<table align="center" border="0px" cellpadding="10px" cellspacing="10px">
    <form action="xuankeServlet?method=login"  method="post"  onsubmit="return check()">
        <tr>
            <td style="color: darkred">用户名：</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td style="color: darkred">密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr align="center">
            <th colspan="2">
                <input type="submit" value="登录">
            </th>
        </tr>
    </form>

</table>
</body>
</html>

