//package com.veterinary.app;
//
//
//import com.veterinary.veterinaryApp.models.AnimalSize;
//import com.veterinary.veterinaryApp.models.Client;
//import com.veterinary.veterinaryApp.models.Pet;
//import com.veterinary.veterinaryApp.models.Veterinarian;
//import jakarta.transaction.TransactionScoped;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//import static org.hamcrest.Matchers.*;
////@SpringBootTest
//public class ClientTest {
//
//    @Test
//    public void canCreateClient() {
//
//        Client client = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "abc123", 31334177);
//
//        assertThat(client.getFirstName(), is("Jelena"));
//        assertThat(client.getLastName(), is("Palavecino"));
//        assertThat(client.getEmail(), is("jelena@vetadmin.com"));
//        assertThat(client.getPassword(), is("abc123"));
//        assertThat(client.getPhone(), is(31334177));
//    }
//
//    @Test
//    public void canAddPet() {
//
//        Client client = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "abc123", 31334177);
//        Pet pet = new Pet("Nina", "5", "Dog", "Husky", AnimalSize.MEDIUM, "Nina.jpg");
//
//        client.addPet(pet);
//        assertThat(client.getPets().get(0), is(pet));
//    }
//
//    @Test
//    public void canCreateVeterinarian() {
//        Veterinarian vet1 = new Veterinarian("Brayan", "Veterinary Dermatology", "Calle 1 # 2 - 3", "31334177", "derma@tology.com","");
//
//        assertThat(vet1.getName(), is("Brayan"));
//        assertThat(vet1.getAddress(), is("Calle 1 # 2 - 3"));
//        assertThat(vet1.getEmail(), is("derma@tology.com"));
//    }
//}
