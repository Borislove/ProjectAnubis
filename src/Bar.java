
import java.awt.Image;
import javax.swing.ImageIcon;

//иконка накоплений, или инвентарь? 
public class Bar {
    
       //цветной бар
     Image img3 = new ImageIcon (getClass().getClassLoader().getResource("res/bar1.png")).getImage() ; 
    int x3 = 160;
    int y3 = 500;
     
    
    //загрузим ее
    Image img = new ImageIcon (getClass().getClassLoader().getResource("res/bar.png")).getImage() ; 
    
    //зададим расположение , координаты
    
    int x = 20;
    int y = 500; 
    
    //загрузим класс в space , и отрисуем
    
    /*
    Bar bar = new Bar();
    
    */
    //пробую загрузить 2 объект того же типа
    
    Image img1 = new ImageIcon (getClass().getClassLoader().getResource("res/bar.png")).getImage() ; 
    int x1 = 90;
    int y1 = 500;
    
    
    
    Image img2 = new ImageIcon (getClass().getClassLoader().getResource("res/bar.png")).getImage() ; 
    int x2 = 160;
    int y2 = 500;
}
