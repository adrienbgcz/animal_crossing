<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Ile</title>
    </head>

    <body>
          <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>

          <h2>Ile <%= request.getParameter("nomIle") %></h2>

            <div class="cardsContainer">
                <a href="http://localhost:8080/batiments?idIle=<%= request.getParameter("idIle") %>&nomIle=<%= request.getParameter("nomIle") %>&localisationIle=<%= request.getParameter("localisationIle") %>"><div class="card">Batiments</div></a>

                <a href="http://localhost:8080/espacesNaturels?idIle=<%= request.getParameter("idIle") %>"><div class="card">Espaces Naturels</div></a>
            </div>

        <style>
           .card {
           border: solid;
           width: 200px;
           margin: 20px;
           }

           .card:hover {
           cursor: pointer;

           }

           .cardsContainer {
            display: flex;
            flex-wrap: wrap;
           }

           </style>

    </body>
</html>