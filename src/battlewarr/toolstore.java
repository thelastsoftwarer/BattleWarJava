package battlewarr;

public class toolstore extends normalloc{

	toolstore(player player) {
		super(player, "maðaza");
	
	}

	@Override
	public boolean getLocation() {
		System.out.println("Paranýz:"+player.getMoney());
		System.out.println("1-Silahlar");
		System.out.println("2-Zýrhlar");
		System.out.println("3-Çýkýþ");
		System.out.print("Seçiminiz:");
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
		System.out.println("1.Hafif zýrh\t Para:5 - Hasar:1>");
		System.out.println("2.Orta zýrh\t Para:35 - Hasar:3>");
		System.out.println("3.Aðýr zýrh\t Para:45 - Hasar:5>");
		System.out.println("4-çýkýþ.");
		System.out.print("Seçim:");
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
				aName="hafif zýrh";
				price=5;
				break;
			case 2:
				avoid=3;
				aName="orta zýrh";
				price=35;
				break;
			case 3:
				avoid=7;
				aName="Aðýr Zýrh";
				price=45;
				break;
			case 4:
				System.out.println("çýkýþ yapýlýyor.");
				default:
					System.out.println("geçersiz iþlem");
					break;
			}
		}
			if(price>0) {
				if(player.getMoney()>=price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()-price);
				System.out.println(aName+" satýn aldýnýz, Engellenen hasar :"+player.getInv().getArmor());
				System.out.println("zýrhý satýn aldýnýz.  Kalan para :"+player.getMoney());
				}else {
					System.out.println("Para yetersiz");
				}
			}
		
	}

	private int weaponMenu() {
		System.out.println("1.Tabanca\t Para:5 - Hasar:2>");
		System.out.println("2.Kýlýç\t Para:35 - Hasar:3>");
		System.out.println("3.tüfek\t Para:45 - Hasar:7>");
		System.out.println("4-çýkýþ.");
		System.out.print("Seçim:");
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
				wName="kýlýç";
				price=35;
				break;
			case 3:
				damage=7;
				wName="Tüfek";
				price=45;
				break;
			case 4:
				System.out.println("çýkýþ yapýlýyor.");
			}
			
		}
		if(price>0) {
			if(player.getMoney()>price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(price);
			System.out.println("silahý satýn aldýnýz. Önceki hasar :"+player.getDamage()+" Þimdiki hasar: "+player.getTotaldamage());
			}else {
				System.out.println("Para yetersiz");
			}
		}
	}

}
