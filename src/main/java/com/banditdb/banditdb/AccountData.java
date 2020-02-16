package com.banditdb.banditdb;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AccountData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name ="Likes")
    private Set<Integer> Likes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name ="dislikes")
    private Set<Integer> dislikes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name ="favourites")
    private Set<Integer> favourites = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Integer> getLikes() {
        return Likes;
    }

    public void setLikes(Set<Integer> likes) {
        Likes = likes;
    }

    public Set<Integer> getDislikes() {
        return dislikes;
    }

    public void setDislikes(Set<Integer> dislikes) {
        this.dislikes = dislikes;
    }

    public Set<Integer> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Integer> favourites) {
        this.favourites = favourites;
    }
}
