package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import java.util.Set;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Material {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    private int cate_id;
    @Column(columnDefinition = "TEXT")
    private String describe;
    @Column(columnDefinition = "TEXT")
    private String base64;
    public Material() {
    }

    public Material(int id, String name, int cate_id, String describe, String base64) {
        this.id = id;
        this.name = name;
        this.cate_id = cate_id;
        this.describe = describe;
        this.base64 = base64;
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

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
