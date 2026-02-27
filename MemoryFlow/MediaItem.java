import java.text.SimpleDateFormat;
import java.util.*;

public class MediaItem {
    private String name;
    private String path;
    private String type;      // Image / Video / Audio
    private long dateMillis;  // last modified time

    public MediaItem(String name, String path, String type, long dateMillis) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.dateMillis = dateMillis;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public long getDateMillis() {
        return dateMillis;
    }

    public String getInfo() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "Name: " + name +
               "\nType: " + type +
               "\nDate: " + df.format(new Date(dateMillis)) +
               "\nPath: " + path;
    }
}