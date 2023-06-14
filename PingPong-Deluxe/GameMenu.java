import javax.swing.*; 
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameMenu extends JFrame {

    private JButton oneVsOneButton, oneVsComputerButton, highScoreButton, hardcoreButton, okay, okayh;
    private PingPong pingPong;
    private JTextField name, nameh;
    private JPanel namenEingabe, mainPanel, namenEingabeh;
    private JFrame nameFrame, nameFrameh;

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);

        ImageIcon backgroundImage = new ImageIcon("/Users/Guest/Downloads/PingPong-Deluxe-main/PingPong-Deluxe/back.png");

        JPanel backgroundPanel = new JPanel() 
            {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
                }
            };

        backgroundPanel.setLayout(null); // Set layout to null
        add(backgroundPanel);

        nameFrame = new JFrame("name eingeben");
        nameFrame.setSize(400, 300);
        namenEingabe = new JPanel();
        nameFrame.add(namenEingabe);
        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        oneVsOneButton = new JButton("1 vs 1");
        oneVsOneButton.setBounds(300, 200, 200, 40); // Set position and size
        oneVsOneButton.addActionListener(e -> startOneVsOneGame());
        backgroundPanel.add(oneVsOneButton);

        oneVsComputerButton = new JButton("1 vs Computer");
        oneVsComputerButton.setBounds(300, 250, 200, 40); // Set position and size
        oneVsComputerButton.addActionListener(e -> startOneVsComputerGame());
        backgroundPanel.add(oneVsComputerButton);

        highScoreButton = new JButton("Highscores");
        highScoreButton.setBounds(300, 350, 200, 40); // Set position and size
        highScoreButton.addActionListener(e -> showHighScores());
        backgroundPanel.add(highScoreButton);

        hardcoreButton = new JButton("Hardcore");
        hardcoreButton.setBounds(300, 300, 200, 40); // Set position and size
        hardcoreButton.addActionListener(e -> showHardcore());
        backgroundPanel.add(hardcoreButton);

        name = new JTextField("Spielername");
        namenEingabe.add(name);

        nameFrameh = new JFrame("name eingeben");
        nameFrameh.setSize(400, 300);
        namenEingabeh = new JPanel();
        nameFrameh.add(namenEingabeh);
        nameFrameh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameh = new JTextField("Spielername");
        namenEingabeh.add(nameh);

        okayh = new JButton("Okay");
        okayh.addActionListener(e -> spielernameEingabeHardcore());
        namenEingabeh.add(okayh);

        okay = new JButton("Okay");
        okay.addActionListener(e -> spielernameEingabe());
        namenEingabe.add(okay);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startOneVsOneGame() {
        setVisible(false);
        pingPong = new PingPong();
    }

    private void startOneVsComputerGame() {
        setVisible(false);
        nameFrame.setVisible(true);
    }

    private void spielernameEingabe()
    {
        nameFrame.setVisible(false);
        new PingPongCom(name.getText());
    }

    private void showHighScores() {
        Path p = Path.of("/Users/Guest/Downloads/PingPong-Deluxe-main/Highscore.txt");
        try {
            System.out.print('\u000C');
            String x = Files.readString(p);
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showHardcore() {
        setVisible(false);
        nameFrameh.setVisible(true);
    }

    private void spielernameEingabeHardcore()
    {
        nameFrameh.setVisible(false);
        new HardcorePingPong(nameh.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameMenu::new);
    }
}