package lk.buddhi.managementcloud.borrowservice.service;

import lk.buddhi.managementcloud.borrowservice.model.DetailResponse;
import lk.buddhi.managementcloud.model.borrow.Borrow;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BorrowService {

    Borrow save(Borrow borrow);

    Borrow findById(int id);

    List<Borrow> findAll();

    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}
