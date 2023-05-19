package proyectowh;

public class Ranking {
	private String char_race,char_army,rival_race,rival_army,player_name;
	private int bat_id,enemy_life,ally_life,points;
	
	public Ranking(String char_race, String char_army, String rival_race, String rival_army, int bat_id,
			String player_name, int enemy_life, int ally_life, int points) {
		super();
		this.char_race = char_race;
		this.char_army = char_army;
		this.rival_race = rival_race;
		this.rival_army = rival_army;
		this.bat_id = bat_id;
		this.player_name = player_name;
		this.enemy_life = enemy_life;
		this.ally_life = ally_life;
		this.points = points;
	}

	public String getChar_race() {
		return char_race;
	}
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setChar_race(String char_race) {
		this.char_race = char_race;
	}
	public String getChar_army() {
		return char_army;
	}
	public void setChar_army(String char_army) {
		this.char_army = char_army;
	}
	public String getRival_race() {
		return rival_race;
	}
	public void setRival_race(String rival_race) {
		this.rival_race = rival_race;
	}
	public String getRival_army() {
		return rival_army;
	}
	public void setRival_army(String rival_army) {
		this.rival_army = rival_army;
	}
	public int getBat_id() {
		return bat_id;
	}
	public void setBat_id(int bat_id) {
		this.bat_id = bat_id;
	}
	public String getPlayer_Name() {
		return player_name;
	}
	public void setPlayer_id(String player_name) {
		this.player_name = player_name;
	}
	public int getEnemy_life() {
		return enemy_life;
	}
	public void setEnemy_life(int enemy_life) {
		this.enemy_life = enemy_life;
	}
	public int getAlly_life() {
		return ally_life;
	}
	public void setAlly_life(int ally_life) {
		this.ally_life = ally_life;
	}
	@Override
	public String toString() {
		return "Ranking [char_race=" + char_race + ", char_army=" + char_army + ", rival_race="
				+ rival_race + ", rival_army=" + rival_army + ", bat_id=" + bat_id + ", player_name=" + player_name
				+ ", enemy_life=" + enemy_life + ", ally_life=" + ally_life + "]";
	}
}
