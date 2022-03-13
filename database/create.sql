
-- -----------------------------------------------------
-- Schema qualle
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `qualleinc`;
CREATE SCHEMA `qualleinc` DEFAULT CHARACTER SET utf8 ;
USE `qualleinc` ;

-- -----------------------------------------------------
-- Table `qualleinc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`user` (
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(45) NOT NULL,
                                                  `lastname` VARCHAR(45) NULL,
                                                  `phone` VARCHAR(15) NULL,
                                                  `email` VARCHAR(45) NULL,
                                                  `birthday` DATE NULL,
                                                  PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`credentials` (
                                                   `user_id` BIGINT NOT NULL,
                                                   `login` VARCHAR(45) NOT NULL,
                                                   `password` VARCHAR(100) NOT NULL,
                                                   `role` VARCHAR(45) NOT NULL,
                                                   PRIMARY KEY (`user_id`),
                                                   CONSTRAINT `creds_user_fk`
                                                       FOREIGN KEY (`user_id`)
                                                           REFERENCES `qualleinc`.`user` (`id`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`category` (
                                                      `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                      `title` VARCHAR(45) NOT NULL,
                                                      `title_ru` VARCHAR(45) NOT NULL,
                                                      PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`developer` (
                                                       `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                       `title` VARCHAR(45) NOT NULL,
                                                       `description` VARCHAR(45) NULL,
                                                       `contacts` VARCHAR(45) NULL,
                                                       `address` VARCHAR(45) NULL,
                                                       PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`product` (
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `category_id` BIGINT NULL,
                                                  `developer_id` BIGINT NOT NULL,
                                                  `name` VARCHAR(45) NOT NULL,
                                                  `description` VARCHAR(45) NULL,
                                                  `price` DECIMAL(13,2) NULL,
                                                  `img_link` VARCHAR(255) NULL,
                                                  PRIMARY KEY (`id`),
                                                  INDEX `game_category_fk_idx` (`category_id` ASC) VISIBLE,
                                                  INDEX `game_developer_fk_idx` (`developer_id` ASC) VISIBLE,
                                                  CONSTRAINT `game_category_fk`
                                                      FOREIGN KEY (`category_id`)
                                                          REFERENCES `qualleinc`.`category` (`id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION,
                                                  CONSTRAINT `game_developer_fk`
                                                      FOREIGN KEY (`developer_id`)
                                                          REFERENCES `qualleinc`.`developer` (`id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`cart` (
                                                  `user_id` BIGINT NOT NULL,
                                                  PRIMARY KEY (`user_id`),
                                                  CONSTRAINT `cart_user_fk`
                                                      FOREIGN KEY (`user_id`)
                                                          REFERENCES `qualleinc`.`user` (`id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`user_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`user_game` (
                                                       `user_id` BIGINT NOT NULL,
                                                       `game_id` BIGINT NOT NULL,
                                                       PRIMARY KEY (`user_id`, `game_id`),
                                                       INDEX `ug_game_fk_idx` (`game_id` ASC) VISIBLE,
                                                       CONSTRAINT `ug_user_fk`
                                                           FOREIGN KEY (`user_id`)
                                                               REFERENCES `qualleinc`.`user` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION,
                                                       CONSTRAINT `ug_game_fk`
                                                           FOREIGN KEY (`game_id`)
                                                               REFERENCES `qualleinc`.`product` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`feedback` (
                                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NOT NULL,
                                                     `email` VARCHAR(45) NOT NULL,
                                                     `phone` VARCHAR(45) NULL,
                                                     `message` VARCHAR(255) NOT NULL,
                                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualleinc`.`cart_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qualleinc`.`cart_game` (
                                                       `user_id` BIGINT NOT NULL,
                                                       `game_id` BIGINT NOT NULL,
                                                       PRIMARY KEY (`user_id`, `game_id`),
                                                       INDEX `cg_game_fk_idx` (`game_id` ASC) VISIBLE,
                                                       CONSTRAINT `cg_game_fk`
                                                           FOREIGN KEY (`game_id`)
                                                               REFERENCES `qualleinc`.`product` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION,
                                                       CONSTRAINT `cg_cart_fk`
                                                           FOREIGN KEY (`user_id`)
                                                               REFERENCES `qualleinc`.`cart` (`user_id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;
