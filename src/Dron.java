
import java.awt.Image;
import javax.swing.ImageIcon;


public class Dron {
    
       // Image img = new ImageIcon ("src\\res\\dron.png").getImage();
       
       Image img = new ImageIcon (getClass().getClassLoader().getResource("res/dron.png")).getImage() ; 
     
     int x = 650;
     int y = 540;
    
    
}
