package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CREATE_CLIENT();CREATE_CLIENT();CREATE_CLIENT();
        CLIENT_LIST();
        String id = SEARCH_CLIENT();
        UPDATE_CLIENT(id);
        CLIENT_LIST();
    }
    
    static void CREATE_CLIENT(){
        String id,name,cellphone,mail;
        System.out.println("\n### Nuevo cliente ###\n");
        System.out.println("Ingrese su ID: ");
        id = sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        name = sc.nextLine();
        System.out.println("Ingrese su numero de telefono: ");
        cellphone = sc.nextLine();
        System.out.println("Ingrese su correo electronico: ");
        mail = sc.nextLine();
        Client client = new Client(id,name,cellphone,mail);
        clients.add(client);
        System.out.println("Cliente registrado correctamente");
    }
    static void CLIENT_LIST(){
        System.out.println("\n### Listado clientes ###\n");
        System.out.println("ID\t\tNOMBRE\t\tTELEFONO\t\tCORREO");
        for(Client c : clients){
            System.out.println(c.id+"\t\t"+c.name+"\t\t"+c.cellphone+"\t\t"+c.mail);
        }
    }
    static String SEARCH_CLIENT(){
        String id;
        System.out.println("\n### Buscar Cliente ###\n");
        System.out.println("Introduzca el ID del cliente:");
        id = sc.nextLine();
        for(Client c : clients){
            if(c.id.equals(id)){
                System.out.println("Cliente encontrado:");
                System.out.println("ID\t\tNOMBRE\t\tTELEFONO\t\tCORREO");
                System.out.println(c.id+"\t\t"+c.name+"\t\t"+c.cellphone+"\t\t"+c.mail);
                return id;
            }
        }
        System.out.println("Cliente NO encontrado");
        return null;
    }
    static void UPDATE_CLIENT(String id){
        
        for(Client c : clients){
            
            if(c.id.equals(id)){
                System.out.println("\n### Actualizar Datos del Cliente ###\n");
                System.out.println("ID:");
                c.id=sc.nextLine();
                System.out.println("Nombre:");
                c.name=sc.nextLine();
                System.out.println("Telefono:");
                c.cellphone=sc.nextLine();
                System.out.println("Correo electronico:");
                c.mail=sc.nextLine();
                System.out.println("DATOS DEL CLIENTE ACTUALIZADOS CORRECTAMENTE");
            }
        }
    }
}
