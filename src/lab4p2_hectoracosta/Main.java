package lab4p2_hectoracosta;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import lab4p2_hectoracosta.Villagers.*;

public class Main {
    
    public static ArrayList<Family> families = new ArrayList();
    
    public static void main(String[] args) {
        
        //Familia Capuleto 
        Family capuleto = new Family("Capuleto");
        
        NormalVillager normalito = new NormalVillager("Hector","Capuleto",19,200);
        PacifistVillager pacifista = new PacifistVillager("Jeri","Capuleto",19,200);
        BlacksmithVillager herrero = new BlacksmithVillager("David","Capuleto",20,400);
        
        capuleto.addVillager(herrero);
        capuleto.addVillager(pacifista);
        capuleto.addVillager(normalito);
        families.add(capuleto);
        
        //Familia Montesco 
        Family montesco = new Family("Montesco");
        NormalVillager normalito1 = new NormalVillager("Bellaco","Montesco",20,200);
        PacifistVillager pacifista1 = new PacifistVillager("Josue","Montesco",19,300);
        BlacksmithVillager herrero1 = new BlacksmithVillager("Michael","Montesco",20,500);
        SuperVillager Romeo = new SuperVillager("Romeo","Montesco",20,1000);
        
        montesco.addVillager(Romeo);
        montesco.addVillager(herrero1);
        montesco.addVillager(pacifista1);
        montesco.addVillager(normalito1);
        families.add(montesco);
        
        //Familia Acosta
        Family acosta = new Family("Acosta");
        NormalVillager normalito2 = new NormalVillager("Cesar","Acosta",40,250);
        PacifistVillager pacifista2 = new PacifistVillager("Alvaro","Acosta",21,300);
        BlacksmithVillager herrero2 = new BlacksmithVillager("Wilmer","Acosta",30,350);
        
        acosta.addVillager(herrero2);
        acosta.addVillager(normalito2);
        acosta.addVillager(pacifista2);
        families.add(acosta);

        
        int opt = 0;
        while(opt != 5){
            opt = menu();
            switch(opt){
                case 1:
                    listFamilies();
                    break;
                case 2:
                    createFamily();
                    break;
                case 3:
                    createVillager();
                    break;
                case 4:
                    play();
                    print("Ejecutado en consola");
                    break;
                case 5:
                    print("Programa Finalizado");
                    break;
            }
        }
    }
    
    
    public static int menu(){
        return Integer.parseInt( 
                JOptionPane.showInputDialog("----MENU----\n1)Listar Familias\n2)Crear Familia\n3)Crear Aldeano\n4)Play\n5)Salir\nIngrese una opcion: ") 
        );
    }
    
    public static int villagerMenu(){
        return Integer.parseInt( 
                JOptionPane.showInputDialog("--Tipos de Aldeanos--\n1)Normal\n2)Pacifista\n3)Agronomo\n4)Herrero\n5)Explosivo\nIngrese una opcion:") 
        );
    }
    
