package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import java.util.Set;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class OverView {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String paragraph;
    @Column(columnDefinition = "TEXT")
    private String author;
    @Column(columnDefinition = "TEXT")
    private String img;
    public OverView() {
    }

    public OverView(int id, String paragraph, String author, String img) {
        this.id = id;
        this.paragraph = paragraph;
        this.author = author;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
