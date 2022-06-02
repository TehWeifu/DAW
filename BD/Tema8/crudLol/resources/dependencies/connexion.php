<?php
$config = require_once './resources/dependencies/config.php';
try {
    $connexion = new PDO($config['database_dsn'], $config['username'], $config['password']);
    $connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    return $connexion;

} catch (PDOException $e) {
    print "Error!: " . $e->getMessage() . "<br/>";
    die();
}

