<html lang="es">
<head>
    <title>GET test</title>
    <meta charset="UTF-8">
</head>
<body>
<pre>
<?php
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    var_dump($_GET['asignatura']);
}
?>
</pre>

</body>
</html>