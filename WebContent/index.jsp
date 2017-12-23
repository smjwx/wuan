<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "main">
		<div id = "login">
		<h1>登录 ${errorMessage}</h1>
			<form action="${pageContext.request.contextPath }/login" method="post">
				<div><label>用户名</label><input name = "account">
				</div>
				
				<div><label>密码</label>
				<input name = "password"
					maxlength="6" required>
				</div>
				
				<div><label>提交</label>
				<input type = "submit">
				</div>
			</form>
		</div>
		
		<div id = "register">
		<h1>注册</h1>		
		<form method="post" action="account">
				<div><label>用户名</label>
				<input id = "account" name = "account" >
				<span id = "account_hint"></span>
				</div>
				<div><label>密码</label>
				<input id = "pw1" name = "password" 
				maxlength="6" required>
				
				</div>
				<div><label>确认密码</label>
				<input id = "pw2" name = "password">
				</div>
				<div><input type="submit" value="注册">
				
				</div>
			</form>
	</div>
</body>
</html>