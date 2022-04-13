<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center">Languages</h1>
	<table class="table table-striped container">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Creator</th>
				<th scope="col">Version</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${languages}">
				<tr>
					<td scope="row"><a href="/languages/${language.id }">${language.name }</a></td>
					<td><c:out value="${language.creatorName }" /></td>
					<td><c:out value="${language.version }" /></td>
					<td class="d-flex align-content-center"><a class="btn btn-link" href="/languages/edit/${language.id }">Edit</a>
						<form action="/languages/delete/${language.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-link">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div class="d-flex flex-column align-items-center">
		<h1>Add a Language</h1>
		<form:form action="/languages" method="post" modelAttribute="language">

			<p>
				<form:errors path="name" class="error" />
			</p>
			<p>
				<form:errors path="creatorName" class="error" />
			</p>
			<p>
				<form:errors path="version" class="error" />
			</p>


			<p>
				<form:label path="name">Language Name:</form:label>
				<form:input path="name" type="text" />
			</p>
			<p>
				<form:label path="creatorName">Creator Name:</form:label>
				<form:input path="creatorName" type="text" />
			</p>
			<p>
				<form:label path="version">Version: </form:label>
				<form:input type="number" path="version" />
			</p>
	
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>