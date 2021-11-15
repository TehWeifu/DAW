<?php 

//isset es verdadero si la variable que se le pasa como parámetro no está vacía

//si se ha pulsado el botón de enviar formulario
if (isset($_POST["sndBtn"])){

        $name = $_POST["userName"];
        $userSur1 = $_POST["userSur1"];
        $userSur2 = $_POST["userSur2"];
        $userPass = $_POST["userPass"];



		//se crea la variable "de" y se le asigna lo que el usuario ha escrito en el campo "de" del formulario
		$de=$_POST["de"];
		
		//se crea la variable "asunto" y se le asigna lo que el usuario ha escrito en el campo "asunto" del formulario
		$asunto=$_POST["asunto"];
				
		
		//se crea la variable "mensaje" y se le asigna lo que el usuario ha escrito en el campo "mensaje" del formulario
		$mensaje=$_POST["mensaje"] . "\n" . $_POST["telefono"] . "\n" . $_POST["direccion"] . "\n";

		 
		//sintaxis mail(destino, asunto,mensaje,cabeceras);
		mail("bvkvgxvt@gmail.com",$asunto,$mensaje,"From:$de\n");
		
		//mensaje de confirmación de envío
		echo "El formulario ha sido enviado con exito.";
}
?>