package battlewarr;

import java.util.Scanner;

public class player {
	private String name,chname;
	private int health,damage,money,rhealth;
	private inventory inv;
	public player(String name) {
		this.name=name;
		this.inv=new inventory(); 
		
		
	}
	public inventory getInv() {
		return inv;
	}
	public void setInv(inventory inv) {
		this.inv = inv;
	}
	public int getRhealth() {
		return rhealth;
	}
	public void setRhealth(int rhealth) {
		this.rhealth = rhealth;
	}
	public void selectmen�() {
		switch(chamen�()) {
		case 1:
			krktrd�nd�r("Samurai",5,21,15);
			break;
		case 2:
			krktrd�nd�r("Archer",7,18,20);
			
			break;
		case 3:
			krktrd�nd�r("Knight",8,24,5);
			break;
		}
		System.out.println("ur character name: "+getChname()+"  ur character's health point : "+getDamage()+ 
				"  ur character's attack damage : "+getHealth()+"  ur character's money: "+getMoney());
		
	}
	public int getTotaldamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public int chamen�() {
		System.out.println("please choose a character");
		System.out.println("1-samurai	hasar:5		sa�l�k:21		para:15");
		System.out.println("2-archer	hasar:7		sa�l�k:18		para:20");
		System.out.println("3-knight	hasar:8		sa�l�k:24		para:5");
		System.out.println("se�iminiz: ");
		Scanner scan=new Scanner(System.in);
	
		int a;
		a=scan.nextInt();
		if(a<1||a>3) {
		while(a<1||a>3) {
			System.out.println("yanl�� girdiniz l�tfen tekrar deneyin");
			a=scan.nextInt();
		}
		}
		return a;

	}
	public void krktrd�nd�r(String chname,int damage,int health,int money) {
		setDamage(damage);
		setChname(chname);
		setHealth(health);
		setMoney(money);
		setRhealth(health);
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMoney() {
		return money;
	}
	public String getChname() {
		return chname;
	}
	public void setChname(String chname) {
		this.chname = chname;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
		
	}
	
	
	


