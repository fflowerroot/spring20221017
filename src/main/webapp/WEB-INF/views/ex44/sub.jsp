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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>json format data 전송</h1>
	<button id="btn1">/ex44/sub01 post 요청 w/ data</button>
	<br>
	<button id="btn2">/ex44/sub02 post 요청 w/ data text/plain</button>
	<br>
	<button id="btn3">/ex44/sub02 post 요청 w/ data application/json</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
const ctx = "${pageContext.request.contextPath}";

document.querySelector("#btn3").addEventListener("click", function() {
	fetch(ctx + "/ex44/sub03", {
		method: "post",
		headers : {
			"Content-Type" : "application/json"
		},
		body : '{"name":"son", "address":"seoul"}'
	});
});

document.querySelector("#btn2").addEventListener("click", function() {
	fetch(ctx + "/ex44/sub02", {
		method: "post",
		body : '{"name":"son", "address":"seoul"}'
	});
});

document.querySelector("#btn1").addEventListener("click", function() {
	fetch(ctx + "/ex44/sub01", {
		method: "post",
		body : '{"name":"son", "address":"seoul"}'
	});
});
</script>
</body>
</html>






