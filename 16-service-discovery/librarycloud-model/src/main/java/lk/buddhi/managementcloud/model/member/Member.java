package lk.buddhi.managementcloud.model.member;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String firstName;
    private String lastName;
    private String mNumber;
    private String zipcode;
    @OneToMany(mappedBy = "member")
    private List<Loyality> loyalities;


}