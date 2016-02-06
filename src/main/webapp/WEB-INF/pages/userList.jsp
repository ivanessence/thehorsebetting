
<%@page import="by.ittc.horsebetting.dao.BeanFacade"%>
<%@page import="by.ittc.horsebetting.dao.IUserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.ittc.horsebetting.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Admin Panel User List</title>

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
			<td align="center">
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

									<input type="submit" value="SignOut"> <input
										type="hidden" name="action" value="signOut" />
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table align="center" width="900" border="2" bgcolor="#F0F8FF">
					<tr align="center">
						<td>id</td>
						<td>Login</td>
						<td>Password</td>
						<td>E-mail</td>
						<td>Name</td>
						<td>Lastname</td>
						<td>Telephone</td>
						<td>Balance</td>
						<td>Access</td>
						<td>Edit</td>
						<td>Delete</td>
						<%
							IUserDAO userDAO = BeanFacade.getUserDAO();
							List<User> usersOk = userDAO.loadAllOkUsers();
							List<User> usersDeleted = userDAO.loadAllDeletedUsers();
							for (int i = 0; i < usersOk.size(); i++) {
						%>
					
					<tr align="center">
						<form>
							<td width="20"><%=(int) usersOk.get(i).getId()%></td>
							<td width="70"><input size="4" required type="text"
								name="login" value="<%=usersOk.get(i).getLogin()%>" /></td>
							<td width="100"><input size="5" required type="text"
								name="password" value="<%=usersOk.get(i).getPassword()%>"></td>
							<td><input size="10" required type="text" name="mail"
								value="<%=usersOk.get(i).getMail()%>" /></td>
							<td><input size="3" required type="text" name="name"
								value="<%=usersOk.get(i).getName()%>" /></td>
							<td><input size="3" required type="text" name="lastName"
								value="<%=usersOk.get(i).getLastName()%>" /></td>
							<td><input size="3" required type="text" name="telephone"
								value="<%=usersOk.get(i).getTelephone()%>" />
							<td><%=usersOk.get(i).getBalance()%><input type="hidden"
								name="balance" value="<%=usersOk.get(i).getBalance()%>" /></td>
							<td><input type="hidden" name="access"
								value="<%=usersOk.get(i).getAccess()%>" /> <select
								name="access">
									<option value="<%=usersOk.get(i).getAccess()%>"><%=usersOk.get(i).getAccess()%></option>
									<option
										value="<%if ("Client".equals(usersOk.get(i).getAccess())) {%>Administrator<%} else {%>Client<%}%>">
										<%
											if ("Client".equals(usersOk.get(i).getAccess())) {
										%>Administrator<%
											} else {
										%>Client<%
											}
										%>
									</option>
							</select></td>
							<td>
								<button>Save</button> <input type="hidden" name="action"
								value="saveUser" /> <input type="hidden" name="id"
								value="<%=usersOk.get(i).getId()%>" />
						</form>
						</form>
						</td>
						<td><form>
								<button>Delete</button>
								<input type="hidden" name="action" value="deleteUser" /> <input
									type="hidden" name="id" value="<%=usersOk.get(i).getId()%>" />
							</form></td>
						<%
							}
						%>
						<%
							for (int x = 0; x < usersDeleted.size(); x++) {
						%>
					
					<tr align="center" bgcolor="#808080">
						<td width="20"><%=(int) usersDeleted.get(x).getId()%></td>
						<td width="70"><%=usersDeleted.get(x).getLogin()%></td>
						<td width="100"><%=usersOk.get(x).getPassword()%></td>
						<td><%=usersDeleted.get(x).getMail()%></td>
						<td><%=usersDeleted.get(x).getName()%></td>
						<td><%=usersDeleted.get(x).getLastName()%></td>
						<td><%=usersDeleted.get(x).getBalance()%></td>
						<td><%=usersDeleted.get(x).getAccess()%></td>
						<td><a
							href="/main?page=returnUser&id=<%=usersDeleted.get(x).getId()%>&action=returnUser">Return</a>

						</td>

						<%
							}
						%>
					
				</table>
			</td>


		</tr>

	</table>

</body>
</html>