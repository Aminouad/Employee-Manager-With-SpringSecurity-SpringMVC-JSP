<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Projets</title>
</head>

<body>

<c:set var="context" value="${pageContext.request.contextPath}" />

	<h2>Projets</h2>
	<hr>
	
	<p>Voici la liste des projets </p>

	<hr>
	   <!-- display user name and role -->
	
	<p> User: <sec:authentication property="principal.username" />
	<br><br>
	 
	 Role(s): <sec:authentication property="principal.authorities" />
	</p>
      
      
      
     
      
       <hr>
       
     
       
      
       
        <h1>Liste des Projets</h1>
<table border="1">
<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>chargeHoraire</th><th>Employé</th></thead>
<tbody>
<c:forEach items="${liste1}" var="k">
	<tr><td>${k.idPro }</td><td>${k.nomPro}</td><td>${k.descriptionPro}</td><td>${k.chargeHorairePro}</td><td>${(k.employe).getNomEmpl()}</td><sec:authorize access="hasRole('ADMIN')"><td> <a href='Projets/deleteProjet/${k.idPro}'>supprimer</a></td> </sec:authorize></tr>
</c:forEach>
</tbody>
</table>

 <hr>
       
   <!-- logout Button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
   </form:form>

	<sec:authorize access="hasRole('ADMIN')">

		<!--  add link to / admin -->
		<p>
			<br> <a
				href="${pageContext.request.contextPath}/FormAjoutProjet">Ajouter
				un Projet </a> <br> (Only for Admins)

		</p>
	</sec:authorize>
   <a href="${context}/">Home</a>
   

</body>

</html>