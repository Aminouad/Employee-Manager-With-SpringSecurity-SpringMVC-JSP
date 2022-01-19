<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Accueil</title>
</head>

<body>
	<h2>Accueil</h2>
	<hr>
	
	<p>Bienvenue dans la plateforme </p>

	<hr>
	   <!-- display user name and role -->
	
	<p> User: <sec:authentication property="principal.username" />
	<br><br>
	 
	 Role(s): <sec:authentication property="principal.authorities" />
	</p>
      
      
      
      
      
       <hr>
       
     <h1>Liste des equipes</h1>
<table border="1">
<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>Employés</th></thead>
<tbody>
<c:forEach items="${liste}" var="v">
	<tr><td>${v.idEquipe }</td><td>${v.nomEquipe}</td><td>${v.descriptionEquipe}</td><td> <a href='Employe/${v.idEquipe}'>liste des employee</a></td><sec:authorize access="hasRole('ADMIN')"><td> <a href='deleteEquipe/${v.idEquipe}'>supprimer</a></td> </sec:authorize></tr>
</c:forEach>
</tbody>
</table>
       
       
       
       <hr>
   
            <sec:authorize access="hasRole('ADMIN')">          
      
      <!--  add link to / admin -->
      <p>
<a href="${pageContext.request.contextPath}/FormAjoutEquipe">Ajouter une equipe </a>
   <br>
   
<a href='${pageContext.request.contextPath}/addEmploye'>ajouter employee</a>
            <br>
     
   <a href="${pageContext.request.contextPath}/FormAjoutProjet">Ajouter un Projet </a>
   <br>
      <a href="${pageContext.request.contextPath}/FormAjoutTache">Ajouter une Tache </a> 
         <br>
            <a href="${pageContext.request.contextPath}/FormAjoutConge">Ajouter un Congé </a>
                     <br>
            
            (Only for Admins)
      
      </p>
            </sec:authorize>
   
   
      <a href="${pageContext.request.contextPath}/Taches">Liste des taches</a>
     <br>
      <a href="${pageContext.request.contextPath}/Projets">Liste des Projets</a>
   



<!-- logout Button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   
    <input type="submit" value="Logout" />
   
   
   </form:form>
</body>

</html>