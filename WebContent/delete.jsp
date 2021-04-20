<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminazione</title>
</head>
<body>
	<%
	Abitante abitanteInDettaglio = (Abitante) request.getAttribute("abitante_attributes");
	%>

	<h1>
		Dettagli dell'abitante:
		<%=abitanteInDettaglio.getNome()%>
		<%=abitanteInDettaglio.getCognome()%></h1>
	<h3>
		ID:
		<%=abitanteInDettaglio.getIdAbitante()%></h3>
	<h3>
		NOME:
		<%=abitanteInDettaglio.getNome()%></h3>
	<h3>
		COGNOME:
		<%=abitanteInDettaglio.getCognome()%></h3>
	<h3>
		CODICE FISCALE:
		<%=abitanteInDettaglio.getCodiceFiscale()%></h3>
	<h3>
		ETA:
		<%=abitanteInDettaglio.getEta()%></h3>
	<h3>
		MOTTO DI VITA:
		<%=abitanteInDettaglio.getMottoDiVita()%></h3>
	<br>

	<h2>SEI SICURO DI VOLER ELIMINARE QUESTO UTENTE?</h2>
	<form action="ExecuteDeleteAbitanteServlet" method="post">
		<input type="submit" value="elimina"> <input type="hidden"
			name="idAbitante" value="<%=abitanteInDettaglio.getIdAbitante()%>">
	</form>

</body>
</html>