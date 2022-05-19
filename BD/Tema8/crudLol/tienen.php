<!doctype html>
<html lang="en">

<?php

require_once './FormHelper.php';
require_once './connexion.php';

FormHelper::printHeader("Campeones Por Jugador", ["./styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Campeones Por Jugadores</h1>";

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['del']))
    {
        $idx = $_GET['idx'];

        $sql = "DELETE FROM Tienen WHERE id = :idx";
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
            'idx' => $_POST['idx'],
            'champ_id' => $_POST['champ_id'],
            'player_id' => $_POST['player_id'],
            'points' => $_POST['points']
        ];

        $sql = "UPDATE Tienen SET campeon=:champ_id, jugador=:player_id, puntosMaestria=:points, campeon=:champ_id WHERE id=:idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($data);

    } else
    {
        $champ_id = $_POST['champ_id'];
        $player_id = $_POST['player_id'];
        $points = $_POST['points'];

        $row = $connexion->query("SELECT * FROM Tienen WHERE campeon='$champ_id' AND jugador='$player_id'");

        if ($row->fetch(PDO::FETCH_ASSOC))
        {
            print"Error. Este jugador ya tiene este campeon";
        } else
        {
            $sql = "INSERT INTO Tienen (campeon, jugador, puntosMaestria) VALUES (?,?,?)";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$champ_id, $player_id, $points]);
        }
    }
}

$sql = "SELECT Tienen.id, C.nombre as 'Campeon', J.nombre as 'Jugador', puntosMaestria ";
$sql .= " FROM Tienen ";
$sql .= " JOIN Campeon C on Tienen.campeon = C.id ";
$sql .= " JOIN Jugador J on J.id = Tienen.jugador ";

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

    $sql = "SELECT * FROM Tienen WHERE id = :idx";
    $stmt = $connexion->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $idx = $result['id']; // TODO: remove this, it is redundant
    $champ_id = $result['campeon'];
    $player_id = $result['jugador'];
    $points = $result['puntosMaestria'];

    print "<p><strong>Editar Campeon por Jugador</strong></p>";
    print "<form method='post' action='" . $_SERVER['PHP_SELF'] . "'>";
    print "<input type='hidden' name='idx' value='$idx'>";

    print "<label>Campeon: <select name='champ_id'>";
    foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila)
    {
        $id = $fila['id'];
        $name = $fila['nombre'];

        print "<option ";
        if ($id == $champ_id) print "selected ";
        print "value='$id'>$name</option>";
    }
    print "</select></label>";

    print "<label>Jugador: <select name='player_id'>";
    foreach ($connexion->query("SELECT * FROM Jugador", PDO::FETCH_ASSOC) as $fila)
    {
        $id = $fila['id'];
        $name = $fila['nombre'];

        print "<option ";
        if ($id == $player_id) print "selected ";
        print "value='$id'>$name</option>";
    }
    print "</select></label>";

    print "<label>Puntos de Maestria: <input type='number' name='points' value='" . $points . "'></label>";

    print "<input type='submit' name='edit' value='Editar'>";
    print "</form>";
    print "<p><a href='" . $_SERVER['PHP_SELF'] . "?" . "'>Volver a nueva habilidad</a></p>";
} else
{ ?>
    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <p><strong>Nueva Habilidad</strong></p>

        <label>
            Campeon: <select name="champ_id">
                <?php
                foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila)
                {
                    $id = $fila['id'];
                    $name = $fila['nombre'];

                    print "<option value='$id'>$name</option>";
                }
                ?>
            </select>
        </label>

        <label>
            Jugador: <select name="player_id">
                <?php
                foreach ($connexion->query("SELECT * FROM Jugador", PDO::FETCH_ASSOC) as $fila)
                {
                    $id = $fila['id'];
                    $name = $fila['nombre'];

                    print "<option value='$id'>$name</option>";
                }
                ?>
            </select>
        </label>

        <label>
            Puntos de Maestria: <input type="number" name="points" required>
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