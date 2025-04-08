<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<form action="main.do" method="post">
		<input id="lat" name="lat" placeholder="LAT">
		<input id="lnt" name="lnt" placeholder="LnT">
		<input type="submit" value="내 위치값 입력" >
	</form>
</body>
</html>