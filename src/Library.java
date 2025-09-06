import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Patron> patrons;

    public Library() {
        patrons = new ArrayList<>();
    }

    public void addPatron(Patron p) {
        patrons.add(p);
    }

    public void addPatronsFromFile(String filename){
        int count =0;
        // Automatically append .txt if it’s not already there
        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    double fineAmount = Double.parseDouble(parts[3]);

                    Patron p = new Patron(id, name, email, fineAmount);
                    patrons.add(p);
                    count ++;
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println(count + " patron(s) successfully loaded from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    public void removePatron(String id){
        boolean removed = patrons.removeIf(p -> p.getId().equals(id));
        if (removed) {
            System.out.println("Patron with ID " + id + " was removed.");
        } else {
            System.out.println("No patron found with ID " + id + ".");
        }
    }

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
