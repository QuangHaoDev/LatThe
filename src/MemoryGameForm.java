import java.awt.GridLayout;

public class MemoryGameForm extends javax.swing.JFrame {
    private javax.swing.Timer gameTimer;
    private int secondsPlayed = 0;
    public MemoryGameForm() {
        initComponents();
        cbSize.addItem("4 x 4");
        cbSize.addItem("6 x 6");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBoard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbSize = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("Moves: 0");

        Time.setText("Time");

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Time)
                            .addGap(176, 176, 176)
                            .addComponent(jLabel1)
                            .addGap(102, 102, 102)
                            .addComponent(jButton1)
                            .addGap(12, 12, 12)
                            .addComponent(jButtonReset)))
                    .addComponent(cbSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(Time))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReset)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int n = switch ((String) cbSize.getSelectedItem()) {
        case "4 x 4" -> 4;
        case "6 x 6" -> 6;
        default -> 4;
    };
    
    jPanelBoard.removeAll();
    jPanelBoard.setLayout(new GridLayout(n, n));
    MemoryBoard board = new MemoryBoard(n);
    MemoryGame game = new MemoryGame(jLabel1, this);
    game.attachEvents(board);
    for (CardButton c : board.getButtons()) {
        jPanelBoard.add(c);
    }
    
    if (gameTimer != null) {
        gameTimer.stop();
    }
    secondsPlayed = 0;
    Time.setText("Time: 0s");

    gameTimer = new javax.swing.Timer(1000, (e) -> {
        secondsPlayed++;
        Time.setText("Time: " + secondsPlayed + "s");
    });
    gameTimer.start();
    jPanelBoard.revalidate();
    jPanelBoard.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void stopTimer() {
    if (gameTimer != null) {
        gameTimer.stop();
    }
}
    private void cbSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSizeActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
      jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jButtonResetActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(() -> new MemoryGameForm().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Time;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelBoard;
    // End of variables declaration//GEN-END:variables

}