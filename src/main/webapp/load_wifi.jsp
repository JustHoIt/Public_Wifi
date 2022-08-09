<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("EUC-KR");%>
<%@ page import="com.example.wifi.find.test.ApiControl" %>
<%@ page import="com.example.wifi.find.apisave.WifiApiJson" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>불러오기 성공</title>
</head>
<body>
<%
    ApiControl api = new ApiControl();
    api.load();
    WifiApiJson waj = new WifiApiJson();
    int listcnt2 = waj.TotalCNT();
%>
<%--API 데이터수를 받아와서 출력--%>
<h1><%=listcnt2%>개의 WIFI정보를 정상적으로 저장하였습니다.</h1>
<a href="index.jsp">홈으로 돌아가기</a>

</body>
</html>
