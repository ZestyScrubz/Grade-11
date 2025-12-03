package Lunchi;

/*
 * NathanielParkAssignment.java
 * Nathaniel park
 * May 24th 2023
 * Draws a picture of the solar system in space 
 */

import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;
import java.util.Random;

public class NathanielParkAssignment {
	public static void main(String[] args) {
		new NathanielParkAssignment();
	}

	int earthX = 940; // Initial X position of Earth
	int earthY = 440; // Initial Y position of Earth
	double angle = 0; // Angle to control Earth's position in orbit
	double angleIncrement = 0.01; // Increment value to control Earth's speed of orbit

	GraphicsConsole gc = new GraphicsConsole(1500, 850, "Solar System"); // Adjust the frame size and title it

	NathanielParkAssignment() {
        while (true) {
            // Update the position of the Earth
            earthX = (int) (750 + 250 * Math.cos(angle));
            earthY = (int) (400 + 250 * Math.sin(angle));
            angle += angleIncrement;

            // Clear the console
            gc.clear();

            // Draw the sun
            gc.setColor(Color.YELLOW);
            gc.fillOval(700, 350, 100, 100);

            // Draw the Earth at its updated position
            gc.setColor(Color.BLUE);
            gc.fillOval(earthX, earthY, 50, 50);

            // Pause the program for a short time to control the animation speed
            gc.sleep(10);
            drawGraphics();
        }
    }

    void drawGraphics() {
        synchronized (gc) {
            gc.clear(); // Clear the screen
            drawing(); // Redraw the graphics
        }
    }
	void drawing() {
		Random rand = new Random();
		int y1, x1;
		Font diffFont = new Font("POPPINS", Font.PLAIN, 12);

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

		// Mercury ==================================================
		gc.setColor(Color.GRAY);
		gc.fillOval(800, 320, 40, 40);

		// Smaller circle of Mercury
		Color lightGray = new Color(192, 192, 192);
		gc.setColor(lightGray);
		gc.fillOval(805, 325, 19, 19);

		// Strings the word MERCURY
		gc.drawString("MERCURY", 790, 315);

		// Venus ====================================================
		Color venusColor = new Color(193, 143, 23);
		gc.setColor(venusColor);
		gc.fillOval(530, 350, 55, 55);

		// Smaller circle of Venus
		Color yellowish = new Color(227, 158, 28);
		gc.setColor(yellowish);
		gc.fillOval(545, 355, 35, 35);

		// Strings the word VENUS
		gc.drawString("VENUS", 536, 420);

		// Earth =====================================================
		gc.setColor(Color.BLUE);
		gc.fillOval(940, 440, 80, 80);

		// Smaller circles of Earth
		Color earthGreen = new Color(102, 204, 51);
		gc.setColor(earthGreen);
		gc.fillOval(947, 447, 30, 30);
		gc.fillOval(955, 450, 30, 30);
		gc.fillOval(955, 462, 30, 30);
		gc.fillOval(955, 455, 30, 30);
		gc.fillOval(985, 470, 30, 30);
		gc.fillOval(985, 475, 30, 30);
		gc.fillOval(980, 478, 30, 30);
		gc.fillOval(982, 482, 30, 30);

		// Strings the word EARTH
		gc.drawString("EARTH", 960, 535);

		// Mars =======================================================
		Color marsColor = new Color(193, 68, 14);
		gc.setColor(marsColor);
		gc.fillOval(400, 440, 60, 60);

		// Strings the word MARS
		gc.drawString("MARS", 413, 512);

		// Black lines on Mars
		gc.setColor(Color.BLACK);
		gc.drawLine(380, 455, 460, 480);
		gc.drawLine(380, 455, 460, 475);

		// Jupiter ====================================================
		Color jupiterColor = new Color(201, 144, 57);
		gc.setColor(jupiterColor);
		gc.fillOval(1100, 275, 100, 100);

		// Extra details on Jupiter
		Color jupiterColor2 = new Color(216, 202, 157);
		gc.setColor(jupiterColor2);
		gc.setStroke(30);
		gc.drawLine(1115, 310, 1187, 330);

		// Strings the word JUPITER
		gc.drawString("JUPITER", 1125, 390);

		// Saturn =====================================================
		Color saturnColor = new Color(234, 214, 184);
		gc.setColor(saturnColor);
		gc.fillOval(210, 300, 115, 115);
		Color saturnColor2 = new Color(191, 189, 175);
		gc.setStroke(5);
		gc.setColor(saturnColor2);
		gc.drawLine(214, 350, 323, 350);
		gc.drawLine(212, 365, 323, 365);

		// The ring of Saturn
		gc.drawArc(165, 335, 210, 45, 123, 297);
		Color saturnColor3 = new Color(227, 224, 192);
		gc.setColor(saturnColor3);
		gc.drawArc(170, 340, 200, 35, 125, 293);

		// Strings the word SATURN
		gc.drawString("SATURN", 242, 430);

		// Uranus =====================================================
		Color uranusColor = new Color(209, 231, 231);
		gc.setColor(uranusColor);
		gc.fillOval(1280, 350, 80, 80);

		// Strings the word URANUS
		gc.drawString("URANUS", 1295, 445);

		// Neptune ====================================================
		Color neptuneColor = new Color(63, 84, 186);
		gc.setColor(neptuneColor);
		gc.fillOval(150, 540, 80, 80);

		// Extra lines on Neptune
		Color neptuneColor2 = new Color(39, 70, 135);
		gc.setColor(neptuneColor2);
		gc.drawArc(150, 560, 80, 10, 205, 130);
		gc.drawArc(150, 570, 80, 10, 205, 130);

		// Strings the word NEPTUNE
		gc.drawString("NEPTUNE", 160, 635);

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
}
