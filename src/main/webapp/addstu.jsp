<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB2312"
         pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="GB2312">
    <title>添加学生信息</title>
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
<table align="center" border="0px" cellpadding="10px" cellspacing="10px" style="background:royalblue ">
    <form action="xuankeServlet?method=addstu"  method="post"  onsubmit="return check()">
        <tr>
            <td><a href="3.jsp">返回菜单</a></td>
        </tr>
        <tr>
            <td>学号:</td>
            <td><input type="text" name="spid" id="spid"></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="stuname" id="stuname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="sex">
                    <option value="boy">boy</option>
                    <option value="girl">girl</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>班级：</td>
            <td><input type="text" name="banji" id="banji"></td>
        </tr>
        <tr>
            <td>专业：</td>
            <td><input type="text" name="ye" id="ye"></td>
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