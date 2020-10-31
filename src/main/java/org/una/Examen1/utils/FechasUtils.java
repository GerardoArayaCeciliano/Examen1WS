/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author LordLalo
 */
public class FechasUtils {

    public int calcularCantidadCobros(String perioridad) {
        int veces = 0;
        if (perioridad.equals("Anual")) {
            veces = 1;
        } else if (perioridad.equals("Mensual")) {
            veces = 12;
        } else if (perioridad.equals("Bimensual")) {
            veces = 6;
        } else if (perioridad.equals("Trimestral")) {
            veces = 4;
        } else if (perioridad.equals("Semestral")) {
            veces = 2;
        }
        return veces;
    }

    public static Date sumarDiasAFecha(Date fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        int diaSema=calendar.get(Calendar.DAY_OF_WEEK);
     
       if(Calendar.SATURDAY==diaSema){
           calendar.add(Calendar.DAY_OF_YEAR,2+dias);
       }else if(Calendar.SUNDAY==diaSema){
           calendar.add(Calendar.DAY_OF_YEAR,1+dias);
       }
       return calendar.getTime();  	
    }

    public int CantidadDias(int veces) {
        int cantidadDias=0;
        if (1 == veces) {
            cantidadDias = 365;
        }else if(veces==2){
         cantidadDias=365/2;
        }else if(veces==4){
          cantidadDias=365/4;
        }else if(veces==6){
          cantidadDias=365/6;
        }else if(veces==12){
         cantidadDias=365/12;
        }
return cantidadDias;
    }
}
