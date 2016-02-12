
package jogorodaroda.Classe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class LeitorArquivo {
    
     	public static ArrayList ler() throws IOException{
            
            File tema = null;
            Random random = new Random();
            int aleatorio = random.nextInt(3) + 1;
            ArrayList<String> listapalavras = new ArrayList();;
            
            switch(aleatorio){
                case 1:
                    tema = new File("cidade.txt");
                    listapalavras.add("CIDADE");
                break;
                    
                case 2:
                    tema = new File("filme.txt");
                    listapalavras.add("FILME");
                break;
                    
                case 3:
                    tema = new File("profissao.txt");
                    listapalavras.add("PROFISSÃO");
                break;
                    
                default:
                    tema = new File("cidade.txt");
                    listapalavras.add("CIDADE");
                break;
            }

            BufferedReader entradaString = new BufferedReader(new InputStreamReader(new FileInputStream(tema), "UTF-8"));
       
	    String linha = entradaString.readLine();
	    
	    while(linha != null){

                listapalavras.add(linha);
                linha = entradaString.readLine();
            }
            
            entradaString.close();
            
            return listapalavras;

	}

}

