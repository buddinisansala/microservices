package lk.buddhi.managementcloud.bookservice.service;

import lk.buddhi.managementcloud.bookservice.repository.BookRepository;
import lk.buddhi.managementcloud.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book member) {
        return bookRepository.save(member);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent())
            return book.get();
        else
            return new Book();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
