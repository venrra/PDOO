#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Sorpresa
    def initialize(unTexto, unValor, unTipo)
      @texto = unTexto #testo de carta Sorpresa
      @valor = unValor #valor de sorpresa
      @tipo = unTipo #tipo de sorpresa de TipoSorpresa
    end

    attr_reader:texto
    attr_reader:valor
    attr_reader:tipo

  #forma explicita  
=begin
    def texto()
      return texto
    end

    def valor()
      return valor
    end

    def tipo()
      return tipo
    end
=end

    def to_s()
      "Texto: #{@texto} \n Valor: #{@valor} \n Tipo: #{@tipo}"
    end

  end
end