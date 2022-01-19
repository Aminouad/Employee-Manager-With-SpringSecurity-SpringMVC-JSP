<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conge</title>
</head>
<body>

<h1>Ajouter un Congé</h1>




<%--<c:set var="cxt" value="${pageContext.request.contextPath}" /> ${cxt}/--%>

<form:form method="POST" action ="saveConge" modelAttribute="c">
	<p>Date Début : <form:input path="dateD"/></p>
	<p>Date Fin : <form:input path="dateF"/></p>
	    <br>
	
<p>Employe : </p>
    <form:select path="empl.id">
    <form:options items="${liste}" itemValue="id" itemLabel="nomEmpl" />
       </form:select>
    
    
	<input type="submit" value="Ajouter" >
</form:form>
<br>
<c:set var="context" value="${pageContext.request.contextPath}" />
<a href="${context}/">Home</a>
</body>
</html>