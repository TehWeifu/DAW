<!doctype html>
<html lang="en">

<?php

require_once './resources/dependencies/FormHelper.php';

require_once './resources/dependencies/connexion.php';
/** @var PDO $connexion */

FormHelper::printHeader("Campeones Por Jugador", ["./resources/styles/styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Campeones Por Jugador</h1>";
print "<div class='container'>";

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['del']))
    {
        foreach ($_GET['delArr'] as $idx)
        {
            $sql = "DELETE FROM Tienen WHERE id = :idx";
            $stmt = $connexion->prepare($sql);
            $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
            try
            {
                $stmt->execute();
                print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El campeón del jugador ha sido eliminado correctamente. </p>";
            } catch (PDOException $e)
            {
                print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Error! No es posible eliminar el campeón del jugaodr. </p>";
            }
        }
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

        $row = $connexion->query("SELECT * FROM Tienen WHERE campeon='" . $_POST['champ_id'] . "' AND jugador='" . $_POST['player_id'] . "' AND id <> '" . $_POST['idx'] . "'");

        if ($row->fetch(PDO::FETCH_ASSOC))
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Error! Este jugador ya tiene este campeón. </p>";
        } else
        {
            $sql = "UPDATE Tienen SET campeon=:champ_id, jugador=:player_id, puntosMaestria=:points, campeon=:champ_id WHERE id=:idx";
            $stmt = $connexion->prepare($sql);
            try
            {
                $stmt->execute();
                print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El campeón del jugador ha sido editado correctamente. </p>";
            } catch (PDOException $e)
            {
                print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Error! No es posible eliminar el registro. </p>";
            }
        }

    } else if (isset($_POST['new']))
    {
        $champ_id = $_POST['champ_id'];
        $player_id = $_POST['player_id'];
        $points = $_POST['points'];

        $row = $connexion->query("SELECT * FROM Tienen WHERE campeon='$champ_id' AND jugador='$player_id'");

        if ($row->fetch(PDO::FETCH_ASSOC))
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Error! Este jugador ya tiene este campeón. </p>";
        } else
        {
            $sql = "INSERT INTO Tienen (campeon, jugador, puntosMaestria) VALUES (?,?,?)";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$champ_id, $player_id, $points]);
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El campeón del jugador ha sido agregado correctamente. </p>";
        }
    }
}

if (isset($_GET['edit']))
{
    $idx = $_GET['idx'];

    $sql = "SELECT * FROM Tienen WHERE id = :idx";
    $stmt = $connexion->prepare($sql);
    $stmt->bindParam("idx", $idx, PDO::PARAM_INT);
    $stmt->execute();

    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $idx = $result['id'];
    $champ_id = $result['campeon'];
    $player_id = $result['jugador'];
    $points = $result['puntosMaestria'];

    ?>
    <form class='editForm' method='post' action='<?= $_SERVER["PHP_SELF"] ?>'>
        <h3><strong>Editar Campeón por Jugador</strong></h3>
        <input type='hidden' name='idx' value='<?= $idx ?>'>

        <table class="formTable">

            <tr>
                <td>
                    <label for="champ_id">Campeón: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic" required>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            if ($id == $champ_id) print "selected ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="player_id">Jugador: </label>
                </td>
                <td>
                    <select id="player_id" name="player_id" class="classic" required>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Jugador", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            if ($id == $player_id) print "selected ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Maestria: </label>
                </td>
                <td>
                    <input type='number' id="points" name='points' value='<?= $points ?>' required>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <a class="btn cancelBtn" href="<?= $_SERVER['PHP_SELF'] ?>"><i class="fa-solid fa-arrow-rotate-left"></i>Cancelar</a>
            <input class="btn editBtn" type='submit' name='edit' value='Aceptar'>
        </div>
    </form>

    <?php
} else if (isset($_GET['new']))
{ ?>
    <form class='newForm' method='post' action='<?= $_SERVER["PHP_SELF"] ?>'>
        <h3><strong>Nuevo Campeón por Jugador</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="champ_id">Campeón: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic" required>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="player_id">Jugador: </label>
                </td>
                <td>
                    <select id="player_id" name="player_id" class="classic" required>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Jugador", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Maestria: </label>
                </td>
                <td>
                    <input type='number' id="points" name='points' required>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <a class="btn cancelBtn" href="<?= $_SERVER['PHP_SELF'] ?>"><i class="fa-solid fa-arrow-rotate-left"></i>Cancelar</a>
            <input class="btn newBtn" type='submit' name='new' value='Aceptar'>
        </div>
    </form>

    <?php
} else
{ ?>
    <form class='searchForm' method='post' action='<?= $_SERVER["PHP_SELF"] ?>'>
        <h3><strong>Buscar Campeón por Jugador</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="champ_id">Campeón: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic">
                        <option></option>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Campeon", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            if ($id == $_POST['champ_id']) print " selected ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="player_id">Jugador: </label>
                </td>
                <td>
                    <select id="player_id" name="player_id" class="classic">
                        <option></option>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Jugador", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $name = $fila['nombre'];

                            print "<option ";
                            if ($id == $_POST['player_id']) print " selected ";
                            print "value='$id'>$name</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Maestria: </label>
                </td>
                <td>
                    <input type='number' id="points" name='points' value="<?= $_POST['points'] ?? "" ?>">
                </td>
            </tr>
        </table>

        <input type="submit" name="search" value="Aceptar">
    </form>

<?php }

