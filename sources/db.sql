drop database Bookstore;
create database Bookstore;
use Bookstore;


-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;

DROP TABLE `ShoppingCart`;


DROP TABLE `Sales`;


DROP TABLE `UserBookstoreCustomerPayment`;


DROP TABLE `CustomerPaymentCard`;


DROP TABLE `UserBookstore`;


DROP TABLE `Book`;


DROP TABLE `Author`;


DROP TABLE `CompanyCard`;


DROP TABLE `TypeCard`;


DROP TABLE `Bank`;


DROP TABLE `Format`;


DROP TABLE `Genre`;


DROP TABLE `Status`;


DROP TABLE `Language`;


DROP TABLE `Editorial`;


DROP TABLE `Municipality`;


DROP TABLE `State`;


DROP TABLE `Country`;


use Bookstore;
-- ************************************** `CompanyCard`

CREATE TABLE `CompanyCard`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `TypeCard`

CREATE TABLE `TypeCard`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Bank`

CREATE TABLE `Bank`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Format`

CREATE TABLE `Format`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Genre`

CREATE TABLE `Genre`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Status`

CREATE TABLE `Status`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Language`

CREATE TABLE `Language`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Editorial`

CREATE TABLE `Editorial`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,
  `Phone`       VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Municipality`

CREATE TABLE `Municipality`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `State`       INT NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `State`

CREATE TABLE `State`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `Country`     INT NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `Country`

CREATE TABLE `Country`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `RegDate`     DATE NOT NULL ,

  PRIMARY KEY (`Id`)
);






-- ************************************** `CustomerPaymentCard`

CREATE TABLE `CustomerPaymentCard`
(
  `Id`          INT NOT NULL AUTO_INCREMENT ,
  `NumberCard`  BIGINT NOT NULL ,
  `DateExp`     DATE NOT NULL ,
  `CCV`         INT NOT NULL ,
  `RegDate`     DATE NOT NULL ,
  `Bank`        INT NOT NULL ,
  `TypeCard`    INT NOT NULL ,
  `CompanyCard` INT NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_146` (`Bank`),
  CONSTRAINT `FK_146` FOREIGN KEY `fkIdx_146` (`Bank`) REFERENCES `Bank` (`Id`),
  KEY `fkIdx_149` (`TypeCard`),
  CONSTRAINT `FK_149` FOREIGN KEY `fkIdx_149` (`TypeCard`) REFERENCES `TypeCard` (`Id`),
  KEY `fkIdx_152` (`CompanyCard`),
  CONSTRAINT `FK_152` FOREIGN KEY `fkIdx_152` (`CompanyCard`) REFERENCES `CompanyCard` (`Id`)
);






-- ************************************** `UserBookstore`

CREATE TABLE `UserBookstore`
(
  `Id`           INT NOT NULL AUTO_INCREMENT ,
  `Username`     VARCHAR(45) NOT NULL ,
  `Email`        VARCHAR(45) NOT NULL ,
  `Password`     VARCHAR(45) NOT NULL ,
  `Street`       VARCHAR(45) NOT NULL ,
  `Colony`       VARCHAR(45) NOT NULL ,
  `Phone`        VARCHAR(45) NOT NULL ,
  `Image`        BLOB NOT NULL ,
  `RegDate`      DATE NOT NULL ,
  `PostalCode`   INT NOT NULL ,
  `Status`       INT NOT NULL ,
  `Municipality` INT NOT NULL ,
  `Country`      INT NOT NULL ,
  `State`        INT NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_112` (`Status`),
  CONSTRAINT `FK_112` FOREIGN KEY `fkIdx_112` (`Status`) REFERENCES `Status` (`Id`),
  KEY `fkIdx_115` (`Municipality`),
  CONSTRAINT `FK_115` FOREIGN KEY `fkIdx_115` (`Municipality`) REFERENCES `Municipality` (`Id`),
  KEY `fkIdx_118` (`Country`),
  CONSTRAINT `FK_118` FOREIGN KEY `fkIdx_118` (`Country`) REFERENCES `Country` (`Id`),
  KEY `fkIdx_121` (`State`),
  CONSTRAINT `FK_121` FOREIGN KEY `fkIdx_121` (`State`) REFERENCES `State` (`Id`)
);






-- ************************************** `Book`

CREATE TABLE `Book`
(
  `Id`              INT NOT NULL AUTO_INCREMENT ,
  `Title`           VARCHAR(45) NOT NULL ,
  `ReferenceNumber` INT NOT NULL ,
  `Popularity`      INT NOT NULL ,
  `ISBN`            VARCHAR(45) NOT NULL ,
  `EAN`             VARCHAR(45) NOT NULL ,
  `Year`            DATE NOT NULL ,
  `NumberOfPages`   INT NOT NULL ,
  `Edition`         VARCHAR(45) NOT NULL ,
  `Price`           DECIMAL NOT NULL ,
  `Stock`           INT NOT NULL ,
  `Details`         VARCHAR(45) NOT NULL ,
  `RegDate`         DATE NOT NULL ,
  `Genre`           INT NOT NULL ,
  `Format`          INT NOT NULL ,
  `Editorial`       INT NOT NULL ,
  `Language`        INT NOT NULL ,
  `Status`          INT NOT NULL ,
  `Image`           BLOB NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_80` (`Genre`),
  CONSTRAINT `FK_80` FOREIGN KEY `fkIdx_80` (`Genre`) REFERENCES `Genre` (`Id`),
  KEY `fkIdx_84` (`Format`),
  CONSTRAINT `FK_84` FOREIGN KEY `fkIdx_84` (`Format`) REFERENCES `Format` (`Id`),
  KEY `fkIdx_87` (`Editorial`),
  CONSTRAINT `FK_87` FOREIGN KEY `fkIdx_87` (`Editorial`) REFERENCES `Editorial` (`Id`),
  KEY `fkIdx_90` (`Language`),
  CONSTRAINT `FK_90` FOREIGN KEY `fkIdx_90` (`Language`) REFERENCES `Language` (`Id`),
  KEY `fkIdx_93` (`Status`),
  CONSTRAINT `FK_93` FOREIGN KEY `fkIdx_93` (`Status`) REFERENCES `Status` (`Id`)
);






