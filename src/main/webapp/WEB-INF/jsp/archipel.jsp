<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>
    <title>Archipel</title>
</head>

<body>
    <p>Session de
        <c:out value="${sessionScope.connectedPlayer.prenom} " />
        <c:out value="${sessionScope.connectedPlayer.nom }" />
    </p>

    <h2>Mon archipel</h2>
    <p>
        <c:forEach items="${listeArchipels}" var="item">
            <p>Nom :
                <c:out value="${item.nom} " />
            </p>
            <p>Localisation :
                <c:out value="${item.localisation}" />
            </p>
        </c:forEach>
    </p>

    <h3>Ajouter une île</h3>
    <form method="POST" action="createIle">
        <p>Nom : <label for="nomIle"><input type="text" name="nomIleEnvoye" id="nomIle"></label></p>
        <p>Localisation : <label for="localisationIle"><input type="text" name="localisationIleEnvoye"
                    id="localisationIle"></label></p>
        <c:forEach items="${listeArchipels}" var="item">
            <input type="hidden" name="idArchipelEnvoye" value="${item.id}">
        </c:forEach>
        <input type="hidden" name="idPlayer" value="${connectedPlayer.id}">
        <input type="submit" value="Valider">
    </form>

    <br />

    <c:if test="${empty listeIles}"><p>Vous ne possédez aucune île actuellement</p></c:if>

    <div class="cardsContainer">
        <p>
            <c:forEach items="${listeIles}" var="item">

                <a
                    href="http://localhost:8080/ile?idIle=${item.id}&nomIle=${item.nom}&localisationIle=${item.localisation}">
                    <div class="ileCard">

                        <p>Nom :
                            <c:out value="${item.nom} " />
                        </p>
                        <p>Localisation :
                            <c:out value="${item.localisation}" />
                        </p>

                        <form method="POST" action="displayUpdateIle">
                            <input type="hidden" name="idIle" value="${item.id}">
                            <input type="hidden" name="idPlayer" value="${connectedPlayer.id}">
                            <input type="submit" value="Modifier">
                        </form>

                        <form method="POST" action="deleteIle">
                            <input type="hidden" name="idIle" value="${item.id}">
                            <input type="hidden" name="idPlayer" value="${connectedPlayer.id}">
                            <input type="submit" value="Supprimer" onclick="displayConfirm()">
                        </form>
                        <br />
                    </div>
                </a>

            </c:forEach>
        </p>
    </div>

    <script>
        function displayConfirm() {
            let resultat = window.confirm("Souhaitez-vous vraiment supprimer cette île ?");
        }
    </script>

    <style>
        .ileCard {
            border: solid;
            width: 200px;
            margin: 20px;
        }

        .ileCard:hover {
            cursor: pointer;

        }

        .cardsContainer {
            display: flex;
            flex-wrap: wrap;
        }
    </style>



</body>

</html>