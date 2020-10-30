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
   
    public
    def cancelarHiteca(titulo)
      raise NotImplementedError
    end
    
    def comprarTituloPropiedad()
      costeCompra = @casillaActual.coste
      comprado = false
      
      if costeCompra < @saldo
        titulo = @casillaActial.asgnarPropietario(self)
        @propiedades<<(titulo)
        modificarSaldo(-costeCompra)
        comprado = true
      end
      
     return comprado
    end
    
    def cuantasCasasHotelesTengo()
      contCasasHoteles = 0     
      @propiedades.each do |i|
        contCasasHotele += i.numCasas + i.numHoteles
      end    
      return contCasasHotele
    end
    
    def deboPagarAlquiler()
       deboPagar = false
       titulo = @casillaActual.titulo
       miPropiedad = esDeMiPropiedad(titulo)
       
      if (!miPropiedad)
        tienePropietario = titulo.tengoPropieda
        if (tienePropietario)
          encarcelado = titulo.propietarioEncarcelado
          if(!encarcelado)
            estaHipotecada = titulo.hipotecada
            deboPagar = !miPropiedad & tienePropietario & !encarcelado & !estaHipotecada
          end
        end
      end
      
      return deboPagar
    end
    
    def devolverCartaLibertad()
      aux = @cartaLibertad
      
      if (@cartaLibertad != nil)
        @cartaLibertad = nil
      end
      
      return aux
    end
    
    def edificarCasa(titulo)
      edificada = false
      numCasas = titulo.numCasas
      
      if numCasas < 4
        costeEdificar = titulo.precioEdificar
        tengo = tengoSaldo(costeEdificar)
        
        if tengo
          
          titulo.edificarCasa
          modificarSaldo(-costeEdificarCasa)
          edificada = true
          
        end
      end
      
      return edificada
    end
    
    def edificarHotel(titulo)
      edificada = false
      numHoteles = titulo.numHoteles
      
      if numCasas < 4
        costeEdificar = titulo.precioEdificar
        tengo = tengoSaldo(costeEdificar)
        
        if tengo
          
          titulo.edificarHotel
          modificarSaldo(-costeEdificarHotel)
          edificada = true
          
        end
      end
      
      return edificada      
    end
    
    private
    def eliminarDeMisPropiedades(titulo)
        @propiedades.remove(titulo)
         titulo.propietario(null)
    end
    
    def esDeMiPropiedad(titulo)
     
      for i in 0..@propiedades.size   
        if(@propiedades[i] == titulo)
          return true
        end
      end
      
      return false
    end
    
    public
    def estoyEnCalleLibre()
      raise NotImplementedError 
    end
    
    def hipotecarPropiedad(titulo)
      costeHipoteca = titulo.hipotecar
      modificarSaldo(costeHipoteca)
    end
    
    def irACarcel(casilla)
      @casillaActual = casilla
      @encarcelado = true
    end
    
    def modificarSaldo(cantidad)
      @saldo +=cantidad
      
      return @saldo
    end
    
    def obtenerCapital()
      capital = @saldo
      
      @propiedades.each do |i|
        capital += i.precioCompra + (i.numCasas + i.numHoteles) * i.precioEdificar;
        if(i.hipotecada)
          capital -= i.hopotecaBase
        end
      end
      
      return capital
    end
    
    def obtenerPropiedades(estadoHipoteca)
      titulosHipoteca = Array.new
      
      if(estadoHipoteca == true)
        @propiedades.each do |i|
          if i.hipotecada == true
            titulosHipoteca<<i
          end
        end
      else
        @propiedades.each do |i|
          if i.hipotecada == false
            titulosHipoteca<<i
          end
        end
      end
    end
         
    def pagarAlquiler()
      costeAlquiler = @casillaActual.pagarAlquiler
      modificarSaldo(-costeAlquiler)
    end
    
    def pagarImpuesto()
      @saldo -=  @casillaActual.coste
    end
    
    def pagarLibertad(cantidad)
      tengoSaldo = tengoSaldo(cantidad)
      
      if tengoSaldo 
        encarcelado(false)
        modificarSaldo(cantidad)
      end
    end
    
    def tengoCartaLibertad()
      return @cartaLibertad != nil
    end
    
    private
    def tengoSalgo(cantidad)
      return (@saldo>cantidad)
    end
    
    public
    def venderPropiedad(casilla)
      titulo = casilla.titulo
      eliminarDeMisPropiedades(titulo)
      precioVenta = titulo.calcularPrecioVenta
      modificarSaldo(precioVenta)
    end
    
    public
    def to_s
      "Jugador: \n nombre: #{@nombre}  \n encarcelado: #{@encarcelado} \n casilla actual: #{@casillaActual} \n carta libertad:#{@cartaLibertad} \n jugadores: \n propiedades: #{@propiedades.to_s} \n saldo: \n  #{@saldo} \n capital #{self.obtenerCapital}}"
    end
    
    def <=>(otroJugador)
      otroJugador.obtenerCapital <=> obtenerCapital
    end
  end
end
