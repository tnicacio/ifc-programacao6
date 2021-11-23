package com.tnicacio.audioplayer.audioformat;

import com.tnicacio.audioplayer.wmaplay.WmaPlay;

public class WmaPlayerAdapter implements AudioFormat {

    private WmaPlay wmaPlay;

    public WmaPlayerAdapter(WmaPlay wmaPlay) {
        this.wmaPlay = wmaPlay;
    }

    @Override
    public void open(String name) {
        wmaPlay.setFile(name);
        wmaPlay.open();
    }

    @Override
    public void reproduce() {
        wmaPlay.setLocation(0);
        wmaPlay.play();
    }

    @Override
    public void stop() {
        wmaPlay.stop();
        wmaPlay.setFile(null);
    }

}
