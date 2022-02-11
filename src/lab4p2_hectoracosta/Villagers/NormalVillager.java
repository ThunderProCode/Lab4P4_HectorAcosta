package lab4p2_hectoracosta.Villagers;

import lab4p2_hectoracosta.Villager;


public class NormalVillager extends Villager {
    
    public NormalVillager(String name, String lastName, int age, int hp) {
        super(name, lastName, age, hp);
        this.damage = 50;
    }
    
    @Override
    public void attack(Villager enemy){
        int originalDamage = this.damage;
        if(enemy instanceof PacifistVillager){
            this.damage = this.damage + (this.damage * 5/100);
        }
        
        enemy.setHp( enemy.getHp() - this.damage );
        System.out.println(this.getName() + " ataca a " + enemy.getName() + " y lo deja con " + enemy.getHp() + " puntos de vida");

        this.damage = originalDamage;
    }
}
