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
	<form action="Inseriscifornitore.do" method="post">
		<label for="codiceFornitore">Codice Fornitore:</label><input
			<c:if test = "${!empty toUpdate}">readonly</c:if>
			id="codiceFornitore" type="text" name="codiceFornitore"
			value="${toUpdate.codiceFornitore}"><br> <label
			for="nome">Nome:</label><input id="nome" type="text" name="nome"
			value="${toUpdate.nome}"><br> <label for="indirizzo">Indirizzo:</label><input
			id="indirizzo" type="text" name="indirizzo"
			value="${toUpdate.indirizzo}"><br> <label for="citta">Città:</label><input
			id="citta" type="text" name="citta" value="${toUpdate.citta}"><br>
		<input type="submit" value="inserisci">
	</form>
</body>
</html>