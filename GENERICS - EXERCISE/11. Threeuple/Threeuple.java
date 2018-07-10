public class Threeuple<E1, E2, E3> {

    private E1 e1;
    private E2 e2;
    private E3 e3;

    public Threeuple(E1 e1, E2 e2, E3 e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public E3 getE3() {
        return this.e3;
    }

    public void setE3(E3 e3) {
        this.e3 = e3;
    }

    public E1 getE1() {
        return this.e1;
    }

    public void setE1(E1 e1) {
        this.e1 = e1;
    }

    public E2 getE2() {
        return this.e2;
    }

    public void setE2(E2 e2) {
        this.e2 = e2;
    }

}
