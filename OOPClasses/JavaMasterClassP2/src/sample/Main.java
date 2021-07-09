package sample;

import java.util.*;

public class Main  {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Hybrid Theory","Linkin Park");
       album.addSong("Papercut",3.04);
       album.addSong("One Step Closer",2.35);
       album.addSong(	"With You",3.23);
       album.addSong(	"Points of Authority",3.20);
       album.addSong(	"Crawling",3.29);
       album.addSong("Runaway",3.09);
       album.addSong("By Myself",3.36);
       album.addSong("In the End",3.04);
       album.addSong(		"Forgotten",3.14);
       album.addSong(	"Cure for the Itch (Instrumental)" ,2.37);
       album.addSong(		"Pushing Me Away",3.11);

        albums.add(album);
        album = new Album("Born To Die", "Lana Del Rey");
        album.addSong("Born To Die",4.46);
        album.addSong("Off to the Races",5.00);
        album.addSong(	"Blue Jeans",3.30);
        album.addSong("Video Games",4.42);
        album.addSong("Radio",3.34);
        album.addSong("Summertime Sadness",4.25);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(1).addToPlaylist("Radio",playList);
        albums.get(1).addToPlaylist("Blue Jeans",playList);
        albums.get(1).addToPlaylist("Summertime Sadness",playList);
        albums.get(0).addToPlaylist("In the End",playList);
        albums.get(0).addToPlaylist("Runaway",playList);
        albums.get(0).addToPlaylist("Pushing Me Away",playList);
        albums.get(0).addToPlaylist("SomeTingWong",playList); //Does not exist
        albums.get(1).addToPlaylist(9,playList); //Does not exist
        albums.get(1).addToPlaylist(10,playList); //Does not exist
        albums.get(1).addToPlaylist(11,playList); //Does not exist
        albums.get(1).addToPlaylist(12,playList); //Does not exist

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist Complete. ");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println(" We have reached the end of playlist");
                        forward = true;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());

                    } else {

                        System.out.println(" we are at the start of the playlist");
                        forward = true;
                    }

                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;

                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                            if(listIterator.hasNext()){
                                System.out.println("Now replaying " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("we have reached the end of the list ");
                            }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()> 0 ){

                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now Playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
    private static void printMenu(){
        System.out.println("Available actions ");
        System.out.println("0 - to quit\n");
        System.out.println("1 - to play next song\n");
        System.out.println("2 - to play previous song\n");
        System.out.println("3 - to reply current song\n");
        System.out.println("4 - to list songs in the playlist\n");
        System.out.println("5 - print available actions. \n");
        System.out.println("6 - remove song from playlist \n");

    }
}
