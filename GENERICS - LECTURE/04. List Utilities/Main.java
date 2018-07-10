import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<?> anyList = new ArrayList<Integer>();
        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        anyList = integers;
        anyList = doubles;
    }
}
