<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../assets/header.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${empty cart}">
				<p class="lead text-center">Vous n'avez aucun élément dans votre panier !</p>
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${cart}" var="purchase" varStatus="loop">
					<div class="float-right">
						<a href="/cart/remove?index=${loop.index}" class="btn btn-sm btn-danger">
							Retirer
						</a>
					</div>
					
					<h3>
						<a href="/vehicle?id=${purchase.vehicle.id}">
							${purchase.vehicle.name}
						</a>
					</h3>
					<h5>${purchase.quantity} unités</h5>
					
					<div class="float-right">
						${purchase.unitPrice} &times; ${purchase.quantity} =
						${purchase.unitPrice * purchase.quantity}&euro;
					</div>
					
					<ul>
						<c:forEach items="${purchase.characteristics}" var="characteristic">
							<li>
								${characteristic.name} &mdash;
								<small>${characteristic.price}&euro;</small>
							</li>
						</c:forEach>
					</ul>
					
					<hr>
				</c:forEach>
				
				<div class="float-left">
					<a href="/cart/validate" class="btn btn-success">
						Valider le panier
					</a>
				</div>
				
				<div class="float-right">
					<p class="lead">
						${cartTotal}&euro;
					</p>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>
</body>
</html>