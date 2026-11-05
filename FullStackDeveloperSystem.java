import java.util.*;

class Project {
    String name;
    String technology;

    Project(String name, String technology) {
        this.name = name;
        this.technology = technology;
    }

    void display() {
        System.out.println("Project: " + name + " | Tech: " + technology);
    }
}

class Developer {
    String name;
    int experience;
    List<String> skills = new ArrayList<>();
    List<Project> projects = new ArrayList<>();

    Developer(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    void addSkill(String skill) {
        skills.add(skill);
    }

    void addProject(Project project) {
        projects.add(project);
    }

    void displayProfile() {
        System.out.println("\nDeveloper: " + name);
        System.out.println("Experience: " + experience + " years");

        System.out.println("Skills:");
        for (String skill : skills)
            System.out.println("- " + skill);

        System.out.println("Projects:");
        for (Project p : projects)
            p.display();
    }
}

public class FullStackDeveloperSystem {
    public static void main(String[] args) {

        Developer dev = new Developer("Retesh", 3);

        dev.addSkill("Java");
        dev.addSkill("Spring Boot");
        dev.addSkill("React");
        dev.addSkill("MySQL");
        dev.addSkill("REST API");

        dev.addProject(new Project(
                "E-Commerce Platform",
                "Java, Spring Boot, React, MySQL"));

        dev.addProject(new Project(
                "Employee Management System",
                "Spring Boot, React, PostgreSQL"));

        dev.displayProfile();
    }
}