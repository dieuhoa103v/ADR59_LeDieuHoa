package vn.devpro.viewgroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.devpro.viewgroup.R;
import vn.devpro.viewgroup.models.User;

public class UserAdapterRCV extends RecyclerView.Adapter<UserAdapterRCV.ViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    public void setListener() {

    }
    private List<User> users;

    public UserAdapterRCV(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.avatar.setImageResource(user.getAvatar());
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView tvName;
        TextView tvEmail;


        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
