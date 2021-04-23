<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

</head>
<body background="images/logo.jpg">
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<div align="">
    <h1 style="color: black;">课程信息列表</h1>
    <table class="tb">
        <tr>
            <td>&nbsp;&nbsp;课程名称&nbsp;&nbsp;</td>
        </tr>
        <c:forEach items="${cous}" var="item">
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="xuankeServlet?method=chakan&id=${item.id}">${item.cname}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>