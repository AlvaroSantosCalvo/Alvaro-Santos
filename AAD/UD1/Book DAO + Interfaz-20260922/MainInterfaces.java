import java.util.List;
import java.util.Scanner;

import dao.BookDAO;
import dao.InterfazBookDAO;
import dao.LocalBookDAO;
import model.Book;

public class MainInterfaces {
    
    static Scanner SC = new Scanner(System.in);
    public void main() throws Exception {
        IO.println("¿Quieres trabajar en local (1) o en remoto (2)?");
        int work = Integer.parseInt(IO.readln());
        InterfazBookDAO dao;
        String ruta = "Books.txt";
        if (work == 1){
            dao = new LocalBookDAO(ruta);
        }
        else{
            dao = new BookDAO(ruta);
        }
        libreria(dao);
    }

    public static void libreria(InterfazBookDAO dao) {
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
