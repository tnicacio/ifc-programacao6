package com.tnicacio.audioplayer;

import com.tnicacio.audioplayer.audioformat.AudioFormat;
import com.tnicacio.audioplayer.audioformat.Mp3Player;
import com.tnicacio.audioplayer.audioformat.WavPlayer;
import com.tnicacio.audioplayer.audioformat.WmaPlayerAdapter;
import com.tnicacio.audioplayer.wmaplay.WmaPlay;
import com.tnicacio.audioplayer.wmaplay.WmaPlayer;

public class AudioPlayer {

    public static void main(String... args) {
        System.out.println("-- Mp3 Player --");
        AudioFormat mp3Player = new Mp3Player();
        mp3Player.open("Learn to Fly - Foo Fighters");
        mp3Player.reproduce();
        mp3Player.stop();

        System.out.println("-- WavPlayer --");
        AudioFormat wavPlayer = new WavPlayer();
        wavPlayer.open("Everlong - Foo Fighters");
        wavPlayer.reproduce();
        wavPlayer.stop();

        System.out.println("-- WmaPlayer --");
        WmaPlay wmaPlayer = new WmaPlayer();
        wmaPlayer.setFile("Can't Stop - Red Hot");
        wmaPlayer.open();
        wmaPlayer.setLocation(0);
        wmaPlayer.play();
        wmaPlayer.stop();

        System.out.println("--WmaPlayer Adapter -- ");
        AudioFormat wmaPlayerAdapter = new WmaPlayerAdapter(wmaPlayer);
        wmaPlayerAdapter.open("Snow - Red Hot");
        wmaPlayerAdapter.reproduce();
        wmaPlayerAdapter.stop();
    }

}
