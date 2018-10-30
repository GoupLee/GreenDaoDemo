package com.zhwykj.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by gouplee on 2017/12/12.
 */

@Entity
public class Category {

    @Id
    private Long id;

    private String category_name;
    private int category_code;
    @Generated(hash = 685509551)
    public Category(Long id, String category_name, int category_code) {
        this.id = id;
        this.category_name = category_name;
        this.category_code = category_code;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory_name() {
        return this.category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public int getCategory_code() {
        return this.category_code;
    }
    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }
}
