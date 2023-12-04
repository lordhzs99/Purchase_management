package users;

import java.io.Serializable;
//import java.io.*;
import java.util.*;

public class Admin extends User implements Serializable{
    public static int n; 
    public Admin(String name, String pswd, double budget){
        super(name, pswd, budget); 
    }

    public static void adminMenu(Families family, Admin admin){
        System.out.println("Welcome " + admin.getName() + ", what you wanna do today?");
        Scanner sc = new Scanner(System.in); 
        do{
            int op; 
            System.out.println("[1] Modify budget");
            System.out.println("[2] View statistics");
            System.out.println("[3] Save data from family members");
            System.out.println("[4] Delete family member from family set");
            System.out.println("[5] Exit");
            op = sc.nextInt(); 
            switch (op) {
                case 1:
                    Scanner sc2 = new Scanner(System.in);
                    String name; 
                    boolean found = false; 
                    System.out.println("Type the family member: ");
                    name = sc2.nextLine(); 
                    for(User user : family.collection){
                        if(name.equals(user.getName())){
                            modifyBudget(user);
                            found = true;  
                        }
                    }
                    if(!found){
                        System.out.println("The desired user is not registered");
                    }else{
                        System.out.println("Budget succesfully modified");
                    }
                    break;
                case 2: 
                    // STATISTICS
                    break;
                case 3: 
                    // file_loader.saveData(family);
                    break;
                case 4: 
                    Scanner sc3 = new Scanner(System.in); 
                    String name3; 
                    boolean found3 = false; 
                    System.out.println("Type the family member: ");
                    name3 = sc3.nextLine(); 
                    for(User user : family.collection){
                        if(name3.equals(user.getName())){
                            deleteNode(user, family.collection);
                            found3 = true;  
                        }
                    }
                    if(!found3){
                        System.out.println("The desired user is not registered");
                    }else{
                        System.out.println("Member succesfully deleted");
                    }
                case 5: 
                    return; 
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(true); 
    }

    public static void modifyBudget(User user){
        Scanner sc = new Scanner(System.in); 
        double b; 
        System.out.println("Current budget: " + user.getBudget());
        System.out.println("New budget: ");
        b = sc.nextDouble();
        user.setBudget(b);
        
    }

    public static void deleteNode(User user, Set<User> set){
        set.remove(user);
    }
}
