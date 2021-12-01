package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import main.Menu;


public class Utilitaires {
	
	static Menu m = new Menu();
	 public static int whitecount = 1;
	 public static int blackcount = 1;
	File file = new File("logs.txt");
	public static String Blanc = "";
	public static String Black = "";
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
	public static void whiteTurn() {
	    System.out.println("#######################################################");
	    System.out.println("              WHITE'S TURN (" + Blanc + ")");
	    System.out.println("#######################################################");
	        
	}
	public static String blackWin() {
		return
		"#######################################################\n	  !!! BLACK HAS WON !!! GG à " + Black.toUpperCase() + "\n#######################################################";
     
    }
    public static String whiteWin() {
    	return 
        "#######################################################\n 	  !!! WHITE HAS WON !!! GG à " + Blanc.toUpperCase() + "\n#######################################################";

    }
	public static void welcome() {
	    System.out.println("#######################################################");
	    System.out.println("Bienvenue, in our Game fait par : ");
	        System.out.println("Us Hehe(Andre, Vencatveer, Florian) !");
	        System.out.println("----------------------------------------------------------");
	        System.out.println("Soyez sure de ne pas write other thing that you don't need");
	        System.out.println("Have Fun!!");
			chooseAgainstWho();
	}
	
	public static void chooseAgainstWho() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Voulez vous affronter un bot ou un autre joueur");
		System.out.println("1/Un bot");
		System.out.println("2/Un joueur");
		Scanner sc = new Scanner(System.in);
		try { 
			 int nombre = sc.nextInt();
			 switch(nombre) {
			 case 1: 
				 System.out.println("En cours de dévelopement");
				 System.out.println("Le mode joueur contre joueur est le seul disponible !");
				 chooseAgainstWho();
			        break;
			 case 2:
				 System.out.println("Vous avez choisi d'affronter un joueur");
			        System.out.print("White nickname : ");
			        Blanc = m.askBlanc(); 
			        System.out.println("And your adversaire qui sont les Black!");
					System.out.print("Black nickname : ");
					Black = m.askBlack();
					System.out.println("Ce duel opposera alors " + Blanc + " against " + Black + "!");
					break;
				 default:
					 chooseAgainstWho();
			 
			 }
			System.out.println("-------------------------------------------------------");
		}catch(Exception e) {
			sc.next();
			chooseAgainstWho();
		}
		
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
	
	 public static void read(String fileName) {
		 try {
				List<String> allLines = Files.readAllLines(Paths.get(fileName));
				for (String line : allLines) {
					if(line.equals(Utilitaires.Black)) {
						blackcount++;
					}else if (line.equals(Utilitaires.Blanc)){
						whitecount++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	 
}
}
