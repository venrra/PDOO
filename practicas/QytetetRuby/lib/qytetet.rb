#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "sorpresa.rb"
require_relative "tipo_sorpresa.rb"
require_relative "tablero"
require_relative "dado"
require_relative "jugador"
require_relative "casilla.rb"
require_relative "estado_juego"

module ModeloQytetet
  class Qytetet
    include Singleton
   public
    @@MAX_JUGADORES = 4
    @@NUM_CASILLAS = 20
   protected
    @@NUM_SORPRESAS = 10
    @@PRECIO_LIBERTAD = 200
    @@SALDO_SALIDA = 1000
    
    def initialize
      @cartaActual = nil
      @jugadorActual = nil
      @dado = Dado.instance
      @mazo
      @jugadores
      @tablero
      @estado = nil
    end
    #aqui no se si se deve crear esta funcion pero bueno y no se si se crea asi
    attr_reader:mazo, :jugadores, :dado, :cartaActual, :jugadorActual, :estado
  public :cartaActual, :jugadores 
    protected :mazo, :jugadorActual, :dado
  
    def setEstadoJuego(estadoJuego)
      @estado=estadoJuego
    end
    
    private
    attr_writer :cartaActual
    
    def self.MAX_JUGADORES
      return @@MAX_JUGADORES
    end
    
    def self.NUM_CASILLAS
      return @@NUM_CASILLAS
    end
    
   public
    def actuarSiEnCasillaEdificable()
      deboPagar = @jugadorActual.deboPagarAlquiler
      
      if deboPagar
        if @jugadorActual.saldo <= 0
          setEstadoJuego(EstadoJuego::ALGUNJUGADORENBANCARROTA)
        end
      end
      
      casilla = @jugadorActual.casillaActual
      tengoPropietario = casilla.tengoPropietario
      
      if @estado != EstadoJuego::ALGUNJUGADORENBANCARROTA
        
        if tengoPropietario
          setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
        else
          setEstadoJuego(EstadoJuego::JA_PUEDECOMPRAROGESTIONAR)
        end
        
      end
    end
    
    def actuarSiEnCasillaNoEdificable()
      setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
      
      casillaActual = @jugadorActual.casillaActual
      
      if casillaActual.tipo == TipoCasilla::IMPUESTO
        
        @jugadorActual.pagarImpuesto
        
        if casillaActual.tipo == TipoCasilla::JUEZ
          encarcelarJugadro
        else if casillaActual.tipo == TipoCasilla::SORPRESA
            cartaActual = @mazo.detete_at(0)
            setEstadoJuego(EstadoJuego::JA_CONSORPRESA)
          end
        end
      end
    end  
 
   public 
    def aplicarSorpresa()
      setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
      
      if @cartaActual.tipo == TipoSorpresa::SALIRCARCEL
        @jugadorActual.setCartalibertad(@cartaActual)
      else
        if @cartaActual.tipo == TipoSorpresa::IRACASILLA
          @jugadorActual.modificarSaldo(@cartaActual.valor);
          if @jugadorActual.saldo <= 0
            setEstadoJuego(EstadoJuego::ALGUNJUGADORENBANCARROTA)
          end
        else if @cartaActual.tipo == TipoSorpresa::IRACASILLA
            valor = @cartaActual.valor
            casillaCarcel = @tablero.esCasillaCarcel(valor)
            
            if casillaCarcel == true
              encarcelarJugadro
            else
              self.mover(valor)
            end
        else if @cartaActual.tipo == TipoSorpresa::PORCASAHOTEL
            cantidad = @cartaActual.valor
            numeroTotal = @jugadorActual.cuantasCasasHoteles
            @jugadorActual.modificarSaldo(cantidad*numeroTotal)
            
            if @jugadorActual.saldo <= 0
              setEstadoJuego(EstadoJuego::ALGUNJUGADORENBANCARROTA)
            end
        else if @cartaActual.tipo == TipoSorpresa::PORJUGADOR
          @jugadores.each do |i|
            if i != @jugadorActual
              
                i.modificarSaldo(@cartaActual.valor)
              
                if i.saldo <= 0
                  setEstadoJuego(EstadoJuego::ALGUNJUGADORENBANCARROTA)
                end
                
                @jugadorActual.modificarSaldo(-@cartaActual.valor)
                
                if @jugadorActual.saldo <= 0
                  setEstadoJuego(EstadoJuego::ALGUNJUGADORENBANCARROTA)
                end
              end
            end
          end        
        end
       end
     end
    end
  end 
    
    def cancelarHipoteca(numeroCasilla)
      raise NotImplementedError
    end
    
    def comprarTituloPropiedad()
      comprado = @jugadorActual.comprarTituloPropiedad
      
      if comprado = true
        setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
      end
      
      return comprado
    end
    
    def edicicarCasa(numeroCasilla)
      
      casilla = @tablero.obtenerCasillaNumero(numeroCasilla)
      titulo = casilla.titulo
      edificada = @jugadorActual.edificarCasa(titulo)
      
      if edificada == true
        setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
      end
      
      return edificada
    end
    
    def edificarHotel(numeroCasilla)
      casilla = @tablero.obtenerCasillaNumero(numeroCasilla)
      titulo = casilla.titulo
      edificada = @jugadorActual.edificarHotel(titulo)
      
      if edificada == true
        setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
      end
      
      return edificada     
    end
   private 
    def encarcelarJugadro()
      if !@jugadorActual.tengoCartaLibertad
        
        casillaCarcel = @tablero.carcel
        @jugadorActual.irACarcel(casillaCarcel)
        setEstadoJuego(EstadoJuego::JA_ENCARCELADO)
      
      else
        
        carta = @jugadorActual.devolverCartaLibertad
        @mazo<<carta
        setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
        
      end
    end
    
   public 
    def getValorDado()
      return  @dado.valor
    end
    
    def hipotecarPropiedad(numeroCasilla)
      casilla = @tablero.obtenerCasillaNumero(numeroCasilla)
      titulo = casilla.titulo
      @jugadorActual.hipotecarPropiedad(titulo)
      setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
    end
    
   private 
    def inicializarCartasSorpresa()
      @mazo = Array.new(@@NUM_CASILLAS)
      #cobras
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PAGARCOBRAR)
      #pagas
      @mazo<< Sorpresa.new("NOSE", +10, TipoSorpresa::PAGARCOBRAR)
      #ir a casilla
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::IRACASILLA)
      #ir a casilla
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::IRACASILLA)
      #IR A LA CARCEL<<<<<<<<<<<<<<<<@tablero.carcel.numeroCasilla<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ARREGLAR
      @mazo<< Sorpresa.new("NOSE", 10, TipoSorpresa::IRACASILLA)
      #recibes por casa/hotel
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PORCASAHOTEL)
      #pagas por casa/hotel
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PORCASAHOTEL)
      #recibes de jugador
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PORJUGADOR)
      #pagar a jugador
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PORJUGADOR)
      #salir carcel
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::SALIRCARCEL)
    end
    
   public 
    def inicializarJuego(nombres)
      inicializarJugadores(nombres)
      inicializarTablero()
      inicializarCartasSorpresa() 
      salidaJugadores()
    end
    
   private 
    def inicializarJugadores(nombres)
      @jugadores = Array.new
       nombres.each do |i|
         @jugadores << Jugador.new(i)
       end
    end
    
    def inicializarTablero()
      @tablero=Tablero.new
    end
    
   public 
    def intentarSalirCarcel(metodo)
      if metodo == MetodoSalirCarcel::TIRANDODADO
        resultado = tirarDado()
        
        if resultado >= 5
          @jugadorActual.encarcelado(false)
        else if metodo == MetodoSalirCarcel::PAGANDOLIBERTAD
              @jugadorActual.pagarLibertad(@@PRECIO_LIBERTAD)
          end
        end
      end
      
      encarcelado = @jugadorActual.encarcelado
      
      if encarcelado 
        setEstadoJuego(EstadoJuego::JA_ENCARCELADO)
      else
        setEstadoJuego(EstadoJuego::JA_PREPARADO)
      end
      
      return !encarcelado
    end
    
    def jugar()
      desplazamiento = self.tirarDado
      numCasilla = @tablero.obtenerCasillaFinal(self.obtenerCasillaJugadorActual, desplazamiento).numeroCasilla
      self.mover(numCasilla)
    end
   
   protected 
    def mover(numCasillaDestino)
      casillaInicial = @jugadorActual.casillaActual
      casillaFinal = @tablero.obtenerCasillaNumero(numCasillaDestino)
      @jugadorActual.casillaActual(casillaFinal)
      
      if numCasillaDestino < casillaInicial.numeroCasilla
        @jugadorActual.modificarSaldo(@@SALDO_SALIDA)
      end
      
      if casillaFinal.soyEdificable
        actuarSiEnCasillaEdificable()
      else
        actuarSiEnCasillaNoEdificable()
      end
        
    end
   
   public 
    def obtenerCasillaJugadorActual()
      raise NotImplementedError
    end
    
    def obtenerCasillasTablero()
      raise NotImplementedError
    end
    
    def obtenerPropiedadesJugador()
      
      numPropiedades = Array.new
      
      @tablero.casillas.each do |i| 
         @jugadorActual.propiedades.each do |j|
            if (i.titulo == j)
                numPropiedades << i.numeroCasilla
            end
         end
      end
          
       return numPropiedades
    end
    
    def obtenerPropiedadesJugadorSegunEstadoHipoteca(estadoHipoteca)
      numPropiedades = Array.new
      
      if estadoHipoteca
        @tablero.casillas.each do |i|
          @jugadorActual.propiedades.each do |j|
            if i.itulo == j && j.hipotecada == estadoHipoteca
              numPropiedades << i.numeroCasilla
            end
          end
        end
      else
        @tablero.casillas.each do |i|
          @jugadorActual.propiedades.each do |j|
            if i.itulo == j && j.hipotecada == estadoHipoteca
              numPropiedades << i.numeroCasilla
            end
          end
        end
      end
      
      return numPropiedades
    end
    
    def obtenerRanking()
      @jugadores=@jugadores.sort
    end
    
    def obtenerSaldoJugadorActual()
      return @jugadorActual.saldo
    end
   
   private 
    def salidaJugadores()
      for i in 0..@jugadores.size
        @jugadores[i].casillaActual(@tablero.btenerCasillaNumero(0))
      end
      
      r = Random.new
      @jugadorActual = @jugadoes[r.rand(@jugadores.size)]
      
      @estado = EstadoJuego::JA_PREPARADO
    end
   
   public 
    def siguienteJugador()
      siguente = @jugadores.index(@jugadorActual)
      siguiente = (siguiente + 1) % @jugadores.size
      @jugadorActual = @jugadores[siguiente]
      
      if @jugadorActual.encarcelado
        @estado = EstadoJuego::JA_ENCARCELADOCONOPCIONDELIBERTAD
      else
        @estado = EstadoJuego::JA_PREPARADO
      end
    end
   
   protected 
    def tirarDado()
      return @dado.tirar
    end
   
   public 
    def venderPropiedad(numeroCasilla)
      casilla = @tablero.obtenerCasillaNumero(numeroCasilla)
      @jugadorActual.venderPropiedad(casilla)
      setEstadoJuego(EstadoJuego::JA_PUEDEGESTIONAR)
    end
  
    def to_s
      "Qytetet: \n carta actual: #{@cartaActual}  \n jugador actual: #{@jugadorActual} \n dado: #{@dado} \n mazo:{ #{@mazo.to_s} } \n jugadores: \n { #{@jugadores} } \n tablero: \n { #{@tablero} }}"
    end
  end
end
