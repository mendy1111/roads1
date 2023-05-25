import javax.swing.*;
import java.awt.*;

public class Player {
    private int x;
    private int y;
    private ImageIcon player;
    private final int speed = 20;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.player = new ImageIcon("src\\images\\player.png");
        this.player = new ImageIcon(this.player.getImage().getScaledInstance(this.player.getIconWidth() / 18, this.player.getIconHeight() / 22, Image.SCALE_SMOOTH));  //כיוץ

    }



    public void paint(Graphics graphics) {
        player.paintIcon(null, graphics, x, y);
    }

    public void moveRight() {
        if (this.x < Window.WIDTH - player.getIconWidth() - 20) {
            this.x += speed+20;
        }
    }

    public void moveLeft() {
        if (this.x > 0) {
            this.x -= speed+20;
        }
    }

    public void moveUp() {
        this.y -= speed;
    }

    public void moveDown() {
        if (this.y < Window.HEIGHT - player.getIconHeight() - 40) {
            this.y += speed;
        }
    }

    public Rectangle rectangle() {
        return new Rectangle(x, y, player.getIconWidth(), player.getIconHeight());
    }

    public boolean reset() {

        x = Window.WIDTH / 2;
        y = 730;
        return true;
    }

    public boolean win() {
        if (this.y < 5) {
            reset();
            return true;
        }
        return false;
    }


}



