import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(Integer.class, 4, 2);
        Integer[] a = ArrayCreator.create(4, 2);
        System.out.println(Arrays.asList(arr));
    }
}
