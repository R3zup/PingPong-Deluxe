import javax.swing.*;
import java.awt.*;

public class GameMenu extends JFrame {
    
    private JButton oneVsOneButton, oneVsComputerButton, highScoreButton, customizationButton;
    
    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridLayout(4,1,10,10));
        mainPanel.setPreferredSize(new Dimension(800,600));
        add(mainPanel);
        
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
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void startOneVsOneGame() {
        
    }
    
    private void startOneVsComputerGame() {
        
    }
    
    private void showHighScores() {
        
    }
    
    private void showCustomization() {
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameMenu::new);
    }
}
