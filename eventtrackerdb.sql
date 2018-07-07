-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema EventTrackerDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `EventTrackerDB` ;

-- -----------------------------------------------------
-- Schema EventTrackerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EventTrackerDB` DEFAULT CHARACTER SET utf8 ;
USE `EventTrackerDB` ;

-- -----------------------------------------------------
-- Table `EventTrackerDB`.`Enemy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EventTrackerDB`.`Enemy` ;

CREATE TABLE IF NOT EXISTS `EventTrackerDB`.`Enemy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `hp` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO user@localhost;
 DROP USER user@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT ON TABLE `EventTrackerDB`.* TO 'user'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE `EventTrackerDB`.* TO 'user'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `EventTrackerDB`.* TO 'user'@'localhost';

-- -----------------------------------------------------
-- Data for table `EventTrackerDB`.`Enemy`
-- -----------------------------------------------------
START TRANSACTION;
USE `EventTrackerDB`;
INSERT INTO `EventTrackerDB`.`Enemy` (`id`, `name`, `hp`) VALUES (1, 'Goblin', 10);
INSERT INTO `EventTrackerDB`.`Enemy` (`id`, `name`, `hp`) VALUES (2, 'Orc', 20);
INSERT INTO `EventTrackerDB`.`Enemy` (`id`, `name`, `hp`) VALUES (3, 'Hobgoblin', 15);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
