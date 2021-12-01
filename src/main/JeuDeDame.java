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
	int[][][][] eatAr = new int[12][24][][]; // un tableau des 12 pions et de leurs 4 possibilités
	int[][][] toRetur = new int[8][8][];
	int[][][] tRA = new int[8][9][]; // un tableau des 4 possibilités de chemins
	int tRAinc = 0;
	int[][] temporary = new int[8][2]; // un tableau des 3 valeurs max d'un chemin
	int maxdepth = 0;
	int[] before = new int[]{0,0,0,0,0,0,0,0,0};
	int[] basic = new int[2];
	int[] depthes = new int[8];
	int[] depthesW = new int[8];
	boolean whiteOrBlack = false;
	
	public void JeuDeGame() {
		plus.file.delete();
		Utilitaires.welcome();
		plus.addPion();	
		cm.whoseTurn(v.tour);
		b.fillTab(b.tableauDeDame, plus.allPion);
		direction();
	}
	
	
	public void direction() {
		
		while(!plus.gameOver()) {
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
					Utilitaires.badInput();
					v.mouv.next();
					b.fillTab(b.tableauDeDame, plus.allPion);
					direction();
				}
			} catch(Exception e) {
				Utilitaires.badInput();
				v.mouv.next();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			}
		}
		plus.winnerIs();
		System.out.close();
		
		
		
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
					whiteOrBlack = true;
					mouvDiagBlanc(p);
				} else {
					whiteOrBlack = false;
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
				plus.pawnBecomeQueen(v.tour, p.getX(), p.getY());
			} else if ((p.getPion() == "  n  ") && (p.getY() == 7)){
				p.setPion("  N  ");
				plus.pawnBecomeQueen(v.tour, p.getX(), p.getY());
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
					Utilitaires.badPionBlanc();
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
		verifWhichDepthToTake(whiteOrBlack);
		int verifEatInt = verifAllBestMove(p);
		if (verifEatInt == 1){
			if((p.getX() + 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
				&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
				|| (p.getX() - 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
				&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {
					plus.moveOfPawn(v.tour, p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					v.tour++;
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);	
			} else {
				Utilitaires.badMove();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			} 
		} else if(verifEatInt == 2) {
				v.tour++;
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
				if(pion.getPion() == "  w  ") {
					System.out.println("Le pion blanc en (" + i + "," + i2 + ") vient de disparaitre");
					plus.allPion.remove(pion);
					plus.deadPawnWhite.add(pion);
					break;
				} else {
					System.out.println("Le pion noir en (" + i + "," + i2 + ") vient de disparaitre");
					plus.allPion.remove(pion);
					plus.deadPawnBlack.add(pion);
					break;
				}
				
				
			}
		}
	}
	
	
	public void  verifWhichDepthToTake(boolean whiteOrBlack) {
		int vardinc = 0;
		for(Pion p : plus.allPion) {
			if (p.getX() == 0 && p.getY() == 0) {
				
			}else if(p.getPion() == "  w  " && whiteOrBlack == true) {
				depthesW = new int[] {0,0,0,0,0,0,0,0};
				before = new int[] {0,0,0,0,0,0,0,0};
				maxdepth = 0;
				basic = new int[] {p.getX(), p.getY()};
				allBestEatingMoveWhite(p.getX(), p.getY(), 0);
				for(int i = maxdepth; i > 0; i--) {
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
				toRetur = new int[8][8][];
				tRA = new int[8][9][]; 
				vardinc++; 
				
			} else if(p.getPion() == "  n  " && whiteOrBlack == false) {
				depthes = new int[] {0,0,0,0,0,0,0,0};
				before = new int[] {0,0,0,0,0,0,0,0};
				maxdepth = 0;
				basic = new int[] {p.getX(), p.getY()};
				allBestEatingMoveBlack(p.getX(), p.getY(), 0);
				for(int i = maxdepth; i > 0; i--) {
					if (depthes[i] > 0) {
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
				toRetur = new int[8][8][];
				tRA = new int[8][9][]; 
				vardinc++; 
			}
		}
	}
	
	public void allBestEatingMoveWhite(int posX, int posY, int depth){
        if (before[depth] != 3) {
            if (allBestEatingMoveWhiteDeepR(posX-1, posY-1)) {
            	before[depth+1] = 1;
                temporary[depth] = new int[] {posX-1, posY-1};
                allBestEatingMoveWhite(posX-2, posY-2, depth+1);
            }
        }
        if (before[depth] != 4) {
            if (allBestEatingMoveWhiteDeepL(posX+1, posY-1)) {
            	before[depth+1] = 2;
                temporary[depth] = new int[] {posX+1, posY-1};
                allBestEatingMoveWhite(posX+2, posY-2, depth+1);
            }
        }
        if (before[depth] != 1) {
            if (allBestEatingMoveWhiteDeepL2(posX+1, posY+1)) {
            	before[depth+1] = 3;
                temporary[depth] = new int[] {posX+1, posY+1};
                allBestEatingMoveWhite(posX+2, posY+2, depth+1);
            }
        }
        if (before[depth] != 2) {
            if (allBestEatingMoveWhiteDeepR2(posX-1, posY+1)) {
            	before[depth+1] = 4;
                temporary[depth] = new int[] {posX-1, posY+1};
                allBestEatingMoveWhite(posX-2, posY+2, depth+1);
            }
        }
        if(maxdepth < depth) {
            tRA = new int[8][9][];
            toRetur = new int[8][8][];
            tRAinc =0;
            tRA[tRAinc][0] = new int[]{posX, posY};
            for (int i = 0; i < depth; i++) {
                tRA[tRAinc][i+1] = temporary[i];
                
            }
            tRAinc++;
            maxdepth = depth;
        }else if(maxdepth > 0 && maxdepth == depth) {
            tRA[tRAinc][0] = new int[]{posX, posY};
            for (int i = 0; i < depth; i++) {
                tRA[tRAinc][i+1] = temporary[i];
            }
            tRAinc++;
            maxdepth = depth;
        }

        toRetur[depth][depthesW[depth]] = new int[]{posX, posY};
        
        depthesW[depth]++;
    }

    public boolean allBestEatingMoveWhiteDeepL(int posX, int posY){ //2 en haut à droite
        if (posX <= 7 && posX+1 <= 7 && posY-1 <= 7 && posY <= 7 && posX >= 0 && posX+1 >= 0 && posY-1 >= 0 && posY >= 0 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX+1][posY-1] == "  -  " && new int[] {posX+1,posY-1} != basic) {
            return true;
        }
        return false;
    }
    public boolean allBestEatingMoveWhiteDeepR(int posX, int posY){ //1 en haut à gauche
        if(posX >= 0 && posX-1 >= 0 && posY-1 >= 0 && posY >= 0 && posX <= 7 && posX-1 <= 7 && posY-1 <= 7 && posY <=7 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX-1][posY-1] == "  -  " && new int[] {posX+1,posY-1} != basic) {
            return true;
        }
        return false;
    }
    public boolean allBestEatingMoveWhiteDeepR2(int posX, int posY){ //4 en bas à gauche
        if(posX >= 0 && posX-1 >= 0 && posY+1 >= 0 && posY >= 0 && posX <= 7 && posX-1 <= 7 && posY+1 <= 7 && posY <=7 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX-1][posY+1] == "  -  " && new int[] {posX+1,posY-1} != basic) {
            
            return true;
        }
        return false;
    }
    public boolean allBestEatingMoveWhiteDeepL2(int posX, int posY){ //3 en bas à droite
        if(posX >= 0 && posX+1 >= 0 && posY+1 >= 0 && posY >= 0 && posX <= 7 && posX+1 <= 7 && posY+1 <= 7 && posY <=7 && b.tableauDeDame[posX][posY] == "  n  " && b.tableauDeDame[posX+1][posY+1] == "  -  " && new int[] {posX+1,posY-1} != basic) {
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
						break;
					} else {
						Utilitaires.badPionBlack();
						b.fillTab(b.tableauDeDame, plus.allPion);
						direction();
					} 
				} 
			}
			System.out.println("\nFin de Tour ou pas de pion \n");
			cm.whoseTurn(v.tour);
			direction();
	}
	
	public void mouvDiagNoir(Pion p) {
		verifWhichDepthToTake(whiteOrBlack);
		int verifEatInt = verifAllBestMove(p);
		if (verifEatInt == 1){
			if((p.getX() + 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne 
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
			|| (p.getX() - 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {	
					plus.moveOfPawn(v.tour, p.getX(), p.getY(), v.directionLigne, v.directionColonne);
					v.tour = v.tour + 1;
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					pawnBecomeBeg();
					b.fillTab(b.tableauDeDame, plus.allPion);
			} else {
				Utilitaires.badMove();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
			}
		} else if (verifEatInt == 2) {
			v.tour++;
		}		
	}
	
	public void allBestEatingMoveBlack(int posX, int posY, int depth){
		if (before[depth] != 3) {
            if (allBestEatingMoveBlackDeepR(posX+1, posY+1)) {
            	before[depth+1] = 1;
                temporary[depth] = new int[] {posX+1, posY+1};
                allBestEatingMoveBlack(posX+2, posY+2, depth+1);
            }
        }
        if (before[depth] != 4) {
            if (allBestEatingMoveBlackDeepL(posX-1, posY+1)) {
            	before[depth+1] = 2;
                temporary[depth] = new int[] {posX-1, posY+1};
                allBestEatingMoveBlack(posX-2, posY+2, depth+1);
            }
        }
        if (before[depth] != 1) {
            if (allBestEatingMoveBlackDeepL2(posX-1, posY-1)) {
            	before[depth+1] = 3;
                temporary[depth] = new int[] {posX-1, posY-1};
                allBestEatingMoveBlack(posX-2, posY-2, depth+1);
            }
        }
        if (before[depth] != 2) {
            if (allBestEatingMoveBlackDeepR2(posX+1, posY-1)) {
            	before[depth+1] = 4;
                temporary[depth] = new int[] {posX+1, posY-1};
                allBestEatingMoveBlack(posX+2, posY-2, depth+1);
            }
        }
        if(maxdepth < depth) {
            tRA = new int[8][9][];
            toRetur = new int[8][8][];
            tRAinc =0;
            tRA[tRAinc][0] = new int[]{posX, posY};
            for (int i = 0; i < depth; i++) {
                tRA[tRAinc][i+1] = temporary[i];
            }
            tRAinc++;
            maxdepth = depth;
        }else if(maxdepth > 0 && maxdepth == depth) {
            tRA[tRAinc][0] = new int[]{posX, posY};
            for (int i = 0; i < depth; i++) {
                tRA[tRAinc][i+1] = temporary[i];
            }
            tRAinc++;
            maxdepth = depth;
        }  
        toRetur[depth][depthes[depth]] = new int[]{posX, posY};
        depthes[depth]++;
	}

	public boolean allBestEatingMoveBlackDeepL(int posX, int posY){  // 2 en bas à gauche
		if (posX <= 7 && posX-1 <= 7 && posY+1 <= 7 && posY <= 7 && posX >= 0 && posX-1 >= 0 && posY+1 >= 0 && posY >= 0 &&  b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX-1][posY+1] == "  -  " && new int[] {posX-1,posY+1} != basic) {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveBlackDeepR(int posX, int posY){ // 1 en bas à droite
		if(posX <= 7 && posX+1 <= 7 && posY+1 <= 7 && posY <= 7 && posX >= 0 && posX-1 >= 0 && posY+1 >= 0 && posY >= 0 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX+1][posY+1] == "  -  " && new int[] {posX-1,posY+1} != basic) {
			return true;
		}
		return false;
	}
	public boolean allBestEatingMoveBlackDeepL2(int posX, int posY){ // 4 en haut à gauche
		if (posX >= 0 && posX-1 >= 0 && posY-1 >= 0 && posY >= 0 && posX <= 7 && posX-1 <= 7 && posY-1 <= 7 && posY <= 7 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX-1][posY-1] == "  -  " && new int[] {posX-1,posY+1} != basic) {
			return true;
		}
		return false;
	}

	public boolean allBestEatingMoveBlackDeepR2(int posX, int posY){ // 3 en haut à droite
		if(posX <= 7 && posX+1 <= 7 && posY-1 <= 7 && posY <= 7 && posX >= 0 && posX+1 >= 0 && posY-1 >= 0 && posY >= 0 && b.tableauDeDame[posX][posY] == "  w  " && b.tableauDeDame[posX+1][posY-1] == "  -  " && new int[] {posX-1,posY+1} != basic) {
			return true;
		}
		return false;
	}
	
	public int verifAllBestMove(Pion pion) {
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
		    		int elsecounter = 0;
					for (int v = 0; v < eatMappingW[i-12].length; v++) {
						if(Objects.nonNull(eatMappingW[i-12][v]) && eatMappingW[i-12][v][0] == PNM[0] && eatMappingW[i-12][v][1] == PNM[1]) {
							for (int[] coo : eatAr[i-12][v]) {
								if(Objects.isNull(coo)) {
								}else {
									if(coo[0] == 0 && coo[1] == 0 || coo[0] == eatMappingW[i-12][v][0] && coo[1] == eatMappingW[i-12][v][1]) {
									
									}else{
					                	removePion(coo[0], coo[1]);
					                	plus.eatAPawn(this.v.tour, eatMappingW[i][0][0], eatMappingW[i][0][1], eatMappingW[i-12][v][0], eatMappingW[i-12][v][1], coo[0], coo[1]);
									}
								} 
							}
							
							changeToNewPosition(pion, PNM[0], PNM[1]);
							
							eatMappingW = new int[24][8][];
							return 2;
						}else {
						elsecounter++;
						}
					}
					if (elsecounter == (eatMappingW[i-12].length)) {
						int[][] alreadyUsed = new int[8][];
						System.out.println("Mouvement possible !");
						for (int v = 0; v < 8; v++) {
							if (Objects.nonNull(eatMappingW[i-12][v])) {
								boolean Use = false;
								for (int[] Used : alreadyUsed) {
									if (Objects.nonNull(Used)) {
									if (Used[0] == eatMappingW[i-12][v][0] && Used[1] == eatMappingW[i-12][v][1]) {
											Use = true;
										}
									}
								}
								if (Use == false) {
									alreadyUsed[v] = new int[] {eatMappingW[i-12][v][0], eatMappingW[i-12][v][1]};
									System.out.println("Tu peux manger avec le pion ("
									+eatMappingW[i][0][0]+ "," + eatMappingW[i][0][1] + ") "
									+ "en (" + eatMappingW[i-12][v][0] + "," 
									+ eatMappingW[i-12][v][1] + ")");
									System.out.println("ces pions seront mangés : ");
									boolean second = false;
									boolean three = false;
									for (int[][] coo : eatAr[i-12]) {
										second = false;
										boolean isit = false;
										if (Objects.nonNull(coo[0])) {
											if (coo[0][0] == eatMappingW[i-12][v][0] && coo[0][1] == eatMappingW[i-12][v][1]) {
												isit = true;
												second = true;;
											}else {
												three = false;
											}
										}else {
											three = false;
										}
										if (three) {
											three = false;
											System.out.println("ou bien ceux-ci : ");
										}
										for (int f = 1; f < 9; f++) {
											if (isit) {
												if (Objects.nonNull(coo[f])) {
													System.out.print("(" + coo[f][0] + "," + coo[f][1] + ")\n");
												}
											}
										}
										if (second) {
											three = true;
										}
									}
								}
							}
						}
					}
				}else {
					int[][] alreadyUsed = new int[8][];
					System.out.println("Mouvement possible !");
					for (int v = 0; v < 8; v++) {
						if (Objects.nonNull(eatMappingW[i-12][v])) {
							boolean Use = false;
							for (int[] Used : alreadyUsed) {
								if (Objects.nonNull(Used)) {
								if (Used[0] == eatMappingW[i-12][v][0] && Used[1] == eatMappingW[i-12][v][1]) {
										Use = true;
									}
								}
							}
							if (Use == false) {
								alreadyUsed[v] = new int[] {eatMappingW[i-12][v][0], eatMappingW[i-12][v][1]};
								System.out.println("Tu peux manger avec le pion ("
								+eatMappingW[i][0][0]+ "," + eatMappingW[i][0][1] + ") "
								+ "en (" + eatMappingW[i-12][v][0] + "," 
								+ eatMappingW[i-12][v][1] + ")");
								System.out.println("ces pions seront mangés : ");
								boolean second = false;
								boolean three = false;
								for (int[][] coo : eatAr[i-12]) {
									second = false;
									boolean isit = false;
									if (Objects.nonNull(coo[0])) {
										if (coo[0][0] == eatMappingW[i-12][v][0] && coo[0][1] == eatMappingW[i-12][v][1]) {
											isit = true;
											second = true;;
										}else {
											three = false;
										}
									}else {
										three = false;
									}
									if (three) {
										three = false;
										System.out.println("ou bien ceux-ci : ");
									}
									for (int f = 1; f < 9; f++) {
										if (isit) {
											if (Objects.nonNull(coo[f])) {
												System.out.print("(" + coo[f][0] + "," + coo[f][1] + ")\n");
											}
										}
									}
									if (second) {
										three = true;
									}
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
}