<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form method="post">
			<label for="name">Nom :</label>
			<input type="text" name="name" id="name">
			
			<label for="description">Description :</label>
			<textarea name="description" id="description"></textarea>
			
			<label for="price">Prix :</label>
			<input type="number" name="price" id="price" step="0.5">
			
			<label for="stock">Stock :</label>
			<input type="number" name="stock" id="stock" step="1">
			
			<label>Catégorie :</label>
			<select name="category">
				<c:forEach items="${categories}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select>
			
		</form>
	</body>
</html>