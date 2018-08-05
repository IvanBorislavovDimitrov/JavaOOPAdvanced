package app.kingdom;

import app.models.BasePerson;
import app.models.RoyalGuard;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {

    private BasePerson king;
    private List<BasePerson> footmen;
    private List<BasePerson> royalGuards;

    public Kingdom(BasePerson king) {
        this.king = king;
        this.footmen = new ArrayList<>();
        this.royalGuards = new ArrayList<>();
    }

    public void addFootman(BasePerson footman) {
        this.footmen.add(footman);
    }

    public void addRoyalGuard(BasePerson royalGuard) {
        this.royalGuards.add(royalGuard);
    }

    public void kill(String name) {
        this.footmen.removeIf(f -> f.getName().equals(name));
        this.royalGuards.removeIf(r -> r.getName().equals(name));
    }

    public String attack() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.king.sayWhatIAmDoing());
        sb.append(System.lineSeparator());

        this.royalGuards.forEach(f -> sb.append(f.sayWhatIAmDoing()).append(System.lineSeparator()));
        this.footmen.forEach(f -> sb.append(f.sayWhatIAmDoing()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
