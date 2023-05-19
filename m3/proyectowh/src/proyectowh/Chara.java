package proyectowh;

public class Chara {
	private String name,race,url;
	private int hp,str,def,ag,spd,id,maxhp,points;
	public Chara(int id,String name, String race,String url, int hp, int str, int spd, int ag, int def, int maxhp, int points) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.url = url;
		this.hp = hp;
		this.str = str;
		this.spd = spd;
		this.ag = ag;
		this.def = def;
		this.maxhp = maxhp;
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public void resethp() {
		this.hp = this.maxhp;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public   int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getAg() {
		return ag;
	}
	public void setAg(int ag) {
		this.ag = ag;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}




	@Override
	public String toString() {
		return "Chara [name=" + name + ", race=" + race + ", url=" + url + ", hp=" + hp + ", str=" + str + ", def="
				+ def + ", ag=" + ag + ", spd=" + spd + ", id=" + id + ", maxhp=" + maxhp + ", points=" + points + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	
	
}
