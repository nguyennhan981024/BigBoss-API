package com.example.APIBigboss.models;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code_order;
    private String userName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String district;
    private String ward;
    @Column(columnDefinition = "TEXT")
    private String note;
    private String option;
    private String user_register;
    private String email_register;
    private String create_at;
    @Column(columnDefinition = "TEXT")
    private String item_cart;
    private String status;
    private String total;
    private String status_buy;
    private String status_rent;

    public Orders() {
    }

    public Orders(int id, String code_order,String status_buy,String status_rent, String userName, String phoneNumber, String email, String address, String city, String district, String ward, String note, String option, String user_register, String email_register, String create_at, String item_cart, String status, String total) {
        this.id = id;
        this.code_order = code_order;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.note = note;
        this.option = option;
        this.user_register = user_register;
        this.email_register = email_register;
        this.create_at = create_at;
        this.item_cart = item_cart;
        this.status = status;
        this.total = total;
        this.status_buy = status_buy;
        this.status_rent = status_rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_order() {
        return code_order;
    }

    public void setCode_order(String code_order) {
        this.code_order = code_order;
    }

    public String getUserName() {
        return userName;
    }
    public String getStatusBuy(){
        return status_buy;
    }
    public String getStatusRent(){
        return status_rent;
    }
    public void setStatusBuy(String status_buy){
        this.status_buy = status_buy;
    }
    public void setStatusRent(String status_rent){
        this.status_rent = status_rent;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getUser_register() {
        return user_register;
    }

    public void setUser_register(String user_register) {
        this.user_register = user_register;
    }

    public String getEmail_register() {
        return email_register;
    }

    public void setEmail_register(String email_register) {
        this.email_register = email_register;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getItem_cart() {
        return item_cart;
    }

    public void setItem_cart(String item_cart) {
        this.item_cart = item_cart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
