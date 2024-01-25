package com.nyrta1.yamllibraryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyrta1.yamllibraryservice.model.Book;
import com.nyrta1.yamllibraryservice.service.bookservice.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/yaml/books")
@Slf4j
public class BookController {
    private final BookService bookService;

    @Qualifier("yamlObjectMapper")
    private final ObjectMapper yamlObjectMapper;

    @Autowired
    public BookController(BookService bookService, ObjectMapper yamlObjectMapper) {
        this.bookService = bookService;
        this.yamlObjectMapper = yamlObjectMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        try {
            List<Book> books = bookService.findAll();
            String yamlBooks = yamlObjectMapper.writeValueAsString(books);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(yamlBooks);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getBookByUUID(@Valid @PathVariable("uuid") UUID uuid) {
        try {
            Book book = bookService.findByUUID(uuid);
            String yamlBook = yamlObjectMapper.writeValueAsString(book);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(yamlBook);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<UUID> saveAuthor(@RequestBody @Valid Book book) {
        UUID bookUUID = bookService.save(book);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookUUID);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestParam("uuid") UUID uuid, @RequestBody @Valid Book book) {
        Book updatedBook = bookService.update(uuid, book);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedBook);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBookByUUID(@RequestParam("uuid") UUID uuid) {
        int isSuccess = bookService.deleteByUUID(uuid);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
