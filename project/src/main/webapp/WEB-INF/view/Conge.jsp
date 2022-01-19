<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="context" value="${pageContext.request.contextPath}" />


<h1>Liste des Conges</h1>
<h2>Employe: ${emp.getNomEmpl()} </h2>
<table border="1">
<thead><tr><th>ID</th><th>Date de debut </th><th>Date de fin </th></thead>
<tbody>
<c:forEach items="${listeC}" var="c">
	<tr><td>${c.idConge}</td><td>${c.dateD }</td><td>${c.dateF}</td><sec:authorize access="hasRole('ADMIN')"><td> <a href='deleteConge/${c.idConge}'>supprimer</a></td></sec:authorize></tr>
</c:forEach>
</tbody>
</table>
<sec:authorize access="hasRole('ADMIN')">
<a href='${context}/FormAjoutConge'>ajouter un Congé</a>
            (Only for Admins)

            </sec:authorize>

<br>
<br>
<a href="${context}/">Home</a>
</body>
</html>
