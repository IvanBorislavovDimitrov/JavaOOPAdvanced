import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        List<Light> lights = new ArrayList<>();
        String[] data = input.readLine().split("\\s+");

        for (String item : data) {
            Light light = Light.valueOf(item);
            lights.add(light);
        }

        int rows = Integer.parseInt(input.readLine());
        TrafficLight trafficLight = new TrafficLight(lights);

        for (int i = 0; i < rows; i++) {
            trafficLight.change();
            System.out.println(trafficLight);
        }
    }
}