<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.*" %>
<%@ page import = "java.util.Vector" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/materialize/css/materialize.min.css">
    <title>Détails employé</title>
</head>
<body>

    <%
        Vector<Avantage> allAvantage = (Vector<Avantage>)request.getAttribute("allAvantages");
    %>

    <div class="container">
        <div class="row">
            <div class="col s12 m8 center">
                <form action="insertDetailsEmploye" method="post">
                    <div class="input-field">
                        <input type="text" name="adresse" id="adresse">
                        <label for="adresse">Adresse</label>
                    </div>
    
                    <div class="input-field">
                        <input type="text" name="pere" id="pere">
                        <label for="pere">Nom et prénom du pére</label>
                    </div>
    
                    <div class="input-field">
                        <input type="text" name="mere" id="mere">
                        <label for="mere">Nom et prénom du mére</label>
                    </div>
    
                    <div class="input-field">
                        <input type="text" name="cin" id="cin">
                        <label for="cin">Numéro CIN</label>
                    </div>

                    <div class="input-field">
                        <blockquote>
                            <h5 style="font-weight: bold;">Les Avantages en nature</h5>
                        </blockquote>

                        <%
                            for(int i = 0; i < allAvantage.size(); i++)
                            {
                                String name = "rep"+i;
                        %>
                            <p>
                                <label>
                                    <input type="checkbox" name="<% out.print(name); %>" value="<% out.print(allAvantage.get(i).getId()); %>">
                                    <span><% out.print(allAvantage.get(i).getNom()); %></span>
                                </label>
                            </p>
                        <%  } %>
                    </div>

                    <button type="submit" class="btn">Valider</button>
                </form>
            </div>
        </div>
    </div>

    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>