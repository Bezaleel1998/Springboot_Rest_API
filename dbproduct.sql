
CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `order_items` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `product_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


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


ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);


ALTER TABLE `product_tbl`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;


ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;


ALTER TABLE `product_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_tbl` (`id`)
COMMIT;