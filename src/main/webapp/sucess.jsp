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
    <title></title>
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
    <tr>
        <td  style="color: darkred;size:60px"><a href="xuankeServlet?method=liulankecheng" style="color: darkred;size:600px">选课成功！请点击返回选课</a></td>
    </tr>
</table>
</body>
</html>