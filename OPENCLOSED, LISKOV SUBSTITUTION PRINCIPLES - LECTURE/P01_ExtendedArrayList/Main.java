package app.P01_ExtendedArrayList;

public class Main {

    public static void main(String[] args) {
        ExtendedArrayList<Integer> extendedArrayList = new ExtendedArrayList<>();
        extendedArrayList.add(1);
        extendedArrayList.add(-123);
        extendedArrayList.add(123);
        extendedArrayList.add(1);
        extendedArrayList.add(1);

        System.out.println(extendedArrayList.min());
        System.out.println(extendedArrayList.max());
    }
}
