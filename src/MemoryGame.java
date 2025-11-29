import javax.swing.*;

public class MemoryGame {

    private CardButton first = null;
    private CardButton second = null;
    private boolean locking = false;

    private int moves = 0;
    private final JLabel lblMoves;

    public MemoryGame(JLabel lblMoves) {
        this.lblMoves = lblMoves;
}
    public void attachEvents(MemoryBoard board) {
    for (CardButton btn : board.getButtons()) {
        btn.addActionListener(e -> {
            if (locking) return;
            if (btn.getCard().isFlipped() || btn.getCard().isMatched()) return;

            btn.getCard().flip();
            btn.updateDisplay();

            moves++;
            lblMoves.setText("Moves: " + moves);

            if (first == null) {
                first = btn;
            } else {
                second = btn;
                checkMatch();
            }
        });
    }
}

    private void checkMatch() {
        if (first.getCard().getSymbol()
            .equals(second.getCard().getSymbol())) {

            first.getCard().setMatched(true);
            second.getCard().setMatched(true);
            first.updateDisplay();
            second.updateDisplay();

            first = null;
            second = null;

        } else {
            locking = true;

            Timer t = new Timer(700, e -> {
                first.getCard().flip();
                second.getCard().flip();
                first.updateDisplay();
                second.updateDisplay();

                first = null;
                second = null;
                locking = false;
            });

            t.setRepeats(false);
            t.start();
        }
    }

    private static class labelMoves {

        private static void setText(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public labelMoves() {
        }
    }
}