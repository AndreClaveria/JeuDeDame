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
				tableauDeDame[0][0] = "     ";
				tableauDeDame[0][1] = "  -  ";
				tableauDeDame[0][2] = "     ";
				tableauDeDame[0][3] = "  -  ";
				tableauDeDame[0][4] = "     ";
				tableauDeDame[0][5] = "  -  ";
				tableauDeDame[0][6] = "     ";
				tableauDeDame[0][7] = "  -  ";
				
				tableauDeDame[1][0] = "  -  ";
				tableauDeDame[1][1] = "     ";
				tableauDeDame[1][2] = "  -  ";
				tableauDeDame[1][3] = "     ";
				tableauDeDame[1][4] = "  -  ";
				tableauDeDame[1][5] = "     ";
				tableauDeDame[1][6] = "  -  ";
				tableauDeDame[1][7] = "     ";
				
				tableauDeDame[2][0] = "     ";
				tableauDeDame[2][1] = "  -  ";
				tableauDeDame[2][2] = "     ";
				tableauDeDame[2][3] = "  -  ";
				tableauDeDame[2][4] = "     ";
				tableauDeDame[2][5] = "  -  ";
				tableauDeDame[2][6] = "     ";
				tableauDeDame[2][7] = "  -  ";
				
				tableauDeDame[3][0] = "  -  ";
			
				tableauDeDame[3][1] = "     ";
				tableauDeDame[3][2] = "  -  ";
				tableauDeDame[3][3] = "     ";
				tableauDeDame[3][4] = "  -  ";
				tableauDeDame[3][5] = "     ";
				tableauDeDame[3][6] = "  -  ";
				tableauDeDame[3][7] = "     ";
				
				tableauDeDame[4][0] = "     ";
			
				tableauDeDame[4][1] = "  -  ";
				tableauDeDame[4][2] = "     ";
				tableauDeDame[4][3] = "  -  ";
				tableauDeDame[4][4] = "     ";
				tableauDeDame[4][5] = "  -  ";
				tableauDeDame[4][6] = "     ";
				tableauDeDame[4][7] = "  -  ";
				
				tableauDeDame[5][0] = "  -  ";
		
				tableauDeDame[5][1] = "     ";
				tableauDeDame[5][2] = "  -  ";
				tableauDeDame[5][3] = "     ";
				tableauDeDame[5][4] = "  -  ";
				tableauDeDame[5][5] = "     ";
				tableauDeDame[5][6] = "  -  ";
				tableauDeDame[5][7] = "     ";
				
				tableauDeDame[6][0] = "     ";
	
				tableauDeDame[6][1] = "  -  ";
				tableauDeDame[6][2] = "     ";
				tableauDeDame[6][3] = "  -  ";
				tableauDeDame[6][4] = "     ";
				tableauDeDame[6][5] = "  -  ";
				tableauDeDame[6][6] = "     ";
				tableauDeDame[6][7] = "  -  ";
			
				tableauDeDame[7][0] = "  -  ";
	
				tableauDeDame[7][1] = "     ";
				tableauDeDame[7][2] = "  -  ";
				tableauDeDame[7][3] = "     ";
				tableauDeDame[7][4] = "  -  ";
				tableauDeDame[7][5] = "     ";
				tableauDeDame[7][6] = "  -  ";
				tableauDeDame[7][7] = "     ";
		
			
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


