package hell.entities.models.items;

public class Item extends BaseItem {

    public Item(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Item: %s", this.getName())).append(System.lineSeparator());
        sb.append(String.format("###+%d Strength", this.getStrengthBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Agility", this.getAgilityBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Intelligence", this.getIntelligenceBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d HitPoints", this.getHitPointsBonus())).append(System.lineSeparator());
        sb.append(String.format("###+%d Damage", this.getDamageBonus()));

        return sb.toString();
    }
}
