package main;

import java.util.ArrayList;

import model.Pion;

public class Board {

	Variables v = new Variables();
	
	public final int ligne = 8;
	public final int colonne = 8;
	public String[][] tableauDeDame = new String[ligne][colonne];
	
	public void printTab(String[][] tableauDeDame) {
		displayRowIndex();
		for(int i = 0; i < tableauDeDame.length; i++) {
			drawHorizontalLine();
			
			for(int j = 0; j < tableauDeDame[i].length; j++) {
				if(j == 0) {
					leftDisplayColIndex(i);
				} else {
					drawVerticalLine();
				}
				System.out.print(tableauDeDame[j][i]);				
			}
			rightDisplayColIndex(i);
			System.out.println();
		}
		drawHorizontalLine();
		displayRowIndex();
	}
	
	
	
	public void fillTab(String[][] tableauDeDame, ArrayList<Pion> pionPlacement) {
		
		
		for(int i = 0 ; i < tableauDeDame.length ; i++) {
			if(i%2 == 0) {
				for(int j = 0 ; j < tableauDeDame[i].length ; j++) {
					if(j%2 == 0) {
						tableauDeDame[i][j] = "     ";
					} else {
						tableauDeDame[i][j] = "  -  ";
					}
				}
			} else {
				for(int j = 0 ; j < tableauDeDame[i].length ; j++) {
					if(j%2 != 0) {
						tableauDeDame[i][j] = "     ";
					} else {
						tableauDeDame[i][j] = "  -  ";
					}	
				}
			}
			
		}
		for (Pion perso: pionPlacement) {
			tableauDeDame[perso.getX()][perso.getY()] = perso.getPion();
		}
		
		printTab(tableauDeDame);
	}
			
	public void drawHorizontalLine() {        
		System.out.println("   _______________________________________________");   
	}

	public void drawVerticalLine() {
		System.out.print("|");
	}

	public void leftDisplayColIndex(int i) {
		
		System.out.print(i + " |");
	}
	public void rightDisplayColIndex(int i) {
		
		System.out.print("| " + i);
	}
	
	public void displayRowIndex() {
	    for(int index = 0; index < 8; index++) {
	    	System.out.print("     " + index);
	    }
	    System.out.println();
	}
	
	
	
}
