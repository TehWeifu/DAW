<?php
$conexion = new mysqli("localhost", "gxvt", "GXVT15o9", "jbsl_libreria3");

if ($conexion->connect_error) {
    die('No se ha podido conectar a la base de datos');
}
