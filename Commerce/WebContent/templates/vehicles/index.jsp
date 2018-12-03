<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des véhicules</title>
	</head>
	<body>
		<v:forEach items="${vehicles}" var="vehicle">
			<label>${v.id} - ${v.name}</label>
		</v:forEach>
	</body>
</html>