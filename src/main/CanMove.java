package main;

import model.Pion;
import utils.Utilitaires;

public class CanMove {

	Variables v = new Variables();
	
	public void whoseTurn(int tour) {
		if(tour%2 == 0) {
			Utilitaires.Whiteturn();
		} else {
			Utilitaires.BlackTurn();
		}
	}
	

}
