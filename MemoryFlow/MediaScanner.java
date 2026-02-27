import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class MediaScanner {

    private static final String[] IMG_EXT = {"jpg", "jpeg", "png", "bmp"};
    private static final String[] AUD_EXT = {"mp3", "wav"};
    private static final String[] VID_EXT = {"mp4", "mkv", "avi"};

    public List<MediaItem> scanFolder(String folderPath) {
        List<MediaItem> result = new ArrayList<>();

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder not found or not a directory: " + folderPath);
            return result;
        }

        File[] files = folder.listFiles();
        if (files == null) return result;

        for (File f : files) {
            if (f.isFile()) {
                String type = detectType(f.getName());
                if (!type.equals("OTHER")) {
                    result.add(buildItem(f, type));
                }
            }
        }

        return result;
    }

    private MediaItem buildItem(File f, String type) {
        long dateMillis = 0;
        try {
            dateMillis = Files.getLastModifiedTime(f.toPath()).toMillis();
        } catch (Exception ex) {
            dateMillis = System.currentTimeMillis();
        }
        return new MediaItem(f.getName(), f.getAbsolutePath(), type, dateMillis);
    }

    private String detectType(String fileName) {
        String ext = getExtension(fileName);
        if (ext == null) return "OTHER";

        if (in(ext, IMG_EXT)) return "IMAGE";
        if (in(ext, AUD_EXT)) return "AUDIO";
        if (in(ext, VID_EXT)) return "VIDEO";
        return "OTHER";
    }

    private String getExtension(String name) {
        int dot = name.lastIndexOf('.');
        if (dot == -1 || dot == name.length() - 1) return null;
        return name.substring(dot + 1).toLowerCase();
    }

    private boolean in(String ext, String[] arr) {
        for (String a : arr) {
            if (a.equalsIgnoreCase(ext)) return true;
        }
        return false;
    }
}