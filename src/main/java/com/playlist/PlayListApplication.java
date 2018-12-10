package com.playlist;

import com.playlist.play.Song;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class PlayListApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(PlayListApplication.class, args);
		ClassLoader loader = PlayListApplication.class.getClassLoader();

		Scanner lineScan, scan = new Scanner(new File(loader.getResource("song.csv").getFile()));
		ArrayList<Song> songCollection = new ArrayList<Song>();
		String line;
		String searchName;
		String artist, title;
		Song song;
		Song searchSong;
		Random generator = new Random();
		while (scan.hasNext())
		{
			line = scan.nextLine();
			lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			artist = lineScan.next();
			title = lineScan.next();
			song = new Song(artist,title);
			songCollection.add(song);
		}

		//Shuffling songlist
		Collections.shuffle(songCollection);

		boolean toContinue = true;
		int choice;
		scan = new Scanner(System.in);

		while (toContinue)
		{
			System.out.println("");
			System.out.println("Music Collection Menu");
			System.out.println("Enter your choice (or 0 to quit)");
			System.out.println("1 - List Collection");
			System.out.println("2 - Play Songs");
			System.out.println("0 - Quit");
			choice = scan.nextInt();
			scan.nextLine();

			if (choice == 0)
				toContinue = false;
			else
			if (choice == 1) // logic for choice 1
				for(int i = 0; i<songCollection.size(); i++)
				{
					System.out.println("Music Collection " + songCollection.get(i));// logic for choice 1

				}
			else

			if (choice == 2) { // logic choice 4
				for (int i = 0; i < songCollection.size(); i++) {
					System.out.println("Playing song " + songCollection.get(i));// logic for choice 1
				}
				System.out.println("Completed playing songs without repeating...!!");
			}
			else
				System.out.println("Invalid choice, select again");
		}
	}
}