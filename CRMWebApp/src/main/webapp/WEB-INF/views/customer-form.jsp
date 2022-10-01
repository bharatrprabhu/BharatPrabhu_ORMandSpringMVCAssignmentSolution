<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Information Form</title>
<style>
h3 {
	text-align: center;
	vertical-align: middle;
	color: white;
	background-color: green;
	height: 150px;
	font-size: 25px;
}
</style>
</head>

<body>

	<div class="container">

		<h3>Customer Relation Management</h3>
		<hr>
		<form action="/CRMWebApp/customers/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="first_name" value="${Customer.first_name}"
					class="form-control mb-4 col-4" placeholder="First_Name">
			</div>

			<div class="form-inline">

				<input type="text" name="last_name" value="${Customer.last_name}"
					class="form-control mb-4 col-4" placeholder="Last_Name">
			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email Address">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CRMWebApp/customers/list">Back to Customer List</a>

	</div>
</body>

</html>

