package main;

import java.util.ArrayList;

import model.Pion;
import utils.Board;

public class JeuDeDame {
	
	Board b = new Board();
	
	final int ligne = 8;
	final int colonne = 8;
	String[][] tableauDeDame = new String[ligne][colonne];
	Pion w1 = new Pion(0, 5, "  W  ", true);
	ArrayList<Pion> allPion = new ArrayList<Pion>();
	
	public void JeuDeGame() {
		allPion.add(w1);
		b.fillTab(tableauDeDame, allPion);
	}
	
}
