import java.util.List;
import java.util.Scanner;
import java.io.File;

import dao.BookDAO;
import dao.LocalBookDAO;
import model.Book;

public class Main {

    private static String rutaBooks() {
        String ruta = "Books.txt";
        if (!new File(ruta).exists()) {
            ruta = "MiPrimerDAO-20260922/Books.txt";
        }
        return ruta;
    }
    
    static Scanner SC = new Scanner(System.in);
    public void main() throws Exception {
        IO.println("¿Quieres trabajar en local (1) o en remoto (2)?");
        int work = Integer.parseInt(IO.readln());
        if (work == 1){
            local();
        }
        else{
            remoto();
        }
    }

    public static void local() throws Exception{
        LocalBookDAO dao = new LocalBookDAO(rutaBooks());
        boolean ok = true;

        while (ok) {
            IO.println("----------------");
            IO.println("(C)reate Book");
            IO.println("(R)ead Book");
            IO.println("(U)pdate Book");
            IO.println("(D)elete Book");
            IO.println("----------------");

            String opt = SC.nextLine();
            switch (opt) {
                case "C" , "c":
                    IO.println("Introduce el nombre : ");
                    String name = SC.nextLine();
                    IO.print("Introduce el isbn : ");
                    String isbn = SC.nextLine();
                    Book book = new Book(isbn, name);
                    dao.insertar(book);
                break;
                case "R", "r":
                    List<Book> books = dao.consultarTodos();
                    books.forEach((l) -> {IO.println(l);});
                    // for (Book book2 : books) {
                    //     IO.println(book2);
                    // }
                break;
                case "R2", "r2":
                    IO.println("Introduce el isbn: ");
                    String isbnBuscar = IO.readln();
                    Book bookBuscar = dao.consultarPorID(isbnBuscar);
                    if (bookBuscar == null){
                        IO.println("El libro no esta en la BBDD.");
                    }
                    else{
                        IO.println(bookBuscar);
                    }
                break;
                case "D", "d":
                    IO.println("Introduce el isbn: ");
                    String isbnBorrar = IO.readln();
                    dao.eliminar(isbnBorrar);
                break;
                default:
                    ok = false;
                break;
            }
        }
        dao.guardarDatos();
    }

    public static void remoto() throws Exception{
        BookDAO dao = new BookDAO(rutaBooks());
        boolean ok = true;

        while (ok) {
            IO.println("----------------");
            IO.println("(C)reate Book");
            IO.println("(R)ead Book");
            IO.println("(U)pdate Book");
            IO.println("(D)elete Book");
            IO.println("----------------");

            String opt = SC.nextLine();
            switch (opt) {
                case "C" , "c":
                    IO.println("Introduce el nombre : ");
                    String name = SC.nextLine();
                    IO.print("Introduce el isbn : ");
                    String isbn = SC.nextLine();
                    Book book = new Book(isbn, name);
                    dao.insertar(book);
                break;
                case "R", "r":
                    List<Book> books = dao.consultarTodos();
                    books.forEach((l) -> {IO.println(l);});
                    // for (Book book2 : books) {
                    //     IO.println(book2);
                    // }
                break;
                case "R2", "r2":
                    IO.println("Introduce el isbn: ");
                    String isbnBuscar = IO.readln();
                    Book bookBuscar = dao.consultarPorID(isbnBuscar);
                    if (bookBuscar == null){
                        IO.println("El libro no esta en la BBDD.");
                    }
                    else{
                        IO.println(bookBuscar);
                    }
                break;
                case "D", "d":
                    IO.println("Introduce el isbn: ");
                    String isbnBorrar = IO.readln();
                    dao.eliminar(isbnBorrar);
                break;
                default:
                    ok = false;
                break;
            }
        }
    }

}
