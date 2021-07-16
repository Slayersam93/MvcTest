<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo Fornitore</title>
</head>
<body>
	<h1>Inserisci un nuovo Fornitore</h1>
	<%-- Metodo cacca
	<c:if test="${empty toUpdate}">
		<form action="Inseriscifornitore.do" method="post">
	</c:if>
	<c:if test="${!empty toUpdate}">
		<form action="Updatefornitore.do" method="post">
	</c:if>
	--%>
	
	<%--il c:choose corrisponde al (if) (else if) (else) di java  --%>
	<%--si possono mettere quanti c:when vogliamo ma un solo c:otherwise--%>
	
	<%-- metodo fico 1 
	<form method="post"
		action=<c:choose>																		
	<c:when test = '${ empty toUpdate}'> "Inseriscifornitore.do"</c:when>							
	<c:otherwise>"Updatefornitore.do" </c:otherwise>
	</c:choose>>
	--%>
	
	<form method = "post" action='${empty toUpdate? "Inseriscifornitore.do" : "Updatefornitore.do"}'>
	
		<label for="codiceFornitore">Codice Fornitore:</label> <input
			<%--<c:if test = "${!empty toUpdate}">readonly</c:if> --%>
			${empty toUpdate? "" : "readonly"}
			id="codiceFornitore" type="text" name="codiceFornitore"
			value="${toUpdate.codiceFornitore}"> <br> <label
			for="nome"> Nome:</label> <input id="nome" type="text" name="nome"
			value="${toUpdate.nome}"> <br> <label for="indirizzo">Indirizzo:</label>
		<input id="indirizzo" type="text" name="indirizzo"
			value="${toUpdate.indirizzo}"> <br> <label for="citta">Città:</label>
		<input id="citta" type="text" name="citta" value="${toUpdate.citta}">
		<br> <input type="submit" value="inserisci">
	</form>
</body>
</html>