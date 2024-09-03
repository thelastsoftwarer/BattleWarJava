package battlewarr;

import java.util.Scanner;

public class game {
	player player;
	location location;
	public void login() {
		System.out.println("Oyuna hoþgeldiniz");
		System.out.println("oyuna baþlamadan önce lütfen bir isim giriniz:a");
		player=new player("a");
		player.selectmenü();
		start();
	}
	public void start(){
		while (true) {
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("Lütfen eylem yapacaðýnýz map seçiniz");
		System.out.println("1-Güvenli ev: Düþman yok , can iyileþtirir.");
		System.out.println("2-Maðara : Karþýnýza zombi çýkabilir,dikkat edin!");
		System.out.println("3-Orman  : Karþýnýza vampir çýkabilir,dikkat edin!");
		System.out.println("4-Nehir  : Karþýnýza ayý çýkabilir, dikkat edin !");
		System.out.println("5-Maðaza : Ýstediðiniz zýrh ve silahtan alabilirsiniz");
		System.out.print("lütfen bir yer seçiniz:");
		Scanner scan=new Scanner(System.in);
		int selloc=scan.nextInt();
		while(selloc<0||selloc>5) {
			System.out.println("lütfen geçerli bir adres giriniz:");
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
				System.out.println("Oyunu kazandýnýz, Tebrikler!!!");
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
