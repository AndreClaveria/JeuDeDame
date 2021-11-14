package model;

public class Pion {
	
	int x;
	int y;
	String pion;
	boolean controlledByUser;
	
	public Pion(int x, int y, String pion, boolean controlledByUser) {
		this.x = x;
		this.y = y;
		this.pion = pion;
		this.controlledByUser = controlledByUser;
	}
	
	//TODO : Faire une condition qui permet d'enlever le pion quand il est mangé

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getPion() {
		return pion;
	}

	public void setPion(String pion) {
		this.pion = pion;
	}

	public boolean isControlledByUser() {
		return controlledByUser;
	}

	public void setControlledByUser(boolean controlledByUser) {
		this.controlledByUser = controlledByUser;
	}
	
}
