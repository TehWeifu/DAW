-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-02-2020 a las 07:42:20
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
-- Base de datos: `ml_solvam`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `codigo` int(3) UNSIGNED ZEROFILL NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `apellidos` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`codigo`, `nombre`, `apellidos`) VALUES
(001, 'Andres', 'Escobar'),
(002, 'Sergio', 'Rodriguez'),
(003, 'Sergio', 'González'),
(004, 'Alex', 'Escribano'),
(005, 'Victor', 'Sorli'),
(006, 'Adrian', 'Roig'),
(007, 'PAblo ', 'Gimeno'),
(008, 'Jose', 'Orts'),
(009, 'Borja', 'Rios'),
(010, 'David', 'Fernandez'),
(011, 'Maria', 'Rosello'),
(012, 'Inma', 'Beltran'),
(013, 'Eloy', 'Ruiz'),
(014, 'Pablo ', 'Martinez'),
(015, 'Pedro', 'Romero'),
(016, 'Pablo', 'Sanchez'),
(017, 'Pablo', 'Rodrigo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclos`
--

CREATE TABLE `ciclos` (
  `codigo` varchar(3) NOT NULL,
  `ciclo` varchar(50) DEFAULT NULL,
  `grado` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciclos`
--

INSERT INTO `ciclos` (`codigo`, `ciclo`, `grado`) VALUES
('AyF', 'Administ y Finanzas', 'Superior'),
('DAW', 'Desarrollo de Aplic Web', 'Superior'),
('FPB', 'Formación Prof Básica', 'Basico'),
('GA', 'Gestion Adm', 'Medio'),
('SMR', 'Sistemas Microinf', 'Medio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `codigo` varchar(5) NOT NULL,
  `curso` varchar(50) DEFAULT NULL,
  `cod_ciclo` varchar(3) DEFAULT NULL,
  `turno` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo`, `curso`, `cod_ciclo`, `turno`) VALUES
('1DAW', 'Primero de DAW', 'DAW', 'Mañanas'),
('1GA', 'Primero Gestion', 'DAW', 'Mañanas'),
('1SMR', 'Primero SMR', 'SMR', 'Mañanas'),
('2DAW', 'Segundo de DAW', 'DAW', 'Mañanas'),
('2GA', 'Segundo Gestion', 'GA', 'Mañanas'),
('2SMR', 'Segundo SMR', 'SMR', 'Mañanas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

CREATE TABLE `matriculas` (
  `codigo` int(10) UNSIGNED NOT NULL,
  `cod_alumno` int(3) UNSIGNED ZEROFILL DEFAULT NULL,
  `cod_modulo` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `matriculas`
--

INSERT INTO `matriculas` (`codigo`, `cod_alumno`, `cod_modulo`) VALUES
(1, 001, 1),
(2, 001, 5),
(3, 002, 1),
(4, 002, 5),
(5, 003, 1),
(6, 003, 5),
(7, 012, 9),
(8, 011, 9),
(9, 013, 9),
(10, 002, 5),
(11, 009, 7),
(12, 015, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos`
--

CREATE TABLE `modulos` (
  `codigo` int(10) UNSIGNED NOT NULL,
  `modulo` varchar(15) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `cod_curso` varchar(5) DEFAULT NULL,
  `cod_profesor` int(2) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modulos`
--

INSERT INTO `modulos` (`codigo`, `modulo`, `nombre`, `cod_curso`, `cod_profesor`) VALUES
(1, 'FOL', 'FOL', '1DAW', 03),
(3, 'FOL', 'FOL', '1GA', 03),
(5, 'BD', 'Base de Datos', '1DAW', 05),
(7, 'PHP', 'Desarrollo Servidor', '2DAW', 05),
(9, 'SO1', 'Sistemas 1', '1SMR', 01),
(10, 'CONTA1', 'Contabilidad', '1GA', 02),
(15, 'TESORERIA', 'Tesoreria', '2GA', 02);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `codigo` int(2) UNSIGNED ZEROFILL NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`codigo`, `nombre`, `apellido`) VALUES
(01, 'Lorenzo', 'Sánchez'),
(02, 'Ricardo', 'Sánchez'),
(03, 'María José', 'Rubio'),
(04, 'Isabel', 'Alcover'),
(05, 'Mariluz', 'Ruiz'),
(06, 'Lola', 'Ruiz'),
(07, 'Belén', 'Sánchez'),
(08, 'JAcobo', 'Lopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` varchar(3) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `ciclos`
--
ALTER TABLE `ciclos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cod_ciclo` (`cod_ciclo`);

--
-- Indices de la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cod_alumno` (`cod_alumno`),
  ADD KEY `cod_modulo` (`cod_modulo`);

--
-- Indices de la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cod_curso` (`cod_curso`),
  ADD KEY `cod_profesor` (`cod_profesor`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`cod_ciclo`) REFERENCES `ciclos` (`codigo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD CONSTRAINT `matriculas_ibfk_1` FOREIGN KEY (`cod_alumno`) REFERENCES `alumnos` (`codigo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `matriculas_ibfk_2` FOREIGN KEY (`cod_modulo`) REFERENCES `modulos` (`codigo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD CONSTRAINT `modulos_ibfk_1` FOREIGN KEY (`cod_curso`) REFERENCES `cursos` (`codigo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `modulos_ibfk_2` FOREIGN KEY (`cod_profesor`) REFERENCES `profesores` (`codigo`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
