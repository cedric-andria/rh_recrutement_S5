<%@ page import="java.util.Vector" %>
<%@ page import="model.Poste" %>
<%@ page import="model.Diplome" %>
<%@ page import="model.Langue" %>
<%@ page import="model.Experience" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Document</title>
</head>
<body>
    <form action="traitementInsertionCritere" method="get">
        <label>
            <input type="text" name="poste" placeholder="poste">
        </label>
        <label for="id_diplome">
            <select name="id_diplome" id="id_diplome">
                <%
                    Vector<Diplome> diplomes = (Vector<Diplome>) request.getAttribute("diplomes");
                    for (Diplome diplome : diplomes) { %>
                        <option value=<% out.println(diplome.getId()); %>>
                            <% out.println(diplome.getNom()); %>
                        </option>
                <% } %>
            </select>
        </label>
        <label>
            <input type="text" name="coeff_diplome" placeholder="coeff_diplome">
        </label>
        <label for="id_langue">
            <select name="id_langue" id="id_langue">
                <%
                    Vector<Langue> langues = (Vector<Langue>) request.getAttribute("langues");
                    for (Langue langue : langues) { %>
                        <option value=<% out.println(langue.getId()); %>>
                            <% out.println(langue.getNom()); %>
                        </option>
                <% } %>
            </select>
        </label>
        <label>
            <input type="text" name="coeff_langue" placeholder="coeff_langue">
        </label>
        <label for="id_experience">
            <select name="id_experience" id="id_experience">
                <% Vector<Experience> experiences = (Vector<Experience>) request.getAttribute("experiences");
                    for (Experience experience : experiences) { %>
                        <option value=<% out.println(experience.getId()); %>>
                            <% out.println(experience.getDebut() + " - " + experience.getFin()); %>
                        </option>
                <% } %>
            </select>
        </label>
        <label>
            <input type="text" name="coeff_experience" placeholder="coeff_experience">
        </label>
        <label for="sexe">
            <select name="sexe" id="sexe">
                <option value="1">
                    Homme
                </option>
                <option value="0">
                    Femme
                </option>
            </select>
        </label>
        <button type="submit">
            Validate
        </button>
    </form>
</body>
</html>
