create table weapons(
	weapon_id int primary key,
    weapon_image_path varchar(200),
    weapon_name varchar(50),
    weapon_speed int,
    weapon_strength int
);
create table characters(
	char_id int primary key,
    char_name varchar(50),
    char_image_path varchar(200),
    char_hp int,
    char_str int,
    char_spd int,
    char_ag int,
    char_def int,
    char_race enum('Human','Ork','Eldar')
);
create table players(
	player_id int primary key auto_increment,
    player_name varchar(50)
);
create table weap_ava(
	char_id int,
    weapon_id int,
    foreign key (char_id) references characters(char_id),
    foreign key (weapon_id) references weapons(weapon_id)
);
create table battle_results(
	battle_id int primary key auto_increment,
    player_id int,
    char_id int,
    char_race varchar(50),
    char_weap_id int,
    rival_race varchar(50),
    rival_weap_army varchar(50),
    enemy_casualties int,
    allied_casualties int,
    battle_points int,
    foreign key (player_id) references players(player_id),
    foreign key (char_id) references characters(char_id),
    foreign key (char_weap_id) references weapons(weapon_id)
);