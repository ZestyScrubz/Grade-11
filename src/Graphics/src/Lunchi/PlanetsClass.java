package Lunchi;

import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Font;

public class PlanetsClass {

    GraphicsConsole gc = new GraphicsConsole(1500, 850, "Solar System"); // Adjust the frame size and title it

    static double orbitX = 750; /* x-coordinate in orbit's center */
    static double orbitY = 425; /* y-coordinate in orbit's center */
    static double orbitRadius = 50;
    static double orbitSpeed = Math.PI / 16;
    static double sphereRadius = 10;

    /**
     * Mercury ==================================================
     */
    void Mercury() {
        gc.setColor(Color.GRAY);
        gc.fillOval(800, 320, 40, 40);

        // Smaller circle of Mercury
        Color lightGray = new Color(192, 192, 192);
        gc.setColor(lightGray);
        gc.fillOval(805, 325, 19, 19);

        // Strings the word MERCURY
        gc.drawString("MERCURY", 790, 315);
    }

    /**
     * Venus ====================================================
     */
    void Venus() {
        Color venusColor = new Color(193, 143, 23);
        gc.setColor(venusColor);
        gc.fillOval(530, 350, 55, 55);

        // Smaller circle of Venus
        Color yellowish = new Color(227, 158, 28);
        gc.setColor(yellowish);
        gc.fillOval(545, 355, 35, 35);

        // Strings the word VENUS
        gc.drawString("VENUS", 536, 420);
    }

    /**
     * Earth =====================================================
     */
    void Earth() {
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
    }

    /**
     * Mars =======================================================
     */
    void Mars() {
        Color marsColor = new Color(193, 68, 14);
        gc.setColor(marsColor);
        gc.fillOval(400, 440, 60, 60);

        // Strings the word MARS
        gc.drawString("MARS", 413, 512);

        // Black lines on Mars
        gc.setColor(Color.BLACK);
        gc.drawLine(380, 455, 460, 480);
        gc.drawLine(380, 455, 460, 475);
    }

    /**
     * Jupiter =====================================================
     */
    void Jupiter() {
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
    }

    /**
     * Saturn =======================================================
     */
    void Saturn() {
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
    }

    /**
     * Uranus ========================================================
     */
    void Uranus() {
        Color uranusColor = new Color(209, 231, 231);
        gc.setColor(uranusColor);
        gc.fillOval(1280, 350, 80, 80);

        // Strings the word URANUS
        gc.drawString("URANUS", 1295, 445);
    }

    /**
     * Neptune ========================================================
     */
    void Neptune() {
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

        /**
         * Creates a little astronaunt with a sign ==================
         */
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
    }
}
