import java.util.ArrayList;
public class Borowwere {
    private String name;
    private ArrayList<String> books;
    private String bookname;

    public Borowwere(String name, ArrayList<String> books, String bookname) {
        this.name = name;
        this.books = books;
        this.bookname = bookname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void addBooks(String bookname) {
        books.add(bookname);
    }
}
