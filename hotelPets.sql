-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Esquema BancoHotelPets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bancohotelpets` DEFAULT CHARACTER SET utf8 ;
USE `bancohotelpets` ;

-- -----------------------------------------------------
-- Tabela de Tutores
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancohotelpets`.`tutor` (
	`cpf` INT NOT NULL,
    `nome` VARCHAR(100) NOT NULL,
    `idade` INT NOT NULL,
	PRIMARY KEY (`cpf`)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela de Pets (Herda de Pets)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancohotelpets`.`pet` (
	`coleira` INT NOT NULL,
	`especie` VARCHAR(45) NOT NULL,
	`nome` VARCHAR(45) NOT NULL,
	`tcpf` INT NOT NULL,
	PRIMARY KEY (`coleira`),
    FOREIGN KEY (`cpf`) REFERENCES `bancohotelpets`.`tutor`(`cpf`)
	ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela de Cachorros (Herda de Pets)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancohotelpets`.`dog` (
    coleira INT PRIMARY KEY,
    -- Cor VARCHAR(50),
    FOREIGN KEY (`coleira`) REFERENCES `bancohotelpets`.`pet`(`coleira`)
    ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela de Gatos (Herda de Pets)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancohotelpets`.`cat` (
    coleira INT PRIMARY KEY,
    -- Cor VARCHAR(50),
    FOREIGN KEY (`coleira`) REFERENCES `BancoHotelPets`.`pet`(`coleira`)
    ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

SELECT * FROM tutor;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;