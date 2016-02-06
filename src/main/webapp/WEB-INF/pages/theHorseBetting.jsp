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

									<br />
									<h1 align="right" width="200px" style="color: Red">Личный
										кабинет</h1>
									<input name="login" align="middle" type="text"
										placeholder="Логин" /><br /> <input name="password"
										align="middle" type="password" placeholder="Пароль" /><br />
									<p / style="color: Red">
										<input name="remember" type="checkbox" value="yes" />
										Запомнить <br /> <input type="submit" value="Вход"> <a
											href="main?page=registration"><input type="button"
											value="Регистрация"></a> <input type="hidden"
											name="action" value="signIn" />

										<%
			User user = (User) request.getSession().getAttribute("user");

			if (user == null) {

				String signInError = (String) request.getSession()
						.getAttribute("signInError");

				if (signInError != null) {
%>
									
									<h1 color="Red">AHTUNG</h1>
									<%
										}

										}
									%>

								</form>


							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<style type="text/css">
ul.css-menu-3 {
	list-style: none;
	border-bottom: 5px solid #bb0000;
	border-top: 1px solid #114477;
	padding: 11px;
	background: #336699
}

ul.css-menu-3 li {
	display: inline
}

ul.css-menu-3 li a {
	color: #fefefe;
	text-decoration: none;
	background: #225588;
	border: 1px solid #225588;
	border-bottom: 1px solid #114477;
	margin: 0;
	padding: 10px 14px 10px 14px
}

ul.css-menu-3 li a:hover {
	border-left: 1px solid #114477;
	border-right: 1px solid #114477
}

ul.css-menu-3 li a.selected {
	color: #fefefe;
	background: #bb0000;
	border: 1px #cc0000 solid;
	border-bottom: 1px solid #bb0000;
	border-left: 1px solid #770000;
	padding: 10px 14px 10px 14px
}
<
</style>
		</ul>
	</table>
	<marquee behavior="scroll" direction="left" style="color: #ffff00">Здесь
		могла бы быть Ваша реклама! Телефон для справок:+375(25)982-39-90</marquee>
</body>
</html>

