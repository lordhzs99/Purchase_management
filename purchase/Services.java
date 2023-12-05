package purchase;

import java.util.*;

public class Services implements CategoryFactory{

    double total;
    LinkedList<FixExpense> FixExpenses;
    LinkedList<RecurrentExpense> RecurrentExpenses;

    public Services(){
        total = 0;
        FixExpenses = new LinkedList<>();
        RecurrentExpenses = new LinkedList<>();
    }

    @Override
    public void addFixExpense(double amount, String concept, String date){
        FixExpense aux = FixExpense.newFixExpense(total, null, null);
        total += amount;
        FixExpenses.add(aux);
    }

    @Override
    public void addRecurrentExpense(double amount, String concept, String date, int period) {
        RecurrentExpense aux = RecurrentExpense.newRecurrentExpense(amount, concept, date, period);
        total += amount;
        RecurrentExpenses.add(aux);
    }
    
}
