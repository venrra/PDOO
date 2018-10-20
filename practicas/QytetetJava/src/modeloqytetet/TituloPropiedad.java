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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularImporteAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularPrecioVenta(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cobrarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }

    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    
    boolean tengoPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
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
