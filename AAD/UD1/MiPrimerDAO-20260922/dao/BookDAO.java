package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {

    public String ruta;

    public BookDAO(String ruta){
        this.ruta = ruta;
    }
    /*
    Create - INSERT book INTO Books
    Update - UPDATE book INTRO Books
    */
    public void insertar(Book book) throws Exception{
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(book.getIsbn() + ";" + book.getName() + "\n");
        bw.close();
        fw.close();
    }

    /* 
    Read - SELECT * FROM BOOKS
    Read - SELECT * FROM BOOKS where isbn = {isbn}
    */
    public List<Book> consultarTodos() throws Exception{
        List<Book> books = new ArrayList<>();
        File f = new File(this.ruta);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine())!= null) {
            Book book = new Book(
                linea.split(";")[0],
                linea.split(";")[1]
            );
            books.add(book);
        }
        br.close();
        fr.close();
        return books;
    }

    public Book consultarPorID(String isbn) throws Exception{
        File f = new File(this.ruta);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine())!= null) {
            if (isbn.equals(linea.split(";")[0])){
                Book book = new Book(
                    linea.split(";")[0],
                    linea.split(";")[1]
                );
                return book;
            }
        }
        br.close();
        fr.close();
        return null;
    }

    // Delete
    public void eliminar(String isbn) throws Exception{
        List<Book> books = consultarTodos();
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Book book : books){
            if (!book.getIsbn().equals(isbn)){
                bw.write(book.getIsbn() + ";" + book.getName() + "\n");
            }
        }
        // books.forEach((book)->{
        //     if (!book.getIsbn().equals(isbn)){
        //         try {
        //             bw.write(book.getIsbn() + ";" + book.getName() + "\n");
        //         } catch (IOException e) {IO.print(e);}
        //     }
        // });
        bw.close();
        fw.close();
    }

}
