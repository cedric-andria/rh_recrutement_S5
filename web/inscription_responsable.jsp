<%@ page import="model.Service"  %>
<%@ page import="java.util.Vector" %>
<%@ page import="util.Model" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Inscription model.Responsable</title>
</head>
<body>
    <h1>Inscription model.Responsable</h1>
    <form action="inscription" method="post">
        <label for="nom">
            <input type="text" placeholder="nom" name="nom" id="nom">
        </label>
        <label for="mdp">
            <input type="password" placeholder="mot de passe" name="mdp" id="mdp">
        </label>
        <label for="service">
            <select name="service" id="service">
                <%
                    Vector<Model> models;
                    try {
                        models = new Service().select();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    for (Model model : models) {
                        Service service = (Service) model; %>
                        <option value="<% out.print(service.getId()); %>">
                            <% out.print(service.getNom()); %>
                        </option>
                <% } %>
            </select>
        </label>
        <button type="submit">
            S'inscrire
        </button>
    </form>
</body>
</html>