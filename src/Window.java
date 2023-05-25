import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    public static final int WIDTH = 1200;
    public static final int  HEIGHT = 800;
    private boolean pause = false;
    Game game = new Game();
    public  Window() throws HeadlessException {
        this.setTitle("my game roads");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(game);
        this.addKeyListener(this);
        this.setVisible(true);


            }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==32) {
            pause = !pause;
            game.pause = pause;

        }
        if (!pause) {
            switch (e.getKeyCode()) {
                case 37 -> {
                    game .getPlayer().moveLeft();

                }
                case 38 -> {
                    game.getPlayer().moveUp();

                }
                case 39 -> {
                    game.getPlayer().moveRight();
                }
                case 40 -> {
                    game.getPlayer().moveDown();

                }


            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


