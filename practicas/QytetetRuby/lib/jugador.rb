# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Jugador
    def initialize(nombre)
      @nombre = nombre
      @encarcelado = false
      @casillaActual = nil
      @cartaLibertad = nil
      @propiedades = Array.new
      @saldo = 7500
    end
    
    attr_accessor :cartaLibertad, :casillaActual, :encarcelado
    attr_reader :nombre, :propiedades, :saldo 
    public :saldo
   
    protected
    def cancelarHiteca(titulo)
      raise NotImplementedError
    end
    
    def comprarTituloPropiedad()
      raise NotImplementedError 
    end
    
    def cuantasCasasHotelesTengo()
      raise NotImplementedError 
    end
    
    def deboPagarAlquiler()
      raise NotImplementedError 
    end
    
    def devolverCartaLibertad()
      raise NotImplementedError 
    end
    
    def edificarCasa(titulo)
      raise NotImplementedError 
    end
    
    def edificarHotel(titulo)
      raise NotImplementedError 
    end
    
    private
    def eliminarDeMisPropiedades(titulo)
      raise NotImplementedError 
    end
    
    def esDeMiPropiedad(titulo)
      raise NotImplementedError 
    end
    
    protected
    def estoyEnCalleLibre()
      raise NotImplementedError 
    end
    
    def hipotecarPropiedad(titulo)
      raise NotImplementedError
    end
    
    def irACarcel(casilla)
      raise NotImplementedError
    end
    
    def modificarSaldo(cantidad)
      raise NotImplementedError
    end
    
    def obtenerCapital()
      raise NotImplementedError
    end
    
    def obtenerPropiedades(hipotecada)
      raise NotImplementedError
    end
    
    def pagarAlquiler()
      raise NotImplementedError
    end
    
    def pagarImpuesto()
      raise NotImplementedError
    end
    
    def pagarLibertad()
      raise NotImplementedError
    end
    
    def tengoCartaLibertad()
      raise NotImplementedError
    end
    
    private
    def tengoSalgo(cantidad)
      raise NotImplementedError
    end
    
    protected
    def venderPropiedad()
      raise NotImplementedError
    end
    
    public
    def to_s
      "Jugador: \n nombre: #{@nombre}  \n encarcelado: #{@encarcelado} \n casilla actual: #{@casillaActual} \n carta libertad:#{@cartaLibertad} \n jugadores: \n propiedades: #{@propiedades.to_s} \n saldo: \n  #{@saldo}}"
    end
    
  end
end
