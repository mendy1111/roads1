import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){

        StartPanel panel = new StartPanel();
        this.add(panel);
        this.setTitle("menu");
        this.setSize(500,650);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        Main main = new Main();
    }


}