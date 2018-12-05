<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../assets/header.jsp" />
	<div class="container">
		<div class="float-right">
			<p>
				<a href="characteristics/new" class="btn btn-primary">
					Nouvelle charactéristique
				</a>
			</p>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th>Catégorie</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${characteristics}" var="characteristic">
					<tr>
						<td>${characteristic.id}</td>
						<td>${characteristic.name}</td>
						<td>${characteristic.category.name}</td>
						<td>
							<a href="characteristics/edit?id=${characteristic.id}">Modifier</a> &middot;
							<a href="characteristics/delete?id=${characteristic.id}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>