package utils;

public class Utilitaires {
	
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
	    System.out.println("              BLACK'S TURN");
	    System.out.println("#######################################################");
	        
	}
	public static void Whiteturn() {
	    System.out.println("#######################################################");
	    System.out.println("              WHITE'S TURN");
	    System.out.println("#######################################################");
	        
	}
	public static void BlackWin() {
	    System.out.println("#######################################################");
	    System.out.println("UWU !!! BLACK HAS WON !!!");
	    System.out.println("#######################################################");
	        
	}
	public static void WhiteWin() {
	    System.out.println("#######################################################");
	    System.out.println("UWU !!! WHITE HAS WON !!!");
	    System.out.println("#######################################################");
	        
	}
	public static void Welcome() {
	    System.out.println("#######################################################");
	    System.out.println("Welcome, in our Game made by : ");
	        System.out.println("Us Hehe !");
	        System.out.println("-------------------------------------------------------");
	        System.out.println("The White will strart");
	        System.out.println("Make sure to didn't write another thing that you need to");
	        System.out.println("Have Fun !!");
	    System.out.println("#######################################################");    
	}
}
