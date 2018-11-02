package geometry;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);
		System.out.println("Xp1: "+p1.getX());
		System.out.println("Yp1: "+p1.getY());
		System.out.println("Selectedp1: "+p1.isSelected());

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

		Line l1 = new Line();
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);

		p1.setX(33);
		// postaviti x startPoint l1 na vrednost 55
		l1.getStartPoint().setX(55);

		//ispisati na konzolu x od startPoint l1
		System.out.println("X startPoint l1: "+l1.getStartPoint().getX());
		System.out.println("Xp1: "+p1.getX());

		//postaviti y endPoint l1 na vrednost x p1
		l1.getEndPoint().setY(p1.getX());

		Rectangle r1 = new Rectangle();
		// ispisati povrsinu r1
		System.out.println("P r1: "+r1.area());

		// postaviti upperLeft r1 na endPoint l1
		r1.setUpperLeft(l1.getEndPoint());

		Circle c1 = new Circle();
		c1.setCenter(p2);
		System.out.println("\n\nX center c1: "+c1.getCenter().getX()
				+"\n\tY center c1: "+c1.getCenter().getY()
				+"\nr c1: "+c1.getR()
				+"\nselected c1: "+c1.isSelected());

		// postaviti radius kruga c1 na vrednost udaljenosti tacaka
		// center c1 i l1 startPoint

		c1.setR((int) c1.getCenter().distance(l1.getStartPoint().getX(), l1.getStartPoint().getY()));
		System.out.println("R c1: "+c1.getR());

		// postaviti selected c1 na vrednost izraza koji proverava
		// da li je x centra c1 vece od y koordinate upperLeft r1
		c1.setSelected(c1.getCenter().getX() > r1.getUpperLeft().getY());
		System.out.println(c1.isSelected());

		// Postaviti y koordinatu krajnje tacke l1 na vrednost
		// razlike koordinata centra kruga c1 
		// umanjene 
		// za vrednost zbira x koordinate upperLeftPoint r1 i povrsine c1
		l1.getEndPoint().setY((int) ((c1.getCenter().getX() - c1.getCenter().getY())
				-
				(r1.getUpperLeft().getX() + c1.area())));
		System.out.println(l1.getEndPoint().getY());
	}

}
