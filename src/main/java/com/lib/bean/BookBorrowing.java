package com.lib.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * 作者：         王大可
 * 创建日期：     2020/7/5 13:52
 * 说明：
 **/
public class BookBorrowing {
    Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    Integer bid;
    String bname;
    Integer uid;
    String username;
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date startdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date enddate;

    public BookBorrowing() {
    }

    public BookBorrowing(User user, Book book) {
        this.bid = book.bid;
        this.bname = book.bname;
        this.uid = user.uid;
        this.username = user.username;
        this.name = user.name;
        Date date = new Date();
        this.startdate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        date = calendar.getTime();
        this.enddate = date;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "number=" + number +
                ", bid=" + bid +
                ", bname='" + bname + '\'' +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}
