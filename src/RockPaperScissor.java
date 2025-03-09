import java.util.Random;

public class RockPaperScissor {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};
    private String computerChoice;
    private int computerScore;
    private int playerScore;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private Random random;

    public RockPaperScissor(Random random) {
        this.random = random;
    }

    public String playRockPaperScissor(String playerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;

        switch (computerChoice) {
            case "Rock":
                if (playerChoice.equals("Paper")) {
                    result = "Palyer Wins!";
                    playerScore++;
                } else if (playerChoice.equals("Scissor")){
                    result = "Computer Wins!";
                    computerScore++;
                } else {
                    result = "Equal! No one Wins!";
                }
                break;
            case "Paper":
                if (playerChoice.equals("Scissors")) {
                    result = "Player Wins!";
                    playerScore++;
                } else if (playerChoice.equals("Rock")) {
                    result = "Computer Wins!";
                    computerScore++;
                } else {
                    result = "Equal! No one Wins!";
                }
                break;
            case "Scissors":
                if (playerChoice.equals("Rock")) {
                    result = "Player Wins!";
                    playerScore++;
                } else if (playerChoice.equals("Paper")) {
                    result = "Computer Wins!";
                    computerScore++;
                } else {
                    result = "Equal! No one Wins!";
                }
                break;
            default:
                result = "False Input!";
        }
        return result;
    }
}
