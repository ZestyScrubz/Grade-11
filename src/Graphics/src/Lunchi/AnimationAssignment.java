/*
 * NathanielParkAssignment.java
 * Nathaniel park
 * May 24th 2023
 * Draws a picture of the solar system in space 
 */

package Lunchi;

import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;
import java.util.Random;

public class AnimationAssignment {

	public static void main(String[] args) {
		new AnimationAssignment();
	}

	class Man {
		int x, y, size;
		int vx = rand.nextInt(15) + 1;
		int vy = rand.nextInt(15) + 1;
	}

	Random rand = new Random();
	final int WINW = 1500, WINH = 850;
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH, "Solar System"); // Adjust the frame size and title it

	AnimationAssignment() {
		int y1, x1;
		Font diffFont = new Font("POPPINS", Font.PLAIN, 12);
		gc.setLocationRelativeTo(null); // Sets the screen/frame into the middle
		gc.setAntiAlias(true); // Enables Anti Aliasing
		gc.setBackgroundColor(Color.BLACK); // Sets the BG colour to black
		gc.clear();

		// Creates the colour for the stars in the BG
		Color aqua = new Color(48, 141, 121, 190);
		gc.setColor(aqua);

		// Generates random little stars in the BG
		for (int i = 0; i < 450; i++) {
			gc.fillStar((x1 = rand.nextInt(1499) + 1), (y1 = rand.nextInt(849) + 1), 10, 10);
		}

		// The sun in the middle of the frame ========================
		Color sunYellow = new Color(253, 184, 19);
		gc.setColor(sunYellow);
		Polygon p = new Polygon();
		for (int i = 0; i < 12; i++)
			p.addPoint((int) (750 + 50 * Math.cos(i * 2 * Math.PI / 12)),
					(int) (400 + 50 * Math.sin(i * 2 * Math.PI / 12)));

		gc.fillPolygon(p);

		// ADDITIONAL DETAILS TO THE SUN:
		// Orange oval in the sun
		Color sunOrange = new Color(252, 150, 1);
		gc.setColor(sunOrange);
		gc.fillOval(710, 360, 80, 80);

		// Smaller red oval in the sun
		Color sunRed = new Color(209, 64, 9);
		gc.setColor(sunRed);
		gc.fillOval(720, 370, 60, 60);

		// Little small lighter yellow ovals in the sun
		Color sunYellow2 = new Color(255, 228, 132);
		gc.setColor(sunYellow2);
		for (int i = 0; i < 12; i++) {
			gc.fillOval((x1 = rand.nextInt(75) + 705), (y1 = rand.nextInt(75) + 355), 16, 16);
		}

		// Strings the word SUN
		gc.setFont(diffFont);
		gc.drawString("SUN", 737, 460);

		// Creates 8 white ovals for each planet ====================
		gc.setColor(Color.WHITE);
		for (int i = 0; i < 8; i++) {
			x1 = i * 150;
			y1 = i * 80;
			gc.drawOval(100 + (x1 / 2), 50 + (y1 / 2), 1300 - x1, 700 - y1); // How on Earth did I firgure it out (O_O)
		}

		// Creates shooting stars in the BG ==========================
		// Heads of the shooting stars
		Color shootingStar = new Color(105, 4, 148, 95);
		gc.setColor(shootingStar);
		gc.fillOval(385, 370, 30, 30); // Near Saturn
		gc.fillOval(750, 240, 30, 30); // Above Mercury
		gc.fillOval(1110, 300, 30, 30); // Near Jupiter

		// Light trails of the shooting star
		Color shootingLight = new Color(162, 190, 206, 95);
		gc.setColor(shootingLight);
		Polygon triangle = new Polygon();
		triangle.addPoint(200, 310);
		triangle.addPoint(390, 370);
		triangle.addPoint(385, 390);
		gc.fillPolygon(triangle); // Near Saturn

		Polygon triangle2 = new Polygon();
		triangle2.addPoint(790, 90);
		triangle2.addPoint(775, 242);
		triangle2.addPoint(755, 242);
		gc.fillPolygon(triangle2); // Above Mercury

		Polygon triangle3 = new Polygon();
		triangle3.addPoint(1300, 230);
		triangle3.addPoint(1130, 300);
		triangle3.addPoint(1140, 320);
		gc.fillPolygon(triangle3); // Near Jupiter

		// Little astronaut with a sign =============================
		// Sign
		Color sign = new Color(150, 111, 51);
		gc.setColor(sign);
		gc.fillRect(250, 680, 40, 25);
		gc.fillRoundRect(265, 690, 10, 30, 40, 40);
		gc.setColor(Color.BLACK);
		Font signFont = new Font("POPPINS", Font.PLAIN, 8);
		gc.setFont(signFont);
		gc.drawString("HELP ME!!", 250, 695);

		// Small person
		gc.setColor(Color.WHITE); // Suit colour
		gc.fillOval(290, 690, 20, 20);
		gc.fillRect(295, 705, 10, 20);
		gc.fillRect(295, 720, 3, 10);
		gc.fillRect(302, 720, 3, 10);
		gc.fillRect(285, 705, 30, 3);
		gc.setColor(Color.BLACK); // Helmet
		gc.fillRoundRect(290, 695, 20, 10, 10, 10);
		gc.setColor(Color.RED); // Suit detail
		gc.fillOval(296, 707, 3, 3);
		gc.fillOval(301, 707, 3, 3);
		gc.setColor(Color.BLUE); // suit detail
		gc.fillOval(296, 713, 3, 3);
		gc.fillOval(301, 713, 3, 3);

		// Text at the top left of the screen ========================
		// Encased title
		gc.setStroke(1);
		gc.setColor(Color.WHITE);
		gc.drawRect(0, 0, 400, 70);
		Font myFont = new Font("Times new roman", Font.BOLD, 36);
		gc.setFont(myFont);
		gc.drawString("THE SOLAR SYSTEM", 17, 50);

		// Created by Nathaniel Park
		gc.drawLine(0, 125, 230, 125);
		Font nameFont = new Font("Georgia", Font.ITALIC, 16);
		gc.setFont(nameFont);
		gc.drawString("Created by: Nathaniel Park", 15, 120);
	}

	void moveBall(Man m) {
		m.x += m.vx;
		m.y += m.vy;
		if (m.x < 0 || (m.x + m.size) > WINW) {
			m.vx *= -1;
		}
		if (m.y < 0 || (m.y + m.size) > WINH) {
			m.vy *= -1;
		}
	}
}
