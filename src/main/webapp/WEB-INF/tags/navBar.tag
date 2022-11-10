<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="active" %>

<style>
#searchTypeSelect {
	width: auto;
}
</style>


<c:url value="/board/list" var="listLink" />
<c:url value="/board/register" var="registerLink" />

<nav class="navbar navbar-expand-md bg-light">
  <div class="container-md">
    <a class="navbar-brand" href="${listLink }">게시판</a>
<!--     <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--       <span class="navbar-toggler-icon"></span> -->
<!--     </button> -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    
    
<!--     어트리뷰트 active 네임만 디렉티브에서 설정해줬지 값은 없잖아 ?   >> 태그사용한 jsp파일의 태그에서 값 설정해줬음 -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link ${active eq 'list' ? 'active' : '' }" href="${listLink }">목록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${active eq 'register' ? 'active' : '' }" href="${registerLink }">작성</a>
        </li>
      </ul>
      
      
<!--       컨트롤러에 리퀘파람 q 넘겨줘서 검색쿼리날리게 할거임 -->
      <form action="<c:url value="/board/list"  />" class="d-flex" role="search">
      	<select name="t" id="searchTypeSelect" class="form-select">
      		<option value="all">전체</option>
      		<option value="title" ${param.t == 'title' ? 'selected' : '' }>제목</option>
      		<option value="content" ${param.t == 'content' ? 'selected' : '' }>본문</option>
      		<option value="writer" ${param.t == 'writer' ? 'selected' : '' }>작성자</option>
      	</select>
      
		<%--    <input name="q" value="${param.q }" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" > --%>
		<%--    value에 왜 ${param.q } 이걸 적어줬음?  안적어도 차이가 없는데 ?--%>
         <input name="q" value="" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit">
        	<i class="fa-solid fa-magnifying-glass"></i>
        </button>
      </form>
      <br />
    </div>
  </div>
</nav>
      <form action=""><input type="search" /></form>  <br />
      <form action=""> <input type="text" /></form>







