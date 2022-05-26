<!doctype html>
<html lang="en">

<?php

require_once './FormHelper.php';
require_once './connexion.php';

FormHelper::printHeader("Jugadores", ["./styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Jugadores</h1>";

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    if (isset($_GET['del'])) {
        $idx = $_GET['idx'];

        $sql = "DELETE FROM Jugador WHERE id = :idx";
        $stmt = $connexion->prepare($sql);
        $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
        $stmt->execute();
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['edit'])) {
        $data = [
            'name' => $_POST['name'],
            'league' => $_POST['league'],
            'points' => $_POST['points'],
            'coins' => $_POST['coins'],
            'idx' => $_POST['idx']
        ];

        $sql = "UPDATE Jugador SET nombre=:name, liga=:league, puntosLiga=:points, monedas=:coins WHERE id=:idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($data);

    } else {
        $name = $_POST['name'];
        $league = $_POST['league'];
        $points = $_POST['points'];
        $coins = $_POST['coins'];

        $sql = "INSERT INTO Jugador (nombre, liga, puntosLiga,monedas) VALUES (?,?,?,?)";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$name, $league, $points, $coins]);
    }
}

$currentPage = $_GET['p'] ?? 1;
if ($currentPage < 1) $currentPage = 1;


$sql = "SELECT * from Jugador ";

if (!isset($_GET['sort'])) {
    $_GET['sort'] = 'id';
}
$field_sort = $_GET['sort'];
$sql .= " ORDER BY $field_sort ";
if (isset($_GET['des'])) {
    $sql .= " DESC";
} else {
    $sql .= " ASC";
}

$sql .= " LIMIT 50 OFFSET " . ($currentPage - 1) * 50;

$stmt = $connexion->query("DESCRIBE Jugador");

$fields = array_map(function ($row) {
    return $row['Field'];
}, $stmt->fetchAll(PDO::FETCH_ASSOC));

print "<table border='1'>";
print "<tr>";
foreach ($fields as $field) {
    print "<th>$field <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'>↑</a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'>↓</a> </th>";
}
print "</tr>";

$stmt = $connexion->query($sql);
while ($row = $stmt->fetch(PDO::FETCH_NUM)) {
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

print "<p>";
print "Pagina " . $currentPage;
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage - 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'>Anterior</a>";
print " | ";
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage + 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'>Siguiente</a>";
print "</p>";

print "<p>";
print "Mostrando los resultados: " . (($currentPage - 1) * 50 + 1) . " al " . ($currentPage * 50);
print "<p>";
?>

<?php
if (isset($_GET['edit'])) {
    $idx = $_GET['idx'];

    $sql = "SELECT * FROM Jugador WHERE id = :idx";
    $stmt = $connexion->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $idx = $result['id'];
    $name = $result['nombre'];
    $league = $result['liga'];
    $points = $result['puntosLiga'];
    $coins = $result['monedas'];

    print "<p><strong>Editar Jugador</strong></p>";
    print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<input type='hidden' name='idx' value='$idx'>";
    print "<label>Nombre: <input type='text' name='name' value='" . $name . "'></label>";
    print "<label>Liga: <input type='text' name='league' value='" . $league . "'></label>";
    print "<label>Puntos de liga: <input type='number' name='points' value='" . $points . "'></label>";
    print "<label>Monedas: <input type='number' name='coins' value='" . $coins . "'></label>";
    print "<input type='submit' name='edit' value='Editar'>";
    print "</form>";
    print "<p><a href='" . $_SERVER['PHP_SELF'] . "?" . "'>Volver a nuevo jugador</a></p>";
} else { ?>
    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <p><strong>Nuevo Jugador</strong></p>

        <label>
            Nombre: <input type="text" name="name" required>
        </label>
        <label>
            Liga: <input type="text" name="league" required>
        </label>
        <label>
            Puntos de liga: <input type="number" name="points" required>
        </label>
        <label>
            Monedas: <input type="number" name="coins" required>
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