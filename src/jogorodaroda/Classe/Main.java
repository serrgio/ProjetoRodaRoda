package jogorodaroda.Classe;

import jogorodaroda.Interface.TelaInicial;



public class Main{

    public static void main(String args[]){
        TelaInicial telaInicial = new TelaInicial();

        telaInicial.dispose();
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
        telaInicial.setLocationRelativeTo(null);
        
        Metodos metodos = new Metodos();
        metodos.audioInicial();
        
        
    }
}
