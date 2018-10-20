#encoding :utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "tipo_sorpresa"
require_relative "qytetet"

module ModeloQytetet
  class PruebaQytetet
    #for i in(0..9)
    #10.times do |num|
      @@juego = Qytetet.instance
      
      def self.getNombreJugadores()
        nombres = Array.new
        for i in 1..Qytetet.MAX_JUGADORES
          nombres << gets
        end
        return nombres
      end
=begin    
    def self.metodo1
      nuevo_mazo = Array.new
      
      @@juego.mazo.each do |i| 
        if i.valor > 0
          nuevo_mazo<< i
        end
      end
      return nuevo_mazo
    end
    
    def self.metodo2
      nuevoMazo = Array.new
      
      @@juego.mazo.each do |i|
        if i.tipo == TipoSorpresa::IRACASILLA
          nuevoMazo<< i
        end
      end
      return nuevoMazo
    end
    
    def self.metodo3(unTipo)
      nuevoMazo = Array.new
      
      @@juego.mazo.each do |i|
        if i.tipo == unTipo
          nuevoMazo<< i
        end
      end
      return nuevoMazo
    end
=end    
    def self.main
      
      nombres = getNombreJugadores
      @@juego.inicializarJuego(nombres)
      puts @@juego.to_s
=begin
      puts metodo1()
      puts "METODO 2///////////////////\n"
      puts metodo2()
      puts "METODO 3///////////////////\n"
        tipo=TipoSorpresa::constants
        for i in tipo
          puts metodo3(TipoSorpresa.const_get(i))
        end
      
      puts "Prueba inspect/////////////\n"
      puts @@juego.mazo.inspect
=end 
    end
  end
  
 PruebaQytetet.main
 
end

#ModeloQytetet::PruebaQytetet.main