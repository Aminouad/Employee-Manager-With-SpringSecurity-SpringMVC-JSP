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

<h1>Ajouter une Tache</h1>




<%--<c:set var="cxt" value="${pageContext.request.contextPath}" /> ${cxt}/--%>

<form:form method="POST" action ="saveTache" modelAttribute="t">
	<p>descriptionTache : <form:input path="descriptionTache"/></p>
	<p>chargeHoraireTache : <form:input path="chargeHoraireTache"/></p>
	<p>prioriteTache : <form:input path="prioriteTache"/></p>
	<p>statusTache : <form:input path="statusTache"/></p>
	<p>dateDebutTache : <form:input path="dateDebutTache"/></p>
		<p>dateFinTache : <form:input path="dateFinTache"/></p>
				<p>Employe : </p>
		
    <form:select path="employe.id">
    <form:options items="${liste}" itemValue="id" itemLabel="nomEmpl" />
       </form:select>
    <br>
    
    		<p>Projet : </p>
    
    <form:select path="projet.idPro">
    <form:options items="${liste1}" itemValue="idPro" itemLabel="nomPro" />
       </form:select>
    
	<input type="submit" value="Ajouter" >
</form:form>
<br>
<c:set var="context" value="${pageContext.request.contextPath}" />
<a href="${context}/">Home</a>
</body>
</html>