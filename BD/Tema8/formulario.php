<html lang="es">
<head>
    <title>Formulario con php</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    <table border="1">
        <tr>
            <th colspan="3">Titulo del formulario</th>
        </tr>

        <tr>
            <td><label for="firstName">Nombre: </label></td>
            <td><label for="lastName">Apellidos</label></td>
            <td><label for="age">Edad: </label></td>
        </tr>

        <tr>
            <td><input type="text" id="firstName" name="firstName"></td>
            <td><input type="text" id="lastName" name="lastName"></td>
            <td><input type="number" id="age" name="age"></td>
        </tr>

        <tr>
            <td><label for="favColor">Color favorito: </label></td>
            <td><label for="gender">Sexo: </label></td>
            <td><label for="civilStatus">Estado Civil: </label></td>
        </tr>

        <tr>
            <td><input type="color" id="favColor" name="favColor"></td>
            <td>
                <input type="radio" name="gender" id="genderMale" value="M"><label for="genderMale">Hombre</label>
                <input type="radio" name="gender" id="genderFemale" value="F"><label for="genderFemale">Mujer</label>
            </td>
            <td>
                <input type="radio" name="civilStatus" id="civilStatusSingle" value="S"><label for="civilStatusSingle">Soltero</label>
                <input type="radio" name="civilStatus" id="civilStatusMarried" value="M"><label
                        for="civilStatusMarried">Casado</label>
                <input type="radio" name="civilStatus" id="civilStatusLol" value="L"><label for="civilStatusLol">LoL
                    player</label>
            </td>
        </tr>

        <tr>
            <td rowspan="2">Aficiones</td>
            <td colspan="2">
                <input type="checkbox" name="hobbies[]" value="cinema" id="hobbiesCinema"> <label
                        for="hobbiesCinema">Cine</label>
                <input type="checkbox" name="hobbies[]" value="literature" id="hobbiesLiterature"> <label
                        for="hobbiesLiterature">Literatura</label>
                <input type="checkbox" name="hobbies[]" value="comics" id="hobbiesComics"> <label
                        for="hobbiesComics">Comics</label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="checkbox" name="hobbies[]" value="sports" id="hobbiesSports"> <label
                        for="hobbiesSports">Deportes</label>
                <input type="checkbox" name="hobbies[]" value="music" id="hobbiesMusic"> <label
                        for="hobbiesMusic">Musica</label>
                <input type="checkbox" name="hobbies[]" value="tv" id="hobbiesTv"> <label
                        for="hobbiesTv">Television</label>
            </td>
        </tr>
        <tr>
            <td>
                <label for="birthDate">Fecha nacimiento:</label><br>
                <input type="date" name="birthDate" id="birthDate">
            </td>
            <td>
                <input type="submit" name="sndBtn" value="Enviar">
                <input type="reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<?php
if (isset($_POST['sndBtn'])) {
    foreach ($_POST as $key => $value) {
        printf("%s: %s<br>", $key, $value);
    }
    echo "<pre>";
    var_dump($_POST['hobbies']);
    echo "</pre>";
}

