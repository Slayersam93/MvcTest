<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Prodotti</title>
</head>
<body>
<c:forEach items="${listaProdotti}" var="prod">
		<p>${prod.codiceProdotto}  ${prod.nome} ${prod.descrizione} ${prod.marca} ${prod.fornitore.nome} ${prod.prezzo} </p>
		<br />
	

	</c:forEach>

</body>
</html>