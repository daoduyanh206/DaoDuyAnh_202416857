package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("The track '" + this.getTitle() + "' cannot be played because its length is 0 or negative.");
        } else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength() + " min");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        Track other = (Track) obj;
        if (this.title == null) {
            if (other.title != null) return false;
        } else if (!this.title.equalsIgnoreCase(other.title)) {
            return false; // Tiêu đề khác nhau 
        }
        return this.length == other.length; // Thời lượng phải bằng nhau 
    }
}