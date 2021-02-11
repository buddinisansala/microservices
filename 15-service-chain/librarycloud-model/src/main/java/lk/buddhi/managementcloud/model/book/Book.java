package lk.buddhi.managementcloud.model.book;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String author;
    String name;
    String type;
    int year;

}