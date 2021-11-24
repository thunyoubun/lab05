package Lab05.Character;

import Lab05.Accessories.EquipType;
import Lab05.Accessories.Equipment;
import Lab05.Character.Job.Job;

public class Character implements CharacterInterface {

    protected String name;
    protected double level = 1;
    protected double hp,mp,atk,def,agi,intel,atkDmg,weaponAtk;
    protected Equipment[] equipment = new Equipment[5];
    protected Job job;

    public Character(String name,double hp,double mp,double atk,double def,double agi,double intel){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.intel = intel;
        update();
    }

    @Override
    public void getJob(Job job) {
        this.job = job;
        this.hp += this.job.getJobHp();
        this.mp += this.job.getJobMp();
        this.atk += this.job.getJobAtk();
        this.def += this.job.getJobDef();
        this.agi += this.job.getJobAgi();
        this.intel += this.job.getJobIntel();
    }

    @Override
    public void attack( Character character) {
        if(this.atk >= character.hp+character.def){
            atkDmg = this.atk-character.def;
            character.hp = 0;
            System.out.println(character.getName() + " is Dead.");
        }else{
            atkDmg = this.atk-character.def;
            character.hp -= atkDmg;
            System.out.println(character.name + " take damaged by :" + atkDmg );
            System.out.println(character.name + " has HP remain : "+ character.getHp());
        }

    }



    @Override
    public void update() {
        this.hp = hp+(10*level);
        this.mp = mp+(10*level);
        this.atk = atk*(0.1+(0.3*level));
        this.def = def*(0.1+(0.3*level));
        this.agi = agi*(0.1+(0.2*level));
    }

    @Override
    public void levelUP() {
        level++;
        update();
        increaseEquip();
    }


    @Override
    public void unEquip(Equipment equipment) {
        if(equipment.getType() == EquipType.WEAPON){
            this.equipment[0] = null;
            equipment.unequip();
        }
        else if(equipment.getType() == EquipType.HELMET){
            this.equipment[1] = null;
            equipment.unequip();
        }
        else if(equipment.getType() == EquipType.BODY){
            this.equipment[2] = null;
            equipment.unequip();
        }
        else if(equipment.getType() == EquipType.GLOVES){
            this.equipment[3] = null;
            equipment.unequip();
        }
        else if(equipment.getType() == EquipType.BOOTS){
            this.equipment[4] = null;
            equipment.unequip();
        }
        decreaseEquip();
    }

    @Override
    public void equip(Equipment equipment) {
        if(equipment.getType() == EquipType.WEAPON  ){
            if(this.equipment[0] == null ) {
                this.equipment[0] = equipment;
                equipment.equip();
                increaseEquip();
            }else{
                System.out.println("Weapon slot is FULL");
            }
        }
        else if(equipment.getType() == EquipType.HELMET){
            if(this.equipment[1] == null ) {
                this.equipment[1] = equipment;
                equipment.equip();
                increaseEquip();
            }else{
                System.out.println("Helmet slot is FULL");
            }
        }
        else if(equipment.getType() == EquipType.BODY){
            if(this.equipment[2] == null ) {
                this.equipment[2] = equipment;
                equipment.equip();
                increaseEquip();
            }else{
                System.out.println("Armor slot is FULL");
            }
        }
        else if(equipment.getType() == EquipType.GLOVES){
            if(this.equipment[3] == null ) {
                this.equipment[3] = equipment;
                equipment.equip();
                increaseEquip();
            }else{
                System.out.println("Gloves slot is FULL");
            }
        }
        else if(equipment.getType() == EquipType.BOOTS){
            if(this.equipment[4] == null ) {
                this.equipment[4] = equipment;
                equipment.equip();
                increaseEquip();
            }else{
                System.out.println("Boots slot is FULL");
            }
        }

    }

    @Override
    public void getWeaponAtk() {

    }

    @Override
    public void increaseEquip() {
        if(this.equipment != null){
            for (int i= 0 ; i<equipment.length; i++){
                if(equipment[i]!= null) {
                    this.atk += equipment[i].getAtk();
                    this.def += equipment[i].getDef();
                    this.agi += equipment[i].getAgi();
                    this.intel += equipment[i].getIntel();
                }
            }
        }
    }

    @Override
    public void decreaseEquip(){
        if(this.equipment != null){
            for (int i= 0 ; i<equipment.length; i++){
                if(equipment[i]!= null) {
                    this.atk -= equipment[i].getAtk();
                    this.def -= equipment[i].getDef();
                    this.agi -= equipment[i].getAgi();
                    this.intel -= equipment[i].getIntel();
                }
            }
        }
    }

    @Override
    public  String getName() {
        return name;
    }

    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public double getMp() {
        return mp;
    }

    @Override
    public double getAtk() {
        return atk;
    }

    @Override
    public double getDef() {
        return def;
    }

    @Override
    public double getAgi() {
        return agi;
    }

    @Override
    public double getIntel(){
        return intel;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atk=" + atk +
                ", def=" + def +
                ", agi=" + agi +
                '}';
    }

    @Override
    public void status() {
        System.out.println("____________________________________________________________________________________");
        System.out.print("[Name : " + name + "]");
        System.out.print("[Class : ");
                if(job != null){
                    System.out.print(job.getJobName());
                }else{
                    System.out.print(" None");
                }
        System.out.print(" ]\n");
        System.out.println("[HP : " + hp +"]" + "[MP : " +mp +"]" );
        System.out.println("[Atk : "+ atk + "]" + "[Def : "+def+ "]");
        System.out.println("[Equipment]");

        System.out.print("[Weapon : ");
        if(equipment[0] != null){
            System.out.print( equipment[0].nameEquip());
        }
        else{
            System.out.print(" None");
        }
        System.out.print(" ]\n");

        System.out.print("[Helmet : ");
        if(equipment[1] != null){
            System.out.print( equipment[1].nameEquip());
        }
        else{
            System.out.print(" None");
        }
        System.out.print(" ]\n");

        System.out.print("[Armor : ");
        if(equipment[2] != null){
            System.out.print( equipment[2].nameEquip());
        }
        else{
            System.out.print(" None");
        }
        System.out.print(" ]\n");

        System.out.print("[Gloves : ");
        if(equipment[3] != null){
            System.out.print( equipment[3].nameEquip());
        }
        else{
            System.out.print(" None");
        }
        System.out.print(" ]\n");

        System.out.print("[Boots : ");
        if(equipment[4] != null){
            System.out.print( equipment[4].nameEquip());
        }
        else if (equipment[4] == null){
            System.out.print(" None");
        }
        System.out.print(" ]\n");
        System.out.println("____________________________________________________________________________________");
    }

}
