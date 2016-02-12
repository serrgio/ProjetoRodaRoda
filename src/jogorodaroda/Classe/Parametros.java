package jogorodaroda.Classe;

/**
 * Classe com os parametros utilizado no jogo "Roda roda"
 *
 * @author Geovane
 * @author José Sérgio
 * @version 1.0
 *
 */
public class Parametros {

    static int qtdJogadores;
    static int qtdPalavras;
    static int qtdEtapas;

    /**
     * Método responsável por retornar a quantidade de jogadores
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @return int
     *
     */
    public int getQtdJogadores() {
        return qtdJogadores;
    }

    /**
     * Método responsável por receber a quantidade de jogadores
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @param qtdJogadores
     *
     */
    public void setQtdJogadores(int qtdJogadores) {
        Parametros.qtdJogadores = qtdJogadores;
    }

    /**
     * Método responsável por retornar a quantidade de palavras
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @return int
     *
     */
    public int getQtdPalavras() {
        return qtdPalavras;
    }

    /**
     * Método responsável por receber a quantidade de palavras
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @param qtdPalavras
     *
     */
    public void setQtdPalavras(int qtdPalavras) {
        Parametros.qtdPalavras = qtdPalavras;
    }

    /**
     * Método responsável por retornar a quantidade de etapas
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @return int
     *
     */
    public int getQtdEtapas() {
        return qtdEtapas;
    }

    /**
     * Método responsável por receber a quantidade de etapas
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @param qtdEtapas
     *
     */
    public void setQtdEtapas(int qtdEtapas) {
        Parametros.qtdEtapas = qtdEtapas;
    }
}
