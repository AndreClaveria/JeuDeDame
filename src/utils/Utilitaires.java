package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.Menu;


public class Utilitaires {
	
	static Menu m = new Menu();
	
	File file = new File("data.txt");
	static String Blanc = "";
	static String Black = "";
	public static void demandeLigne() {
		System.out.println();
		System.out.println("2) L'index de la ligne du pion que vous voulez d�placer.");
		System.out.print("Votre choix(0-7) : ");
		
	}
	
	public static void demandeColonne() {
		System.out.println();
		System.out.println("1) L'index de la colonne du pion que vous voulez d�placer." );
		System.out.print("Votre choix(0-7) : ");
		
	}
	
	public static void demandeLigneMouv() {
		System.out.println();
		System.out.println("4) L'index de la ligne ou vous voulez d�placer le pion." );
		System.out.print("Votre choix(0-7) : ");
	}
	
	public static void demandeColonneMouv() {
		System.out.println();
		System.out.println("3) L'index de la colonne ou vous voulez d�placer le pion." );
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
	public static String BlackWin() {
		return
		"#######################################################\n	  !!! BLACK HAS WON !!! GG � " + Black.toUpperCase() + "\n#######################################################";
     
    }
    public static String WhiteWin() {
    	return 
        "#######################################################\n 	  !!! WHITE HAS WON !!! GG � " + Blanc.toUpperCase() + "\n#######################################################";

    }
	public static void Welcome() {
	    System.out.println("#######################################################");
	    System.out.println("Bienvenue, in our Game fait par : ");
	        System.out.println("Us Hehe(Andre, Vencatveer, Florian) !");
	        System.out.println("----------------------------------------------------------");
	        System.out.println("Soyez sure de ne pas write other thing that you don't need");
	        System.out.println("Have Fun!!");
	        System.out.print("White nickname : ");
	        Blanc = m.AskBlanc(); 
	        System.out.println("And your adversaire qui sont les Black!!");
			System.out.print("Black nickname : ");
			Black = m.AskBlack();
			System.out.println("Ce duel opposera alors " + Blanc + " against " + Black + "!");
			System.out.println("----------------------------------------------------------");
	}
	
	public static void BadInput() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Mauvais Input");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void BadMove() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Mauvais d�placement");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void BadPionBlanc() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Choose a White Pawn");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void BadPionBlack() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Choose a Black Pawn");
		System.out.println("---------------------------------------------------------");
		
	}
	
	 public static void write(String strToPrint, String fileName) {
	        try {
	          FileWriter myWriter = new FileWriter(fileName,true);
	          myWriter.write(strToPrint+'\n');
	          myWriter.close();
	        }
	        catch (IOException e) {
	          System.out.println("Erreur.");
	          e.printStackTrace();
	        }
	 }
	
}
