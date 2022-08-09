<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.wifi.find.apisave.dao.HistoryDao" %>
<%@ page import="com.example.wifi.find.apisave.dao.WifiApiDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.find.apisave.dto.WifiInfoDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>와이파이 정보 구하기</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>


<h1>와이파이 정보 구하기</h1>
<br/>
<a href="index.jsp">홈</a>
<a href="history.jsp">위치 히스토리 목록</a>
<a href="load_wifi.jsp">Open API 정보 가져오기</a>
<%
    String lat = request.getParameter("lat") == null ? "0.0" : request.getParameter("lat");
    String lnt = request.getParameter("lnt") == null ? "0.0" : request.getParameter("lnt");
%>
<br/>
<b>LAT:</b>
<input type="text" id="lat" name="lat" size="20" value="<%=lat%>" maxlength="15">
<b> LNT:</b>
<input type="text" id="lnt" name="lnt" size="20" value="<%=lnt%>" maxlength="15">
<button class="button" type="submit" onclick="getMyPos()">내 위치 가져오기</button>
<button class="button" type="submit" onclick="getNearWifiList()">근처 WIFI 정보 보기</button>
<%

    Date today = new Date(); //날짜 시간 받아와서 포맷후 값 저장
    SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
    String datetime = formatter.format(today);

    if (lat != null && lat != null && lat != "0.0" && lnt != "0.0") {  // history 조건
        HistoryDao hdao = new HistoryDao();
        hdao.insertHistory(lat, lnt, datetime);
    }
%>
<table id="customers">
    <thead>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>

        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>

        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>

        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>
    <tbody>
    <%--    근저 Wifi 정보를 보기위해 lat, lnt를 변수로 보냄   --%>
        <%
            List<WifiInfoDto> wlist = new ArrayList<>();
            WifiApiDao wdao = new WifiApiDao();
         if(lat != "0.0" && lnt != "0.0") {
             wlist = wdao.nearWifi(lat, lnt);
    }
        if (wlist.size() == 0) {
        %>
    <tr>
        <td class="null-list" colspan="17"> 위치 정보를 입력학 후에 조회해 주세요.</td>
    </tr>
        <%
    } else {
        for (int i = 0; i < wlist.size(); i++) {
    %>
    <%--   WifiApiDAO 의 nearWifi의 SELECT문을 실행시켜서 출력할 데이터 20개 받아오기    --%>
    <tr class="list"
        onclick="location.href='mark.jsp?lat='+<%= wlist.get(i).getLatX()%> +'&lnt='+ <%= wlist.get(i).getLntY()%>;">
        <td><%= wlist.get(i).getDistance()%>
        </td>
        <td><%= wlist.get(i).getManagementNo()%>
        </td>
        <td><%= wlist.get(i).getBorough()%>
        </td>
        <td><%= wlist.get(i).getWifiName()%>
        </td>
        <td><%= wlist.get(i).getRoadnameAddress()%>
        </td>
        <td><%= wlist.get(i).getDetailName()%>
        </td>
        <td><%= wlist.get(i).getInstallFloor()%>
        </td>
        <td><%= wlist.get(i).getInstallType()%>
        </td>
        <td><%= wlist.get(i).getInstallAgency()%>
        </td>
        <td><%= wlist.get(i).getServiceDivision()%>
        </td>
        <td><%= wlist.get(i).getNetType()%>
        </td>
        <td><%= wlist.get(i).getYearOfInstall()%>
        </td>
        <td><%= wlist.get(i).getDivisionIo()%>
        </td>
        <td><%= wlist.get(i).getConnectEnvironment()%>
        </td>
        <td><%= wlist.get(i).getLatX()%>
        </td>
        <td><%= wlist.get(i).getLntY()%>
        </td>
        <td><%= wlist.get(i).getWorkDate()%>
        </td>
    </tr>
        <%
                }
            }
        %>

</table>
<script>

    let $lat;
    let $lnt;
    window.onload = () => {
        $lat = document.getElementById("lat");
        $lnt = document.getElementById("lnt");
    }
    const getNearWifiList = () => {  //위치를 url 파라미터로 보내기.
        let lat_value = $lat.value;
        let lnt_value = $lnt.value;
        if (lat_value !== "0.0" && lat_value != null && lat_value != undefined && lat_value != ""
            && lnt_value !== "0.0" && lnt_value != null && lnt_value != undefined && lnt_value != "") {
            console.log($lat.value, $lnt.value);
            location = "index.jsp?lat=" + lat_value + "&lnt=" + lnt_value;
        } else {
            alert("좌표를 입력해 주세요.")
        }
    }
    const getMyPos = () => {  //내 위치 가져오기
        if ('geolocation' in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                console.log(position);
                $lat.value = position.coords.latitude;
                $lnt.value = position.coords.longitude;
            }, function (error) {
                console.log(error)
            })
        } else {
            alert("위치정보확인 서비스를 지원하지 않는 브라우저입니다.")
        }
    }

</script>
</body>
</html>