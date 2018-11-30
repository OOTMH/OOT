package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape{
	private Point upperLeft;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		upperLeft.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		upperLeft.moveTo(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle)
			return (int) (this.area() - ((Rectangle)o).area());
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		
	}

	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y
				&& y < upperLeft.getY() + height);
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Upper left point:(xUpperLeft,yUpperLeft), width = <width>, height = <height>
	public String toString() {
		return "Upper left point: " + upperLeft + ", width = " + width + ", height = " + height;
	}

	public int area() {
		return width * height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
