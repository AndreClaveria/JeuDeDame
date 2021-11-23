package main;

import utils.Utilitaires;

public class Menu {
	
	Variables v = new Variables();
	
	public String AskBlanc() {
		String pseudoBlanc = "";
		try {
			String choisi = v.mouv.nextLine();
			pseudoBlanc = choisi;
		} catch(Exception e) {
			v.mouv.next();
			Utilitaires.Welcome();
		}
		return pseudoBlanc;
		
	}
	
		public String AskBlack() {
			String pseudoBlack = "";
			try {
				String choisi = v.mouv.nextLine();
				pseudoBlack = choisi;
			} catch(Exception e) {
				v.mouv.next();
				Utilitaires.Welcome();
			}
			return pseudoBlack;
		}
	
}
