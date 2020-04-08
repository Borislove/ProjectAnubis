import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public static final int MAX_V = 300; //максимальная скорость в пикселях
    public static final int MAX_TOP = 30; //максимальная координата верхнего края экрана
    public static final int MAX_BOTTOM = 495;  //макс координата нижнего экрана

    //Image img_c = new ImageIcon ("src\\res\\stels_d.png").getImage();
    //влево , право
    //Image img_l = new ImageIcon ("src\\res\\stelsleft.png").getImage();
    //Image img_r = new ImageIcon ("src\\res\\stelsright.png").getImage();

    //Image img = img_c;

    //по дефолту
    // Image img_def = new ImageIcon ("src\\res\\stels.png").getImage();


    //переделываю пути
    Image img_c = new ImageIcon(getClass().getClassLoader().getResource("res/stels_d.png")).getImage();
    Image img = img_c;

//    Image img_l = new ImageIcon (getClass().getClassLoader().getResource("res/stelsleft.png")).getImage() ;

    Image img_l = new ImageIcon(getClass().getClassLoader().getResource("res/nice.png")).getImage();

    Image img_r = new ImageIcon(getClass().getClassLoader().getResource("res/stelsright.png")).getImage();


    Image img_def = new ImageIcon(getClass().getClassLoader().getResource("res/stels.png")).getImage();

    //  Image img_def = new ImageIcon (getClass().getClassLoader().getResource("res/nice.png")).getImage() ;

    //взаимодействие с объектом
    public Rectangle getRect() {
        return new Rectangle(x, y, 100, 56);
    }

    //

    //параметры
    int v = 1;  //скорость   //изменить н а 1
    int dv = 0;  // ускорение
    int dy = 0;

    int s = 0;   //полный путь , величина пути

    int layer1 = 0;  //координаты первого слоя, только икс
    int layer2 = 900;  //координаты 2 слоя


    //начальные координаты тех снизу
    /*int x = 40;
    int y = 600;  */

    //

    //координаты с середины
    int x = 30;
    int y = 300;

    //методы
    public void move() {

        s += v;  //сколько пролетели

        v += dv;

        if (v <= 0) v = 0;   //назад не поедет
        if (v >= MAX_V) v = MAX_V;

        // v +=dv;  включить можно назад

        y -= dy;

        if (y <= MAX_TOP) y = MAX_TOP;  //корректировать
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
        //движение фона
        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 900;
        } else {
            layer1 -= v;
            layer2 -= v;
        }

        //анимирование движения
        layer1 -= v;    //первый слой
        layer2 -= v;


    }

    /*public void keyPressed (KeyEvent e) {
        JOptionPane.showMessageDialog(null,"key pressed");        //showConfim
    }*/


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            dv = 1;
            img = img_def;
        }
        if (key == KeyEvent.VK_LEFT) {
            dv = -1;  //поставить на ноль только вперед + dy -будет уходить вниз плавно

            //  x = 5;
            JOptionPane.showMessageDialog(null, "Только вперед! ");
            x -= 1;

            if (x == 7) {
                JOptionPane.showMessageDialog(null, "Вы вылетели из системы! ");
                System.exit(1);
            }
        }

        if (key == KeyEvent.VK_UP) {
            dy = 3;

            img = img_l;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = -3;

            img = img_r;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dv = 0;

            img = img_c;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (key == KeyEvent.VK_HOME) {
            //   System.out.println("test" + test);
            JOptionPane.showMessageDialog(null, "Вы входите в админку! - без реализации ");
            //  par.setExtendedState (JFrame.MAXIMIZED_BOTH);

        }

    }
}
