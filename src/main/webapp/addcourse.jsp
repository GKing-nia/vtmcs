<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
    <script>
    </script>
</head>
<body background="images/login.jpg">
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<table align="center" border="0px" cellpadding="10px" cellspacing="10px">
    <form action="xuankeServlet?method=addcou"  method="post"  onsubmit="return check()">
        <tr>
            <td style="color: brown"><a href="1.jsp">返回菜单</a></td>
        </tr>
        <tr>
            <td style="color: darkred">课程编号:</td>
            <td><input type="text" name="cpid" id="cpid"></td>
        </tr>
        <tr style="color: darkred">
            <td>课程名称：</td>
            <td><input type="text" name="cname" id="cname"></td>
        </tr>

        <tr style="color: darkred">
            <td>选课人数：</td>
            <td><input type="text" name="num" id="num"></td>
        </tr>
        <tr>

        <tr align="center">
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>