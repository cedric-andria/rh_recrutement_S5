<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/materialize/css/materialize.min.css">
    <title>Contrat d'essaie</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col s12 m8 center">
                <form action="" method="post">
                    <div class="input-field">
                        <input type="date" name="debut" id="debut">
                        <label for="debut">Date début</label>
                    </div>
    
                    <div class="input-field">
                        <input type="date" name="fin" id="fin">
                        <label for="fin">Date fin</label>
                    </div>
    
                    <div class="input-field">
                        <input type="number" name="salaire" id="salaire">
                        <label for="salaire">Salaire</label>
                    </div>
    
                    <div class="input-field">
                        <input type="text" name="lieu_travail" id="lieu_travail">
                        <label for="lieu_travail">Lieu de Travail</label>
                    </div>

                    <button type="submit" class="btn">Valider</button>
                </form>
            </div>
        </div>
    </div>


    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>