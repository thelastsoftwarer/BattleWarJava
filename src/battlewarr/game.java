package battlewarr;

import java.util.Scanner;

public class game {
	player player;
	location location;
	public void login() {
		System.out.println("Oyuna ho�geldiniz");
		System.out.println("oyuna ba�lamadan �nce l�tfen bir isim giriniz:a");
		player=new player("a");
		player.selectmen�();
		start();
	}
	public void start(){
		while (true) {
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("L�tfen eylem yapaca��n�z map se�iniz");
		System.out.println("1-G�venli ev: D��man yok , can iyile�tirir.");
		System.out.println("2-Ma�ara : Kar��n�za zombi ��kabilir,dikkat edin!");
		System.out.println("3-Orman  : Kar��n�za vampir ��kabilir,dikkat edin!");
		System.out.println("4-Nehir  : Kar��n�za ay� ��kabilir, dikkat edin !");
		System.out.println("5-Ma�aza : �stedi�iniz z�rh ve silahtan alabilirsiniz");
		System.out.print("l�tfen bir yer se�iniz:");
		Scanner scan=new Scanner(System.in);
		int selloc=scan.nextInt();
		while(selloc<0||selloc>5) {
			System.out.println("l�tfen ge�erli bir adres giriniz:");
			selloc=scan.nextInt();
		}
		switch(selloc) {
		case 1:
			location=new SafeHouse(player);
			break;
		case 2:
			location=new cave(player);
			break;
		case 3:
			location= new forests(player);
			break;
		case 4:
			location=new river(player);
			break;
			
		case 5:
			location=new toolstore(player);
			break;
			default:
				
				location=new SafeHouse(player); 
				break;
		}
		if(location.getClass().equals("SafeHouse")) {
			if(player.getInv().isFirewood()&&player.getInv().isFood()&&player.getInv().isWater()) {
				System.out.println("Oyunu kazand�n�z, Tebrikler!!!");
				break;
			}
		}
		if(!location.getLocation()){
			System.out.println("oyun bitti...");
			break;
		}
		
		}
		
	}
}
