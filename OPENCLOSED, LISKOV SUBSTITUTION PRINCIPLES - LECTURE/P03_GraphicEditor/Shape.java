package app.P03_GraphicEditor;

public abstract class Shape {

    public String tellForm() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "I am a" + this.tellForm();
    }
}
