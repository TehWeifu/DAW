<?php
$config = require_once './config.php';
$conexion = new mysqli($config['hostname'], $config['username'], $config['password'], $config['database']);

if ($conexion->connect_error) {
    die('No se ha podido conectar a la base de datos');
}
