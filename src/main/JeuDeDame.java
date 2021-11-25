package main;

import java.io.PrintWriter;

import model.Pion;

import utils.Utilitaires;

public class JeuDeDame {
	
	Board b = new Board();
	AddPion plus = new AddPion();
	Variables v = new Variables();
	CanMove cm = new CanMove();
	Menu m = new Menu();
	
	
	
	public void JeuDeGame() {
		Utilitaires.Welcome();
		plus.addPion();
		do {
			
			cm.whoseTurn(v.tour);
			b.fillTab(b.tableauDeDame, plus.allPion);
			verifEatWhite();
			verifEatBlack();
			direction();
			
		}while(true);
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
	
	public void mouvDiagBlanc(Pion p) {
		
		
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
		} else if((p.getX() + 2) == v.directionLigne && (p.getY() - 2) == v.directionColonne
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
		} else {
				Utilitaires.BadMove();
				b.fillTab(b.tableauDeDame, plus.allPion);
				direction();
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
			

	
	public void mouvDiagNoir(Pion p) {
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
		} 
		else if((p.getX() + 2) == v.directionLigne && (p.getY() + 2) == v.directionColonne
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
	
		} else {
			Utilitaires.BadMove();
			b.fillTab(b.tableauDeDame, plus.allPion);
			direction();
		}
	}

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
	
	public void mangerUnBlanc(int ligne, int colonne) {
		for(Pion p : plus.allPion) {
			if(p.getPion() == "  n  ") {
				while(p.isControlledByUser()) {
					System.out.println(p.getPion());
					System.out.println(p.getNomPion());
					System.out.println("Vous pouvez/devez manger un pion Blanc");
					direction();
				}

			}
		}
	}
	
	public void verifEatBlack() {
		for(Pion p : plus.allPion) {
			if(p.getPion()== "  n  ") {
				System.out.println(p.getNomPion());
				if(!(p.getX()-1<=0)&&!(p.getX()+1>=7)) {
					if (b.tableauDeDame[p.getX()+1][p.getY()+1] == "  w  "
							&& b.tableauDeDame[p.getX()+2][p.getY()+2] == "  -  "
							|| (b.tableauDeDame[p.getX()-1][p.getY()+1] == "  w  ")
							&& b.tableauDeDame[p.getX()-2][p.getY()+2] == "  -  "){
				           System.out.println("Tu peux manger avec le pion noir en (" + p.getX() + "," + p.getY() + ")");
				    }	
				}
			}
				
		}
		
	}
	
	public void verifEatWhite() {
		for(Pion p : plus.allPion) {

			if(p.getPion()== "  w  ") {
				if(!(p.getX()-1<=0)&&!(p.getX()+1>=7)) {
					if (b.tableauDeDame[p.getX()+1][p.getY()-1] == "  n  "
							&& b.tableauDeDame[p.getX()+2][p.getY()-2] == "  -  "
							|| (b.tableauDeDame[p.getX()-1][p.getY()-1] == "  n  ")
							&& b.tableauDeDame[p.getX()-2][p.getY()-2] == "  -  ") {
				           System.out.println("Tu peux manger avec le pion blanc en (" + p.getX() + "," + p.getY() + ")");
				    }	
				}
			}
				
		}
		
	}
	
//	if(p.getY() - 1 == 0 && p.getPion() == "  w  ") {
//		plus.MoveOfPawn(p.getX(), p.getY(), v.directionLigne, v.directionColonne);
//		v.tour = v.tour + 1;
//		b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
//		p.setX(v.directionLigne);
//		p.setY(v.directionColonne);
//		p.setPion("  W  ");
//		System.out.println(p.getPion());
//		b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
//	}
}