package com.tnicacio.hometheater.components.player;

public interface Player {

    void on();

    void off();

    void eject();

    void pause();

    void play(String movie);

    void stop();

}
