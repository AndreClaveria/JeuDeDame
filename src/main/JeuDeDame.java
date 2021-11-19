package main;

import model.Pion;
import utils.CreatePerso;
import utils.Utilitaires;

public class JeuDeDame {
	
	Board b = new Board();
	AddPion plus = new AddPion();
	Variables v = new Variables();
	CanMove cm = new CanMove();
	
	

	public void JeuDeGame() {
		plus.addPion();
		do {
			cm.whoseTurn(v.tour);
			b.fillTab(b.tableauDeDame, plus.allPion);
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
				System.out.println("Mauvais Input");
				v.mouv.next();
				direction();
			}
		} catch(Exception e) {
			System.out.println("Mauvais Input");
			v.mouv.next();
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
					System.out.println("ok");
				} else {
					mouvDiagNoir(p);
					System.out.println("ok");
				} 
			} catch (Exception e) {
				System.out.println("Mauvais Input");
				v.mouv.next();
				direction();
			}
		} catch (Exception e) {
			System.out.println("Mauvais Input");
			v.mouv.next();
			direction();
		}		
	}
	
	public void mouvDiagBlanc(Pion p) {
		if((p.getX() + 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
			|| (p.getX() - 1) == v.directionLigne && (p.getY() - 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {
				v.tour = v.tour + 1;
				b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
				p.setX(v.directionLigne);
				p.setY(v.directionColonne);
				b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
				b.fillTab(b.tableauDeDame, plus.allPion);	
		} else if((p.getX() + 2) == v.directionLigne && (p.getY() - 2) == v.directionColonne
				&& (b.tableauDeDame[p.getX() + 1][p.getY() - 1] == "  n  ")
				|| ((p.getX() - 2) == v.directionLigne && (p.getY() - 2) == v.directionColonne)
				&& b.tableauDeDame[p.getX() - 1][p.getY() - 1] == "  n  ") {
			if (b.tableauDeDame[p.getX() + 1][p.getY() - 1] == "  n  ") {
				v.tour = v.tour + 1;
				for(Pion pion : plus.allPion) {
                    if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()-1 )) {
                        System.out.println("ok");
                        plus.allPion.remove(pion);
                        plus.deadPawnBlack.add(pion);
                        plus.PrintBlackDeadArray(pion);
                        break;
                    }
                }
				b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
				p.setX(v.directionLigne);
				p.setY(v.directionColonne);
				b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
				b.fillTab(b.tableauDeDame, plus.allPion);
				cm.whoseTurn(v.tour);
				direction();
			} else if (b.tableauDeDame[p.getX() - 1][p.getY() - 1] == "  n  "){
					v.tour = v.tour + 1;
					for(Pion pion : plus.allPion) {
	                    if((pion.getX() == p.getX() - 1) && (pion.getY() == p.getY()-1 )) {
	                    	
	                        plus.allPion.remove(pion);
	                        plus.deadPawnBlack.add(pion);
	                        plus.PrintBlackDeadArray(pion);
	                        break;
	                    }
	                }
					
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					b.fillTab(b.tableauDeDame, plus.allPion);
					cm.whoseTurn(v.tour);
					direction();
			}
		} else {
				System.out.println("Mauvais déplacement");
				direction();
			}
	}
	
	public void mouvDiagNoir(Pion p) {
		if((p.getX() + 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne 
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")
			|| (p.getX() - 1) == v.directionLigne && (p.getY() + 1) == v.directionColonne
			&& (b.tableauDeDame[v.directionLigne][v.directionColonne] == "  -  ")) {	
				v.tour = v.tour + 1;
				b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
				p.setX(v.directionLigne);
				p.setY(v.directionColonne);
				b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
				b.fillTab(b.tableauDeDame, plus.allPion);
		} 
		else if((p.getX() + 2) == v.directionLigne && (p.getY() + 2) == v.directionColonne
				&& (b.tableauDeDame[p.getX() + 1][p.getY() + 1] == "  w  ")
				|| ((p.getX() - 2) == v.directionLigne && (p.getY() + 2) == v.directionColonne)
				&& b.tableauDeDame[p.getX() - 1][p.getY() + 1] == "  w  ") {
				if (b.tableauDeDame[p.getX() + 1][p.getY() + 1] == "  w  ") {
					v.tour = v.tour + 1;
					for(Pion pion : plus.allPion) {	
	                    if((pion.getX() == p.getX()+1) && (pion.getY() == p.getY()+1 )) {            
	                        plus.allPion.remove(pion);
	                        plus.deadPawnWhite.add(pion);
	                        plus.PrintWhiteDeadArray(pion);
	                        break;
	                    }

	                }
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					b.fillTab(b.tableauDeDame, plus.allPion);
					cm.whoseTurn(v.tour);
					direction();
				} else if (b.tableauDeDame[p.getX() - 1][p.getY() + 1] == "  w  "){
					v.tour = v.tour + 1;
					for(Pion pion : plus.allPion) {
	                    if((pion.getX() == p.getX()-1) && (pion.getY() == p.getY()+1 )) {
	                        
	                        plus.allPion.remove(pion);
	                        plus.deadPawnWhite.add(pion);
	                        plus.PrintWhiteDeadArray(pion);
	                        break;
	                    }
	                }
					b.tableauDeDame[p.getX()][p.getY()] = "  -  ";
					p.setX(v.directionLigne);
					p.setY(v.directionColonne);
					b.tableauDeDame[p.getX()][p.getY()] = p.getPion();
					b.fillTab(b.tableauDeDame, plus.allPion);
					cm.whoseTurn(v.tour);
					direction();
				}
	
		} else {
			System.out.println("Mauvais déplacement");
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
						System.out.println("Choisir pion blanc");
						direction();
					} 
				} else {
					v.a = false;
				}
			}
			
		} while(v.a == true);
		if(v.a == false) {
			System.out.print("Pas de pion");
		}
		cm.whoseTurn(v.tour);
		direction();
	}
	
	public void mouvPionNoir(int x, int y) {
		do {
			for(Pion p : plus.allPion) {
				if(p.getX() == x && p.getY() == y) {
					v.a = true;
					if(p.getPion() == "  N  " || p.getPion() == "  n  ") {
						mouvOneCase(p);
					} else {
						System.out.println("Choisir pion noir");
						direction();
					} 
				} else {
					v.a = false;
				}
				
			}
			if(v.a == false) {
				System.out.print("Pas de pion");
			}
			
		} while(v.a == true);
		
		cm.whoseTurn(v.tour);
		direction();
	}	
}