// File: CodeReviewer.java
// How to run: 
// 1. Save this file as CodeReviewer.java
// 2. Compile: javac CodeReviewer.java
// 3. Run: java CodeReviewer

import java.util.*;
import java.util.regex.*;

public class CodeReviewer {

    // List of simple style rules
    private static final String[] BAD_PATTERNS = {
        "System\\.out\\.print",   // discourage raw prints
        "== true",                // redundant comparison
        "== false",               // redundant comparison
        "public static void main",// check for entry point
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("        AI-Powered Code Reviewer v1.0   ");
        System.out.println("========================================");
        System.out.println("Paste your Java code below (end with 'END'):");

        // Collect code input
        StringBuilder code = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            code.append(line).append("\n");
        }

        // Analyze code
        analyzeCode(code.toString());

        sc.close();
    }

    private static void analyzeCode(String code) {
        System.out.println("\n--- Review Report ---");

        // Rule 1: Check for bad patterns
        for (String pattern : BAD_PATTERNS) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(code);
            if (m.find()) {
                System.out.println("⚠ Warning: Found usage of '" + pattern + "'");
            }
        }

        // Rule 2: Check for long methods
        String[] lines = code.split("\n");
        int methodLines = 0;
        boolean inMethod = false;
        for (String line : lines) {
            if (line.contains("{")) {
                inMethod = true;
                methodLines = 0;
            }
            if (inMethod) methodLines++;
            if (line.contains("}")) {
                if (methodLines > 30) {
                    System.out.println("⚠ Warning: Method longer than 30 lines detected.");
                }
                inMethod = false;
            }
        }

        // Rule 3: Check for comments
        if (!code.contains("//")) {
            System.out.println("⚠ Suggestion: Add comments for better readability.");
        }

        // Rule 4: Check for indentation (basic)
        for (String line : lines) {
            if (line.startsWith("    ") == false && line.trim().length() > 0) {
                System.out.println("⚠ Suggestion: Check indentation on line -> " + line.trim());
                break;
            }
        }

        System.out.println("\n✅ Review Complete. Keep improving your code style!");
    }
}
