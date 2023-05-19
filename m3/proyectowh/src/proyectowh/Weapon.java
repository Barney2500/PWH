package proyectowh;

public class Weapon {
	private String name,url;
	private int id,spd,str,points;
	public String getName() {
		return name;
	}
	public Weapon(int id,String name,String url, int spd, int str,int points) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.spd = spd;
		this.str = str;
		this.points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", url=" + url + ", id=" + id + ", spd=" + spd + ", str=" + str + ", points="
				+ points + "]";
	}


}
