package rpg_lab.api;

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();


    Weapon getLoot();
}