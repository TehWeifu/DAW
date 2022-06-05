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
        $sql = "DELETE FROM Tienen WHERE id = :idx";
        $stmt = $connexion->prepare($sql);
        foreach ($_GET['delArr'] as $idx)
        {
            $stmt->bindParam("idx", $idx, PDO::PARAM_INT);

            $sql = "SELECT c.nombre, j.nombre FROM Tienen JOIN Campeon c on c.id = Tienen.campeon JOIN Jugador j on j.id = Tienen.jugador WHERE Tienen.id = :idx";
            $tmpStmt = $connexion->prepare($sql);
            $tmpStmt->bindParam("idx", $idx, PDO::PARAM_INT);
            $tmpStmt->execute();
            $tmpRecord = $tmpStmt->fetch(PDO::FETCH_NUM);
            $tmpChamp = $tmpRecord[0];
            $tmpPlayer = $tmpRecord[1];

            try
            {
                $stmt->execute();
                print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El jugador <strong>" . $tmpPlayer . "</strong> ya no dispone del campeón <strong>" . $tmpChamp . "</strong>. </p>";
            } catch (PDOException $e)
            {
                print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>No es posible eliminar el campeón <strong>" . $tmpChamp . "</strong> del jugador <strong>" . $tmpPlayer . "</strong>. </p>";
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

        $dataSearch = [
            'champ_id' => $_POST['champ_id'],
            'player_id' => $_POST['player_id'],
            'idx' => $_POST['idx']
        ];

        $sql = "SELECT c.nombre, j.nombre FROM Tienen JOIN Campeon c on c.id = Tienen.campeon JOIN Jugador j on j.id = Tienen.jugador WHERE campeon=:champ_id AND jugador=:player_id AND Tienen.id <> :idx";
        $tmpStmt = $connexion->prepare($sql);
        $tmpStmt->execute($dataSearch);
        $tmpRecord = $tmpStmt->fetch(PDO::FETCH_NUM);
        $tmpChamp = $tmpRecord[0];
        $tmpPlayer = $tmpRecord[1];

        if ($tmpChamp)
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>El jugador <strong>" . $tmpPlayer . "</strong> ya dispone del campeón <strong>" . $tmpChamp . "</strong>. </p>";
        } else
        {
            $sql = "UPDATE Tienen SET campeon=:champ_id, jugador=:player_id, puntosMaestria=:points, campeon=:champ_id WHERE id=:idx";
            $stmt = $connexion->prepare($sql);
            $stmt->execute($data);

            $sql = "SELECT c.nombre, j.nombre FROM Tienen JOIN Campeon c on c.id = Tienen.campeon JOIN Jugador j on j.id = Tienen.jugador WHERE campeon=:champ_id AND jugador=:player_id ";
            $tmpStmt = $connexion->prepare($sql);
            $tmpStmt->execute([
                'champ_id' => $_POST['champ_id'],
                'player_id' => $_POST['player_id'],
            ]);
            $tmpRecord = $tmpStmt->fetch(PDO::FETCH_NUM);
            $tmpChamp = $tmpRecord[0];
            $tmpPlayer = $tmpRecord[1];
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El jugador <strong>" . $tmpPlayer . "</strong> ha editado el campeón <strong>" . $tmpChamp . "</strong> correctamente. </p>";
        }

    } else if (isset($_POST['new']))
    {
        $champ_id = $_POST['champ_id'];
        $player_id = $_POST['player_id'];
        $points = $_POST['points'];

        $sql = "SELECT c.nombre, j.nombre FROM Tienen JOIN Campeon c on c.id = Tienen.campeon JOIN Jugador j on j.id = Tienen.jugador WHERE campeon=? AND jugador=?";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$champ_id, $player_id]);
        $tmpResult = $stmt->fetch(PDO::FETCH_NUM);

        if ($tmpResult)
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>El jugador <strong> " . $tmpResult[1] . " </strong> ya dispone del campeón <strong>" . $tmpResult[0] . "</strong>. </p>";
        } else
        {
            $sql = "INSERT INTO Tienen (campeon, jugador, puntosMaestria) VALUES (?,?,?)";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$champ_id, $player_id, $points]);

            $sql = "SELECT c.nombre, j.nombre FROM Tienen JOIN Campeon c on c.id = Tienen.campeon JOIN Jugador j on j.id = Tienen.jugador WHERE campeon=? AND jugador=?";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$champ_id, $player_id]);
            $tmpResult = $stmt->fetch(PDO::FETCH_NUM);

            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>El jugador <strong>" . $tmpResult[1] . " </strong>ha adquirido el campeon <strong>" . $tmpResult[0] . "</strong> correctamente. </p>";
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
                        foreach ($connexion->query(" SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                        foreach ($connexion->query(" SELECT * FROM Jugador ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                        foreach ($connexion->query("SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                        foreach ($connexion->query(" SELECT * FROM Jugador ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                        foreach ($connexion->query(" SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                        foreach ($connexion->query(" SELECT * FROM Jugador ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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

$sql = "SELECT Tienen.id, J.nombre as 'Jugador', C.nombre as 'Campeon', puntosMaestria ";
$sql .= " FROM Tienen ";
$sql .= " JOIN Campeon C on Tienen.campeon = C.id ";
$sql .= " JOIN Jugador J on J.id = Tienen.jugador ";
$dataResults = [];

if (isset($_POST['search']))
{
    $sql .= " WHERE 1 ";

    if (filter_var($_POST['champ_id'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND Tienen.campeon = :bindChamp ";
        $dataResults[] = ['bindChamp', $_POST['champ_id'], PDO::PARAM_INT];
    }

    if (filter_var($_POST['player_id'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND Tienen.jugador = :bindPlayer ";
        $dataResults[] = ['bindPlayer', $_POST['player_id'], PDO::PARAM_INT];
    }

    if (filter_var($_POST['points'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND puntosMaestria = :bindPoints ";
        $dataResults[] = ['bindPoints', $_POST['points'], PDO::PARAM_INT];
    }
}

if (!isset($_GET['sort']))
{
    $_GET['sort'] = ' Jugador ';
}
$fieldSort = $_GET['sort'];

$sql .= " ORDER BY $fieldSort";

if (isset($_GET['des']))
{
    $sql .= " DESC";
} else
{
    $sql .= " ASC";
}

$sql .= " LIMIT :firstResult , 50 ";
$dataResults[] = ['firstResult', (($currentPage - 1) * 50), PDO::PARAM_INT];

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

$stmt = $connexion->prepare($sql);
foreach ($dataResults as $dataValue)
{
    $stmt->bindParam($dataValue[0], $dataValue[1], $dataValue[2]);
}

$stmt->execute();

if ($row = $stmt->fetch(PDO::FETCH_NUM))
{
    do
    {
        $tmp_idx = array_shift($row);

        print "<tr>";

        print "<td>";
        print "<div class='squaredThree'>";
        print "<input type='checkbox' class='chkBox' value='$tmp_idx' id='squaredThree$tmp_idx' name='champ_id'/>";
        print "<label for='squaredThree$tmp_idx'></label>";
        print "</div>";
        print "</td>";

        print "<td>";
        print implode("</td><td>", $row);
        print "</td>";
        print "</tr>";
    } while ($row = $stmt->fetch(PDO::FETCH_NUM));
} else
{
    print "<tr><td colspan='200'>No se han encontrado registros</td>";
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