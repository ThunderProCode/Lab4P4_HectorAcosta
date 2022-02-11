/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_hectoracosta.Villagers;

import lab4p2_hectoracosta.Villager;

/**
 *
 * @author ThunderKnight
 */
public class AgronomistVillager extends Villager {
    
    public AgronomistVillager(String name, String lastName, int age, int hp) {
        super(name, lastName, age, hp);
        this.damage = 100;
    }
    
    @Override
    public void attack(Villager enemy){
        int originalDamage = this.damage;
        
        if(enemy instanceof PacifistVillager){
            this.damage = this.damage + (this.damage * 5/100);
        }else if(enemy instanceof NormalVillager){
            this.damage = this.damage + (this.damage * 10/100);
        }
        enemy.setHp( enemy.getHp() - this.damage );
        System.out.println(this.getName() + " ataca a " + enemy.getName() + " y lo deja con " + enemy.getHp() + " puntos de vida");
        
        this.damage = originalDamage;
    }
    
}
