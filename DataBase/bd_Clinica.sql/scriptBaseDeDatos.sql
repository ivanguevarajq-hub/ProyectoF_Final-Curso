-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_clinica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_clinica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_clinica` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bd_clinica` ;

-- -----------------------------------------------------
-- Table `bd_clinica`.`pacientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`pacientes` (
  `dni` VARCHAR(8) NOT NULL,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `telefono` VARCHAR(9) NOT NULL,
  `direccion` VARCHAR(200) NULL DEFAULT NULL,
  `apoderado` VARCHAR(150) NULL DEFAULT NULL,
  `numeroHistoriaClinica` VARCHAR(20) NULL DEFAULT NULL,
  `estado` VARCHAR(20) NULL DEFAULT 'ACTIVO',
  `seguroMedico` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `numeroHistoriaClinica` (`numeroHistoriaClinica` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`medicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`medicos` (
  `numeroColegiatura` VARCHAR(10) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `telefono` VARCHAR(9) NULL DEFAULT NULL,
  `direccion` VARCHAR(200) NULL DEFAULT NULL,
  `especialidad` VARCHAR(100) NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`numeroColegiatura`),
  UNIQUE INDEX `dni` (`dni` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`citas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`citas` (
  `idCita` INT NOT NULL,
  `dni_paciente` VARCHAR(8) NOT NULL,
  `colegiatura_medico` VARCHAR(10) NOT NULL,
  `fecha` DATE NOT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `estado` VARCHAR(20) NULL DEFAULT 'PROGRAMADA',
  PRIMARY KEY (`idCita`),
  INDEX `dni_paciente` (`dni_paciente` ASC) VISIBLE,
  INDEX `colegiatura_medico` (`colegiatura_medico` ASC) VISIBLE,
  CONSTRAINT `citas_ibfk_1`
    FOREIGN KEY (`dni_paciente`)
    REFERENCES `bd_clinica`.`pacientes` (`dni`),
  CONSTRAINT `citas_ibfk_2`
    FOREIGN KEY (`colegiatura_medico`)
    REFERENCES `bd_clinica`.`medicos` (`numeroColegiatura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`atencionesmedicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`atencionesmedicas` (
  `idAtencion` INT NOT NULL AUTO_INCREMENT,
  `idCita` INT NOT NULL,
  `motivoConsulta` TEXT NOT NULL,
  `antecedentes` TEXT NULL DEFAULT NULL,
  `signosVitales` TEXT NULL DEFAULT NULL,
  `diagnostico` TEXT NOT NULL,
  `tratamiento` TEXT NULL DEFAULT NULL,
  `observaciones` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idAtencion`),
  UNIQUE INDEX `idCita` (`idCita` ASC) VISIBLE,
  CONSTRAINT `atencionesmedicas_ibfk_1`
    FOREIGN KEY (`idCita`)
    REFERENCES `bd_clinica`.`citas` (`idCita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`auditoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`auditoria` (
  `idAuditoria` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(50) NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  `modulo` VARCHAR(50) NOT NULL,
  `operacion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idAuditoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`comprobantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`comprobantes` (
  `idComprobante` INT NOT NULL AUTO_INCREMENT,
  `numeroComprobante` VARCHAR(20) NOT NULL,
  `idAtencion` INT NOT NULL,
  `montoTotal` DECIMAL(10,2) NOT NULL,
  `metodoPago` VARCHAR(50) NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  PRIMARY KEY (`idComprobante`),
  UNIQUE INDEX `numeroComprobante` (`numeroComprobante` ASC) VISIBLE,
  INDEX `idAtencion` (`idAtencion` ASC) VISIBLE,
  CONSTRAINT `comprobantes_ibfk_1`
    FOREIGN KEY (`idAtencion`)
    REFERENCES `bd_clinica`.`atencionesmedicas` (`idAtencion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`exameneslaboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`exameneslaboratorio` (
  `idExamen` INT NOT NULL AUTO_INCREMENT,
  `idAtencion` INT NOT NULL,
  `tipoExamen` VARCHAR(100) NOT NULL,
  `resultado` TEXT NULL DEFAULT NULL,
  `estado` VARCHAR(20) NULL DEFAULT 'PENDIENTE',
  PRIMARY KEY (`idExamen`),
  INDEX `idAtencion` (`idAtencion` ASC) VISIBLE,
  CONSTRAINT `exameneslaboratorio_ibfk_1`
    FOREIGN KEY (`idAtencion`)
    REFERENCES `bd_clinica`.`atencionesmedicas` (`idAtencion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`medicamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`medicamentos` (
  `idMedicamento` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `concentracion` VARCHAR(50) NULL DEFAULT NULL,
  `presentacion` VARCHAR(50) NULL DEFAULT NULL,
  `stockActual` INT NULL DEFAULT '0',
  PRIMARY KEY (`idMedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`recetas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`recetas` (
  `idReceta` INT NOT NULL AUTO_INCREMENT,
  `idAtencion` INT NOT NULL,
  `idMedicamento` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `indicaciones` TEXT NOT NULL,
  PRIMARY KEY (`idReceta`),
  INDEX `idAtencion` (`idAtencion` ASC) VISIBLE,
  INDEX `idMedicamento` (`idMedicamento` ASC) VISIBLE,
  CONSTRAINT `recetas_ibfk_1`
    FOREIGN KEY (`idAtencion`)
    REFERENCES `bd_clinica`.`atencionesmedicas` (`idAtencion`),
  CONSTRAINT `recetas_ibfk_2`
    FOREIGN KEY (`idMedicamento`)
    REFERENCES `bd_clinica`.`medicamentos` (`idMedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_clinica`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_clinica`.`usuarios` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(8) NOT NULL,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `nombreUsuario` VARCHAR(50) NOT NULL,
  `contrasena` VARCHAR(255) NOT NULL,
  `rol` VARCHAR(20) NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `dni` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `nombreUsuario` (`nombreUsuario` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

Insert into medicos (dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion, numeroColegiatura, especialidad, activo) 
VALUES (87654321, "Juan Alberto", "Manayalle Carranza", '2003-10-20', 'H', 948008081, "Av villapene", "676767", "Urologo", 1);

select * from Citas;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
