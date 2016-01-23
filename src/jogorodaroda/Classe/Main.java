package jogorodaroda.Classe;

import jogorodaroda.Interface.TelaInicial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
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
