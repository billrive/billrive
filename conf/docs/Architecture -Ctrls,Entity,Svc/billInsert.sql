SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `billrive` DEFAULT CHARACTER SET latin1 ;
USE `billrive` ;

-- -----------------------------------------------------
-- Table `billrive`.`billfinances`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`billfinances` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `billPayerId` INT(11) NULL DEFAULT NULL ,
  `bilTotal` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `fName` VARCHAR(100) NULL DEFAULT NULL ,
  `lName` VARCHAR(100) NULL DEFAULT NULL ,
  `mName` VARCHAR(100) NULL DEFAULT NULL ,
  `title` VARCHAR(100) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`bill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`bill` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(100) NULL DEFAULT NULL ,
  `billPayerId` INT(11) NULL DEFAULT NULL ,
  `notes` VARCHAR(100) NULL DEFAULT NULL ,
  `groupId` INT(11) NULL DEFAULT NULL ,
  `user_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`, `user_id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_bill_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `billFinances`
    FOREIGN KEY (`id` )
    REFERENCES `billrive`.`billfinances` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `billrive`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`billitementry`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`billitementry` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `itemTitle` VARCHAR(200) NULL DEFAULT NULL ,
  `itemDescription` TEXT NULL DEFAULT NULL ,
  `billFinancesId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `billFinancesId_idx` (`billFinancesId` ASC) ,
  CONSTRAINT `billFinancesId`
    FOREIGN KEY (`billFinancesId` )
    REFERENCES `billrive`.`billfinances` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`groups`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(200) NULL DEFAULT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `ownerId` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`userfriendmap`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`userfriendmap` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `userId` VARCHAR(45) NULL DEFAULT NULL ,
  `friendId` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `billrive`.`useridandliablecost`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `billrive`.`useridandliablecost` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `userId` INT(11) NULL DEFAULT NULL ,
  `liableCost` FLOAT NULL DEFAULT NULL ,
  `billItemEntryId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `billItemEntryId_idx` (`billItemEntryId` ASC) ,
  CONSTRAINT `billItemEntryId`
    FOREIGN KEY (`billItemEntryId` )
    REFERENCES `billrive`.`billitementry` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `billrive` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
