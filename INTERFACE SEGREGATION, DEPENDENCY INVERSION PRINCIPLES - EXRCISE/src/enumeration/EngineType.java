package src.enumeration;

public enum EngineType
{
    JET,
    STERNDRIVE;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
