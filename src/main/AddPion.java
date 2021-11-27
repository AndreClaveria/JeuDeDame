package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class AddPion {
	
	String fileName = new String("./data.txt");
	File file = new File("data.txt");
	
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
	
	public void moveOfPawn(int oldX, int oldY, int newX, int newY ) {
		String strToPrint = "(" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")";
		Utilitaires.write(strToPrint, fileName);
		System.out.println("-------------------------------------------------------"); 
	    System.out.println(strToPrint);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void eatAPawn(int oldX, int oldY, int newX, int newY, int eatPawnX, int eatPawnY) {
		String strToPrint = "(" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")" + " a mangé le pion en (" + eatPawnX + "," + eatPawnY + ")";
		Utilitaires.write(strToPrint, fileName);
		System.out.println("-------------------------------------------------------");
	    System.out.println(strToPrint);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void pawnBecomeQueen(int newX, int newY ) {
		System.out.println("-------------------------------------------------------");
	    System.out.println("(" + newX + "," + newY + ") est devenu une reine");
	    System.out.println("-------------------------------------------------------");
	}

}
