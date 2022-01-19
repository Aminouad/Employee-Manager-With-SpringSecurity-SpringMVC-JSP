<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Taches</title>
</head>

<body>

	<h2>Liste des taches</h2>
	<hr>
	
	<p>Voici le liste des taches </p>

	<hr>
	   <!-- display user name and role -->
	
	<p> User: <sec:authentication property="principal.username" />
	<br><br>
	 
	 Role(s): <sec:authentication property="principal.authorities" />
	</p>
      
      
      <c:set var="context" value="${pageContext.request.contextPath}" />
      
      
      
       
        <h1>Liste des Taches</h1>
<table border="1">
<thead><tr><th>ID</th><th>descriptionTache</th><th>chargeHoraireTache</th><th>prioriteTache</th><th>statusTache</th><th>dateDebutTache</th><th>dateFinTache</th><th>Employé</th><th>Projet</th></thead>
<tbody>
<c:forEach items="${liste2}" var="t">
	<tr><td>${t.idTache }</td><td>${t.descriptionTache}</td><td>${t.chargeHoraireTache}</td><td>${t.prioriteTache}</td><td>${(t.statusTache)}</td><td>${t.dateDebutTache}</td><td>${t.dateFinTache}</td><td>${(t.employe).getNomEmpl()}</td><td>${(t.projet).getNomPro()}</td><sec:authorize access="hasRole('ADMIN')"><td> <a href='Taches/deleteTache/${t.idTache}'>supprimer</a></td></sec:authorize></tr>
</c:forEach>
</tbody>
</table>
<c:set var="context" value="${pageContext.request.contextPath}" />


   <!-- logout Button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   
    <input type="submit" value="Logout" />
   
   
   </form:form>
   
   
<sec:authorize access="hasRole('ADMIN')">
      
      <!--  add link to / admin -->
      <p>
   <br>
     
   
  
      <a href="${pageContext.request.contextPath}/FormAjoutTache">Ajouter une Tache </a> 
         <br>
            
            (Only for Admins)
      
      </p>
            </sec:authorize>
      
   
   
   <br>
   <a href="${context}/">Home</a>
   

</body>

</html>