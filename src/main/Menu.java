package main;

import utils.Utilitaires;

public class Menu {
	
	Variables v = new Variables();
	
	public String askBlanc() {
		String pseudoBlanc = "";
		try {
			String choisi = v.mouv.nextLine();
			pseudoBlanc = choisi;
		} catch(Exception e) {
			v.mouv.next();
			Utilitaires.welcome();
		}
		return pseudoBlanc;
		
	}
	
		public String askBlack() {
			String pseudoBlack = "";
			try {
				String choisi = v.mouv.nextLine();
				pseudoBlack = choisi;
			} catch(Exception e) {
				v.mouv.next();
				Utilitaires.welcome();
			}
			return pseudoBlack;
		}
	
}
