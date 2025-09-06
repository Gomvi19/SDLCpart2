//Victor Gomez, CEN3024C, 09/06/2025
//Library class
//holds a list of Patron objects and performs methods to add patrons, load from a file, removed patrons, and display the list of patrons
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Patron> patrons;

    //constructor
    public Library() {
        patrons = new ArrayList<>();
    }
    //adding patron from console manually
    public void addPatron(Patron p) {
        patrons.add(p);
    }

    //addPatronsFromFile
    //loads patrons from a file
    // takes the file's address as input
    //void method doesn't return anything but displays a message to the user confirming the patrons have been loaded
    public void addPatronsFromFile(String filename){
        int count =0; //count of patrons added
        // Automatically append .txt if it’s not already there
        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) { //reading until last line in the file
                String[] parts = line.split("-"); //separating fields by "-"
                if (parts.length == 4) { //if each line has 4 parts separated by "-" each part is assigned to a variable
                    String id = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    double fineAmount = Double.parseDouble(parts[3]);

                    Patron p = new Patron(id, name, email, fineAmount); //creating the Patron object with the input from the file
                    patrons.add(p);
                    count ++; //increasing count by one to let the user know how many users where added from the file
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println(count + " patron(s) successfully loaded from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //removePatron
    //removes Patrons from list
    //takes the id value to be looked at in the list to delete the patron
    //void function doesn't return anything but displays a message to let the user know if hte patron was deleted
    public void removePatron(String id){
        boolean removed = patrons.removeIf(p -> p.getId().equals(id));
        if (removed) {
            System.out.println("Patron with ID " + id + " was removed.");
        } else {
            System.out.println("No patron found with ID " + id + ".");
        }
    }
    //displayPatrons
    //displays the list of patrons
    //takes no arguments
    //void methods doesn't return anything, prints the list if is not empty
    public void displayPatrons(){
        if (patrons.isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

}
