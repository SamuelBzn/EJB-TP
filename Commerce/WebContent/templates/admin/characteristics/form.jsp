<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../assets/header.jsp" />
	<div class="container">
		<form method="post">
			<div class="form-group">
				<label for="name">Nom :</label>
				<input type="text" name="name" id="name" class="form-control"
					value="${characteristic.name}">
			</div>
			
			<div class="form-group">
				<label for="price">Prix :</label>
				<input type="number" name="price" id="price" class="form-control"
					step="0.1" value="${characteristic.price}">
			</div>
			
			<div class="form-group">
				<label>Catégorie :</label>
				
				<select name="category_id">
					<c:forEach items="${categories}" var="category">
						<c:choose>
						    <c:when test="${category.id == characteristic.category.id}">
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
			
			<input type="hidden" name="id" value="${characteristic.id}">
			
			<input type="submit" value="Envoyer" class="btn btn-primary">
		</form>
	</div>
</body>
</html>