package AAD.UD1.DAOEjemplo;

import java.util.List;
import java.util.Scanner;

import AAD.UD1.DAOEjemplo.dao.BookDAO;
import dao.bookDAO;
import model.Book;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        IO.println("¿Local (1) o remoto (2)?: ");
        int work = Integer.parseInt(IO.readln());
        if (work == 1) {
            local();
        } else {
            remoto();
        }

    }

    public static void local() {
        LocalBookDAO LocalBookDAO = new LocalBookDAO("Books.txt");

        while (ok) {
            IO.println("\n-------------------");
            IO.println("(C)reate book");
            IO.println("(R)ead book");
            IO.println("(U)pdate book");
            IO.println("(D)elete book");
            IO.println("-------------------\n");

            String opt = sc.nextLine();
            switch (opt) {
                case "C", "c":
                    IO.println("Introduce el nombre: ");
                    String name = sc.nextLine();
                    IO.print("Introduce el isbn: ");
                    String isbn = sc.nextLine();
                    Book book = new Book(isbn, name);
                    bookDAO.saveBook(book);
                    break;
                case "R", "r":
                    List<Book> books = bookDAO.getAllBooks();
                    books.forEach((l) -> {
                        System.out.println(l);
                    });
                    /*
                     * for (Book book2 : books) {
                     * System.out.println(book2);
                     * }
                     */
                    break;
                case "R2", "r2":
                    IO.println("Introduce el isbn:");
                    String isbnBuscar = IO.readln();
                    Book bookBuscar = bookDAO.getBookByIsbn(isbnBuscar);
                    if (bookBuscar == null) {
                        IO.println("El libro no está en la BDD.");
                    } else {
                        IO.println(bookBuscar);
                    }
                    break;
                /*
                 * case "U", "u":
                 * IO.println("Introduce el isbn del libro que quieres modificar: ");
                 * String isbnUpdate = IO.readln();
                 * IO.println("Introduce el nuevo nombre: ");
                 * String newName = IO.readln();
                 * Book bookUpdate = bookDAO.getBookByIsbn(isbnUpdate);
                 * if (bookUpdate == null) {
                 * IO.println("El libro no está en la BDD.");
                 * } else {
                 * bookUpdate.setName(newName);
                 * bookDAO.updateBookByIsbn(isbnUpdate);
                 * }
                 * break;
                 */
                case "D", "d":
                    IO.println("Introduce el isbn:");
                    String isbnBorrar = IO.readln();
                    bookDAO.deleteBook(isbnBorrar);
                    break;
                default:
                    ok = false;
                    break;
            }
        }

    }

    public static void remoto() {
        BookDAO bookDAO = new BookDAO("Books.txt");
        boolean ok = true;
        while (ok) {
            IO.println("\n-------------------");
            IO.println("(C)reate book");
            IO.println("(R)ead book");
            IO.println("(U)pdate book");
            IO.println("(D)elete book");
            IO.println("-------------------\n");

            String opt = sc.nextLine();
            switch (opt) {
                case "C", "c":
                    IO.println("Introduce el nombre: ");
                    String name = sc.nextLine();
                    IO.print("Introduce el isbn: ");
                    String isbn = sc.nextLine();
                    Book book = new Book(isbn, name);
                    bookDAO.saveBook(book);
                    break;
                case "R", "r":
                    List<Book> books = bookDAO.getAllBooks();
                    books.forEach((l) -> {
                        System.out.println(l);
                    });
                    /*
                     * for (Book book2 : books) {
                     * System.out.println(book2);
                     * }
                     */
                    break;
                case "R2", "r2":
                    IO.println("Introduce el isbn:");
                    String isbnBuscar = IO.readln();
                    Book bookBuscar = bookDAO.getBookByIsbn(isbnBuscar);
                    if (bookBuscar == null) {
                        IO.println("El libro no está en la BDD.");
                    } else {
                        IO.println(bookBuscar);
                    }
                    break;
                /*
                 * case "U", "u":
                 * IO.println("Introduce el isbn del libro que quieres modificar: ");
                 * String isbnUpdate = IO.readln();
                 * IO.println("Introduce el nuevo nombre: ");
                 * String newName = IO.readln();
                 * Book bookUpdate = bookDAO.getBookByIsbn(isbnUpdate);
                 * if (bookUpdate == null) {
                 * IO.println("El libro no está en la BDD.");
                 * } else {
                 * bookUpdate.setName(newName);
                 * bookDAO.updateBookByIsbn(isbnUpdate);
                 * }
                 * break;
                 */
                case "D", "d":
                    IO.println("Introduce el isbn:");
                    String isbnBorrar = IO.readln();
                    bookDAO.deleteBook(isbnBorrar);
                    break;
                default:
                    ok = false;
                    break;
            }
        }

    }
}
