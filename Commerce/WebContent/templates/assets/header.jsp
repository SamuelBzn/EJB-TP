<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

		<title>TP EJB</title>

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<style>
			.navbar {
				margin-bottom: 1.5em;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="/">TP EJB</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="/">Accueil</a>
						</li>

						<c:choose>
					    	<c:when test="${sessionScope.sessionId != null}">
					    		<li class="nav-item">
					    			<a href="/deliveries" class="nav-link">Vos achats</a>
					    		</li>
					    	</c:when>
					    </c:choose>
					</ul>
				</div>

				<span class="navbar-text">
					<c:choose>
					    <c:when test="${sessionScope.sessionId != null}">
							<a href="/cart">Votre panier</a> &middot;
					        <a href="/users/sign_out">Déconnexion</a>
					    </c:when>

					    <c:otherwise>
					        <a href="/users/sign_up">Inscription</a> &middot;
					        <a href="/users/sign_in">Connexion</a>
					    </c:otherwise>
					</c:choose>
				</span>
			</div>
		</nav>