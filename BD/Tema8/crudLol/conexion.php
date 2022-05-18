<?php
$config = require_once 'config.php';
$conexion = null;
try {
    $conexion = new PDO($config['database_dns'], $config['username'], $config['password']);
} catch (Exception $exception) {
    print "No se ha podido establecer conexion con la DB <br>";
    print "Error!: " . $exception->getMessage() . "<br/>";
    die();
}

