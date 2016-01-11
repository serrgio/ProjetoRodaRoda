package jogorodaroda.Classe;

import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.exit;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class ClasseTelaInicial extends java.lang.Thread{
    
    private String qtdJogadores;
    private String qtdPalavras;
    private String qtdEtapas;
    private long tempo;

    public String getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(String qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public String getQtdPalavras() {
        return qtdPalavras;
    }

    public void setQtdPalavras(String qtdPalavras) {
        this.qtdPalavras = qtdPalavras;
    }

    public String getQtdEtapas() {
        return qtdEtapas;
    }

    public void setQtdEtapas(String qtdEtapas) {
        this.qtdEtapas = qtdEtapas;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }
   
    
    
    
    public void audioInicial() { 
        
        for(int i = 0; i < 2; i ++){
                       
                AudioPlayer MGP = AudioPlayer.player;  
                AudioStream BGM = null;  
                try {  
                    BGM = new AudioStream(new FileInputStream("AberturaJogo.wav"));  
                } catch(IOException error) {
                    error.printStackTrace();
                    System.out.println("Error!!!");  
                }  

                MGP.start(BGM);
                
                try {
                    Thread.sleep( 10000 ); // coloca a "thread" para "dormir"
                } catch (InterruptedException e) {
                    e.printStackTrace( System.err );
                }
        }
        
    }
    
 
}
