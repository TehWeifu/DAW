<?php

//isset es verdadero si la variable que se le pasa como parámetro no está vacía

//si se ha pulsado el botón de enviar formulario
if (isset($_POST["sndBtn"])) {

    $userName = $_POST["userName"];
    $userSur = $_POST["userSur"];
    $userMail = $_POST["userMail"];
    $userCity = $_POST["userCity"];
    $userRegion = $_POST["userRegion"];
    $userAge = $_POST["userAge"];
//    $userHow = $_POST["userHow"];
    $userOpinion = $_POST["userOpinion"];
    $userSug = $_POST["userSug"];
    $userInternetHours = $_POST["userInternetHours"];


    $mailMessage = $userName . " " . $userSur . "\n" .
        "Provincia: " . $userRegion . "\n" .
        "Ciudad: " . $userCity . "\n" .
        "Edad: " . $userAge . "\n" .
<<<<<<< HEAD
        "Como nos conociste: " . $userHow . "\n" .
        "Opinion pagina: " . $userOpinion . "\n" .
        "Sugerencias: " . $userSug . "\n" .
        "Tiempo en Internet: " . $userInternetHours . "\n";
=======
        "Como nos conociste: ";

>>>>>>> 94c0d440608c8d358b4ec9ec304c958f692912cd

    foreach ($_POST["userHow"] as $selected) {
        $mailMessage .= ($selected . " ");
    }

    $mailMessage .= "\n" .
        "Opinion pagina: " . $userOpinion . "\n" .
        "Sugerencias: " . $userSug . "\n" .
        "Tiempo en Internet: " . $userInternetHours . "\n";

    //sintaxis mail(destino, asunto,mensaje,cabeceras);
    mail("bvkvgxvt@gmail.com", "Formulario 2", $mailMessage, "From:$userMail\n");

    //mensaje de confirmación de envío
    echo $mailMessage;
}
?>

