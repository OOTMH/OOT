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
