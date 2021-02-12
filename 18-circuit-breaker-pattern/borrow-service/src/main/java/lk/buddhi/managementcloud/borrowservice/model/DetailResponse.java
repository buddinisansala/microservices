package lk.buddhi.managementcloud.borrowservice.model;

import lk.buddhi.managementcloud.model.book.Book;
import lk.buddhi.managementcloud.model.borrow.Borrow;
import lk.buddhi.managementcloud.model.member.Member;

public class DetailResponse implements Response{

    Borrow borrow;
    Member member;
    Book book;

    public DetailResponse(Borrow borrow, Member member, Book book) {
        this.borrow = borrow;
        this.member = member;
        this.book = book;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
