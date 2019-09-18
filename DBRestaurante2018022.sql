-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DBRestaurante2018022
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DBRestaurante2018022
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBRestaurante2018022` DEFAULT CHARACTER SET utf8 ;
USE `DBRestaurante2018022` ;

-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`areas` (
  `idareas` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  `cantidadpersonas` INT NOT NULL,
  PRIMARY KEY (`idareas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`mesas` (
  `idmesas` INT NOT NULL AUTO_INCREMENT,
  `idareas` INT NOT NULL,
  `descripcionmesas` VARCHAR(50) NOT NULL,
  `numcomensales` INT NOT NULL,
  PRIMARY KEY (`idmesas`),
  INDEX `fk_Mesas_Areas_idx` (`idareas` ASC) VISIBLE,
  CONSTRAINT `fk_Mesas_Areas`
    FOREIGN KEY (`idareas`)
    REFERENCES `DBRestaurante2018022`.`areas` (`idareas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`clientes` (
  `idclientes` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `tipodecliente` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idclientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`meseros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`meseros` (
  `idmeseros` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(50) NOT NULL,
  `salario` DOUBLE NOT NULL,
  PRIMARY KEY (`idmeseros`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`facturas` (
  `idfacturas` INT NOT NULL AUTO_INCREMENT,
  `idclientes` INT NOT NULL,
  `idmesas` INT NOT NULL,
  `detalle` VARCHAR(50) NOT NULL,
  `fechafactura` DATETIME NOT NULL,
  `nit` VARCHAR(25) NOT NULL,
  `tipodepago` VARCHAR(50) NOT NULL,
  `idmeseros` INT NOT NULL,
  PRIMARY KEY (`idfacturas`),
  INDEX `fk_facturas_clientes1_idx` (`idclientes` ASC) VISIBLE,
  INDEX `fk_facturas_mesas1_idx` (`idmesas` ASC) VISIBLE,
  INDEX `fk_facturas_meseros1_idx` (`idmeseros` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`idclientes`)
    REFERENCES `DBRestaurante2018022`.`clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_mesas1`
    FOREIGN KEY (`idmesas`)
    REFERENCES `DBRestaurante2018022`.`mesas` (`idmesas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_meseros1`
    FOREIGN KEY (`idmeseros`)
    REFERENCES `DBRestaurante2018022`.`meseros` (`idmeseros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`cocineros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`cocineros` (
  `idcocineros` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(50) NOT NULL,
  `sueldo` DOUBLE NOT NULL,
  `especialidad` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idcocineros`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`detalleFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`detalleFactura` (
  `iddetallefactura` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `precioventa` DOUBLE NOT NULL,
  `totalventa` DOUBLE as('cantidad' * 'precioventa'),
  `idfacturas` INT NOT NULL,
  `idcocineros` INT NOT NULL,
  PRIMARY KEY (`iddetallefactura`),
  INDEX `fk_detalleFactura_facturas1_idx` (`idfacturas` ASC) VISIBLE,
  INDEX `fk_detalleFactura_cocineros1_idx` (`idcocineros` ASC) VISIBLE,
  CONSTRAINT `fk_detalleFactura_facturas1`
    FOREIGN KEY (`idfacturas`)
    REFERENCES `DBRestaurante2018022`.`facturas` (`idfacturas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleFactura_cocineros1`
    FOREIGN KEY (`idcocineros`)
    REFERENCES `DBRestaurante2018022`.`cocineros` (`idcocineros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBRestaurante2018022`.`platos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBRestaurante2018022`.`platos` (
  `idplatos` INT NOT NULL AUTO_INCREMENT,
  `descripcionPlatos` VARCHAR(50) NOT NULL,
  `precioPlato` DOUBLE NOT NULL,
  `iddetallefactura` INT,
  PRIMARY KEY (`idplatos`),
  INDEX `fk_platos_detalleFactura1_idx` (`iddetallefactura` ASC) VISIBLE,
  CONSTRAINT `fk_platos_detalleFactura1`
    FOREIGN KEY (`iddetallefactura`)
    REFERENCES `DBRestaurante2018022`.`detalleFactura` (`iddetallefactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -------------------------------------------------------------------
	select * from areas;
    select * from mesas;
    select * from clientes;
    select * from meseros;
    select * from facturas;
    select * from cocineros;
    select * from detallefactura;
    select * from platos;