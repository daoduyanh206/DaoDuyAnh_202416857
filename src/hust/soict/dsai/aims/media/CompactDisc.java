package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        // Khởi tạo thời lượng ban đầu của CD là 0, sau đó tính dựa trên track
        super(id, title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    // Thêm track bài hát (kiểm tra trùng lặp)
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' has been added to CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' already exists in CD.");
        }
    }

    // Xóa track bài hát
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' has been removed from CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' does not exist in CD.");
        }
    }

    // Ghi đè phương thức getLength() để tính tổng thời lượng từ danh sách track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Thêm phương thức play() vào cuối file CompactDisc.java
    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("The CD '" + this.getTitle() + "' cannot be played because it has no valid tracks or total length is 0.");
        } else {
            System.out.println("=== PLAYING CD: " + this.getTitle() + " (Artist: " + this.getArtist() + ") ===");
            System.out.println("Total CD length: " + this.getLength() + " min");
            System.out.println("----------------------------------------");
            // Vòng lặp phát từng track nhạc bên trong CD
            for (Track track : tracks) {
                track.play();
            }
            System.out.println("========================================");
        }
    }

    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " 
            + this.getDirector() + " - Artist: " + this.getArtist() + " - Length: " 
            + this.getLength() + " min: " + this.getCost() + " $";
    }
}