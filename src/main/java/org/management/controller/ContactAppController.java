package org.management.controller;

import org.management.dtos.requests.*;
import org.management.dtos.responses.*;
import org.management.exceptions.ContactAppException;
import org.management.service.ContactAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactAppController {

    @Autowired
    private ContactAppService contactAppService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            contactAppService.registration(registerRequest);
            registerResponse.setMessage("Account created successfully");
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.CREATED);
        } catch (ContactAppException exception) {
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
        } catch (ContactAppException exception) {
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
            return new ResponseEntity<>(new ApiResponse(true, addContactRequest), HttpStatus.ACCEPTED);
        } catch (ContactAppException exception) {
            addContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, addContactRequest), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/deleteContact")
    public ResponseEntity<?> deleterContact(@RequestBody DeleteContactRequest deleteContactRequest) {
        DeleteContactResponse deleteContactResponse = new DeleteContactResponse();
        try {
            contactAppService.deleteContact(deleteContactRequest);
            deleteContactResponse.setMessage("Deleted");
            return new ResponseEntity<>(new ApiResponse(true, deleteContactRequest), HttpStatus.GONE);
        } catch (ContactAppException exception) {
            deleteContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, deleteContactRequest), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PostMapping("/editProfile")
    public ResponseEntity<?> editProfile(@RequestBody EditProfileRequest editProfileRequest) {
        EditProfileResponse editProfileResponse = new EditProfileResponse();
        try {
            contactAppService.editProfile(editProfileRequest);
            editProfileResponse.setMessage("Edited");
            return new ResponseEntity<>(new ApiResponse(true, editProfileRequest), HttpStatus.ACCEPTED);
        } catch (ContactAppException exception) {
            editProfileResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, editProfileRequest), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/deleteProfile/{email}")
    public String deleteProfile(@PathVariable String email) {
        try {
            contactAppService.deleteProfile(email);
            return "Deleted";
        } catch (ContactAppException exception) {
            return exception.getMessage();
        }
    }

    @GetMapping("/findContact")
    public ResponseEntity<?> findContact(@RequestBody FindContactRequest findContactRequest) {
        FindContactResponse findContactResponse = new FindContactResponse();
        try {
            contactAppService.findContact(findContactRequest);
            findContactResponse.setMessage("found");
            return new ResponseEntity<>(new ApiResponse(true, findContactRequest), HttpStatus.FOUND);
        } catch (ContactAppException exception) {
            findContactResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, findContactRequest), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAllContact/{email}")
    public String findAllContact(@PathVariable String email){
        try {
            contactAppService.findAllContact(email);
            return "All contact";
        }catch (ContactAppException exception){
            return exception.getMessage();
        }
    }
}
