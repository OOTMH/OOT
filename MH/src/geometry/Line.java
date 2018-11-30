package geometry;

import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line)
			return (int) (this.length() - ((Line)o).length());
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() < 2;
	}
	
	// (xStartPoint,yStartpoint)-->(xEndPoint,yEndpoint)
	@Override
	public String toString() {
		return startPoint+"-->"+endPoint;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}

	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
