
package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {
    String idLoan;
    Client client;
    Book book;
    LocalDate date;
    String status;

    public Loan(String idLoan, Client client, Book book, LocalDate date, String status) {
        this.idLoan = idLoan;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = status;
    }
}
