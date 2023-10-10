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
    <title>Question Test</title>
</head>
<body>
    <%
        Vector<QuestionTest> allQt = (Vector<QuestionTest>)request.getAttribute("qtByTest");
    %>
    
    <div class="container">
        <div class="row">
            <div class="section left col s12 m6">
                <form action="questionReponseTest" method="get">

                    <input type="hidden" name="nbRep" id="nbRep" value="">

                    <div class="row">
                        <div class="col s12 m9">
                            <div class="input-field">
                                <textarea name="question" id="question" class="materialize-textarea"></textarea>
                                <label for="question">Question</label>
                            </div>
                        </div>
                        <div class="col s12 m3">
                            <div class="input-field">
                                <input type="number" name="coeff" id="coeff">
                                <label for="coeff">Coefficient</label>
                            </div>
                        </div>
                    </div>

                    <!-- Réponses -->
                    <div class="row">
                        <div class="col s12 m6">
                            <div class="input-field">
                                <input type="text" name="reponse0" id="reponse0">
                                <label for="reponse0">Reponse</label>
                            </div>
                        </div>

                        <div class="input-field col s12 m6">
                            <select name="etat0" id="etat0">
                                <option value="1">Vrai</option>
                                <option value="0">Faux</option>
                            </select>
                            <label for="etat0">Etat</label>
                        </div>
                    </div>
                    
                    <div id="container-reponse">
                        <!-- ajout des input du réponse -->
                    </div>

                    <div class="container right">
                        <span class="btn-floating right orange darken-2" id="ajouterComposants">
                            <i class="material-icons">/icons/add</i>
                        </span>
                    </div>
                    
                    <div class="container section right">
                        <button type="submit" class="btn waves-effect right">Créer</button>
                    </div>
                </form>
            </div>

            <!-- Questions - Réponses insérer -->
            <div class="section col s12 m5 offset-l1">
                <h5>Questions - Réponses insérer</h5>
                <%
                    try{
                        for(int j = 0; j < allQt.size(); j++)
                        {
                            ReponseTest rt = new ReponseTest();
                            Vector<ReponseTest> allRt = rt.getReponseTestByQuestion(null, allQt.get(j).getId());
                    %>
                        <div class="container section pb-20">
                            <blockquote style="border-color: teal;">
                                <h6 style="font-weight: bold;"><% out.print(allQt.get(j).getQuestion()); %></h6> 
                    <%
                                for(int k = 0; k < allRt.size(); k++)
                                {
                    %>              
                                    <blockquote style="border-color: red;"> 
                                        <%
                                            if(allRt.get(k).getEtat() == 1){ %>
                                                <span class="chip green">Vrai</span> 
                                        <%  } else { %>
                                                <span class="chip red">Faux</span>  
                                        <% }%>

                                        <% out.print(allRt.get(k).getReponse()); %>
                                    </blockquote>
                    <%           } %>
                            </blockquote>
                        </div>
                    <%
                        }
                    } catch (Exception e){
                        out.print(e);
                    } %>
                    
            </div>
        </div>
    </div>

    <script src="./assets/materialize/js/materialize.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems);
        })
    </script>

    <script>

        var i = 0;

        // Sélectionnez le bouton et l'élément contenant les composants
        var boutonAjouter = document.getElementById("ajouterComposants");
        var container = document.getElementById("container-reponse");

        // Fonction pour ajouter les composants
        function ajouterComposants() {
            i = i + 1;
            // Créez un nouvel élément div avec la classe "row"
            var nouvelleRow = document.createElement("div");
            nouvelleRow.classList.add("row");

            // Créez un nouvel élément div
            var nouvelElement = document.createElement("div");
            nouvelElement.classList.add("col", "s12", "m6");

            // Créez un champ de texte
            var inputField = document.createElement("div");
            inputField.classList.add("input-field");

            var inputElement = document.createElement("input");
            inputElement.type = "text";
            inputElement.name = "reponse"+i;
            inputElement.id = "reponse"+i;

            var labelElement = document.createElement("label");
            labelElement.htmlFor = "reponse"+i;
            labelElement.textContent = "Réponse";

            inputField.appendChild(inputElement);
            inputField.appendChild(labelElement);

            // Créez une liste déroulante
            var selectField = document.createElement("div");
            selectField.classList.add("input-field", "col", "s12", "m6");

            var selectElement = document.createElement("select");
            selectElement.name = "etat"+i;
            selectElement.id = "etat"+i;

            var option1 = document.createElement("option");
            option1.value = "1";
            option1.textContent = "Vrai";

            var option2 = document.createElement("option");
            option2.value = "0";
            option2.textContent = "Faux";

            selectElement.appendChild(option1);
            selectElement.appendChild(option2);

            var labelSelect = document.createElement("label");
            labelSelect.htmlFor = "etat"+i;
            labelSelect.textContent = "État";

            selectField.appendChild(selectElement);
            selectField.appendChild(labelSelect);

            // Ajoutez le champ de texte et la liste déroulante au nouvel élément
            nouvelElement.appendChild(inputField);

            // Ajoutez le nouvel élément à la nouvelle row
            nouvelleRow.appendChild(nouvelElement);
            nouvelleRow.appendChild(selectField);

            // Ajoutez la nouvelle row au conteneur
            container.appendChild(nouvelleRow);

            var nbRep = document.getElementById("nbRep");
            nbRep.value = i;

            var instances = M.FormSelect.init(selectElement);
        }

        // Associez la fonction à l'événement de clic du bouton
        boutonAjouter.addEventListener("click", ajouterComposants);
    </script>
</body>
</html>