package AAD.UD1.DAOEjemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public String ruta;

    BookDAO(String ruta) {
        this.ruta = ruta;
    }

    // CREATE - INSERT book INTO Books
    // UPDATE - UPDATE book INTO Books
    public void saveBook(Book book) throws Exception {
        File f = new File("Books.txt");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n" + book.getIsbn() + ";" + book.getName());
        bw.close();
        fw.close();
    };

    // READ - SELECT * FROM Books
    public List<Book> getAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        File f = new File(this.ruta);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            Book book = new Book(
                    linea.split(";")[0],
                    linea.split(";")[1]);
            books.add(book);
        }
        br.close();
        fr.close();
        return books;
    };

    // READ - SELECT * FROM Books where isbn = {isbn}
    public Book getBookByIsbn(String isbn) throws Exception {
        File f = new File(this.ruta);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";", 2);
            if (datos.length == 2 && isbn.equals(datos[0])) {
                Book book = new Book(datos[0], datos[1]);
                br.close();
                fr.close();
                return book;
            }
        }
        br.close();
        fr.close();
        return null;
    };
    // UPDATE
    public Book updateBookByIsbn(String isbn) throws Exception {
        List<Book> books = getAllBooks();
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        Book updatedBook = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                updatedBook = book;
            } else {
                bw.write(book.getIsbn() + ";" + book.getName() + "\n");
            }
        }
        bw.close();
        fw.close();
        return updatedBook;
    }

    // DELETE
    public void deleteBook(String isbn) throws Exception {
        List<Book> books = getAllBooks();
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Book book : books) {
            if (!book.getIsbn().equals(isbn)) {
                bw.write(book.getIsbn() + ";" + book.getName() + "\n");
            }
        }
        /*
         * books.forEach((book)->{
         * if (!book.getIsbn().equals(isbn)) {
         * try {
         * bw.write(book.getIsbn() + ";" + book.getName() + "\n");
         * } catch (IOException e) {IO.print(e);}
         * }
         * });
         */
        bw.close();
        fw.close();

    };

}
