package lk.buddhi.managementcloud.borrowservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.buddhi.managementcloud.model.book.Book;
import org.springframework.web.client.RestTemplate;

public class BookCommand extends HystrixCommand<Book> {


    RestTemplate restTemplate;
    int bookId;

    public BookCommand(RestTemplate restTemplate, int bookId){

        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate=restTemplate;
        this.bookId=bookId;
    }

    @Override
    protected Book run() throws Exception {
        return restTemplate.getForObject("http://book/services/books/"+bookId,Book.class);
    }

    @Override
    protected Book getFallback() {
        System.out.println("hit on fallback");
        return new Book();
    }
}