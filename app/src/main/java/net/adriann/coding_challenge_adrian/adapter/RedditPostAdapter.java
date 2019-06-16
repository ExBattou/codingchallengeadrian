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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_view_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Child post = postList.get(position);
        String author = post.getData().getAuthor();
        String commmentNumber = post.getData().getNumComments().toString();
        String howmuchtimeago = post.getData().getCreated().toString();

        TextView author_text = holder.author;
        author_text.setText(author);

        TextView commentNumberText = holder.commentNumber;
        commentNumberText.setText(commmentNumber);

        holder.title.setText(post.getData().getTitle());
        holder.time_ago.setText(post.getData().getCreated().toString());
        holder.author.setText(post.getData().getAuthor());
        holder.commentNumber.setText(post.getData().getNumComments().toString());
        getImageFromUrl(post.getData().getThumbnail(),holder.thumbnail);

    }

    private void getImageFromUrl(String url, ImageView view) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.colorPrimaryDark)
                .centerCrop()
                .error(android.R.color.darker_gray);

        Glide.with(context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(options)
                .into(view);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
