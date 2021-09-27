<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Tableau de bord</title>
    </head>

    <body>
          <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>

       <!-- <p>Bonjour <c:out value="${playerLastName} "/><c:out value="${playerFirstName}" /> !</p> -->
       <h2>Mon tableau de bord</h2>

       <div>Mon Archipel</div>
       <c:if test="${empty messageNoArchipel}">
       <button type="submit" onclick="location.href='http://localhost:8080/archipel?playerId=${connectedPlayer.id}'">Accéder à mon Archipel</button>
       </c:if>
       <c:if test="${!empty messageNoArchipel}"><c:out value="${messageNoArchipel}" />
           <input type="submit" name="playerId" value="Créer mon archipel" onclick="location.href='http://localhost:8080/createArchipel?playerId=${connectedPlayer.id}'"/>

       </c:if>
    </body>
</html>