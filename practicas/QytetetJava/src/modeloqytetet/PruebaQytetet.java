/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author venrra
 */
public class PruebaQytetet {

    /**
     * @param args the command line arguments
     */
    
    private static final Scanner in = new Scanner (System.in);
    
    static Qytetet juego = Qytetet.getInstance();
    
    public static ArrayList<String> getNombreJugadores(){
        ArrayList<String> s= new ArrayList<>();
        for(int i=0; i < juego.MAX_JUGADORES; i++){
            s.add(in.nextLine());
        }
        return s;
    }
    
    /*
    private static ArrayList<Sorpresa> Metodo1(){
       
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
            if(i.getValor()>0)
                nuevoArray.add(i);
        return nuevoArray;
    }
    private static ArrayList<Sorpresa> Metodo2(){
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
         if(i.getTipo() == TipoSorpresa.IRACASILLA)
                nuevoArray.add(i);
        return nuevoArray;
    }
    private static ArrayList<Sorpresa> Metodo3(TipoSorpresa tipo){
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
             if(i.getTipo() == tipo)
                nuevoArray.add(i);
        return nuevoArray;
    } 
    */
    public static void main(String[] args) {
        // TODO code application logic here
      /* ArrayList<String> nombres = getNombreJugadores();
        juego.inicializarJuego(nombres);
        System.out.println(juego.toString());
        /*
        //LLAMA AL METODO1
        System.out.println("////////METODO1");
        System.out.println(PruebaQytetet.Metodo1().toString());
     
        
        //LLAMA AL METODO2
        System.out.println("////////METODO2");
        System.out.println(PruebaQytetet.Metodo2().toString());
        
        //LLAMA AL METODO3
        System.out.println("////////METODO3");
         for (TipoSorpresa tipo : TipoSorpresa.values())
            System.out.println(PruebaQytetet.Metodo3(tipo).toString());
    */
      boolean comprado;
       ArrayList<String> jugadores = getNombreJugadores();
      
       juego.inicializarJuego(jugadores);
       
      // System.out.print("\nEstado juego: " + juego.getEstadoJuego());
       System.out.print("\nJugador Inicial: "+ juego.getJugadorActual().getNombre() + " \tcasilla actual:" + juego.getJugadorActual().getCasillaActual().getNumeroCasilla());      
       System.out.print("\nMovemos jugador a la casilla 1");
       juego.mover(1);
      
       System.out.print("\nJugador Actual: " + juego.getJugadorActual().getNombre());
       System.out.print("\nCasilla Actual: "+ juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       System.out.print("\nVamos a comprar la propiedad de la casilla 1. Saldo del jugador actual: " + juego.getJugadorActual().getSaldo());
       System.out.print("\nPropiedades del jugador actual: " + juego.getJugadorActual().getPropiedades().toString());
       
       comprado = juego.comprarTituloPropiedad();
       
       if(comprado){
           System.out.print("\nSaldo del jugador tras comprar: " + juego.getJugadorActual().getSaldo());
           System.out.print("\nPropiedades tras la compra: " + juego.getJugadorActual().getPropiedades().toString());
       }
       
       //System.out.print("\nEstado juego: " + juego.getEstadoJuego()+ "\n");
       
       System.out.print("Provamos a que le toque al siquiente");
       juego.siguienteJugador();
       System.out.print("\nJugador Actual: " + juego.getJugadorActual().getNombre());
       System.out.print("\nCasilla Actual: " + juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       System.out.print("\nMovemos jugador actual a una casilla de tipo sorpresa (9) CARCEL : ");
       juego.mover(9);
       System.out.print("\nJugador Actual: " + juego.getJugadorActual().getNombre());
       System.out.print("\nCasilla Actual: " + juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       juego.setCartaActual(juego.getMazo().get(0));
       
       System.out.print("\nJugdor encarcelado? "+ juego.getJugadorActual().getEncarcelado());
       juego.aplicarSorpresa();
       System.out.print("\nAplicamos sorpresa");
       System.out.print("\nJugdor encarcelado tras aplicar la sorpresa? "+ juego.getJugadorActual().getEncarcelado());
       juego.siguienteJugador();
       System.out.print("\nJugador Actual: " + juego.getJugadorActual().getNombre());
       System.out.print("\nCasilla Actual: " + juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       System.out.print("\nMovemos jugador actual a una casilla comprada por otro jugador: (1) ");
       System.out.print("\nSaldo antes moverlo:  "+juego.getJugadorActual().getSaldo());
       juego.mover(1);
       System.out.print("\nSaldo del propietario de (1) antes de que se mueva el actual:  "+juego.getJugadorActual().getCasillaActual().getTitulo().getPropietario().getSaldo());
       System.out.print("\nSaldo jugador actual despues de moverlo:  "+juego.getJugadorActual().getSaldo());
       System.out.print("\nSaldo del propietario de (1) despues:  "+juego.getJugadorActual().getCasillaActual().getTitulo().getPropietario().getSaldo() + "\n");
       juego.siguienteJugador();
       System.out.print("\nJugador Actual: " + juego.getJugadorActual().getNombre());
       System.out.print("\nCasilla Actual: " + juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       System.out.print("\nMovemos a casilla (8): ");
       juego.mover(8);
       //comprado = juego.comprarTituloPropiedad();
       
       if(comprado){
           System.out.print("\nSaldo del jugador tras comprar: " + juego.getJugadorActual().getSaldo());
           System.out.print("\nPropiedades tras la compra: " + juego.getJugadorActual().getPropiedades().toString());
       }
       juego.venderPropiedad(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
       
           System.out.print("\nSaldo del jugador tras vender: " + juego.getJugadorActual().getSaldo());
           System.out.print("\nPropiedades tras la venta: " + juego.getJugadorActual().getPropiedades().toString());
    }
}
