<%@page import="by.ittc.horsebetting.dao.IRaceDAO"%>
<%@page import="by.ittc.horsebetting.dao.BeanFacade"%>
<%@page import="by.ittc.horsebetting.dao.IUserDAO"%>
<%@page import="by.ittc.horsebetting.command.SortingUtill"%>
<%@page import="by.ittc.horsebetting.methods.SortMethod"%>
<%@page import="by.ittc.horsebetting.methods.DateMethod"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="by.ittc.horsebetting.model.Race"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Admin Panel</title>

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
			<td align="center"><form>
					<select name="filter">
						<option value="Date">Date</option>
						<option value="Destination">Destination</option>
						<option value="Status">Status</option>
					</select><input type="submit" value="filter" /><input type="hidden"
						name="page" value="adminPanel" />
				</form></td>
			<td>
				<form>
					<input type="submit" value="Add Race" /> <input type="hidden"
						name="page" value="addRace" />
				</form>
			</td>
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

		<tr valign="top">
			<td>
				<table align="center" width="900" border="2" bgcolor="#F0F8FF">
					<tr align="center">
						<td>N</td>
						<td>Horse List</td>
						<td>Time</td>
						<td>Destination</td>
						<td>Edit</td>
						<td>Delete</td>
						<td>Status</td>
						<%
							IRaceDAO raceDAO = BeanFacade.getRaceDAO();
							List<Race> racesOK = raceDAO.getAllActiveRace();
							List<Race> racesDeleted = raceDAO.getAllDeletedRace();
							SortingUtill.findFilter(request.getParameter("filter"), racesOK);

							for (int i = 0; i < racesOK.size(); i++) {
						%>
					
					<tr align="center">
						<td width="20"><%=racesOK.get(i).getId()%></td>
						<td width="70"><select>
								<%
									for (int x = 0; x < racesOK.get(i).getHorsesNames().size(); x++) {
								%><option><%=racesOK.get(i).getHorsesNames().get(x)%></option>
								<%
									}
								%>
						</select></td>

						<td width="200"><%=DateMethod.formatDate(racesOK.get(i).getDate())%></td>
						<td width="50"><%=racesOK.get(i).getDestination()%>
						<td>
							<form>
								<a href="main?page=editRace&id=<%=racesOK.get(i).getId()%>">Edit</a>
							</form>
						</td>
						<td>
							<form>
								<button>Delete</button>
								<input type="hidden" value="deleteRace" name="action"><input
									type="hidden" value="<%=racesOK.get(i).getId()%>" name="id">
							</form>
						</td>
						<td><%=racesOK.get(i).getStatus()%></td>
						<%
							}
						%>
						<%
							for (int i = 0; i < racesDeleted.size(); i++) {
						%>
					
					<tr align="center" bgcolor="#808080">
						<td width="20"><%=racesDeleted.get(i).getId()%></td>
						<td width="70"><select>
								<%
									for (int x = 0; x < racesDeleted.get(i).getHorsesNames().size(); x++) {
								%><option><%=racesDeleted.get(i).getHorsesNames().get(x)%></option>
								<%
									}
								%>
						</select></td>

						<td width="200"><%=DateMethod.formatDate(racesDeleted.get(i).getDate())%></td>
						<td width="50"><%=racesDeleted.get(i).getDestination()%>
						<td><a
							href="main?page=adminPanel&action=returnRace&id=<%=racesDeleted.get(i).getId()%>">Return</a>
						</td>
						<td>Already deleted</td>
						<td>Deleted</td>
						<%
							}
						%>
					
				</table>
			</td>


		</tr>

	</table>

</body>
</html>