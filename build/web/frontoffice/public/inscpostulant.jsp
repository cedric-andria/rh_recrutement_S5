<%-- 
    Document   : inscpostulant
    Created on : 29 sept. 2023, 14:34:37
    Author     : P14A-10-Cedric
--%>

<%
    String erreur = "Valeurs manquantes ou non-valides : ";

    erreur += " " + request.getAttribute("erreur");
    if(request.getAttribute("erreur")==null)
    {
        erreur = "";
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Postulant</title>
    </head>
    <body>
        <h2>Inscription Postulant</h2>
        <form action="InscPostulantServlet" method="POST">
            <h2><%= erreur %></h2>
            <input name="nom" type="text" maxlength="30" placeholder="nom" required>
            <input name="prenom" type="text" maxlength="40" placeholder="prenom" required>
            <label for="datenaissance">datenaissance</label>
            <input id="datenaissance" name="datenaissance" type="date" required>
            <span id="birthdateError" style="color: red;"></span>
            <br>
            <label for="male">Male</label>
            <input name="sexe" type="radio" value="1" checked>
            <label for="female">Female</label>
            <input name="sexe" type="radio" value="0">
            <input type="text" name="mail" placeholder="adresse e-mail" required>
            <input type="password" name="mdp" placeholder="mot de passe" required>
            <input type="submit" value="S'inscrire">
        </form>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Get a reference to the date input and error message span
                const birthdateInput = document.getElementById("datenaissance");
                const birthdateError = document.getElementById("birthdateError");
    
                // Attach an event listener to the input element
                birthdateInput.addEventListener("change", function () {
                    const selectedDate = new Date(birthdateInput.value);
                    const currentDate = new Date();
                    const minDate = new Date(currentDate);
                    minDate.setFullYear(currentDate.getFullYear() - 18);
    
                    if (selectedDate < minDate) {
                        birthdateError.textContent = "";
                    } else {
                        birthdateError.textContent = "Vous devez avoir au moins 18 ans";
                        birthdateInput.value = "";
                    }
                });
            });
        </script>
    </body>

    
</html>
