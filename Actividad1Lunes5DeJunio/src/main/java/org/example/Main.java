package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List <Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(minOrMax(lista,true));
        System.out.println(minOrMax(lista,false));
        Descuentos descuentos = (precio, descuento) -> precio * (1-descuento/100);
        System.out.println("Descuentos: " + descuentos.descontar(3500.0, 10.0));
        System.out.println("IVA estándar: "+calcularIVA(3000.0));
        System.out.println("IVA específico: "+calcularIVA(3000.0,20.0));


    }

    public static int minOrMax(List<Integer> lista, boolean needMax){
        return (needMax)? Collections.max(lista):Collections.min(lista);
    }
    public interface Descuentos{
        Double descontar(Double precio, Double descuento);
    }
    public static Double calcularIVA(Double precio){
        return precio*0.21;
    }
    public static Double calcularIVA(Double precio,Double porcIVA){
        return precio*porcIVA/100;
    }

}