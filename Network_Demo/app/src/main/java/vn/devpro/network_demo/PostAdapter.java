package vn.devpro.network_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import vn.devpro.network_demo.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> posts;
    private int[] colorArray;

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (colorArray == null) {
            colorArray = parent.getContext().getResources().getIntArray(R.array.post_colors);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.postTitle.setText(post.getTitle());
        holder.postBody.setText(post.getBody());

        if (colorArray != null && colorArray.length > 0) {
            int color = colorArray[position % colorArray.length];
            holder.cardView.setCardBackgroundColor(color);
        }

    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size(): 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView postTitle, postBody;
        MaterialCardView cardView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postTitle = itemView.findViewById(R.id.postTitle);
            postBody = itemView.findViewById(R.id.postBody);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
