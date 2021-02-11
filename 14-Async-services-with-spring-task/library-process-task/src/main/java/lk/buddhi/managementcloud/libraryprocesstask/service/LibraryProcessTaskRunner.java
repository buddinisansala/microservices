package lk.buddhi.managementcloud.libraryprocesstask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class LibraryProcessTaskRunner implements CommandLineRunner {

    @Autowired
    LibraryProcessService libraryProcessService;

    @Override
    public void run(String... args) throws Exception {
        if(args.length>0) {
            System.out.println("task running with arguments");

            if (libraryProcessService.validateMNumber(args[0])) {
                System.out.println("valid member number");
            } else
                System.out.println("invalid member number");
        }else
            System.out.println("task running without arguments");
    }
}
