<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <title>Insert title here</title> -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1>새 고객 입력</h1> -->
<!-- <form action=""method="post"> -->
<!-- <!-- <form action=""method="get"> --> -->
<!-- <h2>고객 1</h2> 네임이 넘어감. 모델어트리뷰트 만들 때 네임과 같게 만들면 자동 채워짐. -->
<!-- <input type="text" placeholder="name"  value="s" name="name"/>	<br> -->
<!-- <input type="text" placeholder="name"  value="s" name="contactName"/>	<br> -->
<!-- <input type="text" placeholder="name"  value="s" name="address"/>	<br> -->
<!-- <input type="text" placeholder="name"  value="s" name="city"/>	<br> -->
<!-- <input type="text" placeholder="postalCode"  value="s" name="postalCode"/>	<br> -->
<!-- <input type="text" placeholder="country"  value="s" name="country"/>	<br><br><br> -->
<!-- <!-- <h2>고객 2</h2> --> -->
<!-- <!-- <input type="text" placeholder="name"  value="s" name="name"/>	<br> --> -->
<!-- <!-- <input type="text" placeholder="name"  value="s" name="contactName"/>	<br> --> -->
<!-- <!-- <input type="text" placeholder="name"  value="s" name="address"/>	<br> --> -->
<!-- <!-- <input type="text" placeholder="name"  value="s" name="city"/>	<br> --> -->
<!-- <!-- <input type="text" placeholder="postalCode"  value="s" name="postalCode"/>	<br> --> -->
<!-- <!-- <input type="text" placeholder="country"  value="s" name="country"/>	<br> --> -->

<!-- <input type="submit" /> -->
<!-- </form> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script> -->
<!-- </body> -->
<!-- </html> -->



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
	<c:if test="${not empty message }">
		<div>
			${message }
		</div>
	</c:if>
	<h1>공급자 정보 등록</h1>
	<form action="" method="post">
		<input type="text" name="name" value="Park">
		<br>
		<input type="text" name="contactName" value="ji sung">
		<br>
		<input type="text" name="address" value="gangnam">
		<br>
		<input type="text" name="city" value="seoul">
		<br>
		<input type="text" name="postalCode" value="33333">
		<br>
		<input type="text" name="country" value="Korea">
		<br>
		<input type="text" name="phone" value="010-9999">
		<br>
		<input type="submit" value="등록">
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>














