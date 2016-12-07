-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 07, 2016 at 02:46 PM
-- Server version: 5.7.16-0ubuntu0.16.04.1
-- PHP Version: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MaquinaRefrigerante`
--

-- --------------------------------------------------------

--
-- Table structure for table `bebidas`
--

CREATE TABLE `bebidas` (
  `indice` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `preco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bebidas`
--

INSERT INTO `bebidas` (`indice`, `nome`, `preco`) VALUES
(1, 'Coca', 4);

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `indice` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `latas`
--

CREATE TABLE `latas` (
  `indice` int(11) NOT NULL,
  `id_bebida` int(11) NOT NULL,
  `data_reposicao` datetime NOT NULL,
  `vendido` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `troco`
--

CREATE TABLE `troco` (
  `valor` float NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `troco`
--

INSERT INTO `troco` (`valor`, `quantidade`) VALUES
(0.5, 5),
(1, 5),
(2, 5),
(5, 4),
(10, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bebidas`
--
ALTER TABLE `bebidas`
  ADD PRIMARY KEY (`indice`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`indice`);

--
-- Indexes for table `latas`
--
ALTER TABLE `latas`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `Bebida_ID` (`id_bebida`);

--
-- Indexes for table `troco`
--
ALTER TABLE `troco`
  ADD PRIMARY KEY (`valor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `latas`
--
ALTER TABLE `latas`
  ADD CONSTRAINT `latas_ibfk_1` FOREIGN KEY (`id_bebida`) REFERENCES `bebidas` (`indice`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
