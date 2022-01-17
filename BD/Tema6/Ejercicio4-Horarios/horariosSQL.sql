-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2018 a las 11:50:42
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `horarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `cuatrimestre` int(11) NOT NULL,
  `numaula` int(11) NOT NULL,
  `nomprofesor` varchar(40) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`nombre`, `cuatrimestre`, `numaula`, `nomprofesor`) VALUES
('Asignatura1', 1, 111, 'Profesor1'),
('Asignatura2', 1, 888, 'Profesor3'),
('Asignatura3', 1, 777, 'Profesor2'),
('Asignatura4', 2, 999, 'Profesor3'),
('Asignatura5', 2, 111, 'Profesor3'),
('Asignatura6', 3, 333, 'Profesor3'),
('Asignatura7', 3, 444, 'Profesor4'),
('Asignatura8', 3, 666, 'Profesor5'),
('Asignatura9', 4, 555, 'Profesor5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `numaula` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`numaula`, `capacidad`) VALUES
(111, 50),
(222, 50),
(333, 50),
(444, 100),
(555, 100),
(666, 60),
(777, 60),
(888, 60),
(999, 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula_con_pizarra`
--

CREATE TABLE `aula_con_pizarra` (
  `numaula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `aula_con_pizarra`
--

INSERT INTO `aula_con_pizarra` (`numaula`) VALUES
(222),
(333),
(444),
(555),
(666);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula_informatica`
--

CREATE TABLE `aula_informatica` (
  `numaula` int(11) NOT NULL,
  `numordenadores` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `aula_informatica`
--

INSERT INTO `aula_informatica` (`numaula`, `numordenadores`) VALUES
(111, 25),
(777, 30),
(888, 30),
(999, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizarra`
--

CREATE TABLE `pizarra` (
  `numaula` int(11) NOT NULL,
  `ancho` decimal(5,2) DEFAULT NULL,
  `alto` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pizarra`
--

INSERT INTO `pizarra` (`numaula`, `ancho`, `alto`) VALUES
(222, '122.00', '100.00'),
(333, '122.00', '100.00'),
(444, '200.00', '100.00'),
(555, '200.00', '100.00'),
(666, '150.00', '100.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `departamento` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`nombre`, `departamento`) VALUES
('Profesor1', 'Informática'),
('Profesor2', 'Informática'),
('Profesor3', 'Informática'),
('Profesor4', 'Matemáticas'),
('Profesor5', 'Idiomas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `nomprofesor` (`nomprofesor`),
  ADD KEY `numaula` (`numaula`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`numaula`);

--
-- Indices de la tabla `aula_con_pizarra`
--
ALTER TABLE `aula_con_pizarra`
  ADD KEY `numaula` (`numaula`);

--
-- Indices de la tabla `aula_informatica`
--
ALTER TABLE `aula_informatica`
  ADD PRIMARY KEY (`numaula`);

--
-- Indices de la tabla `pizarra`
--
ALTER TABLE `pizarra`
  ADD PRIMARY KEY (`numaula`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`nombre`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD CONSTRAINT `asignatura_ibfk_1` FOREIGN KEY (`nomprofesor`) REFERENCES `profesor` (`nombre`),
  ADD CONSTRAINT `asignatura_ibfk_2` FOREIGN KEY (`numaula`) REFERENCES `aula` (`numaula`);

--
-- Filtros para la tabla `aula_con_pizarra`
--
ALTER TABLE `aula_con_pizarra`
  ADD CONSTRAINT `aula_con_pizarra_ibfk_1` FOREIGN KEY (`numaula`) REFERENCES `aula` (`numaula`);

--
-- Filtros para la tabla `aula_informatica`
--
ALTER TABLE `aula_informatica`
  ADD CONSTRAINT `aula_informatica_ibfk_1` FOREIGN KEY (`numaula`) REFERENCES `aula` (`numaula`);

--
-- Filtros para la tabla `pizarra`
--
ALTER TABLE `pizarra`
  ADD CONSTRAINT `pizarra_ibfk_1` FOREIGN KEY (`numaula`) REFERENCES `aula_con_pizarra` (`numaula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;