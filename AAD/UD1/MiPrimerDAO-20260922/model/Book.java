package model;
public class Book {

    private String isbn;
    private String name;

    public Book(){};

    public Book(String isbn, String name){
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn() { return isbn; }
    public String getName() { return name; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return "[Book] " + this.isbn + " - " + this.name;
    }
}