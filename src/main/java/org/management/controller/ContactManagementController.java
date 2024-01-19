package org.management.controller;

import org.management.dtos.requests.*;
import org.management.dtos.responses.*;
import org.management.exceptions.ContactManagementException;
import org.management.service.ContactManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactManagementController {

    @Autowired
    private ContactManagementService contactAppService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            contactAppService.registration(registerRequest);
            registerResponse.setMessage("Account created successfully");
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.CREATED);
        } catch (ContactManagementException exception) {
            registerResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, registerResponse), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            contactAppService.login(loginRequest);
            loginResponse.setMessage("logged in successfully");
            return new ResponseEntity<>(new ApiResponse(true, loginResponse), HttpStatus.ACCEPTED);
        } catch (ContactManagementException exception) {
            loginResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, loginResponse), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody AddContactRequest addContactRequest) {
        AddContactResponse addContactResponse = new AddContactResponse();
        try {
            contactAppService.addContact(addContactRequest);
            addContactResponse.setMessage("Contact Added");
            return new ResponseEntity<>(new ApiResponse(true, addContactResponse), HttpStatus.ACCEPTED);
        } catch (ContactManagementException exception) {
            addContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, addContactResponse), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/deleteContact")
    public ResponseEntity<?> deleteContact(@RequestBody DeleteContactRequest deleteContactRequest) {
        DeleteContactResponse deleteContactResponse = new DeleteContactResponse();
        try {
            contactAppService.deleteContact(deleteContactRequest);
            deleteContactResponse.setMessage("Deleted");
            return new ResponseEntity<>(new ApiResponse(true, deleteContactResponse), HttpStatus.GONE);
        } catch (ContactManagementException exception) {
            deleteContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, deleteContactResponse), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PostMapping("/editProfile")
    public ResponseEntity<?> editProfile(@RequestBody EditProfileRequest editProfileRequest) {
        EditProfileResponse editProfileResponse = new EditProfileResponse();
        try {
            editProfileResponse.setMessage("Edited");
            return new ResponseEntity<>(new ApiResponse(true, editProfileResponse), HttpStatus.ACCEPTED);
        } catch (ContactManagementException exception) {
            editProfileResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, editProfileResponse), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/deleteProfile/{email}")
    public ResponseEntity<?> deleteProfile(@PathVariable("email") String email) {
        DeleteProfileResponse  deleteProfileResponse = new DeleteProfileResponse();
        try {
            contactAppService.deleteProfile(email);
            deleteProfileResponse.setMessage("Delete");
            return new ResponseEntity<>(new ApiResponse(true,deleteProfileResponse),HttpStatus.GONE);
        } catch (ContactManagementException exception) {
            deleteProfileResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false,deleteProfileResponse),HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/findContact")
    public ResponseEntity<?> findContact(@RequestBody FindContactRequest findContactRequest) {
        FindContactResponse findContactResponse = new FindContactResponse();
        try {
            findContactResponse.setContact(contactAppService.findContact(findContactRequest));
            return new ResponseEntity<>(new ApiResponse(true, findContactResponse), HttpStatus.FOUND);
        } catch (ContactManagementException exception) {
            findContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, findContactResponse), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAllContact/{email}")
    public ResponseEntity<?> findAllContact(@PathVariable("email") String email){
        FindAllContactResponse findAllContactResponse = new FindAllContactResponse();
        try {
            findAllContactResponse.setAllContact(contactAppService.findAllContact(email));
            return new ResponseEntity<>(new ApiResponse(true,findAllContactResponse),HttpStatus.FOUND);
        }catch (ContactManagementException exception){
            return new ResponseEntity<>(new ApiResponse(false,findAllContactResponse),HttpStatus.NOT_FOUND);
        }
    }
}
