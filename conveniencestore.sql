-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-04-2021 a las 14:28:40
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conveniencestore`
--
CREATE DATABASE IF NOT EXISTS `conveniencestore` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `conveniencestore`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `idCategory` int(40) NOT NULL,
  `name` varchar(40) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`idCategory`, `name`) VALUES
(1, 'Comida'),
(2, 'Ropa'),
(3, 'Bebidas'),
(4, 'Juguetes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listproduct`
--

DROP TABLE IF EXISTS `listproduct`;
CREATE TABLE `listproduct` (
  `idProduct` int(50) NOT NULL,
  `productName` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `trademark` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `stock` int(50) NOT NULL,
  `priceByUnit` int(50) NOT NULL,
  `idCategory` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `listproduct`
--

INSERT INTO `listproduct` (`idProduct`, `productName`, `trademark`, `stock`, `priceByUnit`, `idCategory`) VALUES
(1, 'Comida china', 'Dona Rosa', 4, 45, 1),
(2, 'Tacos al pastor', 'Dona Rosa', 5, 35, 1),
(3, 'Zapatos', 'Real', 5, 500, 2),
(4, 'Pantuflas', 'Real', 8, 100, 2),
(5, 'Jugo de naranja', 'Jugos', 12, 50, 3),
(6, 'Licuado', 'Jugos', 15, 80, 3),
(7, 'Peluche oso', 'Jump', 16, 80, 4),
(8, 'Carrito de madera', 'Juni', 25, 50, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale`
--

DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `idSale` int(11) NOT NULL,
  `idVendor` int(11) NOT NULL,
  `saleTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sale_order`
--

DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order` (
  `id` int(50) NOT NULL,
  `idSale` int(11) NOT NULL,
  `idProduct` int(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `idUser` int(30) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `userType` enum('owner','vendor') COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`, `userType`) VALUES
(1, 'Alexander', 'Alexander', 'owner');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idCategory`);

--
-- Indices de la tabla `listproduct`
--
ALTER TABLE `listproduct`
  ADD PRIMARY KEY (`idProduct`),
  ADD KEY `idCategory` (`idCategory`);

--
-- Indices de la tabla `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`idSale`),
  ADD KEY `idVendor_index` (`idVendor`);

--
-- Indices de la tabla `sale_order`
--
ALTER TABLE `sale_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProduct` (`idProduct`),
  ADD KEY `idSale_index` (`idSale`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `idCategory` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `listproduct`
--
ALTER TABLE `listproduct`
  MODIFY `idProduct` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sale`
--
ALTER TABLE `sale`
  MODIFY `idSale` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sale_order`
--
ALTER TABLE `sale_order`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `listproduct`
--
ALTER TABLE `listproduct`
  ADD CONSTRAINT `listproduct_ibfk_1` FOREIGN KEY (`idCategory`) REFERENCES `category` (`idCategory`);

--
-- Filtros para la tabla `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `fk_idVendor` FOREIGN KEY (`idVendor`) REFERENCES `user` (`idUser`) ON DELETE CASCADE;

--
-- Filtros para la tabla `sale_order`
--
ALTER TABLE `sale_order`
  ADD CONSTRAINT `fk_idSale` FOREIGN KEY (`idSale`) REFERENCES `sale` (`idSale`) ON DELETE CASCADE,
  ADD CONSTRAINT `sale_order_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `listproduct` (`idProduct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
