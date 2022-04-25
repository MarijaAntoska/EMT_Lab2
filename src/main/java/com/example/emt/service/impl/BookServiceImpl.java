package com.example.emt.service.impl;

import com.example.emt.model.Book;
import com.example.emt.repository.BookRepository;
import com.example.emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        this.bookRepository.delete(book);

        return null;
    }

    @Override
    public Book edit(Book b) {
        Book book =bookRepository.findById(b.getId()).orElseThrow();

        book.setAvailableCopies(b.getAvailableCopies());

        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
