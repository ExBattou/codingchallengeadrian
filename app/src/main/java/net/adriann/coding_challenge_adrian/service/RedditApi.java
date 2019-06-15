package net.adriann.coding_challenge_adrian.service;

import net.adriann.coding_challenge_adrian.model.ARedditPost;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RedditApi {

    @GET("top.json?limit=50")
    public Call<ARedditPost> getAllPosts2();
}
