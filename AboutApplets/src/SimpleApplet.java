import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;

public class SimpleApplet extends Applet { 
	StringBuffer buffer;

   private void addItem(String newWord) {
  	    System.out.println(newWord);
        buffer.append(newWord); 
        repaint(); 
    } 
 
    public void paint(Graphics g) { 
	  Dimension size = this.getSize();
	  // Draw a Rectangle around the applet's display area. 
   	  g.drawRect(0, 0, getSize().width - 1, getSize().height - 1); 
   	  // Draw the current string inside the rectangle. 
   	  g.drawString(buffer.toString(), 5, 15); 
    }  
    public void init() {
  	    buffer = new StringBuffer();
        addItem("initializing... ");
    }
     
    public void start() { 
  	    addItem("starting... "); 
    } 
  
    public void stop() { 
        addItem("stopping... ");
    } 
  
    public void destroy() { 
  	    addItem("preparing for unloading..."); 
    }
}