import java.util.*;
public class Families{
    public Set<User> collection;  
    private String family; 
    public Admin admin; 
    public Families(String family, Admin admin){
        this.collection = new LinkedHashSet<>(); 
        this.family = family; 
        this.admin = admin; 
    }

    // public static void newSet(Families s){
    //     Scanner sc = new Scanner(System.in); 
    //     String name, pswd; 
    //     double budget; 
    //     System.out.println("You've created a new family set, just a few more steps to finish your family registration");
    //     System.out.println("Name of the administrator: ");
    //     name = sc.nextLine(); 
    //     System.out.println("Write a password");
    //     pswd = sc.nextLine(); 
    //     System.out.println("Type the desired budget for this month (USD)");
    //     budget = sc.nextDouble(); 
    //     Admin a = new Admin(name, pswd, budget);
    //     s.collection.add(a); 
    //     s.admin = a; 
    // }

    public static void setMenu(Families family){
        int op; 
        do{
            Scanner sc = new Scanner(System.in); 
            System.out.println("You've entered as a " + family.getFamily() + " family member, welcome!");
            System.out.println("[1] Login as a member");
            System.out.println("[2] Loggin as an administrator");
            System.out.println("[3] Register a new mamber");
            System.out.println("[4] See active members");
            op = sc.nextInt(); 
            switch (op) {
                case 1:
                    Scanner sc2 = new Scanner(System.in); 
                    System.out.println("Type your name: ");
                    String name = sc2.nextLine();
                    for(User user : family.collection){
                        if(name.equals(user.getName())){
                            User.userMenu(family, user);
                        }
                    }
                    System.out.println("Not found");
                    break;
                case 2: 
                    Admin.adminMenu(family, family.admin);
                    break;
                case 3: 
                    User.addUser(family);
                    break;
                case 4: 
                    for(User user : family.collection){
                        System.out.println(user.getName());
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(true); 
    }

    public String getFamily(){
        return family; 
    }
    public void setFamily(String famliy){
        this.family = famliy; 
    }
}
