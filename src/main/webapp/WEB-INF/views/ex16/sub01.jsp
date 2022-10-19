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
myName : ${myName } <br />
address : ${address }<br />

myName : ${pageScope.myName } <br />
myName : ${requestScope.myName } <br />
myName : ${sessionScope.myName } <br />
myName : ${applicationScope.myName } <br />
//이거 Scope는 어떤 api?


org.springframework.beans.factory.config
Interface Scope
All Known Implementing Classes:
AbstractRequestAttributesScope, RequestScope, ServletContextScope, SessionScope, SimpleThreadScope, SimpleTransactionScope, SimpSessionScope



org.springframework.web.context.request
Class RequestScope
java.lang.Object
org.springframework.web.context.request.AbstractRequestAttributesScope
org.springframework.web.context.request.RequestScope
All Implemented Interfaces:
Scope

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</body>
</html>