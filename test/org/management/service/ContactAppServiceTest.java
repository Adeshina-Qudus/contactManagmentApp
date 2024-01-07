package org.management.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.management.data.model.Contact;
import org.management.data.repository.ContactAppRepository;
import org.management.data.repository.ContactRepository;
import org.management.dtos.requests.*;
import org.management.exceptions.InvalidDetailsException;
import org.management.exceptions.NameAlreadyExist;
import org.management.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactAppServiceTest {

    @Autowired
    private ContactAppService contactAppService;
    @Autowired
    private ContactAppRepository contactAppRepository;
    @Autowired
    private ContactRepository contactRepository;
    @AfterEach
    public void doThisAfterEachTest(){
        contactAppRepository.deleteAll();
        contactRepository.deleteAll();
    }
    @Test
    public void registerOneAccountTwiceTestThrowException(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        assertThrows(UserExistException.class, ()-> contactAppService.registration(registerRequest));
    }
    @Test
    public void registerOneAccountLoginWithWrongPasswordThrowsException(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("hard");
        assertThrows(InvalidDetailsException.class,
                ()-> contactAppService.login(loginRequest));
    }
    @Test
    public void registerOneAccountLoginWithWrongEmailThrowsException(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("hddgdyegeteg");
        loginRequest.setPassword("GoHard");
        assertThrows(InvalidDetailsException.class,
                ()-> contactAppService.login(loginRequest));
    }

    @Test
    public void registerAccountLoginWithRightDetailsAddOneContactNumberOfContactSavedIsOneTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08135347913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        assertEquals(1,contactRepository.count());
    }
    @Test
    public void registerAccountLoginWithRightDetailsAddContactCountNumberOfContactSavedTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08135347913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("qudus");
        addContactRequest.setPhoneNumber("08145647913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("busboy");
        addContactRequest.setPhoneNumber("08135347903");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        assertEquals(3,contactRepository.count());
    }
    @Test
    public void registerAccountLoginWithRightDetailsAddTwoContactSavedWithTheSameNameTrowExceptionTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08135347913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08145647913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        assertThrows(NameAlreadyExist.class, () -> contactAppService.addContact(addContactRequest));
    }
        @Test
        public void registerTwoAccountAndLoginBothCountNumberOfAccountExist () {
            RegisterRequest registerRequest = new RegisterRequest();
            LoginRequest loginRequest = new LoginRequest();
            registerRequest.setName("ope");
            registerRequest.setEmail("qudusa55@Gmail.com");
            registerRequest.setPhoneNumber("09079447913");
            registerRequest.setPassword("GoHard");
            contactAppService.registration(registerRequest);
            loginRequest.setEmail("qudusa55@Gmail.com");
            loginRequest.setPassword("GoHard");
            contactAppService.login(loginRequest);
            registerRequest.setName("ade");
            registerRequest.setEmail("ade55@Gmail.com");
            registerRequest.setPhoneNumber("09079447914");
            registerRequest.setPassword("GoHome");
            contactAppService.registration(registerRequest);
            loginRequest.setEmail("ade55@Gmail.com");
            loginRequest.setPassword("GoHome");
            contactAppService.login(loginRequest);
            assertEquals(2, contactAppRepository.count());
        }
        @Test
        public void registerTwoAccountsLoginWithRightDetails_BothAddContactCountNumberOfContactEachAccountSavedTest () {
            RegisterRequest registerRequest = new RegisterRequest();
            LoginRequest loginRequest = new LoginRequest();
            AddContactRequest addContactRequest = new AddContactRequest();
            registerRequest.setName("ope");
            registerRequest.setEmail("qudusa55@Gmail.com");
            registerRequest.setPhoneNumber("09079447913");
            registerRequest.setPassword("GoHard");
            contactAppService.registration(registerRequest);
            loginRequest.setEmail("qudusa55@Gmail.com");
            loginRequest.setPassword("GoHard");
            contactAppService.login(loginRequest);
            addContactRequest.setName("lekan");
            addContactRequest.setPhoneNumber("08135347913");
            addContactRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            addContactRequest.setName("qudus");
            addContactRequest.setPhoneNumber("08145647913");
            addContactRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            addContactRequest.setName("busboy");
            addContactRequest.setPhoneNumber("08135347903");
            addContactRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            RegisterRequest registerRequest1 = new RegisterRequest();
            LoginRequest loginRequest1 = new LoginRequest();
            registerRequest1.setName("ade");
            registerRequest1.setEmail("ade55@Gmail.com");
            registerRequest1.setPhoneNumber("09079447914");
            registerRequest1.setPassword("GoHome");
            contactAppService.registration(registerRequest1);
            loginRequest1.setEmail("ade55@Gmail.com");
            loginRequest1.setPassword("GoHome");
            contactAppService.login(loginRequest1);
            addContactRequest.setName("lekan");
            addContactRequest.setPhoneNumber("08135347913");
            addContactRequest.setEmail("ade55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            addContactRequest.setName("qudus");
            addContactRequest.setPhoneNumber("08145647913");
            addContactRequest.setEmail("ade55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            addContactRequest.setName("busboy");
            addContactRequest.setPhoneNumber("08135347903");
            addContactRequest.setEmail("ade55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            List<Contact> contact = contactAppService.findAllContact("ade55@Gmail.com");
            List<Contact> contact2 = contactAppService.findAllContact("qudusa55@Gmail.com");
            assertEquals(3, contact.size());
            assertEquals(3, contact2.size());
        }
        @Test
        public void registerAccountLoginWithRightDetailsAddTwoContactAndDeleteOneContactTest() {
            RegisterRequest registerRequest = new RegisterRequest();
            LoginRequest loginRequest = new LoginRequest();
            AddContactRequest addContactRequest = new AddContactRequest();
            DeleteContactRequest deleteContact = new DeleteContactRequest();
            registerRequest.setName("ope");
            registerRequest.setEmail("qudusa55@Gmail.com");
            registerRequest.setPhoneNumber("09079447913");
            registerRequest.setPassword("GoHard");
            contactAppService.registration(registerRequest);
            loginRequest.setEmail("qudusa55@Gmail.com");
            loginRequest.setPassword("GoHard");
            contactAppService.login(loginRequest);
            addContactRequest.setName("qudus");
            addContactRequest.setPhoneNumber("08145647913");
            addContactRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            addContactRequest.setName("busboy");
            addContactRequest.setPhoneNumber("08135347903");
            addContactRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.addContact(addContactRequest);
            deleteContact.setName("busboy");
            deleteContact.setEmail("qudusa55@Gmail.com");
            contactAppService.deleteContact(deleteContact);
            assertEquals(1, contactRepository.count());
        }
        @Test
        public void registerAccountLoginAndEditProfile () {
            RegisterRequest registerRequest = new RegisterRequest();
            LoginRequest loginRequest = new LoginRequest();
            EditProfileRequest editProfileRequest = new EditProfileRequest();
            registerRequest.setName("ope");
            registerRequest.setEmail("qudusa55@Gmail.com");
            registerRequest.setPhoneNumber("09079447913");
            registerRequest.setPassword("GoHard");
            contactAppService.registration(registerRequest);
            loginRequest.setEmail("qudusa55@Gmail.com");
            loginRequest.setPassword("GoHard");
            contactAppService.login(loginRequest);
            editProfileRequest.setName("lekan");
            editProfileRequest.setEmail("qudusa55@Gmail.com");
            contactAppService.editProfile(editProfileRequest);
            assertEquals("lekan", contactAppRepository.findByEmail("qudusa55@Gmail.com").getName());
        }
    @Test
    public void registerAccountLoginAndDeleteProfile () {
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        contactAppService.deleteProfile( "qudusa55@Gmail.com");
        assertEquals(0,contactAppRepository.count());
    }
    @Test
    public void registerAccountLoginAddContactFindContact(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        FindContactRequest findContactRequest = new FindContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("qudus");
        addContactRequest.setPhoneNumber("08145647913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        findContactRequest.setName("qudus");
        findContactRequest.setEmail("qudusa55@Gmail.com");
        assertEquals("qudus",contactAppService.findContact(findContactRequest).getName());
    }
    @Test
    public void registerThreeAccountLoginAddContactFindLastContactSavedContact(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        FindContactRequest findContactRequest = new FindContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08135347913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("qudus");
        addContactRequest.setPhoneNumber("08145647913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("busboy");
        addContactRequest.setPhoneNumber("08135347903");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        findContactRequest.setName("lekan");
        findContactRequest.setEmail("qudusa55@Gmail.com");
        assertEquals("lekan",contactAppService.findContact(findContactRequest).getName());
    }
    @Test
    public void registerAccountLoginAddContactFindAllContactTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        AddContactRequest addContactRequest = new AddContactRequest();
        registerRequest.setName("ope");
        registerRequest.setEmail("qudusa55@Gmail.com");
        registerRequest.setPhoneNumber("09079447913");
        registerRequest.setPassword("GoHard");
        contactAppService.registration(registerRequest);
        loginRequest.setEmail("qudusa55@Gmail.com");
        loginRequest.setPassword("GoHard");
        contactAppService.login(loginRequest);
        addContactRequest.setName("lekan");
        addContactRequest.setPhoneNumber("08135347913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("qudus");
        addContactRequest.setPhoneNumber("08145647913");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        addContactRequest.setName("busboy");
        addContactRequest.setPhoneNumber("08135347903");
        addContactRequest.setEmail("qudusa55@Gmail.com");
        contactAppService.addContact(addContactRequest);
        assertEquals(3,contactRepository.count());
    }
}
