package jogorodaroda.Interface;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogorodaroda.Classe.Parametros;

/**
 * Classe responsável por iniciar a "TelaInicial"
 *
 * @author Geovane
 * @author José Sérgio
 * @version 1.0
 *
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSair = new javax.swing.JToggleButton();
        btIniciar = new javax.swing.JButton();
        comboEtapas = new javax.swing.JComboBox();
        comboJogador = new javax.swing.JComboBox();
        comboPalavras = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(897, 508));
        getContentPane().setLayout(null);

        btSair.setBackground(new java.awt.Color(255, 255, 255));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btSair.PNG"))); // NOI18N
        btSair.setSelected(true);
        btSair.setBorder(null);
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        getContentPane().add(btSair);
        btSair.setBounds(750, 430, 90, 40);

        btIniciar.setBackground(new java.awt.Color(255, 255, 255));
        btIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btIniciar.PNG"))); // NOI18N
        btIniciar.setBorderPainted(false);
        btIniciar.setContentAreaFilled(false);
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btIniciar);
        btIniciar.setBounds(600, 430, 140, 50);

        comboEtapas.setFont(new java.awt.Font("AR CENA", 1, 24)); // NOI18N
        comboEtapas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 Etapa", "2 Etapas", "3 Etapas", "4 Etapas", "5 Etapas", "6 Etapas", "7 Etapas" }));
        comboEtapas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboEtapas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(comboEtapas);
        comboEtapas.setBounds(640, 310, 210, 40);

        comboJogador.setFont(new java.awt.Font("AR CENA", 1, 24)); // NOI18N
        comboJogador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 Jogador", "2 Jogadores", "3 Jogadores" }));
        comboJogador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboJogador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(comboJogador);
        comboJogador.setBounds(640, 110, 210, 40);

        comboPalavras.setFont(new java.awt.Font("AR CENA", 1, 24)); // NOI18N
        comboPalavras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 Palavra", "2 Palavras", "3 Palavras" }));
        comboPalavras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboPalavras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(comboPalavras);
        comboPalavras.setBounds(640, 210, 210, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/ImagemTelaInicial.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 896, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        //Armazena parametros
        Parametros parametros = new Parametros();
        parametros.setQtdJogadores(comboJogador.getSelectedIndex());
        parametros.setQtdPalavras(comboPalavras.getSelectedIndex());
        parametros.setQtdEtapas(comboEtapas.getSelectedIndex());

        TelaJogadores jogadores = null;
        try {
            jogadores = new TelaJogadores(parametros.getQtdJogadores(), parametros.getQtdPalavras(), parametros.getQtdEtapas());
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        jogadores.dispose();
        jogadores.setVisible(true);
        jogadores.setLocationRelativeTo(null);
//                tresJogador.setExtendedState(MAXIMIZED_BOTH);
        dispose();

    }//GEN-LAST:event_btIniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.JToggleButton btSair;
    private javax.swing.JComboBox comboEtapas;
    private javax.swing.JComboBox comboJogador;
    private javax.swing.JComboBox comboPalavras;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
