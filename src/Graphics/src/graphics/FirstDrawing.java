package graphics;
import java.awt.Color;
import java.awt.Polygon;
import hsa2.GraphicsConsole;
/* 
 * FirstDrawing.java
 * by Isaac
 * October 31, 2022
 * Program to demonstrate how to use HSA2 for drawing.
 */

public class FirstDrawing {
	
	GraphicsConsole gc = new GraphicsConsole(800, 600);

	public static void main(String[] args) {
		new FirstDrawing();
	}
	
	FirstDrawing() {
		gc.setBackgroundColor(Color.white);
		gc.clear();
		
		gc.setColor(Color.YELLOW);
		gc.fillOval(400, 50, 150, 270);
		gc.setColor(Color.BLACK);
		gc.fillOval(500, 100, 90, 60);
		gc.setColor(Color.BLACK);
		gc.fillOval(390, 100, 30, 200);
		
		gc.setColor(Color.BLACK);
		gc.drawString("Hello Hello", 100, 150);
		
		Polygon triangle = new Polygon();
		triangle.addPoint(10, 10);
		triangle.addPoint(100, 100);
		triangle.addPoint(100, 400);
		gc.setColor(Color.black);
		gc.setStroke(4);
		gc.drawPolygon(triangle);

	}
}
