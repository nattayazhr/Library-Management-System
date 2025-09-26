<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>

<style type="text/css">
:root {
	--primary: #000000;
	--secondary: #FFFFFF;
	--accent: #8E54E9;
	--shadow: 8px 8px 0px var(--primary);
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Courier New', monospace;
}

body {
	background-color: var(--secondary);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	padding: 20px;
}

<%@ include file="/WEB-INF/nav/navStyles.jsp" %>

h1 {
	text-align: center;
	font-size: 150px;
	color: #FBB144;
	margin-top: 120px;
}

</style>

</head>
<body>

<%@ include file="/WEB-INF/nav/loginNav.jsp" %>

<h1>Library Management System</h1>

</body>
</html>