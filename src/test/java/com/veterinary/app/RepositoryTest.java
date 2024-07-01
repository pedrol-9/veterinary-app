//package com.veterinary.app;
//
//import com.veterinary.veterinaryApp.Repositories.ClientRepository;
//import com.veterinary.veterinaryApp.VeterinaryAppApplication;
//import com.veterinary.veterinaryApp.models.Client;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//import static org.hamcrest.Matchers.*;
//
//@DataJpaTest
//@ContextConfiguration(classes = VeterinaryAppApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class RepositoryTest {
//    @Autowired
//    ClientRepository clientRepository;
//
//    @Test
//    public void canFindClientByEmail() {
//
//        Client client = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "abc123", 31334177);
//        clientRepository.save(client);
//
//        Client foundClient = clientRepository.findByEmail("jelena@vetadmin.com");
//
//        assertThat(foundClient, is(client));
//    }
//
//    @Test
//    public void canSaveClient() {
//
//        Client client = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "abc123", 31334177);
//        clientRepository.save(client);
//
//        Client foundClient = clientRepository.findByEmail("jelena@vetadmin.com");
//
//        assertThat(foundClient, is(client));
//    }
//
//    @Test
//    public void canDeleteClient() {
//
//        Client client = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "abc123", 31334177);
//        clientRepository.save(client);
//
//        clientRepository.delete(client);
//
//        Client foundClient = clientRepository.findByEmail("jelena@vetadmin.com");
//
//        assertThat(foundClient, nullValue());
//    }
//}
