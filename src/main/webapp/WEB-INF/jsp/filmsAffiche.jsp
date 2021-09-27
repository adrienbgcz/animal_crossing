<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Films à l'affiche</title>
    </head>

    <body>
          <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>
             <h2>Films à l'affiche au cinéma <c:out value="${nomCinema}"/></h2>

             <div class="cardsContainer">
                 <p><c:forEach items="${listeFilms}" var="item">
                   <div class="card">
                     <p>Nom : <c:out value="${item.titre} " /></p>

                   </div>
                </c:forEach></p>
             </div>
    </body>

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
</html>