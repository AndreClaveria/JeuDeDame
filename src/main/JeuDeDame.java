package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class JeuDeDame {
	
	Board b = new Board();
	int directionLigne;
	int directionColonne;
	final int ligne = 8;
	final int colonne = 8;
	boolean a;
	String[][] tableauDeDame = new String[ligne][colonne];
	
	Scanner mouv = new Scanner(System.in);
	
	
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
		
		do {
			b.fillTab(tableauDeDame, allPion);
			direction();
		}while(true);
	}
	
	public void direction() {
		Utilitaires.demandeColonne();
		
		for(Pion p : allPion) {
			try {
				directionLigne = mouv.nextInt();
				Utilitaires.demandeLigne();
				directionColonne = mouv.nextInt();
				mouvPionBlanc( directionLigne, directionColonne);
			} catch(Exception e) {
				
			}
			
				
		}
		
	}
	
	public void mouvPionBlanc(int x, int y) {
		do {
			for(Pion p : allPion) {
				if(p.getX() == x && p.getY() == y) {
					a = true;
					if(p.getPion() == "  W  ") {
						Utilitaires.demandeColonneMouv();
						directionLigne = mouv.nextInt();
						Utilitaires.demandeLigneMouv();
						directionColonne = mouv.nextInt();
						if((p.getX() + 1) == directionLigne && (p.getY() - 1) == directionColonne
								|| (p.getX() - 1) == directionLigne && (p.getY() - 1) == directionColonne) {
							tableauDeDame[p.getX()][p.getY()] = "  -  ";
							p.setX(directionLigne);
							p.setY(directionColonne);
							tableauDeDame[p.getX()][p.getY()] = p.getPion();
							b.fillTab(tableauDeDame, allPion);
							
						} else {
							System.out.println("Mauvais déplacement");
							direction();
						}
					} else {
						System.out.println("Mauvais pion");
						direction();
					} 
				} else {
					a = false;
				}
			}	
		} while(a == true);
		System.out.print("Pas de pion");
		direction();
	
	}

}
