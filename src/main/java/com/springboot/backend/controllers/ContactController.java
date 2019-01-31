package com.springboot.backend.controllers;

import com.springboot.backend.models.Contact;
import com.springboot.backend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Bikram Baral
 * Date: 1/30/2019
 */

@RestController
@ComponentScan(basePackages = "com.springboot.backend")
@RequestMapping("/api")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/contact")
    public List<Contact> getAllContacts() {
        Sort sortByDate = new Sort(Sort.Direction.DESC, "createdAt");
        return contactRepository.findAll(sortByDate);
    }

    @PostMapping("/contact")
    public Contact createSave(@Valid @RequestBody Contact contact) {
        contact.setCompleted(false);
        return contactRepository.save(contact);
    }

    @GetMapping(value="/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") String id) {
        return contactRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/contact/{id}")
    public ResponseEntity <Contact> updateContact(@PathVariable("id") String id,
                                               @Valid @RequestBody Contact contact) {
        return contactRepository.findById(id)
                .map(data -> {
                    data.setId(contact.getId());
                    data.setName(contact.getName());
                    data.setAddress(contact.getAddress());
                    data.setCity(contact.getCity());
                    data.setPhone(contact.getPhone());
                    data.setEmail(contact.getEmail());
                    data.setCompleted(contact.getCompleted());
                    data.setCreatedAt(contact.getCreatedAt());
                    Contact updatedContact = contactRepository.save(data);
                    return ResponseEntity.ok().body(updatedContact);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/contact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") String id) {
        return contactRepository.findById(id)
                .map(todo -> {
                    contactRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
