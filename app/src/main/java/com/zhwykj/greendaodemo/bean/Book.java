package com.zhwykj.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by gouplee on 2017/12/11.
 */

@Entity
public class Book {

    @Id
    private Long id;// 必须是Long，不能是long

    private String author;
    private double price;
    private int pages;
    private String name;

    @Generated(hash = 513841040)
    public Book(Long id, String author, double price, int pages, String name) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.name = name;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getPages() {
        return this.pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
