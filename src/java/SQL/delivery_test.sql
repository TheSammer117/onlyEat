-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-04-27 21:08:13
-- 服务器版本： 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delivery_test`
--

-- --------------------------------------------------------

--
-- 表的结构 `cart`
--

CREATE TABLE `cart` (
  `customer_id` int(4) NOT NULL,
  `food_id` int(4) NOT NULL,
  `quantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `cart`
--

INSERT INTO `cart` (`customer_id`, `food_id`, `quantity`) VALUES
(1, 1, 2),
(2, 2, 2);

-- --------------------------------------------------------

--
-- 表的结构 `county`
--

CREATE TABLE `county` (
  `county_id` int(4) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `county`
--

INSERT INTO `county` (`county_id`, `name`) VALUES
(1, 'Antrim'),
(2, 'Armagh'),
(3, 'Carlow'),
(4, 'Cavan'),
(5, 'Clare'),
(6, 'Cork'),
(7, 'Derry'),
(8, 'Donegal'),
(9, 'Down'),
(10, 'Dublin'),
(11, 'Fermanagh'),
(12, 'Galway'),
(13, 'Kerry'),
(14, 'Kildare'),
(15, 'Kilkenny'),
(16, 'Laois'),
(17, 'Leitrim'),
(18, 'Limerick'),
(19, 'Longford'),
(20, 'Louth'),
(21, 'Mayo'),
(22, 'Meath'),
(23, 'Monaghan'),
(24, 'Offaly'),
(25, 'Roscommon'),
(26, 'Sligo'),
(27, 'Tipperary'),
(28, 'Tyrone'),
(29, 'Waterford'),
(30, 'Westmeath'),
(31, 'Wexford'),
(32, 'Wicklow');

-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(4) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(250) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `phone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`customer_id`, `username`, `password`, `first_name`, `last_name`, `phone`) VALUES
(1, 'joe', '1000:db3ce5287f12a3ac775c9b99c4269af2:be6698a1d82703d0c78eaa2a235b1553672030761b2e1337970d1e501522b5dbfd01c71b12907a0ce7e4e9027cdf67f255d1ca767909b0fbbd0f932703066498', 'peter', 'dean', 848231490),
(2, 'jhon', '1000:8bc42cdae86eab71148bb62596239944:3fbada3fd790cf187a191e14768853509c83dff08b26ab8d0738a6b61ee2aa90b3015299562a8e1e3b68f7f04a942cc68e51abba55c45b3f3d6835c0c9e73dd2', 'efjij', 'seifnie', 93493845);

-- --------------------------------------------------------

--
-- 表的结构 `customer_order`
--

CREATE TABLE `customer_order` (
  `order_id` int(4) NOT NULL,
  `customer_id` int(4) NOT NULL,
  `customer_message` varchar(50) DEFAULT NULL,
  `order_date` date NOT NULL,
  `is_paid` int(1) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `customer_order`
--

INSERT INTO `customer_order` (`order_id`, `customer_id`, `customer_message`, `order_date`, `is_paid`, `status`) VALUES
(1, 1, NULL, '2019-03-14', 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `c_address`
--

CREATE TABLE `c_address` (
  `address_id` int(4) NOT NULL,
  `customer_id` int(4) NOT NULL,
  `address1` varchar(30) NOT NULL,
  `address2` varchar(30) NOT NULL,
  `address3` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `c_address`
--

INSERT INTO `c_address` (`address_id`, `customer_id`, `address1`, `address2`, `address3`) VALUES
(1, 2, 'chaoyang', 'beijing', 'china');

-- --------------------------------------------------------

--
-- 表的结构 `food`
--

CREATE TABLE `food` (
  `food_id` int(4) NOT NULL,
  `restaurant_id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` double(10,2) NOT NULL,
  `type_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `food`
--

INSERT INTO `food` (`food_id`, `restaurant_id`, `name`, `price`, `type_id`) VALUES
(2, 4, 'Cheese & Tomato Pizza', 9.00, 1),
(3, 5, 'Cheese & Tomato Pizza', 10.00, 1),
(4, 7, 'Zicos Special Pizza', 10.00, 1),
(5, 2, 'Bun Burger', 2.00, 2),
(6, 2, 'Garlic Burger', 2.60, 2),
(7, 3, 'Chicken Burger', 3.10, 2),
(8, 3, 'Veggie Burger', 3.35, 2),
(9, 4, 'Vincitore', 11.00, 1),
(10, 5, 'Coca-Cola', 1.25, 7),
(11, 6, '7-up', 1.40, 7),
(12, 7, 'Italian Lemon Soda', 1.50, 7),
(13, 4, 'Chips & Curry', 3.50, 5),
(14, 6, 'Chips, Cheese & Curry', 3.95, 5),
(15, 7, 'Battered Cod', 6.10, 4),
(16, 7, 'Banana Fritter', 3.50, 6),
(17, 4, 'Hot Waffle Topped with Marshmallow', 5.20, 6),
(18, 7, 'Chocolate Fudge Cake', 4.20, 6),
(19, 8, 'Cookies', 2.50, 6);

-- --------------------------------------------------------

--
-- 表的结构 `food_type`
--

CREATE TABLE `food_type` (
  `type_id` int(4) NOT NULL,
  `name` varchar(15) NOT NULL,
  `description` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `food_type`
--

INSERT INTO `food_type` (`type_id`, `name`, `description`) VALUES
(1, 'Pizzas', NULL),
(2, 'Burgers', NULL),
(3, 'Bread', NULL),
(4, 'Fish', NULL),
(5, 'Chips', NULL),
(6, 'Desserts', NULL),
(7, 'SoftDrinks', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `order_detail`
--

CREATE TABLE `order_detail` (
  `order_id` int(4) NOT NULL,
  `food_id` int(4) NOT NULL,
  `quantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `order_detail`
--

INSERT INTO `order_detail` (`order_id`, `food_id`, `quantity`) VALUES
(1, 3, 1),
(1, 10, 2);

-- --------------------------------------------------------

--
-- 表的结构 `restaurant`
--

CREATE TABLE `restaurant` (
  `restaurant_id` int(4) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(250) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` int(15) NOT NULL,
  `street` varchar(40) NOT NULL,
  `town` varchar(20) NOT NULL,
  `county_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `restaurant`
--

INSERT INTO `restaurant` (`restaurant_id`, `username`, `password`, `name`, `phone`, `street`, `town`, `county_id`) VALUES
(2, 'Ardie', '1000:41e16f19776de0c415bbf19c71eb5ba1:8b2d3629deeaebb2aedfb76204a3c92faffb6d94b06acc5e7707d41df873dacf184477bbd327d4b018836caffe6783ceeecd1f83d27234e377c50ff3705cc8bb', 'The Frydays', 832539867, '10 Orieldew, Dublin Road', 'Co.cork', 6),
(3, 'Joe', '1000:b70381edae9aef77979d75f1eef93257:b634f47d4310c6691824215e9f052e3820611a9a221a27ad3bc4d690f40e1df5988ab412b999ce51c849fbcc8979a7e3138bbf15e6f59f56390662a0f0eba691', 'fat beely', 832638491, '10 Oriel Hall', 'Dundalk', 20),
(4, 'dean', '1000:11f1266674b991d1eaf7f2493c28b2f2:a392486080302a078df6c73f44530d7acf074c3205c0d5a4361cc0608b9349df65aaa257084450cd15eccc17eecea482966baf5f877d094ad990be8a692bf98b', 'Lennoxs of MacCurtain St', 83217890, '8 Tuckey Street', 'Cork', 6),
(5, 'jordahn', '1000:264c7a7b0c92a1fb42c318982d6996ff:0de3f9624aa04dda8dd174ca79a644ab204b4277a2494175d5b7a3bbe9108ffc5ea3339cec5b3696a4f3c872d2071be1ba3263414832bf74cae188e92c9eb3f9', 'Fellas Good Food Company', 856217274, ' Mormiles Retail Centre', 'Blackpool', 6),
(6, 'lee', '1000:730ce2ab49bb57de3b2a459fd32c9a0e:272207858fc58d126cb349bfd2ed477621c673bba7d0f5988d6cf60616e5e6cb1416f5b9064f374ede13366b5347f14cb16c6302143826e2f15c1db4269d5f93', 'Sunny House', 856217215, '221 Blarney Road', 'Co Cork', 6),
(7, 'jerry', '1000:b1345da5d2b17ea366aee39dcb81c664:ee7db02d14c7e95fcfaec50535e54b200c9e8ca9cb73bc7511aab4143e4fd3d6a8cc587f7b04ec3f2f3c751d0d53cb5cd9740d925247d51df94477538a61efa5', 'Aroma', 856217370, '5 Emmet Place', 'Co Cork', 6),
(8, 'tom', '1000:f6ac6a766c0cc4babda2b35270e057db:776b4ac35254a536f96694bf8849a3b2a69590d75b226c864617ae3cfd2bfecaf1dadc46eb6c5074e91f4c7472609aae5079e2a4f5de57cca6a67ab101cf32b9', 'Zico', 816917370, '5 Emmet Place18A High Street ', 'Co Cork', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `county`
--
ALTER TABLE `county`
  ADD PRIMARY KEY (`county_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `customer_order`
--
ALTER TABLE `customer_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `c_address`
--
ALTER TABLE `c_address`
  ADD PRIMARY KEY (`address_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`food_id`),
  ADD KEY `menu_id` (`restaurant_id`),
  ADD KEY `type_id` (`type_id`);

--
-- Indexes for table `food_type`
--
ALTER TABLE `food_type`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_id`,`food_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `food_id` (`food_id`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`restaurant_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `county_id` (`county_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `county`
--
ALTER TABLE `county`
  MODIFY `county_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- 使用表AUTO_INCREMENT `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `customer_order`
--
ALTER TABLE `customer_order`
  MODIFY `order_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 使用表AUTO_INCREMENT `c_address`
--
ALTER TABLE `c_address`
  MODIFY `address_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 使用表AUTO_INCREMENT `food`
--
ALTER TABLE `food`
  MODIFY `food_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- 使用表AUTO_INCREMENT `food_type`
--
ALTER TABLE `food_type`
  MODIFY `type_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 使用表AUTO_INCREMENT `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `restaurant_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- 限制导出的表
--

--
-- 限制表 `customer_order`
--
ALTER TABLE `customer_order`
  ADD CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- 限制表 `c_address`
--
ALTER TABLE `c_address`
  ADD CONSTRAINT `c_address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- 限制表 `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `food_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `food_type` (`type_id`),
  ADD CONSTRAINT `food_ibfk_3` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`);

--
-- 限制表 `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `customer_order` (`order_id`),
  ADD CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`);

--
-- 限制表 `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `restaurant_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`county_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
