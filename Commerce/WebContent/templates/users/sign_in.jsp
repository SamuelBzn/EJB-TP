<jsp:include page="../assets/header.jsp" />
		<div class="container">
			<form method="post">
			  <div class="form-group">
			    <label for="pseudo">Pseudo :</label>
			    <input type="text" class="form-control" id="pseudo" aria-describedby="pseudo" placeholder="Votre pseudo" name="pseudo">
			  </div>
			  <div class="form-group">
			    <label for="password">Mot de passe :</label>
			    <input type="password" class="form-control" id="password" placeholder="Votre mot de passe" name="password">
			  </div>
			  <button type="submit" class="btn btn-primary">Envoyer</button>
			</form>
		</div>
	</body>
</html>