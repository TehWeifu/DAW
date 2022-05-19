<!doctype html>
<html lang="en">

<?php
require_once './FormHelper.php';
require_once './connexion.php';

FormHelper::printHeader("Campeones", ["./styles.css"]);

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

$sql = "SELECT * FROM Campeon ";

if (isset($_GET['sort']))
{
    $field_sort = $_GET['sort'];
    $sql .= " ORDER BY $field_sort";
    if (isset($_GET['asc']))
    {
        $sql .= " ASC";
    } else
    {
        $sql .= " DESC";
    }
}

$stmt = $connexion->query($sql);
$fields = array_keys($stmt->fetch(PDO::FETCH_ASSOC));
print "<table border='1'>";
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
    print "<td><a href='" . $_SERVER['PHP_SELF'] . "?del&idx=" . $tmp_idx . "'>Eliminar</a></td>";
    print "<td><a href='" . $_SERVER['PHP_SELF'] . "?edit&idx=" . $tmp_idx . "'>Editar</a></td>";
    print "</td>";
    print "</tr>";
}
print "</table>";
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

    print "<p><strong>Editar Campeon</strong></p>";
    print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<input type='hidden' name='idx' value='$idx'>";
    print "<label>Nombre: <input type='text' name='name' value='" . $name . "'></label>";
    print "<label>Clase: <input type='text' name='class' value='" . $class . "'></label>";
    print "<label>Fecha Lanzamiento: <input type='date' name='launchDate' value='" . $launchDate . "'></label>";
    print "<label>Precio: <input type='number' name='price' value='" . $price . "'></label>";
    print "<input type='submit' name='edit' value='Editar'>";
    print "</form>";
    print "<p><a href='" . $_SERVER['PHP_SELF'] . "?" . "'>Volver a nuevo campeon</a></p>";
} else
{ ?>
    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <p><strong>Nuevo Campeon</strong></p>

        <label>
            Nombre: <input type="text" name="name" required>
        </label>
        <label>
            Clase: <input type="text" name="class" required>
        </label>
        <label>
            Fecha lanzamiento: <input type="date" name="launchDate" required>
        </label>
        <label>
            Precio: <input type="number" name="price" required>
        </label>
        <input type="submit" name="submit" value="Nuevo">
    </form>

    <?php
}
?>

<hr>
<p><a href="./index.php"> Volver al índice</a></p>

</body>
</html>