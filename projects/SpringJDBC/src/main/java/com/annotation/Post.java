package com.annotation;

import java.util.Date;

public class Post {
    private Integer id;
    private String title;
    private Date created;
    private Date lastChanged;
    private String content;
    // TODO пока хранится как строка, нужно хранить в отдельной таблице
    private String tags;

    public Post() { }

    public Post(Integer id, String title, Date created, Date lastChanged, String content, String tags) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.lastChanged = lastChanged;
        this.content = content;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", created=" + created + ", lastChanged=" + lastChanged
                + ", content=" + content + ", tags=" + tags + "]";
    }


}
