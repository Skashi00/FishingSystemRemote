import java.util.Scanner;

public class FishingAdvisor {
    public static void main(String[] args){
        // User input //
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Välkommen till FishingAdvisor ===");
        System.out.println("Din guide till bättre fiske, varje gång.\n");
        System.out.println(">> Vänligen ange en månad för att fortsätta:");
        
        // Läser in en månad från användaren, tar bort extra mellanslag och gör om till små bokstäver

        String month = scanner.nextLine().trim().toLowerCase();
        





        scanner.close();

    }
}
