<%@ page import="com.example.wifi.find.apisave.dto.HistoryDto" %>
<%@ page import="com.example.wifi.find.apisave.dao.HistoryDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>와이파이 정보 구하기</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1 class="title">와이파이 정보 구하기</h1>
<br/>
<a href="index.jsp">홈</a>
<a href="history.jsp">위치 히스토리 목록</a>
<br/>
<%-- 데이터베이스에 history 저장 내역을 SELECT해 옴--%>
<%
    List<HistoryDto> hlist = new ArrayList<>();
    HistoryDao hdao = new HistoryDao();
    hlist = hdao.selecthistory();
%>

<table id="customers">
    <thead>
    <tr>
        <th>ID</th>
        <th>LAT 좌표</th>
        <th>LNT 좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (hlist.size() == 0) {
    %>
    <tr class="null-list">
        <td colspan="5">저장된 히스토리 내역이 없습니다..</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < hlist.size(); i++) {
    %>
    <%--    history의 SELECT문을 실행시켜서 검색한(저장된) 데이터 받아오기    --%>
    <tr class="list"
        onclick="location.href='mark.jsp?lat='+<%= hlist.get(i).getSearchLatx()%> +'&lnt='+ <%= hlist.get(i).getSearchLnty()%>;">

        <td><%= i + 1 %>
        </td>
        <td><%= hlist.get(i).getSearchLatx()%>
        </td>
        <td><%= hlist.get(i).getSearchLnty()%>
        </td>
        <td><%= hlist.get(i).getSearchTime()%>
        </td>
<%--        버튼 td 칸에선 실행 안되게 선언 , x버튼 누를시 해 당 데이터를 삭제 (function)  --%>
        <td onclick="event.cancelBubble=true">
            <button type="button" id="<%=hlist.get(i).getSearchTime() %>" onclick="deletewifi(this)"> X
            </button>
        </td>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>
<script>
    function deletewifi(e) {
        const deleteDate = e.id;
        location.href = "http://localhost:8080/deleteDetail.jsp?deleteDate=" + deleteDate;
    }
</script>
</body>
</html>