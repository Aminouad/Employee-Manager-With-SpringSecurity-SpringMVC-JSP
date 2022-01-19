<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Ajouter Employe</h1>




<%--<c:set var="cxt" value="${pageContext.request.contextPath}" /> ${cxt}/--%>

<form:form method="POST" action ="saveEmploye" modelAttribute="emp">
	<p>nomEmpl : <form:input path="nomEmpl"/></p>
	<p>prenomEmpl : <form:input path="prenomEmpl"/></p>
		<p>emailEmpl : <form:input path="emailEmpl"/></p>
		<p>dateNaissanceEmpl : <form:input path="dateNaissanceEmpl"/></p>
	
			<p>équipe : </p>
	
    <form:select path="equipe.idEquipe">
    <form:options items="${liste}" itemValue="idEquipe" itemLabel="nomEquipe" />
       </form:select>
    <br>
	<input type="submit" value="Ajouter" >
</form:form>

<br>
<c:set var="context" value="${pageContext.request.contextPath}" />
<a href="${context}/">Home</a>

</body>
</html>