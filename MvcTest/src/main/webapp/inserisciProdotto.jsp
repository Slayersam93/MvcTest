<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Nuovo Prodotto</title>
</head>
<body>
<form method = "post" action = "inserisciProdotto.do"> 
<label for = "codice">Codice Prodotto</label>
<input type = "text" name = "codice" id = "codice">
<br>
<label for = "nome">Nome Prodotto</label>
<input type = "text" name = "nome" id = "nome">
<br>
<label for = "descrizione">Descrizione Prodotto</label>
<input type = "text" name = "descrizione" id = "descrizione">
<br>
<label for = "marca">Marca Prodotto</label>
<input type = "text" name = "marca" id = "marca">
<br>
<label for = "prezzo">Prezzo Prodotto</label>
<input type = "text" name = "prezzo" id = "prezzo">
<br>
<label for = "fornitore">Fornitore Prodotto</label>
<select id = "fornitore" name = "fornitore">
<c:forEach items = "${listaFornitori}" var = "forn">
	<option value = "${forn.codiceFornitore }"> ${forn.nome} </option> 
</c:forEach>  
</select>


<input type = "submit" value = "inserisci"> 



</form>

</body>
</html>