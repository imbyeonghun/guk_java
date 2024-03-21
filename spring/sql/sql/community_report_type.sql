CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
  `tr_name` varchar(15) NOT NULL,
  PRIMARY KEY (`tr_name`)
);