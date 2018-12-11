package com.playlist;

import com.playlist.play.Song;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PlayListApplication {

	public static void main(String[] args) throws IOException,InterruptedException {

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
			System.out.println("2 - Play Songs without repeat");
			System.out.println("0 - Quit");
			ArrayList<Song> playCollection = songCollection;

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

			if (choice == 2) { // logic choice 2
				for (int i = 1; i < songCollection.size(); i++) {
					System.out.println("Playing song " + songCollection.get(i));
					System.out.println("3: Previous , 4: Next");
					Thread.sleep(50);
					choice = scan.nextInt();
					if(choice == 3){//Previous
						System.out.println("Playing next song "+ songCollection.get(i-1).getTitle());
					}
					else if(choice == 4){//Next
						System.out.println("Playing previous song "+songCollection.get(i+1).getTitle());
					}
				}
				System.out.println("Completed playing songs without repeating...!!");
			}
			else
				System.out.println("Invalid choice, select again");


			/*if (choice == 3) {
				for (int i = 0; i < songCollection.size(); i++) {
					System.out.println("Playing song " + songCollection.get(i));
				}
				System.out.println("Completed playing songs without repeating...!!");
			}
			else
				System.out.println("Invalid choice, select again");*/
		}
	}
}