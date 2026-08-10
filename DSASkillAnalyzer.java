import java.util.*;

public class DSASkillAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define topics
        String[] topics = {"Arrays", "Linked Lists", "Stacks & Queues", "Trees", "Graphs", "Sorting & Searching"};
        int[] scores = new int[topics.length];

        System.out.println("=== DSA Skill Analyzer ===");
        System.out.println("Rate your confidence in each topic (0 = very weak, 10 = very strong):");

        // Collect self-assessment scores
        for (int i = 0; i < topics.length; i++) {
            System.out.print(topics[i] + ": ");
            scores[i] = sc.nextInt();
        }

        // Find weakest topic
        int minIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("\nYour weakest area is: " + topics[minIndex]);
        System.out.println("You should focus more on " + topics[minIndex] + " to improve your DSA skills.");

        // Suggestion based on weakness
        switch (topics[minIndex]) {
            case "Arrays":
                System.out.println("👉 Practice problems on sliding window, prefix sums, and two-pointer techniques.");
                break;
            case "Linked Lists":
                System.out.println("👉 Revise insertion, deletion, and cycle detection problems.");
                break;
            case "Stacks & Queues":
                System.out.println("👉 Work on problems like balanced parentheses, next greater element, and queue simulation.");
                break;
            case "Trees":
                System.out.println("👉 Focus on traversals (DFS, BFS), recursion, and binary search trees.");
                break;
            case "Graphs":
                System.out.println("👉 Study BFS, DFS, shortest path algorithms (Dijkstra, Bellman-Ford).");
                break;
            case "Sorting & Searching":
                System.out.println("👉 Revise quicksort, mergesort, and binary search variations.");
                break;
        }

        sc.close();
    }
}
