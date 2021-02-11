package lk.buddhi.managementcloud.libraryprocesstask.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryProcessServiceImpl implements LibraryProcessService {

    @Override
    public boolean validateMNumber(String mNumber) {
        return mNumber.length() > 3;
    }
}
