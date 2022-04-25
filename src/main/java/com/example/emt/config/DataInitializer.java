package com.example.emt.config;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.Category;
import com.example.emt.model.Country;
import com.example.emt.service.AuthorService;
import com.example.emt.service.BookService;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {

        Country country = new Country("Macedonia","Europe");
        Author author = new Author("Author1","Surname1",country);
        Book book = new Book("Book1", Category.BIOGRAPHY,author,10);
        Book book2 = new Book("Book2", Category.BIOGRAPHY,author,10);



        this.countryService.create(country);
        this.authorService.create(author);
        this.bookService.create(book);
        this.bookService.create(book2);

    }
}
