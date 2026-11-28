import java.util.Scanner;

class FoodInspector {
    String foodName;
    int qualityScore;

    FoodInspector(String foodName, int qualityScore) {
        this.foodName = foodName;
        this.qualityScore = qualityScore;
    }

    void inspectFood() {
        System.out.println("\nFood Item: " + foodName);
        System.out.println("Quality Score: " + qualityScore);

        if (qualityScore >= 70) {
            System.out.println("Result: SAFE FOR CONSUMPTION");
        } else {
            System.out.println("Result: UNSAFE - REJECTED");
        }
    }
}

public class FoodInspectorSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Food Name: ");
        String foodName = sc.nextLine();

        System.out.print("Enter Quality Score (0-100): ");
        int qualityScore = sc.nextInt();

        FoodInspector inspector = new FoodInspector(foodName, qualityScore);
        inspector.inspectFood();

        sc.close();
    }
}