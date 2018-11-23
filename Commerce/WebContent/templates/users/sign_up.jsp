<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
	</head>
	<body>
		<form method="post">
			<label for="pseudo">Adresse e-mail</label>
			<input type="email" name="email" id="email">
			
			<label for="pseudo">Pseudo</label>
			<input type="text" name="pseudo" id="pseudo">
			
			<label for="pseudo">Mot de passe</label>
			<input type="password" name="password" id="password">
			
			<label for="devise">Devise</label>
			<select name="devise">
				<option value="0">Euros €</option>
				<option value="1">USD $</option>
				<option value="2">GBP £</option>
				<option value="3">JPY ¥</option>
			</select>
			
			<input type="submit" value="Envoyer">
		</form>
	</body>
</html>