<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MENU DA VAN</title>
</head>
<body>
	<c:choose>
		<c:when test="${user eq null }">
			<jsp:forward page="erroLogin.jsp" />
		</c:when>
		<c:otherwise>
			<p>Bem-vindo ${user.nome}</p>
		</c:otherwise>
	</c:choose>	
	
	<table>
		<c:forEach var="lugares" items="${lugares}" varStatus="num">



			<c:if test="${num.count%2!=0 }">
				<tr>
					<c:if test="${lugares eq 'true'}">
						<td align="center" bgcolor="red">${num.count}</td>
					</c:if>
					<c:if test="${lugares eq 'false'}">
						<td align="center" bgcolor="green">${num.count} </td>
					</c:if>
			</c:if>
			<c:if test="${num.count%2==0 }">
					<c:if test="${lugares eq 'true'}">
						<td align="center" bgcolor="red">${num.count}</td>
					</c:if>
					<c:if test="${lugares eq 'false'}">

						<td align="center" bgcolor="green">${num.count}</td>

					</c:if>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<b>Para comprar passagem digite o numero:</b></br>
	<form action="comprarPassagem.do" method="post">
		<input type="text" name="num"></br>
		<input type="submit">
	</form>
	<b> Para cancelar a passagem clique no botao:</b></br>
	<form action="cancelarPassagem.do" method="post">
		<input type="submit">
	</form>
	
</body>
</html>