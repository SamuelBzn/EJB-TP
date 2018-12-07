<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../assets/header.jsp" />
	<div class="container">
		<div class="row">
			<c:forEach items="${vehicles}" var="vehicle">
				<div class="col-md-4">
					<div class="card" style="height: 200px;">
						<div class="card-body">
					    	<h5 class="card-title">${vehicle.name}</h5>
		
					    	<p class="card-text">
					    		${vehicle.description}
					    	</p>
		
					    	<a href="/vehicle?id=${vehicle.id}" class="btn btn-primary">
					    		Plus d'informations
					    	</a>
					  </div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>