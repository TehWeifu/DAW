<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Categorías</title>
</head>
<body>
<?php
include_once "./conexion.php";

const DELETE = 1;
const EDIT = 2;

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    if ($_GET['mode'] == DELETE) {
        $idx = $_GET['indx'];

        $conexion->query("DELETE FROM categorias WHERE id_categoria = $idx") or die($conexion->error);
    } elseif ($_GET['mode'] == EDIT) {
        $idx = $_GET['indx'];

        $sql = $conexion->query("SELECT * FROM categorias WHERE id_categoria = $idx") or die($conexion->error);
        $name = $sql->fetch_array(MYSQLI_ASSOC)['categoria'];

        print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
        print "<p><label>id_categoria: <input type='text' readonly value='$idx' name='idx' ></label></p>";
        print "<p><label>Categoria: <input type='text' name='cat' value='$name' ></label></p>";
        print "<p><input type='submit' name='edit' value='Editar'></p>";
        print "</form>";
    }

}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['edit'])) {
        $idx = $_POST['idx'];
        $name = $_POST['cat'];

        $conexion->query("UPDATE categorias SET categoria='$name' WHERE id_categoria=$idx") or die($conexion->error);

    } else {
        $user_category = $_POST['cat'];

        $tmpCount = $conexion->query("SELECT id_categoria FROM categorias ORDER BY id_categoria DESC LIMIT 1") or die($conexion->error);
        $tmpCount = intval($tmpCount->fetch_array()[0]);
        $tmpCount++;

        $insert_sql = $conexion->query("INSERT INTO categorias VALUES ($tmpCount, '$user_category')") or die($conexion->error);
    }
}
$query = "SELECT * FROM categorias";
if (isset($_GET['sort'])) {
    $field_sort = $_GET['sort'];
    $query .= " ORDER BY $field_sort";
    if (isset($_GET['asc'])) {
        $query .= " ASC";
    } else {
        $query .= " DESC";
    }
}
$sql = $conexion->query($query) or die($conexion->error);

$fields = array_map(function ($el) {
    return $el->name;
}, $sql->fetch_fields());

print "<table border='1'>";
print "<tr>";
foreach ($fields as $field) {
    print "<th>$field <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'>↑</a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'>↓</a> </th>";
}
print "</tr>";


while ($fila = $sql->fetch_array(MYSQLI_NUM)) {
    $tmp_idx = $fila[0];

    print "<tr><td>";
    print(implode("</td><td>", $fila));

    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=" . DELETE . "&indx=$tmp_idx" . "'>Eliminar</a>";
    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=" . EDIT . "&indx=$tmp_idx" . "'>Editar</a>";
    print "</td></tr>";
}
print "</table>";

if ($_GET['mode'] != EDIT) {
    ?>

    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <label>
            Nueva categoria: <input type="text" name="cat">
        </label>
        <input type="submit" name="enviar">
    </form>
<?php } else { ?>
    <hr>
    <p><a href="<?= $_SERVER['PHP_SELF'] ?>"> Añadir registro</a></p>
<?php } ?>

<hr>
<p><a href="./index.php"> Volver al índice</a></p>

</body>
</html>
