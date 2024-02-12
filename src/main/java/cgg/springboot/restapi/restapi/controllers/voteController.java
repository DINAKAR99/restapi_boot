package cgg.springboot.restapi.restapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cgg.springboot.restapi.restapi.exceptions.AgeNotValid;
import cgg.springboot.restapi.restapi.services.VoterService;

@RestController
@RequestMapping("/vote")
public class voteController {
    @Autowired
    private VoterService voterservice;

    @PostMapping
    public ResponseEntity<?> vote(@RequestParam("age") int age) {

        if (age < 18) {
            throw new AgeNotValid("age not valid");

        }
        voterservice.vote(age);
        return ResponseEntity.ok("voted ");

    }
}
