-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2023 at 10:07 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmcydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `addId` int(20) NOT NULL,
  `userId` int(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `pincode` int(20) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `brandtable`
--

CREATE TABLE `brandtable` (
  `BrandId` int(25) NOT NULL,
  `BrandName` varchar(25) NOT NULL,
  `ContactNo` varchar(255) NOT NULL,
  `Website` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Logo` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brandtable`
--

INSERT INTO `brandtable` (`BrandId`, `BrandName`, `ContactNo`, `Website`, `Email`, `Logo`) VALUES
(1, 'Medical', '+91 1234567890', 'www.medirelief.com', 'info@medirelief.com', 'medirelief_logo.jpg'),
(2, 'TechHealth', '+91 9876543210', 'www.techhealth.in', 'info@techhealth.in', 'techhealth_logo.jpg'),
(3, 'SafeCare', '+91 7654321098', 'www.safecareindia.com', 'info@safecareindia.com', 'safecare_logo.jpg'),
(4, 'CleanHands', '+91 8765432109', 'www.cleanhands.co.in', 'info@cleanhands.co.in', 'cleanhands_logo.jpg'),
(5, 'VisionCare', '+91 6543210987', 'www.visioncare.in', 'info@visioncare.in', 'visioncare_logo.jpg'),
(6, 'MediTech', '+91 7890123456', 'www.meditechindia.com', 'info@meditechindia.com', 'meditech_logo.jpg'),
(7, 'CoughCure', '+91 8901234567', 'www.coughcure.com', 'info@coughcure.com', 'coughcure_logo.jpg'),
(8, 'ComfortSleep', '+91 5678901234', 'www.comfortsleep.co.in', 'info@comfortsleep.co.in', 'comfortsleep_logo.jpg'),
(9, 'GutWell', '+91 6789012345', 'www.gutwellindia.com', 'info@gutwellindia.com', 'gutwell_logo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartId` int(25) NOT NULL,
  `userId` int(25) NOT NULL,
  `prodId` int(25) NOT NULL,
  `quantity` int(25) NOT NULL,
  `carttotal` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartId`, `userId`, `prodId`, `quantity`, `carttotal`) VALUES
(1, 3, 1, 2, 5998),
(2, 5, 2, 2, 3998),
(3, 3, 2, 2, 3998),
(4, 5, 1, 2, 5998),
(5, 4, 2, 2, 3998),
(6, 4, 3, 2, 10000),
(7, 6, 2, 2, 3998),
(8, 7, 1, 1, 2999);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CatId` int(25) NOT NULL,
  `CatName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CatId`, `CatName`) VALUES
(1, 'Medication'),
(2, 'Medical Equipment'),
(3, 'Emergency Supplies12'),
(4, 'Personal Care'),
(5, 'Eyecare'),
(6, 'Orthopedics'),
(7, 'First Aid'),
(8, 'Respiratory Care'),
(9, 'Diabetes Care'),
(10, 'Oral Care'),
(11, 'Skincare'),
(12, 'Digestive Health'),
(13, 'Nutritional Supplements'),
(14, 'Family Planning'),
(15, 'Orthopedics');

-- --------------------------------------------------------

--
-- Table structure for table `getintouch`
--

CREATE TABLE `getintouch` (
  `gid` int(20) NOT NULL,
  `uid` int(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `odId` int(20) NOT NULL,
  `uId` int(20) NOT NULL,
  `prodId` int(20) NOT NULL,
  `omId` int(20) NOT NULL,
  `ProdPrice` int(20) NOT NULL,
  `ProdName` varchar(25) NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`odId`, `uId`, `prodId`, `omId`, `ProdPrice`, `ProdName`, `quantity`) VALUES
(1, 3, 2, 1, 7996, 'Digital Thermometer', 2),
(2, 3, 1, 1, 11996, 'Pain Relief Tablets', 2),
(3, 3, 2, 2, 17991, 'Digital Thermometer', 3),
(4, 3, 2, 2, 7996, 'Digital Thermometer', 2),
(5, 3, 1, 2, 11996, 'Pain Relief Tablets', 2),
(6, 3, 2, 3, 7996, 'Digital Thermometer', 2),
(7, 3, 2, 3, 17991, 'Digital Thermometer', 3),
(8, 3, 1, 3, 11996, 'Pain Relief Tablets', 2),
(9, 3, 1, 3, 2999, 'Pain Relief Tablets', 1),
(10, 3, 2, 4, 7996, 'Digital Thermometer', 2),
(11, 3, 1, 4, 11996, 'Pain Relief Tablets', 2);

-- --------------------------------------------------------

--
-- Table structure for table `ordermaster`
--

CREATE TABLE `ordermaster` (
  `OrderId` int(25) NOT NULL,
  `UserId` int(25) NOT NULL,
  `Quantity` int(100) NOT NULL,
  `OrderDate` date NOT NULL,
  `OrderStatus` varchar(25) NOT NULL,
  `OrderTotal` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordermaster`
--

INSERT INTO `ordermaster` (`OrderId`, `UserId`, `Quantity`, `OrderDate`, `OrderStatus`, `OrderTotal`) VALUES
(1, 3, 0, '2023-12-15', 'Pending', 19992),
(2, 3, 0, '2023-12-15', 'Pending', 37983),
(3, 3, 0, '2023-12-19', 'Pending', 40982),
(4, 3, 0, '2023-12-28', 'Pending', 19992);

-- --------------------------------------------------------

--
-- Table structure for table `productreview`
--

CREATE TABLE `productreview` (
  `ReviewId` int(25) NOT NULL,
  `ProId` int(25) NOT NULL,
  `UserId` int(25) NOT NULL,
  `ProRating` varchar(25) NOT NULL,
  `ProReview` varchar(25) NOT NULL,
  `AddedDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProId` int(25) NOT NULL,
  `ProName` varchar(25) NOT NULL,
  `CatId` int(25) NOT NULL,
  `ProDescription` varchar(150) NOT NULL,
  `ExpDate` date NOT NULL,
  `ManDate` date NOT NULL,
  `Prostock` int(20) NOT NULL,
  `BrandId` int(25) NOT NULL,
  `ProImg` varchar(250) NOT NULL,
  `ProPrice` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProId`, `ProName`, `CatId`, `ProDescription`, `ExpDate`, `ManDate`, `Prostock`, `BrandId`, `ProImg`, `ProPrice`) VALUES
(1, 'Pain Relief Tablets', 1, 'Effective pain relief tablets for minor aches', '2023-12-31', '2023-01-01', 91, 1, 'pain_relief_tablets.jpg', 2999),
(2, 'Digital Thermometer', 2, 'Accurate digital thermometer for measuring body temperature', '2024-12-31', '2023-12-31', 86, 2, 'thermometer_image.jpg', 1999),
(3, 'First Aid Kit', 3, 'Comprehensive first aid kit for home and travel', '2023-12-31', '2023-01-01', 100, 3, 'first_aid_kit.jpg', 5000),
(4, 'Antibacterial Hand Saniti', 4, 'Alcohol-based hand sanitizer for germ protection', '2023-12-31', '2023-01-01', 100, 4, 'hand_sanitizer.jpg', 999),
(5, 'Prescription Eyeglasses', 5, 'Quality prescription eyeglasses for improved vision', '2023-12-31', '2023-01-01', 0, 5, 'eyeglasses_image.jpg', 9999),
(6, 'Blood Pressure Monitor', 2, 'Digital blood pressure monitor for at-home monitoring', '2023-12-31', '2023-01-01', 0, 6, 'bp_monitor.jpg', 6999),
(7, 'Cough Syrup', 1, 'Relieves cough and cold symptoms for all ages', '2023-12-31', '2023-01-01', 0, 7, 'cough_syrup.jpg', 1499),
(8, 'Orthopedic Pillow', 6, 'Ergonomic orthopedic pillow for neck and back support', '2023-12-31', '2023-01-01', 0, 8, 'orthopedic_pillow.jpg', 3999),
(9, 'Wound Dressing Kit', 7, 'Sterile wound dressing kit for wound care', '2023-12-31', '2023-01-01', 0, 3, 'wound_dressing_kit.jpg', 2499);

-- --------------------------------------------------------

--
-- Table structure for table `proimg`
--

CREATE TABLE `proimg` (
  `id` int(25) NOT NULL,
  `proId` int(25) NOT NULL,
  `proIMG` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rolemaster`
--

CREATE TABLE `rolemaster` (
  `roleid` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rolemaster`
--

INSERT INTO `rolemaster` (`roleid`, `role`) VALUES
(1, 'User'),
(2, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `UserId` int(20) NOT NULL,
  `UserEmail` varchar(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `UserNumber` varchar(255) NOT NULL,
  `UserPassword` varchar(255) NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`UserId`, `UserEmail`, `Name`, `UserNumber`, `UserPassword`, `roleid`) VALUES
(1, 'mistrymeet6338@gmail.com', 'Meet Mistry', '6353918120', 'PBKDF2WithHmacSHA256:2048:tmKd8YSMTG/+2fcgiLt9D9BC4/XHhPLh1c7nX/eSppM=:chmytgS50i/7UdK+eUDGmluRJniPRc5nxQ0rhGvKRfo=', 2),
(2, 'devangshah7122@gmail.com', 'Devang Shah', '7990376456', 'PBKDF2WithHmacSHA256:2048:Ezl+s+krU4YO7j65egpn29u7vk+DA1s7xMaswaaEj0w=:kLvRv47fUarCcSXnxKZyly4ZfCo4h72UB7pf66uecKM=', 2),
(3, 'gunjanmistry@gmail.com', 'Gunjan Mistry', '9925100927', 'PBKDF2WithHmacSHA256:2048:EQc6SUliE0b5quJ4vHt6Zq0/fNxs/8YNXmZoFLpatN8=:Brr1QPcyphKuhwEqrydN6WI5Xgz7y9G6nrm0Kv97Sdc=', 1),
(4, 'jigarshah@gmail.com', 'Jigar Shah', '7990376456', 'PBKDF2WithHmacSHA256:2048:9cz/pV8xm0rE87wYMl0iK2r8YvIXKKa1Ku0/JJHATG4=:l7g6/crCVQVRt3YfUHEsPLp/vueUUHhKGF3LmAjolSI=', 1),
(5, 'bhagyashree@gmail.com', 'bhagyashree', '7878497879', 'PBKDF2WithHmacSHA256:2048:SSuQhRPHnB06Vl0nCoLfR/8brCm2xHlw/Xu+niCYj+I=:4DaoFM28dEEnTI4J/32QIsmj455+az0CxYdbFSoAy/0=', 1),
(6, 'test@gmail.com', 'test', '123456789', 'PBKDF2WithHmacSHA256:2048:i+Mshwbg6djbPjzGVaRtoeS9tltgVjlk1mRu7xdY1hU=:QmYDBLIrI/ff1qy7UYWSqnRmybVUw4lHt/eIBCu03XU=', 1),
(7, 'abhi@gmail.com', 'Abhishek', '8487005464', 'PBKDF2WithHmacSHA256:2048:jligyAOYXB9P1AfjEPn/EjjDRu/fjKwe98ZtkQMwCWE=:AYdSsNEkkrKimvuU1tzaC5lJlH9WvpuBNJegNbdLNXI=', 1),
(8, 'parimal@gmail.com', 'Parimal', '123456789', 'PBKDF2WithHmacSHA256:2048:8eif4D45JsKOmdaQ2Rl7ix/v2Pzi1ot16QULP4P0UHI=:tMh9aREfIr4AirBLqOT4M8Mg6DL4XBgGUVMRId4wNog=', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`addId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `brandtable`
--
ALTER TABLE `brandtable`
  ADD PRIMARY KEY (`BrandId`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartId`),
  ADD KEY `prodId` (`prodId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatId`);

--
-- Indexes for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD PRIMARY KEY (`gid`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`odId`),
  ADD KEY `uId` (`uId`),
  ADD KEY `omId` (`omId`),
  ADD KEY `prodId` (`prodId`);

--
-- Indexes for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD PRIMARY KEY (`OrderId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `productreview`
--
ALTER TABLE `productreview`
  ADD PRIMARY KEY (`ReviewId`),
  ADD KEY `ProId` (`ProId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProId`),
  ADD KEY `CatId` (`CatId`),
  ADD KEY `BrandId` (`BrandId`);

--
-- Indexes for table `proimg`
--
ALTER TABLE `proimg`
  ADD KEY `proId` (`proId`);

--
-- Indexes for table `rolemaster`
--
ALTER TABLE `rolemaster`
  ADD PRIMARY KEY (`roleid`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`UserId`),
  ADD KEY `userName` (`roleid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `addId` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `brandtable`
--
ALTER TABLE `brandtable`
  MODIFY `BrandId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CatId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `getintouch`
--
ALTER TABLE `getintouch`
  MODIFY `gid` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `odId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `ordermaster`
--
ALTER TABLE `ordermaster`
  MODIFY `OrderId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `productreview`
--
ALTER TABLE `productreview`
  MODIFY `ReviewId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ProId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `rolemaster`
--
ALTER TABLE `rolemaster`
  MODIFY `roleid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `UserId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`prodId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD CONSTRAINT `getintouch_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`uId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`omId`) REFERENCES `ordermaster` (`OrderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetail_ibfk_3` FOREIGN KEY (`prodId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD CONSTRAINT `OrderTable_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productreview`
--
ALTER TABLE `productreview`
  ADD CONSTRAINT `ProductReview_ibfk_1` FOREIGN KEY (`ProId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProductReview_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `Products_ibfk_1` FOREIGN KEY (`CatId`) REFERENCES `category` (`CatId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Products_ibfk_2` FOREIGN KEY (`BrandId`) REFERENCES `brandtable` (`BrandId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `proimg`
--
ALTER TABLE `proimg`
  ADD CONSTRAINT `proimg_ibfk_1` FOREIGN KEY (`proId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usertable`
--
ALTER TABLE `usertable`
  ADD CONSTRAINT `usertable_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `rolemaster` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
