<%@page import="by.ittc.horsebetting.dao.BeanFacade"%>
<%@page import="by.ittc.horsebetting.dao.INewsDAO"%>
<%@page import="by.ittc.horsebetting.model.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Admin Panel Add News</title>

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
				<table align="right" width="200" style="height: 100%;" border="2"
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
				<table align="center" width="500" border="2" bgcolor="#F0F8FF">
					<%
						List<News> news = new ArrayList<News>();
						INewsDAO newsDAO = BeanFacade.getNewsDAO();
						news = newsDAO.getAllNews();
						for (int i = 0; i < news.size(); i++) {
					%>
					<tr height="10">

						<td>
							<p>
								<b>Title: </b>
							</p>
						</td>
						<td><form>
								<input maxlength="100" size="20" name="title"
									value="<%=news.get(i).getTitle()%>">
								<button>Edit</button>
								<input type="hidden" name="action" value="editNews"><input
									type="hidden" name="id" value="<%=news.get(i).getId()%>" /></td>
					</tr>
					<tr>
						<td valign="top"><p>
								<b>Text: </b>
							</p></td>
						<td><textarea rows="5" cols="50" name="text"><%=news.get(i).getText()%></textarea>
							</form></td>

					</tr>
					<%
						}
					%>
				</table>
			</td>


		</tr>

	</table>

</body>
</html>