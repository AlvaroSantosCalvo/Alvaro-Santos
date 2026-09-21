import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import AAD.UD1.DAOEjemplo.dao.BookDAO;
import AAD.UD1.DAOEjemplo.model.Book;

public class LocalBookDAO {
    String ruta;
    List<Book> libros;

    public LocalBookDAO(String ruta) throws Exception {
        this.ruta = ruta;
        libros = cargarDatos();
    }

    public List<Book> cargarDatos() throws Exception {
        /*
         * BookDAO bookDAO = new BookDAO(ruta);
         * return bookDAO.getAllBooks();
         */
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
    }

    public void guardarDatos() throws Exception {
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Book libro : this.libros) {
            bw.write(libro.getIsbn() + ";" + libro.getName() + "\n");
        }
    }

    public void saveBook(Book libro) {
        this.libros.add(libro);
    }

    public void updateBook(String isbn, String nuevoNombre) {
        for (Book libro : this.libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setName(nuevoNombre);
                break;
            }
        }
    }

    public List<Book> getAllBooks() {
        return this.libros;
    }

    public Book getBookByIsbn(String isbn) {
        for (Book libro : this.libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void deleteBook(String isbn) {
        Book libro = getBookByIsbn(isbn);
        if (!libro) {
            this.libros.remove(libro);
        }
    }
}
