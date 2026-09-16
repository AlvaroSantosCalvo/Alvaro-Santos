package AAD.UD1.DAOEjemplo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class BookDAO {

    public String ruta;
    BookDAO(String ruta){
        this.ruta = ruta;
    }

    // CREATE - INSERT book INTO Books
    // UPDATE - UPDATE book INTO Books
    public void saveBook(Book book) throws Exception{
        File f = new File("Books.txt");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n" + book.getIsbn() + ";" + book.getName());
        bw.close();
        fw.close();
    };

    // READ - SELECT * FROM Books
    // READ - SELECT * FROM Books where isbn = {isbn}
    public List<Book> getAllBooks() {
        return null;
    };

    public Book getBookByIsbn(String isbn) {
        return null;
    };

    // DELETE
    public void deleteBook(String isbn) {

    };

}
