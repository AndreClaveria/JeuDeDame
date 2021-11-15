package main;

import java.util.ArrayList;
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
		Utilitaires.demandeLigne();
		for(Pion p : allPion) {
			directionLigne = mouv.nextInt();
			Utilitaires.demandeColonne();
			directionColonne = mouv.nextInt();
			mouvPionBlanc(p, directionLigne, directionColonne);	
		}
		
	}
	
	public void mouvPionBlanc(Pion p, int x, int y) {
		System.out.println(x);
		System.out.println(y);
		System.out.println(p);
		
		if(p.getPion() == "  W  ") {
			if(p.getX() == x && p.getY() == y) {
				Utilitaires.demandeLigneMouv();
				directionLigne = mouv.nextInt();
				Utilitaires.demandeColonneMouv();
				directionColonne = mouv.nextInt();
				if(tableauDeDame[directionLigne][directionColonne] == "  -  ") {
					tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(directionLigne);
					p.setY(directionColonne);
					tableauDeDame[p.getX()][p.getY()] = p.getPion();
				}
			}
		} else {
			System.out.println("Error");
		}
		
	}
	
}
