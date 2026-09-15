package AccesoADatos.UD1.DAOEjemplo;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    public void main() throws Exception {
        BookDAO bookDAO = new BookDAO("Books.txt");
        boolean ok = true;
        
        while (ok) {
            IO.println("-------------------");
            IO.println("(C): create book");
            IO.println("(R): read book");
            IO.println("(U): update book");
            IO.println("(D): delete book");
            IO.println("-------------------\n");

            String opt = sc.nextLine();
            switch (opt) {
                case "C", "c":
                    IO.println("Introduce el nombre: ");
                    String name = sc.nextLine();
                    IO.println("Introduce el isbn: ");
                    String isbn = sc.nextLine();
                    Book book = new Book(isbn, name);

                    bookDAO.saveBook(book);
                    break;
                case "R", "r":

                    break;
                case "U", "u":

                    break;
                case "D", "d":

                    break;
                default:
                    ok = false;
                    break;
            }
        }
    }

}
