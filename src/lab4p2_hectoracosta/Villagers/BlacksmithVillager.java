
package lab4p2_hectoracosta.Villagers;

import java.util.Random;
import lab4p2_hectoracosta.Villager;


public class BlacksmithVillager extends Villager {
    
    Random r = new Random();
    
    public BlacksmithVillager(String name, String lastName, int age, int hp) {
        super(name, lastName, age, hp);
        this.hp = hp + (hp * 50/100);
        this.damage = r.nextInt(500-200)+200;
    }
    
    @Override
    public void attack(Villager enemy){
        int originalDamage = this.damage;
        if(enemy instanceof AgronomistVillager){
            this.damage = this.damage + (this.damage * 10/100);
        }else if(enemy instanceof PacifistVillager){
            this.damage = this.damage + (this.damage * 5/100);
        }
        
        enemy.setHp( enemy.getHp() - this.damage);
        System.out.println(this.getName() + " ataca a " + enemy.getName() + " y lo deja con " + enemy.getHp() + " puntos de vida");

        
        this.damage = originalDamage;
    }
}
