package com.tnicacio.hometheater.facade;

import com.tnicacio.hometheater.components.amplifier.Amplifier;
import com.tnicacio.hometheater.components.lights.TheaterLights;
import com.tnicacio.hometheater.components.player.CdPlayer;
import com.tnicacio.hometheater.components.player.DvdPlayer;
import com.tnicacio.hometheater.components.popcornpopper.PopCornPopper;
import com.tnicacio.hometheater.components.projector.Projector;
import com.tnicacio.hometheater.components.screen.Screen;
import com.tnicacio.hometheater.components.tuner.Tuner;

public class HomeTheaterFacade {

    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private CdPlayer cd;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopCornPopper popper;

    private static HomeTheaterFacade uniqueInstance;

    private HomeTheaterFacade(Amplifier amp,
                             Tuner tuner,
                             DvdPlayer dvd,
                             CdPlayer cd,
                             Projector projector,
                             Screen screen,
                             TheaterLights lights,
                             PopCornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public static synchronized HomeTheaterFacade getInstance(Amplifier amp,
                                                Tuner tuner,
                                                DvdPlayer dvd,
                                                CdPlayer cd,
                                                Projector projector,
                                                Screen screen,
                                                TheaterLights lights,
                                                PopCornPopper popper) {
        if (uniqueInstance == null ){
            uniqueInstance = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
            System.out.println("New HomeTheaterFacade instance");
        }
        return uniqueInstance ;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(90);
        screen.down();
        projector.on();
        projector.setDvdPlayer(dvd);
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }

    public void listenToCd(String music) {
        System.out.println("Listening to cd...");
        amp.on();
        amp.setCd(cd);
        amp.setSurroundSound();
        amp.setVolume(5);
        cd.on();
        cd.play(music);
    }

    public void endCd() {
        System.out.println("Turning cd off...");
        amp.off();
        cd.stop();
        cd.eject();
        cd.off();
    }

    public void listenToRadio(int frequency) {
        System.out.println("Listening to the radio...");
        amp.on();
        amp.setVolume(5);
        amp.setStereoSound();
        tuner.on();
        tuner.setFm();
        tuner.setFrequency(frequency);
    }

    public void endRadio() {
        System.out.println("Turning radio off");
        amp.off();
        tuner.off();
    }

}
