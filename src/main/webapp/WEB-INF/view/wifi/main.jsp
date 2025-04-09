<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
		<input id="lat" name="lat" placeholder="LAT">
		<input id="lnt" name="lnt" placeholder="LnT">
		<button id="xy" name="xy">내 위치 입력</button>

	<table border="1">
		
	</table>
</body>
<script type="text/javascript">
var contextPath = '<%= request.getContextPath() %>';
$('#xy').on('click',function(){
	var lat = $('#lat').val();
	var lnt = $('#lnt').val();
	$.ajax({
		type : 'post',
		url: contextPath + '/List',
		data:{
			lat : lat,
			lnt : lnt 
		},
		success: function(data){
			code="<table border='1'>"
			code+="<tr><th>거리</th><th>관리번호</th><th>자치구</th><th>와이파이명</th><th>도로명주소</th><th>상세주소</th><th>설치위치(층)</th><th>설치유형</th><th>설치기관</th><th>서비스구분</th><th>망종류</th><th>설치년도</th><th>실내외구분</th><th>wifi접속환경</th><th>Y좌표</th><th>X좌표</th><th>작업일자</th></tr>"

				data.forEach(function(wifi){
					   code += "<tr>";
					   code += "<td>" + wifi.DISTANCE_KM +"KM"+ "</td>";
					   code += "<td>" + wifi.X_SWIFI_MGR_NO + "</td>";
					   code += "<td>" + wifi.X_SWIFI_WRDOFC + "</td>";
					   code += "<td>" + wifi.X_SWIFI_MAIN_NM + "</td>";
					   code += "<td>" + wifi.X_SWIFI_ADRES1 + "</td>";
					   code += "<td>" + wifi.X_SWIFI_ADRES2 + "</td>";
					   code += "<td>" + wifi.X_SWIFI_INSTL_FLOOR + "</td>";
					   code += "<td>" + wifi.X_SWIFI_INSTL_TY + "</td>";
					   code += "<td>" + wifi.X_SWIFI_INSTL_MBY + "</td>";
					   code += "<td>" + wifi.X_SWIFI_SVC_SE + "</td>";
					   code += "<td>" + wifi.X_SWIFI_CMCWR + "</td>";
					   code += "<td>" + wifi.X_SWIFI_CNSTC_YEAR + "</td>";
					   code += "<td>" + wifi.X_SWIFI_INOUT_DOOR + "</td>";
					   code += "<td>" + wifi.X_SWIFI_REMARS3 + "</td>";
					   code += "<td>" + wifi.LAT + "</td>";
					   code += "<td>" + wifi.LNT + "</td>";
					   code += "<td>" + wifi.WORK_DTTM + "</td>";
					   code += "</tr>";
					});
					code += "</table>";
					$('table').html(code);

		},
		error:function(request,status,error){       
					 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); 
		}
	})
})
</script>
</html>