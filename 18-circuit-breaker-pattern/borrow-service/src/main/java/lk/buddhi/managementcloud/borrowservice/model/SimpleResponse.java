package lk.buddhi.managementcloud.borrowservice.model;

import lk.buddhi.managementcloud.model.borrow.Borrow;

public class SimpleResponse implements Response{

    Borrow borrow;


    public SimpleResponse(Borrow borrow) {
        this.borrow = borrow;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
}
