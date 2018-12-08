<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../assets/header.jsp" />
	<div class="container">
		<div class="alert alert-danger">
			<h2>Erreur lors de la validation de votre commande</h2>
			
			${error}
		</div>
	</div>
</body>
</html>