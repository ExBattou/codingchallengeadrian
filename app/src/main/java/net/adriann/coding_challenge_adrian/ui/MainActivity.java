package net.adriann.coding_challenge_adrian.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.adapter.RedditPostAdapter;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import net.adriann.coding_challenge_adrian.service.RedditService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    RedditPostAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        callRedditEndpoint2();
    }


    public void callRedditEndpoint() { //was going to add a presenter, but it was a drag just to get a Json.
        RedditService.getInstance().getRedditApi().getTopPosts().enqueue(new Callback<ArrayList<PostFromReddit>>() {

            @Override
            public void onResponse(Call<ArrayList<PostFromReddit>> call, Response<ArrayList<PostFromReddit>> response) {
                setRecyclerWithAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostFromReddit>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Aw geez! something has Failed, Rick", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void callRedditEndpoint2() {
        RedditService.getInstance()
                .getRedditApi()
                .getAllPosts()
                .enqueue(new Callback<ArrayList<PostFromReddit>>() {
                    @Override
                    public void onResponse(Call<ArrayList<PostFromReddit>> call, Response<ArrayList<PostFromReddit>> response) {
                        ArrayList<PostFromReddit> toSend = response.body();
                        setRecyclerWithAdapter(toSend);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<PostFromReddit>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Aw geez! something has Failed, Rick", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void setRecyclerWithAdapter(ArrayList<PostFromReddit> posts) {
        this.adapter = new RedditPostAdapter(posts);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recycler.refreshDrawableState();
    }

}
