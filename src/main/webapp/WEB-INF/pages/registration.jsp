<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>
<body text="orange" background="/img/background.jpg">
	<table width=100%>
		<tr>
			<td align="center"><a href="main?page=theHorseBetting"><img
					src="/img/horsebetting.png" /></a></td>
			<td><img align="right" src="/img/logotipe.jpg" width="200"></img>
			<td>
		<tr>
			<td align="center">
				<table align="center">

					<b><font size="8" color="red">Регистрация</font></b>
					</p>
					<form>
						<br>
						<p>
							<b>Введите Ваш Логин:</b><br> <input type="text" name="login" size="40">
						</p>
						<p>
							<b>Введите Ваш Пароль:</b><br> <input type="text" name="password" size="40">
						</p>
						<p>
							<b>Подтвердите Пароль:</b><br> <input type="text" size="40">
						</p>
						<p>
							<b>Введите Ваше имя:</b><br> <input type="text" name="name" size="40">
						</p>
						<p>
							<b>Введите Вашу Фамилию:</b><br> <input type="text" name="lastname"
								size="40">
						</p>
						<p>
							<b>Введите Ваш Номер Телефона:</b><br> <input type="text" name="telephone"
								size="40">
						</p>
						<p>
							<b>Укажите свой электронный ящик:</b><br> <input type="text" name="email"
								size="40">
						</p>
						<input type="checkbox" name="browser" value="ie"> <FONT
							color="orange">С</FONT> <a href="main?page=rule"><FONT
							color="green">правилами</FONT></a><FONT color="orange">
							согласен</FONT><Br>

						<p>
							<button>Зарегистрироваться</button><input name="action" type="hidden" value="addReg">
					</form></body>
</html>