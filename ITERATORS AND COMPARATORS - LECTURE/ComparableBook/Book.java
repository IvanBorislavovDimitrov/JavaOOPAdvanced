import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTitle()).append(" -> ");
        sb.append(this.getYear());
        this.authors.forEach(a -> sb.append(System.lineSeparator()).append(a));

        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        if (this.getTitle().compareTo(o.getTitle()) == 0) {
            return Integer.compare(this.getYear(), o.getYear());
        }

        return this.getTitle().compareTo(o.getTitle());
    }
}
