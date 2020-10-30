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
    
    public
    def calcularCosteCancelar()
      raise NotImplementedError 
    end
    
    def calcularCosteHipotecar()
      costeHipotecar = (@hipotecaBase + @numCasas * 0.5 * @hipotecaBase + @numHoteles * @hipotecaBase).to_i
       return costeHipotecar
    end
    
    def calcularImporteAlquiler()
      costeAlquiler = @alquilerBase + (@numCasas*0.5 + @numHoteles*2).to_i
    end
    
    def calcularPrecioVenta()
      precioVenta = (@precioCompra + ( @numCasas + @numHoteles) * @precioEdificar * @factorRevalorizacion).to_i
      return precioVenta
    end
    
    def cancelarHipoteca()
      raise NotImplementedError 
    end
    
    def cobrarAlquiler(coste)
      
    end
    
    def edificarCasa()
      @numCasas += 1
    end
    
    def edificarHotel()
      @numHoteles += 1
    end
    
    def hipotecar()
      setHipotecada(true)
      costeHipoteca = this.calcularCosteHipotecar
      
      return costeHipoteca
    end
    
    def pagarAlquiler
       costeAlquiler = calcularImporteAlquiler()
       @propietario = modificarSaldo(costeAlquiler)
    end
    
    def propietarioEncarcelado()
      @propietario.encarcelado
    end
    
    def tengoPropietario()
      return @propietario != nil
    end
    
    public
    def to_s()
      "Nombre: #{@nombre} \n Hipotecada: #{@hipotecada} \n Precio compra: #{@precioCompra} Alquiler base: #{@alquilerBase} \n Factor de revalorizacion: #{@factorRevalorizacion} \n Hipoteca base: #{@hopotecaBase} \n Precio por edificar: #{@precioEdificar} \n Numero hoteles: #{@numHoteles} \n Nuemro casas: #{@numCasas} \n"
    end
  end
end
