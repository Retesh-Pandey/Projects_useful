import java.util.*;

class ResearchPaper {
    String title;
    String domain;

    ResearchPaper(String title, String domain) {
        this.title = title;
        this.domain = domain.toLowerCase();
    }
}

public class ResearchPaperRecommender {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<ResearchPaper> papers = new ArrayList<>();

        papers.add(new ResearchPaper(
                "Deep Learning for Medical Diagnosis",
                "artificial intelligence"));

        papers.add(new ResearchPaper(
                "Blockchain in Supply Chain",
                "blockchain"));

        papers.add(new ResearchPaper(
                "Cybersecurity Threat Detection",
                "cybersecurity"));

        papers.add(new ResearchPaper(
                "Machine Learning for Agriculture",
                "artificial intelligence"));

        papers.add(new ResearchPaper(
                "Cloud Computing Security Models",
                "cloud computing"));

        System.out.print("Enter your research interest: ");
        String interest = sc.nextLine().toLowerCase();

        boolean found = false;

        System.out.println("\nRecommended Papers:\n");

        for (ResearchPaper paper : papers) {
            if (paper.domain.contains(interest)) {
                System.out.println("Title: " + paper.title);
                System.out.println("Domain: " + paper.domain);
                System.out.println("------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching papers found.");
        }

        sc.close();
    }
}