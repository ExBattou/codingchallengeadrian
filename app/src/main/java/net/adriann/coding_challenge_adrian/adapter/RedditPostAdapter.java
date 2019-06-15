package net.adriann.coding_challenge_adrian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import net.adriann.coding_challenge_adrian.R;
import net.adriann.coding_challenge_adrian.model.Child;
import net.adriann.coding_challenge_adrian.model.PostFromReddit;
import net.adriann.coding_challenge_adrian.viewholder.PostViewHolder;

import java.util.List;

public class RedditPostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Child> postList;

    public RedditPostAdapter (List<Child> posts) {
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
        Child post = postList.get(position);
        String author = post.getData().getAuthor();

        TextView author_text = holder.author;
        author_text.setText(author);

        TextView commentNumberText = holder.commentNumber;
        commentNumberText.setText(post.getData().getNumComments());
//        holder.commentNumber.setText(post.getData().getNumComments());
//        holder.readstatus.setActivated(false);
//        holder.title.setText(post.getData().getTitle());
//        getImageFromUrl(post.getData().getThumbnail(),holder.thumbnail);

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
        return postList.size();
    }
}
