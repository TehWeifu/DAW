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
include_once "./resources/dependencies/conexion.php";
/** @var PDO $connexion */

const DELETE = 1;
const EDIT = 2;

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['mode']) && $_GET['mode'] == DELETE)
    {
        $idx = $_GET['indx'];

        $connexion->query("DELETE FROM categorias WHERE id_categoria = $idx") or die($connexion->errorInfo());
    } elseif (isset($_GET['mode']) && $_GET['mode'] == EDIT)
    {
        $idx = $_GET['indx'];

        $sql = $connexion->query("SELECT * FROM categorias WHERE id_categoria = $idx") or die($connexion->errorInfo());
        $name = $sql->fetch(PDO::FETCH_ASSOC)['categoria'];

        print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
        print "<p><label>id_categoria: <input type='text' readonly value='$idx' name='idx' ></label></p>";
        print "<p><label>Categoria: <input type='text' name='cat' value='$name' ></label></p>";
        print "<p><input type='submit' name='edit' value='Editar'></p>";
        print "</form>";
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST')
{
    if (isset($_POST['edit']))
    {
        $idx = $_POST['idx'];
        $name = $_POST['cat'];

        $connexion->query("UPDATE categorias SET categoria='$name' WHERE id_categoria=$idx") or die($connexion->errorInfo());

    } else
    {
        $user_category = $_POST['cat'];

        $tmpCount = $connexion->query("SELECT id_categoria FROM categorias ORDER BY id_categoria DESC LIMIT 1") or die($connexion->errorInfo());
        $tmpCount = intval($tmpCount->fetch()[0]);
        $tmpCount++;

        $insert_sql = $connexion->query("INSERT INTO categorias VALUES ($tmpCount, '$user_category')") or die($connexion->errorInfo());
    }
}
$query = "SELECT * FROM categorias";
if (isset($_GET['sort']))
{
    $field_sort = $_GET['sort'];
    $query .= " ORDER BY $field_sort";
    if (isset($_GET['asc']))
    {
        $query .= " ASC";
    } else
    {
        $query .= " DESC";
    }
}
$sql = $connexion->query($query) or die($connexion->errorInfo());

$fields = array_map(function ($el) {
    return $el['Field'];
}, $connexion->query("DESCRIBE categorias")->fetchAll(PDO::FETCH_ASSOC));

print "<table border='1'>";
print "<tr>";
foreach ($fields as $field)
{
    print "<th>$field <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'>↑</a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'>↓</a> </th>";
}
print "</tr>";


while ($fila = $sql->fetch(PDO::FETCH_NUM))
{
    $tmp_idx = $fila[0];

    print "<tr><td>";
    print(implode("</td><td>", $fila));

    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=" . DELETE . "&indx=$tmp_idx" . "'>Eliminar</a>";
    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=" . EDIT . "&indx=$tmp_idx" . "'>Editar</a>";
    print "</td></tr>";
}
print "</table>";

if (!isset($_GET['mode']))
{
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
