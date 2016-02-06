<%@page import="by.ittc.horsebetting.methods.DateMethod"%>
<%@page import="by.ittc.horsebetting.model.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Horse Betting Panel</title>

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
				<table align="center" width="900" border="2" bgcolor="#F0F8FF">
					<tr align="center">
						<td><a href="main?page=howBegin">Как начать</a></td>
						<td><a href="main?page=news">Новости</a></td>
						<td><a href="main?page=type">Типы ставок</a></td>
						<td><a href="main?page=rule">Правила</a></td>
						<td><a href="main?page=contact">Контакты</a></td>
					</tr>
				</table>
			</td>
			<td rowspan="2" valign="top">
				<table align="right" width="200" style="height: 200px;" border="2"
					bgcolor="#F0F8FF">

					<tr valign="top">
						<td>
							<form>
								<form action="/main" method="post">

									<h1 align="center" width="200px" style="color: Red">Измененить
										данные</h1>
									<p align="center">Смена пароля
									<p align="center"></p>

									<p align="center">
										<input name="login" align="center" type="text"
											placeholder="Старый пароль" /><br />
									<p align="center">

										<input name="pas
									sword" align="middle"
											placeholder="Новый пароль" /><br />
									<p / style="color: Red">
									<p align="center">
										<a href="main?page=newBet">Сделать ставку</a>
									<p align="center">
										<input type="submit" value="SignOut"> <input
											type="hidden" name="action" value="signOut" />
								</form>


							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
</body>
</html>