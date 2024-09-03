package battlewarr;

public abstract class battleloc extends location {
 protected obstacle obs;
 protected String award;
	battleloc(player player,String name,obstacle obs,String award) {
		
		super(player);
		this.obs=obs;
		this.name=name;
		this.award=award;
	}
	public boolean getLocation() {
		int obstcount=obs.count();
		System.out.println("þuan buradasýnýz:"+this.getName());
		System.out.println("dikkatli olun , þuan burda"+obstcount+" tane canavar var");
		System.out.println("<S>avaþ veya <Kaç> ");
		String selcase=scan.nextLine();
		selcase=selcase.toUpperCase();
		if(selcase.equals("S")) {
			if(combat(obstcount)) {
			System.out.println(this.getName()+" bölgesindeki tüm düþmanlar temizlendi");
			if(this.award.equals("food")&&player.getInv().isFood()==false) {
				System.out.println(this.award+ " kazandýnýz");
			player.getInv().setFood(true);;
			}else if(this.award.equals("firewood")&&player.getInv().isFirewood()==false) {
				System.out.println(this.award+ " kazandýnýz");
			player.getInv().setFirewood(true);}
			
			else if(this.award.equals("water")&&player.getInv().isWater()==false) {
					System.out.println(this.award+ " kazandýnýz");
				player.getInv().setWater(true);;
			}
			return true;
		}
	}
			
      if (player.getHealth()<=0) {
			System.out.println("öldünüz");
			return false;
		}
		
		return true;
	}
	public boolean combat (int obstcount) {
		for(int i=0;i<obstcount;i++) {
			int defobshealt=obs.getHealth();
			playerstats();
			enemystats();
			while(player.getHealth()>0&&obs.getHealth()>0) {
				System.out.println("<V>ur veya <K>aç");
				String selcase=scan.nextLine();
				selcase=selcase.toUpperCase();
				if(selcase.equals("V")) {
					System.out.println("vurdunuz");
					obs.setHealth(obs.getHealth()-player.getTotaldamage());
					afterhit();
					System.out.println();
					System.out.println("düþman size vurdu");
					player.setHealth(player.getHealth()-(obs.getDamage()-player.getInv().getArmor()));
					afterhit();
				}else {
					return false;
				}
			}
			if(obs.getHealth()<player.getHealth()	) {	
				System.out.println("Tüm düþmanlarý yendiniz");
				player.setMoney(player.getMoney()+obs.getAward());
				System.out.println("güncel paranýz : "+player.getMoney());
				obs.setHealth(defobshealt);
				
				
			}else {
				return false;
			}
			System.out.println("----------------");
			
		}
		return true;
		
	}
	public void playerstats() {
		System.out.println("Oyuncu Deðerleri\n---------------------------");
		System.out.println("Can:"+" "+player.getHealth());
		System.out.println("Hasar: "+player.getTotaldamage());
		System.out.println("Para: "+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah: "+player.getInv().getwName());
		}if(player.getInv().getArmor()>0) {
			System.out.println("Zýrh: "+player.getInv().getaName());
		}
		
		
	}
	public void enemystats() {
		System.out.println("Canavar Deðerleri\n----------------------");
		System.out.println("Can: "+obs.getHealth());
		System.out.println("Ödül: "+obs.getAward());
		System.out.println("Hasar: "+obs.getDamage());
		
	}
	public void afterhit() {
		System.out.println("Oyuncu Caný: "+player.getHealth());
		System.out.println(obs.getName()+ "caný: "+obs.getHealth());
	}
	
	
}
