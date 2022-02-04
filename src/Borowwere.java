import java.util.ArrayList;
public class Borowwere {
    private String name;
    private ArrayList<String> books;


    public Borowwere(String name, ArrayList<String> books) {
        this.name = name;
        this.books = books;

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



    @Override
    public String toString() {
        return "Borowwere{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
