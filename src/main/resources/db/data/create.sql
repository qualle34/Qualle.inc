-- MySQL Script generated by MySQL Workbench
-- Tue Apr 12 21:17:57 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET GLOBAL log_bin_trust_function_creators = 1;

-- -----------------------------------------------------
-- Schema qualleinc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qualleinc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qualleinc` DEFAULT CHARACTER SET utf8 ;
USE `qualleinc` ;

-- -----------------------------------------------------
-- Table `qualleinc`.`metadata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`metadata` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`image` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `link` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `phone` VARCHAR(15) NULL,
  `email` VARCHAR(45) NULL,
  `birthday` TIMESTAMP NULL,
  `metadata_id` BIGINT NULL,
  `image_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_metadata_idx` (`metadata_id` ASC) VISIBLE,
  INDEX `fk_user_image_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_image`
    FOREIGN KEY (`image_id`)
    REFERENCES `qualleinc`.`image` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`credentials` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role` ENUM('GUEST', 'USER', 'ADMIN') NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `credentials_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`developer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL,
  `contacts` VARCHAR(256) NULL,
  `address` VARCHAR(256) NULL,
  `metadata_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_developer_metadata_idx` (`metadata_id` ASC) VISIBLE,
  CONSTRAINT `fk_developer_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`genre` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL,
  `price` DECIMAL(13,2) NULL,
  `type` ENUM('GAME', 'MERCH') NULL,
  `category_id` BIGINT NULL,
  `developer_id` BIGINT NULL,
  `genre_id` BIGINT NULL,
  `image_id` BIGINT NULL,
  `metadata_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_category_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_product_developer_idx` (`developer_id` ASC) VISIBLE,
  INDEX `fk_product_genre_idx` (`genre_id` ASC) VISIBLE,
  INDEX `fk_product_metadata_idx` (`metadata_id` ASC) VISIBLE,
  INDEX `fk_product_image_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `qualleinc`.`category` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_developer`
    FOREIGN KEY (`developer_id`)
    REFERENCES `qualleinc`.`developer` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_genre`
    FOREIGN KEY (`genre_id`)
    REFERENCES `qualleinc`.`genre` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_product_image`
    FOREIGN KEY (`image_id`)
    REFERENCES `qualleinc`.`image` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`purchase` (
  `product_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`product_id`, `user_id`),
  INDEX `fk_purchase_product_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_purchase_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `qualleinc`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_purchase_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`feedback` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  `user_id` BIGINT NULL,
  `metadata_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_feedback_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_feedback_metadata_idx` (`metadata_id` ASC) VISIBLE,
  CONSTRAINT `fk_feedback_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_feedback_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`cart` (
  `product_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`product_id`, `user_id`),
  INDEX `fk_cart_product_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_cart_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `qualleinc`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cart_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`card` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `metadata_id` BIGINT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_card_metadata_idx` (`metadata_id` ASC) VISIBLE,
  INDEX `fk_card_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_card_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_card_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`review` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(256) NULL,
  `score` INT NOT NULL,
  `user_id` BIGINT NULL,
  `metadata_id` BIGINT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_review_metadata_idx` (`metadata_id` ASC) VISIBLE,
  INDEX `fk_review_product_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_review_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_review_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `qualleinc`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`vacancy` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2048) NOT NULL,
  `metadata_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vacancy_metadata_idx` (`metadata_id` ASC) VISIBLE,
  CONSTRAINT `fk_vacancy_metadata`
    FOREIGN KEY (`metadata_id`)
    REFERENCES `qualleinc`.`metadata` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`session` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` TIMESTAMP NULL,
  `success` TINYINT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_session_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_session_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `qualleinc`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
