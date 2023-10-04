<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/materialize/css/materialize.min.css">
    <title>Login Postulant</title>
</head>
<body>
    
    <div class="container">
        <div class="section">
            <div class="row">
                <div class="col m4 offset-l4">
                    <form action="verifLogPostulant" method="post">
                        <div class="input-field">
                            <input type="email" id="mail" name="mail">
                            <label for="mail">Votre e-mail</label>
                        </div>
                        <div class="input-field">
                            <input type="password" name="mdp" id="mdp">
                            <label for="mdp">Votre mot de passe</label>
                        </div>
                        <div class="right">
                            <button type="submit" class="btn waves-effect">Soumettre</button>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>
    </div>

    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>