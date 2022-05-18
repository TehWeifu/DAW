<?php
$config = require_once './config.php';
try {
    $connection = new PDO($config['database_dsn'], $config['username'], $config['password']);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    return $connection;

} catch (PDOException $e) {
    print "Error!: " . $e->getMessage() . "<br/>";
    die();
}

