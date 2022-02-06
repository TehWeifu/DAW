-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 04-02-2022 a las 07:57:09
-- Versión del servidor: 10.3.28-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ml_spotify`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `codigo` int(11) NOT NULL,
  `cancion` varchar(30) DEFAULT NULL,
  `album` varchar(20) DEFAULT NULL,
  `duracion` time DEFAULT NULL,
  `grupo` int(11) NOT NULL,
  `precio` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `canciones`
--

INSERT INTO `canciones` (`codigo`, `cancion`, `album`, `duracion`, `grupo`, `precio`) VALUES
(1, 'freedom', 'Raise your fist', '00:04:18', 1, '2.75'),
(2, 'poison', 'Trash', '00:04:28', 1, '3.25'),
(3, 'bed of nails', 'Trash', '00:04:09', 1, '2.75'),
(4, 'Trash', 'Trash', '00:04:59', 1, '4.75'),
(5, 'Teenage Frankenstein', 'Constrictor', '00:03:40', 1, '2.25'),
(6, 'Take it', 'Constrictor', '00:02:25', 1, '4.25'),
(7, 'Fuckin Perfect', 'Greatest Hits', NULL, 2, '2.35'),
(8, 'Raise your glass', 'Greatest Hits', '00:03:24', 2, '2.45'),
(9, 'Funhouse', 'Funhouse', '00:03:25', 2, '5.25'),
(10, 'Glitter in the air', 'Funhouse', '00:03:45', 2, '7.25'),
(11, 'Runaway', 'I’m not dead', '00:03:32', 2, '3.25'),
(12, 'Cristal ball', 'Funhouse', '00:03:25', 2, '2.15'),
(13, 'Dear Mr. President', NULL, '00:03:55', 2, '3.55');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `grupo` (`grupo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD CONSTRAINT `canciones_ibfk_1` FOREIGN KEY (`grupo`) REFERENCES `grupo` (`codigo_grupo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
