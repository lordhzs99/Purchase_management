import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner; 
import java.util.Iterator;

public class User implements Serializable{
    private String name, pswd;
    private double budget;  
    public User(String name, String pswd, double budget){
        this.name = name; 
        this.pswd = pswd; 
        this.budget = budget; 
    }
    
    public static void addUser(Families family){
        Scanner sc = new Scanner(System.in); 
        String name, pswd;
        name = sc.nextLine(); 
        String s = sc.nextLine(); 
        pswd = sc.nextLine(); 
        User user = new User(name, pswd, 0.08f); 
        family.collection.add(user); 
    }

     public static void userMenu(Families family, User user){
        System.out.println("Welcome " + user.getName() + ", what you wanna do today?");
        do{
            Scanner sc = new Scanner(System.in); 
            int op; 
            System.out.println("- CURRENT BUDGET: " + user.getBudget());
            System.out.println("[1] Add purchases");
            System.out.println("[2] View statistics");
            System.out.println("[3] View lasts purchases");
            System.out.println("[4] Add reminder");
            System.out.println("[5] Save data from purchases");
            System.out.println("[6] Exit");
            op = sc.nextInt(); 
            switch (op) {
                case 1:
                    // addPurchases();
                    break;
                case 2: 
                    // STATISTICS
                    break;
                case 3: 
                    break;
                case 4: 
                    break;
                case 5: 
                    // file_loader.saveData(family);
                    break; 
                case 6: 
                    return; 
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(true); 
    }

    public void setName(String name){
        this.name = name; 
    }
     public void setpswd(String pswd){
        this.pswd = pswd; 
    } 
    public void setBudget(double budget){
        this.budget = budget; 
    }
    public String getName(){
        return name; 
    }
    public double getBudget(){
        return budget; 
    }
}
