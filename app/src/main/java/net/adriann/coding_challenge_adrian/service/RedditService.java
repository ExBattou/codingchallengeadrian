package net.adriann.coding_challenge_adrian.service;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client;
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public RedditApi getRedditApi() {
        return retrofit.create(RedditApi.class);
    }

}
