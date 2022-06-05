<!doctype html>
<html lang="en">

<?php

require_once './resources/dependencies/FormHelper.php';

require_once './resources/dependencies/connexion.php';
/** @var PDO $connexion */

FormHelper::printHeader("Jugadores", ["./resources/styles/styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Jugadores</h1>";
print "<div class='container'>";

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['del']))
    {
        $sql = "DELETE FROM Jugador WHERE id = :idx";
        $stmt = $connexion->prepare($sql);
        foreach ($_GET['delArr'] as $idx)
        {
            $stmt->bindParam("idx", $idx, PDO::PARAM_INT);

            $sql = "SELECT nombre, liga FROM Jugador WHERE id = :idx";
            $tmpStmt = $connexion->prepare($sql);
            $tmpStmt->bindParam("idx", $idx, PDO::PARAM_INT);
            $tmpStmt->execute();
            $tmpRecord = $tmpStmt->fetch(PDO::FETCH_ASSOC);
            $tmpName = $tmpRecord['nombre'];
            $tmpLeague = $tmpRecord['clase'];

            try
            {
                $stmt->execute();
                print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha eliminado correctamente el jugador <strong>" . $tmpName . " (" . $tmpLeague . ")</strong>. </p>";

            } catch (PDOException $e)
            {
                print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>No se puede eliminar el jugador <strong>" . $tmpName . "</strong>, ya que ha adquirido uno o más campeones. </p>";
            }
        }
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST')
{
    if (isset($_POST['edit']))
    {
        $data = [
            'name' => $_POST['name'],
            'league' => $_POST['league'],
            'points' => $_POST['points'],
            'coins' => $_POST['coins'],
            'idx' => $_POST['idx']
        ];

        $dataSearch = [
            'name' => $_POST['name'],
            'idx' => $_POST['idx']
        ];

        $sql = "SELECT * FROM Jugador WHERE nombre=:name AND id <> :idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($dataSearch);

        if ($stmt->fetch(PDO::FETCH_ASSOC))
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Ya existe un jugador con el nombre <strong>" . $data['name'] . "</strong>. </p>";
        } else
        {
            $sql = "UPDATE Jugador SET nombre=:name, liga=:league, puntosLiga=:points, monedas=:coins WHERE id=:idx";
            $stmt = $connexion->prepare($sql);
            $stmt->execute($data);
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha editado correctamente el jugador <strong>" . $data['name'] . " (" . $data['league'] . ")</strong>. </p>";
        }

    } else if (isset($_POST['new']))
    {
        $name = $_POST['name'];
        $league = $_POST['league'];
        $points = $_POST['points'];
        $coins = $_POST['coins'];

        $sql = "SELECT * FROM Jugador WHERE nombre=?";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$name]);
        $tmpName = $stmt->fetch(PDO::FETCH_ASSOC)['nombre'];

        if ($tmpName !== null)
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i> Ya existe un jugador con el nombre <strong>" . $tmpName . "</strong>. </p>";
        } else
        {
            $sql = "INSERT INTO Jugador (nombre, liga, puntosLiga,monedas) VALUES (?,?,?,?)";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$name, $league, $points, $coins]);
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha agregado correctamente el campeón <strong>" . $name . " (" . $league . ")</strong>. </p>";
        }
    }
}

if (isset($_GET['edit']))
{
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

    ?>
    <form class='editForm' method='post' action='<?= $_SERVER["PHP_SELF"] ?>'>
        <h3><strong>Editar Jugador</strong></h3>
        <input type='hidden' name='idx' value='<?= $idx ?>'>

        <table class="formTable">
            <tr>
                <td>
                    <label for="name">Nombre: </label>
                </td>
                <td>
                    <input type='text' id="name" name='name' value='<?= $name ?>' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="league">Liga: </label>
                </td>
                <td>
                    <input type='text' id="league" name='league' value='<?= $league ?>' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Liga: </label>
                </td>
                <td>
                    <input type='number' step="1" id="points" name='points' value='<?= $points ?>' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="coins">Monedas: </label>
                </td>
                <td>
                    <input type='number' step="1" id="coins" name='coins' value='<?= $coins ?>' required>
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
    <form class="newForm" action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <h3><strong>Nuevo Jugador</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="name">Nombre: </label>
                </td>
                <td>
                    <input type="text" id="name" name="name" required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="league">Liga: </label>
                </td>
                <td>
                    <input type="text" id="league" name="league" required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Liga: </label>
                </td>
                <td>
                    <input type="number" step="1" id="points" name="points" required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="coins">Monedas: </label>
                </td>
                <td>
                    <input type="number" step="1" id="coins" name="coins" required>
                </td>
            </tr>

        </table>
        <div class="buttons">
            <a class="btn cancelBtn" href="<?= $_SERVER['PHP_SELF'] ?>"><i class="fa-solid fa-arrow-rotate-left"></i>Cancelar</a>
            <input class="btn newBtn" type="submit" name="new" value="Aceptar">
        </div>
    </form>

    <?php
} else
{ ?>

    <form class="searchForm" action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
        <h3><strong>Buscar Jugador</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="name">Nombre: </label>
                </td>
                <td>
                    <input type="text" id="name" name="name" value="<?= $_POST['name'] ?? "" ?>">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="league">Liga: </label>
                </td>
                <td>
                    <input type="text" id="league" name="league" value="<?= $_POST['league'] ?? "" ?>">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="points">Puntos de Liga: </label>
                </td>
                <td>
                    <input type="number" step="1" id="points" name="points" value="<?= $_POST['points'] ?? "" ?>">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="coins">Monedas: </label>
                </td>
                <td>
                    <input type="number" step="1" id="coins" name="coins" value="<?= $_POST['coins'] ?? "" ?>">
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

$sql = "SELECT * from Jugador ";

if (isset($_POST['search']))
{
    $sql .= " WHERE 1 ";

    if (!empty($_POST['name']))
    {
        $sql .= " AND nombre LIKE :bindName ";
        $dataResults[] = ['bindName', '%' . $_POST['name'] . '%', PDO::PARAM_STR];
    }

    if (!empty($_POST['league']))
    {
        $sql .= " AND liga LIKE :bindLeague ";
        $dataResults[] = ['bindLeague', '%' . $_POST['league'] . '%', PDO::PARAM_STR];
    }

    if (filter_var($_POST['points'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND puntosLiga = :bindPoints ";
        $dataResults[] = ['bindPoints', $_POST['points'], PDO::PARAM_INT];
    }

    if (filter_var($_POST['coins'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND coins = :bindCoins ";
        $dataResults[] = ['bindCoins', $_POST['coins'], PDO::PARAM_INT];
    }
}

if (!isset($_GET['sort']))
{
    $_GET['sort'] = 'nombre';
}
$fieldSort = $_GET['sort'];

$sql .= " ORDER BY $fieldSort ";

if (isset($_GET['des']))
{
    $sql .= " DESC";
} else
{
    $sql .= " ASC";
}

$sql .= " LIMIT :firstResult , 50 ";
$dataResults[] = ['firstResult', (($currentPage - 1) * 50), PDO::PARAM_INT];

$stmt = $connexion->query("DESCRIBE Jugador");

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

//var_dump($sql);
//print "<pre>";
//print_r($dataResults);
//print "</pre>";

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