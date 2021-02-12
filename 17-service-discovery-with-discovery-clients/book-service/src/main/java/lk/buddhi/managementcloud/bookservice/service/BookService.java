package lk.buddhi.managementcloud.bookservice.service;

import lk.buddhi.managementcloud.model.book.Book;

import java.util.List;

public interface BookService {
    Book save(Book member);

    Book findById(int id);

    List<Book> findAll();
}
