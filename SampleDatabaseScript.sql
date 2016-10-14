-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2014 at 09:20 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ergasia`
--

-- --------------------------------------------------------

--
-- Table structure for table `_group`
--

CREATE TABLE IF NOT EXISTS `_group` (
  `Group_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Group_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `_group`
--

INSERT INTO `_group` (`Group_ID`, `Name`) VALUES
(3, 'Abstract'),
(4, 'Allegorical'),
(5, 'Landscape'),
(6, 'Nude'),
(7, 'Urban'),
(8, 'Animals'),
(9, 'Nature'),
(10, 'Portait'),
(11, 'Conseptual'),
(12, 'Satire'),
(13, 'Spiritual'),
(14, 'Wildlife'),
(15, 'Impressionism'),
(16, 'Surrealism'),
(17, 'UFO');

-- --------------------------------------------------------

--
-- Table structure for table `art`
--

CREATE TABLE IF NOT EXISTS `art` (
  `Art_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Sale_ID` int(11) DEFAULT NULL,
  `Artist_ID` int(11) NOT NULL,
  `Type` varchar(25) DEFAULT NULL,
  `Enroll_Year` varchar(25) DEFAULT NULL,
  `Name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Art_ID`),
  KEY `FK_Relationship_4` (`Sale_ID`),
  KEY `FK_Relationship_6` (`Artist_ID`),
  FULLTEXT KEY `Name` (`Name`,`Type`),
  FULLTEXT KEY `Name_2` (`Name`,`Type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `art`
--

INSERT INTO `art` (`Art_ID`, `Sale_ID`, `Artist_ID`, `Type`, `Enroll_Year`, `Name`) VALUES
(4, 9, 4, 'Building', '2001', 'Parthenon'),
(6, 11, 4, 'Xarti', '2001', 'Kolopaper'),
(7, 11, 4, 'Building', '2002', 'Pathe'),
(8, 10, 22, 'Statue', '1990', 'Beautiful Statue'),
(9, 8, 1, 'Trilalo', '2003', 'Qwerty'),
(10, 5, 1, 'Statue', '2000', 'Typ'),
(11, 8, 12, 'Math', '2001', 'Xyz'),
(12, 7, 4, 'Game', '2002', 'League');

-- --------------------------------------------------------

--
-- Table structure for table `art_group`
--

CREATE TABLE IF NOT EXISTS `art_group` (
  `Art_ID` int(11) NOT NULL,
  `Group_ID` int(11) NOT NULL,
  KEY `FK_Relationship_2` (`Group_ID`),
  KEY `FK_Relationship_3` (`Art_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `art_group`
--

INSERT INTO `art_group` (`Art_ID`, `Group_ID`) VALUES
(6, 3),
(7, 16),
(6, 17),
(8, 17),
(4, 7);

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
  `Artist_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Artist_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`Artist_ID`, `Name`) VALUES
(1, 'Bucky Roberts'),
(2, 'Miranda Papadopoulou'),
(3, 'Donatello'),
(4, 'Mikey'),
(5, 'John Smith'),
(6, 'Leonardo'),
(7, 'Raphael'),
(8, 'Sandro Botticelli'),
(9, 'Alatini Paulidi'),
(10, 'Levies'),
(11, 'Phneloph Delta'),
(12, 'Zouboulia Abatzidou'),
(13, 'El Greco'),
(14, 'Peter Paul Rubens'),
(15, 'Gian Lorenzo Bernini'),
(16, 'Francisco de Goya'),
(17, 'Édouard Manet'),
(18, 'Heidi'),
(19, 'Sofia Papanikolaou'),
(20, 'Asdf Qwerty'),
(21, 'Qwerty Asdf'),
(22, 'Georgios Georgiou'),
(23, 'zxcc');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `Customer_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  `Surname` varchar(25) DEFAULT NULL,
  `Address` varchar(25) DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`Customer_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_ID`, `Name`, `Surname`, `Address`, `Phone`) VALUES
(18, 'Walter', 'Black', 'Smurf Vilalge12', 43367644),
(19, 'John', 'Black', 'Bakers way 45', 80054045),
(20, 'Mary', 'Poppins', 'Hammroad 77', 54378543),
(21, 'Doctor', 'Who', 'Tardis 34', 47887209),
(22, 'Doctor', 'Poo', 'Turdis 33', 73847893),
(23, 'Rory', 'Williams', 'Wallaby way 42', 36489012),
(24, 'Emilia', 'Pond', 'Waiting way 45', 47583051),
(25, 'David', 'Tennant', 'Damn road 4', 47589298),
(26, 'Will', 'Smith', 'Carlibar road 312', 47502475),
(27, 'Matt', 'Smith', 'Main Street 45', 49531678),
(28, 'Peter', 'Capaldi', 'Eggshell way 98', 72735687),
(29, 'Christopher', 'Eccleston', 'Grasmere road 3', 58716498),
(30, 'Rose', 'Tyler', 'Lotsoftears 12', 44450159),
(31, 'Dean', 'Winchester', 'Sonosfbitches 55', 10009988),
(32, 'Sam', 'Winchester', 'Deanomgno 666', 44775800),
(33, 'Jensen', 'Ackles', 'WtfamIdoing 123', 22001486),
(34, 'Jared', 'Padaleki', 'Withmylife 321', 87123000),
(35, 'Miranda', 'Papadakh', 'Karaolh kai dhmitriou 7', 453455);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `Sale_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_ID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Sale_ID`),
  KEY `FK_Relationship_5` (`Customer_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`Sale_ID`, `Customer_ID`, `Date`) VALUES
(1, 20, '2031-02-22'),
(3, 24, '2003-12-02'),
(4, 33, '2010-03-30'),
(5, 32, '2010-03-22'),
(6, 18, '2010-01-20'),
(7, 18, '2010-09-04'),
(8, 18, '2014-08-07'),
(9, 21, '2012-09-07'),
(10, 21, '2012-09-06'),
(11, 21, '2012-09-11');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `art`
--
ALTER TABLE `art`
  ADD CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`Sale_ID`) REFERENCES `sale` (`Sale_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`Artist_ID`) REFERENCES `artist` (`Artist_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `art_group`
--
ALTER TABLE `art_group`
  ADD CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`Group_ID`) REFERENCES `_group` (`Group_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`Art_ID`) REFERENCES `art` (`Art_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
