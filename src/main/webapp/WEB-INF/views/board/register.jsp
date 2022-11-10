<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<my:navBar active="register"></my:navBar>
	register.jsp
	
	
	<form action="" method="post">


		title <input type="text" name="title"> <br>
		content <textarea name="content"></textarea> <br>
		writer <input type="text" name="writer"> <br>
		
		<input type="submit" value="등록">
	
	
	</form>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
document.querySelector("#submitButton1").addEventListener("click", function(e) {
	// submit 진행 중지
	e.preventDefault();
	
	// 제목input 입력한 값 가져와서
	// 빈칸만 있는지 확인?
	let titleValue = document.querySelector(`#registerForm1 input[name="title"]`).value
	// 본문 textarea 입력한 값 가져와서
	// 빈칸만 있는지 확인?
	let contentValue = document.querySelector(`#registerForm1 textarea[name="content"]`).value		
	// 작성자 input 값 가져와서
	// 빈칸만 있는지 확인?
	let writerValue = document.querySelector(`#registerForm1 input[name="writer"]`).value
			
	// 위 테스트 다 통과하면 submit
	if (titleValue.trim() != "" 
			&& contentValue.trim() != "" 
			&& writerValue.trim() != "") {
		
		document.querySelector("#registerForm1").submit();
	} else {
		// 적절한 메세지 표시....
	}
	
	
});

</script>
</body>
</html>













