import java.util.*;

class Email {
    String sender;
    String subject;
    String body;
    boolean isSpam;

    Email(String sender, String subject, String body) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
        this.isSpam = false;
    }

    void checkSpam() {
        // Simple spam rules: contains "win", "lottery", "free", "money"
        String content = (subject + " " + body).toLowerCase();
        if (content.contains("win") || content.contains("lottery") ||
            content.contains("free") || content.contains("money")) {
            isSpam = true;
        }
    }
}

public class SpamFilter {
    public static void main(String[] args) {
        List<Email> inbox = new ArrayList<>();

        // Sample emails
        inbox.add(new Email("friend@example.com", "Hello!", "Let's meet tomorrow."));
        inbox.add(new Email("spam@lottery.com", "You WIN!", "Claim your free money now."));
        inbox.add(new Email("work@example.com", "Meeting Reminder", "Project discussion at 3 PM."));
        inbox.add(new Email("offer@spam.com", "Free Gift", "Click here to get free stuff."));

        // Detect spam
        for (Email email : inbox) {
            email.checkSpam();
        }

        // Delete spam emails
        Iterator<Email> iterator = inbox.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (email.isSpam) {
                System.out.println("Deleting spam email: " + email.subject);
                iterator.remove();
            }
        }

        // Show remaining inbox
        System.out.println("\nInbox after spam deletion:");
        for (Email email : inbox) {
            System.out.println("From: " + email.sender + " | Subject: " + email.subject);
        }
    }
}
