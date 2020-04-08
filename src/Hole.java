
import java.awt.Image;
import javax.swing.ImageIcon;


//метеорит , пока просто летает или черная дыра? я запутался
public class Hole {
    
    
     //Image img = new ImageIcon ("src\\res\\hole.png").getImage();
     
     Image img = new ImageIcon (getClass().getClassLoader().getResource("res/hole.png")).getImage() ; 
     
     int x = 300;
     int y = 50;
    
    
}
