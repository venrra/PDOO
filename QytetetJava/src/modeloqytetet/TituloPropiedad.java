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
public class TituloPropiedad {
    private String nombre;      //Nombre del titulo
    private boolean hipotecada; //para indicar si el titulo esta hipotecado o no
    private int precioCompra;   //indica el precio de la compra
    private int alquilerBase;   //indica el precio base(sin edificaciones)que debe pagar quien caiga en la casilla
    private float factorRevalorizacion;//indica cuanto se revaloriza en el perido trascurrido desde su compra ysu venta
    private int hipotecaBase;   //valor base de la hipoteca
    private int precioEdificar; //indica el precio de edificar
    private int numHoteles;     //numero hoteles
    private int numCasas;       //numero casas
    private Jugador propietario;

    //CONSTRUCTOR por defecto hepotecada = true ,numHoteles=0 y numCasa=0
    TituloPropiedad(String nombre, int precioCompra, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        setHipotecada(false);
        this.precioCompra = precioCompra;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;   
        this.precioEdificar = precioEdificar;
        this.numHoteles = 0;
        this.numCasas = 0;
        this.propietario = null;
    }
    
    int calcularCosteCancelar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularCosteHipotecar(){
        int costeHipotecar = (int) (hipotecaBase + numCasas * 0.5 * hipotecaBase + numHoteles * hipotecaBase);
        return costeHipotecar;
    }
    
    int calcularImporteAlquiler(){
        int costeAlquiler = this.alquilerBase + (int)(numCasas*0.5 + numHoteles*2);
        
        this.propietario.modificarSaldo(costeAlquiler);
        
        return costeAlquiler; 
    }
    
    int calcularPrecioVenta(){
        int precioVenta = (int)(this.precioCompra + ( this.numCasas + this.numHoteles) * this.precioEdificar * this.factorRevalorizacion);
        return precioVenta;
    }
    
    void cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cobrarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        this.numCasas += 1;
    }
    
    void edificarHotel(){
       this.numHoteles += 1;
    }
    
    String getNombre() {
        return nombre;
    }

    boolean getHipotecada() {
        return hipotecada;
    }

    int getPrecioCompra() {
        return precioCompra;
    }

    int getAlquilerBase() {
        return alquilerBase;
    }

    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    int getPrecioEdificar() {
        return precioEdificar;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    int getNumCasas() {
        return numCasas;
    }

    Jugador getPropietario() {
        return propietario;
    }
   
    int hipotecar(){
        this.setHipotecada(true);
        int costeHipoteca = this.calcularCosteHipotecar();

        return costeHipoteca;
    }

    int pagarAlquiler(){
        int costeAlquiler = this.calcularImporteAlquiler();
        this.propietario.modificarSaldo(costeAlquiler);
        
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado(){
        return this.propietario.getEncarcelado();
    }
    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    
    boolean tengoPropiedad(){
        return this.propietario != null;
    }
    
    @Override
    public String toString() {
        
        String s = "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas;
        if (propietario != null)
            s += propietario.getNombre();
        s += '}';
        
        return s;
    }
    
}
