<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dto.UserTransactionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	ArrayList<UserTransactionDTO> myTransactions = (ArrayList<UserTransactionDTO>) request.getAttribute("myTransactions");
 	Boolean isTransactionFound = (Boolean) request.getAttribute("isTransactionFound");
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

	<%@ include file="/WEB-INF/nav/userNav.jsp"%>

	<div class="tabledata">
		<h2 style="margin-bottom: 15px; text-align:center;">Transaction Details</h2>
	    <table border="1">
	        <tr style="background-color: #8E54E9; color: white">
	            <th>S.No</th><th>Book_Id</th><th>Book_Title</th><th>Transc_Type</th><th>Transc_Date</th>
	        </tr>
	        <%
     	        int i = 1;
     	        if (myTransactions != null) {
     	            for (UserTransactionDTO transaction : myTransactions) {
	        %>
	            <tr>	            	
	                <td><%= i++ %></td>
	                <td><%= transaction.getBook_id() %></td>
	                <td><%= transaction.getBook_title() %></td>
	                <td><%= transaction.getTransaction_type() %></td>
	                <td><%= transaction.getTransaction_date() %></td>
	            </tr>
	        <% 
	            	}
	         	} else if (isTransactionFound != null && !isTransactionFound) {
	     	%>
	     	    <tr style="color:red; font-size:20px; font-weight:bold;">
	   		    	<td colspan="5">No Transactions found!</td>
	   		    </tr>
	     	<%
	     	    }
	     	%>
	    </table>
	</div>

</body>
</html>