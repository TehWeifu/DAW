<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Libros</title>
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
        $del_index = $_GET['idx'];

        $connexion->query("DELETE FROM libros WHERE id_libro = $del_index") or die($connexion->errorInfo());
    } elseif (isset($_GET['mode']) && $_GET['mode'] == EDIT)
    {
        $up_index = $_GET['idx'];

        $sql = $connexion->query("SELECT * FROM libros WHERE id_libro = $up_index") or die($connexion->errorInfo());
        $fila = $sql->fetch(PDO::FETCH_ASSOC);
        $title = $fila['titulo'];
        $author = $fila['autor'];
        $price = $fila['precio'];
        $id_cat = $fila['id_categoria'];

        print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
        print "<p>id_libro: $up_index</p>";
        print "<input type='hidden' name='idx' value='$up_index'>";
        print "<p><label>Titulo: <input type='text' name='title' value='$title' ></label></p>";
        print "<p><label>Autor: <input type='text' name='author' value='$author' ></label></p>";

        print "Categoria: <select name='cat'>";
        $sql = $connexion->query("SELECT * FROM categorias");
        while ($fila = $sql->fetch(PDO::FETCH_NUM))
        {
            $id = $fila[0];
            $cat = $fila[1];

            print "<option ";
            if ($id == $id_cat) print "selected ";
            print "value='$id'>$cat</option>";
        }
        print "</select>";

        print "<p><label>Precio: <input type='text' name='price' value='$price' ></label></p>";
        print "<p><input type='submit' name='edit' value='Editar'></p>";
        print "</form>";
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST')
{
    if (isset($_POST['edit']))
    {
        $idx = $_POST['idx'];
        $title = $_POST['title'];
        $author = $_POST['author'];
        $price = $_POST['price'];
        $id_cat = $_POST['cat'];

        $connexion->query("UPDATE libros SET titulo='$title', autor='$author', id_categoria=$id_cat, precio=$price WHERE id_libro=$idx") or die($connexion->errorInfo());

    } else
    {
        $user_title = $_POST['title'];
        $user_price = $_POST['price'];
        $user_author = $_POST['author'];
        $user_category = $_POST['cat'];

        $tmpCount = $connexion->query("SELECT id_libro FROM libros ORDER BY id_libro DESC LIMIT 1") or die($connexion->errorInfo());
        $tmpCount = intval($tmpCount->fetch()[0]);
        $tmpCount++;

        $insert_sql = $connexion->query("INSERT INTO libros VALUES ($tmpCount, '$user_title', '$user_author', '$user_category', $user_price)") or die($connexion->errorInfo());
    }
}

$query = "SELECT libros.id_libro, libros.titulo, libros.autor, categorias.categoria, libros.precio FROM libros JOIN categorias ON libros.id_categoria=categorias.id_categoria";
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
} else
{
    $query .= " ORDER BY libros.id_libro";
}
$sql = $connexion->query($query);

$fields = array_map(function ($el) {
    return $el['Field'];
}, $connexion->query("DESCRIBE libros")->fetchAll(PDO::FETCH_ASSOC));

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
    $get_index = $fila[0];

    print "<tr><td>";
    print(implode("</td><td>", $fila));
    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=1&idx=$get_index" . "'>Eliminar</a>";
    print "</td><td><a href='" . $_SERVER['PHP_SELF'] . "?mode=2&idx=$get_index" . "'>Editar</a>";
    print "</td></tr>";
}
print "</table>";

if (!isset($_GET['mode']))
{
    ?>

    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <p><b>Nuevo Libro</b></p>
        <label>
            Titulo: <input type="text" name="title">
        </label>
        <label>
            Autor: <input type="text" name="author">
        </label>
        <label>
            Categoria:
            <select name="cat">
                <?php
                $sql = $connexion->query("SELECT * FROM categorias");
                while ($fila = $sql->fetch(PDO::FETCH_NUM))
                {
                    $id = $fila[0];
                    $cat = $fila[1];

                    print "<option value='$id'>$cat</option>";
                }
                ?>
            </select>
        </label>
        <label>
            Precio: <input type="text" name="price">
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
