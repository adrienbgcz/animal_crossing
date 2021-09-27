<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
    <title>Page de connection</title>
    </head>

    <body>
       <h2>Connexion</h2>
          <form method="POST" action="connection">
              <p>Mail : <label for="mailJoueur"><input type="text" name="mailJoueurEnvoye" id="mailJoueur"></label></p>
              <input type="submit" value="Valider" >
          </form>

           <p><c:out value="${messageErreur}" /></p>
    </body>
</html>