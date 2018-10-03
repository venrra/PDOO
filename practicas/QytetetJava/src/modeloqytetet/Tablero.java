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
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    //Aqui segenera e inicializa el tablero con todas las casillas ordenadas del 0 al 9 intercalando los tipos
    private void inicializar(){
        casillas = new ArrayList();
        casillas.add(new Casilla(00,TipoCasilla.SALIDA));
        casillas.add(new Casilla(01,));
        casillas.add(new Casilla(02,));
        casillas.add(new Casilla(03,));
        casillas.add(new Casilla(04,));
        casillas.add(new Casilla(05,));
        casillas.add(new Casilla(06,));
        casillas.add(new Casilla(07,));
        casillas.add(new Casilla(08,));
        casillas.add(new Casilla(09,));
        casillas.add(new Casilla(10,));
        casillas.add(new Casilla(11,));
        casillas.add(new Casilla(12,));
        casillas.add(new Casilla(13,));
        casillas.add(new Casilla(14,));
        casillas.add(new Casilla(15,));
        casillas.add(new Casilla(16,));
        casillas.add(new Casilla(17,));
        casillas.add(new Casilla(18,));
        casillas.add(new Casilla(19,));
        
        carcel = new Casilla(10, TipoCasilla.CARCEL);
    }
    
    public Tablero() {
        inicializar(); 
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public Casilla getCarcel() {
        return carcel;
    }
    
    @Override
    public String toString() {
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
}
