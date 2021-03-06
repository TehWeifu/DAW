<!doctype html>
<html lang="en">

<?php

require_once './resources/dependencies/FormHelper.php';

require_once './resources/dependencies/connexion.php';
/** @var PDO $connexion */

FormHelper::printHeader("Habilidades", ["./resources/styles/styles.css"]);

print "<body>";

FormHelper::printMenu();
print  "<h1>Habilidades</h1>";
print "<div class='container'>";

if ($_SERVER['REQUEST_METHOD'] === 'GET')
{
    if (isset($_GET['del']))
    {
        $sql = "DELETE FROM Habilidad WHERE id = :idx";
        $stmt = $connexion->prepare($sql);

        foreach ($_GET['delArr'] as $idx)
        {
            $stmt->bindParam("idx", $idx, PDO::PARAM_INT);

            $sql = "SELECT Habilidad.nombre, c.nombre FROM Habilidad JOIN Campeon c on c.id = Habilidad.campeon WHERE Habilidad.id = :idx";
            $tmpStmt = $connexion->prepare($sql);
            $tmpStmt->bindParam("idx", $idx, PDO::PARAM_INT);
            $tmpStmt->execute();
            $tmpRecord = $tmpStmt->fetch(PDO::FETCH_NUM);
            $tmpName = $tmpRecord[0];
            $tmpChamp = $tmpRecord[1];

            try
            {
                $stmt->execute();
                print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha eliminado correctamente la habilidad <strong>" . $tmpName . " (" . $tmpChamp . ")</strong>. </p>";
            } catch (PDOException $e)
            {
                print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>No es posible eliminar la habilidad <strong>" . $tmpName . "</strong>, ya que tiene habilidades establecidas o es utilizado por jugadores. </p>";

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
            'energy' => $_POST['energy'],
            'cooldown' => $_POST['cooldown'],
            'champ_id' => $_POST['champ_id'],
            'idx' => $_POST['idx']
        ];

        $dataSearch = [
            'name' => $_POST['name'],
            'idx' => $_POST['idx']
        ];

        $sql = "SELECT * FROM Habilidad WHERE nombre=:name AND id <> :idx";
        $stmt = $connexion->prepare($sql);
        $stmt->execute($dataSearch);

        if ($stmt->fetch(PDO::FETCH_ASSOC))
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i>Ya existe una habilidad con el nombre <strong>" . $data['name'] . "</strong>. </p>";
        } else
        {
            $sql = "UPDATE Habilidad SET nombre=:name, puntosEnergia=:energy, enfriamiento=:cooldown, campeon=:champ_id WHERE id=:idx";
            $stmt = $connexion->prepare($sql);
            $stmt->execute($data);

            $sql = "SELECT c.nombre FROM Habilidad JOIN Campeon c on c.id = Habilidad.campeon WHERE Habilidad.nombre = ?";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$data['name']]);
            $tmpChampName = $stmt->fetch(PDO::FETCH_NUM)[0];
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha editado correctamente la habilidad <strong>" . $data['name'] . " (" . $tmpChampName . ")</strong>. </p>";
        }

    } else if (isset($_POST['new']))
    {
        $name = $_POST['name'];
        $energy = $_POST['energy'];
        $cooldown = $_POST['cooldown'];
        $champ_id = $_POST['champ_id'];

        $sql = "SELECT id FROM Habilidad WHERE nombre = ?";
        $stmt = $connexion->prepare($sql);
        $stmt->execute([$name]);
        $tmpResult = $stmt->fetch(PDO::FETCH_NUM);

        if ($tmpResult !== false)
        {
            print"<p class='errMsg'><i class='fa-solid fa-triangle-exclamation'></i> Ya existe una habilidad con el nombre <strong>" . $name . "</strong>. </p>";
        } else
        {
            $sql = "INSERT INTO Habilidad (nombre, puntosEnergia, enfriamiento, campeon) VALUES (?,?,?,?)";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$name, $energy, $cooldown, $champ_id]);

            $sql = "SELECT c.nombre FROM Habilidad JOIN Campeon c on c.id = Habilidad.campeon WHERE Habilidad.nombre = ?";
            $stmt = $connexion->prepare($sql);
            $stmt->execute([$name]);
            $tmpChampName = $stmt->fetch(PDO::FETCH_NUM)[0];
            print"<p class='infoMsg'><i class='fa-solid fa-circle-info'></i>Se ha agregado correctamente la habilidad <strong>" . $name . " (" . $tmpChampName . ")</strong>. </p>";
        }
    }
}

