-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2021 at 07:55 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `security_question` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `username`, `password`, `gender`, `email_id`, `phone_no`, `security_question`, `answer`, `date_Time`) VALUES
(1, 'P K Roy', 'admin', '123456', 'Male', 'admin123@gmail.com', '9999999999', 'Your Place of birth?', 'demo', '2021-01-22 12:41:02');

-- --------------------------------------------------------

--
-- Table structure for table `admin_login_information`
--

CREATE TABLE `admin_login_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_login_information`
--

INSERT INTO `admin_login_information` (`id`, `name`, `username`, `date_Time`) VALUES
(1, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 21:29:29'),
(2, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 21:41:29'),
(3, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 22:25:58'),
(4, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:29:32'),
(5, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:44:23'),
(6, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:49:08'),
(7, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:51:43'),
(8, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:53:55'),
(9, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:09:15'),
(10, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:14:37'),
(11, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:30:17'),
(12, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 09:12:39'),
(13, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:29:29'),
(14, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:33:32'),
(15, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:44:24'),
(16, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:52:05'),
(17, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:53:26'),
(18, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 17:06:56'),
(19, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 17:42:33'),
(20, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:00:50'),
(21, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:07:14'),
(22, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:09:50'),
(23, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:10:37'),
(24, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:13:09'),
(25, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:15:13'),
(26, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:18:34'),
(27, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:20:34'),
(28, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:22:41'),
(29, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:29:21'),
(30, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:30:21'),
(31, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:41:46'),
(32, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:42:20'),
(33, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:43:38'),
(34, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:04:13'),
(35, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:11:07'),
(36, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:23:07'),
(37, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:40:19'),
(38, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:02:28'),
(39, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:09:27'),
(40, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:14:17'),
(41, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:18:37'),
(42, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:21:24'),
(43, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:59:07'),
(44, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 21:02:15'),
(45, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 21:13:44'),
(46, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 21:21:33'),
(47, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-03 20:00:56'),
(48, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-08 20:44:39'),
(49, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-08 20:52:24'),
(50, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:17:44'),
(51, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:28:43'),
(52, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:29:25'),
(53, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:31:56'),
(54, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:34:12'),
(55, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:34:33'),
(56, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 11:27:24'),
(57, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 17:17:05'),
(58, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 17:21:42'),
(59, 'P K Roy', 'admin', '2021-02-09 22:29:59'),
(60, 'P K Roy', 'admin', '2021-02-19 15:42:17'),
(61, 'P K Roy', 'admin', '2021-02-19 15:44:32'),
(62, 'P K Roy', 'admin', '2021-02-19 15:53:34'),
(63, 'P K Roy', 'admin', '2021-02-19 16:32:31'),
(64, 'P K Roy', 'admin', '2021-02-19 16:43:33'),
(65, 'P K Roy', 'admin', '2021-02-19 16:45:17'),
(66, 'P K Roy', 'admin', '2021-02-19 16:46:31'),
(67, 'P K Roy', 'admin', '2021-02-19 16:51:18'),
(68, 'P K Roy', 'admin', '2021-02-19 16:52:52'),
(69, 'P K Roy', 'admin', '2021-02-19 16:53:28'),
(70, 'P K Roy', 'admin', '2021-02-19 16:54:36'),
(71, 'P K Roy', 'admin', '2021-02-19 17:00:28'),
(72, 'P K Roy', 'admin', '2021-02-19 17:00:35'),
(73, 'P K Roy', 'admin', '2021-02-19 17:00:46'),
(74, 'P K Roy', 'admin', '2021-02-19 17:01:02'),
(75, 'P K Roy', 'admin', '2021-02-19 17:01:05'),
(76, 'P K Roy', 'admin', '2021-02-19 17:01:08'),
(77, 'P K Roy', 'admin', '2021-02-19 17:01:10'),
(78, 'P K Roy', 'admin', '2021-02-19 17:01:12'),
(79, 'P K Roy', 'admin', '2021-02-19 17:02:42'),
(80, 'P K Roy', 'admin', '2021-02-19 17:03:17'),
(81, 'P K Roy', 'admin', '2021-02-19 17:03:29'),
(82, 'P K Roy', 'admin', '2021-02-19 17:07:24'),
(83, 'P K Roy', 'admin', '2021-02-19 17:07:41'),
(84, 'P K Roy', 'admin', '2021-02-19 17:08:26'),
(85, 'P K Roy', 'admin', '2021-02-19 17:08:41'),
(86, 'P K Roy', 'admin', '2021-02-19 17:10:26'),
(87, 'P K Roy', 'admin', '2021-02-19 17:14:41'),
(88, 'P K Roy', 'admin', '2021-02-19 17:19:53'),
(89, 'P K Roy', 'admin', '2021-02-19 17:20:02'),
(90, 'P K Roy', 'admin', '2021-02-19 17:43:04'),
(91, 'P K Roy', 'admin', '2021-02-19 17:43:56'),
(92, 'P K Roy', 'admin', '2021-02-19 17:44:04'),
(93, 'P K Roy', 'admin', '2021-02-19 17:44:27'),
(94, 'P K Roy', 'admin', '2021-02-19 17:44:44'),
(95, 'P K Roy', 'admin', '2021-02-19 17:46:03'),
(96, 'P K Roy', 'admin', '2021-02-19 17:46:43'),
(97, 'P K Roy', 'admin', '2021-02-19 17:47:30'),
(98, 'P K Roy', 'admin', '2021-02-19 17:47:38'),
(99, 'P K Roy', 'admin', '2021-02-19 17:47:57'),
(100, 'P K Roy', 'admin', '2021-02-19 17:49:19'),
(101, 'P K Roy', 'admin', '2021-02-19 17:49:26'),
(102, 'P K Roy', 'admin', '2021-02-19 17:50:22'),
(103, 'P K Roy', 'admin', '2021-02-19 17:51:23'),
(104, 'P K Roy', 'admin', '2021-02-19 17:51:39'),
(105, 'P K Roy', 'admin', '2021-02-19 17:52:26'),
(106, 'P K Roy', 'admin', '2021-02-19 17:52:33'),
(107, 'P K Roy', 'admin', '2021-02-19 17:53:46'),
(108, 'P K Roy', 'admin', '2021-02-19 17:53:54'),
(109, 'P K Roy', 'admin', '2021-02-19 17:54:25'),
(110, 'P K Roy', 'admin', '2021-02-19 17:54:32'),
(111, 'P K Roy', 'admin', '2021-02-24 11:19:36'),
(112, 'P K Roy', 'admin', '2021-02-24 11:20:14'),
(113, 'P K Roy', 'admin', '2021-02-24 11:23:52'),
(114, 'P K Roy', 'admin', '2021-02-24 11:29:23'),
(115, 'P K Roy', 'admin', '2021-02-24 11:44:55'),
(116, 'P K Roy', 'admin', '2021-02-24 12:17:53'),
(117, 'P K Roy', 'admin', '2021-02-24 12:19:56'),
(118, 'P K Roy', 'admin', '2021-02-24 12:21:42');

-- --------------------------------------------------------

--
-- Table structure for table `admin_logout_information`
--

CREATE TABLE `admin_logout_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_logout_information`
--

INSERT INTO `admin_logout_information` (`id`, `name`, `username`, `date_Time`) VALUES
(1, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 21:39:32'),
(2, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 21:42:58'),
(3, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 22:39:43'),
(4, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:34:38'),
(5, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:44:29'),
(6, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:49:12'),
(7, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:51:48'),
(8, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-30 23:54:03'),
(9, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:09:23'),
(10, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:15:09'),
(11, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 00:30:18'),
(12, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 09:12:45'),
(13, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:30:24'),
(14, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:34:31'),
(15, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:45:22'),
(16, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 16:53:43'),
(17, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 17:10:06'),
(18, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 17:59:12'),
(19, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:03:48'),
(20, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:17:55'),
(21, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:22:11'),
(22, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:27:38'),
(23, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 18:41:49'),
(24, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:08:34'),
(25, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:15:27'),
(26, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:23:27'),
(27, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 19:40:21'),
(28, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 20:25:56'),
(29, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 21:02:47'),
(30, 'Tathagata Bandyopadhyay', 'tathagata', '2021-01-31 21:14:02'),
(31, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-03 20:01:03'),
(32, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-08 20:44:59'),
(33, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-08 20:55:06'),
(34, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:18:35'),
(35, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:28:48'),
(36, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:29:37'),
(37, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:32:01'),
(38, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 09:34:17'),
(39, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 11:28:21'),
(40, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 17:17:14'),
(41, 'Tathagata Bandyopadhyay', 'tathagata', '2021-02-09 17:26:09'),
(42, 'P K Roy', 'admin', '2021-02-19 15:44:58'),
(43, 'P K Roy', 'admin', '2021-02-19 15:53:48'),
(44, 'P K Roy', 'admin', '2021-02-19 16:53:37'),
(45, 'P K Roy', 'admin', '2021-02-19 16:54:54'),
(46, 'P K Roy', 'admin', '2021-02-19 17:00:30'),
(47, 'P K Roy', 'admin', '2021-02-19 17:00:38'),
(48, 'P K Roy', 'admin', '2021-02-19 17:00:53'),
(49, 'P K Roy', 'admin', '2021-02-19 17:01:04'),
(50, 'P K Roy', 'admin', '2021-02-19 17:01:06'),
(51, 'P K Roy', 'admin', '2021-02-19 17:01:09'),
(52, 'P K Roy', 'admin', '2021-02-19 17:01:11'),
(53, 'P K Roy', 'admin', '2021-02-19 17:01:13'),
(54, 'P K Roy', 'admin', '2021-02-19 17:02:43'),
(55, 'P K Roy', 'admin', '2021-02-19 17:03:18'),
(56, 'P K Roy', 'admin', '2021-02-19 17:03:30'),
(57, 'P K Roy', 'admin', '2021-02-19 17:07:27'),
(58, 'P K Roy', 'admin', '2021-02-19 17:07:42'),
(59, 'P K Roy', 'admin', '2021-02-19 17:08:28'),
(60, 'P K Roy', 'admin', '2021-02-19 17:08:42'),
(61, 'P K Roy', 'admin', '2021-02-19 17:11:05'),
(62, 'P K Roy', 'admin', '2021-02-19 17:19:38'),
(63, 'P K Roy', 'admin', '2021-02-19 17:19:55'),
(64, 'P K Roy', 'admin', '2021-02-19 17:43:57'),
(65, 'P K Roy', 'admin', '2021-02-19 17:46:45'),
(66, 'P K Roy', 'admin', '2021-02-19 17:47:32'),
(67, 'P K Roy', 'admin', '2021-02-19 17:49:21'),
(68, 'P K Roy', 'admin', '2021-02-19 17:51:16'),
(69, 'P K Roy', 'admin', '2021-02-19 17:52:27'),
(70, 'P K Roy', 'admin', '2021-02-19 17:53:48'),
(71, 'P K Roy', 'admin', '2021-02-19 17:54:26'),
(72, 'P K Roy', 'admin', '2021-02-24 11:21:02'),
(73, 'P K Roy', 'admin', '2021-02-24 11:25:26'),
(74, 'P K Roy', 'admin', '2021-02-24 11:30:30'),
(75, 'P K Roy', 'admin', '2021-02-24 11:47:27'),
(76, 'P K Roy', 'admin', '2021-02-24 12:18:30'),
(77, 'P K Roy', 'admin', '2021-02-24 12:20:04'),
(78, 'P K Roy', 'admin', '2021-02-24 12:21:44');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(15) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `book_name` varchar(30) NOT NULL,
  `book_author` varchar(30) NOT NULL,
  `book_edition` varchar(10) NOT NULL,
  `book_publication` varchar(30) NOT NULL,
  `quantity_of_book` varchar(20) NOT NULL,
  `avaible_book` varchar(20) NOT NULL,
  `no_of_issue_book` varchar(20) NOT NULL DEFAULT '0',
  `no_of_return_book` varchar(20) NOT NULL DEFAULT '0',
  `username_of_admin_add_book` varchar(20) NOT NULL,
  `username_of_librarian_add_book` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `book_id`, `book_name`, `book_author`, `book_edition`, `book_publication`, `quantity_of_book`, `avaible_book`, `no_of_issue_book`, `no_of_return_book`, `username_of_admin_add_book`, `username_of_librarian_add_book`, `date_Time`) VALUES
(2, '100', 'Python Programming', 'Dr. R. N. Rao', '2nd', 'dreamtech press', '100', '100', '0', '0', 'tathagata', 'null', '2021-01-30 21:36:06'),
(4, '1589', 'Discrete Mathematics', 'B. K. PAL', '9th', 'U.N DHUR SONS PRIVATE LTD', '200', '200', '0', '2', 'tathagata', 'null', '2021-01-31 17:53:38'),
(5, '1478', 'Core Java', 'Dr. R. N. Rao', '2nd', 'dreamtech press', '40', '40', '0', '0', 'tathagata', 'null', '2021-01-31 17:56:43');

-- --------------------------------------------------------

--
-- Table structure for table `issue_book`
--

CREATE TABLE `issue_book` (
  `id` int(15) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `book_name` varchar(30) NOT NULL,
  `book_author` varchar(30) NOT NULL,
  `book_edition` varchar(10) NOT NULL,
  `book_publication` varchar(30) NOT NULL,
  `student_roll_no` varchar(20) NOT NULL,
  `std_name` varchar(30) NOT NULL,
  `course` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `issue_book_date` varchar(15) NOT NULL,
  `return_book_date` varchar(15) NOT NULL,
  `username_of_admin_issue_book` varchar(20) NOT NULL,
  `username_of_librarian_issue_book` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `phone_no` varchar(11) NOT NULL,
  `security_question` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `username`, `password`, `gender`, `email_id`, `phone_no`, `security_question`, `answer`, `date_Time`) VALUES
(1, 'demo', 'librarian', '123456', 'Male', 'librarian@gmail.com', '6888888888', 'Your Nick Name?', 'demo', '2021-01-30 21:25:47');

-- --------------------------------------------------------

--
-- Table structure for table `librarian_login_information`
--

CREATE TABLE `librarian_login_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarian_login_information`
--

INSERT INTO `librarian_login_information` (`id`, `name`, `username`, `date_Time`) VALUES
(1, 'Tathagata', 'librarian', '2021-01-30 21:40:42'),
(2, 'Tathagata', 'librarian', '2021-01-30 22:40:29'),
(3, 'Tathagata', 'librarian', '2021-01-30 23:34:46'),
(4, 'Tathagata', 'librarian', '2021-01-31 00:15:18'),
(5, 'Tathagata', 'librarian', '2021-01-31 16:34:39'),
(6, 'Tathagata', 'librarian', '2021-01-31 16:45:37'),
(7, 'Tathagata', 'librarian', '2021-01-31 16:53:51'),
(8, 'Tathagata', 'librarian', '2021-01-31 17:10:14'),
(9, 'Tathagata', 'librarian', '2021-01-31 18:27:49'),
(10, 'Tathagata', 'librarian', '2021-01-31 19:08:43'),
(11, 'Tathagata', 'librarian', '2021-01-31 19:15:38'),
(12, 'Tathagata', 'librarian', '2021-01-31 20:07:30'),
(13, 'Tathagata', 'librarian', '2021-01-31 20:26:06'),
(14, 'Tathagata', 'librarian', '2021-01-31 21:02:54'),
(15, 'Tathagata', 'librarian', '2021-01-31 21:14:10'),
(16, 'Tathagata', 'librarian', '2021-02-03 20:03:10'),
(17, 'Tathagata', 'librarian', '2021-02-09 09:29:02'),
(18, 'demo', 'librarian', '2021-02-19 15:45:07'),
(19, 'demo', 'librarian', '2021-02-24 11:56:01'),
(20, 'demo', 'librarian', '2021-02-24 11:57:30'),
(21, 'demo', 'librarian', '2021-02-24 11:58:20'),
(22, 'demo', 'librarian', '2021-02-24 12:13:19');

-- --------------------------------------------------------

--
-- Table structure for table `librarian_logout_information`
--

CREATE TABLE `librarian_logout_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarian_logout_information`
--

INSERT INTO `librarian_logout_information` (`id`, `name`, `username`, `date_Time`) VALUES
(1, 'Tathagata', 'librarian', '2021-01-30 21:41:03'),
(2, 'Tathagata', 'librarian', '2021-01-30 22:42:18'),
(3, 'Tathagata', 'librarian', '2021-01-30 23:35:02'),
(4, 'Tathagata', 'librarian', '2021-01-31 00:15:37'),
(5, 'Tathagata', 'librarian', '2021-01-31 16:35:43'),
(6, 'Tathagata', 'librarian', '2021-01-31 16:46:28'),
(7, 'Tathagata', 'librarian', '2021-01-31 16:54:02'),
(8, 'Tathagata', 'librarian', '2021-01-31 17:11:52'),
(9, 'Tathagata', 'librarian', '2021-01-31 18:28:47'),
(10, 'Tathagata', 'librarian', '2021-01-31 19:09:20'),
(11, 'Tathagata', 'librarian', '2021-01-31 19:16:15'),
(12, 'Tathagata', 'librarian', '2021-01-31 20:07:41'),
(13, 'Tathagata', 'librarian', '2021-01-31 20:27:04'),
(14, 'Tathagata', 'librarian', '2021-01-31 21:03:14'),
(15, 'Tathagata', 'librarian', '2021-01-31 21:14:25'),
(16, 'Tathagata', 'librarian', '2021-02-03 20:03:25'),
(17, 'Tathagata', 'librarian', '2021-02-09 09:29:18'),
(18, 'demo', 'librarian', '2021-02-19 15:45:31'),
(19, 'demo', 'librarian', '2021-02-24 11:59:33'),
(20, 'demo', 'librarian', '2021-02-24 12:13:35');

-- --------------------------------------------------------

--
-- Table structure for table `return_book`
--

CREATE TABLE `return_book` (
  `id` int(15) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `book_name` varchar(30) NOT NULL,
  `book_author` varchar(30) NOT NULL,
  `book_edition` varchar(10) NOT NULL,
  `book_publication` varchar(30) NOT NULL,
  `student_roll_no` varchar(20) NOT NULL,
  `std_name` varchar(30) NOT NULL,
  `course` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `issue_date` varchar(15) NOT NULL,
  `return_date` varchar(15) NOT NULL,
  `submit_date` varchar(15) NOT NULL,
  `total_late_day` varchar(15) NOT NULL,
  `late_fine` varchar(15) NOT NULL,
  `username_of_admin_return_book` varchar(20) NOT NULL,
  `username_of_librarian_return_book` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `return_book`
--

INSERT INTO `return_book` (`id`, `book_id`, `book_name`, `book_author`, `book_edition`, `book_publication`, `student_roll_no`, `std_name`, `course`, `branch`, `year`, `semester`, `issue_date`, `return_date`, `submit_date`, `total_late_day`, `late_fine`, `username_of_admin_return_book`, `username_of_librarian_return_book`, `date_Time`) VALUES
(4, '1589', 'Discrete Mathematics', 'B. K. PAL', '9th', 'U.N DHUR SONS PRIVATE LTD', '150', 'Sam Roy', 'B.Tech', 'CSE', '4th', '7th', '22/01/2021', '26/01/2021', '31/1/2021', '5', '50', 'tathagata', 'null', '2021-01-31 18:01:25'),
(5, '1589', 'Discrete Mathematics', 'B. K. PAL', '9th', 'U.N DHUR SONS PRIVATE LTD', '150', 'Sam Roy', 'B.Tech', 'CSE', '4th', '7th', '31/01/2021', '03/03/2021', '31/1/2021', '0', '0', 'tathagata', 'null', '2021-01-31 18:27:28');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(15) NOT NULL,
  `roll_no` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(15) NOT NULL,
  `father_name` varchar(30) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `phone_no` varchar(11) NOT NULL,
  `course` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `year` varchar(10) NOT NULL,
  `semester` varchar(10) NOT NULL,
  `total_issue_book` varchar(15) NOT NULL DEFAULT '0',
  `total_return_book` varchar(15) NOT NULL DEFAULT '0',
  `security_question` varchar(30) NOT NULL,
  `answer` varchar(20) NOT NULL,
  `username_of_admin_add_student` varchar(20) NOT NULL,
  `username_of_librarian_add_student` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `roll_no`, `name`, `password`, `gender`, `dob`, `father_name`, `email_id`, `phone_no`, `course`, `branch`, `year`, `semester`, `total_issue_book`, `total_return_book`, `security_question`, `answer`, `username_of_admin_add_student`, `username_of_librarian_add_student`, `date_Time`) VALUES
(3, '150', 'Sam Roy', '123456', 'Male', '06/03/1998', 'P K Roy', 'sam@gmail.com', '9999999999', 'B.Tech', 'CSE', '4th', '7th', '0', '2', 'Your Childhood Name?', 'samroy', 'tathagata', 'null', '2021-01-31 17:47:10'),
(7, '200', 'sam das', '123456', 'Male', '04/04/1999', 'R K das', 'sam@gmail.com', '9999999999', 'B.Tech', 'CSE', '2nd', '3rd', '0', '0', 'Your Childhood Name?', 'sam', 'tathagata', 'null', '2021-01-31 20:12:01');

-- --------------------------------------------------------

--
-- Table structure for table `student_login_information`
--

CREATE TABLE `student_login_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `student_roll_no` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_login_information`
--

INSERT INTO `student_login_information` (`id`, `name`, `student_roll_no`, `date_Time`) VALUES
(1, 'Tathagata Bandyopadhyay', '120', '2021-01-30 21:39:39'),
(2, 'jhdjshdj', '12', '2021-01-30 21:40:10'),
(3, 'Tathagata Bandyopadhyay', '120', '2021-01-30 22:42:52'),
(4, 'Tathagata Bandyopadhyay', '120', '2021-01-30 22:43:33'),
(5, 'Tathagata Bandyopadhyay', '120', '2021-01-30 23:35:10'),
(6, 'Tathagata Bandyopadhyay', '120', '2021-01-31 00:15:53'),
(7, 'Tathagata Bandyopadhyay', '120', '2021-01-31 16:46:41'),
(8, 'Tathagata Bandyopadhyay', '120', '2021-01-31 16:47:28'),
(9, 'Tathagata Bandyopadhyay', '120', '2021-01-31 16:50:32'),
(10, 'Tathagata Bandyopadhyay', '120', '2021-01-31 17:11:59'),
(11, 'Tathagata Bandyopadhyay', '120', '2021-01-31 17:13:30'),
(12, 'Tathagata Bandyopadhyay', '120', '2021-01-31 17:37:46'),
(13, 'Sam Roy', '150', '2021-01-31 18:03:55'),
(14, 'Tathagata Bandyopadhyay', '120', '2021-01-31 18:04:29'),
(15, 'Sam Roy', '150', '2021-01-31 19:09:28'),
(16, 'Sam Roy', '150', '2021-01-31 19:16:22'),
(17, 'sam das', '200', '2021-01-31 20:27:12'),
(18, 'Tathagata Bandyopadhyay', '120', '2021-01-31 21:14:30'),
(19, 'Sourish Chattaraj', '2', '2021-02-08 20:55:36'),
(20, 'Sourish Chattaraj', '2', '2021-02-09 09:19:17'),
(21, 'Sourish Chattaraj', '2', '2021-02-09 09:29:43'),
(22, 'Sourish Chattaraj', '2', '2021-02-09 10:59:20'),
(23, 'sam das', '200', '2021-02-19 15:48:01'),
(24, 'sam das', '200', '2021-02-19 15:53:57'),
(25, 'sam das', '200', '2021-02-24 12:13:40');

-- --------------------------------------------------------

--
-- Table structure for table `student_logout_information`
--

CREATE TABLE `student_logout_information` (
  `id` int(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `student_roll_no` varchar(20) NOT NULL,
  `date_Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_logout_information`
--

INSERT INTO `student_logout_information` (`id`, `name`, `student_roll_no`, `date_Time`) VALUES
(1, 'Tathagata Bandyopadhyay', '120', '2021-01-30 21:39:49'),
(2, 'jhdjshdj', '12', '2021-01-30 21:40:32'),
(3, 'Tathagata Bandyopadhyay', '120', '2021-01-30 22:43:02'),
(4, 'Tathagata Bandyopadhyay', '120', '2021-01-30 22:47:34'),
(5, 'Tathagata Bandyopadhyay', '120', '2021-01-30 23:35:29'),
(6, 'Tathagata Bandyopadhyay', '120', '2021-01-31 00:16:06'),
(7, 'Tathagata Bandyopadhyay', '120', '2021-01-31 16:47:04'),
(8, 'Tathagata Bandyopadhyay', '120', '2021-01-31 16:50:35'),
(9, 'Tathagata Bandyopadhyay', '120', '2021-01-31 17:12:39'),
(10, 'Tathagata Bandyopadhyay', '120', '2021-01-31 17:13:46'),
(11, 'Sam Roy', '150', '2021-01-31 18:04:16'),
(12, 'Tathagata Bandyopadhyay', '120', '2021-01-31 18:04:35'),
(13, 'Sam Roy', '150', '2021-01-31 19:09:58'),
(14, 'Sam Roy', '150', '2021-01-31 19:16:42'),
(15, 'sam das', '200', '2021-01-31 20:27:37'),
(16, 'Sourish Chattaraj', '2', '2021-02-08 20:57:04'),
(17, 'Sourish Chattaraj', '2', '2021-02-09 09:19:22'),
(18, 'Sourish Chattaraj', '2', '2021-02-09 09:29:47'),
(19, 'Sourish Chattaraj', '2', '2021-02-09 10:59:32'),
(20, 'sam das', '200', '2021-02-19 15:48:07'),
(21, 'sam das', '200', '2021-02-19 15:54:03'),
(22, 'sam das', '200', '2021-02-24 12:14:20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_login_information`
--
ALTER TABLE `admin_login_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_logout_information`
--
ALTER TABLE `admin_logout_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issue_book`
--
ALTER TABLE `issue_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian_login_information`
--
ALTER TABLE `librarian_login_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian_logout_information`
--
ALTER TABLE `librarian_logout_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `return_book`
--
ALTER TABLE `return_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_login_information`
--
ALTER TABLE `student_login_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_logout_information`
--
ALTER TABLE `student_logout_information`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `admin_login_information`
--
ALTER TABLE `admin_login_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- AUTO_INCREMENT for table `admin_logout_information`
--
ALTER TABLE `admin_logout_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `issue_book`
--
ALTER TABLE `issue_book`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `librarian_login_information`
--
ALTER TABLE `librarian_login_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `librarian_logout_information`
--
ALTER TABLE `librarian_logout_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `return_book`
--
ALTER TABLE `return_book`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student_login_information`
--
ALTER TABLE `student_login_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `student_logout_information`
--
ALTER TABLE `student_logout_information`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
