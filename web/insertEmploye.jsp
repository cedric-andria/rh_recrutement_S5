<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/materialize/css/materialize.min.css">
    <title>Insertion Employé</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col s12 m6 center">
                <form action="insertEmploye" method="post">
                    <div class="input-field">
                        <input type="text" name="nom" id="nom">
                        <label for="nom">Nom</label>
                    </div>
                    <div class="input-field">
                        <input type="text" name="prenom" id="prenom">
                        <label for="prenom">Prénom</label>
                    </div>
                    <div class="input-field">
                        <input type="date" name="dtn" id="dtn">
                        <label for="dtn">Date de naissance</label>
                    </div>
                    <div class="input-field">
                        <select name="sexe" id="sexe">
                            <option value="1">Homme</option>
                            <option value="0">Femme</option>
                        </select>
                        <label for="sexe">Sexe</label>
                    </div>
                    <div class="input-field">
                        <input type="email" name="mail" id="mail">
                        <label for="mail">Mail</label>
                    </div>

                    <button type="submit" class="btn">Valider</button>
                </form>
            </div>
        </div>
    </div>
    
    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>