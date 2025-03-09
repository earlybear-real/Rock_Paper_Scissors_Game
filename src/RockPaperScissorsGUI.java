import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGUI extends JFrame implements ActionListener{
    JButton rockButton, paperButton, scissorButton;

    JLabel computerChoice;

    JLabel computerScoreLabel, playerScoreLabel;

    RockPaperScissor rockPaperScissor;

    public RockPaperScissorsGUI() {
        super("Rock Paper Scissor");

        setSize(450, 574);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        rockPaperScissor = new RockPaperScissor(new Random());

        addGuiComponents();
    }

    private void addGuiComponents() {
        // computer score label
        computerScoreLabel = new JLabel("Computer: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        // computer choice label
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        add(computerChoice);

        // player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // rock buttons
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        // scissor button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    // message dialog
    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        // try again button
        JButton tryAgainButton = new JButton("Try Again!");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset computer choice
                computerChoice.setText("?");

                // close dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);
        computerChoice.setText(rockPaperScissor.getComputerChoice());
        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        showDialog(result);
    }
}
