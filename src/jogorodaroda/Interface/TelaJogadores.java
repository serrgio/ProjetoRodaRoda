package jogorodaroda.Interface;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jogorodaroda.Classe.Metodos;

/**
 * Classe responsável por iniciar a "Tela dos jogadores"
 *
 * @author Geovane
 * @author José Sérgio
 * @version 1.0
 *
 */
public final class TelaJogadores extends javax.swing.JFrame {

    /**
     * Método responsável por criar a tela principal do jogo
     *
     * @author Geovane
     * @author José Sérgio
     * @version 1.0
     *
     */
    ArrayList<String> listaPalavras = new ArrayList();
    ArrayList<String> listapalavrasSorteadas = new ArrayList();
    ArrayList<String> listaPalavrasUsadasNoMomento = new ArrayList();
    String[] listaPosicaoLetrasEncontradasPalavra1;
    String[] listaPosicaoLetrasEncontradasPalavra2;
    String[] listaPosicaoLetrasEncontradasPalavra3;
    int valorReaisSorteado = 0;
    int jogadorCorrente = 1; //Jogador que está com a roleta
    int valorReaisAcumuladoJogadorCorrente = 0;
    int qtdPalavras;
    int qtdJogadores;
    boolean jogadorErrou = false; //Usada para passar o jogo para o proximo jogador se este errar a leta, passar ou perder tudo
    int qtdErrosJogador1 = 0;
    boolean respostaATiva = false;
    boolean jogador1EliminadoRodada = false;
    boolean jogador2EliminadoRodada = false;
    boolean jogador3EliminadoRodada = false;
    int etapaAtual = 1;

    int valorAcumuladoJogador1 = 0; //Variável usada para armazenar o valor acumulado durante todas as etapas
    int valorAcumuladoJogador2 = 0; //Variável usada para armazenar o valor acumulado durante todas as etapas
    int valorAcumuladoJogador3 = 0; //Variável usada para armazenar o valor acumulado durante todas as etapas

    public void qtdPalavras(int qtdpalavra) {
        switch (qtdpalavra) {

//            label.setOpaque(true); // Deixa a label opaca.
//            label.setBackground(Color.RED); // Muda a cor de fundo.
            case 1:

                p2l1.setBorder(null);
                p2l2.setBorder(null);
                p2l3.setBorder(null);
                p2l4.setBorder(null);
                p2l5.setBorder(null);
                p2l6.setBorder(null);
                p2l7.setBorder(null);
                p2l8.setBorder(null);
                p2l9.setBorder(null);
                p2l10.setBorder(null);
                p2l11.setBorder(null);
                p2l12.setBorder(null);
                p2l13.setBorder(null);
                p2l14.setBorder(null);
                p2l15.setBorder(null);

                p3l1.setBorder(null);
                p3l2.setBorder(null);
                p3l3.setBorder(null);
                p3l4.setBorder(null);
                p3l5.setBorder(null);
                p3l6.setBorder(null);
                p3l7.setBorder(null);
                p3l8.setBorder(null);
                p3l9.setBorder(null);
                p3l10.setBorder(null);
                p3l11.setBorder(null);
                p3l12.setBorder(null);
                p3l13.setBorder(null);
                p3l14.setBorder(null);
                p3l15.setBorder(null);

                break;

            case 2:

                p3l1.setBorder(null);
                p3l2.setBorder(null);
                p3l3.setBorder(null);
                p3l4.setBorder(null);
                p3l5.setBorder(null);
                p3l6.setBorder(null);
                p3l7.setBorder(null);
                p3l8.setBorder(null);
                p3l9.setBorder(null);
                p3l10.setBorder(null);
                p3l11.setBorder(null);
                p3l12.setBorder(null);
                p3l13.setBorder(null);
                p3l14.setBorder(null);
                p3l15.setBorder(null);

                break;

        }

    }

    public TelaJogadores(int jogadores, int palavras, int qtdetapas) throws IOException {
        initComponents();
        qtdPalavras = palavras;
        qtdJogadores = jogadores;
        saldoJogador1.setOpaque(true);
        saldoJogador1.setBackground(Color.WHITE);
        saldoJogador1.repaint();
        btAvancar.setVisible(false);

        escondeTecladoLetras();
        etapa.setText(etapaAtual + " / " + qtdetapas);

        switch (jogadores) {
            case 1:
                imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Tela1Jogador.png")));
                saldoJogador1.setText("0");
                qtdPalavras(palavras);

                break;

            case 2:
                imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Tela2Jogador.png")));
                saldoJogador1.setText("0");
                saldoJogador2.setText("0");
                qtdPalavras(palavras);
                break;

            case 3:
                imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Tela3Jogador.png")));
                saldoJogador1.setText("0");
                saldoJogador2.setText("0");
                saldoJogador3.setText("0");
                break;
        }

        listaPalavrasUsadasNoMomento = guardaPalavrasSorteadas();
        this.listaPosicaoLetrasEncontradasPalavra1 = new String[(listaPalavrasUsadasNoMomento.get(1)).length()]; //Pega tamanho da palavra sorteada;
        this.listaPosicaoLetrasEncontradasPalavra2 = new String[(listaPalavrasUsadasNoMomento.get(2)).length()]; //Pega tamanho da palavra sorteada;
        this.listaPosicaoLetrasEncontradasPalavra3 = new String[(listaPalavrasUsadasNoMomento.get(3)).length()]; //Pega tamanho da palavra sorteada;

    }

    private TelaJogadores() {
    }

    public int rodarRoleta() throws InterruptedException {

        Random random = new Random();
//        int aleatorio = random.nextInt(3) + 2;
        int sorteRoleta = random.nextInt(20) + 1;

        for (int x = 1; x <= 4; x++) {
            if (x != 4) {
                for (int i = 20; i >= 1; i--) {

                    ImageIcon img = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Roleta/" + i + ".png"));
                    roleta.setIcon(img);
                    roleta.paint(getGraphics().create(247, 231, 480, 480));
                    ImageIcon sel = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Seletor.png"));
                    seletor.setIcon(sel);
                    seletor.paint(getGraphics().create(468, 231, 41, 71));
                    new Thread().sleep(x * 50);

                }
            } else {

                for (int i = 20; i >= sorteRoleta; i--) {

                    ImageIcon img = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Roleta/" + i + ".png"));
                    roleta.setIcon(img);
                    roleta.paint(getGraphics().create(247, 231, 480, 480));
                    ImageIcon sel = new ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Seletor.png"));
                    seletor.setIcon(sel);
                    seletor.paint(getGraphics().create(468, 231, 41, 71));
                    new Thread().sleep(x * 50);

                }

            }
        }

        return sorteRoleta;
    }

