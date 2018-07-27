package app.P02_FileStream;

public class BaseFile implements Streamable {

    private int length;
    private int bytesSent;

    public BaseFile(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
