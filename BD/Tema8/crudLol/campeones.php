<!doctype html>
<html lang="en">

<?php
require_once './FormHelper.php';
require_once './connexion.php';

FormHelper::printHeader("Campeones", ["./styles3.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Campeones</h1>";

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['del']))
    {
        $idx = $_GET['idx'];

        $sql = "DELETE FROM Campeon WHERE id = :idx";
        $stmt = $connexion->prepare($sql);
        $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
        $stmt->execute();
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST')
{
    if (isset($_POST['edit']))
    {
        $data = [
            'class' => $_POST['class'],
            'name' => $_POST['name'],
            'launchDate' => $_POST['launchDate'],
            'price' => $_POST['price'],
            'idx' => $_POST['idx']
        ];

        $sql = "UPDATE Campeon SET nombre=:name, clase=:class, fechaLanzamiento=:launchDate, precio=:price WHERE id=:idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($data);

    } else
    {
        $name = $_POST['name'];
        $class = $_POST['class'];
        $launchDate = $_POST['launchDate'];
        $price = $_POST['price'];

        $sql = "INSERT INTO Campeon (nombre, clase, fechaLanzamiento,precio) VALUES (?,?,?,?)";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$name, $class, $launchDate, $price]);
    }
}
$currentPage = $_GET['p'] ?? 1;
if ($currentPage < 1) $currentPage = 1;

$sql = "SELECT * FROM Campeon ";

if (!isset($_GET['sort']))
{
    $_GET['sort'] = 'id';
}
$field_sort = $_GET['sort'];
$sql .= " ORDER BY $field_sort ";
if (isset($_GET['des']))
{
    $sql .= " DESC";
} else
{
    $sql .= " ASC";
}

$sql .= " LIMIT 50 OFFSET " . ($currentPage - 1) * 50;


$stmt = $connexion->query("DESCRIBE Campeon");

$fields = array_map(function ($row) {
    return $row['Field'];
}, $stmt->fetchAll(PDO::FETCH_ASSOC));

print "<table>";
print "<tr>";
foreach ($fields as $field)
{
    print "<th>$field <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'>↑</a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'>↓</a> </th>";
}
print "</tr>";

$stmt = $connexion->query($sql);
while ($row = $stmt->fetch(PDO::FETCH_NUM))
{
    $tmp_idx = $row[0];

    print "<tr>";
    print "<td>";
    print implode("</td><td>", $row);
    print "<td><a class='delete' href='" . $_SERVER['PHP_SELF'] . "?del&idx=" . $tmp_idx . "'>Eliminar</a></td>";
    print "<td><a class='edit' href='" . $_SERVER['PHP_SELF'] . "?edit&idx=" . $tmp_idx . "'>Editar</a></td>";
    print "</td>";
    print "</tr>";
}
print "</table>";

print "<p>";
print "Pagina " . $currentPage;
print "</p>";
print "<p>";
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage - 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'>Anterior</a>";
print " | ";
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage + 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'>Siguiente</a>";
print "</p>";

print "<p>";
print "Mostrando los resultados: " . (($currentPage - 1) * 50 + 1) . " al " . ($currentPage * 50);
print "<p>";
?>

<?php
if (isset($_GET['edit']))
{
    $idx = $_GET['idx'];

    $sql = "SELECT * FROM Campeon WHERE id = :idx";
    $stmt = $connexion->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $idx = $result['id'];
    $name = $result['nombre'];
    $class = $result['clase'];
    $launchDate = $result['fechaLanzamiento'];
    $price = $result['precio'];

    print "<form class='editForm' method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<h3><strong>Editar Campeón</strong></h3>";
    print "<input type='hidden' name='idx' value='$idx'>";
    print "<p><label>Nombre: <input type='text' name='name' value='" . $name . "'></label></p>";
    print "<p><label>Clase: <input type='text' name='class' value='" . $class . "'></label></p>";
    print "<p><label>Fecha Lanzamiento: <input type='date' name='launchDate' value='" . $launchDate . "'></label></p>";
    print "<p><label>Precio: <input type='number' name='price' value='" . $price . "'></label></p>";
    print "<p><input type='submit' name='edit' value='Editar'>";
    print "</form>";
    print "<p><a href='" . $_SERVER['PHP_SELF'] . "?" . "'>Volver a nuevo campeon</a></p>";
} else { ?>
    <form class="newForm" action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <h3><strong>Nuevo Campeon</strong></h3>

        <p>
            <label>
                Nombre: <input type="text" name="name" required>
            </label>
        </p>
        <p>
            <label>
                Clase: <input type="text" name="class" required>
            </label>
        </p>
        <p>
            <label>
                Fecha lanzamiento: <input type="date" name="launchDate" required>
            </label>
        </p>
        <p>
            <label>
                Precio: <input type="number" name="price" required>
            </label>
        </p>
        <input type="submit" name="submit" value="Nuevo">
    </form>

    <?php
}
?>

<hr>
<p><a href="./index.php"> Volver al índice</a></p>

</body>
</html>