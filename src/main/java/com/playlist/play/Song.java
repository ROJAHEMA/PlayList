/*
 *  Copyright 2018 WickedRide Adventure Services Private Limited.
 *  All Rights Reserved.
 *  For BOUNCE a unit of WickedRide "AS IS" PROPRIETARY/CONFIDENTIAL.
 *  Use is subject to license terms under employee agreement.
 *
 *  @version   1.0, 05-Dec-2018
 *  @author    roja
 */
package com.playlist.play;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Song {

    private String title;
    private String artist;
    private int noPlays;

    public Song(String inTitle, String inArtist) {

        artist = inArtist;
        title  = inTitle;
    }

    public String getTitle()
    {
        return title;
    }
    public String getArtist()
    {
        return artist;
    }
    public void play()
    {
        noPlays++;
    }
    public int getNoPlays()
    {
        return noPlays;
    }


    @Override
    public String toString() {
        return "Song{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + ", noPlays=" +
                noPlays + '}';
    }

}
