
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


//синий камень
public class Enemy {
    
    
    int x;
    int y;
    int v; //скорость
    
    Image img = new ImageIcon ( "src\\res\\astero.png").getImage();
            
    Space space;
    
    
    
    //взаимодействие с объектом
    public Rectangle getRect() {
    return new Rectangle(x,y,100,73);
    }
    
    
    //передать параметры врагу
    public Enemy (int x, int y, int v, Space space) {
    this.x =x;
    this.y=y;
    this.v=v;
    this.space=space;
    
    
    }
    
    public void Movie () {
    
        x = x - space.p.v + v;
        
    }
    
}
