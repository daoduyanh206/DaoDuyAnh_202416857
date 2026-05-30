package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track '" + this.getTitle() + "' length is " + this.getLength() + ", cannot be played!");
        }
        System.out.println("Playing track: " + this.getTitle() + " (Length: " + this.getLength() + ")");
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