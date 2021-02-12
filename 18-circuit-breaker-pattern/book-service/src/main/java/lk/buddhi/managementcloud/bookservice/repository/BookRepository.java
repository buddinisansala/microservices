package lk.buddhi.managementcloud.bookservice.repository;

import lk.buddhi.managementcloud.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
