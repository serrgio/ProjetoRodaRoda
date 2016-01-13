package jogorodaroda.Classe;

import java.io.FileInputStream;
import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author GAOliveira
 */
public class Metodos {
    
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