    public ArrayList guardaPalavrasSorteadas() throws IOException {
        Metodos m = new Metodos();
        int tamanhoPalavra1;
        int tamanhoPalavra2;
        int tamanhoPalavra3;

        listapalavrasSorteadas = m.palavrasSorteadas(listaPalavras);
        dica.setText(listapalavrasSorteadas.get(0));
        for (Object palavrasorteadas : listapalavrasSorteadas) {
            listaPalavras.add((String) palavrasorteadas);
        }

        switch (qtdPalavras) {
            case 1:
                tamanhoPalavra1 = (listapalavrasSorteadas.get(1)).length();
                if (tamanhoPalavra1 >= 1) {
                    p1l1.setOpaque(true); // Deixa a label opaca.
                    p1l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 2) {
                    p1l2.setOpaque(true); // Deixa a label opaca.
                    p1l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 3) {
                    p1l3.setOpaque(true); // Deixa a label opaca.
                    p1l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 4) {
                    p1l4.setOpaque(true); // Deixa a label opaca.
                    p1l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 5) {
                    p1l5.setOpaque(true); // Deixa a label opaca.
                    p1l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 6) {
                    p1l6.setOpaque(true); // Deixa a label opaca.
                    p1l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 7) {
                    p1l7.setOpaque(true); // Deixa a label opaca.
                    p1l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 8) {
                    p1l8.setOpaque(true); // Deixa a label opaca.
                    p1l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 9) {
                    p1l9.setOpaque(true); // Deixa a label opaca.
                    p1l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 10) {
                    p1l10.setOpaque(true); // Deixa a label opaca.
                    p1l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 11) {
                    p1l11.setOpaque(true); // Deixa a label opaca.
                    p1l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 12) {
                    p1l12.setOpaque(true); // Deixa a label opaca.
                    p1l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 13) {
                    p1l13.setOpaque(true); // Deixa a label opaca.
                    p1l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 14) {
                    p1l14.setOpaque(true); // Deixa a label opaca.
                    p1l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 15) {
                    p1l15.setOpaque(true); // Deixa a label opaca.
                    p1l15.setBackground(Color.white); // Muda a cor de fundo.
                }
                break;

            case 2:
                tamanhoPalavra1 = (listapalavrasSorteadas.get(1)).length();
                tamanhoPalavra2 = (listapalavrasSorteadas.get(2)).length();

                if (tamanhoPalavra1 >= 1) {
                    p1l1.setOpaque(true); // Deixa a label opaca.
                    p1l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 2) {
                    p1l2.setOpaque(true); // Deixa a label opaca.
                    p1l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 3) {
                    p1l3.setOpaque(true); // Deixa a label opaca.
                    p1l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 4) {
                    p1l4.setOpaque(true); // Deixa a label opaca.
                    p1l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 5) {
                    p1l5.setOpaque(true); // Deixa a label opaca.
                    p1l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 6) {
                    p1l6.setOpaque(true); // Deixa a label opaca.
                    p1l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 7) {
                    p1l7.setOpaque(true); // Deixa a label opaca.
                    p1l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 8) {
                    p1l8.setOpaque(true); // Deixa a label opaca.
                    p1l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 9) {
                    p1l9.setOpaque(true); // Deixa a label opaca.
                    p1l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 10) {
                    p1l10.setOpaque(true); // Deixa a label opaca.
                    p1l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 11) {
                    p1l11.setOpaque(true); // Deixa a label opaca.
                    p1l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 12) {
                    p1l12.setOpaque(true); // Deixa a label opaca.
                    p1l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 13) {
                    p1l13.setOpaque(true); // Deixa a label opaca.
                    p1l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 14) {
                    p1l14.setOpaque(true); // Deixa a label opaca.
                    p1l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 15) {
                    p1l15.setOpaque(true); // Deixa a label opaca.
                    p1l15.setBackground(Color.white); // Muda a cor de fundo.
                }

                if (tamanhoPalavra2 >= 1) {
                    p2l1.setOpaque(true); // Deixa a label opaca.
                    p2l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 2) {
                    p2l2.setOpaque(true); // Deixa a label opaca.
                    p2l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 3) {
                    p2l3.setOpaque(true); // Deixa a label opaca.
                    p2l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 4) {
                    p2l4.setOpaque(true); // Deixa a label opaca.
                    p2l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 5) {
                    p2l5.setOpaque(true); // Deixa a label opaca.
                    p2l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 6) {
                    p2l6.setOpaque(true); // Deixa a label opaca.
                    p2l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 7) {
                    p2l7.setOpaque(true); // Deixa a label opaca.
                    p2l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 8) {
                    p2l8.setOpaque(true); // Deixa a label opaca.
                    p2l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 9) {
                    p2l9.setOpaque(true); // Deixa a label opaca.
                    p2l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 10) {
                    p2l10.setOpaque(true); // Deixa a label opaca.
                    p2l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 11) {
                    p2l11.setOpaque(true); // Deixa a label opaca.
                    p2l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 12) {
                    p2l12.setOpaque(true); // Deixa a label opaca.
                    p2l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 13) {
                    p2l13.setOpaque(true); // Deixa a label opaca.
                    p2l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 14) {
                    p2l14.setOpaque(true); // Deixa a label opaca.
                    p2l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 15) {
                    p2l15.setOpaque(true); // Deixa a label opaca.
                    p2l15.setBackground(Color.white); // Muda a cor de fundo.
                }
                break;

            case 3:
                tamanhoPalavra1 = (listapalavrasSorteadas.get(1)).length();
                tamanhoPalavra2 = (listapalavrasSorteadas.get(2)).length();
                tamanhoPalavra3 = (listapalavrasSorteadas.get(3)).length();

                if (tamanhoPalavra1 >= 1) {
                    p1l1.setOpaque(true); // Deixa a label opaca.
                    p1l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 2) {
                    p1l2.setOpaque(true); // Deixa a label opaca.
                    p1l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 3) {
                    p1l3.setOpaque(true); // Deixa a label opaca.
                    p1l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 4) {
                    p1l4.setOpaque(true); // Deixa a label opaca.
                    p1l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 5) {
                    p1l5.setOpaque(true); // Deixa a label opaca.
                    p1l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 6) {
                    p1l6.setOpaque(true); // Deixa a label opaca.
                    p1l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 7) {
                    p1l7.setOpaque(true); // Deixa a label opaca.
                    p1l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 8) {
                    p1l8.setOpaque(true); // Deixa a label opaca.
                    p1l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 9) {
                    p1l9.setOpaque(true); // Deixa a label opaca.
                    p1l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 10) {
                    p1l10.setOpaque(true); // Deixa a label opaca.
                    p1l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 11) {
                    p1l11.setOpaque(true); // Deixa a label opaca.
                    p1l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 12) {
                    p1l12.setOpaque(true); // Deixa a label opaca.
                    p1l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 13) {
                    p1l13.setOpaque(true); // Deixa a label opaca.
                    p1l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 14) {
                    p1l14.setOpaque(true); // Deixa a label opaca.
                    p1l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra1 >= 15) {
                    p1l15.setOpaque(true); // Deixa a label opaca.
                    p1l15.setBackground(Color.white); // Muda a cor de fundo.
                }

                if (tamanhoPalavra2 >= 1) {
                    p2l1.setOpaque(true); // Deixa a label opaca.
                    p2l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 2) {
                    p2l2.setOpaque(true); // Deixa a label opaca.
                    p2l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 3) {
                    p2l3.setOpaque(true); // Deixa a label opaca.
                    p2l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 4) {
                    p2l4.setOpaque(true); // Deixa a label opaca.
                    p2l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 5) {
                    p2l5.setOpaque(true); // Deixa a label opaca.
                    p2l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 6) {
                    p2l6.setOpaque(true); // Deixa a label opaca.
                    p2l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 7) {
                    p2l7.setOpaque(true); // Deixa a label opaca.
                    p2l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 8) {
                    p2l8.setOpaque(true); // Deixa a label opaca.
                    p2l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 9) {
                    p2l9.setOpaque(true); // Deixa a label opaca.
                    p2l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 10) {
                    p2l10.setOpaque(true); // Deixa a label opaca.
                    p2l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 11) {
                    p2l11.setOpaque(true); // Deixa a label opaca.
                    p2l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 12) {
                    p2l12.setOpaque(true); // Deixa a label opaca.
                    p2l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 13) {
                    p2l13.setOpaque(true); // Deixa a label opaca.
                    p2l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 14) {
                    p2l14.setOpaque(true); // Deixa a label opaca.
                    p2l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra2 >= 15) {
                    p2l15.setOpaque(true); // Deixa a label opaca.
                    p2l15.setBackground(Color.white); // Muda a cor de fundo.
                }

                if (tamanhoPalavra3 >= 1) {
                    p3l1.setOpaque(true); // Deixa a label opaca.
                    p3l1.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 2) {
                    p3l2.setOpaque(true); // Deixa a label opaca.
                    p3l2.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 3) {
                    p3l3.setOpaque(true); // Deixa a label opaca.
                    p3l3.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 4) {
                    p3l4.setOpaque(true); // Deixa a label opaca.
                    p3l4.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 5) {
                    p3l5.setOpaque(true); // Deixa a label opaca.
                    p3l5.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 6) {
                    p3l6.setOpaque(true); // Deixa a label opaca.
                    p3l6.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 7) {
                    p3l7.setOpaque(true); // Deixa a label opaca.
                    p3l7.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 8) {
                    p3l8.setOpaque(true); // Deixa a label opaca.
                    p3l8.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 9) {
                    p3l9.setOpaque(true); // Deixa a label opaca.
                    p3l9.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 10) {
                    p3l10.setOpaque(true); // Deixa a label opaca.
                    p3l10.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 11) {
                    p3l11.setOpaque(true); // Deixa a label opaca.
                    p3l11.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 12) {
                    p3l12.setOpaque(true); // Deixa a label opaca.
                    p3l12.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 13) {
                    p3l13.setOpaque(true); // Deixa a label opaca.
                    p3l13.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 14) {
                    p3l14.setOpaque(true); // Deixa a label opaca.
                    p3l14.setBackground(Color.white); // Muda a cor de fundo.
                }
                if (tamanhoPalavra3 >= 15) {
                    p3l15.setOpaque(true); // Deixa a label opaca.
                    p3l15.setBackground(Color.white); // Muda a cor de fundo.
                }
                break;
        }

        return listapalavrasSorteadas;
    }

