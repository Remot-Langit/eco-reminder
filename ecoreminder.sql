-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 31, 2023 at 08:29 AM
-- Server version: 11.1.2-MariaDB
-- PHP Version: 8.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fikri_ecoreminder`
--

-- --------------------------------------------------------

--
-- Table structure for table `capaian`
--

CREATE TABLE IF NOT EXISTS `capaian` (
  `id_capaian` varchar(36) NOT NULL,
  `id_user` varchar(36) NOT NULL DEFAULT 'NULL',
  `id_challange` varchar(36) NOT NULL DEFAULT 'NULL',
  `start` timestamp NOT NULL DEFAULT current_timestamp(),
  `finish` tinyint(1) NOT NULL DEFAULT 0,
  `point` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_capaian`),
  KEY `id_user` (`id_user`),
  KEY `id_challange` (`id_challange`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `capaian`
--
DELIMITER $$
CREATE TRIGGER `update_point` AFTER UPDATE ON `capaian` FOR EACH ROW UPDATE point
SET point.`point` = point.`point` + NEW.`point`
WHERE point.id_user = NEW.id_user
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `challange`
--

CREATE TABLE IF NOT EXISTS `challange` (
  `id_challange` varchar(36) NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `nama_challange` varchar(50) DEFAULT NULL,
  `jumlah_hari` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `id_user` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_challange`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `challange`
--

INSERT INTO `challange` (`id_challange`, `deskripsi`, `nama_challange`, `jumlah_hari`, `point`, `id_user`) VALUES
('c1d67f4b-6a96-4cff-b217-78d7ccb277e9', 'jalan kaki', 'fairuz', 1, 10, '9add04a2-a791-11ee-8d0d-0050564d6b08');

-- --------------------------------------------------------

--
-- Table structure for table `edukasi`
--

CREATE TABLE IF NOT EXISTS `edukasi` (
  `id_edukasi` varchar(36) NOT NULL,
  `judul` varchar(50) DEFAULT NULL,
  `materi` text DEFAULT NULL,
  `referensi` varchar(50) DEFAULT NULL,
  `id_user` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_edukasi`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `edukasi`
--

INSERT INTO `edukasi` (`id_edukasi`, `judul`, `materi`, `referensi`, `id_user`) VALUES
('9a2eaa82-f67c-4ce5-9426-df5133a28fd0', 'Hirup udara pagi', 'udara pagi seger', '', '9add04a2-a791-11ee-8d0d-0050564d6b08');

-- --------------------------------------------------------

--
-- Table structure for table `point`
--

CREATE TABLE IF NOT EXISTS `point` (
  `id_user` varchar(36) NOT NULL,
  `point` int(11) DEFAULT NULL,
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `point`
--

INSERT INTO `point` (`id_user`, `point`) VALUES
('752359ce-e4bb-4d43-bbde-4fcef7f1e172', 0),
('af301c27-60fc-4dc7-8023-c4a0fb3cb902', 0),
('9e6e3f67-87ed-4403-96f0-4bf1fa84b9c9', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` varchar(36) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role` enum('Admin','Member') DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `email`, `role`) VALUES
('3b1ab7bc-a791-11ee-8d0d-0050564d6b08', 'admin', 'admin123', 'Si Admin', 'admin@gmail.com', 'Admin'),
('752359ce-e4bb-4d43-bbde-4fcef7f1e172', 'namaku1801', 'p', 'Mohamad Fikri', 'namaku1801@gmail.com', 'Member'),
('83ffce62-a791-11ee-8d0d-0050564d6b08', 'astuti', 'astuti', 'Astuti Solihatunnisa', 'astuti@upi.edu', 'Admin'),
('9add04a2-a791-11ee-8d0d-0050564d6b08', 'fairuz', 'fairuz', 'Fairuz Zulia Muntaha', 'fairuz@upi.edu', 'Admin'),
('9e6e3f67-87ed-4403-96f0-4bf1fa84b9c9', 'fzliaa', '12345', 'fairuz zulia', 'fairuzzulia19@gmail.com', 'Member'),
('af301c27-60fc-4dc7-8023-c4a0fb3cb902', 'anu', 'su', 'Ber anu', 'anu@gmail.com', 'Member'),
('b1580c98-a791-11ee-8d0d-0050564d6b08', 'fikri', 'fikri', 'Mohamad Fikri', 'fikri@upi.edu', 'Admin'),
('c68dbe3c-a791-11ee-8d0d-0050564d6b08', 'hikmat', 'hikmat', 'Muhammad Hikmat Mustofa', 'hikmat@upi.edu', 'Admin'),
('d8f235d8-a791-11ee-8d0d-0050564d6b08', 'sri', 'sri', 'Sri Rahayu', 'sri@upi.edu', 'Admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `capaian`
--
ALTER TABLE `capaian`
  ADD CONSTRAINT `capaian_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `capaian_ibfk_2` FOREIGN KEY (`id_challange`) REFERENCES `challange` (`id_challange`);

--
-- Constraints for table `challange`
--
ALTER TABLE `challange`
  ADD CONSTRAINT `challange_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `edukasi`
--
ALTER TABLE `edukasi`
  ADD CONSTRAINT `edukasi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `point`
--
ALTER TABLE `point`
  ADD CONSTRAINT `point_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`fikri_remotlangit`@`%` EVENT `update_capaian` ON SCHEDULE EVERY 1 HOUR STARTS '2023-12-30 14:45:04' ON COMPLETION PRESERVE ENABLE DO UPDATE capaian
INNER JOIN challange
ON capaian.id_challange = challange.id_challange
SET capaian.finish = TRUE 
WHERE CURRENT_TIMESTAMP >= ( capaian.`start`  + INTERVAL challange.jumlah_hari DAY ) AND capaian.finish = FALSE$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
