
public class book {
    private String title;
    private String author;
    private String isbn;
    private String type;
    private boolean isAvailable;

    public book (String title, String author, String isbn, String type) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    public void borrow() {
        isAvailable = false;
    }

    public void displayInfo() {
        System.out.println("العنوان: " + title);
        System.out.println("المؤلف: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("النوع: " + type);
        System.out.println("الحالة: " + (isAvailable ? "متاح" : "معار"));
    }
}
