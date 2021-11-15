package utils;



public class Utilitaires {
	
	public static void demandeLigne() {
		System.out.println();
		System.out.println("L'index de la ligne du pion que vous voulez déplacer.");
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonne() {
		System.out.println();
		System.out.println("L'index de la colonne du pion que vous voulez déplacer." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeLigneMouv() {
		System.out.println();
		System.out.println("L'index de la ligne ou vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonneMouv() {
		System.out.println();
		System.out.println("L'index de la colonne ou vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
}
