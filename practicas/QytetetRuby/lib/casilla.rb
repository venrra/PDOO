#encoding :utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#require_relative "tipo_casilla"
requiere_relative "tipo_casilla"

module ModeloQytetet
  class Casilla
    
    def initialize(unNumeroCasilla, unTipo, unTitulo)
      @numeroCasilla = unNumeroCasilla  #numero de la casilla             
      @tipo = unTipo          #indica el tipo de la casilla
      @titulo = unTitulo       #asocia la casilla a su titulo de propiedad
      @coste = (unTitulo!=nil)  ? unTitulo.precioCompra() : 0 #para indicar el coste si es de tipo CALLE sera tomado del precioCompra de su titulo propiedad
    end
    
    #CONSTRUCTOR de casilla sin titulo usa initialize, que actua como constructor de casilla de tipo calle por defecto

    def self.casilla_sin_titulo(unNumeroCasilla, unTipo)
      self.new(unNumeroCasilla, unTipo, nil)
    end
   public 
    attr_reader :numeroCasilla ,:coste, :tipo, :titulo
    
   private    
    attr_writer :titulo
    
    public
    def asgnarPropietario(jugador)
      @titulo.propietario(jugador)
      
      return @titulo
    end
    
    def pagarAlquiler()
      costeAlquiler = @titulo.pagarAlquiler
      return costeAlquiler
    end
    
    def propietarioEncarcelado()
        return @titulo.propietarioEncarcelado
    end   
    
    def soyEdificable()
      edificable = true
      
      if @tipo != TipoCasilla::CALLE
        edificable = false
      end
      
      return edificable
    end
    
    def tengoPropietario()
      return @titulo.tengoPropietario
    end
    
    public
    def to_s()
      "Nunmero de casilla: #{@numeroCasilla} \n Coste: #{@Coste} \n Tipo de casilla: #{@tipo} \n"
      if (@titulo != nil)
        "Titulo propiedad: #{@titulo} \n"
      end
    end
    
  end
end
