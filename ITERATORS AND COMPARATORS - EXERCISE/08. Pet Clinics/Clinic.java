import java.util.Arrays;
import java.util.Iterator;

public class Clinic {

    private String name;
    private Pet[] pets;
    private int count;
    private int length;
    private int startIndex;
    private int leftPartIndex;
    private int rightPartIndex;

    public Clinic(String name, int petsCount) {
        if (petsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.name = name;
        this.pets = new Pet[petsCount];
        this.count = 0;
        this.length = 0;
        this.leftPartIndex = petsCount / 2 - 1;
        this.rightPartIndex = petsCount / 2;
        this.startIndex = petsCount / 2;
    }

    public boolean addPet(Pet pet) {
        if (this.count == this.pets.length) {
            return false;
        }
        if (this.count % 2 == 0) {
            this.pets[this.rightPartIndex++] = pet;
        } else {
            this.pets[this.leftPartIndex--] = pet;
        }

        this.count++;

        return true;
    }

    public void print() {
        for (Pet pet : this.pets) {
            System.out.println(pet == null ? "Room empty" : pet);
        }
    }

    public boolean release() {
        while (this.pets[this.startIndex++] == null) {
            if (this.length == this.pets.length) {
                return false;
            }


            this.startIndex %= this.pets.length;
            this.length++;

        }

        this.pets[this.startIndex - 1] = null;

        return true;
    }

    public boolean hasEmptyRooms() {
        return this.count < this.pets.length;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet[] getPets() {
        return this.pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getLeftPartIndex() {
        return this.leftPartIndex;
    }

    public void setLeftPartIndex(int leftPartIndex) {
        this.leftPartIndex = leftPartIndex;
    }

    public int getRightPartIndex() {
        return this.rightPartIndex;
    }

    public void setRightPartIndex(int rightPartIndex) {
        this.rightPartIndex = rightPartIndex;
    }

    public void print(int index) {
        System.out.println(this.pets[index - 1] == null ? "Room empty" : this.pets[index - 1]);
    }
}
