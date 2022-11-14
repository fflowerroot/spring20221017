<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
function m(k,v) {return { k:v }; }  const o=m  ("g","m");   console.log(o); //아래 코드와 다른점이 뭐야 ?
function m2(k,v){return {[k]:v}; }  const o2=m2("g","m");   console.log(o);

</script>
</html>