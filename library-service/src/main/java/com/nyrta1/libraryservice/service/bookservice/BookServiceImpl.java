package com.nyrta1.libraryservice.service.bookservice;

import com.nyrta1.libraryservice.model.Author;
import com.nyrta1.libraryservice.model.Book;
import com.nyrta1.libraryservice.repository.AuthorRepository;
import com.nyrta1.libraryservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
class BookServiceImpl implements BookService{
    private final BookRepository booksRepository;
    private final AuthorRepository authorsRepository;

    @Autowired
    public BookServiceImpl(BookRepository booksRepository, AuthorRepository authorsRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book findByUUID(UUID uuid) {
        return booksRepository
                .findById(uuid)
                .orElse(null);
    }

    @Override
    public UUID save(Book book) {
        Set<Author> resultAuthorsDataFromRepository = new HashSet<>();

        for (Author author : book.getAuthors()) {
            authorsRepository.findByAuthorUUID(
                    author.getAuthorUUID()).ifPresent(resultAuthorsDataFromRepository::add);
        }

        Book changedBook = Book.builder()
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publishedYear(book.getPublishedYear())
                .authors(resultAuthorsDataFromRepository)
                .build();

        Book savedBook = booksRepository.saveAndFlush(changedBook);
        return savedBook.getBookUUID();
    }

    @Override
    public Book update(UUID uuid, Book updatedBook) {
        Book existingBook = booksRepository.findByBookUUID(uuid).orElse(null);

        if (existingBook != null) {
            updatedBook.setBookUUID(existingBook.getBookUUID());
            return booksRepository.saveAndFlush(updatedBook);
        }

        return null;
    }


    @Override
    @Transactional
    public int deleteByUUID(UUID uuid) {
        return booksRepository.deleteByBookUUID(uuid);
    }
}
