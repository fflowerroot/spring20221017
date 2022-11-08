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
	<my:navBar></my:navBar>
	
<!-- 	<div class="container-md"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
			
	
				<h1>
					${board.id }번 게시물
					 
<%-- 					<c:url value="/board/modify" var="modifyLink"> --%>
<%-- 						<c:param name="id" value="${board.id }"></c:param> --%>
<%-- 					</c:url> --%>
					<a class="btn btn-warning" href="/board/modify?id=+${board.id  }">
						수정/삭제
<!-- 					<i class="fa-solid fa-pen-to-square"></i> -->
					</a>
				</h1>
			
<!-- 				<div class="mb-3"> -->
<!-- 					<label class="form-label"> -->
						제목 
<!-- 					</label> -->
<%-- 					<input class="form-control" type="text" value="${board.title }" readonly> --%>
						<input class="form-control"type="text" value= "${board.title }" readonly/> <br />
						
<!-- 				</div>	 -->
				
<!-- 				<div class="mb-3"> -->
<!-- 					<label for="" class="form-label"> -->
					본문 
<!-- 					</label> -->
<%-- 					<textarea rows="5" class="form-control" readonly>${board.content }</textarea> --%>
					<textarea  readonly>${board.content }</textarea><br />
					
<!-- 				</div> -->
				
<!-- 				<div class="mb-3"> -->
<!-- 					<label for="" class="form-label"> -->
						작성자 
<!-- 					</label> -->
<%-- 					<input class="form-control" type="text" value="${board.writer }" readonly> --%>
					<input type="text" value="${board.writer }" readonly> <br />
<!-- 				</div> -->
				
<!-- 				<div class="mb-3"> -->
<!-- 					<label for="" class="form-label"> -->
						작성일시 
<!-- 					</label> -->
					<input type="datetime-local" value="${board.inserted }" readonly> <br />
					작성일시 <input type="text" value="${board.inserted }" readonly>
<%-- 					<input class="form-control" type="datetime-local" value="${board.inserted }" readonly> --%>
<!-- 				</div> -->
	
	
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<hr>
	
	<div id="replyMessage1">
	</div>
	
<!-- 	<div class="container-md"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
				<input type="hidden" id="boardId" value="${board.id }">
				<input type="text" id="replyInput1">
				<button id="replySendButton1">댓글쓰기</button>
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div class="row">
			<div class="col">
				<div id="replyListContainer">
				
				</div>
			</div>
		</div>
<!-- 	</div> -->
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
const ctx = "${pageContext.request.contextPath}";

listReply();

function listReply() {
	const boardId = document.querySelector("#boardId").value;
	fetch(`\${ctx}/reply/list/\${boardId}`)
	.then(res => res.json())
	.then(list => {
		const replyListContainer = document.querySelector("#replyListContainer");
		replyListContainer.innerHTML = "";
		
		for (const item of list) {
			
			const removeReplyButtonId = `removeReplyButton\${item.id}`;
			// console.log(item.id);
			const replyDiv = `
				<div>
					\${item.content} : \${item.inserted}
					<button data-reply-id="\${item.id}" id="\${removeReplyButtonId}">삭제</button>
				</div>`;
			replyListContainer.insertAdjacentHTML("beforeend", replyDiv);
			document.querySelector("#" + removeReplyButtonId)
				.addEventListener("click", function() {
					// console.log(this.id + "번 삭제버튼 클릭됨");
					console.log(this.dataset.replyId + "번 댓글 삭제할 예정")
					// removeReply(this.dataset.replyId);
				});
		}
	});
}

document.querySelector("#replySendButton1").addEventListener("click", function() {
	const boardId = document.querySelector("#boardId").value;
	const content = document.querySelector("#replyInput1").value;
	
	const data = {
		boardId,
		content
	};
	
	fetch(`\${ctx}/reply/add`, {
		method : "post",
		headers : {
			"Content-Type" : "application/json"
		},
		body : JSON.stringify(data)
	})
	.then(res => res.json())
	.then(data => {
		document.querySelector("#replyInput1").value = "";  
		document.querySelector("#replyMessage1").innerText = data.message;
	})
	.then(() => listReply());
});

</script>
</body>
</html>









