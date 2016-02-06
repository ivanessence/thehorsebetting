<%@page import="java.text.DateFormat"%>
<%@page import="by.ittc.horsebetting.dao.IRaceDAO"%>
<%@page import="by.ittc.horsebetting.dao.BeanFacade"%>
<%@page import="by.ittc.horsebetting.model.Race"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Admin Panel Add Race</title>

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
				<table align="center" width="350" border="2" bgcolor="#F0F8FF">
					<tr>
						<td height="50" align="center">
							<h2>Add race menu</h2>
						</td>
					</tr>
					<tr>
						<td height="300" align="left"><b>

								<table>
									<%
										IRaceDAO raceDAO = BeanFacade.getRaceDAO();
										Integer id = new Integer(request.getParameter("id"));
										Race race = raceDAO.getRace(id);

										for (int i = 0; i < race.getHorsesNames().size(); i++) {
									%>
									<tr>
										<td><%=race.getHorsesNames().get(i)%></td>
										<td><form>
												<input type="submit" value="Win" /> <input type="hidden"
													name="name" value="<%=race.getHorsesNames().get(i)%>" /> <input
													type="hidden" name="action" value="setWinnerHorse" /> <input
													type="hidden" name="id" value="<%=id%>" />
											</form> <%
 	}
 %>
								</table>

								<p align="center">
									<a href="main?page=adminPanel">Back</a>
									<button>Confirm</button>
								</p>
				</table>
			</td>


		</tr>

	</table>

</body>
</html>