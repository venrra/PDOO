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
      @propietario = nil
    end
    
    attr_reader :nombre,:precioCompra,:alquilerBase,:factorRevalorizacion,:hopotecaBase,:precioEdificar,:numHoteles,:numCasas
    attr_accessor :hipotecada, :propietario
    private :hipotecada
    
    protected
    def calcularCosteCancelar()
      raise NotImplementedError 
    end
    
    def calcularCosteHipotecar()
      raise NotImplementedError 
    end
    
    def calcularImporteAlquiler()
      raise NotImplementedError 
    end
    
    def calcularPrecioVenta()
      raise NotImplementedError 
    end
    
    def cancelarHipoteca()
      raise NotImplementedError 
    end
    
    def cobrarAlquiler(coste)
      
    end
    
    def edificarCasa()
      #void
      raise NotImplementedError 
    end
    
    def edificarHotel()
      #void
      raise NotImplementedError 
    end
    
    def hipotecar()
      raise NotImplementedError 
    end
    
    def pagarAlquiler
      raise NotImplementedError 
    end
    
    def propietarioEncarcelado()
      raise NotImplementedError 
    end
    
    def tengoPropietario()
      raise NotImplementedError 
    end
    
    public
    def to_s()
      "Nombre: #{@nombre} \n Hipotecada: #{@hipotecada} \n Precio compra: #{@precioCompra} Alquiler base: #{@alquilerBase} \n Factor de revalorizacion: #{@factorRevalorizacion} \n Hipoteca base: #{@hopotecaBase} \n Precio por edificar: #{@precioEdificar} \n Numero hoteles: #{@numHoteles} \n Nuemro casas: #{@numCasas} \n"
    end
  end
end
