import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.FileInputStream;
import java.util.List;

public class GoogleFormChecker {

    public static void main(String[] args) throws Exception {
        // Replace with your Google Sheet ID (linked to the Form responses)
        String spreadsheetId = "YOUR_SHEET_ID_HERE";
        // Replace with the range of responses (usually "Form Responses 1!A:Z")
        String range = "Form Responses 1!A:Z";

        // Load credentials (download JSON from Google Cloud Console)
        GoogleCredential credential = GoogleCredential.fromStream(
                new FileInputStream("credentials.json"))
                .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets.readonly"));

        Sheets service = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                credential)
                .setApplicationName("Google Form Checker")
                .build();

        // Fetch responses
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No responses found.");
        } else {
            // Example: check if a user with email "test@example.com" filled the form
            String userEmail = "test@example.com";
            boolean filled = values.stream()
                    .anyMatch(row -> row.contains(userEmail));

            if (filled) {
                System.out.println("✅ User has filled the form.");
            } else {
                System.out.println("❌ User has NOT filled the form.");
            }
        }
    }
}
