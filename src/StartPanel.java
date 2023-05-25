import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    private final ImageIcon backPhotoRoad;
    private final ImageIcon backPhotoPlayer;

    private boolean rulesVisible = true;
    private boolean removeTheTitle = false;

   private final JLabel title = new JLabel("Keep Pooh alive!");


    private final JLabel text = new JLabel("<html>Rules:\n<html>" +

            "1. Advance Pooh upwards with the arrows on the keyboard, while avoiding meeting the vehicles on the way.\n" +
            "2. As you go up the stages, the speed of the vehicles will increase.\n" +
            "3. encountering vehicles will return you to the beginning of the game.\n"+
            "4. At any time you can press space bar to pause the game.\n" +
            "5. Try to get the highest score number.");



    public StartPanel() {

        this.setSize(500, 650);
        this.backPhotoRoad = new ImageIcon("C:\\studies\\roads\\src\\images\\כביש עם דשא וספסלים מוקטן.png");
        this.backPhotoPlayer = new ImageIcon("C:\\studies\\roads\\src\\images\\פו הדב מוקטן מסך פתיחה.png");
        this.setLayout(null);


        JButton start = new JButton("start");
        start.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
        start.setForeground(Color.red);

        start.setBounds(200, 520, 100, 50);

        start.setBackground(Color.orange);

        start.addActionListener((e) -> {
            Window window = new Window();
        });

        JButton gameInstructions = new JButton("game instructions");
        gameInstructions.setBounds(4, 4, 170, 50);
        gameInstructions.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
        gameInstructions.setForeground(Color.WHITE);
        gameInstructions.setBackground(Color.red);

        text.setBounds(5, 15, 400,170 );
        text.setVisible(false);
        gameInstructions.addActionListener((e) -> {
            text.setVisible(rulesVisible);
            rulesVisible = !rulesVisible;
            title.setVisible(removeTheTitle);
            removeTheTitle = !removeTheTitle;


        });

        title.setBounds(15,100,500,50);
        title.setForeground(Color.RED);
        title.setFont(new Font("Bradley Hand ITC",Font.BOLD,65));
        this.add(gameInstructions);
        this.add(start);
        this.add(text);
        this.add(title);

    }
    public void paintComponent (Graphics graphics){
        graphics.setColor(Color.cyan);
        graphics.fillRect(0,0,this.getWidth(),this.getHeight());
        this.backPhotoRoad.paintIcon(null,graphics,0,200);
        this.backPhotoPlayer.paintIcon(null,graphics,200,300);
    }
}

