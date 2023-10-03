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
    <title>Annonces</title>
</head>
<style>
    .text-bold {
        font-weight: bold;
    }

    .text-chip {
        font-size: 26px;
    }
</style>
<body>
    <%
        Vector<Annonce> allAnnonce = (Vector<Annonce>)request.getAttribute("annonce");
    %>
    <header>
        <nav class="nav-wrapper teal darken-2">
            <div class="container">
                <div class="brand-logo">
                    <span>E-RECRUT</span> 
                </div>
                <div class="right">
                    <ul>
                        <li><a href="">Accueil</a></li>
                        <li><a href="">Annonces</a></li>
                        <li><a href="">Résultats</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="container">
        <div class="section">
            <div class="center">
                <h2>ANNONCES</h2>
            </div>
            <div class="row">
                <%
                    for(int i = 0; i < allAnnonce.size(); i++){
                        Annonce a = allAnnonce.get(i);
                %>
                    <div class="col s6 m6 section">
                        <div class="card" style="border-radius: 10px;">
                            <div class="card-content">
                                <div class="center">
                                    <span class="chip text-bold text-chip"><% out.print(a.getNom_poste()); %></span>
                                </div>
                                <blockquote>
                                    Année d'expérience requise: <span class="text-bold"><% out.print(a.getDebut_exp()); %> - <% out.print(a.getFin_exp()); %> ans</span>
                                </blockquote> 
                                
                                <blockquote>
                                    Maitrise du langue: <span class="text-bold"><% out.print(a.getLangue()); %></span>
                                </blockquote>
                                
                                <blockquote>
                                    Diplome: <span class="text-bold"><% out.print(a.getDiplome()); %></span>
                                </blockquote>
                                <div class="">
                                    <button class="btn waves-effect">Postuler</button>
                                </div>
                            </div>
                        </div>
                    </div>

                <%  } %>
            </div>
        </div>
    </div>
    
    <script src="./assets/materialize/js/materialize.min.js"></script>

</body>
</html>