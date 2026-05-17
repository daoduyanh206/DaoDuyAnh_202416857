package hust.soict.dsai.aims.media; 
import java.util.Comparator;
public abstract class Media { 
    private int id; 
    private String title; 
    private String category; 
    private float cost; 

    // 1. Bộ so sánh: Ưu tiên Title (tăng dần Alphabet), nếu trùng thì so sánh Cost (giảm dần)
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
            if (titleDiff != 0) {
                return titleDiff; // Sắp xếp theo tên tăng dần
            }
            // Nếu trùng tên, giá cao hơn xếp trước (giảm dần)
            return Float.compare(m2.getCost(), m1.getCost());
        }
    };

    // 2. Bộ so sánh: Ưu tiên Cost (giảm dần), nếu trùng thì so sánh Title (tăng dần Alphabet)
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int costDiff = Float.compare(m2.getCost(), m1.getCost()); // Giá giảm dần
            if (costDiff != 0) {
                return costDiff;
            }
            // Nếu trùng giá, tên xếp theo Alphabet tăng dần
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        }
    };

    public Media() { 
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false; // Tránh lỗi ép sai kiểu 
        Media other = (Media) obj; // Ép kiểu về Media 
        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equalsIgnoreCase(other.title); // So sánh không phân biệt hoa thường 
    }
}