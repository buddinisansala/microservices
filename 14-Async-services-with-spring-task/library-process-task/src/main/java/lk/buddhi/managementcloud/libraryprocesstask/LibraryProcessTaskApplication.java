package lk.buddhi.managementcloud.libraryprocesstask;

import lk.buddhi.managementcloud.libraryprocesstask.service.LibraryProcessTaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class LibraryProcessTaskApplication {

	@Bean
	LibraryProcessTaskRunner getLibryProcessTaskRunner() {
		return new LibraryProcessTaskRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryProcessTaskApplication.class, args);
	}

}
