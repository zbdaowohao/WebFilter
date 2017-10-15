<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
  <head>
    <title>Login page</title>
  </head>
  <style type="text/css">
  	input:not(:last-child){
  		float: right;
  	}
  </style>
  <body>
  <!-- http://127.0.0.1:8080/webFilter/AppPage/login.jsp -->
	  <div style="margin: 20% auto;width: 300px;height: 60%">
	    <form action="../login" method="post">
	    	UserName: <input type="text" name="userName">
	    	<br><br><br>
	    	Password: <input type="password" name="password">
	    	<br><br><input type="submit" value="Login" style="display: block;padding: 10px;margin: 30px auto;width:20%;border:1px solid #cecece;cursor: pointer">
	    </form>
	  </div>
  </body>
</html>
