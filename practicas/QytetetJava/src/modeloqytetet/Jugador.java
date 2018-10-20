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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
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
    
    int modificarSaldo(int capacidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipoteca){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarAlquiler(){
    
    }
    
    void pagarImpuesto(){
    
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
        throw new UnsupportedOperationException("Sin implementar");
    }
            
    private boolean tengoSaldo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        String s = "Jugador{" + "nombre=" + nombre + ", encarcelado=" + encarcelado + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + ", saldo=" + saldo;
        if (propiedades.size() != 0)
            s += ", propiedades=" + propiedades ;
        s += '}' + "\n";
        
        return s;
    }
}