/**
 * http://www.jjam.de/Java/Applets/Fraktale/Pythagoras_Baum.html
 * 2001-2004 Albert Kluge
 * Alle angebotenen Programme können zu beliebigen legalen Zwecken verwendet, kopiert, verändert oder weitergegeben werden. Ob mit privater oder kommerzieller Zielsetzung ist mir egal.

Über einen Link oder oder ein Feedback würde ich mich freuen, muss aber nicht sein.

Was ich nicht mag, aber leider schon vorgekommen ist, ist meine Programme unter fremdem Namen auf anderen Webseiten wiederzufinden, die dort als Eigenleistung präsentiert werden.

Albert, JJAM

Slightly modified by BK: 
- introduced switch to turn off tree randomization
- made it bigger
 */
package pythagoras;

import java.awt.*;
import java.applet.*;

public class Pythagoras extends Applet {

    Point a1,b1,c1,d1, a2,b2,c2,d2;

    int depth = 1; // Iterationstiefe Startwert
    boolean randomize = false;
    int size = 100;
    int position = 400;
    int offset = 600;
    
    Graphics g;
    Graphics2D g2;

    public void init() {
        setBackground(new Color(255,255,255));
    }

    public boolean mouseDown(Event ev, int x, int y) {
        if (!ev.metaDown()) depth += 1;
        else if (depth>0) depth -= 1;
        repaint();
        return true;
    }

    public void paint(Graphics g) {
        g2 = (Graphics2D) g; // Anti-Aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);

        drawTree(g2, new Point(position,0), new Point(position+size,0),
		new Point(position+size,size), new Point(position,size), depth); // Start-Quadrat
    }


    public void drawTree(Graphics2D g2, Point a, Point b, Point c, Point d, int depth) {

        // a,b,c,d sind die Punkte des jeweiligen Quadrats (gegen den Uhrzeigersinn)

        if (depth==0) return; // Astende erreicht
        depth -= 1;

        // Quadrat-Koordinaten bestimmen und zeichnen
        int xCoords[] = {a.x, b.x, c.x, d.x};
        int yCoords[] = {offset-a.y, offset-b.y, offset-c.y, offset-d.y};

        g2.setColor(new Color(150-5*depth,150-5*depth,50)); // Baumfarbe variieren
        g2.drawPolygon(xCoords, yCoords, 4);

        // Neuen Basispunkt e für a oder b des nächsten Quadrats bestimmen
        //double r1 = 0.2 + Math.random()*0.6; // Damit jeder Baum anders aussieht
        double r1 = randomize ? 0.2 + Math.random()*0.6 : 0.6;
        double r2 = Math.sqrt(0.5*0.5-(0.5-r1)*(0.5-r1)); // Satz des Pythagoras
        Point e = new Point((int)(d.x + r1*(c.x-d.x) + r2*(a.y-b.y)),
		(int)(d.y + r1*(c.y-d.y) + r2*(b.x-a.x)));

        // Neues Quadrat links
        a1 = d;
        b1 = e;
        c1 = new Point(b1.x+a1.y-b1.y, b1.y+b1.x-a1.x);
        d1 = new Point(a1.x+a1.y-b1.y, a1.y+b1.x-a1.x);
        drawTree(g2, a1, b1, c1, d1, depth);

        // Neues Quadrat rechts
        a2 = e;
        b2 = c;
        c2 = new Point(b2.x+a2.y-b2.y, b2.y+b2.x-a2.x);
        d2 = new Point(a2.x+a2.y-b2.y, a2.y+b2.x-a2.x);
        drawTree(g2, a2, b2, c2, d2, depth);
    }
}
