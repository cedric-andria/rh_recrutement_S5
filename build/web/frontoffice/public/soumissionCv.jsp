<%-- 
    Document   : soumissionCv
    Created on : 2 oct. 2023, 10:41:15
    Author     : P14A-10-Cedric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Diplome, model.Experience, model.Langue"%>
<% Diplome[] tabdiplome = (Diplome[])request.getAttribute("liste_diplome"); %>
<% Langue[] tablangue = (Langue[])request.getAttribute("liste_langue"); %>
<% Experience[] tabexperience = (Experience[])request.getAttribute("liste_experience"); %>
<% String id_poste = (String)request.getAttribute("id_poste"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Soumission de CV</h3>
        <form method="POST">
            <label>Niveau d'education : </label>
            <select name="id_diplome">
                <% for (Diplome diplome : tabdiplome) { 
                %>
                <option value="<%=diplome.getId() %>"><%=diplome.getNom() %></option>
                <% 
                    }
                %>
            </select>
            <label>Langues : </label><br/>
            <% for (Langue langue : tablangue) { 
            %>
                <label><%=langue.getNom() %></label><input name=type="checkbox" value="<%=langue.getId() %>">
            <% 
                }
            %>
            <select name="id_experience">
                <% for (Experience experience : tabexperience) { 
                %>
                <option value="<%=experience.getId() %>"><%=experience.getDebut()%> - <%=experience.getFin() %> ans</option>
                <% 
                    }
                %>
            </select>
            <input type="text" readonly="true" name="id_poste" value="<%=id_poste%>">
            <label>Etranger : </label>
            <input type="radio" value="0" name="resident">
            <label>Resident : </label>
            <input type="radio" value="1" name="resident">
        </form>
    </body>
</html>
