package battlewarr;

public class SafeHouse extends normalloc{

	SafeHouse(player player) {
		super(player, "G�venli ev");
	}

	@Override
	public boolean getLocation() {
		System.out.println("�u anda g�venli evdesiniz");
		System.out.println("can�n�z doluyor");
	player.setHealth(player.getRhealth())	;
	return true;
	}
	
}
