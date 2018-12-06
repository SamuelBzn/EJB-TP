<jsp:include page="../../assets/header.jsp" />
<jsp:include page="../../assets/admin_header.jsp" />
	<div class="container">
		<form method="post">
			<div class="form-group">
				<label for="name">Nom :</label>
				<input type="text" name="name" id="name" value="${category.name}"
					class="form-control">
			</div>

			<input type="hidden" name="id" value="${category.id}">
			
			<input type="submit" value="Envoyer" class="btn btn-primary">
		</form>
	</div>

</body>
</html>