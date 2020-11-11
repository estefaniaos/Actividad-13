package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface AnonClass {
    public void sort();
}

public class Lista {
    List<String> cadenas = new ArrayList();

    public void Lista(){

    }

    public void agregaCadena(String cadena){
        this.cadenas.add(cadena);
    }

    public void sort(){
        System.out.println("===== Orden normal =====");
        print();
        System.out.println("===== Por orden alfabético =====");

        System.out.print("Clase anónima: ");
        AnonClass anon = new AnonClass() {
            public void sort() {
                Collections.sort(cadenas);
            }
        };
        anon.sort();
        print();

        System.out.print("Expresión lambda: ");
        cadenas.sort((word1, word2) -> word1.compareTo(word2));
        print();

        System.out.print("Por referencia: ");
        cadenas.sort(String::compareTo);
        print();

        System.out.println("===== Por longitud =====");

        System.out.print("Clase anónima: ");
        AnonClass anonl = new AnonClass() {
            public void sort() {
                Collections.sort(cadenas, Comparator.comparing(String::length));
            }
        };
        anonl.sort();
        print();

        System.out.print("Expresión lambda: ");
        cadenas.sort((word1, word2) -> word1.length() - word2.length());
        print();

        System.out.print("Por referencia: ");
        cadenas.sort(Comparator.comparing(String::length));
        print();






    }

    public void print(){
        for (String cadena : cadenas) {
            System.out.print(cadena + ", ");
        }
        System.out.println();
    }


}
