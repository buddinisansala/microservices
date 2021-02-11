package lk.buddhi.managementcloud.model.borrow;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow")
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int borrowId;

    int memberId;
    int bookId;
    LocalDateTime borrowFrom;
    LocalDateTime borrowTill;

}