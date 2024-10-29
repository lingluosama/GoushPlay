package com.rookie.webhomewrok.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("album")
public class AlbumTable {
    @Id(keyType = KeyType.Generator,value = KeyGenerators.snowFlakeId)
    private Integer id;
    private String  author;
    private String  description;
    private String  title;
    private String  cover;
    private Time    pub_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Time getPub_time() {
        return pub_time;
    }

    public void setPub_time(Time pub_time) {
        this.pub_time = pub_time;
    }
}
