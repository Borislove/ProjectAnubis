import javax.swing.*;

public class ProjectAnubis {

    public static void main(String[] args) {
        JFrame f = new JFrame("Project: ANUBIS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);

        Player pl = new Player();
        int t = 0;
        f.setSize(815, 695);
        f.setLocationRelativeTo(null);
        if (t == 3) f.setSize(1500, 1800);
        // f.setExtendedState (JFrame.MAXIMIZED_BOTH);
        f.add(new Space());
        f.setVisible(true);
    }
}



