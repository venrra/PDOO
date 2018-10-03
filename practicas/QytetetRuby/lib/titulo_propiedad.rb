#encoding :utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class TituloPropiedad
    def initialize(unNombre, unPrecioCompra, unAlquilerBase, factorRevalorizacion, unHipotecaBasa, unPrecioEdificar)
      @nombre = unNombre
      @hipotecada = false
      @precioCompra = unPrecioCompra
      @alquilerBase = unAlquilerBase
      @factorRevalorizacion = factorRevalorizacion
      @hipotecaBase = unHipotecaBasa
      @precioEdificar = unPrecioEdificar
      @numHoteles = 0
      @numCasas = 0
    end
    
    attr_reader :nombre,:precioCompra,:alquilerBase,:factorRevalorizacion,:hopotecaBase,:precioEdificar,:numHoteles,:numCasas
    attr_accesor :hipotecada
    
    def to_s()
      "Nombre: #{@nombre} \n Hipotecada: #{@Hipotecada} \n Precio compra: #{@precioCompra} Alquiler base: #{@alquilerBase} \n Factor de revalorizacion: #{@factorRevalorizacion} \n Hipoteca base: #{@hopotecaBase} \n Precio por edificar: #{@precioEdificar} \n Numero hoteles: #{@numHoteles} \n Nuemro casas: #{@numCasas} \n"
    end
  end
end
