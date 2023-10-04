<%@ page import="java.util.Vector" %>
<%@ page import="model.Service" %>
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
    <h1>Inscription model.Responsable</h1>
    <form action="traitementInscription" method="post">
        <label>
            <input type="text" placeholder="Nom" name="nom">
        </label>
        <label>
            <input type="password" name="mdp" placeholder="Mot de passe">
        </label>
        <label for="id_service">
            <select name="id_service" id="id_service">
                <%
                    Vector<Service> services = (Vector<Service>) request.getAttribute("services");
                    for (Service service : services) { %>
                        <option value=<% out.println(service.getId()); %>>
                            <% out.println(service.getNom()); %>
                        </option>
                <% } %>
            </select>
        </label>
        <button type="submit">S'inscrire</button>
    </form>
</body>
</html>