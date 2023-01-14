package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimension;
    @ManyToOne
    @JoinColumn
    private Blog blog;

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Image(){}
    public Image(int id, String description, String dimension) {
        this.id = id;
        this.description = description;
        this.dimension = dimension;
    }
}