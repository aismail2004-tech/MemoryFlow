import java.util.*;

public class Main {
    public static void main(String[] args) {

        //add any folder from your pc that have images, audios or videos. 
        String folderPath = "C:\\Users\\pc\\Desktop\\MediaTest";

        Library library = new Library();
        MediaScanner scanner = new MediaScanner();

        List<MediaItem> scanned = scanner.scanFolder(folderPath);
        for (MediaItem item : scanned) {
            library.addMedia(item);
        }

        library.sortByDate();

        System.out.println("==================================");
        System.out.println("MemoryFlow - Scan Result");
        System.out.println("Total Media Found: " + library.getMediaItems().size());
        System.out.println("==================================");

        int limit = Math.min(10, library.getMediaItems().size());
        for (int i = 0; i < limit; i++) {
            System.out.println("\n--- Item " + (i + 1) + " ---");
            System.out.println(library.getMediaItems().get(i).getInfo());
        }

        Event tripEvent = new Event("University Trip");

        if (library.getMediaItems().size() > 0) tripEvent.addMedia(library.getMediaItems().get(0));
        if (library.getMediaItems().size() > 1) tripEvent.addMedia(library.getMediaItems().get(1));

        System.out.println("\n==================================");
        System.out.println("Event: " + tripEvent.getEventName());
        System.out.println("Media inside event: " + tripEvent.getMediaList().size());
        System.out.println("==================================");
        for (MediaItem m : tripEvent.getMediaList()) {
            System.out.println("- " + m.getName() + " (" + m.getType() + ")");
        }

        System.out.println("\n==================================");
        System.out.println("Search Demo (keyword = 'mp4')");
        System.out.println("==================================");
        List<MediaItem> searchRes = library.searchMedia("mp4");
        System.out.println("Found: " + searchRes.size());
    }
}