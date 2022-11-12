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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<my:navBar active="memberList"></my:navBar>

	${memberList[0] }<br>	
	-${m }<br>
	
	<div class="container-md">
	
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
			
					<div class="alert alert-success">
						${message }
					</div>
			

				<table class="table">
					<thead>
						<tr>				
							<th>id</th>
							<th>password</th>
							<th>email</th>
							<th>inserted</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="member">	
							<tr>	
							<td><a href="<c:url value="/member/get"/>">${member.id }</a></td>
							<td>${member.password }</td>
							<td>${member.email }</td>	
							<td>${member.inserted }</td>	
							<tr>
						</c:forEach> 
				</tbody>
				</table>
						
<!-- 	?? c:url을 쓰는 이유가 ?context path도 붙여주고 query string도 만들어주고 인코딩도 안해도 되서라는데.. 잘 모르겠음. -->
<!-- 동일 소스로 context path를 자동 포함시키기 위함 입니다. -->
<!-- 예를 들어 로컬은 context path 가 / 이고 -->
<!-- 개발서버는 context path 가 /context 라고 하면 -->
<!-- 로컬에서는 /resources/js/com.js 라고 선언해야 하고 -->
<!-- 개발서버는 /context/resources/js/com.js 로 선언해야겠죠.. -->
<%-- 이때 <c:url>로 감싸게 되면 동적으로 context path 정보를 가져와 앞에 붙혀주게 됩니다.. --%>
<!-- 안쓰게 되면 개발서버에 올릴때마다 소스를 수정해야겠죠.. -->
						
				
<!-- 			</div> -->
<!-- 		 </div> -->
		
		
		
		
		
<!-- 		--------------------paging------------------------------ -->


		
		
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
				<nav class="mt-3" aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  
				  	 				  	<%-- 맨앞 버튼은 1페이지가 아니면 존재함 --%>
				  	<c:if test="${pageInfo.page ne 1 }">
				  		<c:url value="/board/list" var="listLink">
				  			<c:param name="page" value="1" />
				  			<c:param name="q" value="${param.q }" />
				  			<c:param name="t" value="${param.t }"></c:param>
				  		</c:url>
				  		<!-- li.page-item>a.page-link{맨앞버튼} -->
						<li class="page-item">
							<a href="${listLink }" class="page-link">
								<i class="fa-solid fa-angles-left"></i>
							</a>
						</li>
				  	</c:if>
				  	
				  	<c:if test="${pageInfo.hasPrevButton }">
				  		<c:url value="/board/list" var="listLink">
				  			<c:param name="page" value="${pageInfo.jumpPrevPageNumber }"></c:param>
				  			<c:param name="q" value="${param.q }" />
				  			<c:param name="t" value="${param.t }"></c:param>
				  		</c:url>
				  		<li class="page-item">
				  			<a href="${listLink }" class="page-link">
				  				<i class="fa-solid fa-angle-left"></i>
				  			</a>
				  		</li>
				  	</c:if>
				  	
				  
					<!-- 	페이지출력   >>  페이지번호 출력, 요청페이지파람 붙은 링크 걸어줌, 요청페이지와 페이지번호가 같으면 엑티브-->
					<!--컨트롤러가 요청페이지를 페이지인포의 페이지에 담았음 -->
					<!-- 그리고 페이지번호를 클릭하면 그게 요청페이지임.  -->
					 <c:forEach begin="${pageInfo.leftPageNumber}" end ="${pageInfo.rightPageNumber }" var="page">

					 	<c:url value="/board/list" var="listLink">
					 		<c:param name="page" value="${page}"></c:param>  <!-- 페이지번호를 클릭하면 그게 요청페이지  -->
					 		<c:param name="q" value="${param.q }" />
					 		<c:param name="t" value="${param.t }"></c:param>
					 	</c:url>

<%-- 					    <li class="page-item ${pageInfo.page eq page ? 'active' : '' }"><a class="page-link" href="${listLink }">  ${page}  </a> --%>
					    <li class="page-item ${param.page eq page ? 'active' : '' }"><a class="page-link" href="${listLink }">  ${page}  </a>
						<!-- 엑티브설정 -> 페이지번호와 요청페이지가 같아지려면 클릭을 해야함. 클릭하면 하이퍼링크로 요청보내지고 그 순간 같아짐 -->
					    </li>
	
					 </c:forEach>
					 
					 
					 
					 	<c:if test="${pageInfo.hasNextButton }">
				  		<c:url value="/board/list" var="listLink">
				  			<c:param name="page" value="${pageInfo.jumpNextPageNumber }"></c:param>
				  			<c:param name="q" value="${param.q }" />
				  			<c:param name="t" value="${param.t }"></c:param>
				  		</c:url>
				  		<li class="page-item">
				  			<a href="${listLink }" class="page-link">
				  				<i class="fa-solid fa-angle-right"></i>
				  			</a>
				  		</li>
				  	</c:if>
				  	
				  	
				  	<c:if test="${pageInfo.page ne pageInfo.lastPageNumber }">
				  		<c:url value="/board/list" var="listLink">
				  			<c:param value="${pageInfo.lastPageNumber }" name="page" />
				  			<c:param name="q" value="${param.q }" />
				  			<c:param name="t" value="${param.t }"></c:param>
				  		</c:url>
				  		<!-- li.page-item>a.page-link{맨뒤버튼} -->
				  		<li class="page-item">
				  			<a href="${listLink }" class="page-link">
				  				<i class="fa-solid fa-angles-right"></i>
				  			</a>
				  		</li>
				  	</c:if>
				  </ul>
				</nav>
<!-- 			</div> -->
<!-- 		</div> -->
		
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>







