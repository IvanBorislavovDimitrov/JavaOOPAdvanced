package app.P02_FileStream;

public class Music extends BaseFile {

    private String artist;
    private String album;

    public Music(int length, int bytesSent, String artist, String album) {
        super(length, bytesSent);
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbum() {
        return this.album;
    }
}
