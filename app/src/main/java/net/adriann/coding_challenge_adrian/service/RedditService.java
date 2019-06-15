package net.adriann.coding_challenge_adrian.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedditService {

    private static RedditService instance;
    private static String BASE_URL = "https://www.reddit.com/";
    private Retrofit retrofit;

    public static RedditService getInstance() {
        if (instance == null) {
            instance = new RedditService();
        }
        return instance;
    }

    private RedditService() {
        if (retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public RedditApi getRedditApi() {
        return retrofit.create(RedditApi.class);
    }

}
