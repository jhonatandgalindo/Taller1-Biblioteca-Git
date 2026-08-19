
package com.mycompany.biblioteca;

public class Book extends Material {
    public String author;
    public boolean available;

    public Book(String code, String title, String publicationYear,
                String author, boolean available) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = available;
    }
    
}
