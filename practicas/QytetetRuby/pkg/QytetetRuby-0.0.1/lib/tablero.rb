#encoding :utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "tipo_casilla.rb"
require_relative "casilla.rb"
require_relative "titulo_propiedad"

module ModeloQytetet
  class Tablero
    
    def initialize
      @casillas = Array.new
      @carcel = nil
      
      inicializar()
    end
    
    public
    attr_reader :casillas, :carcel
    
    def esCasillaCarcel(numeroCasilla)
      raise NotImplementedError 
    end
    
    def inicializar()  

      @casillas<< Casilla.casilla_sin_titulo(0, TipoCasilla::SALIDA)
      @casillas<< Casilla.new(1, TipoCasilla::CALLE,  TituloPropiedad.new("HOLA",0,0,0,0,0))
      @casillas<< Casilla.casilla_sin_titulo(2, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(3, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(4, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(5, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(6, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(7, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(8, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(10, TipoCasilla::CARCEL)
      @casillas<< Casilla.casilla_sin_titulo(11, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(12, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(13, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(14, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(15, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(16, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(17, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(18, TipoCasilla::SORPRESA)
      @casillas<< Casilla.casilla_sin_titulo(19, TipoCasilla::SORPRESA)

      @carcel = @casillas.select{|i| i.tipo == TipoCasilla::CARCEL}
    end
     private :inicializar
    
    protected
    def obtenerCasillaFinal(casilla, desplazamiento) 
      raise NotImplementedError 
    end
    
    def obtenerCasillaNumero(numeroCasilla)
      raise NotImplementedError 
    end
    
    public
    def to_s
      "Tablero: \n casillas:{ #{@casillas} } \n carcel: #{@carcel}"
    end
  end
end
