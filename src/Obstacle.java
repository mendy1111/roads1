import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Obstacle {
    private int x;
    private int y;
    private ImageIcon car;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public static int speedFrom = 2;

    public static int speedUpTo = 4;

    public void random(){
        Random random = new Random();

        this.speed = random.nextInt(speedFrom,speedUpTo);

    }



    public Obstacle(int x, int y, String car) {
        this.x = x;
        this.y = y;
        this.car = new ImageIcon(car);
        this.car = new ImageIcon(this.car.getImage().getScaledInstance(82,34,Image.SCALE_SMOOTH));
        random();
    }
    public void moveRight(){
        this.x+=speed;
        if (x > Window.WIDTH + car.getIconWidth()) {
            x = -car.getIconWidth();
            random();
        }
          }

    public void moveLeft(){
        this.x-=speed;
        if (x < - car.getIconWidth()) {
            x = Window.WIDTH + car.getIconWidth();
            random();
        }
    }
    public Rectangle rectangle(){
        return new Rectangle(x,y,car.getIconWidth(),car.getIconHeight());
    }
    public void paint(Graphics graphics){
        car.paintIcon(null,graphics,x,y);

    }
}

