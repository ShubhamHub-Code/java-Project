/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 8.0.22 : Database - bankapplication
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bankapplication` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bankapplication`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `custaccnumber` bigint NOT NULL,
  `custname` varchar(255) DEFAULT NULL,
  `custaddress` varchar(255) DEFAULT NULL,
  `custaccbalance` double DEFAULT NULL,
  `custcontactnumber` bigint DEFAULT NULL,
  `custemailid` varchar(255) DEFAULT NULL,
  `custPass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`custaccnumber`),
  UNIQUE KEY `custcontactnumber` (`custcontactnumber`),
  UNIQUE KEY `custemailid` (`custemailid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`custaccnumber`,`custname`,`custaddress`,`custaccbalance`,`custcontactnumber`,`custemailid`,`custPass`) values 
(12345,'SWARA','PUNE',76000.99,676767766,'SWARA','SWARA'),
(987654,'Ram','Pune',90000.45,9860646368,'ram@fullstack.com','ram@123'),
(1234567,'Shubham','Pune',960000,9665194105,'shubham@fullstack.com','shubham@123'),
(2121212121,'Shweta','PCMC',120000,9860646367,'shweta@fullstack.com','shweta@121');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
