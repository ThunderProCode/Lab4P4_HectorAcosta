package lab4p2_hectoracosta;

import java.util.ArrayList;

public class Family {

    private String lastName;
    private ArrayList<Villager> villagers = new ArrayList();

    public Family(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void addVillager(Villager villager){
        this.villagers.add(villager);
    }

    public ArrayList<Villager> getVillagers() {
        return villagers;
    }

    public void setVillagers(ArrayList<Villager> villagers) {
        this.villagers = villagers;
    }
    
    

    @Override
    public String toString() {
        return "\nFamilia: " + lastName + "\n Aldeanos: " + villagers;
    }
    
    
    
}
