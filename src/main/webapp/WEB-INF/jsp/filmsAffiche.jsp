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
                     <p>Tickets restants : <c:out value="${item.ticketsRestants}" /></p>
                   </div>
                </c:forEach></p>
             </div>

          <h3>Ajouter un film</h3>
              <form method="POST" action="addFilmToCinema">
                    <p>
                         <label for="film">Sélectionnez un film à ajouter</label><br />
                         <select name="idFilmToAdd" id="film">

                             <c:forEach items="${allFilms}" var="item">
                                 <option value="${item.id}"><c:out value="${item.titre}"/></option>
                             </c:forEach>
                         </select>
                     </p>
                  <input type="hidden" value="${idCinema}" name="idCinemaToAdd">
                  <input type="hidden" value="${nomCinema}" name="nomCinema" >
                  <input type="submit" value="Valider">
                  <c:if test="${!empty messageErreur}">
                    <p><c:out value="${messageErreur}" /></p>
                  </c:if>
              </form>
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