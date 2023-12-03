import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.security.sasl.SaslException;

import java.util.Iterator;
import java.util.Hashtable; 
import java.util.LinkedHashSet;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        Hashtable<String, Families> map = new Hashtable<String, Families>( );
        List<User> list = new ArrayList<User>(), in = new ArrayList<User>();
        do{
            System.out.println("[1] See current families");
            System.out.println("[2] Create family set");
            System.out.println("[3] Log in");
            int op = sc.nextInt(); 
            switch (op) {
                case 1:
                    for(Map.Entry<String, Families> fam : map.entrySet()){
                        System.out.println(fam.getKey() + "'s family");
                    }
                    break;
                case 2: 
                    Scanner sc2 = new Scanner(System.in); 
                    String famName; 
                    String name, pswd; 
                    double budget; 
                    System.out.println("Thanks for register to this app");
                    System.out.println("--- Type your family's last name to start a new family income management ---");
                    famName = sc2.nextLine(); 
                    String q = sc.nextLine(); 
                    System.out.println("You've created a new family set, just a few more steps to finish your family registration");
                    System.out.println("Name of the administrator: ");
                    name = sc.nextLine(); 
                    System.out.println("Write a password");
                    pswd = sc.nextLine(); 
                    System.out.println("Type the desired budget for this month (USD)");
                    budget = sc.nextDouble(); 
                    Admin a = new Admin(name, pswd, budget);
                    Families s = new Families(famName, a); 
                    map.put(famName, s); 
                    //Families.newSet(s);
                    System.out.println("You've signed in succesfully, you can now acces to your family's account!");
                    break;
                case 3: 
                    Scanner sc3 = new Scanner(System.in); 
                    System.out.println("Type your family's last name");
                    String famin = sc3.nextLine(); 
                    if(map.containsKey(famin)){
                        Families.setMenu(map.get(famin)); 
                    }else{
                        System.out.println("Your family is not registered yet");
                    }
                case 4: 
                    return; 
                default:
                    System.out.println("Invalid");
                    break;
            }
        }while(true); 
    }
}
