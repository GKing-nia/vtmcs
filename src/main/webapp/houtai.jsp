<%--<jsp:useBean id="pid" scope="request" type="java"/>--%>
<%@ page import="com.yourname.www.dao.Dao" %>
<%--
  Created by IntelliJ IDEA.
  User: Gking
  Date: 2021/4/22
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜单</title>
</head>
<%--<%

    String username = req.getParameter("username");
    String password=req.getParameter("password");
    Dao dao=new Dao();
    int pid=dao.searchPid(username,password);
%>--%>
<body>
<a  href="${pid}.jsp">注册菜单</a>
<a  href="2.jsp">学生菜单</a>
<a  href="1.jsp">教师菜单</a>
</body>
</html>