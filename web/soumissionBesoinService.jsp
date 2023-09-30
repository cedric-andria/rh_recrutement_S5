<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import = "modele.*" %>
<%@ page import = "java.util.Vector" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/materialize/css/materialize.min.css">
    <title>Besoin Service</title>
</head>
<body>
    <%
        int status = (int)request.getAttribute("status");
        Vector<Poste> allPoste = (Vector<Poste>)request.getAttribute("poste");
    %>
    <div class="container">
        <div class="section">
            <div class="center">
                <h3 class="title">Besoin du service</h3>
            </div>
            <div class="row">
                <div class="col m4 offset-l4">
                    <form action="insertBesoinService" method="get">
                        <div class="input-field">
                            <select name="idPoste" id="idPoste">
                                <option value="" disabled selected>Choisissez le Poste</option>
                                <%
                                    for(int i = 0; i < allPoste.size(); i++) { 
                                        Poste p = allPoste.get(i);
                                %>
                                        <option value="<% out.print(p.getId()); %>"><% out.print(p.getNom()); %></option>
                                <%  } %>    
                            </select> 
                            <label for="idPoste">Poste</label>
                        </div>
                        <div class="input-field">
                            <input type="number" name="nbr" id="nbr">
                            <label for="nbr">Nombre de candidat nécessaire</label>
                        </div>
                        <div class="input-field">
                            <input type="number" name="horaire" id="horaire">
                            <label for="horaire">Volume horaire</label>
                        </div>
                        <div class="center">
                            <button type="submit" class="btn waves-effect">Soumettre</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="./assets/materialize/js/materialize.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function(){
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems);
        });

        var status = '<%= status %>';
        console.log(status);
        if(status == 1){
            M.toast({html: 'Ajouter avec success.', classes: 'rounded green lighten-1'});
        } else if(status == 0){
            M.toast({html: 'Une erreur s\'est produit.Réessayez', classes: 'rounded red darken-3'});
        }
    </script>

</body>
</html>