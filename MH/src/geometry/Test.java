package geometry;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);
		System.out.println("Xp1: "+p1.getX());
		System.out.println("Yp1: "+p1.getY());
		System.out.println("Selectedp1: "+p1.getSelected());
		
		Point p2 = new Point();
		p2.setX(13);
		p2.setY(15);
		p2.setSelected(true);
		
		// postaviti Xp1 da bude isti kao Xp2 
		// i ispisati na konzolu
		p1.setX(p2.getX());
		System.out.println("Xp1: "+p1.getX());
		double distance = p1.distance(15, 20);
		System.out.println(distance);
	}

}
