<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Création Archipel</title>
    </head>

    <body>
      <p>Session de <c:out value="${sessionScope.connectedPlayer.prenom} "/><c:out value="${sessionScope.connectedPlayer.nom }" /></p>

      <h2>Créer mon archipel</h2>
        <form method="POST" action="createArchipel">
            <p>Nom : <label for="nomArchipel"><input type="text" name="nomArchipelEnvoye" id="nomArchipel" ></label></p>
            <p>Localisation : <label for="localisationArchipel"><input type="text" name="localisationArchipelEnvoye" id="localisationArchipel" ></label></p>
            <input type="hidden" name="idJoueurEnvoye" value="${connectedPlayer.id}"></label></p>
            <input type="submit" value="Valider">
        </form>



    </body>
</html>