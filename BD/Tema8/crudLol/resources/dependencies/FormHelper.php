<?php

class FormHelper
{
    public static function printHeader($title, $links = [])
    {
        $result = <<<HEREDOC
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://kit.fontawesome.com/4493fed746.js" crossorigin="anonymous"></script>

    <title>$title</title>
HEREDOC;

        foreach ($links as $link)
        {
            $result .= "<link rel='stylesheet' href='$link'>";
        }

        $result .= "</head>";
        print $result;
    }

    public static function printMenu()
    {
        $menu = "<div class='menu'>";

        $menu .= "<a href='./index.php'><i class='fa-solid fa-house'></i><strong>Inicio</strong></a>";
        $menu .= " | ";
        $menu .= "<a href='./campeones.php'>Campeones</a> | ";
        $menu .= "<a href='./jugadores.php'>Jugadores</a> | ";
        $menu .= "<a href='./habilidades.php'>Habilidades</a> | ";
        $menu .= "<a href='./tienen.php'>Campeones por Jugador</a>";

        $menu .= "</div>";

        print $menu;
    }
}
