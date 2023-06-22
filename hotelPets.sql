-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema HotelPets
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `BancoHotelPets` DEFAULT CHARACTER SET utf8 ;
USE `BancoHotelPets` ;

-- -----------------------------------------------------
-- Table `BancoHotelPets`.`Pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BancoHotelPets`.`Pet` (
  `coleira` INT NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`coleira`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BancoHotelPets`.`Dog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BancoHotelPets`.`Dog` (
  `coleira` INT NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `coleiraPet` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`coleira`),
  INDEX `fk_Dog_Pet1_idx` (`coleiraPet` ASC) VISIBLE,
  CONSTRAINT `fk_Dog_Pet1`
    FOREIGN KEY (`coleiraPet`)
    REFERENCES `BancoHotelPets`.`Pet` (`coleira`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BancoHotelPets`.`Cat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BancoHotelPets`.`Cat` (
  `coleira` INT NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `coleiraPet` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`coleira`),
  INDEX `fk_Cat_Pet1_idx` (`coleiraPet` ASC) VISIBLE,
  CONSTRAINT `fk_Cat_Pet1`
    FOREIGN KEY (`coleiraPet`)
    REFERENCES `BancoHotelPets`.`Pet` (`coleira`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
      
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;