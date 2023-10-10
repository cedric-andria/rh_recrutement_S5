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
    <title>Résultats Test</title>
</head>
<body>
    <%
        Vector<ResultatTest> result = (Vector<ResultatTest>)request.getAttribute("resultat");
    %>

    <%
        for(int i = 0; i < result.size(); i++)
        {
    %>
            <p><% out.print(result.get(i).getNom() + " " + result.get(i).getPrenom()); %></p>
    <%
        }

    %>

    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>