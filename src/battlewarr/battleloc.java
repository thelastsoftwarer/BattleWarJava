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
		System.out.println("�uan buradas�n�z:"+this.getName());
		System.out.println("dikkatli olun , �uan burda"+obstcount+" tane canavar var");
		System.out.println("<S>ava� veya <Ka�> ");
		String selcase=scan.nextLine();
		selcase=selcase.toUpperCase();
		if(selcase.equals("S")) {
			if(combat(obstcount)) {
			System.out.println(this.getName()+" b�lgesindeki t�m d��manlar temizlendi");
			if(this.award.equals("food")&&player.getInv().isFood()==false) {
				System.out.println(this.award+ " kazand�n�z");
			player.getInv().setFood(true);;
			}else if(this.award.equals("firewood")&&player.getInv().isFirewood()==false) {
				System.out.println(this.award+ " kazand�n�z");
			player.getInv().setFirewood(true);}
			
			else if(this.award.equals("water")&&player.getInv().isWater()==false) {
					System.out.println(this.award+ " kazand�n�z");
				player.getInv().setWater(true);;
			}
			return true;
		}
	}
			
      if (player.getHealth()<=0) {
			System.out.println("�ld�n�z");
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
				System.out.println("<V>ur veya <K>a�");
				String selcase=scan.nextLine();
				selcase=selcase.toUpperCase();
				if(selcase.equals("V")) {
					System.out.println("vurdunuz");
					obs.setHealth(obs.getHealth()-player.getTotaldamage());
					afterhit();
					System.out.println();
					System.out.println("d��man size vurdu");
					player.setHealth(player.getHealth()-(obs.getDamage()-player.getInv().getArmor()));
					afterhit();
				}else {
					return false;
				}
			}
			if(obs.getHealth()<player.getHealth()	) {	
				System.out.println("T�m d��manlar� yendiniz");
				player.setMoney(player.getMoney()+obs.getAward());
				System.out.println("g�ncel paran�z : "+player.getMoney());
				obs.setHealth(defobshealt);
				
				
			}else {
				return false;
			}
			System.out.println("----------------");
			
		}
		return true;
		
	}
	public void playerstats() {
		System.out.println("Oyuncu De�erleri\n---------------------------");
		System.out.println("Can:"+" "+player.getHealth());
		System.out.println("Hasar: "+player.getTotaldamage());
		System.out.println("Para: "+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah: "+player.getInv().getwName());
		}if(player.getInv().getArmor()>0) {
			System.out.println("Z�rh: "+player.getInv().getaName());
		}
		
		
	}
	public void enemystats() {
		System.out.println("Canavar De�erleri\n----------------------");
		System.out.println("Can: "+obs.getHealth());
		System.out.println("�d�l: "+obs.getAward());
		System.out.println("Hasar: "+obs.getDamage());
		
	}
	public void afterhit() {
		System.out.println("Oyuncu Can�: "+player.getHealth());
		System.out.println(obs.getName()+ "can�: "+obs.getHealth());
	}
	
	
}
