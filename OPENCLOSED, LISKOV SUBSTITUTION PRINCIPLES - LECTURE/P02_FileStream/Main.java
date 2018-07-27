package app.P02_FileStream;

public class Main {

    public static void main(String[] args) {
        Streamable music = new Music(1, 1, "Djamaikata", "Hitove");
        Streamable file = new File(1, 1, "Strange file");

        StreamProgressInfo streamProgressInfoMusic = new StreamProgressInfo(music);
        StreamProgressInfo streamProgressInfoFile = new StreamProgressInfo(file);

        System.out.println(streamProgressInfoMusic.calculateCurrentPercent());
        System.out.println(streamProgressInfoFile.calculateCurrentPercent());
    }
}
