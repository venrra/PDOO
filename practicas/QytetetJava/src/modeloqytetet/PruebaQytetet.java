/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;

/**
 *
 * @author venrra
 */
public class PruebaQytetet {

    /**
     * @param args the command line arguments
     */
   public static Qytetet juego = new Qytetet();
    
    private static ArrayList<Sorpresa> Metodo1(){
       
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
            if(i.getValor()>0)
                nuevoArray.add(i);
        return nuevoArray;
    }
    private static ArrayList<Sorpresa> Metodo2(){
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
         if(i.getTipo() == TipoSorpresa.IRACASILLA)
                nuevoArray.add(i);
        return nuevoArray;
    }
    private static ArrayList<Sorpresa> Metodo3(TipoSorpresa tipo){
        ArrayList<Sorpresa> nuevoArray = new ArrayList();
        for (Sorpresa i: juego.getMazo())
             if(i.getTipo() == tipo)
                nuevoArray.add(i);
        return nuevoArray;
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
        juego.inicializarCartasSorpresa();
        
        for (Sorpresa i : juego.getMazo()){
            System.out.println(i);
        }
        
        //LLAMA AL METODO1
        System.out.println("////////METODO1");
        System.out.println(PruebaQytetet.Metodo1().toString());
     
        
        //LLAMA AL METODO2
        System.out.println("////////METODO2");
        System.out.println(PruebaQytetet.Metodo2().toString());
        
        //LLAMA AL METODO3
        System.out.println("////////METODO3");
         for (TipoSorpresa tipo : TipoSorpresa.values())
            System.out.println(PruebaQytetet.Metodo3(tipo).toString());
    }
}
