package Lab05.Accessories;

public class Equipment implements EquipInterface {

    private boolean equip = false;
    private String name;
    private double atk , def,agi ,intel;
    private EquipType equipType;


    public Equipment(EquipType type ,String name, double atk , double def, double agi , double intel){
        this.equipType = type;
        this.name = name;
        this.atk  = atk;
        this.def = def;
        this.agi = agi;
        this.intel = intel;
    }

    @Override
    public boolean equip() {
        this.equip = true;
        return true;
    }

    @Override
    public boolean unequip() {
        this.equip = false;
        return false;
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
    public double getIntel() {
        return intel;
    }

    @Override
    public EquipType getType() {
        return equipType;
    }

    @Override
    public String nameEquip() {
        return name;
    }


}
