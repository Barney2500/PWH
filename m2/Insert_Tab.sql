INSERT INTO `proyecto2`.`characters`
(`char_id`,
`char_name`,
`char_image_path`,
`char_hp`,
`char_str`,
`char_spd`,
`char_ag`,
`char_def`,
`char_race`,
`max_hp`,
`points`)
VALUES
(1,"Imperium of Man","src/proyectowh/images/imperium.jpg",50,5,5,6,3,"Human",50,20);
INSERT INTO `proyecto2`.`characters`
(`char_id`,
`char_name`,
`char_image_path`,
`char_hp`,
`char_str`,
`char_spd`,
`char_ag`,
`char_def`,
`char_race`,
`max_hp`,
`points`)
VALUES
(2,"Aeldari Empire","src/proyectowh/images/eldar.jpg",40,4,6,6,2,"Eldar",40,20);
INSERT INTO `proyecto2`.`characters`
(`char_id`,
`char_name`,
`char_image_path`,
`char_hp`,
`char_str`,
`char_spd`,
`char_ag`,
`char_def`,
`char_race`,
`max_hp`,
`points`)
VALUES
(3,"The Waaagh!","src/proyectowh/images/ork.jpg",60,6,3,5,4,"Ork",60,21);
INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('1', 'src/proyectowh/images/um.jpg', 'UltraMarines', '3', '1', '10');
INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('2', 'src/proyectowh/images/ba.jpg', 'Blood Angels', '2', '2', '12');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('3', 'src/proyectowh/images/da.jpg', 'Dark Angels', '0', '4', '14');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('4', 'src/proyectowh/images/bm.jpg', 'Bad Moons', '1', '2', '11');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('5', 'src/proyectowh/images/bax.jpg', 'Blood Axes', '3', '0', '9');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('6', 'src/proyectowh/images/ds.jpg', 'Deathskulls', '3', '0', '12');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('7', 'src/proyectowh/images/dr.jpg', 'Dark Reapers', '1', '3', '13');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('8', 'src/proyectowh/images/fd.jpg', 'Fire Dragons', '0', '2', '15');INSERT INTO `proyecto2`.`weapons`
(`weapon_id`,
`weapon_image_path`,
`weapon_name`,
`weapon_speed`,
`weapon_strength`,
`points`)
VALUES
('9', 'src/proyectowh/images/dav.jpg', 'Dire Avengers', '2', '1', '10');
INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(1,1);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(1,2);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(1,3);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(2,7);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(2,8);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(2,9);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(3,4);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(3,5);INSERT INTO `proyecto2`.`weap_ava`
(`char_id`,
`weapon_id`)
VALUES
(3,6);
