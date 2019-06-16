package net.adriann.coding_challenge_adrian.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.adapter.RedditPostAdapter;
import net.adriann.coding_challenge_adrian.model.ARedditPost;
import net.adriann.coding_challenge_adrian.model.Child;
import net.adriann.coding_challenge_adrian.service.RedditService;

import java.util.List;

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
