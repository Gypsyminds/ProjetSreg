package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.Repositery.PostsRepository;
import com.bezkoder.springjwt.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotsService implements IPost {
    @Autowired
    PostsRepository postRepository;


    @Override
    public Posts addQcm(Posts s) {

        return postRepository.save(s);
    }


}


