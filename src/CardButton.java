import java.awt.Dimension; 
import java.awt.Font;
import javax.swing.JButton;

public class CardButton extends JButton {
    private final Card card;

    public CardButton(Card card) {
        this.card = card;
        
        Dimension cardSize = new Dimension(70, 70); 
        this.setPreferredSize(cardSize);
        this.setMaximumSize(cardSize); 

        this.setFont(new java.awt.Font("Arial", Font.BOLD, 36));
        setText("");
    }

    public void updateDisplay() {
        if (card.isMatched()) {
            setText(card.getSymbol());
            setEnabled(false);
        } else if (card.isFlipped()) {
            setText(card.getSymbol());
        } else {
            setText("");
        }
    }

    public Card getCard() {
        return card;
    }
}