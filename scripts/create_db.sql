-- MySQL Script generated by MySQL Workbench
-- Mon May 27 23:36:00 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mytravel
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mytravel` ;

-- -----------------------------------------------------
-- Schema mytravel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mytravel` DEFAULT CHARACTER SET utf8 ;
USE `mytravel` ;

-- -----------------------------------------------------
-- Table `mytravel`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  `gender` VARCHAR(1) NULL,
  `marital_status` VARCHAR(45) NULL,
  `children` INT NULL,
  `income` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(350) NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_role_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_user_user_role_idx` (`user_role_id` ASC),
  CONSTRAINT `fk_user_user_role`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `mytravel`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `about` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `about` VARCHAR(500) NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_city_country1_idx` (`country_id` ASC),
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `mytravel`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`place` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `about` VARCHAR(500) NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`),
  INDEX `fk_place_city1_idx` (`city_id` ASC),
  CONSTRAINT `fk_place_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `mytravel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`tag` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`place_has_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`place_has_tag` (
  `place_id` INT NOT NULL,
  `place_city_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`place_id`, `place_city_id`, `tag_id`),
  INDEX `fk_place_has_tag_tag1_idx` (`tag_id` ASC),
  INDEX `fk_place_has_tag_place1_idx` (`place_id` ASC, `place_city_id` ASC),
  CONSTRAINT `fk_place_has_tag_place1`
    FOREIGN KEY (`place_id` , `place_city_id`)
    REFERENCES `mytravel`.`place` (`id` , `city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_has_tag_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `mytravel`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`recommendation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`recommendation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prediction` FLOAT NULL,
  `user_id` INT NOT NULL,
  `place_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `place_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_recommendation_user1_idx` (`user_id` ASC),
  INDEX `fk_recommendation_place1_idx` (`place_id` ASC),
  CONSTRAINT `fk_recommendation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mytravel`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recommendation_place1`
    FOREIGN KEY (`place_id`)
    REFERENCES `mytravel`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(45) NULL,
  `place_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `place_id`, `user_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_rating_place1_idx` (`place_id` ASC),
  INDEX `fk_rating_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_rating_place1`
    FOREIGN KEY (`place_id`)
    REFERENCES `mytravel`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mytravel`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`news` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `about` VARCHAR(300) NULL,
  `datetime` DATETIME(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytravel`.`statistic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytravel`.`statistic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `page` VARCHAR(45) NULL,
  `action` VARCHAR(45) NULL,
  `data` VARCHAR(300) NULL,
  `datetime` DATETIME(10) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mytravel`.`user_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `mytravel`;
INSERT INTO `mytravel`.`user_role` (`id`, `name`) VALUES (1, 'ADMIN');
INSERT INTO `mytravel`.`user_role` (`id`, `name`) VALUES (2, 'USER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mytravel`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mytravel`;
INSERT INTO `mytravel`.`user` (`id`, `name`, `surname`, `age`, `gender`, `marital_status`, `children`, `income`, `email`, `password`, `user_role_id`) VALUES (1, 'John', 'Doe', 25, 'M', 'Single', 0, 'high', 'john.doe@somemail.com', 'nimda', 1);
INSERT INTO `mytravel`.`user` (`id`, `name`, `surname`, `age`, `gender`, `marital_status`, `children`, `income`, `email`, `password`, `user_role_id`) VALUES (2, 'Ann', 'Smith', 23, 'F', 'Single', 0, 'high', 'ann.smith@somemail.com', '12345', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mytravel`.`country`
-- -----------------------------------------------------
START TRANSACTION;
USE `mytravel`;
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (1, 'Argentina', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (2, 'Armenia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (3, 'Australia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (4, 'Austria', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (5, 'Azerbaijan', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (6, 'Bahamas', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (7, 'Belarus', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (8, 'Belgium', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (9, 'Brazil', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (10, 'Bulgaria', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (11, 'Canada', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (12, 'Chile', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (13, 'China', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (14, 'Croatia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (15, 'Cuba', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (16, 'Cyprus', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (17, 'Czech', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (18, 'Denmark', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (19, 'Egypt', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (20, 'Emirate', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (21, 'England', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (22, 'Estonia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (23, 'Finland', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (24, 'France', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (25, 'Georgia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (26, 'Germany', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (27, 'Great Britain', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (28, 'Greece', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (29, 'Hungary', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (30, 'Iceland', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (31, 'India', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (32, 'Indonesia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (33, 'Ireland', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (34, 'Israel', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (35, 'Italy', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (36, 'Japan', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (37, 'Jordan', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (38, 'Kazakhstan', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (39, 'Korea', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (40, 'Laos', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (41, 'Latvia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (42, 'Liechtenstein', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (43, 'Lithuania', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (44, 'Luxembourg', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (45, 'Macedonia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (46, 'Maldives', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (47, 'Malta', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (48, 'Mexico', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (49, 'Moldova', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (50, 'Monaco', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (51, 'Mongolia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (52, 'Montenegro', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (53, 'Morocco', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (54, 'Nepal', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (55, 'Netherlands', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (56, 'New Zealand', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (57, 'Norway', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (58, 'Panama', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (59, 'Peru', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (60, 'Philippines', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (61, 'Poland', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (62, 'Portugal', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (63, 'Romania', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (64, 'Russia', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (65, 'Singapore', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (66, 'Spain', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (67, 'Sweden', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (68, 'Taiwan', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (69, 'Thailand', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (70, 'Turkey', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (71, 'Ukraine', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (72, 'United Kingdom', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (73, 'USA', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (74, 'Vatican', NULL);
INSERT INTO `mytravel`.`country` (`id`, `name`, `about`) VALUES (75, 'Vietnam', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mytravel`.`tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `mytravel`;
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (1, 'Health');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (2, 'History');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (3, 'Museums');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (4, 'Galleries');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (5, 'Architecture');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (6, 'Nature');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (7, 'Sea');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (8, 'Mountains');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (9, 'River');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (10, 'Forest');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (11, 'Walking');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (12, 'Industrial');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (13, 'Sport');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (14, 'Water');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (15, 'Hiking');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (16, 'Skiing');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (17, 'Religios');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (18, 'Cutural');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (19, 'Cruise');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (20, 'Extreme');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (21, 'Wine');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (22, 'Gastronomic');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (23, 'City');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (24, 'People');
INSERT INTO `mytravel`.`tag` (`id`, `name`) VALUES (25, 'Music');

COMMIT;

