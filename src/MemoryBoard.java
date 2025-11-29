import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MemoryBoard extends JPanel {

    private final int n;
    private final CardButton[] buttons;

    public MemoryBoard(int n) {
        this.n = n;
        setLayout(new GridLayout(n, n));

        String[] symbols = taoBoKyTu(n);
        buttons = new CardButton[n * n];

        for (int i = 0; i < n * n; i++) {
            Card card = new Card(symbols[i]);
            buttons[i] = new CardButton(card);
            add(buttons[i]);
        }
    }

    public CardButton[] getButtons() {
        return buttons;
    }

    private String[] taoBoKyTu(int n) {
        int total = n * n;
        int pairs = total / 2;

        String[] symbols = {
            "♥", "♦", "♣", "♠", "★", "⬤", "⬛", "⬢",
            "✿", "✦", "✧", "❖", "❀", "✪", "✩", "✫",
            "✬", "✭"
        };

        if (pairs > symbols.length) {
            throw new IllegalArgumentException("Không đủ ký tự!");
        }

        String[] arr = new String[total];
        int idx = 0;
        for (int i = 0; i < pairs; i++) {
            arr[idx++] = symbols[i];
            arr[idx++] = symbols[i];
        }

        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }
}