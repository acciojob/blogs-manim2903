package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimensions;
    @ManyToOne
    @JoinColumn // if column is not mentioned pk of parent table is joined
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimension) {
        this.dimensions = dimension;
    }

    public Image(){}
    public Image(int id, String description, String dimension) {
        this.id = id;
        this.description = description;
        this.dimensions = dimension;
    }
}