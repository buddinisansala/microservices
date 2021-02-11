package lk.buddhi.managementcloud.borrowservice.controller;

import lk.buddhi.managementcloud.borrowservice.model.Response;
import lk.buddhi.managementcloud.borrowservice.model.SimpleResponse;
import lk.buddhi.managementcloud.borrowservice.service.BorrowService;
import lk.buddhi.managementcloud.model.borrow.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services/borrows")
public class BorrowController {


    @Autowired
    BorrowService borrowService;

    @PostMapping
    public Borrow save(@RequestBody Borrow borrow) {
        return borrowService.save(borrow);
    }

    @GetMapping(value = "/{id}")
    public Response getRent(@PathVariable int id, @RequestParam(required = false) String type) {

        if(type==null){
            return  new SimpleResponse(borrowService.findById(id));
        }else{
            return    borrowService.findDetailResponse(id);
        }



    }

    @GetMapping
    public List<Borrow> getAllRents() {
        return borrowService.findAll();
    }


}
