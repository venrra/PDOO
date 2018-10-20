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
public class Casilla {
    private int numeroCasilla;//numero de la casilla
    private int coste;        //para indicar el coste si es de tipo CALLE sera tomado del precioCompra de su titulo propiedad
    private TipoCasilla tipo; //indica el tipo de la casilla
    private TituloPropiedad titulo;//asocia la casilla a su titulo de propiedad
    
    //Constructor con parametros para casillas que no son tipo CALLE
    Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = 0;
        this.tipo = tipo;
        this.titulo = null;
    }
    
    //Constructor con parametros para casillas tipo CALLE se le pasas titulopropiedad de donde se optienen tambein el coste
    Casilla(int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.coste = titulo.getPrecioCompra();
        this.tipo = TipoCasilla.CALLE;
        //usamos un metodo auxiliar para inicializar el titulo
        setTitulo(titulo);
    }
    
    TituloPropiedad asignarPropiedad(Jugador jugador){
        throw new UnsupportedOperationException("Sin implementar");
    }

    int getCoste() {
        return coste;
    }
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }
 
    TipoCasilla getTipo() {
        return tipo;
    }
 
    public TituloPropiedad getTitulo() {
        return titulo;
    }
    
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    boolean soyEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        String string = "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", tipo=" + tipo;
        //si el titulo es null quiere decir que no necesita titulo y por lo tanto no deve aparecer
        if (this.titulo!=null)      
            string += ", titulo=" + titulo;
        
        string += "}\n";
        
        return string; 
    }
    
}
