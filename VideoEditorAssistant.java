import java.util.*;

class VideoClip {
    String clipName;
    int duration; // in seconds

    VideoClip(String clipName, int duration) {
        this.clipName = clipName;
        this.duration = duration;
    }
}

public class VideoEditorAssistant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<VideoClip> clips = new ArrayList<>();

        System.out.print("Enter number of video clips: ");
        int n = sc.nextInt();
        sc.nextLine();

        int totalDuration = 0;
        VideoClip longestClip = null;

        for (int i = 0; i < n; i++) {
            System.out.println("\nClip " + (i + 1));

            System.out.print("Enter clip name: ");
            String name = sc.nextLine();

            System.out.print("Enter duration (seconds): ");
            int duration = sc.nextInt();
            sc.nextLine();

            VideoClip clip = new VideoClip(name, duration);
            clips.add(clip);

            totalDuration += duration;

            if (longestClip == null || duration > longestClip.duration) {
                longestClip = clip;
            }
        }

        System.out.println("\n===== VIDEO EDITING REPORT =====");

        for (VideoClip clip : clips) {
            System.out.println("Clip: " + clip.clipName +
                               " | Duration: " + clip.duration + " sec");
        }

        System.out.println("\nTotal Video Duration: " + totalDuration + " sec");

        if (longestClip != null) {
            System.out.println("Recommended Highlight Clip: "
                    + longestClip.clipName
                    + " (" + longestClip.duration + " sec)");
        }

        System.out.println("Editing Status: Ready for Export");
    }
}