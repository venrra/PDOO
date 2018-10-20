/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

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
        throw new UnsupportedOperationException("Sin implementar");
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }
}
