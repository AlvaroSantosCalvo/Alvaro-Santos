package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO implements InterfazBookDAO {

    public String ruta;

    public BookDAO(String ruta){
        this.ruta = ruta;
    }
    /*
    Create - INSERT book INTO Books
    Update - UPDATE book INTRO Books
    */
    public void insertar(Book book){
        File f = new File(this.ruta);
        try (
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw); 
        ) {
           bw.write(book.getIsbn() + ";" + book.getName() + "\n");
        } 
        catch (IOException e) {
           IO.print("Error leyendo el fichero, archivo corrupto.");
        }
    }

    /* 
    Read - SELECT * FROM BOOKS
    Read - SELECT * FROM BOOKS where isbn = {isbn}
    */
    public List<Book> consultarTodos() {
        List<Book> books = new ArrayList<>();
        File f = new File(this.ruta);
        try (
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
        ) {
            String linea;
            while ((linea = br.readLine())!= null) {
                Book book = new Book(
                    linea.split(";")[0],
                    linea.split(";")[1]
                );
                books.add(book);
            }
        } catch (FileNotFoundException  e) {
            IO.print("El archivo no se ha encontrado.");
        } catch (IOException | IndexOutOfBoundsException  e) {
            IO.print("Error leyendo el fichero, archivo corrupto.");
        }

        return books;
    }

    public Book consultarPorID(String isbn) {
        File f = new File(this.ruta);
        try (
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
        ) {
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
        }
        catch (FileNotFoundException  e) {
            IO.print("El archivo no se ha encontrado.");
        } catch (IOException | IndexOutOfBoundsException  e) {
            IO.print("Error leyendo el fichero, archivo corrupto.");
        }
        return null;
    }

    // Delete
    public void eliminar(String isbn) {
        List<Book> books = consultarTodos();
        File f = new File(this.ruta);
        try (
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw); 
        ) {
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
        }
        catch (IOException e) {
           IO.print("Error leyendo el fichero, archivo corrupto.");
        }

    }

}