-- ************************************** `author`

CREATE TABLE `Author`
(
  `Id`           INT NOT NULL AUTO_INCREMENT ,
  `FullName`     VARCHAR(45) NOT NULL ,
  `YearOfBirth`  DATE NOT NULL ,
  `Municipality` INT NOT NULL ,
  `State`        INT NOT NULL ,
  `Country`      INT NOT NULL ,
  `RegDate`      DATE NOT NULL ,
  `Status`       INT NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_26` (`Municipality`),
  CONSTRAINT `FK_26` FOREIGN KEY `fkIdx_26` (`Municipality`) REFERENCES `Municipality` (`Id`),
  KEY `fkIdx_29` (`State`),
  CONSTRAINT `FK_29` FOREIGN KEY `fkIdx_29` (`State`) REFERENCES `State` (`Id`),
  KEY `fkIdx_32` (`Country`),
  CONSTRAINT `FK_32` FOREIGN KEY `fkIdx_32` (`Country`) REFERENCES `Country` (`Id`),
  KEY `fkIdx_96` (`Status`),
  CONSTRAINT `FK_96` FOREIGN KEY `fkIdx_96` (`Status`) REFERENCES `Status` (`Id`)
);






-- ************************************** `ShoppingCart`

CREATE TABLE `ShoppingCart`
(
  `Id`            INT NOT NULL AUTO_INCREMENT ,
  `UserBookstore` INT NOT NULL ,
  `Book`          INT NOT NULL ,
  `RegDate`       DATE NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_170` (`UserBookstore`),
  CONSTRAINT `FK_170` FOREIGN KEY `fkIdx_170` (`UserBookstore`) REFERENCES `UserBookstore` (`Id`),
  KEY `fkIdx_173` (`Book`),
  CONSTRAINT `FK_173` FOREIGN KEY `fkIdx_173` (`Book`) REFERENCES `Book` (`Id`)
);






-- ************************************** `Sales`

CREATE TABLE `Sales`
(
  `Id`              INT NOT NULL AUTO_INCREMENT ,
  `UserBookstore`   INT NOT NULL ,
  `Book`            INT NOT NULL ,
  `CustomerPayment` INT NOT NULL ,
  `OldStock`        INT NOT NULL ,
  `NewStock`        INT NOT NULL ,
  `RegDate`         DATE NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_176` (`UserBookstore`),
  CONSTRAINT `FK_176` FOREIGN KEY `fkIdx_176` (`UserBookstore`) REFERENCES `UserBookstore` (`Id`),
  KEY `fkIdx_179` (`Book`),
  CONSTRAINT `FK_179` FOREIGN KEY `fkIdx_179` (`Book`) REFERENCES `Book` (`Id`),
  KEY `fkIdx_182` (`CustomerPayment`),
  CONSTRAINT `FK_182` FOREIGN KEY `fkIdx_182` (`CustomerPayment`) REFERENCES `CustomerPaymentCard` (`Id`)
);






-- ************************************** `UserBookstoreCustomerPayment`

CREATE TABLE `UserBookstoreCustomerPayment`
(
  `Id`              INT NOT NULL AUTO_INCREMENT ,
  `CustomerPayment` INT NOT NULL ,
  `UserBookstore`   INT NOT NULL ,

  PRIMARY KEY (`Id`),
  KEY `fkIdx_158` (`CustomerPayment`),
  CONSTRAINT `FK_158` FOREIGN KEY `fkIdx_158` (`CustomerPayment`) REFERENCES `CustomerPaymentCard` (`Id`),
  KEY `fkIdx_161` (`UserBookstore`),
  CONSTRAINT `FK_161` FOREIGN KEY `fkIdx_161` (`UserBookstore`) REFERENCES `UserBookstore` (`Id`)
);





