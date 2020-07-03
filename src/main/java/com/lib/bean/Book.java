package com.lib.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/27 18:15
 * 说明：
 **/
public class Book {
    Integer bid;
    String bname;
    String baddress;
    String bauthor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date bdate;
    Double bprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date bindate;
    Integer binnumber;
    Integer bnumber;

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", baddress='" + baddress + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bdate=" + bdate +
                ", bprice=" + bprice +
                ", bindate=" + bindate +
                ", binnumber=" + binnumber +
                ", bnumber=" + bnumber +
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

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Double getBprice() {
        return bprice;
    }

    public void setBprice(Double bprice) {
        this.bprice = bprice;
    }

    public Date getBindate() {
        return bindate;
    }

    public void setBindate(Date bindate) {
        this.bindate = bindate;
    }

    public Integer getBinnumber() {
        return binnumber;
    }

    public void setBinnumber(Integer binnumber) {
        this.binnumber = binnumber;
    }

    public Integer getBnumber() {
        return bnumber;
    }

    public void setBnumber(Integer bnumber) {
        this.bnumber = bnumber;
    }
}
