package utils;

import main.Menu;


public class Utilitaires {
	
	static Menu m = new Menu();
	
	static String Blanc = "";
	static String Black = "";
	public static void demandeLigne() {
		System.out.println();
		System.out.println("2) L'index de la ligne du pion que vous voulez déplacer.");
		System.out.print("Votre choix(0-7) : ");
		
	}
	
	public static void demandeColonne() {
		System.out.println();
		System.out.println("1) L'index de la colonne du pion que vous voulez déplacer." );
		System.out.print("Votre choix(0-7) : ");
		
	}
	
	public static void demandeLigneMouv() {
		System.out.println();
		System.out.println("4) L'index de la ligne ou vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonneMouv() {
		System.out.println();
		System.out.println("3) L'index de la colonne ou vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
		
	}
	
	public static void BlackTurn() {
	    System.out.println("#######################################################");
	    System.out.println("              BLACK'S TURN (" + Black + ")");
	    System.out.println("#######################################################");
	        
	}
	public static void Whiteturn() {
	    System.out.println("#######################################################");
	    System.out.println("              WHITE'S TURN (" + Blanc + ")");
	    System.out.println("#######################################################");
	        
	}
	public static void BlackWin() {
        System.out.println("#######################################################");
        System.out.println("UWU !!! BLACK'S HAS WON !!! GG à "  + Black.toUpperCase());
        System.out.println("#######################################################");

    }
    public static void WhiteWin() {
        System.out.println("#######################################################");
        System.out.println("UWU !!! WHITE'S HAS WON !!! GG à " + Blanc.toUpperCase());
        System.out.println("#######################################################");

    }
	public static void Welcome() {
	    System.out.println("#######################################################");
	    System.out.println("Bienvenue, in our Game fait par : ");
	        System.out.println("Us Hehe(André, Vencatveer, Florian) !");
	        System.out.println("-------------------------------------------------------");
	        System.out.println("Soyez sure de ne write other thing dont vous avez pas besoin");
	        System.out.println("Have Fun!!");
	        System.out.print("White nickname : ");
	        Blanc = m.AskBlanc(); 
	        System.out.println("And your adversaire qui sont les Black!!");
			System.out.print("Black nickname : ");
			Black = m.AskBlack();
			System.out.println("Ce duel opposera alors " + Blanc + " against " + Black + "!");
			WhiteWin();
	}
	
	
	

}
