<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<h1>${board.id }번 게시물</h1>
제목 <input type="text"  value="${board.title } " readonly/><br />
본문 <textarea readonly>${board.content }</textarea> <br />
작성자 <input type="text" value="${board.writer}" readonly/> <br />
작성일시 <input type="datetime-local" value="${board.inserted }" readonly>

<c:url value="/board/modify" var="modifyLink">
	<c:param name="id" value="${board.id }"></c:param>
</c:url>
<a class ="btn btn-warning" href="${modifyLink }">수정</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</body>
</html>