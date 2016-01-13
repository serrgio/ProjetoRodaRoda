package jogorodaroda.Interface;

import javax.swing.ImageIcon;

/**
 *
 * @author GAOliveira
 */
public class TelaDoisJogadores extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaDoisJogadores() {
        initComponents();
    }
    
    public void imageRoleta() throws InterruptedException{
            
        for(int x = 1; x <= 5; x++){
            for(int i = 20; i >= 1; i--){

                ImageIcon img = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Roleta/"+i+".png"));
                roleta.setIcon(img);
                roleta.paint(getGraphics().create(279, 220, 480, 480));
                ImageIcon sel = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Seletor.png"));
                seletor.setIcon(sel);
                seletor.paint(getGraphics().create(499, 220, 41, 71));
                new Thread().sleep(100);          
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seletor = new javax.swing.JLabel();
        roleta = new javax.swing.JLabel();
        imagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo Roda a Roda");
        setPreferredSize(new java.awt.Dimension(1225, 720));
        getContentPane().setLayout(null);

        seletor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Seletor.png"))); // NOI18N
        getContentPane().add(seletor);
        seletor.setBounds(490, 190, 41, 60);

        roleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Roleta/1.png"))); // NOI18N
        getContentPane().add(roleta);
        roleta.setBounds(270, 190, 480, 480);

        imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Tela2Jogador.png"))); // NOI18N
        getContentPane().add(imagemFundo);
        imagemFundo.setBounds(0, 0, 1210, 683);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDoisJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoisJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoisJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoisJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDoisJogadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagemFundo;
    private javax.swing.JLabel roleta;
    private javax.swing.JLabel seletor;
    // End of variables declaration//GEN-END:variables
}
