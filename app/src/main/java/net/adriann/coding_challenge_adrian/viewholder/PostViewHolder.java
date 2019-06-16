package net.adriann.coding_challenge_adrian.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import net.adriann.coding_challenge_adrian.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    @BindView(R.id.title_view)
    public TextView title;
    @BindView(R.id.author)
    public TextView author;
    @BindView(R.id.x_time_agor)
    public TextView time_ago;
    @BindView(R.id.comment_number)
    public TextView commentNumber;
    @BindView(R.id.readstatus)
    public CheckBox readstatus;
    @BindView(R.id.thumb)
    public ImageView thumbnail;
    @BindView(R.id.container)
    public ConstraintLayout container;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         readstatus.setActivated(true);
    }



    
}
