-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-01-2020 a las 07:32:01
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
-- Base de datos: `ml_seguros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `dni` char(9) NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrativo`
--

INSERT INTO `administrativo` (`dni`, `categoria`) VALUES
('11111111E', 'AdminCat1'),
('22222222E', 'AdminCat2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beneficiario`
--

CREATE TABLE `beneficiario` (
  `dni` char(9) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `beneficiario`
--

INSERT INTO `beneficiario` (`dni`, `nombre`) VALUES
('66666666B', 'Juan Rodirguez'),
('77777777B', 'Marcos Mateo'),
('88888888B', 'Maria Luna'),
('99999999B', 'Ana Reyes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `dni` char(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `salario` decimal(5,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`dni`, `nombre`, `salario`) VALUES
('11111111E', 'Empleado1', '851'),
('22222222E', 'Empleado2', '990'),
('33333333E', 'Empleado3', '1121'),
('44444444E', 'Empleado4', '1121'),
('55555555E', 'Empleado5', '2101');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `numpoliza` int(11) NOT NULL,
  `fechafirma` date NOT NULL,
  `importe` decimal(5,0) NOT NULL,
  `dni_empleado` char(9) NOT NULL,
  `dni_beneficiario` char(9) NOT NULL,
  `fechacobro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seguro`
--

INSERT INTO `seguro` (`numpoliza`, `fechafirma`, `importe`, `dni_empleado`, `dni_beneficiario`, `fechacobro`) VALUES
(111, '2015-12-15', '126', '33333333E', '77777777B', '2015-12-16'),
(222, '2016-01-10', '201', '33333333E', '77777777B', '2016-01-11'),
(333, '2015-12-20', '181', '44444444E', '88888888B', '2015-12-21'),
(444, '2015-11-08', '321', '44444444E', '99999999B', '2015-11-09');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `dni` char(9) NOT NULL,
  `zona` varchar(10) NOT NULL,
  `porcentaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`dni`, `zona`, `porcentaje`) VALUES
('33333333E', 'Zona1', 10),
('44444444E', 'Zona2', 15),
('55555555E', 'Zona3', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `beneficiario`
--
ALTER TABLE `beneficiario`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `seguro`
--
ALTER TABLE `seguro`
  ADD PRIMARY KEY (`numpoliza`),
  ADD KEY `dni_empleado` (`dni_empleado`),
  ADD KEY `dni_beneficiario` (`dni_beneficiario`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`dni`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD CONSTRAINT `administrativo_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguro`
--
ALTER TABLE `seguro`
  ADD CONSTRAINT `seguro_ibfk_1` FOREIGN KEY (`dni_empleado`) REFERENCES `empleado` (`dni`) ON UPDATE CASCADE,
  ADD CONSTRAINT `seguro_ibfk_2` FOREIGN KEY (`dni_beneficiario`) REFERENCES `beneficiario` (`dni`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
