-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2016 at 06:41 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `donor_list`
--

CREATE TABLE `donor_list` (
  `Name` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Confirm Password` varchar(30) DEFAULT NULL,
  `Address` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Contact No.` varchar(30) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Donate Blood Group` varchar(20) NOT NULL,
  `Last Donate Date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donor_list`
--

INSERT INTO `donor_list` (`Name`, `Password`, `Confirm Password`, `Address`, `Email`, `Contact No.`, `Gender`, `Donate Blood Group`, `Last Donate Date`) VALUES
('Farhan', 'abcdef', 'abcdef', 'Mirpur', 'farhan@yahoo.com', '01675383936', 'Male', 'AB+', NULL),
('Rakib', 'acndef', 'acndef', 'Khilgoan', 'Rakib21@gmail.com', '01839389293', 'Male', 'B+', NULL),
('Joy', 'defgs', 'defgs', 'Rampura', 'joy62@gmail.com', '01675243534', 'Male', 'A+', '2016-07-11'),
('Shovon', 'qwer', 'qwer', 'Mohammadpur', 'sovon.kundu@gmail.com', '01698367368', 'Male', 'AB-', '2016-03-11'),
('sam', 'sam', 'sam1', 'azimpur', 'sam23@gmail.com', '0134365566', 'Male', 'O+', '2016-06-02'),
('Shawon', '678', '678', 'polton', 'shawonbd@gmail.com', '964656788', 'Male', 'B-', '2015-03-02'),
('Shakil', '123', '123', 'puran dhaka', 'shakil.khan@yahoo.com', '787878787', 'Male', 'A-', '');

-- --------------------------------------------------------

--
-- Table structure for table `receiver_list`
--

CREATE TABLE `receiver_list` (
  `Name` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Contact No` varchar(10) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Needed Blood Group` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiver_list`
--

INSERT INTO `receiver_list` (`Name`, `Password`, `Address`, `Email`, `Contact No`, `Gender`, `Needed Blood Group`) VALUES
('Talha', '1234', 'ajimpur', 'talha.noyon@gmail.com', '099090998', 'Male', ' '),
('Alvi', '3456', 'Basundhara', 'alvi.rahman@yahoo.com', '0167543556', 'Female', ' '),
('Sajib', '2345', 'mogbazar', 'sajib@hotmail.com', '898796876', 'Male', NULL),
('Shosi', '7890', 'Nilkhet', 'shosi56@yahoo.com', '898989898', 'Male', 'A-'),
('Rohan', '890', 'Banglabzar', 'rohan67@hotmail.com', '8989898543', 'Male', 'B-'),
('Ashik', '567', 'sciencelab', 'ashik.ahmed@yahoo.com', '0145434435', 'Male', 'B-');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
