<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/2/16
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Fisherman Place</title>
</head>
<body>

	<jsp:include page="fragments/header.jsp" />

	<%--Container--%>

	<div class="container">


		<div id="map"></div>

	</div>

	<script
		src="https://maps.googleapis.com/maps/api/js?sensor=false&amp;language=ru&amp;key=
		"AIzaSyC7SM-bttLntm1cXWpd6mulDyhoYHIPHzA"
		type="text/javascript"></script>

	<%--JQuery--%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

	<%--Bootstrap--%>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


	<%--Custom CSS--%>
	<link rel="stylesheet" type="text/css"
		href="resources/css/coordinates.css">

	<%--Google maps--%>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC7uD59aU-uCFNVqxFRZAXPte6ITsjDeXI&callback=initMap"
		async defer></script>


	<%--Custom Scripts--%>
	<script src="resources/js/coordinates.js"></script>
</body>
</html>