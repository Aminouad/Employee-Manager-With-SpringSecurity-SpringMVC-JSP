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

<h1>Ajouter Projet</h1>



<%--<c:set var="cxt" value="${pageContext.request.contextPath}" /> ${cxt}/--%>

<form:form method="POST" action ="saveProjet" modelAttribute="p">
	<p>nomPro : <form:input path="nomPro"/></p>
	<p>descriptionPro : <form:input path="descriptionPro"/></p>
		<p>chargeHorairePro : <form:input path="chargeHorairePro"/></p>
		<p>Employe : </p>
	
    <form:select path="employe.id">
    <form:options items="${liste}" itemValue="id" itemLabel="nomEmpl" />
       </form:select>
    <br>
	<input type="submit" value="Ajouter" >
</form:form>
<br>
<c:set var="context" value="${pageContext.request.contextPath}" />
<a href="${context}/">Home</a>
</body>
</html>