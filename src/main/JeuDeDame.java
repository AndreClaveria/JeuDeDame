package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Perso;
import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class JeuDeDame {
	
	Board b = new Board();
	
	final int ligne = 8;
	final int colonne = 8;
	String[][] tableauDeDame = new String[ligne][colonne];	
	
	public ArrayList<Pion> allPion = new ArrayList<Pion>();
	
	public void JeuDeGame() {
		
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
		b.fillTab(tableauDeDame, allPion);
	}
	
	public static void recupIndex() {
		
	//TODO : récupérer l'index de la colonne et la ligne du pion à bouger.
		
	}

//	private void mouvMap() {
//		//faire un scanner, demander mouvement à utilisateur
//		
//		do{
//			System.out.println("\n\nSaisir mouvement (up:z , down:s, left:q, right:d).");
//		
//			int mouvement;
//			//gerer la saisie clavier
//			
//				for(Pion perso : allPion) {
//					
//					    mouvement = Utilitaires.saisieMouv();
//					
//					}
//					mouvPion(pion,mouvement);
//				
//				
//				
//	b.fillTab(tableauDeDame, allPion);
//			
//		}
//
//		while(true);
//	}
	
	
}
