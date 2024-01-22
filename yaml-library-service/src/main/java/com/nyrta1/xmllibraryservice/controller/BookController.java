package com.nyrta1.xmllibraryservice.controller;

import com.nyrta1.xmllibraryservice.model.Book;
import com.nyrta1.xmllibraryservice.service.bookservice.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/xml/books")
@Slf4j
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getBookByUUID(@Valid @PathVariable("uuid") UUID uuid) {
        Book book = bookService.findByUUID(uuid);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(book);
    }


    @PostMapping
    public ResponseEntity<UUID> saveAuthor(@RequestBody @Valid Book book) {
        log.info(book.toString());
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
