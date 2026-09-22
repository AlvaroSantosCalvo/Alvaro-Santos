
import java.util.List;

import model.Book;

public class InterfazDAO {
    
    public interface InterfazBookDAO {
    
        public void saveBook(Book book);
        public List<Book> getAllBooks();
        public Book getBookByIsbn(String isbn);
        public void deleteBook(String isbn);
        
    }
}