    public static void print(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static String inputString(String message){
        return JOptionPane.showInputDialog(message);
    }
    
    public static int inputInt(String message){
      return Integer.parseInt( JOptionPane.showInputDialog(message) );
    }
    
    //Metodo para crear una familia
    public static void createFamily(){
        String lastName = inputString("Ingrese el apellido de la familia: ");
        Family newFamily = new Family(lastName);
        families.add(newFamily);
    }
    
    public static void listFamilies(){
        String familias = "";
        for (Family family : families) {
            familias += "\n"+family.toString()+"\n";
        }
        print(familias);
    }
    
    public static void play(){         
            Family montesco = getFamilyByLastName("Montesco");
            while(families.size()>1){
                
                String lastName = JOptionPane.showInputDialog("--Familias--\n"+familiesNames() + "\nIngrese la siguiente familia que va a pelear contra los Montesco: ");
                if(lastNameExists(lastName)){
                    Family locales = getFamilyByLastName("Montesco");
                    Family luchadora = getFamilyByLastName(lastName);
                    System.out.println("La batalla ha comenzado");

                    for (Villager fighter1 : locales.getVillagers()) {
                        for (Villager fighter2 : luchadora.getVillagers()) {
                            if(fighter1.alive && fighter2.alive){
                                fight(fighter1,fighter2);
                            }
                        }
                    }

                    if(aliveCount(locales) == 0){
                        System.out.println( "Los " + luchadora.getLastName() + " vencieron a " + locales.getLastName());
                        families.remove(locales);
                    }else if(aliveCount(luchadora)==0){
                        System.out.println( "Los " + locales.getLastName() + " vencieron a " + luchadora.getLastName());
                        families.remove(luchadora);
                    }
                }
                
                if(!families.contains(montesco)){
                    break;
                }
            }
            
            if(families.contains(montesco)){
                System.out.println("Romeo se quedo con Julieta siiuuuuu");
            }else{
                System.out.println("Romeo no se quedo con Julieta, su familia fue eliminada");
            }
    }
    
    
    public static  int aliveCount(Family family){
        int c=0;
        for (Villager villager : family.getVillagers()) {
            if(villager.alive){
                c++;
            }
        }
        return c;
    }
    
    public static void fight(Villager fighter1,Villager fighter2){
        while(fighter1.getHp() >0 && fighter2.getHp() > 0 ){
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
        }
        if(fighter1.getHp() > fighter2.getHp()){
            System.out.println( fighter2.getName() + " ha sido eliminado");
            String lastName = fighter2.getLastName();
            fighter2.alive = false;
        }else{
            System.out.println( fighter1.getName() + " ha sido eliminado");
            String lastName = fighter1.getLastName();
            fighter1.alive = false;
        }
    }
    
    //Retorna los apellidos de todas las familias
    public static String familiesNames(){
        String familiesNames = "";
        for (Family family : families) {
            if(!family.getLastName().equals("Montesco")){
                familiesNames += family.getLastName() + "\n";
            }
        }
        return familiesNames;
    }
    
    //Metodo para crear un Aldeano 
    public static void createVillager(){
        String name = inputString("Ingrese el nombre del aldeano: ");
        String lastName = inputString("Ingrese el apellido del aldeano: ");
        int age = inputInt("Ingrese edad del aldeano: ");
        int hp = inputInt("Ingrese puntos de vida del aldeano: ");
        
        if(lastNameExists(lastName)){
            Family family = getFamilyByLastName(lastName);
            int opc = villagerMenu();
            switch(opc){
                case 1:
                    NormalVillager newNormalVillager = new NormalVillager(name,lastName,age,hp);
                    family.addVillager(newNormalVillager);
                    break;
                case 2:
                    PacifistVillager newPacifistVillager = new PacifistVillager(name,lastName,age,hp);
                    family.addVillager(newPacifistVillager);
                    break;
                case 3:
                    AgronomistVillager newAgronomistVillager = new AgronomistVillager(name,lastName,age,hp);
                    family.addVillager(newAgronomistVillager);
                    break;
                case 4:
                    BlacksmithVillager newBlacksmithVillager = new BlacksmithVillager(name,lastName,age,hp);
                    family.addVillager(newBlacksmithVillager);
                    break;
                case 5:
                    ExplosiveVillager newExplosiveVillager = new ExplosiveVillager(name,lastName,age,hp);
                    family.addVillager(newExplosiveVillager);
                    break;
            }
        }else{
            print("No existe una familia con ese apellido");
        }
    }
    
    public static boolean lastNameExists(String lastName){
        for (Family family : families) {
            if(family.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }
    
    public static Family getFamilyByLastName(String lastName){
        for (Family family : families) {
            if(family.getLastName().equals(lastName)){
                return family;
            }
        }
        return null;
    }
    
}
