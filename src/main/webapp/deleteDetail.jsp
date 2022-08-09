<%@ page import="com.example.wifi.find.apisave.dao.HistoryDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<%
    HistoryDao hdao = new HistoryDao();
    String deleteDate = request.getParameter("deleteDate");
    hdao.deleteHistory(deleteDate);
    response.sendRedirect("history.jsp");
%>

</body>
</html>
