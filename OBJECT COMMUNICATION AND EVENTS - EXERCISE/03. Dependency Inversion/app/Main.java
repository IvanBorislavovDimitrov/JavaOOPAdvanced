package app;

import app.calculator.PrimitiveCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();
        primitiveCalculator.changeStrategy('+');
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("mode")) {
                primitiveCalculator.changeStrategy(tokens[1].charAt(0));
            } else {
                System.out.println(primitiveCalculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
        }
    }
}
