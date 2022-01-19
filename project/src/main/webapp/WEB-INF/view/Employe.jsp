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

<h1>Liste des employes</h1>
<h2>Equipe: ${equipe.getNomEquipe()} </h2>
<table border="1">
<thead><tr><th>ID</th><th>nom</th><th>email</th><th>date Naissance </th><th>Consulter congés</th></thead>
<tbody>
<c:forEach items="${liste}" var="e">                         
	<tr><td>${e.id}</td><td>${e.nomEmpl}</td><td>${e.emailEmpl}</td><td>${e.dateNaissanceEmpl}</td><td> <a href='Employe/${equipe.getIdEquipe()}/Conge/${e.id}'>liste des Congés</a></td><sec:authorize access="hasRole('ADMIN')"><td> <a href='deleteEmploye/${e.id}'>supprimer</a></td></sec:authorize></tr>
</c:forEach>
</tbody>
</table>
<sec:authorize access="hasRole('ADMIN')">
<a href='${context}/addEmploye'>ajouter employee</a>
            (Only for Admins)

            </sec:authorize>

<br>
<br>
<a href="${context}/">Home</a>
</body>
</html>