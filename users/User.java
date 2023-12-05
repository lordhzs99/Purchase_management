package users;

import java.io.*;
import java.util.*;
import stats.*;
import purchase.*;

public class User implements Serializable{
    private String name, pswd;
    private double budget;  
    public List <User> list; 
    private LinkedList<Object> categories; 

    public User(String name, String pswd, double budget){
        this.name = name; 
        this.pswd = pswd; 
        this.budget = budget; 
        this.list = new ArrayList<>(); 
        categories = new LinkedList<>();
        categories.add(new Fun());
        categories.add(new Food());
        categories.add(new Services());
        this.reminder = new Reminder();
    }
    
    public static void addUser(Families family){
        Scanner sc = new Scanner(System.in); 
        String name, pswd;
        System.out.println("-------------------");
        System.out.println("Type the name of the new user: ");
        name = sc.nextLine(); 
        //String s = sc.nextLine(); 
        System.out.println("Type the password: ");
        pswd = sc.nextLine(); 
        User user = new User(name, pswd, 0.08f); 
        family.collection.add(user); 
        File f = new File("./families/" + family.getFamily() + "/" + name); 
        if(f.mkdir() != true){
            System.out.println("Directory cannot be created because it already exists");
        }
        File reminders = new File("./families/" + family.getFamily() + "/" + name + "/reminders"); 
        if(reminders.mkdir() != true){
            System.out.println("Directory cannot be created because it already exists");
        }
        File purchases = new File("./families/" + family.getFamily() + "/" + name + "/purchases"); 
        if(purchases.mkdir() != true){
            System.out.println("Directory cannot be created because it already exists");
        }
    }

     public static void userMenu(Families family, User user){
        System.out.println("Welcome " + user.getName() + ", what you wanna do today?");
        do{
            Scanner sc = new Scanner(System.in); 
            int op; 
            System.out.println("- CURRENT BUDGET: " + user.getBudget() + "$ (USD)");
            System.out.println("[1] Add purchases");
            System.out.println("[2] View statistics");
            System.out.println("[3] View lasts purchases");
            System.out.println("[4] Add reminder");
            System.out.println("[5] Save data from purchases");
            System.out.println("[6] Exit");
            op = sc.nextInt(); 
            switch (op) {
                case 1:
                    addPurchase(user);
                    break;
                case 2: 
                    // STATISTICS
                    break;
                case 3: 
                    // last purchases
                    break;
                case 4:
                    Reminder.RMenu(user);
                    break;
                case 5: 
                    file_loader.saveData(family, user);
                    break; 
                case 6: 
                    return; 
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(true); 
    }

    protected static void addPurchase(User user){
        
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
