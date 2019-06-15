package net.adriann.coding_challenge_adrian.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import net.adriann.coding_challenge_adrian.service.RedditService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void callRedditEndpoint() { //was going to add a presenter, but it was a drag just to get a Json.
        RedditService.getInstance().getRedditApi().getTopPosts().enqueue(new Callback<ArrayList<PostFromReddit>>() {

            @Override
            public void onResponse(Call<ArrayList<PostFromReddit>> call, Response<ArrayList<PostFromReddit>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<PostFromReddit>> call, Throwable t) {

            }
        });
    }

}
