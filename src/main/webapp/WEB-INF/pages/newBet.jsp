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

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Новая ставка</title>
</head>
<body background="/img/background.jpg">
<table width=100%>
		<tr>
			<td align="center"><a href="main?page=theHorseBetting"><img
					src="/img/horsebetting.png" /></a></td>
			<td><img align="right" src="/img/logotipe.jpg" width="200"></img>
			<td>
		</table>

	<p align="center"><font size="10" color="#ffff00">Сделайте новую ставку</font></p>
	
	<tr valign="top">
			<td>
				<table align="center" width="900" border="2" bgcolor="#F0F8FF">
					<tr align="center">
						<td>N</td>
						<td>Horse List</td>
						<td>Time</td>
						<td>Destination</td>
						<td>Amount</td>
						<td>Delete</td>
						<td>Status</td>
						<%
							IRaceDAO raceDAO = BeanFacade.getRaceDAO();
							List<Race> racesOK = raceDAO.getAllActiveRace();
							
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
								<input type="text" name="coefficent" size="20">
							</form>
						</td>
						<td>
							<form>
								<button>Do bet</button>
								<input name="action" type="hidden" value="addBet">
							</form>
						</td>
						<td><%=racesOK.get(i).getStatus()%></td>
						<%
							}
						%>
						
					
				</table>
			</td>


		</tr>

	</table>
				
								
</body>
</html>