print "<div class='buttons'>";
print "<a href='" . $_SERVER['PHP_SELF'] . "?search' class='btn searchBtn'><i class='fa-solid fa-magnifying-glass'></i>Buscar</a>";
print "<a href='" . $_SERVER['PHP_SELF'] . "?new' class='btn newBtn'><i class='fa-solid fa-plus'></i>Nuevo</a>";
print "<button class='btn editBtn js_editBtn'><i class='fa-solid fa-pen-to-square'></i>Editar</button>";
print "<button class='btn deleteBtn js_deleteBtn'><i class='fa-solid fa-trash-can'></i>Eliminar</button>";
print "</div>";


$currentPage = $_GET['p'] ?? 1;
if ($currentPage < 1) $currentPage = 1;

$sql = "SELECT Tienen.id, C.nombre as 'Campeon', J.nombre as 'Jugador', puntosMaestria ";
$sql .= " FROM Tienen ";
$sql .= " JOIN Campeon C on Tienen.campeon = C.id ";
$sql .= " JOIN Jugador J on J.id = Tienen.jugador ";

if (isset($_POST['search']))
{
    $sql .= " WHERE 1 ";

    // TODO refactor this with prepare
    if (!empty($_POST['champ_id']))
    {
        $sql .= " AND Tienen.campeon = '" . $_POST['champ_id'] . "' ";
    }

    if (!empty($_POST['player_id']))
    {
        $sql .= " AND Tienen.jugador = '" . $_POST['player_id'] . "' ";
    }

    if (!empty($_POST['points']))
    {
        $sql .= " AND puntosMaestria = '" . $_POST['points'] . "' ";
    }
}

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

$stmt = $connexion->query("DESCRIBE Tienen");

$fields = array_map(function ($row) {
    return $row['Field'];
}, $stmt->fetchAll(PDO::FETCH_ASSOC));

print "<table class='resultsTable'>";
print "<tr><td></td>";
array_shift($fields);
foreach ($fields as $field)
{
    $fancyField = preg_replace("/([a-z])([A-Z])/", "$1 $2", $field);
    print "<th class='headerSort'>$fancyField <a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&asc" . "'><i class='fa-solid fa-sort-up'></i></a> " .
        "<a href='" . $_SERVER['PHP_SELF'] . "?sort=$field&des" . "'><i class='fa-solid fa-sort-down'></i></a> </th>";
}
print "</tr>";

$stmt = $connexion->query($sql);
while ($row = $stmt->fetch(PDO::FETCH_NUM))
{
    $tmp_idx = array_shift($row);

    print "<tr>";

    print "<td>";
    print "<div class='squaredThree'>";
    print "<input type='checkbox' class='chkBox' value='$tmp_idx' id='squaredThree$tmp_idx' name='squaredThree$tmp_idx'/>";
    print "<label for='squaredThree$tmp_idx'></label>";
    print "</div>";
    print "</td>";

    print "<td>";
    print implode("</td><td>", $row);
    print "</td>";
    print "</tr>";
}

print "<tr><td></td>";
foreach ($fields as $field)
{
    $field = preg_replace("/([a-z])([A-Z])/", "$1 $2", $field);
    print "<th>$field</th>";
}
print "</tr>";

print "</table>";

print "<p>";
print "Pagina " . $currentPage;
print "</p>";
print "<p>";
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage - 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'><i class='fa-solid fa-arrow-left'></i>Anterior</a>";
print " | ";
print "<a href='" . $_SERVER['PHP_SELF'] . "?p=" . ($currentPage + 1) . "&sort=" . $_GET['sort'] . "&" . (isset($_GET['asc']) ? "asc" : "desc") . "'>Siguiente<i class='fa-solid fa-arrow-right''></i></a>";
print "</p>";

print "<p>";
print "Mostrando los resultados: " . (($currentPage - 1) * 50 + 1) . " al " . ($currentPage * 50);
print "<p>";
?>

<script src="./resources/scripts/script.js"></script>
</div>
</body>
</html>