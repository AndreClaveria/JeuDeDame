package main;

import java.io.PrintWriter;
import java.util.ArrayList;


import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class AddPion {

	public String fichier = "fichier.txt";
	
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
	
	public void PrintBlackDeadArray(Pion p) {
	    System.out.println("-------------------------------------------------------");
	    PrintArrayListBlack(deadPawnBlack);
	    System.out.println("-------------------------------------------------------");
	        
	}
	
	public void PrintArrayListBlack(ArrayList<Pion> jeVeuxDormir) {
		System.out.println("Dead Black Pawn : ");
        for(int i = 0; i < jeVeuxDormir.size(); i++) {
        	
            System.out.println((jeVeuxDormir.get(i)).getNomPion() + "(" +
            		(jeVeuxDormir.get(i).getX()) + "," + (jeVeuxDormir.get(i).getY())
            		+ ")");
            
        }
	}
	public void PrintWhiteDeadArray(Pion p) {
	    System.out.println("-------------------------------------------------------");
	    PrintArrayListWhite(deadPawnWhite);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void PrintArrayListWhite(ArrayList<Pion> jeVeuxDormir) {
		System.out.println("Dead White Pawn : ");
        for(int i = 0; i < jeVeuxDormir.size(); i++) {
            System.out.println((jeVeuxDormir.get(i)).getNomPion() + "(" +
            		(jeVeuxDormir.get(i).getX()) + "," + (jeVeuxDormir.get(i).getY())
            		+ ")");    
        }
	}
	
	public void MoveOfPawn(int oldX, int oldY, int newX, int newY ) {
		String strToPrint = "(" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")";
		Utilitaires.write(strToPrint, fichier);
		System.out.println("-------------------------------------------------------");
	    System.out.println(strToPrint);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void writeInFile(int oldX, int oldY, int newX, int newY, int eatPawnX, int eatPawnY) {
		String strToPrint = "(" + oldX + "," + oldY + ") -> (" + newX + "," + newY + ")" + " a mangé le pion en (" + eatPawnX + "," + eatPawnY + ")";
		Utilitaires.write(strToPrint, fichier);
		System.out.println("-------------------------------------------------------");
	    System.out.println(strToPrint);
	    System.out.println("-------------------------------------------------------");
	}
	
	public void PawnBecomeQueen(int newX, int newY ) {
		System.out.println("-------------------------------------------------------");
	    System.out.println("(" + newX + "," + newY + ") est devenu une reine");
	    System.out.println("-------------------------------------------------------");
	}
}
