/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.Random;

/**
 *
 * @author venrra
 */
public class Dado {
    private int valor;
    
    private Dado(){
        valor=0;
    }
    
    private static final Dado instance = new Dado();
    
    public static Dado getinstance(){
        return instance;
    }
    
    int tirar(){
        Random r = new Random();
        valor = r.nextInt(6)+1;
        return valor;
    }

    public int getValor() {
        return valor;
    }
    
    boolean salgoDeLaCarcel(){
      int n = tirar();
      boolean x = n >= 5 ? true : false;
      return x;
    }
    public int quienEmpieza(int n){
      return random.nextInt(n);
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }
}
