package graphics;

import java.awt.Color;
import java.awt.Polygon;

import hsa2.GraphicsConsole;

public class graphics {
	
	GraphicsConsole gc = new GraphicsConsole(300, 300);

	public static void main(String[] args) {
		new graphics();
	}
	
	graphics() {
		Polygon diamond = new Polygon();

		gc.setBackgroundColor(Color.YELLOW);
		gc.clear();

		gc.setColor(Color.BLUE);
		gc.fillRect(280, 280, 20, 20);
		gc.setColor(Color.BLUE);
		gc.fillRect(0, 280, 20, 20);
		gc.setColor(Color.BLUE);
		gc.fillRect(280, 0, 20, 20);
		gc.setColor(Color.BLUE);
		gc.fillRect(0, 0, 20, 20);

		diamond.addPoint(150, 0);
		diamond.addPoint(300, 150);
		diamond.addPoint(150, 300);
		diamond.addPoint(0, 150);
		gc.drawPolygon(diamond);
	}
}
