<%@page import="java.text.DateFormat"%>
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
									<a href="main?page=addNews">Edit News</a>
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
						<td height="50" align="center" colspan="2">
							<h2>Add race menu</h2>
						</td>
					</tr>
					<tr>
						<td height="300" align="left" colspan="2">
							<%
								for (int i = 0; i < 7; i++) {
							%> <b><div
									title="Оставьте поле пустым, если вам необходимо меньше лошадей">Please
									add horse(?)</div></b>
							<form>
								<select name="horse<%=i%>">
									<option></option>
									<option value="1">Бурёнка</option>
									<option value="2">Быстроходка</option>
									<option value="3">Вертехвостка</option>
									<option value="4">Бурая Молния</option>
									<option value="5">Глазастая Мэрри</option>
									<option value="6">Блудливая Инди</option>
									<option value="7">Кариглазая Вари</option>
								</select> Введите коэфициент<input maxlength="4" size="4"
									name="koef<%=i%>">
								<%
									}
								%>
								<%
									SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
									String min = dt.format(new Date());
								%>

								<p>
									Выберите дату: <input type="date" name="calendar"
										value="<%=min%>">

								</p>
								<p>
									<input name="destination" placeholder="Расстояние">
								</p>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">


							<button>Confirm</button> <input type="hidden"
							value="confirmAddRace" name="action">
							</form>


							<form>
								<button>Back</button>
								<input type="hidden" value="adminPanel" name="page">
							</form>



						</td>
					</tr>
				</table>
			</td>


		</tr>

	</table>

</body>
</html>