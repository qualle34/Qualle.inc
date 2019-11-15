
-- -----------------------------------------------------
-- Schema qualle.inc
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `qualle`;
CREATE SCHEMA `qualle` DEFAULT CHARACTER SET utf8 ;
USE `qualle` ;

-- -----------------------------------------------------
-- Table `qualle`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`user` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `birtdate` VARCHAR(45) NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`creds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`creds` (
  `user_id` BIGINT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `creds_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualle`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`category` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`developer` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `contacts` VARCHAR(45) NULL,
  `adres` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`game` (
  `id` BIGINT NOT NULL,
  `category_id` BIGINT NULL,
  `developer_id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `game_category_fk_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `game_category_fk`
    FOREIGN KEY (`category_id`)
    REFERENCES `qualle`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`cart` (
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `cart_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualle`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`user_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`user_game` (
  `user_id` BIGINT NOT NULL,
  `game_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `game_id`),
  INDEX `ug_game_fk_idx` (`game_id` ASC) VISIBLE,
  CONSTRAINT `ug_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualle`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ug_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `qualle`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`summary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`summary` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `file` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`cart_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`cart_game` (
  `user_id` BIGINT NOT NULL,
  `game_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `game_id`),
  INDEX `cg_game_fk_idx` (`game_id` ASC) VISIBLE,
  CONSTRAINT `cg_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `qualle`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cg_cart_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualle`.`cart` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualle`.`dev_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualle`.`dev_game` (
  `dev_id` BIGINT NOT NULL,
  `game_id` BIGINT NOT NULL,
  PRIMARY KEY (`dev_id`, `game_id`),
  INDEX `dg_game_fk_idx` (`game_id` ASC) VISIBLE,
  CONSTRAINT `dg_dev_fk`
    FOREIGN KEY (`dev_id`)
    REFERENCES `qualle`.`developer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dg_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `qualle`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;