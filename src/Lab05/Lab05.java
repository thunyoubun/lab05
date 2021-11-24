package Lab05;

import Lab05.Accessories.EquipType;
import Lab05.Accessories.Equipment;
import Lab05.Character.Job.Job;
import Lab05.Character.Job.JobType;
import Lab05.Character.Player;

import java.util.Scanner;

public class Lab05 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String []args){

        //Player
        Player player = new Player("Switch",10,10,10,10,10,10);
        Player enemy = new Player("Zombie",300,10,10,10,10,10);
        //Class
        Job knight = new Job(JobType.Knight,50,30,40,35,15,10);

        //Equipment
        Equipment sword = new Equipment(EquipType.WEAPON,"Sword",25,12,10,5);
        Equipment helmet = new Equipment(EquipType.HELMET,"Helmet",10,15,5,8);
        Equipment armor = new Equipment(EquipType.BODY,"Armor",5,20,5,5);
        Equipment gloves = new Equipment(EquipType.GLOVES,"Gloves",5,20,5,10);
        Equipment boots = new Equipment(EquipType.BOOTS,"Boots",5,20,10,5);

        //รับอาชีพ
        player.getJob(knight);

        //ใส่ของ
        player.equip(sword);
        player.equip(sword);
        player.equip(helmet);
        player.equip(armor);
        player.equip(gloves);
        player.equip(boots);

        player.unEquip(armor);

        player.status();

        enemy.status();

        int mode = 0;
        do{
            System.out.println("Select Mode : [0] Exit   [1] Attack    [2] Status");
            mode =s.nextInt();
            if(mode==1){
                player.attack(enemy);

            }else if(mode == 2){
                player.status();

            }
        }while (mode!=0);
    }


}
