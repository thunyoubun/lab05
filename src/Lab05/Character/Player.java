package Lab05.Character;

import Lab05.Character.Character;

public class Player extends Character {

    Character Job;

    public Player(String name, double hp, double mp, double atk, double def, double agi, double intel) {
        super(name, hp, mp, atk, def, agi, intel);
    }

    public void getJob(Character job){
        this.Job = job;
    }

    public void stats(){

    }
}
