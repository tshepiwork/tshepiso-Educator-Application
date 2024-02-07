-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2023 at 06:05 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fa3_assessment`
--

-- --------------------------------------------------------

--
-- Table structure for table `student_booking`
--

CREATE TABLE `student_booking` (
  `id` int(11) NOT NULL,
  `FName` varchar(10) NOT NULL COMMENT 'Student First Name',
  `LName` varchar(10) NOT NULL COMMENT 'Students last name',
  `Email` varchar(15) NOT NULL COMMENT 'Student email address',
  `Phone` varchar(10) NOT NULL COMMENT 'Student phone number',
  `Subject` varchar(15) NOT NULL COMMENT 'Subject to study'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_booking`
--

INSERT INTO `student_booking` (`id`, `FName`, `LName`, `Email`, `Phone`, `Subject`) VALUES
(1, 'ffd', 'fdfd', 'fe@fef', '47464765', 'emglish'),
(2, 'gdfg', 'dfgdfgg', 'gfdgdfgg', 'gfdgggdf', 'gdfgf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_booking`
--
ALTER TABLE `student_booking`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_booking`
--
ALTER TABLE `student_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
