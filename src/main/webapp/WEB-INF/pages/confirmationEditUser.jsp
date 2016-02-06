<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Admin Panel Confirmation Editing User</title>

<style type="text/css">
h1 {
	font-size: 300%;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #F5F5DC;
}
</style>

</head>
<body background="/img/background.jpg">
	<table width=100%>
		<tr>
			<td align="center"><a href="main?page=theHorseBetting"><img
					src="/img/horsebetting.png" /></a></td>
			<td><img align="right" src="/img/logotipe.jpg" width="200"></img>
			<td>
		<tr>
			<td align="center"><p></p></td>
		</tr>
		<tr>
			<td align="center"></td>
			<td rowspan="2" valign="top">
				<table align="right" width="200" style="height: 200px;" border="2"
					bgcolor="#F0F8FF">

					<tr valign="top">
						<td>
							<form>
						
							<h3 align="center">Hello, User</h3>
							<p align="center">
								<a href="main?page=userList">User List</a>
							<p align="center">
								<a href="main?page=adminPanel">Races List</a>
							<p align="center">
								<a href="main?page=addNews">Add News</a>
							<p align="center">
								<a href="main?page=editNews">Edit News</a>
							<p align="right">
							
								<input type="submit" value="SignOut"> <input type="hidden"
									name="action" value="signOut" />
							</form>	
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table align="center" width="250" height="150"  border="2" bgcolor="#F0F8FF">
					<tr>
						<td height="50" align="center">
							<h2>Edit user menu</h2>
						</td>
					</tr>
					<tr>
						<td height="100" align="left">
							<table border="0" width="250">
								<tr>
									<td>
										<p>Login:
									</td>
									<td>abube</td>
								</tr>
								<tr>
									<td><p>Password:</td>
									<td>abubeechka</td>
								</tr>
								<tr>
									<td><p>Name:</td>
									<td>Lolka</td>
								</tr>
								<tr>
									<td><p>Lastname:</td>
									<td>Korolka</td>
								</tr>
								<tr>
									<td><p>e-mail:</td>
									<td>odindvatri@mail.com</td>
								</tr>
								<tr>
									<td><p>Access:</td>
									<td>User</td>
								</tr>
								<tr>
									<td colspan="2" align="center">


										<button>Back</button>
										<button>Confirm</button>
									</td>
								</tr>

							</table>
						</td>


					</tr>

				</table>
</body>
</html>