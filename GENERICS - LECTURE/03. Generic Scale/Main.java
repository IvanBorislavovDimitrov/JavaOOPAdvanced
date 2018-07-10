public class Main {

    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "c");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> intScale = new Scale<>(1, 2);
        System.out.println(intScale.getHeavier());

    }
}
