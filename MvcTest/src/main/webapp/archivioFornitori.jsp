<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Fornitori</title>
</head>
<body>
<c:forEach items="${listaFornitori}" var="forn">
		<p>${forn.codiceFornitore}  ${forn.nome} ${forn.indirizzo} ${forn.citta} 
		 <a href="mostraFormUpdateFornitore.do?id=${forn.codiceFornitore}">Modifica</a></p>
		<br />
	

	</c:forEach>

</body>
</html>