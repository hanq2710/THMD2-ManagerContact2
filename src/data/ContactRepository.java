package data;

import data.entitis.Contact;
import java.util.ArrayList;

public class ContactRepository implements IContactRepository {


    FileFactory fileFactory;
    ArrayList<Contact> arrayList;
    private String path = "Contact.csv";
    public ContactRepository(){
        fileFactory = new FileFactory();
        arrayList = fileFactory.readContact(path);
    }
    @Override
    public ArrayList<Contact> displayContact(){
        ArrayList<Contact> disArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            disArrayList.add(arrayList.get(i));
        }
        return arrayList;
    }
    @Override
    public void addContact(Contact contact){
    arrayList.add(contact);
    fileFactory.writeContact(this.path, arrayList);
        System.out.println("Thêm thành công ..!");
    }
    @Override
    public Contact checkInfo(String info){
    return arrayList.stream().filter(
            o -> info.equals(o.getPhone())).findFirst().orElse(null);
    }@Override
    public void updateContact(String phone, Contact contact){
        for (int i = 0; i < arrayList.size(); i++) {
            if(phone.equals(arrayList.get(i).getPhone())){
                arrayList.set(i,contact);
                fileFactory.writeContact(this.path, arrayList);
                System.out.println("Câp nhật thành công");
            }
        }
    }
    @Override
    public void deleteContact(String phone) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (phone.equals(arrayList.get(i).getPhone())) {
            arrayList.remove(i);
            fileFactory.writeContact(this.path, arrayList);
                System.out.println("Xóa thành công..!");
            }
        }
    }
    @Override
    public Contact[] searchEmployee(String info){
        return arrayList.stream().filter(
                o -> info.equals(o.getName()) || info.equals(o.getPhone())).toArray(Contact[]::new);
    }

    public void setPathAndData(String path){
        this.path = path;
        this.arrayList = fileFactory.readContact(this.path);
    }
}
