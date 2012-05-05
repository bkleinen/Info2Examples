package pythagoras;

/*
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                   Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar
 *  14 rue de Plaisance, 75014 Paris, France
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 * 
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO. 
 */

/** 
 * Dieses Programm malt ein Pythagoras Baum.
 *
 * Ein Pythagoras-Baum ist eine besondere Art eines Fraktals. Das ursprÃ¼ngliche
 * Verfahren zum Erstellen eines Pythagoras-Baums basiert auf dem Satz des
 * Pythagoras, in dem auf ein Quadrat zwei weitere, kleinere Quadrate im rechtem
 * Winkel angeordnet werden. Durch rekursives Aufrufen dieser
 * Konstruktionsvorschrift wird ein Fraktal erzeugt, das im Grenzfall der Form
 * eines Baumes Ã¤hnelt. Durch den rechten Winkel des eingeschlossenen Dreiecks
 * bleibt die GesamtflÃ¤che jeder Ebene gleich, daher ist die Fläche des
 * Grundelementes (Stammes) genau so groÃŸ wie die Summe der Fläche aller Ã¤uÃŸeren
 * Elemente (BlÃ¤tter).
 *
 * @author Kalkin Sam <kalkin-@web.de> 2008-03-24
 * @version 0.1
 * 
 *
 * {@link} http://de.wikipedia.org/wiki/Pythagoras_Baum
 */

import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

public class PythagorasBaum extends JFrame{

    
    /**
     * Wenn du nicht weisst, was das ist, brauchst du es auch nicht zu wissen.
     * Du brauchst es eigentlich nur um eine Compiler Warnung zu deaktivieren.
     * @see java.io.Serializable
     */
    public static final long serialVersionUID = 1L;

    /**
     * Man braucht ein JPanel um in einem JFrame zu zeichnen
     */
    private JPanel panel = new JPanel(){
        /**
         * Siehe oben
         */
        public static final long serialVersionUID = 1L;

        /**
         * Diese Funktion stammt von JPanel ab und wird ueberschrieben, so dass
         * sie die maleHaus Funktion aufruft.
         */
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            maleHaus((Graphics2D) g, new Point(280, 400), new Point(380, 400));
        }

        /**
         *            Diese Funktion malt ein Quadrat mit einem Dreieck oben
         *       E    drauf. Zum besseren Verstaendnis wie die Punkte, die
         *      /\    gezeichnet werden, angeordnet sind, siehe *links*.
         *     /  \
         *   D ---- C
         *    |    |  (Das ist das Haus des Nikolaus, oder fast ;). )
         *    |    |
         *   A ---- B
         *
         */
        private void maleHaus(Graphics2D g, Point a, Point b)
        {
            // Berechnen des Abstands der Punkte A und B
            int dx = b.x - a.x;
            int dy = a.y - b.y;

            // Berechnen der Koordinaten der restlichen Punkte
            Point c = new Point(b.x-dy, b.y-dx);
            Point d = new Point(a.x-dy, a.y-dx);
            Point e = new Point( ((c.x + d.x)/2 - (dy/2)), 
                               ( (c.y + d.y)/2 - (dx/2)));

            // Unsere zwei Polygone, ein Quadrat und ein Dreieck.
            Polygon quadrat = new Polygon();
            Polygon dach = new Polygon();

            quadrat.addPoint(a.x, a.y);
            quadrat.addPoint(b.x, b.y);
            quadrat.addPoint(c.x, c.y);
            quadrat.addPoint(d.x, d.y);

            dach.addPoint(e.x, e.y);
            dach.addPoint(c.x, c.y);
            dach.addPoint(d.x, d.y);

            // Male unsere beiden Polygone
            g.drawPolygon(quadrat);
            g.drawPolygon(dach);


            // Stoppe wenn es kein Sinn mehr macht zu malen
            if ( dx*dx+dy*dy >2)
            {
                // Male die beiden ans Dreieck angrenzenden "Haeuser".
                maleHaus(g, d, e);
                maleHaus(g, e, c);
            } 
        }
        
    };

    /**
     * Wir setzen im Konstruktor direkt ein paar Einstellungen, fuegen das
     * JPanel ins JFrame ein und setzen Orange als Hintergrundfarbe ein.
     */
    public PythagorasBaum(){
        super("Pythagoras Baum");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension fensterGroesse = new Dimension(700,500);

        setLayout(new BorderLayout());
        setMinimumSize(fensterGroesse);

        panel.setPreferredSize(fensterGroesse);
        panel.setBackground(Color.ORANGE);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    /**
     * DIE MAIN, DIE!
     */
    public static void main(String args[]){
        new PythagorasBaum();

    }
}