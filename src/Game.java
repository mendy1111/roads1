import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    int level = 1;
    JLabel labelLevel = new JLabel("level: " + level);
    int scores = 0;
    JLabel score = new JLabel("your score: " +scores);





    public boolean pause = false;

    private final ImageIcon road2 = new ImageIcon("src\\images\\כביש עם דשא וספסלים.png");
    private final ImageIcon shrinkRoads = new ImageIcon(road2.getImage().getScaledInstance(Window.WIDTH, 200, Image.SCALE_SMOOTH));

    private final Obstacle car1 = new Obstacle(Window.WIDTH-100,60,"src\\images\\רכב נוסע לשמאל.png");
    private final Obstacle car2 = new Obstacle(0,95,"src\\images\\car1.png");

    private final Obstacle car3 = new Obstacle(Window.WIDTH-100,260,"src\\images\\רכב נוסע לשמאל.png");
    private final Obstacle car4 = new Obstacle(0,295,"src\\images\\car1.png");
    private final Obstacle car5 = new Obstacle(Window.WIDTH-100,460,"src\\images\\רכב נוסע לשמאל.png");
    private final Obstacle car6 = new Obstacle(0,495,"src\\images\\car1.png");
    private final Obstacle car7 = new Obstacle(Window.WIDTH-100,660,"src\\images\\רכב נוסע לשמאל.png");
    private final Obstacle car8 = new Obstacle(0,695,"src\\images\\car1.png");
    private final Obstacle crow = new Obstacle(Window.WIDTH-100,150,"C:\\studies\\roads\\src\\images\\עורב.png");
    private final Obstacle eagle = new Obstacle(0,350,"C:\\studies\\roads\\src\\images\\נשר עף לימין.png");
    private final Obstacle crow2 = new Obstacle(Window.WIDTH-100,600,"C:\\studies\\roads\\src\\images\\עורב.png");


    private final Player player = new Player(Window.WIDTH/2,730);


    public Player getPlayer() {
        return player;
    }

    public Game() {

        this.setBackground(Color.cyan);
        this.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
        this.setLayout(null);

        new Thread(()->{

            while (true) {
                if (!pause) {
                    car1.moveLeft();
                    car3.moveLeft();
                    car5.moveLeft();
                    car7.moveLeft();

                    collusion(car1);
                    collusion(car2);
                    collusion(car3);
                    collusion(car4);
                    collusion(car5);
                    collusion(car6);
                    collusion(car7);
                    collusion(car8);
                    collusion(crow);
                    collusion(crow2);
                    collusion(eagle);
                    if (player.win()) {
                        Obstacle.speedUpTo ++;
                       // Obstacle.speedFrom++;
                        level++;
                        labelLevel.setText("level: "+ level);

                        scores+=10;
                        score.setText("your score: " + scores);
                    }

                }
                try {
                    Thread.sleep(4);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }).start();


        new Thread(()->{
            while (true){
                if (!pause) {
                    car8.moveRight();
                    car6.moveRight();
                    car4.moveRight();
                    car2.moveRight();
                    crow.moveLeft();
                    eagle.moveRight();
                    crow2.moveLeft();
                }
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }

        }).start();
        labelLevel.setForeground(Color.RED);
        labelLevel.setFont(new Font("Arial",Font.BOLD,25));
        labelLevel.setBounds(0,0,200,30);
        this.add(labelLevel);

        score.setForeground(Color.yellow);
        score.setFont(new Font("Arial",Font.BOLD,20));
        score.setBounds(0,15,200,50);
        this.add(score);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shrinkRoads.paintIcon(null, g, 0, -70);
        shrinkRoads.paintIcon(null, g, 0, 130);
        shrinkRoads.paintIcon(null, g, 0, 330);
        shrinkRoads.paintIcon(null,g,0,530);


        g.setColor(Color.PINK);
        g.fillRect(0, 730, Window.WIDTH, 35);
        car1.paint(g);
        car2.paint(g);
        car3.paint(g);
        car4.paint(g);
        car5.paint(g);
        car6.paint(g);
        car7.paint(g);
        car8.paint(g);
        player.paint(g);
        crow.paint(g);
        eagle.paint(g);
        crow2.paint(g);


    }
    public void collusion(Obstacle obstacle){
        if (player.rectangle().intersects(obstacle.rectangle())){
            player.reset();

        }
    }


}
