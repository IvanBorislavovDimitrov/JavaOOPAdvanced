import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] f1Info = input.readLine().split("\\s+");
        String fullName = f1Info[0] + " " + f1Info[1];
        String neighbourhood = f1Info[2];
        Threeuple<String, String, String> t1 = new Threeuple<>(fullName, neighbourhood, f1Info[3]);

        String[] f2Info = input.readLine().split("\\s+");
        String s1 = f2Info[0];
        String s2 = f2Info[1];
        Threeuple<String, Integer, Boolean> t2 = new Threeuple<>(s1, Integer.parseInt(s2), f2Info[2].equals("drunk"));

        String[] f3Info = input.readLine().split("\\s+");
        Threeuple<String, Double, String> t3 = new Threeuple<>(f3Info[0], Double.parseDouble(f3Info[1]), f3Info[2]);


        System.out.println(String.format("%s -> %s -> %s", t1.getE1(), t1.getE2(), t1.getE3()));
        System.out.println(String.format("%s -> %s -> %s", t2.getE1(), t2.getE2(), t2.getE3()));
        System.out.println(String.format("%s -> %s -> %s", t3.getE1(), t3.getE2(), t3.getE3()));
    }
}
