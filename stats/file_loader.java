package stats;

import java.util.*;
import java.io.*;
import users.User;

public class file_loader implements Serializable {

    public static void saveData(List<User> list){
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("nodelist.dat"));
            output.writeObject(list);
            output.close();
        }
        catch(IOException e){
            System.err.println("Error saving to file");
        }
    }

    public static List readData(){
        List <User> in = new ArrayList<>(); 
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("nodelist.dat"));
            in = (List<User>) input.readObject(); 
            input.close();
        }
        catch(IOException e){
            System.err.println("Error opening file");
        }
        catch(ClassNotFoundException e2){
            System.err.println("Object read is not a node");
        }
        return in; 
    }
}
