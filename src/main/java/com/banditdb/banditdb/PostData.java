package com.banditdb.banditdb;

import javax.persistence.*;

@Entity
public class PostData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="post_id")
    private Integer id;
    @Column(name="post_upvote")
    private Integer postUpvote;
    private Integer post_downvote;

    private String post_album_name;
    private String post_song_name;
    private String post_song_dir;
    private String post_picture_dir;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost_album_name() {
        return post_album_name;
    }

    public void setPost_album_name(String post_album_name) {
        this.post_album_name = post_album_name;
    }

    public String getPost_song_name() {
        return post_song_name;
    }

    public void setPost_song_name(String post_song_name) {
        this.post_song_name = post_song_name;
    }

    public String getPost_song_dir() {
        return post_song_dir;
    }

    public void setPost_song_dir(String post_song_dir) {
        this.post_song_dir = post_song_dir;
    }

    public String getPost_picture_dir() {
        return post_picture_dir;
    }

    public void setPost_picture_dir(String post_picture_dir) {
        this.post_picture_dir = post_picture_dir;
    }

    public Integer getPost_downvote() {
        return post_downvote;
    }

    public void setPost_downvote(Integer post_downvote) {
        this.post_downvote = post_downvote;
    }

    public Integer getPostUpvote() {
        return postUpvote;
    }

    public void setPostUpvote(Integer postUpvote) {
        this.postUpvote = postUpvote;
    }
}
