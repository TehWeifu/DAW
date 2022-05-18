<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Jugadores</title>
</head>
<body>
<h1>Jugadores - El 4%</h1>
<?php
require_once './connexion.php';

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    if (isset($_GET['del'])) {
        $idx = $_GET['idx'];

        $sql = "DELETE FROM Jugador WHERE id = :idx";
        $stmt = $connection->prepare($sql);
        $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
        $stmt->execute();
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['edit'])) {
        $data = [
            'name' => $_GET['name'],
            'leauge' => $_GET['leauge'],
            'points' => $_GET['points'],
            'coins' => $_GET['coins'],
            'idx' => $_GET['idx']
        ];
        $sql = "UPDATE Jugador SET nombre=:name, liga=:leauge, puntosLiga=:points, monedas=:coins WHERE id=:idx";

    } else {
        $name = $_POST['name'];
        $league = $_POST['league'];
        $points = $_POST['points'];
        $coins = $_POST['coins'];

        $sql = "INSERT INTO Jugador (nombre, liga, puntosLiga,monedas) VALUES (?,?,?,?)";
        $stmt = $connection->prepare($sql);
        $stmt->execute([$name, $league, $points, $coins]);
    }
}

$sql = "SELECT * from Jugador ";

if (isset($_GET['sort'])) {
    $field_sort = $_GET['sort'];
    $sql .= " ORDER BY $field_sort";
    if (isset($_GET['asc'])) {
        $sql .= " ASC";
    } else {
        $sql .= " DESC";
    }
}

$stmt = $connection->query($sql);
$fields = array_keys($stmt->fetch(PDO::FETCH_ASSOC));
print "<table border='1'>";
print "<tr>";
foreach ($fields as $field) {
    print "<th>$field <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'>↑</a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'>↓</a> </th>";
}
print "</tr>";

$stmt = $connection->query($sql);
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
?>

<?php
if (isset($_GET['edit'])) {
    $idx = $_GET['idx'];

    $sql = "SELECT * FROM Jugador WHERE id = :idx";
    $stmt = $connection->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $name = $result['nombre'];
    $league = $result['liga'];
    $points = $result['puntosLiga'];
    $coins = $result['monedas'];
    print "<p><strong>Editar Jugador</strong></p>";
    print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<input type='hidden' name='idx'>";
    print "<label>Nombre: <input type='text' name='name' value='" . $name . "'></label>";
    print "<label>Liga: <input type='text' name='league' value='" . $league . "'></label>";
    print "<label>Puntos de liga: <input type='number' name='points' value='" . $points . "'></label>";
    print "<label>Monedas: <input type='nu' name='coins' value='" . $coins . "'></label>";
    print "<input type='submit' name='edit'>";
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
        <input type="submit" name="submit">
    </form>

    <?php
}
?>

<hr>
<p><a href="./index.php"> Volver al índice</a></p>

</body>
</html>