package geometry;

import java.awt.Graphics;

public class Circle extends Shape {
	protected Point center;
	protected int r;

	public Circle() {

	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Circle)
			return (int) (this.area() - ((Circle)o).area());
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		center.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		center.moveTo(x, y);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Center:(xCenter,yCenter), radius = <radius>
	public String toString() {
		return "Center: " + center + ", radius = " + r;
	}

	public double area() {
		return r * r * Math.PI;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}


}
