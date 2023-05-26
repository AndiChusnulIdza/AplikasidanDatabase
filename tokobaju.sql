-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2023 at 01:38 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokobaju`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `quantity`, `status`) VALUES
(4, 'celana', '12.00', 4, 0),
(5, 'Baju', '0.60', 34, 0),
(6, 'oji ganteng', '2.00', 4, 0),
(7, 'oji', '3.00', 0, 0),
(8, 'oji ganteng', '3.00', 0, 0),
(9, 'fardan', '111.00', 10, 0),
(10, 'Daster', '10.00', 98, 1),
(11, 'Sepatu', '5.20', 0, 1),
(12, 'Celana Trift', '9.20', 0, 1),
(13, 'Sendal Keren', '1.20', 68, 0),
(14, 'HOODIE', '1.70', 0, 1),
(15, 'Baju Kaos', '5.20', 87, 0),
(16, 'TOPI', '40.70', 78, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `total_amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `customer_name`, `total_amount`) VALUES
(1, '', '10.00'),
(2, '', '10.00'),
(3, '', '10.00'),
(4, 'jaldi', '0.00'),
(5, '', '10.00'),
(6, 'ds', '0.00'),
(7, '', '0.00'),
(8, '', '10.00'),
(9, '', '12.00'),
(10, '', '12.00'),
(11, 'fddfd', '0.00'),
(12, '', '0.60'),
(13, '', '0.60'),
(14, 'Oji', '0.00'),
(15, '', '3.00'),
(16, '', '3.00'),
(17, 'sss', '0.00'),
(18, '', '3.00'),
(19, '', '0.00'),
(20, '', '0.00'),
(21, '', '0.00'),
(22, '', '5.20'),
(23, 'Chusnul', '0.00'),
(24, '', '10.90'),
(25, '', '0.00'),
(26, 'ABDILLAH', '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_product`
--

CREATE TABLE `transaction_product` (
  `transaction_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_product`
--

INSERT INTO `transaction_product` (`transaction_id`, `product_id`) VALUES
(1, 4),
(2, 4),
(3, 4),
(5, 4),
(8, 4),
(9, 4),
(10, 4),
(12, 5),
(13, 5),
(15, 7),
(16, 7),
(18, 7),
(22, 11),
(24, 12),
(24, 14);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction_product`
--
ALTER TABLE `transaction_product`
  ADD KEY `transaction_id` (`transaction_id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction_product`
--
ALTER TABLE `transaction_product`
  ADD CONSTRAINT `transaction_product_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`),
  ADD CONSTRAINT `transaction_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
