package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import java.util.Set;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class ShopBanner {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String base64;
    @Column(columnDefinition = "TEXT")
    private String content;
    public ShopBanner() {
    }

    public ShopBanner(int id, String base64, String content) {
        this.id = id;
        this.base64 = base64;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
