<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../assets/header.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${empty deliveries}">
				<p class="lead text-center">Vous n'avez encore passé aucune commande</p>
			</c:when>
		
			<c:otherwise>
				<c:forEach items="${deliveries}" var="delivery">
					<c:forEach items="${delivery.purchases}" var="purchase">
						<div class="float-right">
							${purchase.unitPrice} &times; ${purchase.quantity} =
							${purchase.unitPrice * purchase.quantity}&euro;
						</div>

						<h3>
							<a href="/vehicle?id=${purchase.vehicle.id}">
								${purchase.vehicle.name}
							</a>
						</h3>
						<h5>${purchase.quantity} unités</h5>
						
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
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>