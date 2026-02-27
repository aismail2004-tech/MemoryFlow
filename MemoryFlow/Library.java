import java.util.*;

public class Library {
    private List<MediaItem> mediaItems;

    public Library() {
        mediaItems = new ArrayList<>();
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void addMedia(MediaItem item) {
        if (item == null) return;

        for (MediaItem m : mediaItems) {
            if (m.getPath().equalsIgnoreCase(item.getPath())) {
                return;
            }
        }
        mediaItems.add(item);
    }

    public List<MediaItem> searchMedia(String keyword) {
        List<MediaItem> result = new ArrayList<>();
        if (keyword == null) keyword = "";
        String k = keyword.toLowerCase();

        for (MediaItem m : mediaItems) {
            if (m.getName().toLowerCase().contains(k) ||
                m.getType().toLowerCase().contains(k)) {
                result.add(m);
            }
        }
        return result;
    }

    public void sortByDate() {
        Collections.sort(mediaItems, new Comparator<MediaItem>() {
            @Override
            public int compare(MediaItem a, MediaItem b) {
                return Long.compare(b.getDateMillis(), a.getDateMillis());
            }
        });
    }
}