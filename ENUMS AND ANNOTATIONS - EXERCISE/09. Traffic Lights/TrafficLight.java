import java.awt.font.TransformAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrafficLight {

    public TrafficLight(List<Light> lights) {
        this.lights = lights;
    }

    private List<Light> lights;

    public void change() {
        // red -> green -> yellow -> red

        for (int i = 0; i < lights.size(); i++) {
            switch (lights.get(i)) {
                case YELLOW:
                    lights.set(i, Light.RED);
                    break;
                case GREEN:
                    lights.set(i, Light.YELLOW);
                    break;
                case RED:
                    lights.set(i, Light.GREEN);
                    break;
            }
        }

    }

    public String toString() {
        return this.lights.stream().map(Enum::toString).collect(Collectors.joining(" "));
    }
}


