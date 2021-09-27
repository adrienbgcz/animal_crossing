<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Archipel</title>
    </head>

    <body>
          <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>

            <h2>Mon archipel</h2>
            <p><c:forEach items="${listeArchipels}" var="item">
               <p>Nom : <c:out value="${item.nom} " /></p>
               <p>Localisation : <c:out value="${item.localisation}" /></p>
            </c:forEach></p>

            <h3>Ajouter une île</h3>
            <form method="POST" action="createIle">
                <p>Nom : <label for="nomIle"><input type="text" name="nomIleEnvoye" id="nomIle" ></label></p>
                <p>Localisation : <label for="localisationIle"><input type="text" name="localisationIleEnvoye" id="localisationIle" ></label></p>
                <c:forEach items="${listeArchipels}" var="item">
                    <input type="hidden" name="idArchipelEnvoye" value="${item.id}">
                </c:forEach>
                <input type="hidden" name="idPlayer" value="${connectedPlayer.id}">
                <input type="submit" value="Valider" >
            </form>

            <br />

            <p><c:forEach items="${listeIles}" var="item">

             <c:if test="${item.id != idIleToUpdate}">
               <br />
               <p>Nom : <c:out value="${item.nom} " /></p>
               <p>Localisation : <c:out value="${item.localisation}" /></p>
               <br />
             </c:if>

             <c:if test="${item.id == idIleToUpdate}">
                <br />
                <form method="POST" action="updateIle">
                    <p>Nom : <input type="text" name="nomToUpdateEnvoye" value="<c:out value='${item.nom}' />" </p>
                    <p>Localisation : <input type="text" name="localisationToUpdateEnvoye" value="<c:out value="${item.localisation}" />"</p>
                    <c:forEach items="${listeArchipels}" var="item">
                        <input type="hidden" name="idArchipelEnvoye" value="${item.id}">
                    </c:forEach>
                     <input type="hidden" name="idPlayer" value="${connectedPlayer.id}">
                     <input type="hidden" name="idIleToUpdate" value="${idIleToUpdate}">
                     <input type="submit" value="Valider" >
                    <br />
                </form>
             </c:if>
            </c:forEach></p>



    </body>
</html>