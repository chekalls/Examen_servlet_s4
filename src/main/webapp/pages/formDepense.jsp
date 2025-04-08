<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itu.Projet.model.Prevision" %>

<%
    ArrayList<Prevision> listePrevisions = (ArrayList<Prevision>) request.getAttribute("listePrevisions");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Depense</title>
</head>
<body>
    <form action="inserer_depense" method="post">
        <div>
            <label for="prevision">prevision</label>
            <select name="prevision" id="prevision">
                <% for(Prevision prevision : listePrevisions ) {%>
                    <option value="<%= prevision.getId() %>"><%= prevision.getLibelle() %></option>
                <% }%>
            </select>
        </div>

        <div>
            <label for="montant">montant : </label>
            <% if(request.getAttribute("error")!=null) {%>
                <p>montant trop elevee</p>
            <% } %>
            <input type="number" name="montant" id="montant">
        </div>

        <div>
            <input type="submit" value="valider">
        </div>
    </form>
</body>
</html>