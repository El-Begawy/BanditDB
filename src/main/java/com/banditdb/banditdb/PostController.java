package com.banditdb.banditdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/trending")
    public @ResponseBody Iterable<PostData> getTrending() {
        Iterator iterator = postRepository.findAll(Sort.by(Sort.Direction.DESC, "postUpvote")).iterator();
        ArrayList<PostData> trending = new ArrayList<>();
        while (trending.size() < 15 && iterator.hasNext()) {
            trending.add((PostData) iterator.next());
        }
        return trending;
    }

    @GetMapping(path = "/new")
    public @ResponseBody Iterable<PostData> getNew() {
        Iterator iterator = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).iterator();
        ArrayList<PostData> trending = new ArrayList<>();
        while (trending.size() < 15 && iterator.hasNext()) {
            trending.add((PostData) iterator.next());
        }
        return trending;
    }

    @GetMapping("/posts/{id}")
    public @ResponseBody
    PostData findPost(@PathVariable int id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

}