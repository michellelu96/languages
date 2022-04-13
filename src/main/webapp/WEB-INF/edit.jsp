<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name }</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="d-flex flex-column align-items-center">
		<h1>Edit an Language</h1>
		<form action="/languages/delete/${language.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-link">
						</form>
		<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">

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

			<input class="text-center" type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>