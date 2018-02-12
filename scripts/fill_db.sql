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
INSERT INTO `marvelous_travel`.`tour` (`id`, `start_date`, `end_date`, `city_from_id`, `city_to_id`, `price`, `name`, `group_id`) VALUES (2, '2017-04-31', '2017-05-06', 2, 3, 800.00, 'Tour2', 1);

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
-- Data for table `marvelous_travel`.`hotel`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (1, 'hotel1', 4, 1, 1);
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (2, 'hotel2', 5, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`feedback`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`) VALUES (1, '2018-02-10', 4, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 1);
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`) VALUES (2, '2017-12-31', 5, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 2);

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


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`hotel`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (1, 'hotel1', 4, 1, 1);
INSERT INTO `marvelous_travel`.`hotel` (`id`, `name`, `stars`, `city_id`, `tour_id`) VALUES (2, 'hotel2', 5, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `marvelous_travel`.`feedback`
-- -----------------------------------------------------
START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`) VALUES (1, '2018-02-10', 4, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 1);
INSERT INTO `marvelous_travel`.`feedback` (`id`, `date`, `mark`, `content`, `image`, `user_id`) VALUES (2, '2017-12-31', 5, 'lorem ipsum bla bla bla  bla bla bla lorem ipsum bla bla bla  bla bla blalorem ipsum bla bla bla  bla bla bla', NULL, 2);

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

START TRANSACTION;
USE `marvelous_travel`;
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (3, 'Ann1', 'Bou1', '1996-06-14', 'Ж', 'AA1111116', '1234567', false, 'vchyhir1@mail.ru', 'admin', 900.00, false, 1, NULL, 2, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (4, 'Jane1', 'Snow1', '1993-04-11', 'Ж', 'BB2222227', NULL, false, 'nastya1@mail.ru', 'user', 800.00, false, 1, NULL, 2, 2);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (5, 'Ann2', 'Bou2', '1996-06-14', 'Ж', 'AA1111167', '1234567', false, 'vchyhir2@mail.ru', 'admin', 900.00, false, 1, NULL, 3, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (6, 'Jane2', 'Snow2', '1993-04-11', 'Ж', 'BB2222292', NULL, false, 'nastya2@mail.ru', 'user', 800.00, false, 1, NULL, 3, 2);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (7, 'Ann3', 'Bou3', '1996-06-14', 'Ж', 'AA1111111', '1234567', false, 'vchyhir3@mail.ru', 'admin', 900.00, false, 1, NULL, 4, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (8, 'Jane3', 'Snow3', '1993-04-11', 'Ж', 'BB2224222', NULL, false, 'nastya3@mail.ru', 'user', 800.00, false, 1, NULL, 4, 2);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (9, 'Ann4', 'Bou4', '1996-06-14', 'Ж', 'AA1111121', '1234567', false, 'vchyhir4@mail.ru', 'admin', 900.00, false, 1, NULL, 5, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (10, 'Jane4', 'Snow4', '1993-04-11', 'Ж', 'BB2252222', NULL, false, 'nastya4@mail.ru', 'user', 800.00, false, 1, NULL, 5, 2);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (11, 'Ann5', 'Bou5', '1996-06-14', 'Ж', 'AA1111131', '1234567', false, 'vchyhir5@mail.ru', 'admin', 900.00, false, 1, NULL, 6, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (12, 'Jane5', 'Snow5', '1993-04-11', 'Ж', 'BB2892222', NULL, false, 'nastya5@mail.ru', 'user', 800.00, false, 1, NULL, 6, 2);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (13, 'Ann6', 'Bou6', '1996-06-14', 'Ж', 'AA1111451', '1234567', false, 'vchyhir6@mail.ru', 'admin', 900.00, false, 1, NULL, 7, 1);
INSERT INTO `marvelous_travel`.`user` (`id`, `name`, `surname`, `birthday`, `gender`, `passport`, `phone`, `marital_status`, `email`, `password`, `income`, `is_parent`, `home_id`, `favourite_activity`, `group_id`, `user_role_id`) VALUES (14, 'Jane6', 'Snow6', '1993-04-11', 'Ж', 'BB2372222', NULL, false, 'nastya6@mail.ru', 'user', 800.00, false, 1, NULL, 7, 2);

COMMIT;