package lab4p2_hectoracosta.Villagers;

import lab4p2_hectoracosta.Villager;

public class SuperVillager extends Villager{
    
    public SuperVillager(String name, String lastName, int age, int hp) {
        super(name, lastName, age, 1000);
        this.damage = 1000;
    }
    
    @Override
    public void attack(Villager enemy){
        
        int originalDamage = this.damage;
        
        if(enemy instanceof BlacksmithVillager){
            this.damage = this.damage + (this.damage * 10/100);
        }else if(enemy instanceof ExplosiveVillager){
            this.damage = this.damage + (this.damage * 15/100);
        }
        
        
        enemy.setHp( enemy.getHp() - this.damage);
        System.out.println(this.getName() + " ataca a " + enemy.getName() + " y lo deja con " + enemy.getHp() + " puntos de vida");
        
        this.damage = originalDamage;
        
    }
    
}
