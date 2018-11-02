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
public class Jugador {
    private String nombre;
    private boolean encarcelado;
    private Casilla casillaActual;
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> propiedades;
    private int saldo;

    Jugador(String nombre) {
        this.nombre = nombre;
        setEncarcelado(false);
        this.casillaActual = null;
        this.cartaLibertad = null;
        this.propiedades = new ArrayList<>();
        this.saldo = 7500;
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cuantasCasasHoteles(){
        int cont_CasasHotel=0;
        for (TituloPropiedad i: this.propiedades)
            cont_CasasHotel += i.getNumCasas() + i.getNumHoteles();
        return cont_CasasHotel;
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa aux  = this.cartaLibertad;
        
        if(cartaLibertad != null){
            cartaLibertad = null;
        }
        
        return aux;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        
    } 
    
    private boolean esdeMiPropiedad(TituloPropiedad titulo){
        return this.propiedades.contains(titulo);
    }

    String getNombre() {
        return nombre;
    }

    boolean getEncarcelado() {
        return encarcelado;
    }

    Casilla getCasillaActual() {
        return casillaActual;
    }

    Sorpresa getCartalibertad() {
        return cartaLibertad;
    }

    ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }    

    public int getSaldo() {
        return saldo;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla casilla){
        
    }
    
    int modificarSaldo(int cantidad){
        this.saldo += cantidad;
        
        return getSaldo();
    }
    
    int obtenerCapital(){
        int capital = saldo;
        
        for (TituloPropiedad i: propiedades){
            capital += i.getPrecioCompra() + (i.getNumCasas() + i.getNumHoteles()) * i.getPrecioEdificar();
            if ( i.getHipotecada() )
                capital -= i.getHipotecaBase();
        }
        
        return capital;
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipoteca){
        ArrayList<TituloPropiedad> titulosHipoteca = new ArrayList<>();
        
        if (hipoteca == true){
            for ( TituloPropiedad i : propiedades)
                if (i.getHipotecada() == true)
                    titulosHipoteca.add(i);
        }else{
            for ( TituloPropiedad i : propiedades)
                if (i.getHipotecada() == false)
                    titulosHipoteca.add(i);
        }
     
            
        return titulosHipoteca;
    }
    
    void pagarAlquiler(){
    
    }
    
    void pagarImpuesto(){
        this.saldo -= this.casillaActual.getCoste();
    }

    void pagarLibertad(int cantidad){
    
    }
    
    public void setCartalibertad(Sorpresa carta) {
        this.cartaLibertad = carta;
    }

    public void setCasillaActual(Casilla casilla) {
        this.casillaActual = casilla;
    }  
    
    public void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }
    
    boolean tengoCartaLibertad(){
        return this.cartaLibertad != null;
    }
            
    private boolean tengoSaldo(int cantidad){
        return ( saldo > cantidad );
    }
    
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    /*@Override
    public int compareTo(Object otroJugador) {
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital ­ obtenerCapital();
    }*/
    
    @Override
    public String toString() {
        String s = "Jugador{" + "nombre=" + nombre + ", encarcelado=" + encarcelado + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + ", saldo=" + saldo + ", capital=" + this.obtenerCapital();
        if (propiedades.size() != 0)
            s += ", propiedades=" + propiedades ;
        s += '}' + "\n";
        
        return s;
    }
}