    public void letraSelecionada(String letraEscolhida, ArrayList palavrasEtapa, int qtdPalavras) {
        String palavra1;
        String palavra2;
        String palavra3;
        String achouLetra;
        palavra1 = palavrasEtapa.get(1).toString();
        palavra2 = palavrasEtapa.get(2).toString();
        palavra3 = palavrasEtapa.get(3).toString();
        valorReaisAcumuladoJogadorCorrente = 0;
        boolean encontrouLetraPalavraAnterior1 = true;
        boolean encontrouLetraPalavraAnterior2 = true;
        boolean encontrouLetra = true;

        Metodos metodos = new Metodos();

        switch (qtdPalavras) {
            case 1:
                System.err.println(palavra1);
                for (int i = 0; i < palavra1.length(); i++) {
                    achouLetra = palavra1.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra1[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }

                        if (encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                            encontrouLetra = false;
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra1[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra1[i] = " ";
                    }

                }

                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida)) {//Se jogador errar pula para proximo jogador
                    jogadorErrou = true;
                    qtdErrosJogador1 = qtdErrosJogador1 + 1;
                    metodos.audioLetraErrada();

                }

                if (respostaATiva == true) {//Trata resposta do jogador
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida)) {
                        if (qtdJogadores == 1) {
                            JOptionPane.showMessageDialog(null, "Você perdeu, pratique mais!");
                            saldoJogador1.setOpaque(true);
                            saldoJogador1.setBackground(Color.red);
                            saldoJogador1.repaint();
                            jogador1EliminadoRodada = true;
                            escondeTecladoLetras();
                        } else {
//                            if(jogadorCorrente == 1){
//                                saldoJogador1.setOpaque(true);
//                                saldoJogador1.setBackground(Color.red);
//                                saldoJogador1.repaint();
//                                jogador1EliminadoRodada = true;
//                                escondeTecladoLetras();
//                            }
                            //                        else if(jogadorCorrente == 2){
                            //                            saldoJogador2.setOpaque(true);
                            //                            saldoJogador2.setBackground(Color.red);
                            //                            saldoJogador2.repaint();  
                            //                            jogador2EliminadoRodada = true;
                            //                        }
                            //                        else if(jogadorCorrente == 3){
                            //                            saldoJogador3.setOpaque(true);
                            //                            saldoJogador3.setBackground(Color.red);
                            //                            saldoJogador3.repaint();
                            //                            jogador3EliminadoRodada = true;
                            //                        }
//                        
                            escondeTecladoLetras();
                            roleta.setEnabled(true);
                            respostaATiva = false;
                            btResponder.setEnabled(true);
                        }
                    } else {
                        btRodar.setEnabled(false);
                        mostraTecladoLetras();
                    }

                }

                try {
                    p1l1.setText(listaPosicaoLetrasEncontradasPalavra1[0]);
                    p1l2.setText(listaPosicaoLetrasEncontradasPalavra1[1]);
                    p1l3.setText(listaPosicaoLetrasEncontradasPalavra1[2]);
                    p1l4.setText(listaPosicaoLetrasEncontradasPalavra1[3]);
                    p1l5.setText(listaPosicaoLetrasEncontradasPalavra1[4]);
                    p1l6.setText(listaPosicaoLetrasEncontradasPalavra1[5]);
                    p1l7.setText(listaPosicaoLetrasEncontradasPalavra1[6]);
                    p1l8.setText(listaPosicaoLetrasEncontradasPalavra1[7]);
                    p1l9.setText(listaPosicaoLetrasEncontradasPalavra1[8]);
                    p1l10.setText(listaPosicaoLetrasEncontradasPalavra1[9]);
                    p1l11.setText(listaPosicaoLetrasEncontradasPalavra1[10]);
                    p1l12.setText(listaPosicaoLetrasEncontradasPalavra1[11]);
                    p1l13.setText(listaPosicaoLetrasEncontradasPalavra1[12]);
                    p1l14.setText(listaPosicaoLetrasEncontradasPalavra1[13]);
                    p1l15.setText(listaPosicaoLetrasEncontradasPalavra1[14]);
                } catch (Exception ex) {

                }

                break;

            case 2:
                System.err.println(palavra1);
                for (int i = 0; i < palavra1.length(); i++) {
                    achouLetra = palavra1.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra1[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }
                        if (encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                            encontrouLetra = false;
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra1[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra1[i] = " ";
                    }

                }
                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida)) {//Se jogador errar pula para proximo jogador
//                    jogadorErrou = true;
                    encontrouLetraPalavraAnterior1 = false;
                }

                System.err.println(palavra2);
                for (int i = 0; i < palavra2.length(); i++) {
                    achouLetra = palavra2.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra2[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }
                        if (encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                            encontrouLetra = false;
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra2[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra2[i] = " ";
                    }

                }

                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(letraEscolhida) && encontrouLetraPalavraAnterior1 == false) {//Se jogador errar pula para proximo jogador
                    jogadorErrou = true;
                    qtdErrosJogador1 = qtdErrosJogador1 + 1;
                    metodos.audioLetraErrada();

                }

                if (respostaATiva == true) {//Trata resposta do jogador
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(letraEscolhida)) {
                        if (qtdJogadores == 1) {
                            JOptionPane.showMessageDialog(null, "Você perdeu, pratique mais!");
                            saldoJogador1.setOpaque(true);
                            saldoJogador1.setBackground(Color.red);
                            saldoJogador1.repaint();
                            jogador1EliminadoRodada = true;
                            escondeTecladoLetras();
                        } else {
//                        else if(jogadorCorrente == 2){
//                            saldoJogador2.setOpaque(true);
//                            saldoJogador2.setBackground(Color.red);
//                            saldoJogador2.repaint();   
//                            jogador2EliminadoRodada = true;
//                        }
//                        else if(jogadorCorrente == 3){
//                            saldoJogador3.setOpaque(true);
//                            saldoJogador3.setBackground(Color.red);
//                            saldoJogador3.repaint(); 
//                            jogador3EliminadoRodada = true;
//                        }
//                        
                            escondeTecladoLetras();
                            roleta.setEnabled(true);
                            respostaATiva = false;
                            btResponder.setEnabled(true);
                        }
                    } else {
                        btRodar.setEnabled(false);
                        mostraTecladoLetras();
                    }

                }

                try {

                    p1l1.setText(listaPosicaoLetrasEncontradasPalavra1[0]);
                    p1l2.setText(listaPosicaoLetrasEncontradasPalavra1[1]);
                    p1l3.setText(listaPosicaoLetrasEncontradasPalavra1[2]);
                    p1l4.setText(listaPosicaoLetrasEncontradasPalavra1[3]);
                    p1l5.setText(listaPosicaoLetrasEncontradasPalavra1[4]);
                    p1l6.setText(listaPosicaoLetrasEncontradasPalavra1[5]);
                    p1l7.setText(listaPosicaoLetrasEncontradasPalavra1[6]);
                    p1l8.setText(listaPosicaoLetrasEncontradasPalavra1[7]);
                    p1l9.setText(listaPosicaoLetrasEncontradasPalavra1[8]);
                    p1l10.setText(listaPosicaoLetrasEncontradasPalavra1[9]);
                    p1l11.setText(listaPosicaoLetrasEncontradasPalavra1[10]);
                    p1l12.setText(listaPosicaoLetrasEncontradasPalavra1[11]);
                    p1l13.setText(listaPosicaoLetrasEncontradasPalavra1[12]);
                    p1l14.setText(listaPosicaoLetrasEncontradasPalavra1[13]);
                    p1l15.setText(listaPosicaoLetrasEncontradasPalavra1[14]);
                } catch (Exception ex) {
                }

                try {
                    p2l1.setText(listaPosicaoLetrasEncontradasPalavra2[0]);
                    p2l2.setText(listaPosicaoLetrasEncontradasPalavra2[1]);
                    p2l3.setText(listaPosicaoLetrasEncontradasPalavra2[2]);
                    p2l4.setText(listaPosicaoLetrasEncontradasPalavra2[3]);
                    p2l5.setText(listaPosicaoLetrasEncontradasPalavra2[4]);
                    p2l6.setText(listaPosicaoLetrasEncontradasPalavra2[5]);
                    p2l7.setText(listaPosicaoLetrasEncontradasPalavra2[6]);
                    p2l8.setText(listaPosicaoLetrasEncontradasPalavra2[7]);
                    p2l9.setText(listaPosicaoLetrasEncontradasPalavra2[8]);
                    p2l10.setText(listaPosicaoLetrasEncontradasPalavra2[9]);
                    p2l11.setText(listaPosicaoLetrasEncontradasPalavra2[10]);
                    p2l12.setText(listaPosicaoLetrasEncontradasPalavra2[11]);
                    p2l13.setText(listaPosicaoLetrasEncontradasPalavra2[12]);
                    p2l14.setText(listaPosicaoLetrasEncontradasPalavra2[13]);
                    p2l15.setText(listaPosicaoLetrasEncontradasPalavra2[14]);
                } catch (Exception ex) {
                }

                break;

            case 3:
                boolean validaSeEncontrou1 = false;
                boolean validaSeEncontrou2 = false;
                boolean validaSeErrou1 = false;
                boolean validaSeErrou2 = false;
                System.err.println(palavra1);
                for (int i = 0; i < palavra1.length(); i++) {
                    achouLetra = palavra1.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra1[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }
                        if (encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                            encontrouLetra = false;
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra1[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra1[i] = " ";
                    }

                }

                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida)) {//Se jogador errar pula para proximo jogador
                    encontrouLetraPalavraAnterior1 = false;
                }

                System.err.println(palavra2);
                for (int i = 0; i < palavra2.length(); i++) {
                    achouLetra = palavra2.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra2[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }
                        if (encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                            encontrouLetra = false;
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra2[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra2[i] = " ";
                    }

                }

                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(letraEscolhida)) {//Se jogador errar pula para proximo jogador
                    encontrouLetraPalavraAnterior2 = false;
                }

                System.err.println(palavra3);
                for (int i = 0; i < palavra3.length(); i++) {
                    achouLetra = palavra3.substring(i, i + 1);

                    if (achouLetra.equals(letraEscolhida)) {
                        listaPosicaoLetrasEncontradasPalavra3[i] = letraEscolhida;
                        if (valorReaisSorteado > 0) {
                            valorReaisAcumuladoJogadorCorrente = valorReaisAcumuladoJogadorCorrente + valorReaisSorteado; //valor da roleta * quantidade de letras encontradas + valor já acumulado
                        }
                        if (encontrouLetra == true && encontrouLetra == true) {
                            metodos.audioLetraCorreta();
                        }
                    } else if (listaPosicaoLetrasEncontradasPalavra3[i] == " ") {
                        listaPosicaoLetrasEncontradasPalavra3[i] = " ";
                    }

                }

                if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra3).contains(letraEscolhida) && encontrouLetraPalavraAnterior1 == false && encontrouLetraPalavraAnterior2 == false) {//Se jogador errar pula para proximo jogador
                    jogadorErrou = true;
                    qtdErrosJogador1 = qtdErrosJogador1 + 1;
                    metodos.audioLetraErrada();

                }

                if (respostaATiva == true) {//Trata resposta do jogador
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(letraEscolhida) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra3).contains(letraEscolhida)) {
                        if (qtdJogadores == 1) {
                            JOptionPane.showMessageDialog(null, "Você perdeu, pratique mais!");
                            saldoJogador1.setOpaque(true);
                            saldoJogador1.setBackground(Color.red);
                            saldoJogador1.repaint();
                            jogador1EliminadoRodada = true;
                            escondeTecladoLetras();
                        } else {
//                        else if(jogadorCorrente == 2){
//                            saldoJogador2.setOpaque(true);
//                            saldoJogador2.setBackground(Color.red);
//                            saldoJogador2.repaint();   
//                            jogador2EliminadoRodada = true;
//                        }
//                        else if(jogadorCorrente == 3){
//                            saldoJogador3.setOpaque(true);
//                            saldoJogador3.setBackground(Color.red);
//                            saldoJogador3.repaint();
//                            jogador3EliminadoRodada = true;
//                        }
//                        
                            escondeTecladoLetras();
                            roleta.setEnabled(true);
                            respostaATiva = false;
                            btResponder.setEnabled(true);
                        }
                    } else {
                        btRodar.setEnabled(false);
                        mostraTecladoLetras();
                    }

                }

                try {
                    p1l1.setText(listaPosicaoLetrasEncontradasPalavra1[0]);
                    p1l2.setText(listaPosicaoLetrasEncontradasPalavra1[1]);
                    p1l3.setText(listaPosicaoLetrasEncontradasPalavra1[2]);
                    p1l4.setText(listaPosicaoLetrasEncontradasPalavra1[3]);
                    p1l5.setText(listaPosicaoLetrasEncontradasPalavra1[4]);
                    p1l6.setText(listaPosicaoLetrasEncontradasPalavra1[5]);
                    p1l7.setText(listaPosicaoLetrasEncontradasPalavra1[6]);
                    p1l8.setText(listaPosicaoLetrasEncontradasPalavra1[7]);
                    p1l9.setText(listaPosicaoLetrasEncontradasPalavra1[8]);
                    p1l10.setText(listaPosicaoLetrasEncontradasPalavra1[9]);
                    p1l11.setText(listaPosicaoLetrasEncontradasPalavra1[10]);
                    p1l12.setText(listaPosicaoLetrasEncontradasPalavra1[11]);
                    p1l13.setText(listaPosicaoLetrasEncontradasPalavra1[12]);
                    p1l14.setText(listaPosicaoLetrasEncontradasPalavra1[13]);
                    p1l15.setText(listaPosicaoLetrasEncontradasPalavra1[14]);
                } catch (Exception ex) {
                }

                try {
                    p2l1.setText(listaPosicaoLetrasEncontradasPalavra2[0]);
                    p2l2.setText(listaPosicaoLetrasEncontradasPalavra2[1]);
                    p2l3.setText(listaPosicaoLetrasEncontradasPalavra2[2]);
                    p2l4.setText(listaPosicaoLetrasEncontradasPalavra2[3]);
                    p2l5.setText(listaPosicaoLetrasEncontradasPalavra2[4]);
                    p2l6.setText(listaPosicaoLetrasEncontradasPalavra2[5]);
                    p2l7.setText(listaPosicaoLetrasEncontradasPalavra2[6]);
                    p2l8.setText(listaPosicaoLetrasEncontradasPalavra2[7]);
                    p2l9.setText(listaPosicaoLetrasEncontradasPalavra2[8]);
                    p2l10.setText(listaPosicaoLetrasEncontradasPalavra2[9]);
                    p2l11.setText(listaPosicaoLetrasEncontradasPalavra2[10]);
                    p2l12.setText(listaPosicaoLetrasEncontradasPalavra2[11]);
                    p2l13.setText(listaPosicaoLetrasEncontradasPalavra2[12]);
                    p2l14.setText(listaPosicaoLetrasEncontradasPalavra2[13]);
                    p2l15.setText(listaPosicaoLetrasEncontradasPalavra2[14]);
                } catch (Exception ex) {
                }

                try {
                    p3l1.setText(listaPosicaoLetrasEncontradasPalavra3[0]);
                    p3l2.setText(listaPosicaoLetrasEncontradasPalavra3[1]);
                    p3l3.setText(listaPosicaoLetrasEncontradasPalavra3[2]);
                    p3l4.setText(listaPosicaoLetrasEncontradasPalavra3[3]);
                    p3l5.setText(listaPosicaoLetrasEncontradasPalavra3[4]);
                    p3l6.setText(listaPosicaoLetrasEncontradasPalavra3[5]);
                    p3l7.setText(listaPosicaoLetrasEncontradasPalavra3[6]);
                    p3l8.setText(listaPosicaoLetrasEncontradasPalavra3[7]);
                    p3l9.setText(listaPosicaoLetrasEncontradasPalavra3[8]);
                    p3l10.setText(listaPosicaoLetrasEncontradasPalavra3[9]);
                    p3l11.setText(listaPosicaoLetrasEncontradasPalavra3[10]);
                    p3l12.setText(listaPosicaoLetrasEncontradasPalavra3[11]);
                    p3l13.setText(listaPosicaoLetrasEncontradasPalavra3[12]);
                    p3l14.setText(listaPosicaoLetrasEncontradasPalavra3[13]);
                    p3l15.setText(listaPosicaoLetrasEncontradasPalavra3[14]);
                } catch (Exception ex) {

                }

                break;
        }
        if (respostaATiva == false) {
            switch (qtdPalavras) {//Valida se jogador corrente canhou a partida acertando todas as letras
                case 1:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + (valorAcumuladoJogador1) + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }

                        }
                    }

                    break;

                case 2:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }
                        }

                    }
                    break;

                case 3:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra3).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }
                        }

                    }
                    break;
            }
        }

        if (respostaATiva == true) { //Valida se jogador corrente canhou a partida respondendo as palavras
            switch (qtdPalavras) {
                case 1:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }
                        }

                    }
                    break;

                case 2:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }
                        }

                    }
                    break;

                case 3:
                    if (!Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra2).contains(null) && !Arrays.asList(listaPosicaoLetrasEncontradasPalavra3).contains(null)) {
                        JOptionPane.showMessageDialog(null, "Jogador " + jogadorCorrente + " ganhou a rodada!");
                        escondeTecladoLetras();
                        btRodar.setVisible(false);
                        btResponder.setVisible(false);
                        btAvancar.setVisible(true);

                        if (jogadorCorrente == 1) {
                            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
                        } else if (jogadorCorrente == 2) {
                            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
                        } else if (jogadorCorrente == 3) {
                            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
                        }

                        if (Integer.parseInt(etapa.getText().substring(0, 1)) == Integer.parseInt(etapa.getText().substring(4, 5))) {
                            btAvancar.setVisible(false);

                            if (valorAcumuladoJogador1 > valorAcumuladoJogador2 && valorAcumuladoJogador1 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Mister Bim ganhou!");
                            }
                            if (valorAcumuladoJogador2 > valorAcumuladoJogador1 && valorAcumuladoJogador2 > valorAcumuladoJogador3) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Dilma ganhou!");
                            }
                            if (valorAcumuladoJogador3 > valorAcumuladoJogador1 && valorAcumuladoJogador3 > valorAcumuladoJogador2) {
                                JOptionPane.showMessageDialog(null, "Resultado: Mister Bim: " + valorAcumuladoJogador1 + "\n"
                                        + "Dilma: " + valorAcumuladoJogador2 + "\n"
                                        + "Barack Obama: " + valorAcumuladoJogador3 + "\n"
                                        + "Fim de jogo, jogador Barack Obama ganhou!");
                            }
                        }

                    }
                    break;
            }
        }

        if (respostaATiva == false) {
            trataPontuacaoJogadores();
        }

    }

    public void escondeTecladoLetras() {
        btA.setVisible(false);
        btB.setVisible(false);
        btC.setVisible(false);
        btD.setVisible(false);
        btE.setVisible(false);
        btF.setVisible(false);
        btG.setVisible(false);
        btH.setVisible(false);
        btI.setVisible(false);
        btJ.setVisible(false);
        btK.setVisible(false);
        btL.setVisible(false);
        btM.setVisible(false);
        btN.setVisible(false);
        btO.setVisible(false);
        btP.setVisible(false);
        btQ.setVisible(false);
        btR.setVisible(false);
        btS.setVisible(false);
        btT.setVisible(false);
        btU.setVisible(false);
        btV.setVisible(false);
        btX.setVisible(false);
        btW.setVisible(false);
        btY.setVisible(false);
        btZ.setVisible(false);

        btRodar.setEnabled(true);
        btResponder.setEnabled(true);
    }

    public void mostraTecladoLetras() {
        btA.setVisible(true);
        btB.setVisible(true);
        btC.setVisible(true);
        btD.setVisible(true);
        btE.setVisible(true);
        btF.setVisible(true);
        btG.setVisible(true);
        btH.setVisible(true);
        btI.setVisible(true);
        btJ.setVisible(true);
        btK.setVisible(true);
        btL.setVisible(true);
        btM.setVisible(true);
        btN.setVisible(true);
        btO.setVisible(true);
        btP.setVisible(true);
        btQ.setVisible(true);
        btR.setVisible(true);
        btS.setVisible(true);
        btT.setVisible(true);
        btU.setVisible(true);
        btV.setVisible(true);
        btX.setVisible(true);
        btW.setVisible(true);
        btY.setVisible(true);
        btZ.setVisible(true);

        btResponder.setEnabled(false);
    }

    public void trataPontuacaoJogadores() {
        saldoJogador1.setBackground(Color.WHITE);
        saldoJogador2.setBackground(Color.WHITE);
        saldoJogador3.setBackground(Color.WHITE);

        switch (qtdJogadores) {

            case 1:
                saldoJogador1.setOpaque(true);
                if (qtdErrosJogador1 > 3) {
                    JOptionPane.showMessageDialog(null, "Você perdeu, pratique mais!");
                    btRodar.setEnabled(false);
                    btResponder.setEnabled(false);
                } else {
                    saldoJogador1.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador1.getText())));
                }
                break;

            case 2:
                boolean validador = false;//Usado para não deixar entrar 2 vezes na logica do jogador 1
                if (jogadorErrou == true && jogadorCorrente == 1) { //caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 2;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();

                }

                if (jogadorCorrente == 1) {
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    validador = true;

                    if (valorReaisSorteado < 0) {
                        saldoJogador1.setText("0");
                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 2;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(false);
                        saldoJogador2.setOpaque(true);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                    }

                    saldoJogador1.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador1.getText())));
                }

                if (jogadorErrou == true && jogadorCorrente == 2) {//caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 1;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();

                }

                if (jogadorCorrente == 2) {
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();

                    if (valorReaisSorteado < 0) {
                        saldoJogador2.setText("0");
                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 1;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(true);
                        saldoJogador2.setOpaque(false);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                    }
                    saldoJogador2.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador2.getText())));
                }

                if (jogadorErrou == true && jogadorCorrente == 1) { //caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 2;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();

                }

                if (jogadorCorrente == 1 && validador == false) {
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();

                    if (valorReaisSorteado < 0) {
                        saldoJogador1.setText("0");
                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 2;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(false);
                        saldoJogador2.setOpaque(true);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                    }

                    saldoJogador1.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador1.getText())));
                }

                break;

            case 3:
                boolean validador2 = false;//Usado para não deixar entrar 2 vezes na logica do jogador 1
                if (jogadorErrou == true && jogadorCorrente == 1) {//caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 2;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                }

                if (jogadorCorrente == 1) {
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                    validador2 = true;

                    if (valorReaisSorteado < 0) {
                        saldoJogador1.setText("0");

                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 2;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(false);
                        saldoJogador2.setOpaque(true);
                        saldoJogador3.setOpaque(false);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                        saldoJogador3.repaint();
                    }
                    saldoJogador1.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador1.getText())));
                }

                if (jogadorErrou == true && jogadorCorrente == 2) {//caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 3;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                }

                if (jogadorCorrente == 2 && jogadorErrou == false) {
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();

                    if (valorReaisSorteado < 0) {
                        saldoJogador2.setText("0");
                    }
                    if (valorReaisSorteado == 0) {//caso jogador corrente erre a letra passa a vez para o proximo
                        jogadorCorrente = 3;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(false);
                        saldoJogador2.setOpaque(false);
                        saldoJogador3.setOpaque(true);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                        saldoJogador3.repaint();
                    }
                    saldoJogador2.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador2.getText())));
                }

                if (jogadorErrou == true && jogadorCorrente == 3) {
                    jogadorCorrente = 1;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                }

                if (jogadorCorrente == 3) {
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();

                    if (valorReaisSorteado < 0) {
                        saldoJogador3.setText("0");
                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 1;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(true);
                        saldoJogador2.setOpaque(false);
                        saldoJogador3.setOpaque(false);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                        saldoJogador3.repaint();

                    }
                    saldoJogador3.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador3.getText())));
                }

                if (jogadorErrou == true && jogadorCorrente == 1) {//caso jogador corrente erre a letra passa a vez para o proximo
                    jogadorCorrente = 2;
                    jogadorErrou = false;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                }

                if (jogadorCorrente == 1 && validador2 == false) {
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();

                    if (valorReaisSorteado < 0) {
                        saldoJogador1.setText("0");

                    }
                    if (valorReaisSorteado == 0) {
                        jogadorCorrente = 2;
                        jogadorErrou = true;
                        saldoJogador1.setOpaque(false);
                        saldoJogador2.setOpaque(true);
                        saldoJogador3.setOpaque(false);
                        saldoJogador1.repaint();
                        saldoJogador2.repaint();
                        saldoJogador3.repaint();
                    }
                    saldoJogador1.setText(String.valueOf(valorReaisAcumuladoJogadorCorrente + Integer.parseInt(saldoJogador1.getText())));
                }

                break;
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
        etapa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        p1l1 = new javax.swing.JLabel();
        p2l1 = new javax.swing.JLabel();
        p3l1 = new javax.swing.JLabel();
        p3l2 = new javax.swing.JLabel();
        p2l2 = new javax.swing.JLabel();
        p1l2 = new javax.swing.JLabel();
        p1l3 = new javax.swing.JLabel();
        p2l3 = new javax.swing.JLabel();
        p3l3 = new javax.swing.JLabel();
        p3l4 = new javax.swing.JLabel();
        p2l4 = new javax.swing.JLabel();
        p1l4 = new javax.swing.JLabel();
        p1l5 = new javax.swing.JLabel();
        p2l5 = new javax.swing.JLabel();
        p3l5 = new javax.swing.JLabel();
        p3l6 = new javax.swing.JLabel();
        p2l6 = new javax.swing.JLabel();
        p1l6 = new javax.swing.JLabel();
        p1l7 = new javax.swing.JLabel();
        p2l7 = new javax.swing.JLabel();
        p3l7 = new javax.swing.JLabel();
        p3l8 = new javax.swing.JLabel();
        p2l8 = new javax.swing.JLabel();
        p1l8 = new javax.swing.JLabel();
        p1l9 = new javax.swing.JLabel();
        p2l9 = new javax.swing.JLabel();
        p3l9 = new javax.swing.JLabel();
        p2l10 = new javax.swing.JLabel();
        p3l10 = new javax.swing.JLabel();
        p1l10 = new javax.swing.JLabel();
        p1l11 = new javax.swing.JLabel();
        p2l11 = new javax.swing.JLabel();
        p3l11 = new javax.swing.JLabel();
        p3l12 = new javax.swing.JLabel();
        p2l12 = new javax.swing.JLabel();
        p1l12 = new javax.swing.JLabel();
        p1l13 = new javax.swing.JLabel();
        p2l13 = new javax.swing.JLabel();
        p3l13 = new javax.swing.JLabel();
        p3l14 = new javax.swing.JLabel();
        p2l14 = new javax.swing.JLabel();
        p1l14 = new javax.swing.JLabel();
        p1l15 = new javax.swing.JLabel();
        p2l15 = new javax.swing.JLabel();
        p3l15 = new javax.swing.JLabel();
        dica = new javax.swing.JLabel();
        btA = new javax.swing.JToggleButton();
        btB = new javax.swing.JToggleButton();
        btC = new javax.swing.JToggleButton();
        btD = new javax.swing.JToggleButton();
        btE = new javax.swing.JToggleButton();
        btF = new javax.swing.JToggleButton();
        btG = new javax.swing.JToggleButton();
        btH = new javax.swing.JToggleButton();
        btI = new javax.swing.JToggleButton();
        btJ = new javax.swing.JToggleButton();
        btK = new javax.swing.JToggleButton();
        btL = new javax.swing.JToggleButton();
        btM = new javax.swing.JToggleButton();
        btN = new javax.swing.JToggleButton();
        btO = new javax.swing.JToggleButton();
        btP = new javax.swing.JToggleButton();
        btQ = new javax.swing.JToggleButton();
        btR = new javax.swing.JToggleButton();
        btS = new javax.swing.JToggleButton();
        btT = new javax.swing.JToggleButton();
        btU = new javax.swing.JToggleButton();
        btV = new javax.swing.JToggleButton();
        btX = new javax.swing.JToggleButton();
        btW = new javax.swing.JToggleButton();
        btY = new javax.swing.JToggleButton();
        btZ = new javax.swing.JToggleButton();
        btResponder = new javax.swing.JButton();
        btRodar = new javax.swing.JButton();
        saldoJogador1 = new javax.swing.JLabel();
        saldoJogador2 = new javax.swing.JLabel();
        saldoJogador3 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btAvancar = new javax.swing.JButton();
        imagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo Roda a Roda");
        setPreferredSize(new java.awt.Dimension(1226, 723));
        getContentPane().setLayout(null);

        seletor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Seletor.png"))); // NOI18N
        getContentPane().add(seletor);
        seletor.setBounds(460, 200, 41, 60);

        roleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Roleta/1.png"))); // NOI18N
        getContentPane().add(roleta);
        roleta.setBounds(240, 200, 480, 480);

        etapa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        etapa.setForeground(new java.awt.Color(0, 0, 255));
        etapa.setText("1 / 1");
        getContentPane().add(etapa);
        etapa.setBounds(1110, 50, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Etapa:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1020, 40, 80, 50);

        p1l1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p1l1.setPreferredSize(new java.awt.Dimension(40, 40));
        getContentPane().add(p1l1);
        p1l1.setBounds(400, 30, 30, 30);

        p2l1.setBackground(new java.awt.Color(204, 204, 204));
        p2l1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p2l1.setPreferredSize(new java.awt.Dimension(40, 40));
        getContentPane().add(p2l1);
        p2l1.setBounds(400, 60, 30, 30);

        p3l1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p3l1.setPreferredSize(new java.awt.Dimension(40, 40));
        getContentPane().add(p3l1);
        p3l1.setBounds(400, 90, 30, 30);

        p3l2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l2);
        p3l2.setBounds(430, 90, 30, 30);

        p2l2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l2);
        p2l2.setBounds(430, 60, 30, 30);

        p1l2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l2);
        p1l2.setBounds(430, 30, 30, 30);

        p1l3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l3);
        p1l3.setBounds(460, 30, 30, 30);

        p2l3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l3);
        p2l3.setBounds(460, 60, 30, 30);

        p3l3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l3);
        p3l3.setBounds(460, 90, 30, 30);

        p3l4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l4);
        p3l4.setBounds(490, 90, 30, 30);

        p2l4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l4);
        p2l4.setBounds(490, 60, 30, 30);

        p1l4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l4);
        p1l4.setBounds(490, 30, 30, 30);

        p1l5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l5);
        p1l5.setBounds(520, 30, 30, 30);

        p2l5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l5);
        p2l5.setBounds(520, 60, 30, 30);

        p3l5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l5);
        p3l5.setBounds(520, 90, 30, 30);

        p3l6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l6);
        p3l6.setBounds(550, 90, 30, 30);

        p2l6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l6);
        p2l6.setBounds(550, 60, 30, 30);

        p1l6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l6);
        p1l6.setBounds(550, 30, 30, 30);

        p1l7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l7);
        p1l7.setBounds(580, 30, 30, 30);

        p2l7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l7);
        p2l7.setBounds(580, 60, 30, 30);

        p3l7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l7);
        p3l7.setBounds(580, 90, 30, 30);

        p3l8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l8);
        p3l8.setBounds(610, 90, 30, 30);

        p2l8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l8);
        p2l8.setBounds(610, 60, 30, 30);

        p1l8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l8);
        p1l8.setBounds(610, 30, 30, 30);

        p1l9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l9);
        p1l9.setBounds(640, 30, 30, 30);

        p2l9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l9);
        p2l9.setBounds(640, 60, 30, 30);

        p3l9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l9);
        p3l9.setBounds(640, 90, 30, 30);

        p2l10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l10);
        p2l10.setBounds(670, 60, 30, 30);

        p3l10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l10);
        p3l10.setBounds(670, 90, 30, 30);

        p1l10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l10);
        p1l10.setBounds(670, 30, 30, 30);

        p1l11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l11);
        p1l11.setBounds(700, 30, 30, 30);

        p2l11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l11);
        p2l11.setBounds(700, 60, 30, 30);

        p3l11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l11);
        p3l11.setBounds(700, 90, 30, 30);

        p3l12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l12);
        p3l12.setBounds(730, 90, 30, 30);

        p2l12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l12);
        p2l12.setBounds(730, 60, 30, 30);

        p1l12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l12);
        p1l12.setBounds(730, 30, 30, 30);

        p1l13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l13);
        p1l13.setBounds(760, 30, 30, 30);

        p2l13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l13);
        p2l13.setBounds(760, 60, 30, 30);

        p3l13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l13);
        p3l13.setBounds(760, 90, 30, 30);

        p3l14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l14);
        p3l14.setBounds(790, 90, 30, 30);

        p2l14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l14);
        p2l14.setBounds(790, 60, 30, 30);

        p1l14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l14);
        p1l14.setBounds(790, 30, 30, 30);

        p1l15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p1l15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1l15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p1l15);
        p1l15.setBounds(820, 30, 30, 30);

        p2l15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p2l15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2l15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p2l15);
        p2l15.setBounds(820, 60, 30, 30);

        p3l15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        p3l15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3l15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(p3l15);
        p3l15.setBounds(820, 90, 30, 30);

        dica.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        dica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dica.setText("************");
        getContentPane().add(dica);
        dica.setBounds(420, 153, 410, 30);

        btA.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btA.setText("A");
        btA.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAActionPerformed(evt);
            }
        });
        getContentPane().add(btA);
        btA.setBounds(710, 540, 35, 25);

        btB.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btB.setText("B");
        btB.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBActionPerformed(evt);
            }
        });
        getContentPane().add(btB);
        btB.setBounds(750, 540, 35, 25);

        btC.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btC.setText("C");
        btC.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCActionPerformed(evt);
            }
        });
        getContentPane().add(btC);
        btC.setBounds(790, 540, 35, 25);

        btD.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btD.setText("D");
        btD.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDActionPerformed(evt);
            }
        });
        getContentPane().add(btD);
        btD.setBounds(830, 540, 35, 25);

        btE.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btE.setText("E");
        btE.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEActionPerformed(evt);
            }
        });
        getContentPane().add(btE);
        btE.setBounds(870, 540, 35, 25);

        btF.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btF.setText("F");
        btF.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFActionPerformed(evt);
            }
        });
        getContentPane().add(btF);
        btF.setBounds(910, 540, 35, 25);

        btG.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btG.setText("G");
        btG.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGActionPerformed(evt);
            }
        });
        getContentPane().add(btG);
        btG.setBounds(950, 540, 35, 25);

        btH.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btH.setText("H");
        btH.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHActionPerformed(evt);
            }
        });
        getContentPane().add(btH);
        btH.setBounds(710, 570, 35, 25);

        btI.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btI.setText("I");
        btI.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIActionPerformed(evt);
            }
        });
        getContentPane().add(btI);
        btI.setBounds(750, 570, 35, 25);

        btJ.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btJ.setText("J");
        btJ.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJActionPerformed(evt);
            }
        });
        getContentPane().add(btJ);
        btJ.setBounds(790, 570, 35, 25);

        btK.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btK.setText("K");
        btK.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKActionPerformed(evt);
            }
        });
        getContentPane().add(btK);
        btK.setBounds(830, 570, 35, 25);

        btL.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btL.setText("L");
        btL.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLActionPerformed(evt);
            }
        });
        getContentPane().add(btL);
        btL.setBounds(870, 570, 35, 25);

        btM.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btM.setText("M");
        btM.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMActionPerformed(evt);
            }
        });
        getContentPane().add(btM);
        btM.setBounds(910, 570, 35, 25);

        btN.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btN.setText("N");
        btN.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNActionPerformed(evt);
            }
        });
        getContentPane().add(btN);
        btN.setBounds(950, 570, 35, 25);

        btO.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btO.setText("O");
        btO.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOActionPerformed(evt);
            }
        });
        getContentPane().add(btO);
        btO.setBounds(710, 600, 35, 25);

        btP.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btP.setText("P");
        btP.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPActionPerformed(evt);
            }
        });
        getContentPane().add(btP);
        btP.setBounds(750, 600, 35, 25);

        btQ.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btQ.setText("Q");
        btQ.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQActionPerformed(evt);
            }
        });
        getContentPane().add(btQ);
        btQ.setBounds(790, 600, 35, 25);

        btR.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btR.setText("R");
        btR.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRActionPerformed(evt);
            }
        });
        getContentPane().add(btR);
        btR.setBounds(830, 600, 35, 25);

        btS.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btS.setText("S");
        btS.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSActionPerformed(evt);
            }
        });
        getContentPane().add(btS);
        btS.setBounds(870, 600, 35, 25);

        btT.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btT.setText("T");
        btT.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTActionPerformed(evt);
            }
        });
        getContentPane().add(btT);
        btT.setBounds(910, 600, 35, 25);

        btU.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btU.setText("U");
        btU.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUActionPerformed(evt);
            }
        });
        getContentPane().add(btU);
        btU.setBounds(950, 600, 35, 25);

        btV.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btV.setText("V");
        btV.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVActionPerformed(evt);
            }
        });
        getContentPane().add(btV);
        btV.setBounds(750, 630, 35, 25);

        btX.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btX.setText("X");
        btX.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXActionPerformed(evt);
            }
        });
        getContentPane().add(btX);
        btX.setBounds(790, 630, 35, 25);

        btW.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btW.setText("W");
        btW.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWActionPerformed(evt);
            }
        });
        getContentPane().add(btW);
        btW.setBounds(830, 630, 35, 25);

        btY.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btY.setText("Y");
        btY.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btYActionPerformed(evt);
            }
        });
        getContentPane().add(btY);
        btY.setBounds(870, 630, 35, 25);

        btZ.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btZ.setText("Z");
        btZ.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btZActionPerformed(evt);
            }
        });
        getContentPane().add(btZ);
        btZ.setBounds(910, 630, 35, 25);

        btResponder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btresponder.png"))); // NOI18N
        btResponder.setBorderPainted(false);
        btResponder.setContentAreaFilled(false);
        btResponder.setFocusPainted(false);
        btResponder.setFocusable(false);
        btResponder.setRequestFocusEnabled(false);
        btResponder.setVerifyInputWhenFocusTarget(false);
        btResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResponderActionPerformed(evt);
            }
        });
        getContentPane().add(btResponder);
        btResponder.setBounds(760, 490, 170, 40);

        //brRodar.setBackground(new Color(0,0,0,0));
        btRodar.setBackground(new java.awt.Color(0, 0, 0));
        btRodar.setForeground(new java.awt.Color(255, 255, 255));
        btRodar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btrodarativo.png"))); // NOI18N
        btRodar.setToolTipText("Rodar Roleta");
        btRodar.setBorder(null);
        btRodar.setContentAreaFilled(false);
        btRodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRodarActionPerformed(evt);
            }
        });
        getContentPane().add(btRodar);
        btRodar.setBounds(810, 390, 80, 70);

        saldoJogador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saldoJogador1.setForeground(new java.awt.Color(255, 0, 0));
        saldoJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoJogador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saldoJogador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(saldoJogador1);
        saldoJogador1.setBounds(20, 130, 200, 40);

        saldoJogador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saldoJogador2.setForeground(new java.awt.Color(255, 0, 0));
        saldoJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoJogador2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saldoJogador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(saldoJogador2);
        saldoJogador2.setBounds(20, 350, 200, 50);

        saldoJogador3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saldoJogador3.setForeground(new java.awt.Color(255, 0, 0));
        saldoJogador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoJogador3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saldoJogador3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(saldoJogador3);
        saldoJogador3.setBounds(20, 570, 200, 50);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btVoltar.png"))); // NOI18N
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.setFocusPainted(false);
        btVoltar.setFocusable(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar);
        btVoltar.setBounds(1030, 10, 140, 30);

        btAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/btAvancar.png"))); // NOI18N
        btAvancar.setBorderPainted(false);
        btAvancar.setContentAreaFilled(false);
        btAvancar.setFocusPainted(false);
        btAvancar.setFocusable(false);
        btAvancar.setRequestFocusEnabled(false);
        btAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvancarActionPerformed(evt);
            }
        });
        getContentPane().add(btAvancar);
        btAvancar.setBounds(720, 280, 250, 80);

        imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogorodaroda/Imagens/Tela3Jogador.png"))); // NOI18N
        getContentPane().add(imagemFundo);
        imagemFundo.setBounds(0, -10, 1210, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAActionPerformed
        btA.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("A", listaPalavrasUsadasNoMomento, qtdPalavras);

    }//GEN-LAST:event_btAActionPerformed

    private void btBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBActionPerformed
        btB.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("B", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btBActionPerformed

    private void btFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFActionPerformed
        btF.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("F", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btFActionPerformed

    private void btHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHActionPerformed
        btH.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("H", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btHActionPerformed

    private void btIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIActionPerformed
        btI.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("I", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btIActionPerformed

    private void btJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJActionPerformed
        btJ.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("J", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btJActionPerformed

    private void btPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPActionPerformed
        btP.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("P", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btPActionPerformed

    private void btRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRActionPerformed
        btR.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("R", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btRActionPerformed

    private void btTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTActionPerformed
        btT.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("T", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btTActionPerformed

    private void btXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXActionPerformed
        btX.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("X", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btXActionPerformed

    private void btRodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRodarActionPerformed
        int valorSorteado = 0;
        Metodos metodos = new Metodos();
        metodos.audioRoleta();
        try {
            valorSorteado = rodarRoleta();
        } catch (InterruptedException ex) {
            Logger.getLogger(TelaJogadores.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (valorSorteado == 2 || valorSorteado == 8 || valorSorteado == 12 || valorSorteado == 17) {
            valorReaisSorteado = 100;
        } else if (valorSorteado == 4 || valorSorteado == 10 || valorSorteado == 14 || valorSorteado == 18) {
            valorReaisSorteado = 200;
        } else if (valorSorteado == 3 || valorSorteado == 6 || valorSorteado == 9 || valorSorteado == 13) {
            valorReaisSorteado = 400;
        } else if (valorSorteado == 16 || valorSorteado == 19) {
            valorReaisSorteado = 500;
        } else if (valorSorteado == 1 || valorSorteado == 7) {
            valorReaisSorteado = 1000;
        } else if (valorSorteado == 5 || valorSorteado == 15) {
            valorReaisSorteado = 0; //passa
        } else if (valorSorteado == 11 || valorSorteado == 20) {
            valorReaisSorteado = -1; //perde
        }

        if (valorReaisSorteado > 0) {
            mostraTecladoLetras();
            btRodar.setEnabled(false);
        } else {
            if (qtdJogadores == 1) {
                if (valorReaisSorteado == -1 && jogadorCorrente == 1) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador1.setText("0");
                }
            }

            if (qtdJogadores == 2) {//caso a sorte seja passa a vez´ ou perde tudo passa para proximo jogador

                if (valorReaisSorteado == -1 && jogadorCorrente == 1) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador1.setText("0");
                } else if (valorReaisSorteado == -1 && jogadorCorrente == 2) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador2.setText("0");
                } else if (valorReaisSorteado == -1 && jogadorCorrente == 3) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador3.setText("0");
                }

                if (jogadorCorrente == 1) {
                    jogadorCorrente = 2;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                } else if (jogadorCorrente == 2) {
                    jogadorCorrente = 1;
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                }
            }

            if (qtdJogadores == 3) {//caso a sorte seja passa a vez´ ou perde tudo passa para proximo jogador

                if (valorReaisSorteado == -1 && jogadorCorrente == 1) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador1.setText("0");
                } else if (valorReaisSorteado == -1 && jogadorCorrente == 2) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador2.setText("0");
                } else if (valorReaisSorteado == -1 && jogadorCorrente == 3) {//Caso a sorte seja perde tudo zera o saldo do jogador e habilita para rodar novamente
                    saldoJogador3.setText("0");
                }

                if (jogadorCorrente == 1) {
                    jogadorCorrente = 2;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(true);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                } else if (jogadorCorrente == 2) {
                    jogadorCorrente = 3;
                    saldoJogador1.setOpaque(false);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(true);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                } else if (jogadorCorrente == 3) {
                    jogadorCorrente = 1;
                    saldoJogador1.setOpaque(true);
                    saldoJogador2.setOpaque(false);
                    saldoJogador3.setOpaque(false);
                    saldoJogador1.repaint();
                    saldoJogador2.repaint();
                    saldoJogador3.repaint();
                }
            }
        }

    }//GEN-LAST:event_btRodarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Metodos metodos = new Metodos();
        metodos.audioInicial();
        TelaInicial telaInicial = new TelaInicial();

        telaInicial.dispose();
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
        telaInicial.setLocationRelativeTo(null);
        dispose();

//        Metodos metodos = new Metodos();
//        metodos.audioInicial();

    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCActionPerformed
        btC.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("C", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btCActionPerformed

    private void btDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDActionPerformed
        btD.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("D", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btDActionPerformed

    private void btEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEActionPerformed
        btE.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("E", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btEActionPerformed

    private void btGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGActionPerformed
        btG.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("G", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btGActionPerformed

    private void btKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKActionPerformed
        btK.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("K", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btKActionPerformed

    private void btLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLActionPerformed
        btL.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("L", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btLActionPerformed

    private void btMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMActionPerformed
        btM.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("M", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btMActionPerformed

    private void btNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNActionPerformed
        btN.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("N", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btNActionPerformed

    private void btOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOActionPerformed
        btO.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("O", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btOActionPerformed

    private void btQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQActionPerformed
        btQ.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("Q", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btQActionPerformed

    private void btSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSActionPerformed
        btS.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("S", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btSActionPerformed

    private void btUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUActionPerformed
        btU.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("U", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btUActionPerformed

    private void btVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVActionPerformed
        btV.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("V", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btVActionPerformed

    private void btWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWActionPerformed
        btW.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("W", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btWActionPerformed

    private void btYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btYActionPerformed
        btY.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("Y", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btYActionPerformed

    private void btZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZActionPerformed
        btZ.setEnabled(false);
        escondeTecladoLetras();
        letraSelecionada("Z", listaPalavrasUsadasNoMomento, qtdPalavras);
    }//GEN-LAST:event_btZActionPerformed

    private void btResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResponderActionPerformed
        respostaATiva = true;
        roleta.setEnabled(false);
        btRodar.setEnabled(false);
        btResponder.setEnabled(false);
        mostraTecladoLetras();
    }//GEN-LAST:event_btResponderActionPerformed

    private void btAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvancarActionPerformed

        p1l1.setText("");
        p1l2.setText("");
        p1l3.setText("");
        p1l4.setText("");
        p1l5.setText("");
        p1l6.setText("");
        p1l7.setText("");
        p1l8.setText("");
        p1l9.setText("");
        p1l10.setText("");
        p1l11.setText("");
        p1l12.setText("");
        p1l13.setText("");
        p1l14.setText("");
        p1l15.setText("");
        p2l1.setText("");
        p2l2.setText("");
        p2l3.setText("");
        p2l4.setText("");
        p2l5.setText("");
        p2l6.setText("");
        p2l7.setText("");
        p2l8.setText("");
        p2l9.setText("");
        p2l10.setText("");
        p2l11.setText("");
        p2l12.setText("");
        p2l13.setText("");
        p2l14.setText("");
        p2l15.setText("");
        p3l1.setText("");
        p3l2.setText("");
        p3l3.setText("");
        p3l4.setText("");
        p3l5.setText("");
        p3l6.setText("");
        p3l7.setText("");
        p3l8.setText("");
        p3l9.setText("");
        p3l10.setText("");
        p3l11.setText("");
        p3l12.setText("");
        p3l13.setText("");
        p3l14.setText("");
        p3l15.setText("");

        p1l1.setOpaque(false);
        p1l2.setOpaque(false);
        p1l3.setOpaque(false);
        p1l4.setOpaque(false);
        p1l5.setOpaque(false);
        p1l6.setOpaque(false);
        p1l7.setOpaque(false);
        p1l8.setOpaque(false);
        p1l9.setOpaque(false);
        p1l10.setOpaque(false);
        p1l11.setOpaque(false);
        p1l12.setOpaque(false);
        p1l13.setOpaque(false);
        p1l14.setOpaque(false);
        p1l15.setOpaque(false);

        p2l1.setOpaque(false);
        p2l2.setOpaque(false);
        p2l3.setOpaque(false);
        p2l4.setOpaque(false);
        p2l5.setOpaque(false);
        p2l6.setOpaque(false);
        p2l7.setOpaque(false);
        p2l8.setOpaque(false);
        p2l9.setOpaque(false);
        p2l10.setOpaque(false);
        p2l11.setOpaque(false);
        p2l12.setOpaque(false);
        p2l13.setOpaque(false);
        p2l14.setOpaque(false);
        p2l15.setOpaque(false);

        p3l1.setOpaque(false);
        p3l2.setOpaque(false);
        p3l3.setOpaque(false);
        p3l4.setOpaque(false);
        p3l5.setOpaque(false);
        p3l6.setOpaque(false);
        p3l7.setOpaque(false);
        p3l8.setOpaque(false);
        p3l9.setOpaque(false);
        p3l10.setOpaque(false);
        p3l11.setOpaque(false);
        p3l12.setOpaque(false);
        p3l13.setOpaque(false);
        p3l14.setOpaque(false);
        p3l15.setOpaque(false);

        btA.setEnabled(true);
        btB.setEnabled(true);
        btC.setEnabled(true);
        btD.setEnabled(true);
        btE.setEnabled(true);
        btF.setEnabled(true);
        btG.setEnabled(true);
        btH.setEnabled(true);
        btI.setEnabled(true);
        btJ.setEnabled(true);
        btK.setEnabled(true);
        btL.setEnabled(true);
        btM.setEnabled(true);
        btN.setEnabled(true);
        btO.setEnabled(true);
        btP.setEnabled(true);
        btQ.setEnabled(true);
        btR.setEnabled(true);
        btS.setEnabled(true);
        btT.setEnabled(true);
        btU.setEnabled(true);
        btV.setEnabled(true);
        btX.setEnabled(true);
        btW.setEnabled(true);
        btY.setEnabled(true);
        btZ.setEnabled(true);

        btA.setSelected(false);
        btB.setSelected(false);
        btC.setSelected(false);
        btD.setSelected(false);
        btE.setSelected(false);
        btF.setSelected(false);
        btG.setSelected(false);
        btH.setSelected(false);
        btI.setSelected(false);
        btJ.setSelected(false);
        btK.setSelected(false);
        btL.setSelected(false);
        btM.setSelected(false);
        btN.setSelected(false);
        btO.setSelected(false);
        btP.setSelected(false);
        btQ.setSelected(false);
        btR.setSelected(false);
        btS.setSelected(false);
        btT.setSelected(false);
        btU.setSelected(false);
        btV.setSelected(false);
        btX.setSelected(false);
        btW.setSelected(false);
        btY.setSelected(false);
        btZ.setSelected(false);

        etapaAtual = 1 + Integer.parseInt(etapa.getText().substring(0, 1));  //Atualiza label da etapa  
        etapa.setText(etapaAtual + " " + etapa.getText().substring(2, 5)); //Atualiza label da etapa 

//        if(jogadorCorrente == 1){
//            valorAcumuladoJogador1 = valorAcumuladoJogador1 + Integer.parseInt(saldoJogador1.getText());
//        }
//        else if(jogadorCorrente == 2){
//            valorAcumuladoJogador2 = valorAcumuladoJogador2 + Integer.parseInt(saldoJogador2.getText());
//        }
//        else if(jogadorCorrente == 3){
//            valorAcumuladoJogador3 = valorAcumuladoJogador3 + Integer.parseInt(saldoJogador3.getText());
//        }
        saldoJogador1.setText("");
        saldoJogador2.setText("");
        saldoJogador3.setText("");

        listaPalavras.clear();
        listapalavrasSorteadas.clear();
        listaPalavrasUsadasNoMomento.clear();

        for (int x = 0; x < listaPosicaoLetrasEncontradasPalavra1.length; x++) {
            listaPosicaoLetrasEncontradasPalavra1[x] = "";
        }
        for (int y = 0; y < listaPosicaoLetrasEncontradasPalavra2.length; y++) {
            listaPosicaoLetrasEncontradasPalavra2[y] = "";
        }
        for (int z = 0; z < listaPosicaoLetrasEncontradasPalavra3.length; z++) {
            listaPosicaoLetrasEncontradasPalavra3[z] = "";
        }

        valorReaisSorteado = 0;
        valorReaisAcumuladoJogadorCorrente = 0;
        jogadorErrou = false; //Usada para passar o jogo para o proximo jogador se este errar a leta, passar ou perder tudo
        qtdErrosJogador1 = 0;
        respostaATiva = false;
        jogador1EliminadoRodada = false;
        jogador2EliminadoRodada = false;
        jogador3EliminadoRodada = false;

        try {
            listaPalavrasUsadasNoMomento = guardaPalavrasSorteadas();
        } catch (IOException ex) {
            Logger.getLogger(TelaJogadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listaPosicaoLetrasEncontradasPalavra1 = new String[(listaPalavrasUsadasNoMomento.get(1).toString()).length()]; //Pega tamanho da palavra sorteada;
        this.listaPosicaoLetrasEncontradasPalavra2 = new String[(listaPalavrasUsadasNoMomento.get(2).toString()).length()]; //Pega tamanho da palavra sorteada;
        this.listaPosicaoLetrasEncontradasPalavra3 = new String[(listaPalavrasUsadasNoMomento.get(3).toString()).length()]; //Pega tamanho da palavra sorteada;

        escondeTecladoLetras();
        roleta.setEnabled(true);
        btRodar.setVisible(true);
        btResponder.setVisible(true);

//         if(qtdJogadores == 1){
//            saldoJogador1.setText(String.valueOf(valorAcumuladoJogador1));
//        }
//        else if(qtdJogadores == 2){
//            saldoJogador1.setText(String.valueOf(valorAcumuladoJogador1));
//            saldoJogador2.setText(String.valueOf(valorAcumuladoJogador2));
//        }
//        else if(qtdJogadores == 3){
//            saldoJogador1.setText(String.valueOf(valorAcumuladoJogador1));
//            saldoJogador2.setText(String.valueOf(valorAcumuladoJogador2));
//            saldoJogador3.setText(String.valueOf(valorAcumuladoJogador3));
//        }
        saldoJogador1.setText("0");
        saldoJogador2.setText("0");
        saldoJogador3.setText("0");

        btAvancar.setVisible(false);

    }//GEN-LAST:event_btAvancarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btA;
    private javax.swing.JButton btAvancar;
    private javax.swing.JToggleButton btB;
    private javax.swing.JToggleButton btC;
    private javax.swing.JToggleButton btD;
    private javax.swing.JToggleButton btE;
    private javax.swing.JToggleButton btF;
    private javax.swing.JToggleButton btG;
    private javax.swing.JToggleButton btH;
    private javax.swing.JToggleButton btI;
    private javax.swing.JToggleButton btJ;
    private javax.swing.JToggleButton btK;
    private javax.swing.JToggleButton btL;
    private javax.swing.JToggleButton btM;
    private javax.swing.JToggleButton btN;
    private javax.swing.JToggleButton btO;
    private javax.swing.JToggleButton btP;
    private javax.swing.JToggleButton btQ;
    private javax.swing.JToggleButton btR;
    private javax.swing.JButton btResponder;
    private javax.swing.JButton btRodar;
    private javax.swing.JToggleButton btS;
    private javax.swing.JToggleButton btT;
    private javax.swing.JToggleButton btU;
    private javax.swing.JToggleButton btV;
    private javax.swing.JButton btVoltar;
    private javax.swing.JToggleButton btW;
    private javax.swing.JToggleButton btX;
    private javax.swing.JToggleButton btY;
    private javax.swing.JToggleButton btZ;
    private javax.swing.JLabel dica;
    private javax.swing.JLabel etapa;
    private javax.swing.JLabel imagemFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel p1l1;
    private javax.swing.JLabel p1l10;
    private javax.swing.JLabel p1l11;
    private javax.swing.JLabel p1l12;
    private javax.swing.JLabel p1l13;
    private javax.swing.JLabel p1l14;
    private javax.swing.JLabel p1l15;
    private javax.swing.JLabel p1l2;
    private javax.swing.JLabel p1l3;
    private javax.swing.JLabel p1l4;
    private javax.swing.JLabel p1l5;
    private javax.swing.JLabel p1l6;
    private javax.swing.JLabel p1l7;
    private javax.swing.JLabel p1l8;
    private javax.swing.JLabel p1l9;
    private javax.swing.JLabel p2l1;
    private javax.swing.JLabel p2l10;
    private javax.swing.JLabel p2l11;
    private javax.swing.JLabel p2l12;
    private javax.swing.JLabel p2l13;
    private javax.swing.JLabel p2l14;
    private javax.swing.JLabel p2l15;
    private javax.swing.JLabel p2l2;
    private javax.swing.JLabel p2l3;
    private javax.swing.JLabel p2l4;
    private javax.swing.JLabel p2l5;
    private javax.swing.JLabel p2l6;
    private javax.swing.JLabel p2l7;
    private javax.swing.JLabel p2l8;
    private javax.swing.JLabel p2l9;
    private javax.swing.JLabel p3l1;
    private javax.swing.JLabel p3l10;
    private javax.swing.JLabel p3l11;
    private javax.swing.JLabel p3l12;
    private javax.swing.JLabel p3l13;
    private javax.swing.JLabel p3l14;
    private javax.swing.JLabel p3l15;
    private javax.swing.JLabel p3l2;
    private javax.swing.JLabel p3l3;
    private javax.swing.JLabel p3l4;
    private javax.swing.JLabel p3l5;
    private javax.swing.JLabel p3l6;
    private javax.swing.JLabel p3l7;
    private javax.swing.JLabel p3l8;
    private javax.swing.JLabel p3l9;
    private javax.swing.JLabel roleta;
    private javax.swing.JLabel saldoJogador1;
    private javax.swing.JLabel saldoJogador2;
    private javax.swing.JLabel saldoJogador3;
    private javax.swing.JLabel seletor;
    // End of variables declaration//GEN-END:variables
}
