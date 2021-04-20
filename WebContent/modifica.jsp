<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Abitante</title>
</head>
<body>

	<h1>Modifica Abitante</h1>

	<form action="ExecuteModificaAbitanteServlet" method="post">

		<label for="nomeModificaInput">Inserisci Nome:</label> <input
			type="text" name="nomeModificaInput" required> <br> <label
			for="cognomeModificaInput">Inserisci Cognome:</label> <input
			type="text" name="cognomeModificaInput" required> <br> <label
			for="codiceFiscaleModificaInput">Inserisci Codice Fiscale:</label> <input
			type="text" name="codiceFiscaleModificaInput" required> <br>

		<label for="etaModificaInput">Inserisci Eta':</label> <input
			type="text" name="etaModificaInput" required> <br> <label
			for="mottoModificaInput">Inserisci Motto di Vita:</label> <input
			type="text" name="mottoModificaInput" required> <br> <input
			type="hidden" name="idModificaInput"
			value=<%= request.getAttribute("abitante_modifica_attribute") %>>
		<input type="submit" value="Modifica">

	</form>

</body>
</html>