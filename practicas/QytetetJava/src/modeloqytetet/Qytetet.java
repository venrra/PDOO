/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
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
    private EstadoJuego estado;
    
    private Qytetet() {
        this.cartaActual = null;
        this.jugadorActual = null;
        this.dado = Dado.getinstance();
        //this.estado=
    }
    
    private static final Qytetet instance = new Qytetet();
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    void actuarSiEnCasillaEdificable(){
        boolean deboPagar = jugadorActual.deboPagarAlquiler();
        
        if (deboPagar){
            jugadorActual.pagarAlquiler();
            if(jugadorActual.getSaldo()<=0)
                this.setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
        }
        
        Casilla casilla = jugadorActual.getCasillaActual();
        boolean tengoPropietario = casilla.tengoPropietario();
        
        if (this.estado != EstadoJuego.ALGUNJUGADORENBANCARROTA){
            
            if(tengoPropietario)
                this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
            else
                this.setEstadoJuego(EstadoJuego.JA_PUEDECOMPRAROGESTIONAR);
        }
    }
    
    void actuarSiEnCasillaNoEdificable(){
        this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        Casilla casillaActual = this.jugadorActual.getCasillaActual();
        
        if (casillaActual.getTipo() == TipoCasilla.IMPUESTO){
            
            this.jugadorActual.pagarImpuesto();
            
            if (casillaActual.getTipo() == TipoCasilla.JUEZ){
                
                this.encarcelarJugador();
            
            }else if(casillaActual.getTipo() == TipoCasilla.SORPRESA){
                cartaActual = mazo.remove(0);
                this.setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
            }
        }
        
    }
    
    public void aplicarSorpresa(){
        this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        if (this.cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            
            this.jugadorActual.setCartalibertad(cartaActual);
        
        }else{
            if(this.cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
                
                this.jugadorActual.modificarSaldo(cartaActual.getValor());
                
                if(this.jugadorActual.getSaldo() <= 0)
                    this.setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    
            }else if(this.cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
                    
                int valor = cartaActual.getValor();
                boolean casillaCarcel = tablero.esCasillaCarcel(valor);
                
                if(casillaCarcel == true)
                    this.encarcelarJugador();
                else
                    this.mover(valor);
                
            }else if(this.cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
                
               int cantidad = this.cartaActual.getValor();
               
               int numeroTotal = this.jugadorActual.cuantasCasasHoteles();
               
               this.jugadorActual.modificarSaldo(cantidad*numeroTotal);
               
               if(this.jugadorActual.getSaldo() <= 0)
                   this.setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
               
            }else if(this.cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
                for(Jugador i : jugadores){
                    
                    if(i != jugadorActual){
                        
                        i.modificarSaldo(cartaActual.getValor());
                        
                        if (i.getSaldo() <= 0)
                            this.setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        
                        this.jugadorActual.modificarSaldo(-this.cartaActual.getValor());
                        
                        if (this.jugadorActual.getSaldo() <= 0)
                            this.setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    }
                }
            }
        }
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        boolean comprado = this.jugadorActual.comprarTituloPropiedad();
        
        if(comprado == true)
            this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return comprado;
        
    }
    
    public boolean edificarCasa(int numeroCasilla){
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        boolean edificada = this.jugadorActual.edificarCasa(titulo);
        
        if(edificada == true)
            this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return edificada;
    }
    
    public boolean edificarHotel(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        boolean edificada = this.jugadorActual.edificarHotel(titulo);
        
        if (edificada == true)
            this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return edificada;
    }
    
    private void encarcelarJugador(){
        if (!this.jugadorActual.tengoCartaLibertad()){
           
            Casilla casillaCarcel = tablero.getCarcel();
            this.jugadorActual.irACarcel(casillaCarcel);
            this.setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
            
        }else{
            
            Sorpresa carta = this.jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
            this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);

        }
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
        return this.dado.getValor();
    }

    public void hipotecarPropiedades(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        this.jugadorActual.hipotecarPropiedad(titulo);
        this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
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
        salidaJugadores();
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
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int resultado = this.tirarDado();
           
            if(resultado >= 5){
                
                this.jugadorActual.setEncarcelado(false);
           
            }else if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
                
                this.jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
                
            }
        }
            
        boolean encarcelado = this.jugadorActual.getEncarcelado();

        if(encarcelado)
            this.setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        else
            this.setEstadoJuego(EstadoJuego.JA_PREPARADO);
        
        return !encarcelado;
    }
            
    public void jugar(){
        int desplazamiento = this.tirarDado();
        int numCasilla = this.tablero.obtenerCasillaFinal(this.obtenerCasillaJugadorActual(), desplazamiento).getNumeroCasilla();
        this.mover(numCasilla);
    }
    
    void mover(int numCasillaDestino){
        
        Casilla casillaInicial = jugadorActual.getCasillaActual();
        Casilla casillaFinal = tablero.obtenerCasillaNumero(numCasillaDestino);
        this.jugadorActual.setCasillaActual(casillaFinal);
        
        if(numCasillaDestino < casillaInicial.getNumeroCasilla())
            this.jugadorActual.modificarSaldo(SALDO_SALIDA);
        
        if(casillaFinal.soyEdificable())
            this.actuarSiEnCasillaEdificable();
        else
            this.actuarSiEnCasillaNoEdificable();

    }

    public Casilla obtenerCasillaJugadorActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador(){
        ArrayList<Integer> numPropiedades = new ArrayList<>();
        for (Casilla i: tablero.getCasillas())
            for(TituloPropiedad j : jugadorActual.getPropiedades())
                if (i.getTitulo() == j)
                    numPropiedades.add(i.getNumeroCasilla());
        
        return numPropiedades;
    }
    
    public ArrayList<Integer> obtenerPropidadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca){
        ArrayList<Integer> numPropiedades = new ArrayList<>();        
        if (estadoHipoteca){
            for (Casilla i: tablero.getCasillas())
                for(TituloPropiedad j : jugadorActual.getPropiedades())
                    if (i.getTitulo() == j && j.getHipotecada() == estadoHipoteca)
                        numPropiedades.add(i.getNumeroCasilla());
        }else
            for (Casilla i: tablero.getCasillas())
                for(TituloPropiedad j : jugadorActual.getPropiedades())
                    if (i.getTitulo() == j && j.getHipotecada() == estadoHipoteca)
                        numPropiedades.add(i.getNumeroCasilla());
        
        return numPropiedades;
    }
    
    public void obtenerRanking(){
        Collections.sort(this.jugadores);
    }
    
    public int obtenerSaldoJugadorActual(){
        return jugadorActual.getSaldo();
    }
    
    private void salidaJugadores(){
        for (int i=0; i < jugadores.size(); i++)
            jugadores.get(i).setCasillaActual(tablero.obtenerCasillaNumero(0));
        
        Random r = new Random();
        jugadorActual = jugadores.get( r.nextInt( jugadores.size() ));
        
        estado = EstadoJuego.JA_PREPARADO;
    }

    public void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    void setEstadoJuego(EstadoJuego estadoJuego){
        this.estado=estadoJuego;
    }
    
    public void siguienteJugador(){
        int siguiente = jugadores.indexOf(jugadorActual);
        siguiente = (siguiente + 1) % jugadores.size();
        jugadorActual = jugadores.get(siguiente);
        
        if (jugadorActual.getEncarcelado())
            estado = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        else 
            estado = EstadoJuego.JA_PREPARADO;
    }
    
    int tirarDado(){
        return this.dado.tirar();
    }
    
    public void venderPropiedad(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        this.jugadorActual.venderPropiedad(casilla);
        
        this.setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }

    @Override
    public String toString() {
        return "Qytetet{" + "mazo=" + mazo + ", tablero=" + tablero + ", cartaActual=" + cartaActual + ",\n jugadores=\n" + jugadores + ", jugadorActual=" + jugadorActual + ", dado=" + dado + '}';
    }
    
    
}