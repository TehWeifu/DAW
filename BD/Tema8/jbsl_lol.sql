-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 01, 2022 at 09:11 AM
-- Server version: 10.3.28-MariaDB
-- PHP Version: 7.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jbsl_lol`
--

-- --------------------------------------------------------

--
-- Table structure for table `Campeon`
--

CREATE TABLE `Campeon` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clase` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaLanzamiento` date DEFAULT NULL,
  `precio` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Campeon`
--

INSERT INTO `Campeon` (`id`, `nombre`, `clase`, `fechaLanzamiento`, `precio`) VALUES
(1, 'Aatrox', 'luchador', '2013-06-13', 3000),
(2, 'Ahri', 'mago', '2011-12-14', 2000),
(3, 'Akali', 'asesino', '2009-02-21', 1000),
(4, 'Akshan', 'tirador', '2021-07-22', 1000),
(5, 'Bard', 'mago', '2015-03-12', 3000),
(6, 'Brand', 'mago', '2011-04-12', 3000),
(7, 'Corki', 'tirador', '2009-02-21', 1000),
(8, 'Darius', 'luchador', '2012-05-23', 2000),
(9, 'Draven', 'tirador', '2012-06-06', 1000),
(10, 'Ekko', 'asesino', '2015-05-29', 3000),
(11, 'Ezreal', 'tirador', '2010-03-16', 2000),
(12, 'Fizz', 'asesino', '2011-11-15', 3000),
(13, 'Garen', 'luchador', '2009-02-21', 1000),
(14, 'Gnar', 'luchador', '2014-08-14', 3000),
(15, 'Gwen', 'luchador', '2021-04-15', 1000),
(16, 'Irelia', 'luchador', '2010-11-16', 1000),
(17, 'Ivern', 'mago', '2016-10-05', 2000),
(18, 'Jhin', 'tirador', '2016-02-01', 2000),
(19, 'Jinx', 'tirador', '2013-10-10', 3000),
(20, 'Kalista', 'tirador', '2014-11-20', 1000),
(21, 'Kassadin', 'asesino', '2009-09-02', 3000),
(22, 'Katarina', 'asesino', '2009-09-19', 3000),
(23, 'LeBlanc', 'asesino', '2010-11-02', 2000),
(24, 'Lee Sin', 'luchador', '2011-04-01', 1000),
(25, 'Lulu', 'mago', '2012-03-20', 3000),
(26, 'Malzahar', 'mago', '2009-02-21', 3000),
(27, 'Morgana', 'mago', '2009-02-21', 2000),
(28, 'Nocturne', 'luchador', '2011-03-15', 2000),
(29, 'Pyke', 'asesino', '2018-05-31', 3000),
(30, 'Qiyana', 'asesino', '2019-06-28', 1000),
(31, 'Rengar', 'asesino', '2012-08-21', 3000),
(32, 'Teemo', 'mago', '2009-02-21', 1000),
(33, 'Yasuo', 'asesino', '2013-12-13', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `Habilidad`
--

CREATE TABLE `Habilidad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `puntosEnergia` int(10) UNSIGNED DEFAULT NULL,
  `enfriamiento` decimal(5,2) UNSIGNED DEFAULT NULL,
  `campeon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Habilidad`
--

INSERT INTO `Habilidad` (`id`, `nombre`, `puntosEnergia`, `enfriamiento`, `campeon`) VALUES
(1, 'La espada oscura', 0, '6.50', 1),
(2, 'Cadenas Infernales', 0, '20.00', 1),
(3, 'Impulso Siniestro', 0, '9.00', 1),
(4, 'Destructor de Mundos', 0, '140.00', 1),
(5, 'Orbe del embrujo', 100, '5.00', 2),
(6, 'Fuego fatuo', 50, '10.00', 2),
(7, 'Encanto', 50, '100.00', 2),
(8, 'Salto espiritual', 150, '120.00', 2),
(9, 'Estrella de cinco puntas', 0, '2.00', 3),
(10, 'Bomba de humo', 0, '20.00', 3),
(11, 'Salto con Shuriken', 0, '15.00', 3),
(12, 'Ejecucion Perfecta', 0, '100.00', 3),
(13, 'Boomerang', 50, '8.00', 4),
(14, 'Camuflaje', 100, '20.00', 4),
(15, 'Salto heroico', 0, '20.00', 4),
(16, 'Rafaga de disparos', 100, '100.00', 4),
(17, 'Hechizo cosmico', 50, '8.00', 5),
(18, 'Altar de curacion', 100, '14.00', 5),
(19, 'Viaje magino', 50, '20.00', 5),
(20, 'Destino dorado', 0, '120.00', 5),
(21, 'bola de fuego', 50, '5.00', 6),
(22, 'pilar de fuego', 90, '10.00', 6),
(23, 'erupcion', 50, '12.00', 6),
(24, 'pyroclasto', 100, '90.00', 6),
(25, 'decimar', 20, '8.00', 8),
(26, 'golpe sangrante', 30, '5.00', 8),
(27, 'atrapar', 50, '12.00', 8),
(28, 'gillotina noxiana', 0, '120.00', 8),
(29, 'hacha giratoria', 40, '10.00', 9),
(30, 'sprint', 30, '12.00', 9),
(31, 'apartar', 100, '20.00', 9),
(32, 'muerte giratoria', 100, '120.00', 9),
(33, 'Truncatiempo', 50, '8.00', 10),
(34, 'Convergencia paralela', 50, '20.00', 10),
(35, 'Salto de fase', 20, '10.00', 10),
(36, 'Chronobreak', 0, '100.00', 10),
(37, 'disparo mistico', 40, '3.00', 11),
(38, 'esencia de flujo', 50, '10.00', 11),
(39, 'salto arcano', 90, '20.00', 11),
(40, 'disparo verdadero', 100, '80.00', 11),
(41, 'Golpe urticante', 40, '8.00', 13),
(42, 'Tridente', 20, '3.00', 13),
(43, 'Gamberro', 80, '16.00', 13),
(44, 'Tiburon', 100, '60.00', 13),
(45, 'Lanzamiento de Boomerang', 0, '20.00', 14),
(46, 'Super', 0, '0.00', 14),
(47, 'Saltito', 0, '20.00', 14),
(48, 'GNAR!', 0, '60.00', 14),
(49, 'Lanzamiento de piedra', 0, '15.00', 14),
(50, 'Golpe aturdidor', 0, '20.00', 14),
(51, 'super salto', 0, '60.00', 14),
(52, 'snip snip', 20, '6.00', 15),
(53, 'Niebla oscura', 100, '20.00', 15),
(54, 'Salto y corte', 40, '10.00', 15),
(55, 'Un millon de agujas', 100, '120.00', 15),
(56, 'salto de espada', 20, '10.00', 16),
(57, 'Baile de espadas', 70, '20.00', 16),
(58, 'Desafio sigiloso', 50, '15.00', 16),
(59, 'Filo de espada', 100, '140.00', 16),
(60, 'llamada de raiz', 50, '14.00', 17),
(61, 'Arbusto', 30, '0.00', 17),
(62, 'Semilla explosiva', 70, '11.00', 17),
(63, 'MARGARIA', 100, '140.00', 17),
(64, 'POW-POW', 0, '0.00', 19),
(65, 'Huesitos', 0, '0.00', 19),
(66, 'trampas llama', 90, '24.00', 19),
(67, 'zap!', 50, '8.00', 19),
(68, 'super mega cohete espacial', 100, '80.00', 19),
(69, 'Perforar', 50, '8.00', 20),
(70, 'Centinela', 0, '0.00', 20),
(71, 'Rendicion', 30, '10.00', 20),
(72, 'llamada del destino', 100, '150.00', 20),
(73, 'Esfera nula', 70, '8.00', 21),
(74, 'Espada del vacio', 0, '0.00', 21),
(75, 'Pulso de energia', 60, '8.00', 21),
(76, 'Saltagrietas', 400, '2.00', 21),
(77, 'Daga rebotaqnte', 0, '8.00', 22),
(78, 'Preparacion', 0, '10.00', 22),
(79, 'destello', 0, '14.00', 22),
(80, 'Loto moral', 0, '90.00', 22),
(81, 'Sello de malicia', 50, '8.00', 23),
(82, 'Distorsion', 100, '14.00', 23),
(83, 'Cadenas etereas', 50, '14.00', 23),
(84, 'Mimica', 0, '30.00', 23),
(85, 'lanza de purpurina', 50, '7.00', 25),
(86, 'Hechizo', 50, '17.00', 25),
(87, 'Ayuda Pix', 60, '8.00', 25),
(88, 'Crecimiento Salvaje', 100, '120.00', 25),
(89, 'Llamada del vacio', 80, '6.00', 26),
(90, 'Bichos del vacio', 40, '8.00', 26),
(91, 'Visiones Maleficas', 60, '15.00', 26),
(92, 'Conjuro del vacio', 100, '140.00', 26),
(97, 'Hechizo oscuro', 50, '10.00', 27),
(98, 'piscina en teruel', 70, '12.00', 27),
(99, 'Escudo negro', 80, '24.00', 27),
(100, 'cadenas del alma', 100, '100.00', 27),
(101, 'Llamda del vacio', 60, '8.00', 28),
(102, 'escudo de oscuridad', 50, '20.00', 28),
(103, 'Horror inombrable', 60, '15.00', 28),
(104, 'Paranoia', 100, '140.00', 28),
(105, 'buscador de huesos', 60, '8.00', 29),
(106, 'aguas fantasmales', 50, '12.00', 29),
(107, 'desplazamiento sombrio', 60, '15.00', 29),
(108, 'Muerte desde abajo', 0, '120.00', 29),
(109, 'Salvaje', 0, '5.00', 31),
(110, 'Rugido salvaje', 0, '8.00', 31),
(111, 'Lazamiento de trampa', 0, '10.00', 31),
(112, 'Hora de la caza', 0, '60.00', 31),
(113, 'Dardo cegador', 70, '7.00', 32),
(114, 'Morverse rapido', 0, '14.00', 32),
(115, 'Dardo toxico', 0, '0.00', 32),
(116, 'Trampa noxiona', 0, '20.00', 32),
(117, 'Tempesta de acero', 0, '7.00', 33),
(118, 'Muro de viento', 0, '14.00', 33),
(119, 'Hijo del viento', 0, '1.00', 33),
(120, 'Ultimo aliento', 0, '80.00', 33),
(122, 'hola', 123, '1.00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Jugador`
--

CREATE TABLE `Jugador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `liga` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `puntosLiga` int(4) DEFAULT NULL,
  `monedas` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Jugador`
--

INSERT INTO `Jugador` (`id`, `nombre`, `liga`, `puntosLiga`, `monedas`) VALUES
(1, 'DeliriumTremens', 'Maestro', 350, 100000),
(2, 'Faker', 'Maestro', 1000, 999999),
(3, 'Santorin', 'Bronce', 23, 1500),
(4, 'Deft', 'Plata', 80, 12300),
(5, 'Canna', 'Oro', 20, 8900),
(6, 'Febiven', 'Plata', 0, 15000),
(7, 'Forg1venGRE', 'Bronce', 35, 120),
(8, 'Caps', 'Bronce', 98, 660),
(9, 'Rekkles', 'Plata', 45, 30300),
(10, 'Tyler1', 'Plata', 69, 800000),
(11, 'Perkz', 'Oro', 36, 65300),
(12, 'ElYoya', 'Plata', 2, 3200),
(13, 'Razork', 'Bronce', 15, 210000),
(14, 'Bjergsen', 'Bronce', 78, 87000),
(15, 'Jensen', 'Oro', 96, 770),
(16, 'Ming', 'Plata', 30, 8600),
(17, 'xPeke', 'Maestro', 65, 4100),
(18, 'Uzi', 'Oro', 42, 65000);

-- --------------------------------------------------------

--
-- Table structure for table `Tienen`
--

CREATE TABLE `Tienen` (
  `id` int(11) NOT NULL,
  `campeon` int(11) DEFAULT NULL,
  `jugador` int(11) DEFAULT NULL,
  `puntosMaestria` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Tienen`
--

INSERT INTO `Tienen` (`id`, `campeon`, `jugador`, `puntosMaestria`) VALUES
(1, 15, 10, 707),
(2, 6, 12, 4228590),
(3, 15, 3, 5549021),
(4, 11, 11, 8331473),
(5, 16, 3, 75),
(6, 11, 9, 4703768),
(7, 12, 3, 3184959),
(8, 1, 15, 6817163),
(9, 4, 12, 9477144),
(10, 16, 10, 2842710),
(11, 4, 1, 3693286),
(12, 24, 18, 5700470),
(13, 31, 13, 493253),
(14, 29, 2, 4636340),
(15, 30, 7, 4980815),
(16, 14, 17, 8164967),
(17, 31, 16, 8992106),
(18, 17, 3, 3571842),
(19, 22, 9, 4388034),
(20, 9, 4, 562909),
(21, 21, 3, 1045615),
(22, 21, 17, 2493315),
(23, 18, 4, 1963106),
(24, 11, 4, 4385978),
(25, 29, 10, 6962526),
(26, 31, 2, 5749945),
(27, 4, 14, 2058826),
(28, 24, 1, 4015393),
(29, 25, 3, 5029343),
(30, 27, 10, 1082578),
(31, 14, 8, 3526105),
(32, 32, 8, 2806009),
(33, 17, 18, 3855435),
(34, 25, 10, 1563962),
(35, 20, 1, 1163798),
(36, 12, 15, 4663429),
(37, 18, 14, 4622432),
(38, 13, 17, 4045764),
(39, 12, 5, 6851767),
(40, 23, 1, 3262758),
(41, 1, 6, 8132250),
(42, 4, 5, 4543889),
(43, 32, 15, 3883529),
(44, 23, 6, 7126142),
(45, 33, 1, 9785322),
(46, 14, 12, 6899603),
(47, 11, 7, 881991),
(48, 30, 15, 4555114),
(49, 8, 16, 6580323),
(50, 27, 11, 5194080),
(51, 18, 5, 2398546),
(52, 16, 11, 2392841),
(53, 8, 3, 4259258),
(54, 26, 7, 4505090),
(55, 22, 4, 3657363),
(56, 21, 6, 4180931),
(57, 29, 6, 5435383),
(58, 16, 6, 837452),
(59, 5, 13, 8186575),
(60, 17, 12, 4418566),
(61, 9, 12, 2030382),
(62, 32, 9, 528760),
(63, 15, 11, 975832),
(64, 30, 1, 676462),
(65, 33, 4, 3829518),
(66, 31, 1, 2221923),
(67, 12, 18, 5404262),
(68, 6, 2, 7424666),
(69, 10, 11, 9346046),
(70, 14, 2, 1839727),
(71, 7, 8, 673363),
(72, 27, 1, 4587470),
(73, 27, 15, 4523819),
(74, 26, 1, 9268324),
(75, 6, 11, 2085284),
(76, 8, 8, 1118347),
(77, 16, 18, 7059760),
(78, 32, 4, 770308),
(79, 24, 17, 3482180),
(80, 27, 9, 2947847),
(81, 27, 6, 3592491),
(82, 14, 14, 6240090),
(83, 20, 17, 4349018),
(84, 6, 7, 6623104),
(85, 11, 5, 4896095),
(86, 13, 9, 5105890),
(87, 28, 9, 7554112),
(88, 25, 6, 2824615),
(89, 10, 16, 874365),
(90, 15, 7, 2741735),
(91, 6, 1, 3063589),
(92, 24, 10, 8388942),
(93, 6, 10, 4149425),
(94, 13, 10, 4685869),
(95, 11, 2, 914391),
(96, 25, 17, 3298007),
(97, 29, 9, 4138164),
(98, 20, 11, 8186300),
(99, 32, 7, 6283311),
(100, 15, 8, 3050988),
(101, 22, 12, 6379750),
(102, 23, 13, 5744508),
(103, 18, 16, 4201991),
(104, 9, 18, 1177853),
(105, 4, 8, 8857588),
(106, 32, 14, 2090805),
(107, 2, 16, 9618867),
(108, 8, 2, 3051447),
(109, 5, 3, 235951),
(110, 25, 16, 4995755),
(111, 8, 1, 9567367),
(112, 1, 5, 9841845),
(113, 14, 11, 9218486),
(114, 2, 18, 7420843),
(115, 20, 7, 9281418),
(116, 5, 18, 9679758),
(117, 12, 4, 4786000),
(118, 15, 5, 6280521),
(119, 3, 1, 3130629),
(120, 26, 11, 5724457),
(121, 24, 8, 173718),
(122, 23, 12, 7483711),
(123, 2, 4, 1662341),
(124, 20, 12, 6785947),
(125, 10, 2, 7038588),
(126, 7, 3, 8492946),
(127, 16, 5, 3567962),
(128, 18, 18, 1002805),
(129, 5, 8, 8303045),
(130, 16, 7, 6880410),
(131, 17, 10, 2413123),
(132, 17, 4, 6052272),
(133, 2, 1, 1113109),
(134, 8, 14, 1007619),
(135, 1, 1, 221872),
(136, 29, 12, 6579188),
(137, 32, 17, 4133724),
(138, 17, 8, 5610267),
(139, 20, 5, 8633344),
(140, 2, 17, 2275414),
(141, 5, 1, 5485615),
(142, 14, 5, 9180973),
(143, 12, 6, 4551411),
(144, 25, 5, 8839702),
(145, 28, 11, 6673272),
(146, 1, 9, 1041106),
(147, 1, 17, 3836028),
(148, 14, 10, 3102518),
(149, 18, 15, 8388333),
(150, 9, 6, 7568801),
(151, 28, 5, 2102645),
(152, 25, 12, 3907933),
(153, 19, 3, 3063507),
(154, 23, 10, 9125876),
(155, 29, 7, 7863350),
(156, 13, 18, 8645772),
(157, 4, 2, 84591),
(158, 33, 7, 1845444),
(159, 23, 18, 6641222),
(160, 28, 1, 4281139),
(161, 10, 15, 3850795),
(162, 9, 9, 9786157),
(163, 27, 4, 2254628),
(164, 25, 14, 6181900),
(165, 32, 1, 1492411),
(166, 30, 8, 8481369),
(167, 24, 13, 5765356),
(168, 13, 8, 7544280),
(169, 31, 3, 70225),
(170, 21, 10, 2527127),
(171, 27, 2, 8168843),
(172, 27, 14, 8341349),
(173, 17, 9, 9690337),
(174, 19, 11, 1807436),
(175, 18, 3, 333001),
(176, 29, 18, 1650800),
(177, 28, 2, 583376),
(178, 11, 10, 148813),
(179, 26, 14, 3847330),
(180, 19, 12, 1111060),
(181, 31, 18, 6342778),
(182, 1, 11, 3338242),
(183, 25, 15, 5386415),
(184, 33, 9, 769435),
(185, 27, 8, 8464056),
(186, 31, 7, 2228870),
(187, 19, 5, 7631717),
(188, 15, 6, 7620894),
(189, 13, 16, 4690747),
(190, 32, 12, 3058492),
(191, 23, 11, 4370952),
(192, 8, 18, 1882820),
(193, 15, 18, 7812325),
(194, 25, 1, 3409381),
(195, 23, 15, 398165),
(196, 17, 13, 8517427),
(197, 7, 18, 3610410),
(198, 3, 18, 9580202),
(199, 19, 10, 5759175),
(200, 28, 17, 4151431),
(201, 4, 18, 2006703),
(202, 1, 13, 8176043),
(203, 19, 8, 3119387),
(204, 19, 14, 8632738),
(205, 14, 3, 8328358),
(206, 10, 12, 6835633),
(207, 13, 7, 3165192),
(208, 21, 5, 4310198),
(209, 25, 18, 1954889),
(210, 5, 5, 5300393),
(211, 3, 8, 1430855),
(212, 8, 7, 2734759),
(213, 6, 14, 2720083),
(214, 9, 7, 4565828),
(215, 27, 12, 4212482),
(216, 19, 9, 7538210),
(217, 23, 2, 189251),
(218, 3, 4, 6172437),
(219, 4, 13, 2651751),
(220, 31, 14, 1622658),
(222, 9, 14, 2470714),
(223, 17, 1, 2726592),
(224, 8, 11, 7272391),
(225, 33, 6, 1909150),
(226, 9, 1, 6587810),
(227, 28, 15, 3359377),
(228, 21, 13, 7977910),
(229, 14, 7, 1935676),
(230, 7, 1, 5213592),
(231, 13, 1, 8848240),
(232, 16, 15, 4932218),
(233, 25, 9, 9982898),
(234, 5, 4, 3405380),
(235, 24, 6, 7810746),
(236, 23, 17, 2090492),
(237, 12, 17, 752360),
(238, 7, 9, 2031355),
(239, 29, 13, 1588368),
(240, 4, 3, 6069554),
(241, 17, 2, 886488),
(242, 21, 11, 2345991),
(243, 10, 18, 1348608),
(244, 23, 4, 7150374),
(245, 30, 14, 8302810),
(246, 1, 18, 866384),
(247, 12, 7, 360573),
(248, 32, 6, 5688562),
(249, 26, 12, 8113063),
(250, 19, 16, 9289204),
(251, 33, 13, 157072),
(252, 33, 17, 7621399),
(253, 32, 16, 9737361),
(254, 15, 16, 1419691),
(255, 13, 14, 3713483),
(256, 18, 13, 2484058),
(257, 4, 4, 5525146),
(258, 6, 15, 6619146),
(259, 19, 17, 7337730),
(260, 31, 12, 4267292),
(261, 24, 11, 1762695),
(262, 18, 11, 9333118),
(263, 3, 7, 6893921),
(264, 31, 9, 3161606),
(265, 13, 3, 3669453),
(266, 9, 8, 1080402),
(267, 26, 10, 151475),
(268, 9, 3, 3567344),
(269, 3, 6, 9024631),
(270, 20, 8, 914619),
(271, 24, 14, 731110),
(272, 24, 9, 3953186),
(273, 21, 9, 2809001),
(274, 4, 11, 1967904),
(275, 29, 8, 6582735),
(276, 24, 7, 5830916),
(277, 31, 17, 9823046),
(278, 30, 12, 5340461),
(279, 4, 16, 8621001),
(280, 6, 16, 90962),
(281, 8, 9, 9679628),
(282, 5, 14, 9341001),
(283, 20, 6, 5299147),
(284, 33, 16, 4001808),
(285, 20, 15, 9349102),
(286, 26, 3, 2326512),
(287, 33, 11, 1278988),
(288, 10, 7, 2997275),
(289, 14, 1, 650557),
(290, 18, 10, 8342026),
(291, 17, 15, 686637),
(292, 11, 16, 3046029),
(293, 30, 5, 252143),
(294, 17, 16, 3132420),
(295, 9, 5, 4393991),
(296, 10, 3, 5254552),
(297, 10, 4, 1941110),
(298, 22, 15, 4051389),
(299, 2, 5, 5227271),
(300, 6, 18, 6776721),
(301, 28, 13, 4971673),
(302, 13, 6, 898497),
(303, 1, 2, 18901),
(304, 2, 12, 1018975),
(305, 29, 3, 3296939),
(306, 33, 10, 2818787),
(307, 2, 15, 1430662),
(308, 5, 6, 5378501),
(309, 26, 16, 2282495),
(310, 30, 10, 6331994),
(311, 3, 5, 111941),
(312, 6, 4, 5591147),
(313, 3, 11, 5326438),
(314, 27, 16, 1197721),
(315, 11, 6, 7955243),
(316, 33, 18, 3906924),
(317, 18, 6, 9936256),
(318, 12, 12, 9813327),
(319, 15, 12, 2169665),
(320, 4, 15, 8704387),
(321, 32, 13, 6142989),
(322, 2, 8, 5154456),
(323, 8, 6, 4191318),
(324, 9, 17, 8689948),
(325, 14, 16, 9270178),
(326, 10, 8, 8590449),
(327, 12, 9, 2186404),
(328, 13, 4, 3839169),
(329, 28, 16, 5492937),
(330, 2, 11, 8477415),
(331, 21, 2, 7199487),
(332, 32, 11, 9594734),
(333, 19, 13, 5547649),
(334, 8, 13, 2673040),
(335, 8, 15, 1965783),
(336, 1, 7, 5347173),
(337, 26, 17, 8090199),
(338, 23, 5, 6596662),
(339, 31, 11, 8046225),
(340, 11, 15, 5950787),
(341, 10, 5, 1660173);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Campeon`
--
ALTER TABLE `Campeon`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indexes for table `Habilidad`
--
ALTER TABLE `Habilidad`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `campeon` (`campeon`);

--
-- Indexes for table `Jugador`
--
ALTER TABLE `Jugador`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indexes for table `Tienen`
--
ALTER TABLE `Tienen`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `campeon_2` (`campeon`,`jugador`),
  ADD KEY `campeon` (`campeon`),
  ADD KEY `jugador` (`jugador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Campeon`
--
ALTER TABLE `Campeon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `Habilidad`
--
ALTER TABLE `Habilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT for table `Jugador`
--
ALTER TABLE `Jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `Tienen`
--
ALTER TABLE `Tienen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=349;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Habilidad`
--
ALTER TABLE `Habilidad`
  ADD CONSTRAINT `Habilidad_ibfk_1` FOREIGN KEY (`campeon`) REFERENCES `Campeon` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `Tienen`
--
ALTER TABLE `Tienen`
  ADD CONSTRAINT `Tienen_ibfk_1` FOREIGN KEY (`campeon`) REFERENCES `Campeon` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Tienen_ibfk_2` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
