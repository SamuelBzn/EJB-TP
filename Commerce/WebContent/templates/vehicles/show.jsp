<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../assets/header.jsp" />

<form method="post" action="/cart/add">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>
					${vehicle.name} &middot;
					<small>${vehicle.category.name}</small>
				</h2>
				
				<p>${vehicle.description}</p>
				
				<p><strong>Options</strong></p>

				<ul>
					<c:forEach items="${vehicle.characteristics}" var="characteristic">
						<li>
							<input type="checkbox" id="${characteristic.id}"
								data-price="${characteristic.price}"
								value="${characteristic.id}" name="characteristics">

							${characteristic.name} &mdash; <small>${characteristic.price}</small>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col-md-6">			
				<p style="font-size: 30px" id="price" data-value="${vehicle.price}"></p>
				
				<p><strong>Stock</strong></p>
				
				<c:choose>
					<c:when test="${vehicle.stock == 1}">
						<p class="text-success">
							<strong>Plus qu'un article restant !</strong>
						</p>
					</c:when>
					
					<c:when test="${vehicle.stock > 1}">
						<p class="text-success">
							${vehicle.stock} restants !
						</p>
					</c:when>
					
					<c:otherwise>
						<p class="text-danger">
							Plus aucun stock disponible pour cet article !
						</p>
					</c:otherwise>
				</c:choose>
				
				<div class="form-inline">
					<input type="hidden" name="id" value="${vehicle.id}">
					
					<div class="input-group" style="width: 100px; margin-right: 1em;">
						<input type="number" name="quantity" value="1" step="1"
							class="form-control" id="quantity"
							max="${vehicle.stock}" min="1" data-max="${vehicle.stock}">
					</div>
					
					<input type="submit" value="Acheter cet article"
						class="btn btn-success">
				</div>
			</div>
		</div>
	</div>
</form>

	<script type="text/javascript">
		
		$(document).ready(function() {
			var price  = $('#price');
			const base = parseFloat(price.data('value'));

			function computePrice() {
				var total = base;

				// On récupère toutes les options cochées et on rajoute
				// leur prix au prix total
				$('input[type=checkbox]:checked').each(function() {
					total += parseFloat($(this).data('price'))
				});

				// On multiplie par le nombre d'éléments souhaités
				total *= parseInt($('#quantity').val());

				price.html('' + total.toFixed(2) + '&euro;');
			}

			// Pour calculer le prix au chargement de la page
			computePrice();

			$('input[type=checkbox], #quantity').on('change', function() {
				computePrice();
			});
		});
	</script>
</body>
</html>