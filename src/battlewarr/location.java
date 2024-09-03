package battlewarr;

import java.util.Scanner;

public abstract class location {
	protected player player;
	protected String name;
	Scanner scan=new Scanner(System.in);
	location(player player) {
		this.player = player;
	}
	 public player getPlayer() {
		return player;
	}
	public void setPlayer(player player) {
		this.player = player;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract boolean getLocation();
	
	

}
