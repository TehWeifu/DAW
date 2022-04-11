<?php
function print_form()
{
    $tmp = $_SERVER['PHP_SELF'];
    print <<<TEXT
    <html lang="es">
    <body>
    <form method="post" action="$tmp">
        Nombre: <input type="text" name="nombre">
        <input type="submit" name="enviar" value="123">
    </form>

    </body>
    </html>
TEXT;
}

if (isset($_POST['enviar'])) {
    $nombre = $_POST['nombre'];
    if (empty($nombre)) {
        echo "No se han rellenado todos los campos";
        print_form();
    } else {
        echo $nombre;
        echo "<br>";
        echo '<a href="post_index.php">Volver al formulario</a>';
    }

} else {
    print_form();
}
