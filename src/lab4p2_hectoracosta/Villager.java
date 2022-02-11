package lab4p2_hectoracosta;

public class Villager {    
    
    private String name;     
    private String lastName;
    private int age;
    public int hp;
    public int damage;

    public Villager(String name, String lastName, int age, int hp) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.hp = hp;
    }
    
    
    /**
     * Get the value of damage
     *
     * @return the value of damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set the value of damage
     *
     * @param damage new value of damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    
    /**
     * Get the value of hp
     *
     * @return the value of hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Set the value of hp
     *
     * @param hp new value of hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    
    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ""
                + "\n Aldeano: " + name + ",Apellido: " + lastName + ",Edad: " + age + ",Puntos de vida: " + hp + ",Puntos de ataque: " + damage + "\n";
    }

    public void attack(Villager enemy){
        
    }
    
}
