package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import main.JeuDeDame;
import main.Menu;


public class Utilitaires {
	
	static Menu m = new Menu();
	File file = new File("data.txt");
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
	
	public static void blackTurn() {
	    System.out.println("#######################################################");
	    System.out.println("              BLACK'S TURN (" + Black + ")");
	    System.out.println("#######################################################");
	        
	}
	public static void whiteturn() {
	    System.out.println("#######################################################");
	    System.out.println("              WHITE'S TURN (" + Blanc + ")");
	    System.out.println("#######################################################");
	        
	}
	public static void blackWin() {
        System.out.println("#######################################################");
        System.out.println("UWU !!! BLACK'S HAS WON !!! GG à "  + Black.toUpperCase());
        System.out.println("#######################################################");

    }
    public static void whiteWin() {
        System.out.println("#######################################################");
        System.out.println("UWU !!! WHITE'S HAS WON !!! GG à " + Blanc.toUpperCase());
        System.out.println("#######################################################");

    }
	public static void welcome() {
	    System.out.println("#######################################################");
	    System.out.println("Bienvenue, in our Game fait par : ");
	        System.out.println("Us Hehe(André, Vencatveer, Florian) !");
	        System.out.println("----------------------------------------------------------");
	        System.out.println("Soyez sure de ne pas write other thing that you don't need");
	        System.out.println("Have Fun!!");
	        chooseAgainstWho();
			System.out.println("----------------------------------------------------------");
	}
	
	public static void badInput() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Mauvais Input");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void badMove() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Mauvais déplacement");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void badPionBlanc() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Choose a White Pawn");
		System.out.println("---------------------------------------------------------");
	}
	
	public static void badPionBlack() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Choose a Black Pawn");
		System.out.println("---------------------------------------------------------");
		
	}
	public static void chooseAgainstWho() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Voulez vous affronter un bot ou un autre joueur");
		System.out.println("1/Un bot");
		System.out.println("2/Un joueur");
		Scanner sc = new Scanner(System.in);
		 int nombre = sc.nextInt();
		 switch(nombre) {
		 case 1: 
			 System.out.println("En cours de dévelopement");
			 System.out.println("Vous avez choisi d'affronter un bot");
			 System.out.println("Vous jouerez les blancs");
			 System.out.print("White nickname : ");
		        Blanc = m.AskBlanc(); 
		        System.out.println("And your adversaire qui sont les Black!!");
		        Black = "Bot 01";
		        System.out.println("Ce duel opposera alors " + Blanc + " against " + Black + "!");
		        break;
		 case 2:
			 System.out.println("Vous avez choisi d'affronter un joueur");
		        System.out.print("White nickname : ");
		        Blanc = m.AskBlanc(); 
		        System.out.println("And your adversaire qui sont les Black!!");
				System.out.print("Black nickname : ");
				Black = m.AskBlack();
				System.out.println("Ce duel opposera alors " + Blanc + " against " + Black + "!");
				break;
			 default:
		 
		 }
		System.out.println("-------------------------------------------------------");
	}
	
    public static void write(String strToPrint, String fileName) {
        try {
          FileWriter myWriter = new FileWriter(fileName);
          myWriter.write(strToPrint);
          myWriter.close();
          System.out.println("Enregistré ! \n");
        }
        catch (IOException e) {
          System.out.println("Erreur.");
          e.printStackTrace();
        }
}

    public static void read(File fileName) {
        try {
          Scanner sc = new Scanner(fileName);
          while (sc.hasNextLine()) {
          String data = sc.nextLine();
          System.out.println(data);
          }
          sc.close();
        } 
         catch (FileNotFoundException e) {
         System.out.println("Fichier non trouvé.");
         e.printStackTrace();
        }
}
}
