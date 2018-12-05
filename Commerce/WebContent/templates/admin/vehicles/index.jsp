<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../assets/header.jsp" />
	<div class="container">
		<div class="float-right">
			<p>
				<a href="vehicles/new" class="btn btn-primary">
					Nouveau véhicule
				</a>
			</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th>Catégorie</th>
					<th>Stock</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${vehicles}" var="vehicle">
					<tr>
						<td>${vehicle.id}</td>
						<td>${vehicle.name}</td>
						<td>${vehicle.category.name}</td>
						<td>${vehicle.stock}</td>
						<td>
							<a href="vehicles/edit?id=${vehicle.id}">Modifier</a> &middot;
							<a href="vehicles/delete?id=${vehicle.id}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>