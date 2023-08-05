package enums;

import enums.*;

public enum DiaDeLaSemana {
    
   LUNES(1),
   MARTES(2),
   MIERCOLES(3),
   JUEVES(4),
   VIERNES(5),
   SABADO(6);
   
   final int numero;
   
   private DiaDeLaSemana(int num){
       this.numero =num;
       
   }

    public boolean equalsIgnoreCase(String dia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

