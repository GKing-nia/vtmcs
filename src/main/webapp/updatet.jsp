<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改教师信息</title>
    <script>
    </script>
</head>
<body>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<table align="center" border="0px" cellpadding="10px" cellspacing="10px">
    <form action="xuankeServlet?method=updatetea"  method="post"  onsubmit="return check()">
        <tr>
            <td><a href="1.jsp">返回菜单</a></td>
        </tr>

        <tr>
            <td>教师姓名：</td>
            <td><input type="text" name="teaname" id="teaname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="sex">
                    <option value="男">Boy</option>
                    <option value="女">Girl</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>教师所在学院：</td>
            <td><input type="text" name="txueyuan" id="txueyuan"></td>
        </tr>
        <tr>
            <td>职称：</td>
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