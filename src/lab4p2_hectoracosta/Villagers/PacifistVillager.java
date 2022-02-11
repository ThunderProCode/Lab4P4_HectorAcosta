package lab4p2_hectoracosta.Villagers;

import lab4p2_hectoracosta.Villager;


public class PacifistVillager extends Villager {
    
    private String speech = "No pelien porfa";
    
    public PacifistVillager(String name, String lastName, int age, int hp) {
        super(name, lastName, age, hp);
        this.damage = 0;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
    
    @Override
    public void attack(Villager enemy){
        System.out.println(this.speech);
    }
}
