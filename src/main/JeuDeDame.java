package main;

import utils.Board;

public class JeuDeDame {
	
	Board b = new Board();
	
	final int ligne = 8;
	final int colonne = 8;
	String[][] tableauDeDame = new String[ligne][colonne];
	
	
	public void JeuDeGame() {
		b.fillTab(tableauDeDame);
	}
	
}
