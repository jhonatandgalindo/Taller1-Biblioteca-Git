
package com.mycompany.biblioteca;

public class Client extends Person {
    public String mail;
    public Client(String id, String name, String cellphone, String mail) {
        super(id, name, cellphone);
        this.mail = mail;
    }
    
}
