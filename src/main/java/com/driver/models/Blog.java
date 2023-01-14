package com.driver.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;

@Entity
@Table
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Data pubDate;
    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> imageList;

    public Blog(){}
    public Blog(int id, String title, String content, Data pubDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getPubDate() {
        return pubDate;
    }

    public void setPubDate(Data pubDate) {
        this.pubDate = pubDate;
    }
}