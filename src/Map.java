
import java.awt.Image;
import javax.swing.ImageIcon;


public class Map {
    
    
    
   //Image img = new ImageIcon ("src\\res\\space.jpg").getImage ();
   
   Image img = new ImageIcon (getClass().getClassLoader().getResource("res/space.jpg")).getImage() ; 
    
    int x = 950;
    int y = 0;
}

