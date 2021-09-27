<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Batiments</title>
    </head>

    <body>
          <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>

          <c:if test="${empty nomIleAfterCreation}"><h2>Ile <%= request.getParameter("nomIle") %></h2></c:if>
          <c:if test="${!empty nomIleAfterCreation}"><h2>Ile <c:out value="${nomIleAfterCreation}"/></h2></c:if>

            <h3>Mes bâtiments</h3>
            <c:if test="${!empty listeBatiments}">
                <div class="cardsContainer">
                   <p><c:forEach items="${listeBatiments}" var="item">

                          <c:if test="${item.id != idBatimentToUpdate}">
                              <div class="card">
                                <p>Nom : <c:out value="${item.nom} " /></p>
                                <p>Type : <c:out value="${item.libelle}" /></p>
                              </div>
                          </c:if>

                      <c:if test="${item.id == idBatimentToUpdate}">
                          <div class="card">
                          <form method="POST" action="updateBatiment">
                              <p>Nom : <input type="text" value="<c:out value='${item.nom}' />" name="nomBatimentToUpdate" /></p>
                              <label for="typeBatiment">Choisissez un type de bâtiment</label><br />
                                 <select name="idTypeBatimentToUpdate" id="typeBatiment">
                                     <option value="1">Magasin</option>
                                     <option value="2">Ecole</option>
                                 </select>
                                 <input type"hidden" value="idBatimentToUpdate">
                              <input type="submit" value="Valider" >
                           </form>
                          </div>
                      </c:if>
                   </c:forEach></p>
                </div>
            </c:if>

            <h3>Ajouter un bâtiment</h3>
                <form method="POST" action="createBatiment">
                    <p>Nom : <label for="nomBatiment"><input type="text" name="nomBatimentEnvoye" id="nomBatiment"></label></p>
                    <p>
                       <label for="typeBatiment">Choisissez un type de bâtiment</label><br />
                       <select name="idTypeBatimentEnvoye" id="typeBatiment">
                           <option value="1">Magasin</option>
                           <option value="2">Ecole</option>
                       </select>
                    </p>
                    <input type="hidden" name="idIle" value="<%= request.getParameter("idIle") %>">
                    <input type="submit" value="Valider">
                </form>



            <c:if test="${empty listeBatiments}">
                <p>Vous ne possédez aucun batiment actuellement</p>
            </c:if>

            <h3>Mes cinemas</h3>
            <c:if test="${!empty listeCinemas}">
                <div class="cardsContainer">
                   <p><c:forEach items="${listeCinemas}" var="item">
                      <div class="card">
                        <p>Nom : <c:out value="${item.nom} " /></p>
                        <p>Nombre de places : <c:out value="${item.nombrePlaces}" /></p>
                        <form methode="POST" action="getFilmsByCinema">
                            <input type="hidden" value="${item.id}" name="idCinema" >
                            <input type="hidden" name="idIle" value="<%= request.getParameter("idIle") %>">
                            <input type="hidden" value="${item.nom}" name="nomCinema" >
                            <input type="submit" value="Films à l'affiche" >
                        </form>
                      </div>
                   </c:forEach></p>
                </div>
            </c:if>

            <c:if test="${empty listeCinemas}">
                <p>Vous ne possédez aucun cinema actuellement</p>
            </c:if>


            <h3>Ajouter un cinema</h3>
                <form method="POST" action="createCinema">
                    <p>Nom : <label for="nomCinema"><input type="text" name="nomCinemaEnvoye" id="nomCinema"></label></p>
                    <p>Nombre de places : <label for="nombrePlaces"><input type="text" name="nombrePlacesEnvoye" id="nombrePlaces"></label> </p>
                    <input type="hidden" name="idIle" value="<%= request.getParameter("idIle") %>">
                    <input type="submit" value="Valider">
                </form>


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