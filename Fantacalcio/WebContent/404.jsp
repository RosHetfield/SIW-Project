<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fantabomber - 404</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/business-casual.css" rel="stylesheet" />

</head>
<body>
	<c:choose>
		<c:when test="${Username == null}">
			<%@ include file="../fragments/header.html"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../fragments/navbar.html"%>
		</c:otherwise>
	</c:choose>


	<div class="container-fluid box text-center">
		<h1>404</h1>
		<div>
			<p>Pagina non trovata</p>
		</div>
	</div>



	<%@ include file="../fragments/footer.html"%>


	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js"></script>


</body>
</html>
