package com.tnicacio.audioplayer.wmaplay;

public interface WmaPlay {

    void setFile(String name);
    void open();
    void setLocation(int seconds);
    void play();
    void stop();

}
