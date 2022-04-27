<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<ul>
    <li>Enlace 1: <a href="./enlaces.php?asignatura=bbdd">Asignatura</a></li>
    <li>Enlace 1: <a href="./enlaces.php?centro=Solvam&asignatura=bbdd">Centro</a></li>
</ul>

<?php
if (isset($_GET['asignatura'])) {
    if (isset($_GET['centro'])) {
        print "<p>La asignatura es " . $_GET['asignatura'] . " y el centro es " . $_GET['centro'] . ".</p>";
    } else {
        print "<p>La asignatura es " . $_GET['asignatura'] . ".</p>";
    }
}
?>
</body>
</html>