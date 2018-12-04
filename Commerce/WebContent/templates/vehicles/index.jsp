<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des véhicules</title>
	</head>
	<body>
		<c:forEach items="${requestScope['vehicles']}" var="vehicle">
			<label>${vehicle.id} - ${vehicle.name}</label>
		</c:forEach>
	</body>
</html>