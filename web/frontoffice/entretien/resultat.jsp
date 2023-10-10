<%@ page import="java.util.Vector" %>
<%@ page import="model.entretien.Resultat" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <form action="traitementEmbauche" method="get">
        <%
            Vector<Resultat> resultats = (Vector<Resultat>) request.getAttribute("resultats"); %>
            <input type="hidden" value="<% out.print(resultats.get(0).getId_entretien()); %>" name="id_entretien">
            <% for (Resultat resultat : resultats) { %>
                <label for="id_postulants">
                    <% out.print(resultat.getId_postulant()); %>
                </label>
                <input type="checkbox" name="id_postulants" id="id_postulants" value="<% out.print(resultat.getId_postulant()); %>">
            <% }
        %>
        <button type="submit">Embaucher</button>
    </form>
</body>
</html>