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

public class LocalBookDAO implements InterfazBookDAO {
    
    String ruta;
    List<Book> libros;

    public LocalBookDAO(String ruta) {
        this.ruta = ruta;
        this.libros = cargarDatos();
    }

    private  List<Book> cargarDatos() {
        // BookDAO bookDAO = new BookDAO(ruta);
        // return bookDAO.consultarTodos();
        //
        File f = new File(this.ruta);
        List<Book> books = new ArrayList<>();
        try (
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);) {
            String linea;
            while ((linea = br.readLine())!= null) {
                Book book = new Book(
                    linea.split(";")[0],
                    linea.split(";")[1]
                );
                books.add(book);
            }
        }
        catch (FileNotFoundException  e) {
            IO.print("El archivo no se ha encontrado.");
        } catch (IOException | IndexOutOfBoundsException  e) {
            IO.print("Error leyendo el fichero, archivo corrupto.");
        }
        return books;
    }

    private void guardarDatos() {
        File f = new File(this.ruta);
        try (
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (Book libro : this.libros){
                bw.write(libro.getIsbn() + ";" + libro.getName() + "\n");
            }
        } 
        catch (IOException e) {
           IO.print("Error leyendo el fichero, archivo corrupto.");
        }

    }

    public void insertar(Book libro){
        this.libros.add(libro);
        guardarDatos();
    }

    public void actualizar(String isbn, String nuevoNombre){
        for (Book libro : this.libros){
            if (libro.getIsbn().equals(isbn)){
                libro.setName(nuevoNombre);
                break;
            }
        }
        guardarDatos();
    }

    public List<Book> consultarTodos(){
        return this.libros;
    }

    public Book consultarPorID(String isbn){
        for (Book libro : this.libros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public void eliminar(String isbn){
        Book libro = consultarPorID(isbn);
        if (libro != null){
            this.libros.remove(libro);
        }
        guardarDatos();
    }
}
