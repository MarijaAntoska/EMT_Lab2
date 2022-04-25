package com.example.emt.web;

import com.example.emt.model.Book;
import com.example.emt.model.Category;
import com.example.emt.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/", "/books"})
    public String showAll(Model model) {

        List<Book> books = this.bookService.listAll();
        model.addAttribute("books", books);

        return "books.html";
    }
    @GetMapping("/books/add")
    public String showAdd(Model model){

        List<Book> books = this.bookService.listAll();
        model.addAttribute("books",books);
        model.addAttribute("category", Category.values());

        return "addBook.html";
    }
    @GetMapping("/books/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model){

        Book books = this.bookService.findById(id);
        model.addAttribute("books",books);
        model.addAttribute("category", Category.values());

        return "addBook.html";
    }


    @PostMapping("/books")
    public String addBook(Book book){
        bookService.create(book);
        return"redirect:/books";
    }
    @PostMapping("/books/{id}")
    public String editBook(Book book){
        bookService.edit(book);
        return"redirect:/books";
    }
    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.bookService.delete(id);
        return "redirect:/books";
    }

}
