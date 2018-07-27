package app.P03_GraphicEditor;

public class Main {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        Shape shape = new Circle();
        graphicEditor.drawShape(shape);
    }
}
