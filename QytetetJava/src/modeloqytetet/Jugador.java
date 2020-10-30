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
public class Jugador implements Comparable{
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
        int costeCompra = this.casillaActual.getCoste();
        boolean comprado=false;
        if (costeCompra < this.saldo){
            
            TituloPropiedad titulo = this.casillaActual.asignarPropietario(this);
            
            this.propiedades.add(titulo);
            
            this.modificarSaldo(-costeCompra);
            
            comprado=true;
        }
        
        return comprado;
    }
    
    int cuantasCasasHoteles(){
        int cont_CasasHotel=0;
        for (TituloPropiedad i: this.propiedades)
            cont_CasasHotel += i.getNumCasas() + i.getNumHoteles();
        return cont_CasasHotel;
    }
    
    boolean deboPagarAlquiler(){
        boolean deboPagar = false;
        TituloPropiedad titulo = casillaActual.getTitulo();
        boolean esDeMiPropiedad = this.esdeMiPropiedad(titulo);

        if(!esDeMiPropiedad){
            boolean tienePropietario = titulo.tengoPropiedad();
            if(tienePropietario){
                boolean encarcelado = titulo.propietarioEncarcelado();
                if(!encarcelado){
                    boolean estaHipotecada = titulo.getHipotecada();
                    deboPagar = !esDeMiPropiedad & tienePropietario & !encarcelado & !estaHipotecada;
                }
            }
        }
        
        return deboPagar;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa aux  = this.cartaLibertad;
        
        if(cartaLibertad != null){
            cartaLibertad = null;
        }
        
        return aux;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificada = false;
        int numCasas = titulo.getNumCasas();
       
        if(numCasas < 4){
            
            int costeEdificarCasa = titulo.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarCasa);
            
            if(tengoSaldo){
                
                titulo.edificarCasa();
                this.modificarSaldo(-costeEdificarCasa);            
                edificada = true;
            }
        }
        
        return edificada;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificada = false;
        int numHoteles = titulo.getNumHoteles();
       
        if(numHoteles < 4){
            
            int costeEdificarHotel = titulo.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarHotel);
            
            if(tengoSaldo){
                
                titulo.edificarHotel();
                this.modificarSaldo(-costeEdificarHotel);            
                edificada = true;
            }
        }
        
        return edificada;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        propiedades.remove(titulo);
        titulo.setPropietario(null);
    } 
    
    private boolean esdeMiPropiedad(TituloPropiedad titulo){
        return this.propiedades.contains(titulo);
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sinsi implementar");
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
    
    void hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca = titulo.hipotecar();
        this.modificarSaldo(costeHipoteca);
    }
    
    void irACarcel(Casilla casilla){
        this.setCasillaActual(casilla);
        this.setEncarcelado(true);
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
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean estadoHipoteca){
        ArrayList<TituloPropiedad> titulosHipoteca = new ArrayList<>();
        
        if (estadoHipoteca == true){
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
        
        int costeAlquiler = this.casillaActual.pagarAlquiler();
        
        this.modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto(){
        this.saldo -= this.casillaActual.getCoste();
    }

    void pagarLibertad(int cantidad){
        boolean tengoSaldo = this.tengoSaldo(cantidad);
        
        if(tengoSaldo){
            this.setEncarcelado(false);
            this.modificarSaldo(cantidad);
        }
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
    
    void venderPropiedad(Casilla casilla){
        TituloPropiedad titulo = casilla.getTitulo();
        
        this.eliminarDeMisPropiedades(titulo);
        
        int precioVenta = titulo.calcularPrecioVenta();
        
        this.modificarSaldo(precioVenta);        
    }
    
    @Override
    public String toString() {
        String s = "Jugador{" + "nombre=" + nombre + ", encarcelado=" + encarcelado + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + ", saldo=" + saldo + ", capital=" + this.obtenerCapital();
        if (propiedades.size() != 0)
            s += ", propiedades=" + propiedades ;
        s += '}' + "\n";
        
        return s;
    }

    @Override
    public int compareTo(Object otroJugador) {
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital - obtenerCapital();
    }
}