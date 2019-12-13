<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Compteur texte</title>

</head>
<body>
<form action="compteur" method="get" class="form-example">
<div class="form-example">
<label for="localisation">Texte: </label>

<input type="text" name="inputTexte" id="inputTexte" required>
<button type="submit"> Compter mots </button>
</div>
</form>
<table>
	<c:if test = "${isEmpty == false}" >
		<c:forEach var="word" items="${TabWord}" >
		<tr>
			<td> ${word} </td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test = "${isEmpty == true}" >
	<tr>Il n'y a pas de mot dans le texte</tr>
	</c:if>
</table>
</body>
</html>