

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.*;

public class Space extends JPanel implements ActionListener, Runnable {

    Timer mainTimer = new Timer(20, this);  //таймер будет запускать функцию , миллисекунды

    // Image img = new ImageIcon ("res/space.jpg").getImage() ;  //создайется новый файл, возвращает его


//космос версия 1
//Image img = new ImageIcon ("src//res//space.jpg").getImage() ;    //добавил scr подгрузилось все


//космос версия 2
    //Image img = new ImageIcon ("src//res//space1.jpg").getImage() ;    //добавил scr подгрузилось все

    //космос версия 3 рабочая версия
    //Image img = new ImageIcon ("src//res//space3.jpg").getImage() ;


    //для архива если что то не так заменить
    Image img = new ImageIcon(getClass().getClassLoader().getResource("res/space3.jpg")).getImage();   //видит дорогу но не все другое...


    //Image img = new ImageIcon ("C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectAnubis\\src\\res\\space.jpg").getImage() ;
    //перерисовка

    Player p = new Player(); //создали объект тех
    Panel pa = new Panel();  //создали панель
    Ram ram = new Ram();   //создал объект рамки
    Stage st = new Stage();

    Date date = new Date(); //инициализация даты

    Meteor mt = new Meteor();
    Hole hole = new Hole();
    Dron drone = new Dron();
    Map map = new Map();

    //загружаем класс бар
    Bar bar = new Bar();


    int t = 0;

    int tt = t;

    Thread enemiesFactory = new Thread(this);
    List<Enemy> enemies = new ArrayList<Enemy>();

    //поток врагов


    //Panel ram = new Panel ();

    public Space() {
        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);  //видеть обработку клавиатуры
    }


    //автоматически создана
    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));   //случайно задержаться потоку
                enemies.add(new Enemy(1200, rand.nextInt(700), rand.nextInt(50), this));   //+случайная позиция + скорость рандомная

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //реализация клавиатуры
    private class myKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }


        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }


    public void paint(Graphics g) {
        //приведение типов
        g = (Graphics2D) g;
        //уровень
        g.drawImage(st.stage, st.x, st.y, null);
        //фон
        g.drawImage(img, p.layer1, 0, null);
        g.drawImage(img, p.layer2, 0, null);
        //метеорит
        g.drawImage(mt.img, mt.x, mt.y, null);
        //черная дырка
        g.drawImage(hole.img, hole.x, hole.y, null);
        //звездолет
        g.drawImage(p.img, p.x, p.y, null);

        //рамка не видна - переместил перед уровнем видна
        g.drawImage(ram.img, ram.x, ram.y, null);

        //bar0
        g.drawImage(bar.img, bar.x, bar.y, null);
        //bar1
        g.drawImage(bar.img, bar.x1, bar.y1, null);
        //bar2 = 3
        g.drawImage(bar.img, bar.x2, bar.y2, null);
        //bar3 - желтый
        //     g.drawImage(bar.img3, bar.x3, bar.y3, null);


        //карта
        g.drawImage(map.img, map.x, map.y, null);


        //повороты  звездолета


        //дрон
        g.drawImage(drone.img, drone.x, drone.y, null);
        //тул бар
        g.drawImage(pa.img, pa.x, pa.y, null);


        //считаем скорость
        g.setColor(Color.green);
        Font font = new Font("Arial", Font.ITALIC, 15);  //шрифт
        g.setFont(font);
        double v = (300 / Player.MAX_V) * p.v;
        g.drawString("Speed: " + v + " " + "SS/H", 10, 640);  //supersonic сверхзвуковая)

        if (v >= 150) {
            g.setColor(Color.yellow);
            g.setFont(font);
            g.drawString("Speed: " + v + " " + "SS/H" + " optimal", 10, 640);
        }


        if (v == 300) {
            g.setColor(Color.red);
            g.setFont(font);
            g.drawString("Speed: " + v + " " + "SS/H", 10, 640);  //supersonic сверхзвуковая)

            g.drawString(" WARNING!", 10, 590);  //supersonic сверхзвуковая)

        }

        g.setColor(Color.WHITE);
        g.drawString("открыл пространство и время...", 1000, 1000);
        g.drawString("нажми HOME и будет тебе бесконечность!", 1100, 1100);


        g.setColor(Color.GREEN);
        //g.drawString ("Вы собрали: " + t  + " метеоритов (при 30 выкидывает из игры)" , 10,10 );

        g.drawString("Вы собрали: " + t + " метеоритов (при 30 выкидывает из игры)", 10, 10);

        g.drawString("" + t, 50, 520);


        g.setColor(Color.GREEN);
        g.drawString("Date: " + new Date(), 10, 615);   //выводит дату и время


        // -------------------------------------------
        //рабочий бар накоплений
//                 if(t==1) {
//                        g.drawImage (bar.img3, bar.x3, bar.y3, null);
//
//                      }

        // -------------------------------------------


        //тест

        for (int i = 0; i < 10; i++) {


            if (tt == 1) {
                g.drawImage(bar.img3, bar.x3, bar.y3, null);

            }
        }


        //враги объекты
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();


            //если враг появляется то удаляем его из коллекции
            if (e.x >= 2400 || e.x <= -2400) {
                i.remove();
            } else {
                e.Movie();
                g.drawImage(e.img, e.x, e.y, null);
            }

        }

    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        testCollisionWithEnemies();

        //System.out.println(enemies.size()); //вывод в консоль столкновения
    }

    private void testCollisionWithEnemies() {
        Iterator<Enemy> i = enemies.iterator();


        while (i.hasNext()) {
            Enemy e = i.next();
            //если попали друг в друга леталка + камень


            if (p.getRect().intersects(e.getRect())) {


//        System.out.println("i"+i);  //сборка пошла, выводить количество собранных камней


//это для чего??? для накопления
//--t;
                ++t;


                //System.out.println("Собранно кристаллов:"  + t  + " " + i + " "+ date.toString());    //дата с первого кристала...не работают секунды и минуты
                System.out.println("Собранно кристаллов:" + t + " " + i + " " + new Date());
                if (t == 10 || t == 20) {
                    System.out.println("warning!!!");


                }

       /*
        //тест
        if (t==3 ) {
        System.exit(1);   //выход из игры
        }
        */

                //если собрано 3 выйти из игры
//      if (t==10) {
//       JOptionPane.showMessageDialog(null, "Error: 823922142234211664322PatrikERo!" + date  + "");
//       System.exit(1);
//       }


                i.remove();
            }

        }
    }
}

