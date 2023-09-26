import App.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Listenify World!");

        List<Song> list = new ArrayList<>();
        list.add(new Song("Chaiya Chaiya", 6.5));
        list.add(new Song("Baby", 3.5));
        list.add(new Song("Love Me", 4.5));
        Album album = new Album("Pop Music", "Various", list);
//        System.out.println(album.findSong("Chaiya Chaiya"));

        printMenu();
        startPlaylist(album.getSongList());
    }

    public static void startPlaylist(List<Song> playlist) {
        if (playlist == null || playlist.isEmpty())
            return;

        int index = 0;

        System.out.println("Now playing " + playlist.get(index) + "\n");

        Scanner sc = new Scanner(System.in);

        boolean continuePlaylist = true;

        while (continuePlaylist) {
            System.out.println("Enter you choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    if (index + 1 < playlist.size()) ++index;
                    else index = 0;
                    System.out.println("Now playing " + playlist.get(index) + "\n");
                    break;

                case 2:
                    if (index > 0) --index;
                    System.out.println("Now playing " + playlist.get(index) + "\n");
                    break;

                case 3:
                    System.out.println("Now playing " + playlist.get(index) + "\n");
                    break;

                case 4:
                    printPlaylist(playlist);
                    System.out.println();
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    playlist.remove(index);
                    if (playlist.isEmpty()) return;
                    if (index == playlist.size()) index = 0;
                    System.out.println("Now playing " + playlist.get(index) + "\n");
                    break;

                case 7:
                    index = new Random().nextInt(playlist.size());
                    System.out.println("Now playing " + playlist.get(index) + "\n");
                    break;
                case 8:
                    continuePlaylist = false;
                    break;
            }
        }
    }

    public static void printPlaylist(List<Song> playlist) {
        for (Song song: playlist)
            System.out.println(song);
    }

    public static void printMenu() {
        System.out.println("These are the options you can choose from:");
        System.out.println("1. Go to and play the next song");
        System.out.println("2. Go to the previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all songs in the playlist");
        System.out.println("5. Print the Menu");
        System.out.println("6. Delete the current song");
        System.out.println("7. Shuffle play");
        System.out.println("8. Exit the playlist\n");
    }
}