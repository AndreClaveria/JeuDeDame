package main;

import java.util.Objects;

import model.Pion;

import utils.Utilitaires;

public class JeuDeDame {
	
	Board b = new Board();
	AddPion plus = new AddPion();
	Variables v = new Variables();
	CanMove cm = new CanMove();
	Menu m = new Menu();
	int[] PNM = new int[2];
	int[][][] eatMapping = new int[24][8][];
	int[][][] eatMappingW = new int[24][8][];
	int[][][][] eatAr = new int[12][8][][]; // un tableau des 12 pions et de leurs 4 possibilités
	int[][][] toRetur = new int[4][8][];
	int[][][] tRA = new int[8][][]; // un tableau des 4 possibilités de chemins
	int tRAinc = 0;
	int[][] temporary = new int[8][2]; // un tableau des 3 valeurs max d'un chemin
	int maxdepth = 0;
	int[] depthes = new int[4];
	int[] depthesW = new int[4];
	
	public void JeuDeGame() {
		plus.file.delete();
		Utilitaires.Welcome();
		plus.addPion();	
		cm.whoseTurn(v.tour);
		b.fillTab(b.tableauDeDame, plus.allPion);
		direction();
	}
	
	
	public void direction() {
		
		Utilitaires.demandeColonne();
		try {
			v.directionLigne = v.mouv.nextInt();
			Utilitaires.demandeLigne();
			try {
				v.directionColonne = v.mouv.nextInt();
				if(v.tour%2 == 0) {
					
					mouvPionBlanc(v.directionLigne, v.directionColonne);
				} else {
					
					mouvPionNoir(v.directionLigne, v.directionColonne);
					
				}
			} catch(Exception e) {
				Utilitaires.BadInput();
				v.mouv.next();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			}
		} catch(Exception e) {
			Utilitaires.BadInput();
			v.mouv.next();
			b.fillTab(b.tableauDeDame, plus.allPion);
			direction();
		}
		
	}
	
	public void mouvOneCase(Pion p) {
		Utilitaires.demandeColonneMouv();
		try {
			v.directionLigne = v.mouv.nextInt();
			Utilitaires.demandeLigneMouv();
			try {
				v.directionColonne = v.mouv.nextInt();
				System.out.println();
				PNM = new int[] {v.directionLigne, v.directionColonne};
				if(v.tour%2 == 0) {
					
					mouvDiagBlanc(p);
				} else {
					System.out.println("Le tour des noirs");
					mouvDiagNoir(p);
					
				} 
			} catch (Exception e) {
				
				
				b.fillTab(b.tableauDeDame, plus.allPion);
				
			}
		} catch (Exception e) {

			b.fillTab(b.tableauDeDame, plus.allPion);
			
		}		
	}
	
	public void pawnBecomeBeg() {
		for(Pion p : plus.allPion) {
			if((p.getPion() == "  w  ") && (p.getY() == 0)) {
				p.setPion("  W  ");
				plus.pawnBecomeQueen(p.getX(), p.getY());
			} else if ((p.getPion() == "  n  ") && (p.getY() == 7)){
				p.setPion("  N  ");
				plus.pawnBecomeQueen(p.getX(), p.getY());
			}
		}
		
	}
	
	/*
	 FONCTION DES BLANCS
	 */
	
	public void mouvPionBlanc(int x, int y) {
		
		for(Pion p : plus.allPion) {
			if(p.getX() == x && p.getY() == y) {
				if(p.getPion() == "  W  " || p.getPion() == "  w  ") {
					mouvOneCase(p);
					break;
				} else {
					Utilitaires.BadPionBlanc();
					b.fillTab(b.tableauDeDame, plus.allPion);
					direction();
				} 
			}
		}
		
		System.out.println("\nFin de Tour ou pas de pion \n");
		cm.whoseTurn(v.tour);
		direction();
	}
	
