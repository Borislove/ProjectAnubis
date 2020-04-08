
import java.awt.Image;
import javax.swing.ImageIcon;


//нижняя панель , отключена
//тулбар
public class Panel {
    
    //Image img = new ImageIcon ("src\\res\\toolbar3.jpg").getImage();
    
    Image img = new ImageIcon (getClass().getClassLoader().getResource("res/toolbar3.jpg")).getImage() ; 
    
    
    int x = 0;
    int y = 590;
    
}
