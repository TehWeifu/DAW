-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-01-2020 a las 07:41:23
-- Versión del servidor: 10.2.10-MariaDB
-- Versión de PHP: 7.2.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ml_paginas_web`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE `contiene` (
  `codigo` int(11) NOT NULL,
  `nombreweb` varchar(30) NOT NULL,
  `ficheromultimedia` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contiene`
--

INSERT INTO `contiene` (`codigo`, `nombreweb`, `ficheromultimedia`) VALUES
(8, 'index.html', 'img1'),
(9, 'index.html', 'img2'),
(10, 'index.html', 'img4'),
(11, 'contacto.html', 'img3'),
(12, 'sobre_nosotros.html', 'video1'),
(13, 'index2.html', 'img1'),
(14, 'index2.html', 'video2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enlaza`
--

CREATE TABLE `enlaza` (
  `codigo` int(11) NOT NULL,
  `nombreorigen` varchar(30) NOT NULL,
  `nombredestino` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `enlaza`
--

INSERT INTO `enlaza` (`codigo`, `nombreorigen`, `nombredestino`) VALUES
(7, 'index.html', 'servicios.html'),
(8, 'index.html', 'contacto.html'),
(9, 'index.html', 'sobre_nosotros.html'),
(10, 'index2.html', 'contacto2.html'),
(11, 'index2.html', 'servicios2.html'),
(12, 'index2.html', 'sobre_nosotros2.html');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `fichero` varchar(30) NOT NULL,
  `ancho` int(11) NOT NULL,
  `alto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`fichero`, `ancho`, `alto`) VALUES
('img1', 200, 150),
('img2', 200, 150),
('img3', 200, 150),
('img4', 600, 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_multimedia`
--

CREATE TABLE `objeto_multimedia` (
  `fichero` varchar(30) NOT NULL,
  `tamaño` int(11) NOT NULL,
  `extension` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `objeto_multimedia`
--

INSERT INTO `objeto_multimedia` (`fichero`, `tamaño`, `extension`) VALUES
('cancion1', 25, 'mp3'),
('cancion2', 45, 'mp3'),
('cancion3', 70, 'mp3'),
('img1', 100, 'jpg'),
('img2', 150, 'jpg'),
('img3', 200, 'jpg'),
('img4', 150, 'png'),
('video1', 525, 'avi'),
('video2', 700, 'avi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagina_web`
--

CREATE TABLE `pagina_web` (
  `nombre` varchar(30) NOT NULL,
  `fecultimamodif` date NOT NULL,
  `ipsitio` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pagina_web`
--

INSERT INTO `pagina_web` (`nombre`, `fecultimamodif`, `ipsitio`) VALUES
('contacto.html', '2016-01-10', '10.10.10.10'),
('contacto2.html', '2015-12-22', '20.20.20.20'),
('index.html', '2016-01-05', '10.10.10.10'),
('index2.html', '2015-12-14', '20.20.20.20'),
('servicios.html', '2016-01-03', '10.10.10.10'),
('servicios2.html', '2016-01-10', '20.20.20.20'),
('sobre_nosotros.html', '2016-01-14', '10.10.10.10'),
('sobre_nosotros2.html', '2015-12-21', '20.20.20.20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sitio`
--

CREATE TABLE `sitio` (
  `ip` varchar(30) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sitio`
--

INSERT INTO `sitio` (`ip`, `direccion`) VALUES
('10.10.10.10', 'dominio1.com'),
('20.20.20.20', 'dominio2.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sonido`
--

CREATE TABLE `sonido` (
  `fichero` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sonido`
--

INSERT INTO `sonido` (`fichero`) VALUES
('cancion1'),
('cancion2'),
('cancion3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `video`
--

CREATE TABLE `video` (
  `fichero` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `video`
--

INSERT INTO `video` (`fichero`) VALUES
('video1'),
('video2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `ficheromultimedia` (`ficheromultimedia`),
  ADD KEY `nombreweb` (`nombreweb`);

--
-- Indices de la tabla `enlaza`
--
ALTER TABLE `enlaza`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `nombreorigen` (`nombreorigen`),
  ADD KEY `nombredestino` (`nombredestino`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`fichero`);

--
-- Indices de la tabla `objeto_multimedia`
--
ALTER TABLE `objeto_multimedia`
  ADD PRIMARY KEY (`fichero`),
  ADD KEY `fichero` (`fichero`);

--
-- Indices de la tabla `pagina_web`
--
ALTER TABLE `pagina_web`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `nombre` (`nombre`),
  ADD KEY `ipsitio` (`ipsitio`);

--
-- Indices de la tabla `sitio`
--
ALTER TABLE `sitio`
  ADD PRIMARY KEY (`ip`);

--
-- Indices de la tabla `sonido`
--
ALTER TABLE `sonido`
  ADD PRIMARY KEY (`fichero`);

--
-- Indices de la tabla `video`
--
ALTER TABLE `video`
  ADD PRIMARY KEY (`fichero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contiene`
--
ALTER TABLE `contiene`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `enlaza`
--
ALTER TABLE `enlaza`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD CONSTRAINT `contiene_ibfk_1` FOREIGN KEY (`nombreweb`) REFERENCES `pagina_web` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contiene_ibfk_2` FOREIGN KEY (`ficheromultimedia`) REFERENCES `objeto_multimedia` (`fichero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `enlaza`
--
ALTER TABLE `enlaza`
  ADD CONSTRAINT `enlaza_ibfk_1` FOREIGN KEY (`nombreorigen`) REFERENCES `pagina_web` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `enlaza_ibfk_2` FOREIGN KEY (`nombredestino`) REFERENCES `pagina_web` (`nombre`);

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`fichero`) REFERENCES `objeto_multimedia` (`fichero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pagina_web`
--
ALTER TABLE `pagina_web`
  ADD CONSTRAINT `pagina_web_ibfk_1` FOREIGN KEY (`ipsitio`) REFERENCES `sitio` (`ip`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sonido`
--
ALTER TABLE `sonido`
  ADD CONSTRAINT `sonido_ibfk_1` FOREIGN KEY (`fichero`) REFERENCES `objeto_multimedia` (`fichero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `video`
--
ALTER TABLE `video`
  ADD CONSTRAINT `video_ibfk_1` FOREIGN KEY (`fichero`) REFERENCES `objeto_multimedia` (`fichero`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
