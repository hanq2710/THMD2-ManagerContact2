package data;

import data.entitis.Contact;

import java.util.ArrayList;

public interface IContactRepository {
    void addContact(Contact contact);
    Contact checkInfo(String info);
    void updateContact(String phone, Contact contact);
    void deleteContact(String phone);
    Contact[] searchEmployee(String info);
    void setPathAndData(String path);

    ArrayList<Contact> displayContact();

}
