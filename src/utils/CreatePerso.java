package utils;

import model.Pion;

public class CreatePerso {

	
	//TABLEAU NORMAL
	public static Pion p1 = new Pion(0, 7, "p1", "  w  ", false); //0 7
	public static Pion p2 = new Pion(2, 7, "p2", "  w  ", false);
	public static Pion p3 = new Pion(4, 7, "p3","  w  ", false);
	public static Pion p4 = new Pion(6, 7, "p4","  w  ", false);
	public static Pion p5 = new Pion(1, 6, "p5","  w  ", false);
	public static Pion p6 = new Pion(3, 6, "p6","  w  ", false);
	public static Pion p7 = new Pion(5, 6, "p7","  w  ", false);
	public static Pion p8 = new Pion(7, 6, "p8","  w  ", false);
	public static Pion p9 = new Pion(0, 5, "p9","  w  ", false);
	public static Pion p10 = new Pion(2, 5, "p10","  w  ", false);
	public static Pion p11 = new Pion(4, 5, "p11","  w  ", false);
	public static Pion p12 = new Pion(3, 4, "p12","  w  ", false);
	public static Pion p13 = new Pion(1, 2, "p13","  n  ", false);
	public static Pion p14 = new Pion(3, 2, "p14","  n  ", false);
	public static Pion p15 = new Pion(5, 2, "p15","  n  ", false);
	public static Pion p16 = new Pion(7, 2, "p16","  n  ", false);
	public static Pion p17 = new Pion(0, 1, "p17","  n  ", false); //0 1
	public static Pion p18 = new Pion(2, 1, "p18","  n  ", false);
	public static Pion p19 = new Pion(4, 1, "p19","  n  ", false);
	public static Pion p20 = new Pion(6, 1, "p20","  n  ", false);
	public static Pion p21 = new Pion(1, 0, "p21","  n  ", false); //1 0
	public static Pion p22 = new Pion(3, 0, "p22","  n  ", false);
	public static Pion p23 = new Pion(5, 0, "p23","  n  ", false);
	public static Pion p24 = new Pion(7, 0, "p24","  n  ", false);
	
