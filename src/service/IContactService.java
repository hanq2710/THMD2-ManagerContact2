package service;

import data.entitis.Contact;

import java.util.ArrayList;

public interface IContactService {
    ArrayList<Contact> displayContact();
    void addContact();
    void deleteContact();
    void searchContact();
    void updateContact();
    void readFile();
    String writeFile();
}
