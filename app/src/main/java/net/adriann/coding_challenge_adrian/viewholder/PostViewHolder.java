package net.adriann.coding_challenge_adrian.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.adriann.coding_challenge_adrian.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.title_view)
    TextView title;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.x_time_agor)
    TextView time_ago;
    @BindView(R.id.comment_number)
    TextView commentNumber;
    //@BindView(R.id.readstatus)
    CheckBox readstatus;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    
}