	//Test 1(eat 5 white pawn, make with white pawn 7 6 then 6 5 and eat with black pawn
//	public static Pion p1 = new Pion(2, 1, "p1", "  w  ", false); //0 7
//	public static Pion p2 = new Pion(4, 1, "p2", "  w  ", false);
//	public static Pion p3 = new Pion(2, 3, "p3","  w  ", false);
//	public static Pion p4 = new Pion(4, 3, "p4","  w  ", false);
//	public static Pion p5 = new Pion(6, 3, "p5","  w  ", false);
//	public static Pion p6 = new Pion(2, 5, "p6","  w  ", false);
//	public static Pion p7 = new Pion(7, 6, "p7","  w  ", false);
//	public static Pion p8 = new Pion(0, 0, "p8","  w  ", false);
//	public static Pion p9 = new Pion(0, 0, "p9","  w  ", false);
//	public static Pion p10 = new Pion(0, 0, "p10","  w  ", false);
//	public static Pion p11 = new Pion(0, 0, "p11","  w  ", false);
//	public static Pion p12 = new Pion(0, 0, "p12","  w  ", false);
//	public static Pion p13 = new Pion(3, 0, "p13","  n  ", false);
//	public static Pion p14 = new Pion(0, 0, "p14","  n  ", false);
//	public static Pion p15 = new Pion(0, 0, "p15","  n  ", false);
//	public static Pion p16 = new Pion(0, 0, "p16","  n  ", false);
//	public static Pion p17 = new Pion(0, 0, "p17","  n  ", false); //0 1
//	public static Pion p18 = new Pion(0, 0, "p18","  n  ", false);
//	public static Pion p19 = new Pion(0, 0, "p19","  n  ", false);
// 	public static Pion p20 = new Pion(0, 0, "p20","  n  ", false);
// 	public static Pion p21 = new Pion(0, 0, "p21","  n  ", false); //1 0
// 	public static Pion p22 = new Pion(0, 0, "p22","  n  ", false);
// 	public static Pion p23 = new Pion(0, 0, "p23","  n  ", false);
//	public static Pion p24 = new Pion(0, 0, "p24","  n  ", false);
	
	
	//Test 2 (eat 5 black pawn)
//	  public static Pion p1 = new Pion(2, 7, "p1", "  w  ", false); //0 7
//    public static Pion p2 = new Pion(0, 0, "p2", "  w  ", false);
//    public static Pion p3 = new Pion(0, 0, "p3","  w  ", false);
//    public static Pion p4 = new Pion(6, 7, "p4","  w  ", false);
//    public static Pion p5 = new Pion(0, 0, "p5","  w  ", false);
//    public static Pion p6 = new Pion(0, 0, "p6","  w  ", false);
//    public static Pion p7 = new Pion(0, 0, "p7","  w  ", false);
//    public static Pion p8 = new Pion(0, 0, "p8","  w  ", false);
//    public static Pion p9 = new Pion(0, 0, "p9","  w  ", false);
//    public static Pion p10 = new Pion(0, 0, "p10","  w  ", false);
//    public static Pion p11 = new Pion(0, 0, "p11","  w  ", false);
//    public static Pion p12 = new Pion(0, 0, "p12","  w  ", false);
//    public static Pion p13 = new Pion(1, 6, "p13","  n  ", false);
//    public static Pion p14 = new Pion(1, 4, "p14","  n  ", false);
//    public static Pion p15 = new Pion(3, 4, "p15","  n  ", false);
//    public static Pion p16 = new Pion(5, 4, "p16","  n  ", false);
//    public static Pion p17 = new Pion(5, 2, "p17","  n  ", false); //0 1
//    public static Pion p18 = new Pion(1, 2, "p18","  n  ", false);
//    public static Pion p19 = new Pion(3, 6, "p19","  n  ", false);
//    public static Pion p20 = new Pion(0, 0, "p20","  n  ", false);
//    public static Pion p21 = new Pion(0, 0, "p21","  n  ", false); //1 0
//    public static Pion p22 = new Pion(0, 0, "p22","  n  ", false);
//    public static Pion p23 = new Pion(0, 0, "p23","  n  ", false);
//    public static Pion p24 = new Pion(0, 0, "p24","  n  ", false);
	

//Test 3(you can choose between 3 different eat way)	
//	public static Pion p1 = new Pion(0, 7, "p1", "  w  ", false); //0 7
//	public static Pion p2 = new Pion(2, 7, "p2", "  w  ", false);
//	public static Pion p3 = new Pion(4, 7, "p3","  w  ", false);
//	public static Pion p4 = new Pion(6, 7, "p4","  w  ", false);
//	public static Pion p5 = new Pion(1, 6, "p5","  w  ", false);
//	public static Pion p6 = new Pion(3, 6, "p6","  w  ", false);
//	public static Pion p7 = new Pion(5, 6, "p7","  w  ", false);
//	public static Pion p8 = new Pion(7, 6, "p8","  w  ", false);
//	public static Pion p9 = new Pion(1, 4, "p9","  w  ", false);
//	public static Pion p10 = new Pion(2, 5, "p10","  w  ", false);
//	public static Pion p11 = new Pion(3, 4, "p11","  w  ", false);
//	public static Pion p12 = new Pion(6, 5, "p12","  w  ", false);
//	public static Pion p13 = new Pion(1, 2, "p13","  n  ", false);
//	public static Pion p14 = new Pion(2, 3, "p14","  n  ", false);
//	public static Pion p15 = new Pion(6, 3, "p15","  n  ", false);
//	public static Pion p16 = new Pion(7, 2, "p16","  n  ", false);
//	public static Pion p17 = new Pion(0, 1, "p17","  n  ", false); //0 1
//	public static Pion p18 = new Pion(2, 1, "p18","  n  ", false);
//	public static Pion p19 = new Pion(4, 1, "p19","  n  ", false);
//	public static Pion p20 = new Pion(4, 3, "p20","  n  ", false);
//	public static Pion p21 = new Pion(1, 0, "p21","  n  ", false); //1 0
//	public static Pion p22 = new Pion(3, 0, "p22","  n  ", false);
//	public static Pion p23 = new Pion(6, 1, "p23","  n  ", false);
//	public static Pion p24 = new Pion(7, 0, "p24","  n  ", false);
//	

}
