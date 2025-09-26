<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<style type="text/css">

<%@ include file ="/WEB-INF/nav/navStyles.jsp" %>

<%@ include file="/WEB-INF/css/styles.jsp" %>

</style>

</head>
<body>

	<%@ include file="/WEB-INF/nav/loginNav.jsp"%>

	<div class="login-container">
		<form action="signUp" method="post">
			<h1>SIGN UP</h1>

			<div class="input-group">
				<label for="name">User Name</label> 
				<input type="text" name="name" id="name" placeholder="your name" required>
			</div>
			
			<div class="input-group">
				<label for="email">Email</label> 
				<input type="email" name="email" id="email" placeholder="your@email.com" required>
			</div>

			<div class="input-group">
            <label for="password">Password</label>
            <div class="password-container">
                <input type="password" name="password" id="password" placeholder="••••••••">
                <i class="fa-solid fa-eye-slash" id="togglePassword"></i>
            </div>
        </div>

			<button type="submit">Create Account</button>

			<div class="divider">OR</div>

			<div class="footer">
				Already have an account? <a href="login">Login</a>
			</div>
		</form>
		
		<div style="margin-top: 10px; text-align: center;">
		
			<%
			Boolean isUserAdded = (Boolean) request.getAttribute("isUserAdded");
			if (isUserAdded != null && isUserAdded) {
			%>
				<p style="color: green; font-size:19px; font-weight:bold;">Account Created Successfully!! Please Login!!</p>
			<%
			} else if(isUserAdded != null) {
			%>
				<p style="color: red; font-size:19px; font-weight:bold;">Error Creating Account!! Try Later!!</p>
			<%
			}
			%>
		
		</div>
		
	</div>
	
	<script>
	    const passwordField = document.getElementById('password');
	    const togglePassword = document.getElementById('togglePassword');
	
	    togglePassword.addEventListener('click', function() {
	        const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
	        passwordField.setAttribute('type', type);
	
	        // Toggle the eye icon
	        togglePassword.classList.toggle('fa-eye'); // Changes to a eye icon
	        togglePassword.classList.toggle("fa-eye-slash");
	    });
    </script>

</body>
</html>