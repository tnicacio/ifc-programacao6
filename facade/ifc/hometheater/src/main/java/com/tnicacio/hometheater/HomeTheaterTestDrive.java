package com.tnicacio.hometheater;

import com.tnicacio.hometheater.components.amplifier.Amplifier;
import com.tnicacio.hometheater.components.lights.TheaterLights;
import com.tnicacio.hometheater.components.player.CdPlayer;
import com.tnicacio.hometheater.components.player.DvdPlayer;
import com.tnicacio.hometheater.components.popcornpopper.PopCornPopper;
import com.tnicacio.hometheater.components.projector.Projector;
import com.tnicacio.hometheater.components.screen.Screen;
import com.tnicacio.hometheater.components.tuner.Tuner;
import com.tnicacio.hometheater.facade.HomeTheaterFacade;

public class HomeTheaterTestDrive {

    public static void main(String... args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player");
        CdPlayer cd = new CdPlayer("Top-O-Line CD Player");
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopCornPopper popper = new PopCornPopper();

        HomeTheaterFacade homeTheater = HomeTheaterFacade.getInstance(amp, tuner, dvd, cd, projector, screen, lights, popper);
        homeTheater = HomeTheaterFacade.getInstance(amp, tuner, dvd, cd, projector, screen, lights, popper);
        homeTheater = HomeTheaterFacade.getInstance(amp, tuner, dvd, cd, projector, screen, lights, popper);

        System.out.println("--- Watch movie ---");
        homeTheater.watchMovie("Raiders of the Lost Ark");
        System.out.println("--- End movie ---");
        homeTheater.endMovie();
        System.out.println("--- Listen to cd ---");
        homeTheater.listenToCd("Californication");
        System.out.println("--- End cd ---");
        homeTheater.endCd();
        System.out.println("--- Listen to radio ---");
        homeTheater.listenToRadio(101);
        System.out.println("--- End radio ---");
        homeTheater.endRadio();
    }

}
