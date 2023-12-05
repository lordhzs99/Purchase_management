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
            LocalDate nextPaymentDate = today.plus(expense.getRecurrenceDays(), ChronoUnit.DAYS);

            // Recordar al usuario un día antes del pago
            if (nextPaymentDate.minus(1, ChronoUnit.DAYS).isEqual(today)) {
                System.out.println("Recordatorio: Pago próximo para " + expense.getName() +
                        " de " + expense.getAmount() + " programado para mañana.");
            }
        }
    }
}
