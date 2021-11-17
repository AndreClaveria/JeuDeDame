package main;

import java.util.ArrayList;

import model.Pion;

public class Board {

	Variables v = new Variables();
	
	public final int ligne = 8;
	public final int colonne = 8;
	public String[][] tableauDeDame = new String[ligne][colonne];
	
	public void printTab(String[][] tableauDeDame) {
		DisplayRowIndex();
		for(int i = 0; i < tableauDeDame.length; i++) {
			DrawHorizontalLine();
			
			for(int j = 0; j < tableauDeDame[i].length; j++) {
				if(j == 0) {
					LeftDisplayColIndex(i);
				} else {
					DrawVerticalLine();
				}
				System.out.print(tableauDeDame[j][i]);				
			}
			RightDisplayColIndex(i);
			System.out.println();
		}
		DrawHorizontalLine();
		DisplayRowIndex();
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
			
	public void DrawHorizontalLine() {        
		System.out.println("   _______________________________________________");   
	}

	public void DrawVerticalLine() {
		System.out.print("|");
	}

	public void LeftDisplayColIndex(int i) {
		
		System.out.print(i + " |");
	}
	public void RightDisplayColIndex(int i) {
		
		System.out.print("| " + i);
	}
	
	public void DisplayRowIndex() {
	    for(int index = 0; index < 8; index++) {
	    	System.out.print("     " + index);
	    }
	    System.out.println();
	}
	
	
	
}
