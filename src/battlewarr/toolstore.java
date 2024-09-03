package battlewarr;

public class toolstore extends normalloc{

	toolstore(player player) {
		super(player, "ma�aza");
	
	}

	@Override
	public boolean getLocation() {
		System.out.println("Paran�z:"+player.getMoney());
		System.out.println("1-Silahlar");
		System.out.println("2-Z�rhlar");
		System.out.println("3-��k��");
		System.out.print("Se�iminiz:");
		int selTool=scan.nextInt();
		int selItemId;
		switch(selTool) {
		case 1:
			selItemId=weaponMenu();
			buyWeapon(selItemId);
			break;
		case 2:
			selItemId=armorMenu();
			buyArmor(selItemId);
			
		}
		return true;
	}
	public int armorMenu() {
		System.out.println("1.Hafif z�rh\t Para:5 - Hasar:1>");
		System.out.println("2.Orta z�rh\t Para:35 - Hasar:3>");
		System.out.println("3.A��r z�rh\t Para:45 - Hasar:5>");
		System.out.println("4-��k��.");
		System.out.print("Se�im:");
		int a =scan.nextInt();
		return a;
		
	}
	public void buyArmor(int itemId) {
		int avoid=0;
		int price=0	;
		String aName=null;
		if(itemId>0||itemId<4) {
			switch(itemId) {
			case 1:
				avoid=2;
				aName="hafif z�rh";
				price=5;
				break;
			case 2:
				avoid=3;
				aName="orta z�rh";
				price=35;
				break;
			case 3:
				avoid=7;
				aName="A��r Z�rh";
				price=45;
				break;
			case 4:
				System.out.println("��k�� yap�l�yor.");
				default:
					System.out.println("ge�ersiz i�lem");
					break;
			}
		}
			if(price>0) {
				if(player.getMoney()>=price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()-price);
				System.out.println(aName+" sat�n ald�n�z, Engellenen hasar :"+player.getInv().getArmor());
				System.out.println("z�rh� sat�n ald�n�z.  Kalan para :"+player.getMoney());
				}else {
					System.out.println("Para yetersiz");
				}
			}
		
	}

	private int weaponMenu() {
		System.out.println("1.Tabanca\t Para:5 - Hasar:2>");
		System.out.println("2.K�l��\t Para:35 - Hasar:3>");
		System.out.println("3.t�fek\t Para:45 - Hasar:7>");
		System.out.println("4-��k��.");
		System.out.print("Se�im:");
		int a =scan.nextInt();
		return a;

		
	}
	public void buyWeapon(int itemId) {
		int damage=0;
		int price=0	;
		String wName=null;
		if(itemId>0||itemId<4) {
			switch(itemId) {
			case 1:
				damage=2;
				wName="tabanca";
				price=5;
				break;
			case 2:
				damage=3;
				wName="k�l��";
				price=35;
				break;
			case 3:
				damage=7;
				wName="T�fek";
				price=45;
				break;
			case 4:
				System.out.println("��k�� yap�l�yor.");
			}
			
		}
		if(price>0) {
			if(player.getMoney()>price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(price);
			System.out.println("silah� sat�n ald�n�z. �nceki hasar :"+player.getDamage()+" �imdiki hasar: "+player.getTotaldamage());
			}else {
				System.out.println("Para yetersiz");
			}
		}
	}

}
