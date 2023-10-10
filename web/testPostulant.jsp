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
    <title>Test Postulant</title>
</head>
<body>

    <%
        Vector<QuestionTest> allQt = (Vector<QuestionTest>)request.getAttribute("qtByPoste");
    %>
    
    <div class="container">
        <div class="center">
            <h3>Test pour le poste: bla</h3>        
        </div>

        <form action="soumissionReponsePostulant" method="post">

        <%
            for(int i = 0; i < allQt.size(); i++){
                ReponseTest rt = new ReponseTest();
                Vector<ReponseTest> allRt = rt.getReponseTestByQuestion(null, allQt.get(i).getId_question());
        %>
                <div class="row">
                    <div class="col s12 m12">
                        <div class="section">
                            <div class="input-field">
                                <blockquote style="border-color: teal;">
                                    <h5 style="font-weight: bold;"><% out.print(allQt.get(i).getQuestion()); %></h5>
                                </blockquote>
                    <%
                                for(int k = 0; k < allRt.size(); k++)
                                {
                                    String name = "rep"+allRt.get(k).getId();
                    %>              
                                <p>
                                    <label>
                                        <input type="checkbox" name="<% out.print(name); %>" value="<% out.print(allRt.get(k).getId()); %>">
                                        <span><% out.print(allRt.get(k).getReponse()); %></span>
                                    </label>
                                </p>
                            <%  } %>
                            </div>
                        </div>
                    </div>
                </div>
        <%  } %>

        <div class="center">
            <button type="submit" class="btn waves-effect">Valider</button>
        </div>
        </form>
    </div>

    <script src="./assets/materialize/js/materialize.min.js"></script>
</body>
</html>
