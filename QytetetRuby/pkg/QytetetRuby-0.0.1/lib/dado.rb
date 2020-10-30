# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"

module ModeloQytetet
  class Dado
    include Singleton
    
    def initialize
      @valor = 0
    end
    
    attr_reader :valor
    
    def tirar()
      r = Random.new
      @valor = r.rand(1..6)
      return @valor
    end
    
    public
    def to_s()
      "Dado: valor: #{@valor} \n"
    end    
    
  end
end
