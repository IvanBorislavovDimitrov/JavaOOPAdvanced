package bg.softuni.models.models.cores;

public class ParaCore extends BaseCore {

    public ParaCore(String type, Integer durability) {
        super(type, durability / 3);
    }

}
