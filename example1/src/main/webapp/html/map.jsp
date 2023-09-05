<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커에 인포윈도우 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:700px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d80a72caedf25308e96b099114f93b53"></script>
<script>
let lat = '${param.lat }';
let lng = '${param.lng }';
let centerName = '${param.centerName }';
console.log(lat);
console.log(lng);
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(lat, lng); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 마커에 건물명 표시.
var url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=e1%2F68WYAGN37amlOlJpfi6ZewXy%2BDFfyq8b5JLEtBqo%2Ff1I8TosiRh9%2FzwQb8cOLbhWIdCE0wxAXrLB%2BSoUVyw%3D%3D';


var iwContent = '<div style="padding:5px;">${param.centerName.substring(5) } <br>'
	+'<a href="https://map.kakao.com/link/map/${param.centerName },${param.lat },${param.lng }" style="color:blue" target="_blank">큰지도보기</a>'
	+'<a href="https://map.kakao.com/link/to/${param.centerName },${param.lat },${param.lng }" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>
</html>