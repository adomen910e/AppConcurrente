<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>METEO</title>

</head>
<body>
<form action="meteo" method="get" class="form-example">
<div class="form-example">
<label for="localisation">Ville: </label>

<input type="text" name="localisation" id="localisation" required>
<button type="submit"> Météo </button>
</div>
</form>
	<c:if test="${is_running == true}">
		<c:if test = "${meteo != null}" >
			<p>La température à  ${ville} est de ${meteo} degres</p>
		</c:if>
		<c:if test = "${meteo == null}">
			<p>La température à ${ville} n'est pas disponible.</p>
		</c:if>
	</c:if>
</body>
</html>