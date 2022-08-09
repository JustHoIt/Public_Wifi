<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title class="title">와이파이 주변지도</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table id="customers">
    <thead>
    <tr>
        <th>와이파이 주변 지도</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <div id="map" style="width:100%;height:500px;"></div>
        </td>
    </tr>
    </tbody>
</table>

</table>
<button class="back_button" onclick="history.back()">이전 페이지로 돌아가기</button>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3f0f13f7d0f3931ce4c3c0d0a0e4ac31"></script>
<script>
    //주소 파라미터를 가져와 저장
    var url_href = window.location.href;
    var url = new URL(url_href);
    var lat = url.searchParams.get("lat");
    var lnt = url.searchParams.get("lnt");

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(lat, lnt), // 지도의 중심좌표(lat, lnt) : 와이파이 위치
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성

    // 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(lat, lnt); //마커가 표시될 위치 (lat, lnt) : 와이파이 위치

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    // 마커가 지도 위에 표시되도록 설정
    marker.setMap(map);

</script>
</body>
</html>