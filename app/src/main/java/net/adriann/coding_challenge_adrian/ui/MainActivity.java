package net.adriann.coding_challenge_adrian.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.adapter.RedditPostAdapter;
import net.adriann.coding_challenge_adrian.model.ARedditPost;
import net.adriann.coding_challenge_adrian.model.Child;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import net.adriann.coding_challenge_adrian.service.RedditService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    RedditPostAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(linearLayoutManager);
        callRedditEndpoint3();
    }

    public void callRedditEndpoint3() {
        RedditService.getInstance()
                .getRedditApi()
                .getAllPosts2()
                .enqueue(new Callback<ARedditPost>() {
                    @Override
                    public void onResponse(Call<ARedditPost> call, Response<ARedditPost> response) {

                        List<Child> postList = response.body().getData().getChildren();
                        setRecyclerWithAdapter(postList);
                        Toast.makeText(getApplicationContext(), "IT WORKED", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ARedditPost> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Aw geez! something has Failed, Rick", Toast.LENGTH_LONG).show();
                    }

                });
    }

    public void setRecyclerWithAdapter(List<Child> posts) {
        this.adapter = new RedditPostAdapter(posts);

        recycler.setAdapter(adapter);
    }

}
