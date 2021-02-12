package lk.buddhi.managementcloud.borrowservice.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand;
import lk.buddhi.managementcloud.borrowservice.hystrix.BookCommand;
import lk.buddhi.managementcloud.borrowservice.hystrix.CommonHysctrixCommand;
import lk.buddhi.managementcloud.borrowservice.repository.BorrowRepository;
import lk.buddhi.managementcloud.model.book.Book;
import lk.buddhi.managementcloud.model.borrow.Borrow;
import lk.buddhi.managementcloud.borrowservice.model.DetailResponse;
import lk.buddhi.managementcloud.model.member.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    HystrixCommand.Setter setter;

    @LoadBalanced
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
    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException {


        Borrow borrow = findById(id);
        Member member = getMember(borrow.getMemberId());
        Book book = getBook(borrow.getBookId());

        return new DetailResponse(borrow,member,book);


    }

    private Member getMember(int memberId) throws ExecutionException, InterruptedException{

        CommonHysctrixCommand<Member> memberCommonHysctrixCommand=new CommonHysctrixCommand<Member>(setter,()->
        {
            return restTemplate.getForObject("http://member/services/members/"+memberId,Member.class);
        },()->{
            return new Member();
        });

        Future<Member> memberFuture=memberCommonHysctrixCommand.queue();
        return memberFuture.get();

    }

    private Book getBook(int bookId){

        BookCommand bookCommand = new BookCommand(restTemplate,bookId);
        return bookCommand.execute();
        //return restTemplate.getForObject("http://book/services/books/"+bookId,Book.class);


    }
}
