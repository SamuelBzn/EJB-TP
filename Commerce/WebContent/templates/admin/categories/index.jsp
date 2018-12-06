<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../assets/header.jsp" />
<jsp:include page="../../assets/admin_header.jsp" />
	<div class="container">
		<div class="float-right">
			<p>
				<a href="categories/new" class="btn btn-primary">
					Nouvelle catégorie
				</a>
			</p>
		</div>

		<br>

		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>
							<a href="categories/edit?id=${category.id}">Modifier</a> &middot;
							<a href="categories/delete?id=${category.id}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>