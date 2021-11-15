package utils;



public class Utilitaires {
	
	public static void demandeLigne() {
		System.out.println();
		System.out.println("La ligne du pion que vous vous voulez bouger." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonne() {
		System.out.println();
		System.out.println("La colonne du pion que vous vous voulez bouger." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeLigneMouv() {
		System.out.println();
		System.out.println("La ligne ou vous vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonneMouv() {
		System.out.println();
		System.out.println("La colonne ou vous vous voulez déplacer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
}
