package proyectowh;

public class Player {
	private String name;
	private Chara Chara;
	private Weapon weapon;
	private int points;
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Chara getChara() {
		return Chara;
	}
	public void setChara(Chara Chara) {
		this.Chara = Chara;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", Chara=" + Chara + ", weapon=" + weapon + "]";
	}
	public Player(String name, Chara Chara, Weapon weapon) {
		super();
		this.name = name;
		this.Chara = Chara;
		this.weapon = weapon;
		this.points = 0;
	}
	
}
