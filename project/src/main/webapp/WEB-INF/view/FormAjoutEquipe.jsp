<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter une equipe </h1>
<form:form method="POST" action="saveEquipe" modelAttribute="equipe">
	<p>Nom : <form:input path="nomEquipe"/></p>
	<p>desc : <form:input path="descriptionEquipe"/></p>
	<input type="submit" value="Ajouter" >
</form:form>
<br>
<c:set var="context" value="${pageContext.request.contextPath}" />
<a href="${context}/">Home</a>
</body>
</html>