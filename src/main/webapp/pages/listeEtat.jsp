<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itu.Projet.model.Etat" %>
<% 
    ArrayList<Etat> listeEtat = (ArrayList<Etat>) request.getAttribute("listeEtat");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,tr,td,th{
            border: 1px solid black;
            border-collapse:collapse;            
        }    </style>
</head>
<body>
    <table>
        <tr>
            <th>libelle</th>
            <th>previsions</th>
            <th>depense</th>
            <th>reste</th>
        </tr>
        <% for(Etat etat : listeEtat) {%>
            <tr>
                <td><%= etat.getLibelle() %></td>
                <td><%= etat.getPrevision() %></td>
                <td><%= etat.getDepense() %></td>
                <td><%= etat.getReste() %></td>
            </tr>
        <% }%>
    </table>
</body>
</html>