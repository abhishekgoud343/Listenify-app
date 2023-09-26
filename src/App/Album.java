package App;

import java.util.*;

public class Album {

    private String albumName;
    private String artistName;
    private List<Song> songList;

    public Album(String albumName, String artistName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songList = new ArrayList<>();
    }

    public Album(String albumName, String artistName, List<Song> songList) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songList = songList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(Song song) {
        songList.add(song);
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public boolean findSong(String enteredTitle) {
        for (Song song : songList)
            if (song.getName().equals(enteredTitle))
                return true;

        return false;
    }

    public String addNewSong(String title, double duration) {
        if (findSong(title))
            return "The song is already present in the album!";

        Song newSong = new Song(title, duration);
        songList.add(newSong);

        return "New song with title " + title + " has been added to the album.";
    }

    public String addSongToPlaylist(int songNo, List<Song> playlist) {
        int index = songNo - 1;

        if (index >= 0 && index < songList.size()) {
            Song song = songList.get(index);
            playlist.add(song);

            return "The song has been added to the playlist";
        }

        return "The song number is out of range";
    }

    public String addSongToPlaylist(String title, List<Song> playlist) {
        for (Song song : songList)
            if (song.getName().equals(title)) {
                playlist.add(song);

                return "The song has been added to the playlist";
            }

        return "The song could not be found in the album";
    }
}