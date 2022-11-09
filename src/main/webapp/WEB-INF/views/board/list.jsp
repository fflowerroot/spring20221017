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
	<my:navBar active="list"></my:navBar>

	
	
	<div class="container-md">
	
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
			

				<c:if test="${not empty message }">
					<div class="alert alert-success">
						${message }
					</div>
				</c:if>
				
			 list.jsp
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>title</th>
							<th>writer</th>
							<th>inserted</th>
						</tr>
					</thead>
					<tbody>
			
				
						
						<c:forEach items="${boardList}" var="board">
										
						
<!-- 	?? c:url을 쓰는 이유가 ?context path도 붙여주고 query string도 만들어주고 인코딩도 안해도 되서라는데.. 잘 모르겠음. -->
<!-- 동일 소스로 context path를 자동 포함시키기 위함 입니다. -->
<!-- 예를 들어 로컬은 context path 가 / 이고 -->
<!-- 개발서버는 context path 가 /context 라고 하면 -->
<!-- 로컬에서는 /resources/js/com.js 라고 선언해야 하고 -->
<!-- 개발서버는 /context/resources/js/com.js 로 선언해야겠죠.. -->
<%-- 이때 <c:url>로 감싸게 되면 동적으로 context path 정보를 가져와 앞에 붙혀주게 됩니다.. --%>
<!-- 안쓰게 되면 개발서버에 올릴때마다 소스를 수정해야겠죠.. -->
						
						
						
							<tr>
								<td>${board.id }</td>
								<td><a href="<c:url value= "/board/get?id=${board.id }"/>">${board.title }</a></td>
								<td><a href="/board/get?id=${board.id }">${board.writer }</a></td>
								<td>
								<c:url value="/board/get" var="getLink">      
								<c:param name="id" value="${board.id }"></c:param>
								</c:url>
								<a href="${getLink }">${board.inserted }</a></td>
<!-- 								? ? 페이지소스보기해서 봤을 때 context path  안붙어있는데 ? 선생님 거 복붙해도 안붙음/ 그런데 선생님 파일 실행하면 붙어있음... -->
		
							</tr>
						</c:forEach> 
					</tbody>
				</table>
<!-- 			</div> -->
<!-- 		 </div> -->
		
		
		
		
		
<!-- 		--------------------paging------------------------------ -->


		
		
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
				<nav class="mt-3" aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  
				  	 				  	<%-- 맨앞 버튼은 1페이지가 아니면 존재함 --%>
				  	<c:if test="${pageInfo.currentPageNumber ne 1 }">
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
				  	
					 <c:forEach begin="${pageInfo.leftPageNumber}" end ="${pageInfo.rightPageNumber }" var="pageNumber">

					 	<c:url value="/board/list" var="listLink">
					 		<c:param name="page" value="${pageNumber}"></c:param>
					 		<c:param name="t" value="${param.t }"></c:param>
					 	</c:url>

					    <li class="page-item ${pageInfo.currentPageNumber eq pageNumber ? 'active' : '' }"><a class="page-link" href="${listLink }">  ${pageNumber}  </a>
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
				  	
				  	
				  	<c:if test="${pageInfo.currentPageNumber ne pageInfo.lastPageNumber }">
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







