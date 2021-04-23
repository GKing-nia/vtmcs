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
    <title>添加教师信息</title>
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
    <form action="xuankeServlet?method=addtea"  method="post"  onsubmit="return check()">
        <tr>
            <td><a href="3.jsp">返回菜单</a></td>
        </tr>
        <tr style="color: darkred">
            <td>教师工号:</td>
            <td><input type="text" name="tpid" id="tpid"></td>
        </tr>
        <tr style="color: darkred">
            <td>教师姓名：</td>
            <td><input type="text" name="teaname" id="teaname"></td>
        </tr>
        <tr style="color: darkred">
            <td>性别</td>
            <td>
                <select name="sex">
                    <option value="男">boy</option>
                    <option value="女">girl</option>
                </select>
            </td>
        </tr>

        <tr style="color: darkred">
            <td>所在学院：</td>
            <td><input type="text" name="txueyuan" id="txueyuan"></td>
        </tr>
        <tr style="color: darkred">
            <td style="color: darkred">职称：</td>
            <td>
                <select name="zhicheng">
                    <option value="教授">professor</option>
                    <option value="副教授">associate professor</option>
                    <option value="讲师">lecture</option>
                    <option value="助教">teaching assistant</option>
                </select>
            </td>
        </tr>

        <tr align="center">
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>