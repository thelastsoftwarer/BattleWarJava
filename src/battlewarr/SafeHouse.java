package battlewarr;

public class SafeHouse extends normalloc{

	SafeHouse(player player) {
		super(player, "Güvenli ev");
	}

	@Override
	public boolean getLocation() {
		System.out.println("þu anda güvenli evdesiniz");
		System.out.println("canýnýz doluyor");
	player.setHealth(player.getRhealth())	;
	return true;
	}
	
}
