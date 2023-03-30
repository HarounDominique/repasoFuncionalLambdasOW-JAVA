package com.example.consumer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main1 {
    public static void main(String[] args) {

        //Instanciando la interfaz funcional Consumer mediante una clase anónima
        Consumer printer1 = new Consumer<ArrayList>() {
            @Override
            public void accept(ArrayList messages) {
                for (int i = 0; i<messages.size(); i++) {
                    System.out.println(messages.get(i));
                }
            }
        };
        //printer.accept("Hola mundo");

        Consumer<String> printer4 = message -> System.out.println(message);

        //Instanciando la interfaz funcional Consumer mediante una lambda (método anónimo)
        Consumer<ArrayList> printer2 = messages -> {for (int i = messages.size()-1; i>0; i--) {
            System.out.println(messages.get(i));}};

        ArrayList<String> names = new ArrayList<>();
        names.add("hola");
        names.add("mundo");
        names.add("que");
        names.add("tal");

        Consumer<ArrayList> printer3 = printer2.andThen(printer1);
        printer3.accept(names);
        System.out.println("------------------------------------");
        names.forEach(printer4);
        System.out.println("------------------------------------");
        names.forEach(message -> {
            System.out.println(message);
        });




    }
}
