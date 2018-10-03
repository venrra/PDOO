#encoding :utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "tipo_casilla"

module ModeloQytetet
  class Casilla
    
    attr_reader:numeroCasilla ,:coste, :tipo, :titulo
    ############################################################################
    attr_writter private :titulo=
    
    def initialize(unNumeroCasilla, unTipo, unTitulo)
    @numeroCasilla = unNumeroCasilla  #numero de la casilla
    @coste =  0              #para indicar el coste si es de tipo CALLE sera tomado del precioCompra de su titulo propiedad
    @tipo = unTipo          #indica el tipo de la casilla
    @titulo = unTitulo       #asocia la casilla a su titulo de propiedad
      if(unTitulo!=nil)
        @coste=unTitulo.precioCompra()
      end
    end
    
    def self.casilla_sin_titulo(unNumeroCasilla, unTipo)
      self.new(unNumeroCasilla, unTipo, nil)
    end
    
    def to_s()
      "Nunmero de casilla: #{@numeroCasilla} \n Coste: #{@Coste} \n Tipo de casilla: #{@tipo} \n"
      if (@titulo != nil)
        "Titulo propiedad: #{@titulo} \n"
      end
    end
    
  end
end
