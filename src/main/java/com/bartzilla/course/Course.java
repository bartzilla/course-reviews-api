package com.bartzilla.course;

import com.bartzilla.core.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Course extends BaseEntity {

    private String title;
    private String url;

    protected Course() {
        super();
    }

    public Course(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}