<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>
							<a href="edit/${category.id}">Modifier</a> &middot;
							<a href="delete/${category.id}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>