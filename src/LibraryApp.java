import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {
    private static Library library = new Library(); //instantiation of library
    private static Scanner input = new Scanner(System.in);
    //menu to show the user
    public static void displayMenu() {
        System.out.println("Library App");
        System.out.println("Choose an option: ");
        System.out.println("1. Add Patron");
        System.out.println("2. Import Patrons from File");
        System.out.println("3. Remove Patron");
        System.out.println("4. Display Patrons");
        System.out.println("5. Quit");
    }
    //handleInput calls the methods depending on user input
    public static void handleInput()  {
        int choice;
        do {
            displayMenu();
            choice = input.nextInt();
            input.nextLine(); // consume leftover newline
            //selecting method based on user input
            switch (choice) {
                case 1: // Add Patron
                    System.out.print("Enter id: ");
                    String id = input.nextLine();
                    while(id.length() != 7){ //verifying if ID is 7 digits
                        System.out.println("ID must be 7 digits");
                        System.out.println("Enter id: ");
                        id = input.nextLine();
                    }
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("Enter address: ");
                    String address = input.nextLine();
                    System.out.print("Enter fine amount: ");
                    double fineAmount = input.nextDouble();
                    while (fineAmount < 0 || fineAmount > 250) { //verifying that fine is between 0 and 250
                        System.out.println("Number must be between 0 and 250");
                        System.out.print("Enter fine amount: ");
                        fineAmount = input.nextDouble();
                    }
                    input.nextLine(); // consume leftover newline
                    Patron patron = new Patron(id, name, address, fineAmount);
                    library.addPatron(patron);
                    System.out.println("Patron added successfully.");
                    break;



                case 2: // Import Patrons
                    System.out.print("Enter filename: ");
                    String filename = input.nextLine();
                    library.addPatronsFromFile(filename);
                    break;

                case 3: // Remove Patron
                    System.out.print("Enter ID of patron to remove: ");
                    String removeId = input.nextLine();
                    library.removePatron(removeId);
                    break;

                case 4: // Display Patrons
                    library.displayPatrons();
                    break;

                case 5: // Quit
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 5);
    }


    public static void main(String[] args) {
        handleInput();//start the loop
    }






}
