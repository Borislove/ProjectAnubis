
import java.awt.Image;
import javax.swing.ImageIcon;


//метеорит , пока просто летает
public class Meteor {
    
    
     //Image img = new ImageIcon ("src\\res\\meteor.png").getImage();
     
     Image img = new ImageIcon (getClass().getClassLoader().getResource("res/meteor.png")).getImage() ; 
     
     int x = 100;
     int y = 390;
    
    
}
