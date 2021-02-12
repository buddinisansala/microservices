package lk.buddhi.managementcloud.borrowservice.repository;

import lk.buddhi.managementcloud.model.borrow.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
