<%@page import="com.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	ArrayList<UserDTO> users = (ArrayList<UserDTO>) request.getAttribute("users");
	Boolean isUserFound = (Boolean) request.getAttribute("isUserFound");
%>
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

table, th, td {
	font-size: 20px;
 	border: 2px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 7px 20px;
	text-align: center;
}

.tabledata {
	margin-top : 70px;
}

</style>

</head>
<body>

	<%@ include file="/WEB-INF/nav/adminNav.jsp"%>

	<div class="tabledata">
		<h2 style="margin-bottom: 15px; text-align: center;">User Details</h2>
	    <table border="1">
	        <tr style="background-color: #8E54E9; color: white">
	            <th>s.no</th><th>userId</th><th>UserName</th><th>Email</th>
	        </tr>
	        <% 
	        	int i = 1;
	            if (users != null) {
	                for (UserDTO user : users) {
	        %>
	            <tr>
	            	<td><%= i++ %></td>
	                <td><%= user.getUserId() %></td>
	                <td><%= user.getName() %></td>
	                <td><%= user.getEmail() %></td>
	            </tr>
	        <% 
	            	}
	         	} else if (isUserFound != null && !isUserFound) {
	     	%>
	     	    <tr style="color:red; font-size:20px; font-weight:bold;">
	   		    	<td colspan="4">No Users found!</td>
	   		    </tr>
	     	<%
	     	    }
	     	%>
	    </table>
	</div>

</body>
</html>