	public void mouvDiagBlanc(Pion p) {
		verifEatWite();
		int verifEatInt = verifEatWhite(p);
		if (verifEatInt == 1){
			if((p.getX() + 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
				&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
				|| (p.getX() - 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
				&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {
					plus.moveOfPawn(p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					v.tour = v.tour + 1;
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);	
			} else {
				Utilitaires.BadMove();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			} 
		} else if(verifEatInt == 2) {
					
				b.fillTab(b.tableauDeDame, plus.allPion);
				
			
		}
	}
	
	public void changeToNewPosition(Pion p, int x, int y) {
		b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
		p.setX(v.directionLigne);
		p.setY(v.directionColonne);
		b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
		pawnBecomeBeg();
		b.fillTab(b.tableauDeDame, plus.allPion);
	}
	
	public void removePion(int i, int i2) {
		for(Pion pion : plus.allPion) {
			if (pion.getX() == i && pion.getY() == i2) {
				plus.allPion.remove(pion);
				v.tour = v.tour + 1;
				break;
			}
		}
	}
	public void eatWhitePawn(Pion p, int oldX, int oldY, int newX, int newY) {
		for(Pion pion : plus.allPion) {
            if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()+1 )) {
                plus.eatAPawn(oldX, oldY, newX, newY, p.getX()+1, p.getY()+1);
                plus.allPion.remove(pion);
                plus.deadPawnWhite.add(pion);
                plus.PrintWhiteDeadArray(pion);
                break;
            } else if ((pion.getX() == p.getX()-1) && (pion.getY() == p.getY()+1 )) {
            	 plus.eatAPawn(oldX, oldY, newX, newY, p.getX()-1, p.getY()+1);
                 plus.allPion.remove(pion);
                 plus.deadPawnWhite.add(pion);
                 plus.PrintWhiteDeadArray(pion);
                 break;
            }
        }
	}
	
	public int verifEatWhite(Pion pion) {
		int verifposs = 0;
		
        for (int i  = 12; i < 24; i++) {
            if (Objects.isNull(eatMappingW[i][0])) {
                verifposs++;
            }
        }
        
        if (verifposs == 12) {
            return 1;
        }
		for (int i  = 12; i < 24; i++) {
			if (Objects.nonNull(eatMappingW[i][0])) {
				if(eatMappingW[i][0][0] == pion.getX() && eatMappingW[i][0][1] == pion.getY()) {
					for (int v = 0; v < eatMappingW[i-12][0].length; v++) {
						if(eatMappingW[i-12][v][0] == PNM[0] && eatMappingW[i-12][v][1] == PNM[1]) {
							for (int[] coo : eatAr[i-12][v]) {
								if(coo[0] == 0 && coo[1] == 0 || coo[0] == eatMappingW[i-12][v][0] && coo[1] == eatMappingW[i-12][v][1]) {
									
								}else{
					                removePion(coo[0], coo[1]);
								}
							}
							changeToNewPosition(pion, PNM[0], PNM[1]);
							eatMappingW = new int[24][8][];
							return 3;
						}
					}
				}else {
					System.out.println("Mouvement possible !");
					for (int v = 0; v < 8; v++) {
						if (Objects.nonNull(eatMappingW[i-12][v])) {
							System.out.println("Tu peux manger avec le pion ("
							+eatMappingW[i][0][0]+ "," + eatMappingW[i][0][1] + ") "
							+ "en (" + eatMappingW[i-12][v][0] + "," 
							+ eatMappingW[i-12][v][1] + ")");
							System.out.println("ce.s pion.s sera.ont mangé.s : ");
							for (int[] coo : eatAr[i-12][v]) {
								if(coo[0] == 0 && coo[1] == 0 || coo[0] == eatMappingW[i-12][v][0] && coo[1] == eatMappingW[i-12][v][1]) {
									
								}else{
									System.out.println("(" + coo[0] + "," + coo[1] + ")\n");
								}
							}
						}
					}
				}
			}
		}
		eatMappingW = new int[24][8][];
		return 3;
	}
	
	public void  verifEatWite() {
		
		int vardinc = 0;
		for(Pion p : plus.allPion) {
			
			if(p.getPion() == "  w  ") {
				
				depthesW = new int[] {0,0,0,0};
				maxdepth = 0;
				
				allbesteatingmoveWhite(p.getX(), p.getY(), 0);
				
				for(int i = 3; i > 0; i--) {
				
					if (depthesW[i] > 0) {
					
						for (int v = 0; v < 8; v++) {
							
							if (Objects.nonNull(toRetur[i][v])) {
								
								eatMappingW[vardinc][v] = toRetur[i][v];
							}
						}
						eatAr[vardinc] = tRA;
						eatMappingW[vardinc+12][0] = new int[]{p.getX(), p.getY()};
						break;
					}
				} 
				toRetur = new int[4][8][];
				tRA = new int[4][4][];
				vardinc++; 
				
			}
		}
		
	}
	
	public void allbesteatingmoveWhite(int posX, int posY, int depth){
		if (allBestEatingMoveWhiteDeepR(posX-1, posY-1)) {
			temporary[depth] = new int[] {posX-1, posY-1};
			allbesteatingmoveWhite(posX-2, posY-2, depth+1);
		}
		if (allBestEatingMoveWhiteDeepL(posX+1, posY-1)) {
			temporary[depth] = new int[] {posX+1, posY-1};
			allbesteatingmoveWhite(posX+2, posY-2, depth+1);
		}
		if(maxdepth < depth) {
			tRA = new int[8][][];
			tRAinc =0;
			tRA[tRAinc] = new int[][]{{posX, posY}};
			for (int i = 0; i < depth; i++) {
				tRA[tRAinc] = new int[][]{temporary[i]};
				tRAinc++;
			}
			
			maxdepth = depth;
		}else if(maxdepth > 0 && maxdepth == depth) {
			tRA[tRAinc] = new int[][]{{posX, posY}};
			for (int i = 0; i < depth; i++) {
				tRA[tRAinc] = new int[][]{temporary[i]};
				tRAinc++;
			}
			
			maxdepth = depth;
		}
		//temporary = new int[4][2]; 
		toRetur[depth][depthesW[depth]] = new int[]{posX, posY};
		
		depthesW[depth]++;
	}

	public boolean allBestEatingMoveWhiteDeepL(int posX, int posY){
		if (posX <= 7 && posX+1 <= 7 && posY-1 <= 7 && posY <= 7 && posX >= 0 && posX-1 >= 0 && posY-1 >= 0 && posY >= 0 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX+1][posY-1] == "  -  ") {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveWhiteDeepR(int posX, int posY){
		if(posX >= 0 && posX-1 >= 0 && posY-1 >= 0 && posY >= 0 && posX <= 7 && posX+1 <= 7 && posY-1 <= 7 && posY <= 7 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX-1][posY-1] == "  -  ") {
			return true;
		}
		return false;
	}
	
	/*
	 FONCTION DES NOIRS
	 */
	
	public void mouvPionNoir(int x, int y) {
		
			for(Pion p : plus.allPion) {
				if(p.getX() == x && p.getY() == y) {
					
					if(p.getPion() == "  N  " || p.getPion() == "  n  ") {
						mouvOneCase(p);
						System.out.println("passe1");
						
						System.out.println("passe2");
						break;
					} else {
						Utilitaires.BadPionBlack();
						b.fillTab(b.tableauDeDame, plus.allPion);
						direction();
					} 
				} 
				
			}
			
			System.out.println("passe4");
			
			System.out.println("\nFin de Tour ou pas de pion \n");
			cm.whoseTurn(v.tour);
			direction();
	}
	
	public void mouvDiagNoir(Pion p) {
		System.out.println("Passe 6");
		verifEatBack();
		System.out.println("Passe 7");
		int verifEatInt = verifEatBlack(p);
		System.out.println("Passe 8");
		System.out.println(verifEatInt);
		if (verifEatInt == 1){
			System.out.println("Passe 9");
			if((p.getX() + 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne 
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
			|| (p.getX() - 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {	
					plus.moveOfPawn(p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					v.tour = v.tour + 1;
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);
			} else {
				Utilitaires.BadMove();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			}
		} else if (verifEatInt == 2) {
					b.fillTab(b.tableauDeDame, plus.allPion);
		}		
	}
	
	public void eatBlackPawn(Pion p, int oldX, int oldY, int newX, int newY) {
		for(Pion pion : plus.allPion) {
            if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()-1 )) {
            	plus.eatAPawn(oldX, oldY, newX, newY, p.getX()+1, p.getY()-1);
                plus.allPion.remove(pion);
                plus.deadPawnBlack.add(pion);
                plus.PrintBlackDeadArray(pion);
                break;
            } else if ((pion.getX() == p.getX()-1) && (pion.getY() == p.getY()-1 )){
            	plus.eatAPawn(oldX, oldY, newX, newY, p.getX()-1, p.getY()-1);
                plus.allPion.remove(pion);
                plus.deadPawnBlack.add(pion);
                plus.PrintBlackDeadArray(pion);
                break;
            }
        }
	}

		public int verifEatBlack(Pion pion) {
		int verifposs = 0;
		
        for (int i  = 12; i < 24; i++) {
            if (Objects.isNull(eatMapping[i][0])) {
                verifposs++;
            }
        }
        
        if (verifposs == 12) {
            return 1;
        }
		for (int i  = 12; i < 24; i++) {
			if (Objects.nonNull(eatMapping[i][0])) {
				if(eatMapping[i][0][0] == pion.getX() && eatMapping[i][0][1] == pion.getY()) {
					for (int v = 0; v < eatMapping[i-12][0].length; v++) {
						if(eatMapping[i-12][v][0] == PNM[0] && eatMapping[i-12][v][1] == PNM[1]) {
							for (int[] coo : eatAr[i-12][v]) {
								if(coo[0] == 0 && coo[1] == 0 || coo[0] == eatMapping[i-12][v][0] && coo[1] == eatMapping[i-12][v][1]) {
									
								}else{
					                removePion(coo[0], coo[1]);
								}
							}
							changeToNewPosition(pion, PNM[0], PNM[1]);
							eatMapping = new int[24][8][];
							return 3;
						}
					}
				}else {
					System.out.println("Mouvement possible !");
					for (int v = 0; v < 8; v++) {
						if (Objects.nonNull(eatMapping[i-12][v])) {
							System.out.println("Tu peux manger avec le pion (" +eatMapping[i][0][0]+ "," + eatMapping[i][0][1] + ") " + "en (" + eatMapping[i-12][v][0] + ","  + eatMapping[i-12][v][1] + ")");
							System.out.println("Ce.s pion.s sera.ont mangé.s : ");
							for (int[] coo : eatAr[i-12][v]) {
								if(coo[0] == 0 && coo[1] == 0 || coo[0] == eatMapping[i-12][v][0] && coo[1] == eatMapping[i-12][v][1]) {
									
								} else{
									System.out.println("(" + coo[0] + "," + coo[1] + ")\n");
								}
							}
						}
					}
				}
			}
		}
		eatMappingW = new int[24][8][];
		return 3;
	}
	
	public void verifEatBack() {
		
		int vardinc = 0;
		for(Pion p : plus.allPion) {
			
			if(p.getPion() == "  n  ") {
				
				depthes = new int[] {0,0,0,0};
				maxdepth = 0;
				
				allbesteatingmoveBlack(p.getX(), p.getY(), 0);
				
				for(int i = 3; i > 0; i--) {
					
					if (depthes[i] > 0) {
						
						for (int v = 0; v < 8; v++) {
						
							if (Objects.nonNull(toRetur[i][v])) {
								
								eatMapping[vardinc][v] = toRetur[i][v];
							}
						}
						eatAr[vardinc] = tRA;
						eatMapping[vardinc+12][0] = new int[]{p.getX(), p.getY()};
						break;
					}
				} 
				toRetur = new int[4][8][];
				tRA = new int[4][4][];
				vardinc++; 
				
			}
		}
		System.out.println("Fin");
	}
	
	
	public void allbesteatingmoveBlack(int posX, int posY, int depth){
		if (allBestEatingMoveBlackDeepR(posX+1, posY+1)) {
			temporary[depth] = new int[] {posX+1, posY+1};
			allbesteatingmoveBlack(posX+2, posY+2, depth+1);
		}
		if (allBestEatingMoveBlackDeepL(posX-1, posY+1)) {
			temporary[depth] = new int[] {posX-1, posY+1};
			allbesteatingmoveBlack(posX-2, posY+2, depth+1);
		}
		if(maxdepth < depth) {
			tRA = new int[8][][];
			tRAinc =0;
			tRA[tRAinc] = new int[][]{{posX, posY}};
			for (int i = 0; i < depth; i++) {
				tRA[tRAinc] = new int[][]{temporary[i]};
				tRAinc++;
			}
			
			maxdepth = depth;
		}else if(maxdepth > 0 && maxdepth == depth) {
			tRA[tRAinc] = new int[][]{{posX, posY}};
			for (int i = 0; i < depth; i++) {
				tRA[tRAinc] = new int[][]{temporary[i]};
				tRAinc++;
			}
			
			maxdepth = depth;
		}
		//temporary = new int[4][2]; 
		toRetur[depth][depthes[depth]] = new int[]{posX, posY};
		
		depthes[depth]++;
	}
	

	public boolean allBestEatingMoveBlackDeepL(int posX, int posY){
		if (posX <7 && posX+1 < 7 && posY+1 < 7 && posY <7 && posX > 0 && posX-1 > 0 && posY+1 > 0 && posY > 0 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX+1][posY+1] == "  -  ") {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveBlackDeepR(int posX, int posY){
		if(posX <7 && posX+1 < 7 && posY+1 < 7 && posY <7 && posX > 0 && posX-1 > 0 && posY+1 > 0 && posY > 0 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX-1][posY+1] == "  -  ") {
			return true;
		}
		return false;
	}
	

	
}