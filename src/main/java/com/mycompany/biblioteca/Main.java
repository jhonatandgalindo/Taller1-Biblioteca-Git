package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CREATE_BOOK();
        CREATE_BOOK();
        CREATE_BOOK();
        BOOK_LIST();
        String code=SEARCH_BOOK();
        UPDATE_BOOK(code);
        BOOK_LIST();
    }

    static void CREATE_CLIENT() {
        String id, name, cellphone, mail;
        System.out.println("\n### Nuevo cliente ###\n");
        System.out.println("Ingrese su ID: ");
        id = sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        name = sc.nextLine();
        System.out.println("Ingrese su numero de telefono: ");
        cellphone = sc.nextLine();
        System.out.println("Ingrese su correo electronico: ");
        mail = sc.nextLine();
        Client client = new Client(id, name, cellphone, mail);
        clients.add(client);
        System.out.println("Cliente registrado correctamente");
    }

    static void CREATE_BOOK() {
        String code, title, publicationYear, author;
        boolean available;
        System.out.println("\n### Registrar Libro ###\n");
        System.out.println("Ingrese codigo:");
        code = sc.nextLine();
        System.out.println("Ingrese titulo:");
        title = sc.nextLine();
        System.out.println("Ingrese anio de publicacion:");
        publicationYear = sc.nextLine();
        System.out.println("Ingrese autor:");
        author = sc.nextLine();
        System.out.println("Disponible?[true(SI)|false(NO)]:");
        available = sc.nextBoolean();
        sc.nextLine();
        Book book = new Book(code, title, publicationYear, author, available);
        books.add(book);
        System.out.println("Libro registrado correctamente");
    }

    static void CLIENT_LIST() {
        System.out.println("\n### Listado clientes ###\n");
        System.out.println("ID\t\tNOMBRE\t\tTELEFONO\t\tCORREO");
        for (Client c : clients) {
            System.out.println(c.id + "\t\t" + c.name + "\t\t" + c.cellphone + "\t\t" + c.mail);
        }
    }

    static void BOOK_LIST() {
        System.out.println("\n### Listado libros ###\n");
        System.out.println("CODIGO - TITULO - ANIO PUBLICACION - AUTOR - DISPONIBLE");
        for (Book b : books) {
            String available;
            if (b.available) {
                available = "Si";
            } else {
                available = "No";
            }
            System.out.println(b.code + " - " + b.title + " - " + b.publicationYear + " - " + b.author + " - " + available);
        }
    }

    static String SEARCH_CLIENT() {
        String id;
        System.out.println("\n### Buscar Cliente ###\n");
        System.out.println("Introduzca el ID del cliente:");
        id = sc.nextLine();
        for (Client c : clients) {
            if (c.id.equals(id)) {
                System.out.println("Cliente encontrado:");
                System.out.println("ID\t\tNOMBRE\t\tTELEFONO\t\tCORREO");
                System.out.println(c.id + "\t\t" + c.name + "\t\t" + c.cellphone + "\t\t" + c.mail);
                return id;
            }
        }
        System.out.println("Cliente NO encontrado");
        return null;
    }

    static String SEARCH_BOOK() {
        String code;
        System.out.println("\n### Buscar libro ###\n");
        System.out.println("Introduzca el codigo del libro:");
        code = sc.nextLine();
        for (Book b : books) {
            String available;
            if (b.available) {
                available = "Si";
            } else {
                available = "No";
            }
            if (b.code.equals(code)) {
                System.out.println("Libro encontrado:");
                System.out.println("CODIGO - TITULO - ANIO PUBLICACION - AUTOR - DISPONIBLE");
                System.out.println(b.code + " - " + b.title + " - " + b.publicationYear + " - " + b.author + " - " + available);
                return code;
            }
        }
        System.out.println("Libro NO encontrado");
        return null;
    }

    static void UPDATE_CLIENT(String id) {

        for (Client c : clients) {

            if (c.id.equals(id)) {
                System.out.println("\n### Actualizar Datos del Cliente ###\n");
                System.out.println("ID:");
                c.id = sc.nextLine();
                System.out.println("Nombre:");
                c.name = sc.nextLine();
                System.out.println("Telefono:");
                c.cellphone = sc.nextLine();
                System.out.println("Correo electronico:");
                c.mail = sc.nextLine();
                System.out.println("DATOS DEL CLIENTE ACTUALIZADOS CORRECTAMENTE");
            }
        }
    }

    static void UPDATE_BOOK(String code) {
        for (Book b : books) {
            if (b.code.equals(code)) {
                System.out.println("\n### Actualizar Datos del Libro ###\n");
                System.out.println("Ingrese codigo:");
                b.code = sc.nextLine();
                System.out.println("Ingrese titulo:");
                b.title = sc.nextLine();
                System.out.println("Ingrese anio de publicacion:");
                b.publicationYear = sc.nextLine();
                System.out.println("Ingrese autor:");
                b.author = sc.nextLine();
                System.out.println("Disponible?[true(SI)|false(NO)]:");
                b.available = sc.nextBoolean();
                sc.nextLine();
            }
        }
    }

    static void DELETE_CLIENT(String id) {
        for (Client c : clients) {
            int i = 0;
            if (c.id.equals(id)) {
                System.out.println("\n### Actualizar Datos del Cliente ###\n");
                clients.remove(i);
                System.out.println("CLIENTE ELIMINADO CORRECTAMENTE");
                return;
            }
        }
    }

}
