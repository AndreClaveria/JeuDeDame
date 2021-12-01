package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class AddPion {

	String fileName = new String("./logs.txt");
	String fileName1 = new String("./nicknameList.txt");
	String fileName2 = new String("./countNicknameVictory.txt");
	File file = new File("logs.txt");
	
	public ArrayList<Pion> allPion = new ArrayList<Pion>();
	public ArrayList<Pion> deadPawnWhite = new ArrayList<Pion>();
	public ArrayList<Pion> deadPawnBlack= new ArrayList<Pion>();
	
	
	public void addPion() {
		
		allPion.add(CreatePerso.p1);
		allPion.add(CreatePerso.p2);
		allPion.add(CreatePerso.p3);
		allPion.add(CreatePerso.p4);
		allPion.add(CreatePerso.p5);
		allPion.add(CreatePerso.p6);
		allPion.add(CreatePerso.p7);
		allPion.add(CreatePerso.p8);
		allPion.add(CreatePerso.p9);
		allPion.add(CreatePerso.p10);
		allPion.add(CreatePerso.p11);
		allPion.add(CreatePerso.p12);
		allPion.add(CreatePerso.p13);
		allPion.add(CreatePerso.p14);
		allPion.add(CreatePerso.p15);
		allPion.add(CreatePerso.p16);
		allPion.add(CreatePerso.p17);
		allPion.add(CreatePerso.p18);
		allPion.add(CreatePerso.p19);
		allPion.add(CreatePerso.p20);
		allPion.add(CreatePerso.p21);
		allPion.add(CreatePerso.p22);
		allPion.add(CreatePerso.p23);
		allPion.add(CreatePerso.p24);
		
		//For testing Black Win condition
//		deadPawnWhite.add(CreatePerso.p1);
//		deadPawnWhite.add(CreatePerso.p2);
//		deadPawnWhite.add(CreatePerso.p3);
//		deadPawnWhite.add(CreatePerso.p4);
//		deadPawnWhite.add(CreatePerso.p5);
//		deadPawnWhite.add(CreatePerso.p6);
//		deadPawnWhite.add(CreatePerso.p7);
//		deadPawnWhite.add(CreatePerso.p8);
//		deadPawnWhite.add(CreatePerso.p9);
//		deadPawnWhite.add(CreatePerso.p10);
//		deadPawnWhite.add(CreatePerso.p11);
//		allPion.add(CreatePerso.p12);
//		allPion.add(CreatePerso.p13);
//		allPion.add(CreatePerso.p14);
//		allPion.add(CreatePerso.p15);
//		allPion.add(CreatePerso.p16);
//		allPion.add(CreatePerso.p17);
//		allPion.add(CreatePerso.p18);
//		allPion.add(CreatePerso.p19);
//		allPion.add(CreatePerso.p20);
//		allPion.add(CreatePerso.p21);
//		allPion.add(CreatePerso.p22);
//		allPion.add(CreatePerso.p23);
//		allPion.add(CreatePerso.p24);
		
		//For testing White Win condition
//		allPion.add(CreatePerso.p1);
//		allPion.add(CreatePerso.p2);
//		allPion.add(CreatePerso.p3);
//		allPion.add(CreatePerso.p4);
//		allPion.add(CreatePerso.p5);
//		allPion.add(CreatePerso.p6);
//		allPion.add(CreatePerso.p7);
//		allPion.add(CreatePerso.p8);
//		allPion.add(CreatePerso.p9);
//		allPion.add(CreatePerso.p10);
//		allPion.add(CreatePerso.p11);
//		allPion.add(CreatePerso.p12);
//		allPion.add(CreatePerso.p13);
//		deadPawnBlack.add(CreatePerso.p14);
//		deadPawnBlack.add(CreatePerso.p15);
//		deadPawnBlack.add(CreatePerso.p16);
//		deadPawnBlack.add(CreatePerso.p17);
//		deadPawnBlack.add(CreatePerso.p18);
//		deadPawnBlack.add(CreatePerso.p19);
//		deadPawnBlack.add(CreatePerso.p20);
//		deadPawnBlack.add(CreatePerso.p21);
//		deadPawnBlack.add(CreatePerso.p22);
//		deadPawnBlack.add(CreatePerso.p23);
//		deadPawnBlack.add(CreatePerso.p24);
	}
	
	public void printBlackDeadArray(Pion p) {
	    System.out.println("-------------------------------------------------------");
	    printArrayListBlack(deadPawnBlack);
	    System.out.println("-------------------------------------------------------");
	        
	}
	
	public void printArrayListBlack(ArrayList<Pion> deadPawnBlack) {
		System.out.println("Dead Black Pawn : ");
        for(int i = 0; i < deadPawnBlack.size(); i++) {
        	
            System.out.println((deadPawnBlack.get(i)).getNomPion() + "(" +
            		(deadPawnBlack.get(i).getX()) + "," + (deadPawnBlack.get(i).getY())
            		+ ")");
            
        }
	}
	public void printWhiteDeadArray(Pion p) {
	    System.out.println("-------------------------------------------------------");
	    printArrayListWhite(deadPawnWhite);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void printArrayListWhite(ArrayList<Pion> deadPawnWhite) {
		System.out.println("Dead White Pawn : ");
        for(int i = 0; i < deadPawnWhite.size(); i++) {
            System.out.println((deadPawnWhite.get(i)).getNomPion() + "(" +
            		(deadPawnWhite.get(i).getX()) + "," + (deadPawnWhite.get(i).getY())
            		+ ")");    
        }
	}
	
	public void moveOfPawn(int tour, int oldX, int oldY, int newX, int newY ) {
		if(tour%2 == 0) {
			String strToPrint = "Blanc : (" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		} else {
			String strToPrint = "Blanc : (" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		}
		
	}
	
	
	public void eatAPawn(int tour, int oldX, int oldY, int newX, int newY, int eatPawnX, int eatPawnY) {
		if(tour%2 == 0) {
			String strToPrint = "Blanc : (" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")" + " a mangé le pion en (" + eatPawnX + "," + eatPawnY + ")";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		} else {
			String strToPrint = "Noir : (" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")" + " a mangé le pion en (" + eatPawnX + "," + eatPawnY + ")";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		}
		
		
	}
	
	public void pawnBecomeQueen(int tour, int newX, int newY ) {
		
		if(tour%2 == 0) {
			String strToPrint ="Blanc : (" + newX + "," + newY + ") est devenu une reine";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		} else {
			String strToPrint ="Noir : (" + newX + "," + newY + ") est devenu une reine";
			Utilitaires.write(strToPrint, fileName);
			System.out.println("-------------------------------------------------------");
		    System.out.println(strToPrint);
		    System.out.println("-------------------------------------------------------");
		}
		
	}
	
	public boolean gameOver() {
		if(deadPawnBlack.size() == 12 || deadPawnWhite.size() == 12) {
			return true;
		}
		return false;
		
	}
		    
	public void winnerIs() { 
		Utilitaires.read(fileName1);
		if (deadPawnBlack.size() == 12) {
			String strToPrint = Utilitaires.Blanc;
			String str = "Pseudo: "+ Utilitaires.Blanc +" | "+ "Nb de victoire total : " + Utilitaires.whitecount + "\n ----- \n";
			Utilitaires.write(strToPrint, fileName1);
			Utilitaires.write(str, fileName2);
			System.out.println(Utilitaires.whiteWin());		
		} else if(deadPawnWhite.size() == 12){
			String strToPrint = Utilitaires.Black;
			String str = "Pseudo: "+ Utilitaires.Black +" | "+ "Nb de victoire total : " + Utilitaires.blackcount + "\n ----- \n";
			Utilitaires.write(strToPrint, fileName1);
			Utilitaires.write(str, fileName2);
			 System.out.println(Utilitaires.blackWin());
		}
	}
}
