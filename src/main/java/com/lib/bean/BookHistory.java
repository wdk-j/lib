package com.lib.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 作者：         王大可
 * 创建日期：     2020/7/5 15:34
 * 说明：
 **/
public class BookHistory {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date truedate;
    Double fine;

    public BookHistory() {
    }

    public BookHistory(BookBorrowing bookBorrowing, Double fine) {
        this.bid = bookBorrowing.bid;
        this.bname = bookBorrowing.bname;
        this.uid = bookBorrowing.uid;
        this.username = bookBorrowing.username;
        this.name = bookBorrowing.name;
        this.startdate = bookBorrowing.startdate;
        this.enddate = bookBorrowing.enddate;
        this.truedate = new Date();
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "BookHistory{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", truedate=" + truedate +
                ", fine=" + fine +
                '}';
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
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

    public Date getTruedate() {
        return truedate;
    }

    public void setTruedate(Date truedate) {
        this.truedate = truedate;
    }
}
