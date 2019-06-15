package net.adriann.coding_challenge_adrian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import net.adriann.coding_challenge_adrian.viewholder.PostViewHolder;

import java.util.ArrayList;

public class RedditPostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    ArrayList<PostFromReddit> postList;

    public RedditPostAdapter (ArrayList<PostFromReddit> posts) {
        this.postList = posts;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_view_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostFromReddit post = postList.get(position);
        holder.author.setText(post.getAuthor());
        holder.commentNumber.setText(post.getCommentsQuantity());
        holder.readstatus.setActivated(false);
        holder.title.setText(post.getTitle());
        getImageFromUrl(post.getThumbnailUrl(),holder.thumbnail);

    }

    private void getImageFromUrl(String url, ImageView view) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.colorPrimary)
                .error(android.R.color.white);

        Glide.with(context).load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(options).into(view);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
