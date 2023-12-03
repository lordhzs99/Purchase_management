import java.util.List;
import java.util.ListIterator;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
