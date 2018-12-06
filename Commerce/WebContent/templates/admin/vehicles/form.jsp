<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../assets/header.jsp" />
<jsp:include page="../../assets/admin_header.jsp" />
	<div class="container">
		<form method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="name">Nom :</label>

						<input type="text" name="name" id="name"
							class="form-control" value="${vehicle.name}">
					</div>

					<div class="form-group">
						<label for="description">Description :</label>

						<textarea name="description" id="description"
							class="form-control">${vehicle.description}</textarea>
					</div>

					<div class="form-group">
						<label for="price">Prix :</label>

						<input type="number" name="price" id="price" step="0.5"
							class="form-control" value="${vehicle.price}">
					</div>

					<div class="form-group">
						<label for="stock">Stock :</label>

						<input type="number" name="stock" id="stock" step="1"
							class="form-control" value="${vehicle.stock}">
					</div>

					<div class="form-group">
						<label>Catégorie :</label>

						<select name="category_id" class="form-control">
							<c:forEach items="${categories}" var="category">
								<c:choose>
									<c:when test="${category.id == vehicle.category.id}">
										<option value="${category.id}" selected>
											${category.name}
										</option>
									</c:when>
			
									<c:otherwise>
										<option value="${category.id}">
											${category.name}
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card">
						<div class="card-header">Charactéristiques supplémentaires</div>

						<div class="card-body">
							<c:forEach items="${groups}" var="entry">
								<p><strong>${entry.key}</strong></p>

								<c:forEach items="${entry.value}" var="val">
									<label for="${val.id}">
										<c:choose>
											<c:when test="${vehicle.characteristicIds.contains(val.id)}">
												<input type="checkbox" name="characteristics"
													value="${val.id}" id="${val.id}" checked>
											</c:when>

											<c:otherwise>
												<input type="checkbox" name="characteristics"
													value="${val.id}" id="${val.id}">
											</c:otherwise>
										</c:choose>

										${val.name}
									</label><br>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
				</div>

				<input type="hidden" name="id" value="${vehicle.id}">


				<input type="submit" value="Envoyer" class="btn btn-primary">
			</div>
		</form>
	</div>

</body>
</html>