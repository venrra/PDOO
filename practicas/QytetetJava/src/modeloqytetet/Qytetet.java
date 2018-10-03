/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author venrra
 */
public class Qytetet {
    
    private ArrayList<Sorpresa> mazo = new ArrayList();
    private Tablero tablero;

    public Qytetet() {
        inicializarTablero();
    }
    
    private void inicializarTablero(){
        this.tablero = new Tablero();
    }
  
    void inicializarCartasSorpresa(){
        
        //cobras 
        mazo.add(new Sorpresa ("NOSE", 200, TipoSorpresa.PAGARCOBRAR));
        //pagas
        mazo.add(new Sorpresa ("NOSE", -1000, TipoSorpresa.PAGARCOBRAR));
        //ir a casilla
        mazo.add(new Sorpresa ("CASILLA1", 1, TipoSorpresa.IRACASILLA));
        //ir a casilla
        mazo.add(new Sorpresa ("CASILLA19", 19, TipoSorpresa.IRACASILLA));
        //ir a la carcel
        mazo.add(new Sorpresa ("CARCEL", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        //cobra por las casa y hoteles que tenga
        mazo.add(new Sorpresa ("NOSE", 150, TipoSorpresa.PORCASAHOTEL));
        //paga por las casa y hoteles que tenga
        mazo.add(new Sorpresa ("NOSE", -100, TipoSorpresa.PORCASAHOTEL));
        //recibes 
        mazo.add(new Sorpresa ("NOSE", 50, TipoSorpresa.PORJUGADOR));
        //pagas 
        mazo.add(new Sorpresa ("NOSE", 75, TipoSorpresa.PORJUGADOR));
        //SALR DE LA CARCEL
        mazo.add(new Sorpresa ("NOSE", 0,TipoSorpresa.SALIRCARCEL));
}
    
    public ArrayList<Sorpresa> getMazo(){
        return this.mazo;
    }
}
