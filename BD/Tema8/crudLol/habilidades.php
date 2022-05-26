<!doctype html>
<html lang="en">

<?php
require_once './FormHelper.php';
require_once './connexion.php';

FormHelper::printHeader("Habilidades", ["./styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Habilidades</h1>";

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    if (isset($_GET['del'])) {
        $idx = $_GET['idx'];

        $sql = "DELETE FROM Habilidad WHERE id = :idx";
        $stmt = $connexion->prepare($sql);
        $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
        $stmt->execute();
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['edit'])) {
        $data = [
            'name' => $_POST['name'],
            'energy' => $_POST['energy'],
            'cooldown' => $_POST['cooldown'],
            'champ_id' => $_POST['champ_id'],
            'idx' => $_POST['idx']
        ];

        $sql = "UPDATE Habilidad SET nombre=:name, puntosEnergia=:energy, enfriamiento=:cooldown, campeon=:champ_id WHERE id=:idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($data);

    } else {
        $name = $_POST['name'];
        $energy = $_POST['energy'];
        $cooldown = $_POST['cooldown'];
        $champ_id = $_POST['champ_id'];

        $sql = "INSERT INTO Habilidad (nombre, puntosEnergia, enfriamiento,campeon) VALUES (?,?,?,?)";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$name, $energy, $cooldown, $champ_id]);
    }
}
$currentPage = $_GET['p'] ?? 1;
if ($currentPage < 1) $currentPage = 1;

$sql = "SELECT Habilidad.id, Habilidad.nombre, puntosEnergia, enfriamiento, C.nombre as 'Campeon' FROM Habilidad JOIN Campeon C on C.id = Habilidad.campeon ";

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

$stmt = $connexion->query("DESCRIBE Habilidad");

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

    $sql = "SELECT * FROM Habilidad WHERE id = :idx";
    $stmt = $connexion->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $idx = $result['id'];
    $name = $result['nombre'];
    $energy = $result['puntosEnergia'];
    $cooldown = $result['enfriamiento'];
    $champ_id = $result['campeon'];

    print "<p><strong>Editar Habilidad</strong></p>";
    print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<input type='hidden' name='idx' value='$idx'>";
    print "<label>Nombre: <input type='text' name='name' value='" . $name . "'></label>";
    print "<label>Puntos de energia: <input type='number' name='energy' value='" . $energy . "'></label>";
    print "<label>Tiempo de enfriamiento: <input type='number' step='0.01' name='cooldown' value='" . $cooldown . "'></label>";

    print "<label>Campeon: <select name='champ_id'>";
    foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila) {
        $id = $fila['id'];
        $name = $fila['nombre'];

        print "<option ";
        if ($id == $champ_id) print "selected ";
        print "value='$id'>$name</option>";
    }
    print "</select></label>";

    print "<input type='submit' name='edit' value='Editar'>";
    print "</form>";
    print "<p><a href='" . $_SERVER['PHP_SELF'] . "?" . "'>Volver a nueva habilidad</a></p>";
} else { ?>
    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <p><strong>Nueva Habilidad</strong></p>

        <label>
            Nombre: <input type="text" name="name" required>
        </label>
        <label>
            Puntos energia: <input type="number" name="energy" required>
        </label>
        <label>
            Tiempo de enfriamiento: <input type="number" name="cooldown" required>
        </label>
        <label>
            Campeon: <select name="champ_id">
                <?php
                foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila) {
                    $id = $fila['id'];
                    $name = $fila['nombre'];

                    print "<option value='$id'>$name</option>";
                }
                ?>
            </select>
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