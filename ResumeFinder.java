import java.util.*;

class Candidate {
    String name;
    String skills;

    Candidate(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }
}

public class ResumeFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Candidate> resumes = new ArrayList<>();

        resumes.add(new Candidate("Rahul", "Java Python SQL"));
        resumes.add(new Candidate("Priya", "JavaScript React NodeJS"));
        resumes.add(new Candidate("Amit", "Java Spring MySQL"));

        System.out.print("Enter skill to search: ");
        String skill = sc.nextLine().toLowerCase();

        boolean found = false;

        System.out.println("\nMatching Candidates:");
        for (Candidate c : resumes) {
            if (c.skills.toLowerCase().contains(skill)) {
                System.out.println("Name: " + c.name);
                System.out.println("Skills: " + c.skills);
                System.out.println("-------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching resume found.");
        }

        sc.close();
    }
}