package com.example.emt.service;

import com.example.emt.model.Book;

import java.util.List;

public interface BookService {

    List<Book> listAll();
    Book create(Book book);
    Book delete(Long id);
    Book edit(Book book);
    Book findById(Long id);
}
