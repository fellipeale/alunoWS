SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



CREATE SCHEMA IF NOT EXISTS `ees-soa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `ees-soa` ;



-- -----------------------------------------------------

-- Table `ees-soa`.`aluno`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ees-soa`.`aluno` ;



CREATE  TABLE IF NOT EXISTS `ees-soa`.`aluno` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `matricula` VARCHAR(10) NOT NULL ,

  `nome` VARCHAR(50) NOT NULL ,

  `cpf` VARCHAR(11) NULL ,

  `idade` INT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `ees-soa`.`endereco`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ees-soa`.`endereco` ;



CREATE  TABLE IF NOT EXISTS `ees-soa`.`endereco` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `logradouro` VARCHAR(100) NOT NULL ,

  `numero` INT NULL ,

  `complemento` VARCHAR(45) NULL ,

  `bairro` VARCHAR(45) NOT NULL ,

  `cep` VARCHAR(9) NOT NULL ,

  `cidade` VARCHAR(45) NOT NULL ,

  `estado` VARCHAR(2) NOT NULL ,

  `aluno_id` INT NOT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `fk_endereco_aluno_idx` (`aluno_id` ASC) ,

  CONSTRAINT `fk_endereco_aluno`

    FOREIGN KEY (`aluno_id` )

    REFERENCES `ees-soa`.`aluno` (`id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;



USE `ees-soa` ;





SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;