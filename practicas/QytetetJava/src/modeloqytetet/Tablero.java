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
    
    Tablero() {
        this.inicializar(); 
    }
    
    boolean esCasillaCarcel(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla getCarcel() {
        return carcel;
    }
    
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    //Segenera e inicializa el tablero con todas las casillas ordenadas del 0 al 19 intercalando los tipos
    private void inicializar(){
        casillas = new ArrayList<>();
        casillas.add(new Casilla(0,TipoCasilla.SALIDA));
        casillas.add(new Casilla(1, new TituloPropiedad("HOLA",0,0,0,0,0)));
        casillas.add(new Casilla(2, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(3, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(4, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(5, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(6, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(7, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(8, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(9, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(10,TipoCasilla.CARCEL));
        casillas.add(new Casilla(11, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(12, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(13, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(14, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(15, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(16, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(17, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(18, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(19, TipoCasilla.SORPRESA));
        
        //no se cual es mejor
        //carcel = casillas.get(10)
        carcel = new Casilla(10, TipoCasilla.CARCEL);
    }
    
    Casilla ontenerCasillaFinal(Casilla casilla, int desplazamiento){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla obtenerCasillaNumero(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        return "Tablero:" + "\nTodas las casillas=\n" + casillas + "\ncarcel=" + carcel + '}' + "\n";
    }
}
