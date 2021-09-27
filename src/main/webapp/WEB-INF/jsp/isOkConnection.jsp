<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Dashboard</title>
    </head>

    <body>
     <c:if test="${!empty sessionScope.connectedPlayer}">
            <p>Bienvenue <c:out value="${sessionScope.connectedPlayer.prenom} "/> !</p>
     </c:if>

        <form method="GET" action="dashboard">
        <button type="submit" name="playerId" value="${connectedPlayer.id}">Accéder à mon tableau de bord</button>
        </form>

    </body>
</html>