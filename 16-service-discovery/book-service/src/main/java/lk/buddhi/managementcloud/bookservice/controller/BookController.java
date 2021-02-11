package lk.buddhi.managementcloud.bookservice.controller;

import lk.buddhi.managementcloud.bookservice.service.BookService;
import lk.buddhi.managementcloud.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping(value = "/{id}")
    public Book getBook(@PathVariable int id)
    {
        System.out.println("request came on "+ LocalDateTime.now() + "  ++++++++++++++++++++++");
        return bookService.findById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
