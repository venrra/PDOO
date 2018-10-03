#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "sorpresa.rb"
require_relative "tipo_sorpresa.rb"

module ModeloQytetet
  class Qytetet
    def initialize
      @mazo = Array.new
    end

    attr_reader:mazo

    def inicializarCartasSorpresa()
      #cobras
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::PAGARCOBRAR)
      #pagas
      @mazo<< Sorpresa.new("NOSE", +10, TipoSorpresa::PAGARCOBRAR)
      #ir a casilla
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::IRACASILLA)
      #ir a casilla
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::IRACASILLA)
      #IR A LA CARCEL
      @mazo<< Sorpresa.new("NOSE", 0, TipoSorpresa::IRACASILLA)
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
  end
end
