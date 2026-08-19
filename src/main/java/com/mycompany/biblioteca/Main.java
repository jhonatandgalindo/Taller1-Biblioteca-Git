package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    int option;

    do {
        System.out.println("\n==============================");
        System.out.println("      SISTEMA BIBLIOTECA");
        System.out.println("==============================");
        System.out.println("1. Gestionar clientes");
        System.out.println("2. Gestionar libros");
        System.out.println("3. Gestionar prestamos");
        System.out.println("0. Salir");
        System.out.println("==============================");
        System.out.println("Seleccione una opcion:");

        option = sc.nextInt();
        sc.nextLine();

        switch (option) {

            case 1:

                int clientOption;

                do {
                    System.out.println("\n### GESTION DE CLIENTES ###\n");
                    System.out.println("1. Registrar cliente");
                    System.out.println("2. Listar clientes");
                    System.out.println("3. Buscar cliente");
                    System.out.println("4. Actualizar cliente");
                    System.out.println("5. Eliminar cliente");
                    System.out.println("0. Volver");
                    System.out.println("Seleccione una opcion:");

                    clientOption = sc.nextInt();
                    sc.nextLine();

                    switch (clientOption) {

                        case 1:
                            CREATE_CLIENT();
                            break;

                        case 2:
                            CLIENT_LIST();
                            break;

                        case 3:
                            SEARCH_CLIENT();
                            break;

                        case 4:
                            System.out.println("Ingrese el ID del cliente:");
                            String idUpdate = sc.nextLine();
                            UPDATE_CLIENT(idUpdate);
                            break;

                        case 5:
                            System.out.println("Ingrese el ID del cliente:");
                            String idDelete = sc.nextLine();
                            DELETE_CLIENT(idDelete);
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                    }

                } while (clientOption != 0);

                break;


            case 2:

                int bookOption;

                do {
                    System.out.println("\n### GESTION DE LIBROS ###\n");
                    System.out.println("1. Registrar libro");
                    System.out.println("2. Listar libros");
                    System.out.println("3. Buscar libro");
                    System.out.println("4. Actualizar libro");
                    System.out.println("5. Eliminar libro");
                    System.out.println("0. Volver");
                    System.out.println("Seleccione una opcion:");

                    bookOption = sc.nextInt();
                    sc.nextLine();

                    switch (bookOption) {

                        case 1:
                            CREATE_BOOK();
                            break;

                        case 2:
                            BOOK_LIST();
                            break;

                        case 3:
                            SEARCH_BOOK();
                            break;

                        case 4:
                            System.out.println("Ingrese el codigo del libro:");
                            String codeUpdate = sc.nextLine();
                            UPDATE_BOOK(codeUpdate);
                            break;

                        case 5:
                            System.out.println("Ingrese el codigo del libro:");
                            String codeDelete = sc.nextLine();
                            DELETE_BOOK(codeDelete);
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                    }

                } while (bookOption != 0);

                break;


            case 3:

                int loanOption;

                do {
                    System.out.println("\n### GESTION DE PRESTAMOS ###\n");
                    System.out.println("1. Registrar prestamo");
                    System.out.println("2. Listar prestamos");
                    System.out.println("3. Devolver prestamo");
                    System.out.println("0. Volver");
                    System.out.println("Seleccione una opcion:");

                    loanOption = sc.nextInt();
                    sc.nextLine();

                    switch (loanOption) {

                        case 1:
                            CREATE_LOAN();
                            break;

                        case 2:
                            LOAN_LIST();
                            break;

                        case 3:
                            System.out.println("Ingrese el ID del prestamo:");
                            String idLoan = sc.nextLine();
                            RETURN_LOAN(idLoan);
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                    }

                } while (loanOption != 0);

                break;


            case 0:
                System.out.println("Saliendo del sistema...");
                break;

            default:
                System.out.println("Opcion no valida.");
        }

    } while (option != 0);
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
    static void CREATE_LOAN(){
        String idLoan;
        Client client;Book book;
        LocalDate date;
        String status;
        System.out.println("\n### Registro Prestamo ###\n");
        System.out.println("Ingrese la ID del prestamo:");
        idLoan=sc.nextLine();
        client=SEARCH_CLIENT();
        do{
            book=SEARCH_BOOK();
            if(!book.available){
                System.out.println("Libro no disponible, favor registrar otro.");
            }else{
                book.available=false;
            }
        }while(book.available);
        System.out.println("Ingrese la fecha del prestamo[Formato YYYY-MM-DD]:");
        date = LocalDate.parse(sc.nextLine());
        System.out.println("Ingrese estado del prestamo:");
        status =sc.nextLine();
        Loan loan = new Loan(idLoan,client,book,date,status);
        loans.add(loan);
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
    static void LOAN_LIST(){
        System.out.println("\n### Listado prestamos ###\n");
        System.out.println("ID - CLIENTE - LIBRO - FECHA - ESTADO");
        for (Loan l : loans) {
            System.out.println(l.idLoan + " - " + l.client + " - " + l.book + " - " + l.date + " - " + l.status);
        }
    }
    static Client SEARCH_CLIENT() {
        String id;
        System.out.println("\n### Buscar Cliente ###\n");
        System.out.println("Introduzca el ID del cliente:");
        id = sc.nextLine();
        for (Client c : clients) {
            if (c.id.equals(id)) {
                System.out.println("Cliente encontrado:");
                System.out.println("ID\t\tNOMBRE\t\tTELEFONO\t\tCORREO");
                System.out.println(c.id + "\t\t" + c.name + "\t\t" + c.cellphone + "\t\t" + c.mail);
                return c;
            }
        }
        System.out.println("Cliente NO encontrado");
        return null;
    }

    static Book SEARCH_BOOK() {
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
                return b;
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
        int i = 0;
        for (Client c : clients) {
            
            if (c.id.equals(id)) {
                System.out.println("\n### Eliminar Cliente ###\n");
                clients.remove(i);
                System.out.println("CLIENTE ELIMINADO CORRECTAMENTE");
                return;
            }
            i++;
        }
    }
    static void DELETE_BOOK(String code){
        int i = 0;
        for (Book b : books) {
            
            if (b.code.equals(code)) {
                System.out.println("\n### Eliminar Libro ###\n");
                books.remove(i);
                System.out.println("LIBRO ELIMINADO CORRECTAMENTE");
                return;
            }
            i++;
        }
    }
    static void RETURN_LOAN(String idLoan){
        int i = 0;
        for (Loan l : loans) {
            
            if (l.idLoan.equals(idLoan)) {
                l.book.available=true;
                System.out.println("\n### DEVOLUCION PRESTAMO ###\n");
                loans.remove(i);
                System.out.println("PRESTAMO DEVUELTO CORRECTAMENTE");
                return;
            }
            i++;
        }
    }
}
