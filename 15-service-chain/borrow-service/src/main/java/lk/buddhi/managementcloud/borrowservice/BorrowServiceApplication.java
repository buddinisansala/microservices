package lk.buddhi.managementcloud.borrowservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "lk.buddhi.managementcloud.model.borrow")
public class BorrowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowServiceApplication.class, args);
	}

}
