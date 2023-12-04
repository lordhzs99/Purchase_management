package purchase;

import java.util.regex.*;

public abstract class  Expense {
    
    static Pattern datePattern = Pattern.compile("[0-3]\\d/[0-1]\\d/d{4}");
    private double amount;
    private String concept;
    private String date;

    

}
