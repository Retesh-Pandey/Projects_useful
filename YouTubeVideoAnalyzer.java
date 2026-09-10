import java.util.Scanner;

public class YouTubeVideoAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== YouTube Video Analyzer ===");

        // Input video details
        System.out.print("Enter video title: ");
        String title = sc.nextLine();

        System.out.print("Enter total views: ");
        int views = sc.nextInt();

        System.out.print("Enter total likes: ");
        int likes = sc.nextInt();

        System.out.print("Enter total comments: ");
        int comments = sc.nextInt();

        System.out.print("Enter total watch time (in minutes): ");
        double watchTime = sc.nextDouble();

        // Calculations
        double engagementRate = ((double)(likes + comments) / views) * 100;
        double avgWatchTimePerView = watchTime / views;
        double performanceScore = (engagementRate * 0.6) + (avgWatchTimePerView * 0.4);

        // Output analysis
        System.out.println("\n--- Analysis Report ---");
        System.out.println("Video Title: " + title);
        System.out.println("Total Views: " + views);
        System.out.println("Total Likes: " + likes);
        System.out.println("Total Comments: " + comments);
        System.out.println("Total Watch Time: " + watchTime + " minutes");
        System.out.printf("Engagement Rate: %.2f%%\n", engagementRate);
        System.out.printf("Average Watch Time per View: %.2f minutes\n", avgWatchTimePerView);
        System.out.printf("Performance Score: %.2f\n", performanceScore);

        // Simple suggestion
        if (engagementRate < 5) {
            System.out.println("Suggestion: Try improving thumbnails or titles to boost engagement.");
        } else {
            System.out.println("Great job! Your audience is engaging well.");
        }

        sc.close();
    }
}
