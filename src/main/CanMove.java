package main;

import utils.Utilitaires;

public class CanMove {

	Variables v = new Variables();
	
	public void whoseTurn(int tour) {
		if(tour%2 == 0) {
			Utilitaires.whiteTurn();
		} else {
			Utilitaires.blackTurn();
		}
	}
	
	
	

}
