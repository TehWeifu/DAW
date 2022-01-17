-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-01-2019 a las 11:45:49
-- Versión del servidor: 5.7.22-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ml_galeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `dni` char(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`dni`, `nombre`, `direccion`, `telefono`) VALUES
('11111111A', 'Juan González', 'C/ Doctor Fletcher, 3', 961231212),
('22222222B', 'Ramón Arias', 'C/ Corts Valencianes, 24', 961471414),
('33333333C', 'Maríz Sánchez', 'C/ Don Juan Boscó, 45', 961024747),
('44444444D', 'Luisa Mieres', 'C/ Baja, 25', 961231417);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `dni` char(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dni`, `nombre`, `direccion`, `telefono`) VALUES
('12345678Q', 'Maite', 'C/ Álvarez, 54', 654987789),
('12345678W', 'Ana', 'Plaza Pintor Sorolla, 21', 654987987),
('12345678X', 'Marta', 'Plaza América, 27', 654123123),
('12345678Y', 'Jose', 'C/ Marinas, 54', 654787878);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expone`
--

CREATE TABLE `expone` (
  `codigo` int(11) NOT NULL,
  `exposicion` int(11) NOT NULL,
  `pintura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `expone`
--

INSERT INTO `expone` (`codigo`, `exposicion`, `pintura`) VALUES
(1, 11111, 111),
(2, 11111, 222),
(3, 11111, 333),
(4, 11111, 444),
(5, 11111, 555),
(6, 21111, 666),
(7, 21111, 777),
(8, 21111, 888),
(9, 21111, 987),
(10, 21111, 999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exposicion`
--

CREATE TABLE `exposicion` (
  `codigo` int(11) NOT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `exposicion`
--

INSERT INTO `exposicion` (`codigo`, `fechainicio`, `fechafin`) VALUES
(11111, '2015-11-01', '2016-01-30'),
(21111, '2015-10-01', '2015-11-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pintura`
--

CREATE TABLE `pintura` (
  `codigo` int(11) NOT NULL,
  `titulo` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `dni_cliente` char(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaventa` date DEFAULT NULL,
  `dni_artista` char(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `preciofinal` decimal(5,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pintura`
--

INSERT INTO `pintura` (`codigo`, `titulo`, `precio`, `dni_cliente`, `fechaventa`, `dni_artista`, `preciofinal`) VALUES
(111, 'Sol naciente', '215.00', '12345678Q', '2015-12-07', '11111111A', '200'),
(222, 'Amanecer', '300.00', '12345678Q', '2015-11-16', '11111111A', '300'),
(333, 'Las Vegas', '299.00', '12345678Q', '2015-12-07', '11111111A', '200'),
(444, 'L.A.', '50.00', '12345678Q', '2015-11-16', '11111111A', '45'),
(555, 'El mar', '125.00', '12345678W', '2015-12-30', '22222222B', '125'),
(666, 'Alegría', '250.00', '12345678W', '2016-01-03', '22222222B', '125'),
(777, 'Mi mundo', '233.00', '12345678X', '2015-12-22', '33333333C', '200'),
(888, 'El vuelo', '400.00', '12345678Y', '2015-12-29', '44444444D', '250'),
(987, 'La clase', '321.00', '12345678X', '2015-12-09', '44444444D', '300'),
(999, 'La playa', '654.00', '12345678X', '2015-12-23', '44444444D', '500');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `expone`
--
ALTER TABLE `expone`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `exposicion` (`exposicion`),
  ADD KEY `pintura` (`pintura`);

--
-- Indices de la tabla `exposicion`
--
ALTER TABLE `exposicion`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `pintura`
--
ALTER TABLE `pintura`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `dni_cliente` (`dni_cliente`),
  ADD KEY `dni_artista` (`dni_artista`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `expone`
--
ALTER TABLE `expone`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `exposicion`
--
ALTER TABLE `exposicion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21112;
--
-- AUTO_INCREMENT de la tabla `pintura`
--
ALTER TABLE `pintura`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `expone`
--
ALTER TABLE `expone`
  ADD CONSTRAINT `expone_ibfk_1` FOREIGN KEY (`exposicion`) REFERENCES `exposicion` (`codigo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `expone_ibfk_2` FOREIGN KEY (`pintura`) REFERENCES `pintura` (`codigo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pintura`
--
ALTER TABLE `pintura`
  ADD CONSTRAINT `pintura_ibfk_1` FOREIGN KEY (`dni_cliente`) REFERENCES `cliente` (`dni`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pintura_ibfk_2` FOREIGN KEY (`dni_artista`) REFERENCES `artista` (`dni`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
