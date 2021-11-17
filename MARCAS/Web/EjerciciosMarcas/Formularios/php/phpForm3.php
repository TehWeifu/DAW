<?php

//isset es verdadero si la variable que se le pasa como parámetro no está vacía

//si se ha pulsado el botón de enviar formulario
if (isset($_POST["sndBtn"])) {

    $userFirstName = $_POST["userFirstName"];
    $userLastName = $_POST["userLastName"];
    $userMail = $_POST["userMail"];
    $userCountry = $_POST["userCountry"];
    $userFrequency = $_POST["userFrequency"];
    $userDescription = $_POST["userDescription"];
    $userLanguages = $_POST["userLanguages"];


    $mailMessage = $userFirstName . " " . $userLastName . " " . "\n" .
        "Mail: " . $userMail . "\n" .
        "Country: " . $userCountry . "\n" .
        "Language: " . $userLanguages . "\n" .
        "Description: " . $userDescription . "\n" .
        "Translation frequency: " . $userFrequency . "\n";

    //sintaxis mail(destino, asunto,mensaje,cabeceras);
    mail("bvkvgxvt@gmail.com", "Formulario 3", $mailMessage, "From:owo\n");

    //mensaje de confirmación de envío
    echo "El formulario ha sido enviado con éxito.";
}
?>