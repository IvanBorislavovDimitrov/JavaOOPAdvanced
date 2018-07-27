package app.P02_FileStream;

public class StreamProgressInfo {

    private Streamable streamable;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Streamable streamable) {
        this.streamable = streamable;
    }

    public int calculateCurrentPercent() {
        return (this.streamable.getBytesSent() * 100) / this.streamable.getLength();
    }
}
