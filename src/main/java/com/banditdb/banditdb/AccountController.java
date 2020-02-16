package com.banditdb.banditdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/users/data/{id}/likes")
    public @ResponseBody
    Set<Integer> getLikes(@PathVariable Integer id) {
        return accountRepository.getOne(id).getLikes();
    }

    @GetMapping(path = "/users/data/{id}/dislikes")
    public @ResponseBody
    Set<Integer> getDislikes(@PathVariable Integer id) {
        return accountRepository.getOne(id).getDislikes();
    }

    @GetMapping(path = "/users/data/{id}/favourites")
    public @ResponseBody
    Set<Integer> getFavourites(@PathVariable Integer id) {
        return accountRepository.getOne(id).getFavourites();
    }

    @GetMapping(path = "/users/login/{username}/{password}")
    public @ResponseBody
    Boolean authenticate(@PathVariable String username, @PathVariable String password) {
        List<AccountData> accountData = accountRepository.findByusername(username);
        if (accountData.size() != 1)
            return false;
        else
            return accountData.get(0).getPassword().equals(password);
    }

    @PostMapping(path = "/users/register/{username}/{password}")
    public @ResponseBody
    Boolean register(@PathVariable String username, @PathVariable String password) {
        if (accountRepository.findByusername(username).size() != 0)
            return false;
        AccountData data = new AccountData();
        data.setPassword(password);
        data.setUsername(username);
        accountRepository.save(data);
        return true;
    }

    @PostMapping(path = "/users/data/{id}/likes/{postID}")
    public @ResponseBody
    void userLike(@PathVariable Integer id, @PathVariable Integer postID) {
        AccountData data = accountRepository.getOne(id);
        int change = 0;
        if (data.getLikes().contains(postID)) {
            data.getLikes().remove(postID);
            change = -1;
        }
        else {
            data.getLikes().add(postID);
            change = 1;
        }
        PostData postData = postRepository.getOne(postID);
        postData.setPostUpvote(postData.getPostUpvote() + change);
        postRepository.saveAndFlush(postData);
        accountRepository.saveAndFlush(data);
    }

    @PostMapping(path = "/users/data/{id}/Favourites/{postID}")
    public @ResponseBody
    void userFavourite(@PathVariable Integer id, @PathVariable Integer postID) {
        AccountData data = accountRepository.getOne(id);
        if (data.getFavourites().contains(postID))
            data.getFavourites().remove(postID);
        else
            data.getFavourites().add(postID);
        accountRepository.saveAndFlush(data);
    }

    @PostMapping(path = "/users/data/{id}/dislikes/{postID}")
    public @ResponseBody
    void userDislike(@PathVariable Integer id, @PathVariable Integer postID) {
        AccountData data = accountRepository.getOne(id);
        int change;
        if (data.getDislikes().contains(postID)) {
            data.getDislikes().remove(postID);
            change = -1;
        }
        else {
            data.getDislikes().add(postID);
            change = 1;
        }
        PostData postData = postRepository.getOne(postID);
        postData.setPost_downvote(postData.getPost_downvote() + change);
        postRepository.saveAndFlush(postData);
        accountRepository.saveAndFlush(data);
    }
}
