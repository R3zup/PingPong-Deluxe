import javax.swing.*; 
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameMenu extends JFrame {

private JButton oneVsOneButton, oneVsComputerButton, highScoreButton, customizationButton, okay;
private PingPong pingPong;
private JTextField name;
private JPanel namenEingabe, mainPanel;
private JFrame nameFrame;

public GameMenu() {
    setTitle("Game Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    mainPanel = new JPanel(new GridLayout(4,1,10,10));
    mainPanel.setPreferredSize(new Dimension(800,600));
    add(mainPanel);
    
    namenEingabe = new JPanel();
    
    nameFrame = new JFrame("name eingeben");
    nameFrame.setSize(400, 300);
    nameFrame.add(namenEingabe);
    nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    oneVsOneButton = new JButton("1 vs 1");
    oneVsOneButton.setPreferredSize(new Dimension(200, 80));
    oneVsOneButton.addActionListener(e -> startOneVsOneGame());
    mainPanel.add(oneVsOneButton);
    
    oneVsComputerButton = new JButton("1 vs Computer");
    oneVsComputerButton.setPreferredSize(new Dimension(200, 80));
    oneVsComputerButton.addActionListener(e -> startOneVsComputerGame());
    mainPanel.add(oneVsComputerButton);
    
    highScoreButton = new JButton("Highscores");
    highScoreButton.setPreferredSize(new Dimension(200, 80));
    highScoreButton.addActionListener(e -> showHighScores());
    mainPanel.add(highScoreButton);
    
    customizationButton = new JButton("Customization");
    customizationButton.setPreferredSize(new Dimension(200, 80));
    customizationButton.addActionListener(e -> showCustomization());
    mainPanel.add(customizationButton);
    
    name = new JTextField("Spielername");
    namenEingabe.add(name);
    
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
            String x = Files.readString(p);
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
}

private void showCustomization() {
    
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(GameMenu::new);
}
}