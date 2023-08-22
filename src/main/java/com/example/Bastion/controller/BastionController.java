package com.example.Bastion.controller;
import com.example.Bastion.entitty.crmentity.OnlineActivation;
import com.example.Bastion.entitty.crmentity.User;
import com.example.Bastion.service.BastionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class BastionController {
    @Autowired
    private BastionService bastionService;

    @GetMapping("/b/gelAllData")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllBastionDetails(){
        return new ResponseEntity<>(bastionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/b/bastions/{licenseKey}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public OnlineActivation getLicense(@PathVariable("licenseKey") String licenseKey){
        return bastionService.getLicense(licenseKey);
    }

    @PutMapping("/b/update/{licenseKey}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void UpdateSystemCount(@RequestBody OnlineActivation onlineActivation ,@PathVariable("licenseKey") String licenseKey) {
        bastionService.updateSystemCount(onlineActivation ,licenseKey);
    }

    @DeleteMapping("/b/deleteEntry/{licenseKey}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Void deleteEntry(@PathVariable("licenseKey") String licenseKey){
        bastionService.deleteEntry(licenseKey);
        return null;
    }

    @GetMapping("/b/bastion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<OnlineActivation>> getBook()
    {
        List<OnlineActivation> list=bastionService.getAllBook();
        try
        {
            return  ResponseEntity.of(Optional.of(list));
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/newUser")
    public String addUser(@RequestBody User user){
        return bastionService.addUser(user);
    }

}

