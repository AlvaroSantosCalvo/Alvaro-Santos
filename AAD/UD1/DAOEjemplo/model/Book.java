package AAD.UD1.DAOEjemplo.model;

public class Book {
    private  String isbn;
    private String name;

    Book(){};

    Book(String isbn, String name){
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn() { return isbn; }
    public String getName() { return name; }

    public void setIsbn (String isbn) {this.isbn = isbn; }
    public void setName (String name) {this.name = name; }

    @Override
    public String toString() {
        return isbn + ";" + name;
    }
}


