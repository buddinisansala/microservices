package lk.buddhi.managementcloud.borrowservice.service;

import lk.buddhi.managementcloud.borrowservice.repository.BorrowRepository;
import lk.buddhi.managementcloud.model.book.Book;
import lk.buddhi.managementcloud.model.borrow.Borrow;
import lk.buddhi.managementcloud.borrowservice.model.DetailResponse;
import lk.buddhi.managementcloud.model.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    BorrowRepository borrowRepository;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Borrow save(Borrow member) {
        return borrowRepository.save(member);
    }


    @Override
    public Borrow findById(int id) {
        Optional<Borrow> borrow = borrowRepository.findById(id);

        if (borrow.isPresent())
            return borrow.get();
        else
            return new Borrow();

    }


    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) {


        Borrow borrow=findById(id);
        Member member=getMember(borrow.getMemberId());
        Book book= getBook(borrow.getBookId());

        return new DetailResponse(borrow,member,book);


    }

    private Member getMember(int memberId){

        Member member=restTemplate.getForObject("http://localhost:8080/services/members/"+memberId,Member.class);
        return member;

    }

    private Book getBook(int bookId){

        return restTemplate.getForObject("http://localhost:9191/services/books/"+bookId,Book.class);


    }
}
