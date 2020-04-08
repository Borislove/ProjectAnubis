
import java.awt.Image;
import javax.swing.ImageIcon;


//рамка
public class Ram {
    
   
    
    //тест
   // Image img = new ImageIcon ("src\\res\\ramka1.jpg").getImage ();
   //Image img = new ImageIcon ("src\\res\\ramka.jpg").getImage ();
   
   
   
   //Image img = new ImageIcon ("src\\res\\ram.png").getImage ();
   
   Image img = new ImageIcon (getClass().getClassLoader().getResource("res/ram.png")).getImage() ; 
    
    int x = 0;
    int y = 0;
}
