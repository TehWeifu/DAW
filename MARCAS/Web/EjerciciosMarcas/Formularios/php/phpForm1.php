<?php 

//isset es verdadero si la variable que se le pasa como parámetro no está vacía

//si se ha pulsado el botón de enviar formulario
if (isset($_POST["sndBtn"])){

        $userName = $_POST["userName"];
        $userSur1 = $_POST["userSur1"];
        $userSur2 = $_POST["userSur2"];
        $userPass = $_POST["userPass"];
        $userAdult = ($_POST["userAdult"] === "1" ? "Mayor de edad" : "Menor de edad");
        $userSingle = ($_POST["userSingle"] === "1" ? "Soltero" : "Con pareja");
        $userFavCountry = $_POST["userFavCountry"];
        $userRegion = $_POST["userRegion"];
        $userCountry = $_POST["userCountry"];
        $userExtra = $_POST["userExtra"];

        $mailMessage = $userName . " " . $userSur1 . " " . $userSur2 . "\n" .
                        "Contraseña: " . $userPass . "\n" .
                        $userAdult . "\n" .
                        $userSingle . "\n" .
                        "Pais favorito: " . $userFavCountry . "\n" .
                        "Provincia: " . $userRegion . "\n" .
                        "Pais: " . $userCountry . "\n" .
                        "Comentarios: " . $userExtra . "\n";

		 
		//sintaxis mail(destino, asunto,mensaje,cabeceras);
		mail("bvkvgxvt@gmail.com", "Formulario 1", $mailMessage, "From:uwu\n");
		
		//mensaje de confirmación de envío
		echo "El formulario ha sido enviado con éxito.";
}
?>