-- MySQL Script generated by MySQL Workbench
-- 02/14/18 22:25:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema marvelous_travel
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `marvelous_travel` ;

-- -----------------------------------------------------
-- Schema marvelous_travel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `marvelous_travel` DEFAULT CHARACTER SET utf8 ;
USE `marvelous_travel` ;

-- -----------------------------------------------------
-- Table `marvelous_travel`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `region_id` INT NOT NULL,
  `about` VARCHAR(1000) NULL,
  `climate` VARCHAR(300) NULL,
  `temperature` DOUBLE NULL,
  `best_start_date` DATE NULL,
  `best_end_date` DATE NULL,
  `activities` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`, `region_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_country_region1_idx` (`region_id` ASC),
  CONSTRAINT `fk_country_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `marvelous_travel`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_city_country_idx` (`country_id` ASC),
  CONSTRAINT `fk_city_country`
    FOREIGN KEY (`country_id`)
    REFERENCES `marvelous_travel`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`user_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `info` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `passport` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `marital_status` TINYINT(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `income` DOUBLE NOT NULL,
  `is_parent` TINYINT(1) NOT NULL,
  `home_id` INT NOT NULL,
  `favourite_activity` VARCHAR(45) NULL,
  `group_id` INT NOT NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`id`, `home_id`, `group_id`, `user_role_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_user_city1_idx` (`home_id` ASC),
  INDEX `fk_user_group1_idx` (`group_id` ASC),
  INDEX `fk_user_user_role1_idx` (`user_role_id` ASC),
  CONSTRAINT `fk_user_city1`
    FOREIGN KEY (`home_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `marvelous_travel`.`user_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_role1`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `marvelous_travel`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `city_from_id` INT NOT NULL,
  `city_to_id` INT NOT NULL,
  `price` DOUBLE NULL,
  `name` VARCHAR(45) NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_from_id`, `city_to_id`, `group_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_tour_city1_idx` (`city_from_id` ASC),
  INDEX `fk_tour_city2_idx` (`city_to_id` ASC),
  INDEX `fk_tour_group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_tour_city1`
    FOREIGN KEY (`city_from_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tour_city2`
    FOREIGN KEY (`city_to_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tour_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `marvelous_travel`.`user_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `stars` INT NOT NULL,
  `city_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_hotel_city1_idx` (`city_id` ASC),
  INDEX `fk_hotel_tour1_idx` (`tour_id` ASC),
  CONSTRAINT `fk_hotel_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `marvelous_travel`.`tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date` DATE NULL,
  `content` VARCHAR(1000) NOT NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `mark` INT NOT NULL,
  `content` VARCHAR(600) NOT NULL,
  `image` LONGBLOB NULL,
  `user_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `tour_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_feedback_user1_idx` (`user_id` ASC),
  INDEX `fk_feedback_tour1_idx` (`tour_id` ASC),
  CONSTRAINT `fk_feedback_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `marvelous_travel`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `marvelous_travel`.`tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`transport_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`transport_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `transport_type_id` INT NOT NULL,
  PRIMARY KEY (`id`, `transport_type_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_transport_transport_type1_idx` (`transport_type_id` ASC),
  CONSTRAINT `fk_transport_transport_type1`
    FOREIGN KEY (`transport_type_id`)
    REFERENCES `marvelous_travel`.`transport_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `city_from_id` INT NOT NULL,
  `city_to_id` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `transport_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_from_id`, `city_to_id`, `transport_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_ticket_city1_idx` (`city_from_id` ASC),
  INDEX `fk_ticket_city2_idx` (`city_to_id` ASC),
  INDEX `fk_ticket_transport1_idx` (`transport_id` ASC),
  INDEX `fk_ticket_tour1_idx` (`tour_id` ASC),
  CONSTRAINT `fk_ticket_city1`
    FOREIGN KEY (`city_from_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_city2`
    FOREIGN KEY (`city_to_id`)
    REFERENCES `marvelous_travel`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_transport1`
    FOREIGN KEY (`transport_id`)
    REFERENCES `marvelous_travel`.`transport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `marvelous_travel`.`tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `tour_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_booking_user1_idx` (`user_id` ASC),
  INDEX `fk_booking_tour1_idx` (`tour_id` ASC),
  CONSTRAINT `fk_booking_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `marvelous_travel`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_booking_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `marvelous_travel`.`tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`statistics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`statistics` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `feedback_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marvelous_travel`.`user_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marvelous_travel`.`user_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `paid` TINYINT(1) NOT NULL,
  `date` DATE NOT NULL,
  `billing_time` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_order_user1_idx` (`user_id` ASC),
  INDEX `fk_order_tour1_idx` (`tour_id` ASC),
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `marvelous_travel`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `marvelous_travel`.`tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`region`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (1, 'Европа');
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (2, 'Юго-Восточная Азия');
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (3, 'Африка');
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (4, 'Индийский океан');
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (5, 'Западная и Центральная Азия');
INSERT INTO `marvelous_travel`.`region` (`id`, `name`) VALUES (6, 'Карибский бассейн');

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`country`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (1, 'Австрия', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (2, 'Андорра', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (3, 'Въетнам', 2, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (4, 'Индонезия', 2, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (5, 'Египет', 3, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (6, 'Кения', 3, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (7, 'Индия', 4, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (8, 'Мальдивы', 4, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (9, 'Абхазия', 5, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (10, 'Грузия', 5, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (11, 'Куба', 6, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `marvelous_travel`.`country` (`id`, `name`, `region_id`, `about`, `climate`, `temperature`, `best_start_date`, `best_end_date`, `activities`) VALUES (12, 'Мексика', 6, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`city`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`city` (`id`, `name`, `country_id`) VALUES (1, 'City1', 1);
INSERT INTO `marvelous_travel`.`city` (`id`, `name`, `country_id`) VALUES (2, 'City2', 2);
INSERT INTO `marvelous_travel`.`city` (`id`, `name`, `country_id`) VALUES (3, 'City3', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`user_group`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (1, 'Explorer', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (2, 'Extremal', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (3, 'Сontemplator', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (4, 'Camper', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (5, 'Familier', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (6, 'Eventer', NULL);
INSERT INTO `marvelous_travel`.`user_group` (`id`, `name`, `info`) VALUES (7, 'Mainstreamer', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`user_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`user_role` (`id`, `name`) VALUES (1, 'ADMIN');
INSERT INTO `marvelous_travel`.`user_role` (`id`, `name`) VALUES (2, 'USER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (1, 'Ann', 'Bou', '1996-06-14', 'Ж', 'AA1111111', '1234567', false, 'vchyhir@mail.ru', 'admin', 900.00, false, 1, NULL, 1, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (2, 'Jane', 'Snow', '1993-04-11', 'Ж', 'BB2222222', NULL, false, 'nastya@mail.ru', 'user', 800.00, false, 1, NULL, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`tour`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`tour` (`id`, `start_date`, `end_date`, `city_from_id`, `city_to_id`, `price`, `name`, `group_id`) VALUES (1, '2017-04-30', '2017-05-05', 1, 2, 700.00, 'Tour1', 1);
INSERT INTO `marvelous_travel`.`tour` (`id`, `start_date`, `end_date`, `city_from_id`, `city_to_id`, `price`, `name`, `group_id`) VALUES (2, '2017-04-30', '2017-05-06', 2, 3, 800.00, 'Tour2', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`hotel`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (1, 'hotel1', 4, 1, 1);
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (2, 'hotel2', 5, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`news`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`news` (`id`, `name`, `date`, `content`, `image`) VALUES (1, 'Дарим подарки!', '2017-04-04', 'Хочешь получить подарок? Жми и выбирай!', NULL);
INSERT INTO `marvelous_travel`.`news` (`id`, `name`, `date`, `content`, `image`) VALUES (2, 'Подбор тура', '2017-04-03', 'Подбери тур на любой вкус. Цены авиабилетов включены в стоимость!', NULL);
INSERT INTO `marvelous_travel`.`news` (`id`, `name`, `date`, `content`, `image`) VALUES (3, 'Lorem ipsum', '2018-02-10', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`feedback`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`, `tour_id`) VALUES (1, '2018-02-10', 4, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 1, 1);
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`, `tour_id`) VALUES (2, '2017-12-31', 5, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`transport_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`transport_type` (`id`, `name`) VALUES (1, 'TRAIN');
INSERT INTO `marvelous_travel`.`transport_type` (`id`, `name`) VALUES (2, 'BOAT');
INSERT INTO `marvelous_travel`.`transport_type` (`id`, `name`) VALUES (3, 'BUS');
INSERT INTO `marvelous_travel`.`transport_type` (`id`, `name`) VALUES (4, 'PLAIN');

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`transport`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`transport` (`id`, `number`, `transport_type_id`) VALUES (1, 'ASD123', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`ticket`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`ticket` (`id`, `price`, `city_from_id`, `city_to_id`, `number`, `start_date`, `end_date`, `transport_id`, `tour_id`) VALUES (1, 30.00, 1, 2, '123123', '2018-03-18', '2018-03-18', 1, 1);

COMMIT;

