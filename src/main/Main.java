package main;

public class Main {
	
	public static void main(String[] args) {
		fillTab(tableauDeDame);
	}
	
	
	static final int ligne = 8;
	static final int colonne = 8;
	
	static String[][] tableauDeDame = new String[ligne][colonne];
	
	public static void printTab(String[][] tableauDeDame) {
		for(int i = 0; i < tableauDeDame.length; i++) {
			DrawHorizontalLine();
			for(int j = 0; j < tableauDeDame[i].length; j++) {
				DrawVerticalLine();
				System.out.print(tableauDeDame[j][i]);
				
				
			}
			DrawVerticalLine();
			System.out.println();
		}
		DrawHorizontalLine();
	}
	
	public static void fillTab(String[][] tableauDeDame) {
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

		printTab(tableauDeDame);
	}
			
	
	public static void DrawHorizontalLine() {        
    System.out.println(" _______________________________________________");   
	}

//
	public static void DrawVerticalLine() {
    System.out.print("|");
	}
}
//
//private void DisplayColIndex() {
//    System.out.print("   ");
//    for(int colIndex = 0; colIndex<cols; colIndex++){            
//        System.out.print("   " + colIndex + "  " );            
//    }
//    System.out.println();
//}
//
//private void DisplayRowIndex(int i) {
//    System.out.print(" " + i + " ");
//}


