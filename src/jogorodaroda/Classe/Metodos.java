package jogorodaroda.Classe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Classe com os métodos utilizado no jogo "Roda roda"
 *
 * @author Geovane
 * @author José Sérgio
 * @version 1.0
 *
 */
public class Metodos {

    /**
     * Método responsável executar o audio inicial do jogo
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     *
     */
    public void audioInicial() {

//        for(int i = 0; i < 1; i ++){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM = null;
        try {
            BGM = new AudioStream(new FileInputStream("AberturaJogo.wav"));
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }
        MGP.start(BGM);
    }

    /**
     * Método responsável executar o audio quando é selecionado uma letra errada
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     *
     */
    public void audioLetraErrada() {

//        for(int i = 0; i < 2; i ++){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM = null;
        try {
            BGM = new AudioStream(new FileInputStream("LetraErrada.wav"));
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }

        MGP.start(BGM);

//                try {
//                    Thread.sleep( 10000 ); // coloca a "thread" para "dormir"
//                } catch (InterruptedException e) {
//                    e.printStackTrace( System.err );
//                }
//        }
    }

    /**
     * Método responsável executar o audio da animação da roleta
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     *
     */
    public void audioRoleta() {

//        for(int i = 0; i < 2; i ++){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM = null;
        try {
            BGM = new AudioStream(new FileInputStream("Roleta.wav"));
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }

        MGP.start(BGM);

//                try {
//                    Thread.sleep( 10000 ); // coloca a "thread" para "dormir"
//                } catch (InterruptedException e) {
//                    e.printStackTrace( System.err );
//                }
//        }
    }

    /**
     * Método responsável executar o audio quando selecionaddo a letra correta
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     *
     */
    public void audioLetraCorreta() {

//        for(int i = 0; i < 2; i ++){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM = null;
        try {
            BGM = new AudioStream(new FileInputStream("LetraCorreta.wav"));
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }

        MGP.start(BGM);

//                try {
//                    Thread.sleep( 10000 ); // coloca a "thread" para "dormir"
//                } catch (InterruptedException e) {
//                    e.printStackTrace( System.err );
//                }
//        }
    }

    /**
     * Método responsável por buscar a plavra sorteada
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     * @param palavrasJaSorteadas
     * @return ArrayList
     * @throws java.io.IOException
     *
     */
    public ArrayList palavrasSorteadas(ArrayList palavrasJaSorteadas) throws IOException {
        ArrayList<String> listaPalavras = new ArrayList();
        ArrayList<String> p = new ArrayList();

        listaPalavras = LeitorArquivo.ler();
        p.add((String) listaPalavras.get(0));

        for (int i = 1; i <= 300; i++) {
            Random r = new Random();
            int aleatorio = r.nextInt(21) + 1;

            if (!palavrasJaSorteadas.contains(listaPalavras.get(aleatorio)) || !p.contains(listaPalavras.get(aleatorio))) {
                p.add((String) listaPalavras.get(aleatorio));
                if (p.size() > 3) {
                    i = 301; //Sair lo for
                }
            }
        }

        if (p.size() < 3) {
            palavrasSorteadas(palavrasJaSorteadas);
        }
        return p;
    }

}
