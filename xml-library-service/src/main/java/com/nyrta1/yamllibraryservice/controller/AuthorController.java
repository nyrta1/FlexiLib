package com.nyrta1.yamllibraryservice.controller;

import com.nyrta1.yamllibraryservice.model.Author;
import com.nyrta1.yamllibraryservice.service.authorservice.AuthorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/xml/authors")
@Slf4j
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthor() {
        List<Author> authors = authorService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authors);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getAuthorByUUID(@Valid @PathVariable("uuid") UUID uuid) {
        Author author = authorService.findByUUID(uuid);
        return ResponseEntity.of(Optional.ofNullable(author));
    }

    @PostMapping
    public ResponseEntity<UUID> saveAuthor(@RequestBody @Valid Author author) {
        UUID authorUUID = authorService.save(author);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorUUID);
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestParam("uuid") UUID uuid, @RequestBody @Valid Author author) {
        Author updatedAuthor = authorService.update(uuid, author);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedAuthor);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAuthorByUUID(@RequestParam("uuid") UUID uuid) {
        int isSuccess = authorService.deleteByUUID(uuid);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
