package battlewarr;

import java.util.Random;

public class obstacle {
	private String name;
	private int damage,award,health,maxnumber;
	public obstacle(String name, int damage, int health, int award, int maxnumber) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxnumber = maxnumber;
	}
	public int count() {
		Random r=new Random();
		return r.nextInt(this.maxnumber)+1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxnumber() {
		return maxnumber;
	}
	public void setMaxnumber(int maxnumber) {
		this.maxnumber = maxnumber;
	}
}
