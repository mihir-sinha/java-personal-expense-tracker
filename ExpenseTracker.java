
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = loadExpenses();

        while (true) {
        System.out.println("1. Add expense");
        System.out.println("2. View expenses");
        System.out.println("3. Show total spending");
        System.out.println("4. Monthly expense report");
        System.out.println("5. Exit");  
            System.out.print("Choose an option: ");
            String input = sc.nextLine();

int choice;

try {
    choice = Integer.parseInt(input);
} catch (NumberFormatException e) {
    System.out.println("Invalid input. Please enter a number.");
    continue;
}
           
             if (choice == 1) {
               System.out.print("Enter amount: ");
                String amountInput = sc.nextLine();
                double amount;
        try {
    amount = Double.parseDouble(amountInput);
} 
    catch (NumberFormatException e) {
    System.out.println("Invalid amount. Please enter a number.");
    continue;
}
if (!Double.isFinite(amount) || amount <= 0) {
    System.out.println("Invalid amount. Enter a finite number greater than zero.");
    continue;
}
                System.out.print("Enter category: ");
                String category = sc.nextLine().trim();

if (category.isEmpty()) {
    System.out.println("Category cannot be empty.");
    continue;
}

            System.out.print("Enter description: ");
            String description = sc.nextLine().trim();

if (description.isEmpty()) {
    System.out.println("Description cannot be empty.");
    continue;
}

                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                try {
                  java.time.LocalDate.parse(date);
                } catch (java.time.format.DateTimeParseException e) {
               System.out.println("Invalid date. Use YYYY-MM-DD format.");
       continue;
}

                if (Double.isFinite(amount) && amount > 0) { 
                    Expense expense = new Expense(amount, category, description, date);
                    expenses.add(expense);
                    saveExpenses(expenses);
                    System.out.println("Expense added successfully!");
                } else {
                    System.out.println("Amount must be greater than zero.");
                }

            } else if (choice == 2) {
                if (expenses.isEmpty()) {
                    System.out.println("No expenses recorded.");
                } else {
                    for (Expense e : expenses) {
                        System.out.println(
                            e.date + " | " + e.category + " | " +
                            e.description + " | " + e.amount
                        );
                    }
                }

            } else if (choice == 3) {
                double total = 0;

                for (Expense e : expenses) {
                    total += e.amount;
                }

                System.out.printf("Total spending: %.2f%n", total);
                } else if (choice == 4) {
                System.out.print("Enter month (YYYY-MM): ");
                String month = sc.nextLine();

                try {
                 java.time.YearMonth.parse(month);
            } catch (java.time.format.DateTimeParseException e) {
              System.out.println("Invalid month. Use YYYY-MM format.");
     continue;
}

             double monthlyTotal = 0;

    for (Expense e : expenses) {
        if (e.date.startsWith(month)) {
            monthlyTotal += e.amount;
        }
    }

    System.out.printf("Total spending for %s: %.2f%n", month, monthlyTotal);

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
    public static void saveExpenses(ArrayList<Expense> expenses) {
    try (PrintWriter writer = new PrintWriter("expenses.txt")) {
        for (Expense e : expenses) {
            writer.println(e.amount + "," + e.category + "," +
                           e.description + "," + e.date);
        }
    } catch (IOException e) {
        System.out.println("Error saving expenses.");
    }
    
}
public static ArrayList<Expense> loadExpenses() {
    ArrayList<Expense> expenses = new ArrayList<>();

    try (Scanner fileScanner = new Scanner(new File("expenses.txt"))) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",", -1);

            if (data.length == 4) {
                double amount = Double.parseDouble(data[0]);
                String category = data[1];
                String description = data[2];
                String date = data[3];

                expenses.add(new Expense(amount, category, description, date));
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("No previous expenses found. Starting fresh.");
    }

    return expenses;
}
}