if (isset($_GET['edit']))
{
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

    ?>
    <form class='editForm' method='post' action='<?= $_SERVER["PHP_SELF"] ?>'>
        <h3><strong>Editar Habilidad</strong></h3>
        <input type='hidden' name='idx' value='<?= $idx ?>'>

        <table class="formTable">
            <tr>
                <td>
                    <label for="champ_id">Campe??n: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic" required>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
                        {
                            $id = $fila['id'];
                            $champName = $fila['nombre'];

                            print "<option ";
                            if ($id == $champ_id) print "selected ";
                            print "value='$id'>$champName</option>";
                        }
                        ?>
                    </select>
                </td>
            </tr>

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
                    <label for="energy">Puntos de Energia: </label>
                </td>
                <td>
                    <input type='number' step="1" id="energy" name='energy' value='<?= $energy ?>' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="cooldown">Tiempo de Enfriamiento: </label>
                </td>
                <td>
                    <input type='number' step="0.01" id="cooldown" name='cooldown' value='<?= $cooldown ?>' required>
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
        <h3><strong>Nueva Habilidad</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="champ_id">Campe??n: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic" required>
                        <?php
                        foreach ($connexion->query(" SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                    <label for="name">Nombre: </label>
                </td>
                <td>
                    <input type='text' id="name" name='name' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="energy">Puntos de Energia: </label>
                </td>
                <td>
                    <input type='number' step="1" id="energy" name='energy' required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="cooldown">Tiempo de Enfriamiento: </label>
                </td>
                <td>
                    <input type='number' step="0.01" id="cooldown" name='cooldown' required>
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
        <h3><strong>Buscar Habilidad</strong></h3>

        <table class="formTable">
            <tr>
                <td>
                    <label for="champ_id">Campe??n: </label>
                </td>
                <td>
                    <select id="champ_id" name="champ_id" class="classic">
                        <option></option>
                        <?php
                        foreach ($connexion->query("SELECT * FROM Campeon ORDER BY nombre ", PDO::FETCH_ASSOC) as $fila)
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
                    <label for="name">Nombre: </label>
                </td>
                <td>
                    <input type='text' id='name' name='name' value='<?= $_POST['name'] ?? "" ?>'>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="energy">Puntos de Energia: </label>
                </td>
                <td>
                    <input type='number' step="1" id="energy" name='energy' value='<?= $_POST['energy'] ?? "" ?>'>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="cooldown">Tiempo de Enfriamiento: </label>
                </td>
                <td>
                    <input type='number' step="0.01" id="cooldown" name='cooldown'
                           value='<?= $_POST['cooldown'] ?? "" ?>'>
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

$sql = "SELECT Habilidad.id, C.nombre as 'Campeon', Habilidad.nombre, puntosEnergia, enfriamiento FROM Habilidad JOIN Campeon C on C.id = Habilidad.campeon ";
$dataResults = [];

if (isset($_POST['search']))
{
    $sql .= " WHERE 1 ";

    if (!empty($_POST['name']))
    {
        $sql .= " AND Habilidad.nombre LIKE :bindName ";
        $dataResults[] = ['bindName', '%' . $_POST['name'] . '%', PDO::PARAM_STR];
    }

    if (filter_var($_POST['energy'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND puntosEnergia = :bindEnergy ";
        $dataResults[] = ['bindEnergy', $_POST['energy'], PDO::PARAM_INT];
    }

    if (filter_var($_POST['cooldown'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND enfriamiento = :bindCooldown ";
        $dataResults[] = ['bindCooldown', $_POST['cooldown'], PDO::PARAM_INT];
    }

    if (filter_var($_POST['champ_id'], FILTER_VALIDATE_INT) !== false)
    {
        $sql .= " AND campeon = :bindChamp ";
        $dataResults[] = ['bindChamp', $_POST['champ_id'], PDO::PARAM_INT];
    }
}

if (!isset($_GET['sort']))
{
    $_GET['sort'] = ' Campeon ';
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

$stmt = $connexion->query("DESCRIBE Habilidad");

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