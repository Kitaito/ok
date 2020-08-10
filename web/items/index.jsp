<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index.jsp</title>
	<link rel="stylesheet" href="../css/index.css"/>
	<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>
	<script type="text/javascript" src="../js/user.js"></script>
</head>
<body style="letter-spacing: -8px">
	<div class="head" style="width: 1200px;height: 200px;background-color: olive">
		<%@ include file="head.jsp" %>
	</div>
	<div class="left" style="width: 300px;height: 500px;background-color: lightblue;display:inline-block">
		<%@ include file="left.jsp" %>
	</div>
	<div class="main"  style="width: 900px;height: 500px; background-color: orange;display:inline-block;vertical-align: top">
		<%@ include file="main.jsp" %>
	</div>
	<div class="foot" style="width: 1200px;height: 100px;background-color: olive;">
		<%@ include file="foot.jsp" %>
	</div>
</body>
</html>