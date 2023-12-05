import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reminder {
    private List<RecurrentExpense> recurrentExpenses;

    public Reminder() {
        this.recurrentExpenses = new ArrayList<>();
    }

    public void addExpense(RecurrentExpense expense) {
        recurrentExpenses.add(expense);
    }

    public void remindUser() {
        LocalDate today = LocalDate.now();

        for (RecurrentExpense expense : recurrentExpenses) {
            // Recordar al usuario un día antes del pago
            if (expense.getNextPaymentDate().minus(1, ChronoUnit.DAYS).isEqual(today)) {
                System.out.println("Recordatorio: Pago próximo para " + expense.getName() +
                        " de " + expense.getAmount() + " programado para mañana.");
            }
        }
    }

    public void RMenu(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the date of the next payment (format yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate paymentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("Enter the reason for the payment: ");
        String expenseName = scanner.nextLine();

        System.out.println("Enter the amount of the payment: ");
        double amount = scanner.nextDouble();

        RecurrentExpense newExpense = new RecurrentExpense(expenseName, amount, paymentDate);
        addExpense(newExpense);
        System.out.println("Recurrent expense added successfully");
    }

     public void showReminders() {
        if (recurrentExpenses.isEmpty()) {
            System.out.println("No hay recordatorios guardados.");
        } else {
            System.out.println("Recordatorios:");
            for (RecurrentExpense expense : recurrentExpenses) {
                System.out.println("Fecha del próximo pago para " + expense.getName() +
                        ": " + expense.getNextPaymentDate() +
                        ", Monto: " + expense.getAmount());
            }
        }
    }
}
