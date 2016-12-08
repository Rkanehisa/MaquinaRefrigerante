-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 07-Dez-2016 às 22:44
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.5.35

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
(1, 1, '2016-08-03 00:00:00', 0);

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
(10, 5);
(5, 5),
(2, 5),
(1, 5),
(0.5, 5);

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
-- Limitadores para a tabela `latas`
--
ALTER TABLE `latas`
  ADD CONSTRAINT `latas_ibfk_1` FOREIGN KEY (`id_bebida`) REFERENCES `bebidas` (`indice`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
