package dao;

import java.util.List;

import model.Book;

public interface InterfazBookDAO {

    public void insertar(Book book);
    public List<Book> consultarTodos();
    public Book consultarPorID(String isbn);
    public void eliminar(String isbn);
    
}
