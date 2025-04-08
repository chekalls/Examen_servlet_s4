<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <h3>Previsions</h3>
    <form action="/Examen/insert_previsions" method="post">
        <div>
            <label for="libelle"> libelle: </label>
            <input type="text" name="libelle" id="libelle">    
        </div>
        <div>
            <label for="montant">montant : </label>
            <input type="number" name="montant" id="montant">
        </div>
        <div>
            <input type="submit" value="valider">
        </div>
    </form>
</body>

</html>