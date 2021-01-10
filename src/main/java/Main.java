/*
Fix Bugs of the Application.
DESCRIPTION

Project objective:
As a developer, fix the bugs in the application using the appropriate algorithmic techniques.

Background of the problem statement:
You have been assigned a few tasks during the sprint planning. Solving the bugs raised by the testing team is one among them. You are given the boilerplate code and are asked to complete it by fixing the bugs.

Bugs to be fixed:
Add the missing source code to the application based on searching technique. Find the appropriate comments to code for the searching technique.
Write source code for sorting the predefined array and ensure the functionality of the application. Find the appropriate comments to code for sorting the predefined array.
You can download the boilerplate code by executing the command below in your git bash.
git clone https://github.com/Simplilearn-Edu/Full-Stack---The-Desk-Application-.git

You must use the following:
Eclipse/IntelliJ: An IDE to code for the application
Java: A programming language to develop the prototype
Git: To connect and push files from local system to GitHub
GitHub: To store the application code and track its versions
Search and Sort techniques: Select the relevant data structure algorithms to fix the bugs

Following requirements should be met:
The source code should be pushed to your GitHub repositories. You need to document the steps and write the algorithms in the Google Docs.
The link of your GitHub repository is must. In order to track your task, you need to share the link of the repository. You can add a section in the Google Docs.
Document the step-by-step process involved in completing this task.
 */

import java.util.*;

public class Main {
    /*
        While Integers shouldn't be used for handling money, I wasn't sure if changing the list to BigDecimal
        was allowed or wanted for this assignment, so I left the List as a List of Integers.
     */
    private static List<Integer> expenses = new ArrayList<>();
    private static final String ERROR_MESSAGE = "ERROR: Please enter a valid integer!";

    private final static StringBuilder arr = new StringBuilder()
            .append("1. I wish to review my expenditure\n")
            .append("2. I wish to add my expenditure\n")
            .append("3. I wish to delete my expenditure\n")
            .append("4. I wish to sort the expenditures\n")
            .append("5. I wish to search for a particular expenditure\n")
            .append("6. Close the application\n");

    public static void main(String[] args) {

        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        System.out.println("\nEnter your choice:\t");

        addInitialExpenses();
        System.out.println("Current expenses: " + expenses);
        optionsSelection();

    }

    private static void addInitialExpenses() {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
    }

    private static void optionsSelection() {

        int optionSelected = 1;

        do {
            System.out.print(arr);
            Scanner sc = new Scanner(System.in);

            /*
                Ensures valid user input by catching an InputMismatchException which continues to the next iteration
                to allow the user to try again.
             */
            try {
                optionSelected = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n" + ERROR_MESSAGE + "\n");
                continue;
            }

            switch (optionSelected) {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses + "\n");
                    break;
                case 2:
                    addExpenditure(sc);
                    break;
                case 3:
                    deleteExpenses(optionSelected, sc);
                    break;
                case 4:
                    sortExpenses(expenses);
                    break;
                case 5:
                    searchExpenses(expenses, sc);
                    break;
                case 6:
                    closeApp();
                    break;
                /*
                    Allow the user to pick another option if they make a non-existent choice by accident.
                 */
                default:
                    System.out.println("\nYou have made an invalid choice!\nChoose '6' if you wish to exit.\n");
                    break;
            }

            // The loop will not end unless option 6 is selected.
        } while (true);
    }

    // exits the program
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
        System.exit(0);
    }

    private static void searchExpenses(List<Integer> arrayList, Scanner sc) {
        System.out.println("Enter the expense you need to search:\t");

        int key = -1;
        try {
            key = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n" + ERROR_MESSAGE);
            return;
        }

        System.out.println(arrayList);

        // Searching to see if an element exists in the List can be easily accomplished through using the indexOf method
        int index = arrayList.indexOf(key);

        if (index < 0)
            System.out.println(key + " is not present in the list!");
        else
            System.out.println("Value " + "[ " + key + " ]" + " has been found at index: " + index);
    }

    //Sorts in ascending order using the existing functionality given to us by Collections
    private static void sortExpenses(List<Integer> arrayList) {
        Collections.sort(arrayList);
        System.out.println("\n" + arrayList);
    }

    private static void deleteExpenses(int optionSelected, Scanner sc) {
        System.out.println("You are about the delete all your expenses! " +
                "\nConfirm again by selecting the same option...\n");
        int con_choice = -1;

        try {
            con_choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        // Empty the list if the user wants to delete all the expenses
        if (con_choice == optionSelected) {
            expenses.clear();
            System.out.println(expenses + "\n");
            System.out.println("All your expenses are erased!\n");
        } else {
            System.out.println("Oops... try again!");
        }
    }

    private static void addExpenditure(Scanner sc) {
        System.out.println("Enter the value to add your Expense: \n");
        int value;
        try {
            value = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        System.out.println("Your value is updated\n");
        expenses.add(value);
        System.out.println(expenses + "\n");
    }
}
