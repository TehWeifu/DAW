-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 06, 2022 at 09:31 AM
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
-- Database: `jbsl_libreria3`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `categoria` varchar(50) COLLATE utf16_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `categoria`) VALUES
(1, 'FicciÃ³n'),
(2, 'Terror'),
(3, 'Novela'),
(4, 'CÃ³mic'),
(5, 'Historiaaaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `libros`
--

CREATE TABLE `libros` (
  `id_libro` int(11) NOT NULL,
  `titulo` varchar(50) COLLATE utf16_spanish_ci DEFAULT NULL,
  `autor` varchar(40) COLLATE utf16_spanish_ci NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `precio` decimal(5,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Dumping data for table `libros`
--

INSERT INTO `libros` (`id_libro`, `titulo`, `autor`, `id_categoria`, `precio`) VALUES
(1, 'Harry Potter y la piedra filosofal', 'JK Rowling', 1, '15'),
(2, 'Harry Potter y la cÃ¡mara secreta', 'JK Rowling', 1, '8'),
(3, 'El ocho', 'Katherin Neville', 1, '10'),
(4, 'Wonder Woman', 'William Moulton', 4, '10'),
(5, 'Alicia en el paÃ­s de las maravillas', 'Lewis Carroll', 3, '11'),
(6, 'Los pilares de la tierra', 'Ken Follett', 5, '12'),
(7, 'El alquimista', 'Paolo Coelho', 3, '12'),
(8, 'El fuego', 'Katherin Neville', 1, '10'),
(9, 'La clave estÃ¡ en Rebeca', 'Ken Follett', 1, '8'),
(10, 'Secretos', 'Paolo Coelho', 1, '11'),
(11, 'Harry Potter y el prisionero de AzkabÃ¡n', 'JK Rowling', 1, '15'),
(12, 'Harry Potter y el cÃ¡liz de fuego', 'JK Rowling', 1, '16'),
(13, 'paco sanz y los 200000000 tumores', 'uwu', 4, '42');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id_libro`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
