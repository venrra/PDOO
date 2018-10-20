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
    public static int MAX_JUGADORES = 4;
    static int NUM_SORPRESAS = 10;
    public static int NUM_CASILLAS = 20;
    static int PRECIO_LIBERTAD = 200;
    static int SALDO_SALIDA = 1000;
    
    private ArrayList<Sorpresa> mazo;
    private Tablero tablero;
    private Sorpresa cartaActual;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorActual;
    private Dado dado;
    
    private Qytetet() {
        this.cartaActual = null;
        this.jugadorActual = null;
        this.dado = Dado.getinstance();
    }
    
    private static final Qytetet instance = new Qytetet();
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    void actuarSiEnCasillaEdificable(){
    
    } 
    
    void actuarSiEnCasillaNoEdificable(){
    
    }
    
    public void aplicarSorpresa(){
    
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador(){
        
    }

    public Sorpresa getCartaActual() {
        return cartaActual;
    }
    
    Dado getDado() {
        return dado;
    }    

    Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }
     
    ArrayList<Sorpresa> getMazo(){
        return this.mazo;
    }
    
    public int getValorDado(){
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void hipotecarPropiedades(int numeroCasilla){
        
    }
    
    private void inicializarCartasSorpresa(){
        mazo = new ArrayList<>();
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
       
    public void inicializarJuego(ArrayList<String> nombres){
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
    }
    
    private void inicializarJugadores(ArrayList<String> nombres){
        jugadores = new ArrayList<>();
        for(String t: nombres)
            this.jugadores.add(new Jugador(t));
    }
    
    private void inicializarTablero(){
        this.tablero = new Tablero();
    }

    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        throw new UnsupportedOperationException("Sin implementar");
    }
            
    public void jugar(){
    
    }
    
    void mover(int numCasillaDestino){
    
    }

    public Casilla obtenerCasillaJugadorActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropidadesJugadorSegunEstadoHipoteca(boolean estadoHipotaca){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void obtenerRanking(){
        
    }
    
    public int obtenerSaldoJugadorActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void salidaJugadores(){
        
    }

    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador(){
    
    }
    
    void tirarDado(){
           
    }
    
    public boolean venderPropiedad(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "Qytetet{" + "mazo=" + mazo + ", tablero=" + tablero + ", cartaActual=" + cartaActual + ",\n jugadores=\n" + jugadores + ", jugadorActual=" + jugadorActual + ", dado=" + dado + '}';
    }
    
    
}