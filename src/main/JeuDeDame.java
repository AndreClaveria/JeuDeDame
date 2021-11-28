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
	int[][][] toRetur = new int[4][8][];
	int[] depthes = new int[4];
	int[] depthesW = new int[4];
	
	public void JeuDeGame() {
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
					
					mouvDiagNoir(p);
					
				} 
			} catch (Exception e) {
				Utilitaires.BadInput();
				v.mouv.next();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			}
		} catch (Exception e) {
			Utilitaires.BadInput();
			v.mouv.next();
			b.fillTab(b.tableauDeDame, plus.allPion);
			direction();
		}		
	}
	
	public void pawnBecomeBeg() {
		for(Pion p : plus.allPion) {
			if((p.getPion() == "  w  ") && (p.getY() == 0)) {
				p.setPion("  W  ");
				plus.PawnBecomeQueen(p.getX(), p.getY());
			} else if ((p.getPion() == "  n  ") && (p.getY() == 7)){
				p.setPion("  N  ");
				plus.PawnBecomeQueen(p.getX(), p.getY());
			}
		}
		
	}
	
	/*
	 FONCTION DES BLANCS
	 */
	
	public void mouvPionBlanc(int x, int y) {
		do {
			for(Pion p : plus.allPion) {
				if(p.getX() == x && p.getY() == y) {
					v.a = true;
					if(p.getPion() == "  W  " || p.getPion() == "  w  ") {
						mouvOneCase(p);
						v.a = false;
						
					} else {
						Utilitaires.BadPionBlanc();
						b.fillTab(b.tableauDeDame, plus.allPion);
						direction();
					} 
				}
			}
			
		} while(v.a == true);
		System.out.println();
		System.out.println("Fin de Tour ou pas de pion");
		System.out.println();
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
					plus.MoveOfPawn(p.getX(), p.getY(), v.directionLigne, v.directionColonne);
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
			if((p.getX() + 2) == v.directionLigne && (p.getY() - 2) == v.directionColonne
			&& (b.tableauDeDame[p.getX() + 1][p.getY() - 1] == "  n  ")
			|| ((p.getX() - 2) == v.directionLigne && (p.getY() - 2) == v.directionColonne)
			&& b.tableauDeDame[p.getX() - 1][p.getY() - 1] == "  n  ") {
				if (b.tableauDeDame[p.getX() + 1][p.getY() - 1] == "  n  "
				&& b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ") {	
						v.tour = v.tour + 1;
						eatBlackPawn(p, p.getX(), p.getY(), v.directionLigne, v.directionColonne);
						b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
						p.setX(v.directionLigne);
						p.setY(v.directionColonne);
						b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
						pawnBecomeBeg();
						b.fillTab(b.tableauDeDame, plus.allPion);
						cm.whoseTurn(v.tour);
						direction();
				} else if (b.tableauDeDame[p.getX() - 1][p.getY() - 1] == "  n  "
					&& b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  "){
						v.tour = v.tour + 1;
						eatBlackPawn(p, p.getX(), p.getY(), v.directionLigne, v.directionColonne);				
						b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
						p.setX(v.directionLigne);
						p.setY(v.directionColonne);
						b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
						pawnBecomeBeg();
						b.fillTab(b.tableauDeDame, plus.allPion);			
						cm.whoseTurn(v.tour);
						direction();
				} else {
					Utilitaires.BadMove();
					b.fillTab(b.tableauDeDame, plus.allPion);
				}
			}
		}
	}
	
	public void eatWhitePawn(Pion p, int oldX, int oldY, int newX, int newY) {
		for(Pion pion : plus.allPion) {
            if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()+1 )) {
                plus.writeInFile(oldX, oldY, newX, newY, p.getX()+1, p.getY()+1);
                plus.allPion.remove(pion);
                plus.deadPawnWhite.add(pion);
                plus.PrintWhiteDeadArray(pion);
                break;
            } else if ((pion.getX() == p.getX()-1) && (pion.getY() == p.getY()+1 )) {
            	 plus.writeInFile(oldX, oldY, newX, newY, p.getX()-1, p.getY()+1);
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
							eatMappingW = new int[24][8][];
							return 2;
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
				allbesteatingmoveWhite(p.getX(), p.getY(), 0);
				for(int i = 3; i > 0; i--) {
					if (depthesW[i] > 0) {
						for (int v = 0; v < 8; v++) {
							if (Objects.nonNull(toRetur[i][v])) {
								eatMappingW[vardinc][v] = toRetur[i][v];
							}
						}
						eatMappingW[vardinc+12][0] = new int[]{p.getX(), p.getY()};
						break;
					}
				} 
				toRetur = new int[4][8][];
				vardinc++; 
			}
		}
	}
	
	public void allbesteatingmoveWhite(int posX, int posY, int depth){
		if (allBestEatingMoveWhiteDeepR(posX-1, posY-1)) {
				allbesteatingmoveWhite(posX-2, posY-2, depth+1);
		}
		if (allBestEatingMoveWhiteDeepL(posX+1, posY-1)) {
			allbesteatingmoveWhite(posX+2, posY-2, depth+1);
		}
		toRetur[depth][depthesW[depth]] = new int[]{posX, posY};
		
		depthesW[depth]++;
		
	}

	public boolean allBestEatingMoveWhiteDeepL(int posX, int posY){
		if (posX <7 && posX+1 < 7 && posY-1 < 7 && posY <7 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX+1][posY-1] == "  -  ") {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveWhiteDeepR(int posX, int posY){
		if(posX > 0 && posX-1 > 0 && posY-1 > 0 && posY > 0 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX-1][posY-1] == "  -  ") {
			return true;
		}
		return false;
	}
	
	/*
	 FONCTION DES NOIRS
	 */
	
	public void mouvPionNoir(int x, int y) {
		do {
			for(Pion p : plus.allPion) {
				if(p.getX() == x && p.getY() == y) {
					v.a = true;
					if(p.getPion() == "  N  " || p.getPion() == "  n  ") {
						mouvOneCase(p);
						v.a = false;
					} else {
						Utilitaires.BadPionBlack();
						b.fillTab(b.tableauDeDame, plus.allPion);
						direction();
					} 
				} 
				
			}
			
		} while(v.a == true);
		System.out.println();
		System.out.println("Fin de Tour ou pas de pion");
		System.out.println();
		cm.whoseTurn(v.tour);
		direction();
	}
	
	public void mouvDiagNoir(Pion p) {
		verifEatBack();
		int verifEatInt = verifEatBlack(p);
		if (verifEatInt == 1){
			if((p.getX() + 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne 
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
			|| (p.getX() - 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {	
					plus.MoveOfPawn(p.getX(), p.getY(), v.directionLigne, v.directionColonne);
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
			if((p.getX() + 2) == v.directionLigne && (p.getY() + 2) == v.directionColonne
			&& (b.tableauDeDame[p.getX() + 1][p.getY() + 1] == "  w  ")
			|| ((p.getX() - 2) == v.directionLigne && (p.getY() + 2) == v.directionColonne)
			&& b.tableauDeDame[p.getX() - 1][p.getY() + 1] == "  w  ") {
				if (b.tableauDeDame[p.getX() + 1][p.getY() + 1] == "  w  "
				&& b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ") {
						
					v.tour = v.tour + 1;
					eatWhitePawn(p, p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
						
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);
					cm.whoseTurn(v.tour);
					direction();
				} else if (b.tableauDeDame[p.getX() - 1][p.getY() + 1] == "  w  "
				&& b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  "){
						
					v.tour = v.tour + 1;
					eatWhitePawn(p, p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);
					cm.whoseTurn(v.tour);
					direction();
				} else {
					Utilitaires.BadMove();
					b.fillTab(b.tableauDeDame, plus.allPion);
				}		
			} 
		}
	}
	
	public void eatBlackPawn(Pion p, int oldX, int oldY, int newX, int newY) {
		for(Pion pion : plus.allPion) {
            if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()-1 )) {
            	plus.writeInFile(oldX, oldY, newX, newY, p.getX()+1, p.getY()-1);
                plus.allPion.remove(pion);
                plus.deadPawnBlack.add(pion);
                plus.PrintBlackDeadArray(pion);
                break;
            } else if ((pion.getX() == p.getX()-1) && (pion.getY() == p.getY()-1 )){
            	plus.writeInFile(oldX, oldY, newX, newY, p.getX()-1, p.getY()-1);
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
							eatMapping = new int[24][8][];
							return 2;
						}
					}
				}else {
					for (int v = 0; v < 8; v++) {
						if (Objects.nonNull(eatMapping[i-12][v])) {
							System.out.println("Tu peux manger avec le pion "+ eatMapping[i][0][0] + " " + eatMapping[i][0][1] + " en (" + eatMapping[i-12][v][0] + "," + eatMapping[i-12][v][1] + ")");
						}
					}
				}
			}
		}
		
		eatMapping = new int[24][8][];
		return 3;
	}
	
	public void verifEatBack() {
		int vardinc = 0;
		for(Pion p : plus.allPion) {
			if(p.getPion() == "  n  ") {
				depthes = new int[] {0,0,0,0};
				allbesteatingmoveBlack(p.getX(), p.getY(), 0);
				for(int i = 3; i > 0; i--) {
					if (depthes[i] > 0) {
						for (int v = 0; v < 8; v++) {
							if (Objects.nonNull(toRetur[i][v])) {
								eatMapping[vardinc][v] = toRetur[i][v];
							}
						}
						eatMapping[vardinc+12][0] = new int[]{p.getX(), p.getY()};
						break;
					}
				} 
				toRetur = new int[4][8][];
				vardinc++; 
			}
		}
	}
	
	public void allbesteatingmoveBlack(int posX, int posY, int depth){
		if (allBestEatingMoveBlackDeepL(posX+1, posY+1)) {
				allbesteatingmoveBlack(posX+2, posY+2, depth+1);
		}
		if (allBestEatingMoveBlackDeepR(posX-1, posY+1)) {
				allbesteatingmoveBlack(posX-2, posY+2, depth+1);
		}
		toRetur[depth][depthes[depth]] = new int[]{posX, posY};
		depthes[depth]++;
	}

	public boolean allBestEatingMoveBlackDeepL(int posX, int posY){
		if (posX <7 && posX+1 < 7 && posY+1 < 7 && posY <7 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX+1][posY+1] == "  -  ") {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveBlackDeepR(int posX, int posY){
		if(posX > 0 && posX-1 > 0 && posY+1 > 0 && posY > 0 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX-1][posY+1] == "  -  ") {
			return true;
		}
		return false;
	}
	

	
}