<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Page d'inscription</title>
    </head>

    <body>
                                       <!-- <h1>Liste joueurs actuels</h1>
                                       <p><c:forEach items="${listeJoueurs}" var="item">
                                        <p><c:out value="${item.nom} " /><c:out value="${item.prenom} " /><c:out value="${item.mail}" /></p>
                                       </c:forEach></p> -->

       <h2>Inscription</h2>
          <form method="POST" action="createPlayer">
              <p>Nom : <label for="nomJoueur"><input type="text" name="nomJoueurEnvoye" id="nomJoueur" value="${nomJoueurAffiche}"></label></p>
              <p>Prénom : <label for="prenomJoueur"><input type="text" name="prenomJoueurEnvoye" id="prenomJoueur" value="${prenomJoueurAffiche}"></label></p>
              <p>Mail : <label for="mailJoueur"><input type="text" name="mailJoueurEnvoye" id="mailJoueur"></label></p>
              <input type="submit" value="Valider">
          </form>
              <p><c:out value="${messageErreur}" /></p>

          <input type="submit" onclick="location.href='http://localhost:8080/connectionPlayer'" value="Connexion">
    </body>
</html>