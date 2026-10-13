public class CivicIssue {
    String id, type, location, description;
    int priority;

    CivicIssue(String id, String type, String location, String description, int priority) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Issue ID: " + id + "\nType: " + type + "\nLocation: " + location +
               "\nDescription: " + description + "\nPriority: " + priority;
    }
}

public class CivicSystem {
    public static void main(String[] args) {
        List<CivicIssue> issues = new ArrayList<>();
        issues.add(new CivicIssue("ISS001", "Pothole", "Main Road", "Large pothole near school", 5));
        issues.add(new CivicIssue("ISS002", "Garbage", "Sector 12", "Overflowing garbage bins", 3));

        System.out.println("Civic Issues Report:");
        for (CivicIssue issue : issues) {
            System.out.println(issue);
            System.out.println("-------------------");
        }
    }
}
