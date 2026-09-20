import java.util.Scanner;

public class CuisineGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🍴 Welcome to Favourite Cuisine Guesser 🍴");
        System.out.println("Answer a few questions and we'll guess your favourite cuisine!\n");

        // Question 1: Spice preference
        System.out.println("1. Do you enjoy spicy food?");
        System.out.println("   a) Yes, the spicier the better!");
        System.out.println("   b) Mild spice is fine.");
        System.out.println("   c) Not really, I prefer less spice.");
        String spice = sc.nextLine().toLowerCase();

        // Question 2: Favorite dish type
        System.out.println("\n2. What type of dish do you enjoy most?");
        System.out.println("   a) Curry or gravy-based dishes");
        System.out.println("   b) Pasta or cheesy dishes");
        System.out.println("   c) Noodles or stir-fry");
        System.out.println("   d) Tacos, burritos, or wraps");
        String dish = sc.nextLine().toLowerCase();

        // Question 3: Cooking style
        System.out.println("\n3. Which cooking style attracts you?");
        System.out.println("   a) Rich and aromatic with lots of spices");
        System.out.println("   b) Simple, fresh, and full of herbs");
        System.out.println("   c) Quick stir-fry with sauces");
        System.out.println("   d) Bold flavors with beans, corn, and chili");
        String style = sc.nextLine().toLowerCase();

        // Cuisine suggestion logic
        System.out.println("\n✨ Based on your answers, we guess your favourite cuisine is: ✨");

        if(spice.contains("yes") || dish.contains("curry") || style.contains("aromatic")) {
            System.out.println("🍛 Indian Cuisine – full of spices, curries, and flavor!");
        } else if(dish.contains("pasta") || style.contains("herbs")) {
            System.out.println("🍝 Italian Cuisine – pasta, pizza, and cheesy delights!");
        } else if(dish.contains("noodles") || style.contains("stir-fry")) {
            System.out.println("🥡 Chinese Cuisine – noodles, dumplings, and stir-fry dishes!");
        } else if(dish.contains("tacos") || style.contains("beans")) {
            System.out.println("🌮 Mexican Cuisine – tacos, burritos, and bold flavors!");
        } else {
            System.out.println("🍽 A mix of world cuisines – you enjoy variety!");
        }

        System.out.println("\nThanks for playing! Explore your favourite cuisine today 🍴");
        sc.close();
    }
}
