package Lab05.Character;

import Lab05.Accessories.Equipment;
import Lab05.Character.Job.Job;

public interface CharacterInterface {

    public void attack(Character character);
    public void status();
    public String getName();
    public double getHp();
    public double getMp();
    public double getAtk();
    public double getDef();
    public double getAgi();
    public double getIntel();
    public String toString();
    public void decreaseEquip();
    public void update();
    public void levelUP();
    public void unEquip(Equipment equipment);
    public void equip(Equipment equipment);
    public void getWeaponAtk();
    public void increaseEquip();

    public void getJob(Job job);

}
