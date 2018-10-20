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

module ModeloQytetet
  class Qytetet
    include Singleton
   public
    @@MAX_JUGADORES = 4
    @@NUM_CASILLAS = 20
   protected
    @@NUM_SORPRESAS = 10
    @@PRECIO_LIBERTAD = 200
    @@SAL_SALIDA = 1000
    
    def initialize
      @cartaActual = nil
      @jugadorActual = nil
      @dado = Dado.instance
      @mazo
      @jugadores
      @tablero
    end
    #aqui no se si se deve crear esta funcion pero bueno y no se si se crea asi
    attr_reader:mazo, :jugadores, :dado, :cartaActual, :jugadorActual 
  public :cartaActual, :jugadores 
    protected :mazo, :jugadorActual, :dado
  private
    attr_writer :cartaActual
    
    def self.MAX_JUGADORES
      return @@MAX_JUGADORES
    end
    
    def self.NUM_CASILLAS
      return @@NUM_CASILLAS
    end
    
   protected 
    def actuarSiEnCasillaEdificable()
      raise NotImplementedError
    end
    
    def actuarSiEnCasillaNoEdificable()
      raise NotImplementedError
    end
   public 
    def aplicarSorpresa()
      raise NotImplementedError
    end
    
    def cancelarHipoteca(numeroCasilla)
      raise NotImplementedError
    end
    
    def comprarTituloPropiedad()
      raise NotImplementedError
    end
    
    def edicicarCasa(numeroCasilla)
      raise NotImplementedError
    end
    
    def edificarHotel(numeroCasilla)
      raise NotImplementedError
    end
   private 
    def encarcelarJugadro()
      raise NotImplementedError
    end
    
   public 
    def getValorDado()
      raise NotImplementedError
    end
    
    def hipotecarPropiedad(numeroCasilla)
      raise NotImplementedError
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
      inicializarTablero()
      inicializarCartasSorpresa()    
      inicializarJugadores(nombres)
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
      raise NotImplementedError
    end
    
    def jugar()
      raise NotImplementedError
    end
   
   protected 
    def mover(numeroCasillaDestino)
      raise NotImplementedError
    end
   
   public 
    def obtenerCasillaJugadorActual()
      raise NotImplementedError
    end
    
    def obtenerCasillasTablero()
      raise NotImplementedError
    end
    
    def obtenerPropiedadesJugador()
      raise NotImplementedError
    end
    
    def obtenerPropiedadesJugadorSegunEstadoHipoteca(estadoHipiteca)
      raise NotImplementedError
    end
    
    def obtenerRanking()
      raise NotImplementedError
    end
    
    def obtenerSaldoJugadorActual()
      raise NotImplementedError
    end
   
   private 
    def salidaJugadores()
      raise NotImplementedError
    end
   
   public 
    def siguienteJugador()
      raise NotImplementedError
    end
   
   protected 
    def tirarDado()
      raise NotImplementedError
    end
   
   public 
    def venderPropiedad(numeroCasilla)
      raise NotImplementedError
    end
  
    def to_s
      "Qytetet: \n carta actual: #{@cartaActual}  \n jugador actual: #{@jugadorActual} \n dado: #{@dado} \n mazo:{ #{@mazo.to_s} } \n jugadores: \n { #{@jugadores} } \n tablero: \n { #{@tablero} }}"
    end
  end
end
