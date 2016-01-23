package jogorodaroda.Classe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
     
     public ArrayList palavrasSorteadas(ArrayList palavrasJaSorteadas) throws IOException{
         ArrayList<String> listaPalavras = new ArrayList();
         ArrayList<String> p = new ArrayList();
         
         listaPalavras = LeitorArquivo.ler();
         p.add((String) listaPalavras.get(0));
         
         for(int i = 1; i <= 300; i ++){
            Random r = new Random();
            int aleatorio = r.nextInt(21) + 1;
 
                if(palavrasJaSorteadas.contains(listaPalavras.get(aleatorio)) || p.contains(listaPalavras.get(aleatorio))){
                    
                } 
                else{
                    p.add((String) listaPalavras.get(aleatorio));
                    if(p.size() > 3){
                        i = 301; //Sair lo for
                    }
                }
         }
         
         if(p.size() < 3){
             palavrasSorteadas(palavrasJaSorteadas);
         }
         return p;
     }
    
}
