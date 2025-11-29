import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MemoryGame {
    private CardButton firstCard = null;
    private CardButton secondCard = null;
    private int moves = 0;
    private int pairsFound = 0;
    private final JLabel movesLabel;
    private final MemoryGameForm form;
    private int totalPairs;
    
public MemoryGame(JLabel movesLabel, MemoryGameForm form) { 
    this.movesLabel = movesLabel;
    this.form = form; 
}
    public void attachEvents(MemoryBoard board) {
        this.totalPairs = board.getButtons().length / 2;
        for (CardButton button : board.getButtons()) {
            button.addActionListener(e -> handleCardClick(button));
        }
    }

    private void handleCardClick(CardButton clickedCard) {
        if (clickedCard.getCard().isMatched() || clickedCard.getCard().isFlipped()) {
            return;
        }

        if (firstCard == null) {
            firstCard = clickedCard;
            firstCard.getCard().flip();
            firstCard.updateDisplay();
        } else if (secondCard == null) {
            secondCard = clickedCard;
            secondCard.getCard().flip();
            secondCard.updateDisplay();
            
            moves++;
            movesLabel.setText("Moves: " + moves);

            Timer timer = new Timer(1000, e -> compareCards());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void compareCards() {
        if (firstCard.getCard().getSymbol().equals(secondCard.getCard().getSymbol())) {
            firstCard.getCard().setMatched(true);
            secondCard.getCard().setMatched(true);
            firstCard.setEnabled(false);
            secondCard.setEnabled(false);
            pairsFound++;
            
            if (pairsFound == totalPairs) {
                form.stopTimer(); 
                JOptionPane.showMessageDialog(form, "You won in " + moves + " moves!");
            }
        } else {
            firstCard.getCard().flip();
            secondCard.getCard().flip();
            firstCard.updateDisplay();
            secondCard.updateDisplay();
        }

        firstCard = null;
        secondCard = null;
    }
}