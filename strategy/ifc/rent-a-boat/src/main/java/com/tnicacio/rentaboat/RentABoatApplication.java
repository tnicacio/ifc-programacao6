package com.tnicacio.rentaboat;

import com.tnicacio.rentaboat.entities.embarcacao.impl.*;

import java.util.stream.Stream;

public class RentABoatApplication {

    public static void main(String... args) {

        Stream.of(new Bateira(), new Iate(), new Canoa(), new Jangada(), new BarcoAVela())
                .forEach(embarcacao -> {
                    System.out.println(embarcacao.getClass().getSimpleName() +
                            ": " + embarcacao.getMovimentationMode().getValue());
                });

    }
}
