DROP SCHEMA IF EXISTS `app`;
CREATE SCHEMA `app`;
 
CREATE TABLE `app`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `app`.`user` (`name`, `last_name`, `email`, `password`) VALUES ('Pedro', 'Gomez', 'p.gomez@gmail.com', SHA2('1234', 256));
INSERT INTO `app`.`user` (`name`, `last_name`, `email`, `password`) VALUES ('Agustin', 'Skare', 'a.skare@gmail.com', SHA2('askare', 256));
INSERT INTO `app`.`user` (`name`, `last_name`, `email`, `password`) VALUES ('Nicolas', 'Salama', 'nicosalama@gmail.com', SHA2('19920801', 256));
INSERT INTO `app`.`user` (`name`, `last_name`, `email`, `password`) VALUES ('Pablo', 'Blazquez', 'p.blazquez@gmail.com', SHA2('blaz1990', 256));
INSERT INTO `app`.`user` (`name`, `last_name`, `email`, `password`) VALUES ('Esteban', 'Suko', 'esteban.suko@gmail.com', SHA2('12345678', 256));
