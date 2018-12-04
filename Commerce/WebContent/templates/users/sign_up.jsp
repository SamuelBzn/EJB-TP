<jsp:include page="../assets/header.jsp" />
		<div class="container">
			<form method="post">
				<div class="form-group">
					<label for="pseudo">Pseudo :</label>

					<input type="text" class="form-control" id="pseudo"
						placeholder="Votre pseudo" name="pseudo">
				</div>

				<div class="form-group">
					<label for="email">E-Mail :</label>

					<input type="email" class="form-control" id="email"
						placeholder="Votre e-mail" name="email">
				</div>

				<div class="form-group">
					<label for="password">Mot de passe :</label>

					<input type="password" class="form-control" id="password"
						placeholder="Votre mot de passe"
						name="password">
				</div>

				<div class="form-group">
					<label for="devise">Devise pour les achats</label>

					<select class="form-control" name="devise" id="devise">
						<option value="0">Euros &euro;</option>
						<option value="1">USD &#36;</option>
						<option value="2">GBP &pound;</option>
						<option value="3">JPY &yen;</option>
					</select>
				</div>

				<button type="submit" class="btn btn-primary">Envoyer</button>
			</form>
		</div>
	</body>
</html>