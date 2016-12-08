-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Dez-2016 às 20:24
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maquinarefrigerante`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bebidas`
--

CREATE TABLE `bebidas` (
  `indice` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `preco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `bebidas`
--

INSERT INTO `bebidas` (`indice`, `nome`, `preco`) VALUES
(1, 'Coca Cola', 8.5),
(2, 'Pepsi', 3.5),
(3, 'Mtn. Dew', 4),
(4, 'Soylent Green', 6.5),
(5, 'Crystal Pepsi', 7.5),
(6, 'Dr. Pepper', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `indice` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`indice`, `login`, `senha`) VALUES
(1, 'Jonas', 'jonasotraidor95'),
(2, 'Muddy', 'muddy256');

-- --------------------------------------------------------

--
-- Estrutura da tabela `latas`
--

CREATE TABLE `latas` (
  `indice` int(11) NOT NULL,
  `id_bebida` int(11) NOT NULL,
  `data_reposicao` datetime NOT NULL,
  `vendido` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `latas`
--

INSERT INTO `latas` (`indice`, `id_bebida`, `data_reposicao`, `vendido`) VALUES
(1, 1, '2016-08-03 00:00:00', 0),
(2, 1, '2016-08-03 00:00:00', 0),
(3, 1, '2016-08-03 00:00:00', 0),
(4, 1, '2016-08-03 00:00:00', 0),
(5, 1, '2016-08-03 00:00:00', 0),
(6, 1, '2016-08-03 00:00:00', 0),
(7, 1, '2016-08-03 00:00:00', 0),
(8, 1, '2016-08-03 00:00:00', 0),
(9, 1, '2016-08-03 00:00:00', 0),
(10, 1, '2016-08-03 00:00:00', 0),
(11, 2, '2016-08-03 00:00:00', 0),
(12, 2, '2016-08-03 00:00:00', 0),
(13, 2, '2016-08-03 00:00:00', 0),
(14, 2, '2016-08-03 00:00:00', 0),
(15, 2, '2016-08-03 00:00:00', 0),
(16, 2, '2016-08-03 00:00:00', 0),
(17, 2, '2016-08-03 00:00:00', 0),
(18, 2, '2016-08-03 00:00:00', 0),
(19, 2, '2016-08-03 00:00:00', 0),
(20, 2, '2016-08-03 00:00:00', 0),
(21, 3, '2016-08-03 00:00:00', 0),
(22, 3, '2016-08-03 00:00:00', 0),
(23, 3, '2016-08-03 00:00:00', 0),
(24, 3, '2016-08-03 00:00:00', 0),
(25, 3, '2016-08-03 00:00:00', 0),
(26, 3, '2016-08-03 00:00:00', 0),
(27, 3, '2016-08-03 00:00:00', 0),
(28, 3, '2016-08-03 00:00:00', 0),
(29, 3, '2016-08-03 00:00:00', 0),
(30, 3, '2016-08-03 00:00:00', 0),
(31, 4, '2016-08-03 00:00:00', 0),
(32, 4, '2016-08-03 00:00:00', 0),
(33, 4, '2016-08-03 00:00:00', 0),
(34, 4, '2016-08-03 00:00:00', 0),
(35, 4, '2016-08-03 00:00:00', 0),
(36, 4, '2016-08-03 00:00:00', 0),
(37, 4, '2016-08-03 00:00:00', 0),
(38, 4, '2016-08-03 00:00:00', 0),
(39, 4, '2016-08-03 00:00:00', 0),
(40, 4, '2016-08-03 00:00:00', 0),
(41, 5, '2016-08-03 00:00:00', 0),
(42, 5, '2016-08-03 00:00:00', 0),
(43, 5, '2016-08-03 00:00:00', 0),
(44, 5, '2016-08-03 00:00:00', 0),
(45, 5, '2016-08-03 00:00:00', 0),
(46, 5, '2016-08-03 00:00:00', 0),
(47, 5, '2016-08-03 00:00:00', 0),
(48, 5, '2016-08-03 00:00:00', 0),
(49, 5, '2016-08-03 00:00:00', 0),
(50, 5, '2016-08-03 00:00:00', 0),
(51, 6, '2016-08-03 00:00:00', 0),
(52, 6, '2016-08-03 00:00:00', 0),
(53, 6, '2016-08-03 00:00:00', 0),
(54, 6, '2016-08-03 00:00:00', 0),
(55, 6, '2016-08-03 00:00:00', 0),
(56, 6, '2016-08-03 00:00:00', 0),
(57, 6, '2016-08-03 00:00:00', 0),
(58, 6, '2016-08-03 00:00:00', 0),
(59, 6, '2016-08-03 00:00:00', 0),
(60, 6, '2016-08-03 00:00:00', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `troco`
--

CREATE TABLE `troco` (
  `valor` float NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `troco`
--

INSERT INTO `troco` (`valor`, `quantidade`) VALUES
(0.5, 10),
(1, 10),
(2, 10),
(5, 10),
(10, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `latas`
--
ALTER TABLE `latas`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `indice` (`indice`),
  ADD KEY `indice_2` (`indice`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
