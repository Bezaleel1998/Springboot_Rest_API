-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2024 at 04:23 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbproduct`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `customer_name`, `customer_address`, `total`, `date`) VALUES
(1, 'Bezaleel', 'Dian Asri', 1480000.00, '2024-07-15'),
(2, 'Miller', 'Washington D.C', 1230000.00, '2024-07-15'),
(3, 'James', 'South Dakota', 1610000.00, '2024-07-15'),
(4, 'Amiya', 'Rhodes Island', 830000.00, '2024-07-15'),
(5, 'Kal\'tsit', 'Rhodes Island', 2400000.00, '2024-07-16'),
(6, 'W', 'Rhodes Island', 1950000.00, '2024-07-15'),
(7, 'Savage', 'Rhodes Island', 1330000.00, '2024-07-16'),
(8, 'Mostima', 'Penguin Logistics', 2510000.00, '2024-07-16'),
(9, 'Blaze', 'Rhodes Island', 500000.00, '2024-07-16'),
(10, 'Firewatch', 'SAMI (NOW Rhodes Island)', 800000.00, '2024-07-16'),
(11, 'Skadi', 'AEGIR', 900000.00, '2024-07-16'),
(12, 'Specter', 'AEGIR', 500000.00, '2024-07-17'),
(13, 'Miller', 'Aha', 430000.00, '2024-07-17'),
(14, 'Frostleaf', 'Rhodes Island', 380000.00, '2024-07-17'),
(15, 'Ptilopsis', 'Rhine Lab', 380000.00, '2024-07-18');

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`id`, `order_id`, `product_id`, `quantity`, `total`) VALUES
(1, 1, 5, 2, 1000000.00),
(2, 1, 3, 1, 450000.00),
(3, 1, 2, 1, 30000.00),
(4, 2, 2, 1, 30000.00),
(5, 2, 5, 1, 500000.00),
(6, 2, 10, 1, 320000.00),
(7, 2, 11, 1, 380000.00),
(8, 3, 11, 1, 380000.00),
(9, 3, 1, 1, 350000.00),
(10, 3, 2, 1, 30000.00),
(11, 3, 5, 1, 500000.00),
(12, 3, 1, 1, 350000.00),
(13, 4, 1, 1, 350000.00),
(14, 4, 2, 1, 30000.00),
(15, 4, 3, 1, 450000.00),
(16, 5, 5, 1, 500000.00),
(17, 5, 6, 2, 1200000.00),
(18, 5, 8, 1, 350000.00),
(20, 5, 8, 1, 350000.00),
(21, 7, 8, 1, 350000.00),
(22, 7, 5, 1, 500000.00),
(23, 6, 5, 1, 500000.00),
(24, 6, 5, 1, 500000.00),
(25, 6, 5, 1, 500000.00),
(26, 6, 3, 1, 450000.00),
(27, 7, 3, 1, 450000.00),
(28, 7, 2, 1, 30000.00),
(29, 8, 2, 1, 30000.00),
(30, 8, 1, 6, 2100000.00),
(31, 8, 1, 1, 350000.00),
(32, 8, 2, 1, 30000.00),
(33, 9, 5, 1, 500000.00),
(34, 10, 4, 2, 800000.00),
(35, 10, 5, 1, 500000.00),
(52, 10, 4, 1, 400000.00),
(53, 10, 4, 1, 400000.00),
(54, 11, 4, 1, 400000.00),
(55, 11, 5, 1, 500000.00),
(56, 13, 4, 1, 400000.00),
(57, 13, 2, 1, 30000.00),
(58, 12, 5, 1, 500000.00),
(59, 14, 1, 1, 350000.00),
(60, 14, 2, 1, 30000.00),
(61, 15, 1, 1, 350000.00),
(62, 15, 2, 1, 30000.00);

-- --------------------------------------------------------

--
-- Table structure for table `product_tbl`
--

CREATE TABLE `product_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_tbl`
--

INSERT INTO `product_tbl` (`id`, `name`, `type`, `price`) VALUES
(1, 'Head First Java', 'Book', 350000.00),
(2, 'Professional Apache Tomcat 8', 'Book', 30000.00),
(3, 'Clean Code', 'Book', 450000.00),
(4, 'Java Concurrency in Practice', 'Book', 400000.00),
(5, 'Effective Java', 'Book', 500000.00),
(6, 'Design Patterns', 'Book', 600000.00),
(7, 'Refactoring', 'Book', 550000.00),
(8, 'Spring in Action', 'Book', 350000.00),
(9, 'Hibernate in Action', 'Book', 370000.00),
(10, 'JUnit in Action', 'Book', 320000.00),
(11, 'Java Puzzlers', 'Book', 380000.00),
(12, 'Java: The Complete Reference', 'Book', 450000.00),
(13, 'Thinking in Java', 'Book', 420000.00),
(14, 'Java Performance', 'Book', 400000.00),
(15, 'The Pragmatic Programmer', 'Book', 470000.00),
(16, 'Code Complete', 'Book', 480000.00),
(17, 'Introduction to Algorithms', 'Book', 520000.00),
(18, 'The Art of Computer Programming', 'Book', 530000.00),
(19, 'Algorithms', 'Book', 510000.00),
(20, 'Structure and Interpretation of Computer Programs', 'Book', 490000.00),
(21, 'Patterns of Enterprise Application Architecture', 'Book', 450000.00),
(22, 'Domain-Driven Design', 'Book', 500000.00),
(23, 'Building Microservices', 'Book', 480000.00),
(24, 'Continuous Delivery', 'Book', 470000.00),
(25, 'The Phoenix Project', 'Book', 420000.00),
(26, 'Release It!', 'Book', 430000.00),
(27, 'Clean Architecture', 'Book', 460000.00),
(28, 'The Mythical Man-Month', 'Book', 440000.00),
(29, 'Dont Make Me Think', 'Book', 410000.00),
(30, 'You Dont Know JS', 'Book', 390000.00),
(31, 'Eloquent JavaScript', 'Book', 370000.00),
(32, 'JavaScript: The Good Parts', 'Book', 360000.00),
(33, 'JavaScript: The Definitive Guide', 'Book', 380000.00),
(34, 'Learning Python', 'Book', 350000.00),
(35, 'Python Crash Course', 'Book', 340000.00),
(36, 'Automate the Boring Stuff with Python', 'Book', 330000.00),
(37, 'Fluent Python', 'Book', 450000.00),
(38, 'Effective Python', 'Book', 430000.00),
(39, 'Python Cookbook', 'Book', 420000.00),
(40, 'Machine Learning with Python', 'Book', 410000.00),
(41, 'Deep Learning with Python', 'Book', 460000.00),
(42, 'Artificial Intelligence: A Modern Approach', 'Book', 470000.00),
(43, 'Hands-On Machine Learning with Scikit-Learn and TensorFlow', 'Book', 480000.00),
(44, 'Data Science from Scratch', 'Book', 390000.00),
(45, 'R for Data Science', 'Book', 370000.00),
(46, 'Practical Statistics for Data Scientists', 'Book', 350000.00),
(47, 'Deep Learning', 'Book', 550000.00),
(48, 'The Elements of Statistical Learning', 'Book', 530000.00),
(49, 'Pattern Recognition and Machine Learning', 'Book', 520000.00),
(50, 'Applied Predictive Modeling', 'Book', 510000.00);

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `ID` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `code_user` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`ID`, `username`, `password`, `code_user`, `role`) VALUES
(1, 'Admin', 'Admin123', '4dM1N123', 'ADMIN'),
(2, 'User', 'User123', 'Us3R123', 'USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `product_tbl`
--
ALTER TABLE `product_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `product_tbl`
--
ALTER TABLE `product_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FKs7yce00lm3w3srckmhg7q4i24` FOREIGN KEY (`product_id`) REFERENCES `product_tbl` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
