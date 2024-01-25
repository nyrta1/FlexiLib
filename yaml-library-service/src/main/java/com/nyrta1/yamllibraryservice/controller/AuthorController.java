package com.nyrta1.yamllibraryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyrta1.yamllibraryservice.model.Author;
import com.nyrta1.yamllibraryservice.service.authorservice.AuthorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/yaml/authors")
@Slf4j
public class AuthorController {
    private final AuthorService authorService;

    @Qualifier("yamlObjectMapper")
    private final ObjectMapper yamlObjectMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ObjectMapper yamlObjectMapper) {
        this.authorService = authorService;
        this.yamlObjectMapper = yamlObjectMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthor() {
        try {
            List<Author> authors = authorService.findAll();
            String yamlAuthors = yamlObjectMapper.writeValueAsString(authors);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(yamlAuthors);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getAuthorByUUID(@Valid @PathVariable("uuid") UUID uuid) {
        try {
            Author author = authorService.findByUUID(uuid);
            String yamlAuthor = yamlObjectMapper.writeValueAsString(author);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(yamlAuthor);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestBody @Valid Author author) {
        try {
            String yamlAuthor = yamlObjectMapper.writeValueAsString(author);
            UUID authorUUID = authorService.save(author);

            if (authorUUID == null) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Unable to save the user");
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(yamlAuthor);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateAuthor(@RequestParam("uuid") UUID uuid, @RequestBody String yamlAuthor) {
        try {
            Author author = yamlObjectMapper.readValue(yamlAuthor, Author.class);
            Author updatedAuthor = authorService.update(uuid, author);

            if (updatedAuthor == null) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Unable to update the user");
            }

            String updatedYamlAuthor = yamlObjectMapper.writeValueAsString(updatedAuthor);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedYamlAuthor);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAuthorByUUID(@RequestParam("uuid") UUID uuid) {
        try {
            int isSuccess = authorService.deleteByUUID(uuid);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(isSuccess);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
