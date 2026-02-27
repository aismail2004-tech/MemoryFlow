import java.util.*;

public class Event {
    private String eventName;
    private List<MediaItem> mediaList;

    public Event(String eventName) {
        this.eventName = eventName;
        this.mediaList = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public List<MediaItem> getMediaList() {
        return mediaList;
    }

    public void addMedia(MediaItem item) {
        if (item == null) return;

        for (MediaItem m : mediaList) {
            if (m.getPath().equalsIgnoreCase(item.getPath())) {
                return;
            }
        }
        mediaList.add(item);
    }

    public boolean removeMediaByPath(String path) {
        for (int i = 0; i < mediaList.size(); i++) {
            if (mediaList.get(i).getPath().equalsIgnoreCase(path)) {
                mediaList.remove(i);
                return true;
            }
        }
        return false;
    }
}