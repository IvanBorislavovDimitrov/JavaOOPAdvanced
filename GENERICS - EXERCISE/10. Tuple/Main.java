import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] f1Info = input.readLine().split("\\s+");
        String fullName = f1Info[0] + " " + f1Info[1];
        String neighbourhood = f1Info[2];
        Tuple<String, String> t1 = new Tuple<>(fullName, neighbourhood);

        String[] f2Info = input.readLine().split("\\s+");
        String s1 = f2Info[0];
        String s2 = f2Info[1];
        Tuple<String, Integer> t2 = new Tuple<>(s1, Integer.parseInt(s2));

        String[] f3Info = input.readLine().split("\\s+");
        Tuple<Integer, Double> t3 = new Tuple<>(Integer.parseInt(f3Info[0]), Double.parseDouble(f3Info[1]));



        System.out.println(String.format("%s -> %s", t1.getE1(), t1.getE2()));
        System.out.println(String.format("%s -> %s", t2.getE1(), t2.getE2()));
        System.out.println(String.format("%s -> %s", t3.getE1(), t3.getE2()));
    }
}
