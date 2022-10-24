package ch.fhnw.webec.contactlist;

import ch.fhnw.webec.contactlist.data.ContactRepository;
import ch.fhnw.webec.contactlist.model.Contact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class JpaTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    //    private ContactRepository contactRepository;
//
//    public JpaTest(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        var contacts = contactRepository.findAll();
//        for (Contact contact : contacts) {
//            System.out.println(contact.getFirstName() + " " + contact.getLastName());
//        }
//    }

}
