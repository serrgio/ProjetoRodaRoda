package jogorodaroda.Classe;

import jogorodaroda.Interface.TelaInicial;
import java.io.IOException;

/**
 * Classe responsável por iniciar o jogo "Roda roda"
 *
 * @author Geovane
 * @author José Sérgio
 * @version 1.0
 *
 */
public class Main {

    /**
     * Método responsável por iniciar o jogo
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @param args
     * @throws java.io.IOException
     *
     *
     */
    public static void main(String args[]) throws IOException {
        TelaInicial telaInicial = new TelaInicial();

        telaInicial.dispose();
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
        telaInicial.setLocationRelativeTo(null);

        Metodos metodos = new Metodos();
        metodos.audioInicial();
    }
}
