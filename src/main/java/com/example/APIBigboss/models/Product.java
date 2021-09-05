package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String img;
    private String cate_name;
    @Column(columnDefinition = "TEXT")
    private String size;
    private String price;
    @Column(columnDefinition = "TEXT")
    private String list_img;
    private String to_rent;
    private String price_to_rent;
    private int cate_id;

    public Product() {
    }

    public Product(int id, String name, String status, String img, String cate_name, String size, String price, String list_img, String to_rent, String price_to_rent, int cate_id) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.img = img;
        this.cate_name = cate_name;
        this.size = size;
        this.price = price;
        this.list_img = list_img;
        this.to_rent = to_rent;
        this.price_to_rent = price_to_rent;
        this.cate_id = cate_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getList_img() {
        return list_img;
    }

    public void setList_img(String list_img) {
        this.list_img = list_img;
    }

    public String getTo_rent() {
        return to_rent;
    }

    public void setTo_rent(String to_rent) {
        this.to_rent = to_rent;
    }

    public String getPrice_to_rent() {
        return price_to_rent;
    }

    public void setPrice_to_rent(String price_to_rent) {
        this.price_to_rent = price_to_rent;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }
}
